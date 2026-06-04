# Projet Java — Gestion de Magasin
Application gestion de magasin réalisé avec Java + Swing + JDBC + MariaDB

Avant de lancer l'application (ou le fichier `.jar`), assurez-vous que les éléments suivants sont installés et configurés :

### Pré-requis
- Avoir Java 26
- Wamp ou Xampp

1. Exécuter WampServer ou Xampp
- s'assurer que dans les paramètres vous autorisez MySQL et MariaDB

2. Sur un navigateur, faites `localhost`.
- Vous devriez voir la page d'accueil de Wamp ou Xampp, ensuite cliquez sur phpmyadmin

3. Vous devriez atterir sur la page de connexion. 
- Entrez comme identifiant `root` et laissez le mot de passe vide.
- Pour le choix de serveur, prendre MariaDB.
- Cliquez sur Connexion.

4. Si cela a fonctionné, vous devriez voir l'interface phpmyadmin.
- Vous devriez voir en haut un onglet "Importer", cliquer dessus.
- Dans la partie Fichier à importer, cliquez sur Choisir un fichier.
- Naviguez dans le dossier ProjetJava-Master, vous devriez voir à l'intérieur un fichier `data.sql`
- Cliquez sur `data.sql`.
- Revenez sur l'interface phpmyadmin, descendez tout en bas et cliquer sur Importer.
- La base de données magasin est créé, les tables sont créées et des données sont insérées dans les tables.

. Exécuter `ProjetJava-GestionMagasin.jar`

### État du projet
Fonctions basiques (ajout, supprimer, modifier) mais manque la partie Caisse, Commande, Fournisseur, Magasin