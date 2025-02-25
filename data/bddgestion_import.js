use bddgestion;

// Insérer des groupes
db.groupes.insertMany([
    {
        numero: "G1",
        nom: "Groupe Paris 1",
        ville: "Paris",
        codePostal: 75001
    },
    {
        numero: "G2",
        nom: "Groupe Lyon 2",
        ville: "Lyon",
        codePostal: 69001
    },
    {
        numero: "G3",
        nom: "Groupe Paris 3",
        ville: "Paris",
        codePostal: 75001
    },
    {
        numero: "G4",
        nom: "Groupe Poker Lyon",
        ville: "Lyon",
        codePostal: 69001
    },
    {
        _id: ObjectId("67bd913bf01e7517985ecfa4"),
        numero: "G5",
        nom: "Groupe de Basket M1",
        ville: "Marseille",
        codePostal: 13001
    },
    {
        numero: "G6",
        nom: "Groupe Basket Valenciennes",
        ville: "Valenciennes",
        codePostal: 59300
    },
    {
        numero: "G7",
        nom: "Groupe Poker Lille",
        ville: "Lille",
        codePostal: 59000
    }
]);

// Insérer des membres
db.membres.insertMany([
    {
        nom: "Martin",
        prenom: "Marie",
        numeroRue: 45,
        rue: "Avenue des Champs",
        ville: "Paris",
        codePostal: 75008,
        email: "marie.martin@email.com",
        type: "CLIENT",
        numeroGroupe: "G1",
        password: "123456789"
    },
    {
        nom: "Dupont",
        prenom: "Jean",
        numeroRue: 12,
        rue: "Rue de la Paix",
        ville: "Paris",
        codePostal: 75001,
        email: "jean.dupont@email.com",
        type: "ACTIF",
        numeroGroupe: "G1",
        password: "123456789"
    },
    {
        nom: "Potter",
        prenom: "Harry",
        numeroRue: 45,
        rue: "Rue Nuggeser",
        ville: "Lille",
        codePostal: 59300,
        email: "harry.potter@gmail.com",
        type: "CLIENT",
        numeroGroupe: "G7",
        password: "123456789"
    },
    {
        nom: "Waston",
        prenom: "Emma",
        numeroRue: 34,
        rue: "Chemin Vert",
        ville: "Valenciennes",
        codePostal: 59300,
        email: "emma.waston@gmail.com",
        type: "ACTIF",
        numeroGroupe: "G6",
        password: "123456789"
    },
    {
        nom: "Weasly",
        prenom: "Ron",
        numeroRue: 99,
        rue: "Avenue de Champs Elysee",
        ville: "Lyon",
        codePostal: 69001,
        email: "ron.weasly@gmail.com",
        type: "CLIENT",
        numeroGroupe: "G4",
        password: "123456789"
    },
    {
        nom: "Waston",
        prenom: "Sharon",
        numeroRue: 77,
        rue: "Boulevard de Paris",
        ville: "Lille",
        codePostal: 59000,
        email: "sharon.waston@gmail.com",
        type: "ACTIF",
        numeroGroupe: "G7",
        password: "123456789"
    }
]);

// Insérer du matériel
db.materiels.insertMany([
    {
        numeroSerie: "PC001",
        marque: "HP",
        modele: "EliteBook",
        type: "LAPTOP",
        prix: 599.99,
        numeroGroupe: "G2"
    },
    {
        numeroSerie: "ECR001",
        marque: "Dell",
        modele: "P2419H",
        type: "ECRAN",
        prix: 149.99,
        numeroGroupe: "G1"
    },
    {
        numeroSerie: "ECR001",
        marque: "Dell",
        modele: "D4589K",
        type: "ECRAN",
        prix: 179.99,
        numeroGroupe: "G6"
    },
    {
        numeroSerie: "MXT758",
        marque: "Canon",
        modele: "MX",
        type: "AUTRE",
        prix: 899.99,
        numeroGroupe: "G6"
    },
    {
        numeroSerie: "R4000",
        marque: "AMD",
        modele: "Ryzen 5",
        type: "AUTRE",
        prix: 349.99,
        numeroGroupe: "G3"
    },
    {
        numeroSerie: "ACC12345",
        marque: "Logitech",
        modele: "MX Master 3",
        type: "SOURIS",
        prix: 99.99,
        numeroGroupe: "G7"
    },
    {
        numeroSerie: "ACC67890",
        marque: "Corsair",
        modele: "K70 RGB",
        type: "CLAVIER",
        prix: 149.99,
        numeroGroupe: "G7"
    },
    {
        numeroSerie: "ACC202401",
        marque: "JBL",
        modele: "Quantum 400",
        type: "ENCEINTES",
        prix: 89.99,
        numeroGroupe: "G7"
    }
]);

// Insérer des commandes par l'interface graphique de l'application