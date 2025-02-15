# 🚗 Your Car Your Way - Proof of Concept (POC)   ![Your Car Your Way Logo](/P13-chat-frontend/src/assets/images/p13_logo.PNG)



## ✨ Introduction :

Bienvenue dans le projet **Your Car Your Way** ! Ce POC a pour objectif de démontrer la faisabilité de l'application en mettant l'accent sur la fonctionnalité de **chat en ligne** entre les clients et les agents du service client.

L'application vise à centraliser les opérations de location de voiture tout en offrant une expérience utilisateur fluide et intuitive.

### **Ce POC inclut les fonctionnalités clés suivantes :**

- Chat en ligne en temps réel (via WebSocket).

---

## 🛠️ Prérequis

### **Backend (Spring Boot)**
- **Java** : Version 17 ou supérieure.
- **Spring Boot** ( JAVA) , architecture microservice
- **Maven** : Pour gérer les dépendances.
- **H2** : Pour le stockage des messages de chat.

### **Frontend (Angular)**
- **Node.js** : Version 18 ou supérieure.
- **npm** : Gestionnaire de paquets pour Angular.
- **Angular17** :  TypeScript, Angular Material , architecture modulaire.
 
### **API Gateway**
- Point d'entrée unique qui centralise, sécurise et distribue les requêtes des clients vers les différents microservices, optimisant ainsi la communication et la gestion des accès.

### **Services externes**
- **Stripe** pour les paiements.
- **WebRTC** pour la vidéo-assistance.


---

## 📂 Architecture

### Architecture basée sur les microservices pour une scalabilité accrue.

- **Frontend** : Angular 17, TypeScript, Angular Material.
- **Backend** : Spring Boot Java 3 avec microservices dédiés.
- **API Gateway** : Sécurisation et distribution des requêtes.
- **Bases de données** : MySQL (relationnel) et MongoDB (NoSQL pour le chat).
- **Interopérabilité avec services tiers** : Stripe pour les paiements, WebRTC pour l'assistance vidéo.

## 📋 Fonctionnalités POC

Chat en ligne avec un agent.
Réponses en temps réel via le chat.

---

## 🔧 Configuration des Propriétés Backend

Ajoutez les paramètres suivants dans application.properties ( ou passer par un fichier database.properties à inclure dans votre projet Spring Boot) :


### Dans application.properties

```
#Vous pouvez parametrer un port spécifique si vous n'utiliser pas celui par defaut.
server.port=3555

spring.datasource.url=jdbc:h2:file:./data/bdd_p13_yourcaryourway
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=user
spring.datasource.password=password
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
logging.level.org.hibernate.SQL=DEBUG
```
---

## Lancement :


### 📦 Clonage du Projet
```
git clone urlprojet 
```

### 🛢️ Initialisation de la Base de Données

L'application utilise une base de données H2 pour stocker les messages de chat. 
Vous pouvez accéder à la console H2 en ouvrant le lien suivant dans votre navigateur :

```
http://localhost:3555/h2-console
```
Remplissez les champs de connexion comme suit :

```
JDBC URL : jdbc:h2:file:./data/bdd_p13_yourcaryourway
User Name : user
Password : password
```

La base de donnée au lancement de l'application se charge automatiquement avec des données de test à partir du fichier :

```
data.sql 
```

Pour que Spring Boot NE charge PAS les données de test, décommentée les ligne 18 et 19 suivante dans application.properties 

```
#spring.sql.init.mode=always
#spring.sql.init.data-locations=classpath:data.sql
```


### 🚀 Lancement de l'Application Spring Boot (Backend)

Lancez l'application Spring Boot à l'aide de Maven :
```
mvn spring-boot:run
```

### 🏃‍♂️ Lancement de l'Application Angular (Frontend)

Installez les dépendances nécessaires :

```
npm install
```
Lancez l'application Angular :

```
ng serve
```
Ouvrez l'application dans votre navigateur :

```
http://localhost:4200/
```

### 🚪 Lancement avec Docker si docker est installer sur votre machine :

``` 
docker-compose up
```
Ensuite rendez vous sur le navigateur à l'adresse suivante : 

``` 
http://localhost:4200/
```

Si docker n'est pas installer sur votre machine, vous pouvez l'installer en suivant les instructions sur le site officiel de docker : 

``` 
https://docs.docker.com/get-docker/
```

## 📂 Documentation Supplémentaire

Les documents complémentaires sont disponibles dans le dossier `docs` du projet.


## 🎯 Objectif

Ce POC vise à démontrer la faisabilité de la fonctionnalité Chat de l'application. Si vous avez des retours ou des suggestions, n'hésitez pas à me les partager ! 😊
