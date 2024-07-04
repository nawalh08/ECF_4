# Application de gestion de recrutement 

## Description de l'application 
Cette application gère les offres d'emploi et les candidatures au sein d'une entreprise.
Elle permet de créer, lire, mettre à jour et supprimer des offres d'emploi et des candidatures.
L'application utilise Spring Boot pour le développement web et Spring Data JPA pour les opérations de base de données.

## Ce qu'il nous faut 
- Maven
- MySQL
- Java
- 
## Les dépendences 
- Spring boot
- thymeleaft
- Spring boot starter validation
- Spring boot starter web-services
- Spring boot devtools

## MySQL 
1. Créez la base de données
2. Creations des tables nécessaires:
   - table JobOffer
   - Table User
   - Table Application
   - Table Interview
  
     
Connecter sa base de données en configurant les propriétés dans application.properties

spring.application.name=ECF_4
spring.datasource.url=jdbc:mysql://localhost:3306/ecf4
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update

## Fonctionnalités 
- Creation des offres d'emploi
- Lire toutes les offres d'emploi
- Mettre à jour les offres d'emploi
- supprimer les offres d'emploi

- Candidatures
   - Creer une candidature
   - Lire toutes les candidatures
   - Modifier les candidatures
   - Supprimer les candidatures

- Entretiens
   - Creer un entretien
   - Lire tous les entretiens
   - Modifier les entretiens
   - Supprimer les entretiens
 
     
## Interface Utilisateur 

L'application utilise thymeleaft pour l'interface utilisateur, les templates se trouvent dans le répertoire resources/templates.
