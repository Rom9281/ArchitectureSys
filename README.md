# Architecture Système Atelier 3

## Projet Creation d'un site de jeu de cartes SpringBoot

## Membres de l'équipe 

BURLOT Alexandre <br>
CURRAL Maxime<br>
GAUD Romain<br>
GALMIER Romain<br>

## Ports de lancement de nos micro-services

- card : 8083
    - Base de l'URL : http://localhost:8083/
- user : 8082
    - Base de l'URL : http://localhost:8082/
- market : 8084
    - Base de l'URL : http://localhost:8084/

Tous nos services sont accessibles à partir du localhost : 127.0.0.1


# Liste des routes par micro service

## Micro service Market
- Route de base : http://localhost:8084/market

|   Methode     |       URI              |  Body       |Valeur de retour| Explication |
| :-----------: |   :-----------:        |:-----------:|:-----------:   |:-----------:|
|   GET         | /buy                   |    None     |List\<CardDTO>  | Obtenir toutes les cartes qui sont en vente|
|   GET         | /sell/{userid}         |    None     |List\<CardDTO>  | Obtenir les cartes de l'utilisateur pour une possible mise en vente|
|   GET         | /buy/{userId}/{cardId} |    None     |" "             | Action d'achat d'une carte par un utilisateur |



## Micro service Card

- Route de base: http://localhost:8083/card

|   Methode     |       URI         |     Body          |   Valeur de retour    | Explication |
| :-----------: |   :-----------:   |   :-----------:   |   :-----------:       |:-----------:|
|   GET         | /generateCards/{userId}  |     None   |   List\<CardDTO>      | Génère les 5 cartes de l'utilisateur venant d'être créé |
|   POST        | /                |    CardDTO        |   CardDTO      | Création d'une carte |
|   GET         |       /{cardId}     |    None        |   CardDTO              | Obetenir la carte possèdant l'id {cardId}
|   GET         |        /user/{userId}     |    None        |   List\<CardDTO> | Obtenir toutes les cartes de l'utilisateur {userId}
|   GET         |       /market     |    None        |   List\<CardDTO> | Obtenir toutes les cartes à la vente
|   GET         |       /cards     |    None        |   List\<CardDTO> | Obtenir toutes les cartes ayant été crées |
|   PUT         |       /{cardId}    |    CardDTO        |   CardDTO | Met à jour une carte |


## Micro service User

- Route de base: http://localhost:8082/

|   Methode     |       URI         |     Body          |   Valeur de retour    | Explication |
| :-----------: |   :-----------:   |   :-----------:   |   :-----------:       |:-----------:|
|   POST        |       /createUser |    UserDto        |   Boolean             | Création d'un utilisateur |
|   GET         |       /user/           |    None           |   List\<UserDTO>      | Obtenir tous les utilisateurs | 
|   GET         |       /user/{userId}   |    None        |   UserDTO      | Obtention de l'utilisateur {userId}
|   POST        |       /user/login     |    UserDTO        |   Boolean | Vérification du login de l'utilisateur souhaitant se connecter
|   PUT         |       /user/update     |    UserDTO        |   None | Met à jour un User
|   GET         |       /getUserInfo/{login}     |    None        |   User | Récupère les informations du User grâce à son login


  
# Elements réalisés du cahier des charges
  ## BURLOT Alexandre
  - Réalisation de tous le micro-service market
  - Utilisation de la base de données H2 sur le projet
  - création des fichier Com pour controle microservices
  ## CURRAL Maxime
  
  ## GAUD Romain
  - Parle de la base de données en docker
  ## GALMIER Romain
  
  
 # Elements non-réalisés du cahier des charges
  ## SONAR
  Nous nous sommes renseignés sur une éventuelle implémentation de l'outils SonarScanner sur le projet mais sa mise en place nécessite les packages de dockers que nous n'avons pas sur nos machines et son utilisation n'aurait été que partielle.
  ## ROOMS
  
  ## Front
  
