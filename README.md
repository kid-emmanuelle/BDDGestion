# BDDGestion - Projet MongoDB avec Spring Boot

## Prérequis

- Docker Desktop
- Java 17 ou supérieur
- Maven (ou utiliser ./mvnw)
- IntelliJ IDEA (recommandé)

## Installation et Configuration

### 1. Cloner le projet

```bash
git clone [URL_DU_PROJET]
cd [NOM_DU_PROJET]
```

### 2. Configuration MongoDB

Démarrer les conteneurs Docker

```bash
docker-compose up -d
```

**Note**: Assurez-vous que le réseau `mongonetwork` est correctement configuré dans votre `docker-compose.yml`.

Initialiser le Config Server

```bash
docker exec -it configsvr mongosh --port 27021

# Dans le shell mongo
rs.initiate({
  _id: "configRS",
  configsvr: true,
  members: [{ _id: 0, host: "configsvr:27021" }]
})
```

Initialiser le ReplicaSet

```bash
docker exec -it mongo1 mongosh --port 27017

# Dans le shell mongo
rs.initiate({
  _id: "rs0",
  members: [
    { _id: 0, host: "mongo1:27017" },
    { _id: 1, host: "mongo2:27018" },
    { _id: 2, host: "mongo3:27019" }
  ]
})
```

Configurer le Router et l'Authentification

```bash
docker exec -it mongos mongosh --port 27020

# Dans le shell mongo
sh.addShard("rs0/mongo1:27017,mongo2:27018,mongo3:27019")

use admin
db.createUser({
  user: "admin",
  pwd: "password123",
  roles: [ { role: "userAdminAnyDatabase", db: "admin" } ]
})

# Activer le sharding pour la base de données
use bddgestion
sh.enableSharding("bddgestion")
```

### 3. Configuration de l'Application

Le fichier `application.properties` est déjà configuré avec :

```properties
spring.data.mongodb.uri=mongodb://admin:password123@localhost:27020/bddgestion?authSource=admin
```

Vous pouvez utiliser cette URL pour vous connecter à la base de données.

### Insertion de Données

Vous devez insérer des données dans la base de données pour tester l'application. Vous pouvez le faire de deux manières :

- 1ère méthode : Utilisez le script fourni `bddgestion_import.js` pour insérer des données dans la base de données.

- 2ème méthode : Utilisez les fichiers CSV fournis pour insérer des données dans la base de données.

### Remarques supplémentaires

- Assurez-vous que votre version de Docker est à jour pour éviter des problèmes de compatibilité.
- Vérifiez que les ports spécifiés dans `docker-compose.yml` ne sont pas utilisés par d'autres services sur votre machine.

