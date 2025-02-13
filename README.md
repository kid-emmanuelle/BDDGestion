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
Le fichier application.properties est déjà configuré avec :
```properties
spring.data.mongodb.uri=mongodb://admin:password123@localhost:27020/bddgestion?authSource=admin
```

### Exemple d'Insertion de Données
```bash
use bddgestion

// Insérer des groupes
db.groupes.insertMany([
  {
    numero: "G1",
    nom: "Groupe Paris",
    ville: "Paris",
    codePostal: "75001"
  },
  {
    numero: "G2",
    nom: "Groupe Lyon",
    ville: "Lyon",
    codePostal: "69001"
  }
])

// Insérer des membres
db.membres.insertMany([
  {
    nom: "Dupont",
    prenom: "Jean",
    numeroRue: "12",
    rue: "Rue de la Paix",
    ville: "Paris",
    codePostal: "75001",
    email: "jean.dupont@email.com",
    type: "ACTIF",
    numeroGroupe: "G1"
  },
  {
    nom: "Martin",
    prenom: "Marie",
    numeroRue: "45",
    rue: "Avenue des Champs",
    ville: "Paris",
    codePostal: "75008",
    email: "marie.martin@email.com",
    type: "CLIENT",
    numeroGroupe: "G1"
  }
])

// Insérer du matériel
db.materiels.insertMany([
  {
    numeroSerie: "ECR001",
    marque: "Dell",
    modele: "P2419H",
    type: "ECRAN",
    prix: 149.99,
    numeroGroupe: "G1"
  },
  {
    numeroSerie: "PC001",
    marque: "HP",
    modele: "EliteBook",
    type: "LAPTOP",
    prix: 599.99,
    numeroGroupe: "G2"
  }
])
```
