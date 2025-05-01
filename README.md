Ce projet de gestion de bibliothèque a représenté une étape clé dans ma progression en développement d’applications Java avec Spring Boot. 
Il m’a permis de mettre en pratique de nombreuses compétences techniques, notamment :
La création d’un CRUD complet pour la gestion des livres.
L’intégration d’un endpoint SOAP pour la réservation, une fonctionnalité avancée rarement mise en œuvre dans les projets de début de parcours.
🌟 Ce projet a été un vrai succès car :
Il m’a permis de m’auto-évaluer objectivement sur mes capacités à mener un projet technique du début à la fin.
J’ai renforcé ma maîtrise de Java, Spring Boot, JPA et les API SOAP, tout en me confrontant à des situations proches du monde professionnel.
J’ai su résoudre des problèmes complexes, comme le fait de retirer un livre de la liste des livres disponibles dès qu’il est réservé, ce qui a 
nécessité des ajustements dans les règles métiers et la base de données.
⚠️ Difficultés rencontrées
Comme tout projet réel, j’ai été confrontée à plusieurs défis importants :
Des difficultés d’organisation en binôme, notamment à cause de mon emploi du temps chargé et de mes horaires de travail qui ont parfois ralenti notre coordination.
Un temps d’adaptation nécessaire pour bien comprendre les concepts avancés comme la gestion des états de réservation, ou encore l’intégration SOAP.
Des erreurs techniques (ex : erreurs JAXB, configuration de Maven, gestion des dépendances) que j’ai su résoudre avec patience et persévérance.
🎯 l’architecture du projet

com.biblio.livres
├── Accueil
│   └── Accueil.java                      # Classe liée à l'écran d'accueil ou au contenu statique
│
├── config
│   └── OpenApiConfig.java               # Configuration de la documentation API (ex. : Swagger)
│
├── controller
│   ├── LivreController.java             # Contrôleur REST pour les livres
│   └── ReservationController.java       # Contrôleur REST pour les réservations
│
├── dto
│   └── PreterLivreRequest.java          # Objet de transfert pour les requêtes de prêt de livre
│
├── model
│   ├── Livre.java                       # Entité Livre (JPA)
│   └── Reservation.java                 # Entité Reservation (JPA)
│
├── repository
│   ├── LivreRepository.java             # Interface JPA pour Livre
│   └── ReservationRepository.java       # Interface JPA pour Reservation
│
├── service
│   └── LivreService.java                # Logique métier pour la gestion des livres
│
├── BibliothequeApplication.java         # Classe principale (peut-être point d'entrée alternatif)
└── LivreApplication.java                # Classe principale Spring Boot (point d'entrée de l’app)

