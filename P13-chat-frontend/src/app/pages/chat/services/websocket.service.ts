import { Injectable, NgZone } from '@angular/core';
import { io, Socket } from 'socket.io-client';

@Injectable({
  providedIn: 'root',
})
export class WebSocketService {
  public socket: Socket | undefined;

  // URL WebSocket fixe pour le VPS
  private SERVER_URL = 'https://poc.cortek.fr';

  constructor(private ngZone: NgZone) {}

  /**
   * Initialise la connexion WebSocket
   */
  initializeWebSocketConnection(): void {
    this.ngZone.runOutsideAngular(() => {
      if (this.socket && this.socket.connected) {
        console.warn('WebSocket déjà connecté');
        return;
      }

      this.socket = io(this.SERVER_URL, {
        transports: ['websocket'], // Forcer uniquement WebSocket
        reconnectionAttempts: 10, // Nombre de tentatives de reconnexion
        timeout: 20000, // Timeout pour la connexion initiale
      });

      this.socket.on('connect', () => {
        console.log('✅ Connecté au serveur WebSocket:', this.SERVER_URL);
      });

      this.socket.on('disconnect', (reason: string) => {
        console.warn('❌ Déconnecté du serveur WebSocket:', reason);
        // Tentative de reconnexion après 3 secondes
        setTimeout(() => this.reconnect(), 3000);
      });

      this.socket.on('connect_error', (error: any) => {
        console.error('⚠️ Erreur de connexion WebSocket:', error);
      });
    });
  }

  /**
   * Reconnecte le WebSocket si la connexion est perdue
   */
  private reconnect(): void {
    if (!this.socket || !this.socket.connected) {
      console.log('������ Tentative de reconnexion...');
      this.initializeWebSocketConnection();
    }
  }

  /**
   * Envoie un message via WebSocket
   */
  sendMessage(message: { sender: string; content: string }): void {
    if (this.socket && this.socket.connected) {
      this.socket.emit('sendMessage', message);
      console.log('������ Message envoyé:', message);
    } else {
      console.warn('⚠️ Impossible d\'envoyer le message, WebSocket non connecté.');
    }
  }

  /**
   * Déconnecte proprement le WebSocket
   */
  disconnect(): void {
    if (this.socket) {
      this.socket.disconnect();
      this.socket = undefined;
      console.log('❎ WebSocket déconnecté manuellement.');
    }
  }
}
