import { ChangeDetectorRef, Component, NgZone, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { WebSocketService } from './services/websocket.service';
import {MessageService} from "./services/message.service";

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss'],
})
export class ChatComponent {
  // Liste des messages affichés dans le chat, chaque message contient un expéditeur et un contenu.
  messages: { sender: string; content: string }[] = [];

  // Contenu du message actuellement écrit par l'utilisateur.
  messageContent: string = '';

  // Nom de l'expéditeur des messages (ici, le client).
  sender: string = 'Client';

  constructor(
    private webSocketService: WebSocketService, // Service gérant les communications WebSocket.
    private ngZone: NgZone,// Service Angular pour gérer les exécutions en dehors de la zone Angular.
    private messageService: MessageService // Service pour récupérer les messages
  ) {}

  // Méthode appelée lors de l'initialisation du composant.
  ngOnInit(): void {
    // Si une connexion WebSocket existe déjà, on la déconnecte pour réinitialiser.
    if (this.webSocketService.socket?.connected) {
      this.webSocketService.disconnect();
    }

    // Initialisation de la connexion WebSocket.
    this.webSocketService.initializeWebSocketConnection();

    // Gestionnaire d'événement pour la connexion établie.
    this.webSocketService.socket?.on('connect', () => {
      console.log('WebSocket connection established'); // Confirmation dans la console.
    });

    // Gestionnaire d'événement pour les messages entrants.
    this.webSocketService.socket?.on('chatMessage', (message: any) => {
      // On utilise NgZone pour informer Angular du changement et forcer la mise à jour de la vue.
      this.ngZone.run(() => {
        this.messages.push(message); // Ajout du message à la liste des messages.
        console.log('Message added to list inside Angular zone:', message);
      });
    });

    // Gestionnaire d'événement pour les erreurs de connexion.
    this.webSocketService.socket?.on('connect_error', (error: any) => {
      console.error('Failed to connect to WebSocket server:', error); // Affichage de l'erreur.
    });
    this.messageService.getMessages().subscribe((messages) => {
      this.messages = messages;
      // console.log('Messages:', messages);
    });
  }

  // Méthode pour envoyer un message via WebSocket.
  sendMessage(): void {
    // Création de l'objet message avec l'expéditeur et le contenu.
    const message = { sender: this.sender, content: this.messageContent };

    // Envoi du message via le service WebSocket.
    this.webSocketService.sendMessage(message);

    // Réinitialisation du contenu du champ de saisie du message.
    this.messageContent = '';
  }

  // Méthode appelée lors de la destruction du composant (nettoyage).
  ngOnDestroy(): void {
    // Suppression des gestionnaires d'événements pour éviter les fuites mémoire.
    this.webSocketService.socket?.off('chatMessage');

    // Déconnexion du WebSocket.
    this.webSocketService.disconnect();
  }
}
