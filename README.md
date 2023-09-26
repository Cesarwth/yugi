Yugi Aplication

* Prerequisites
    * Install Docker
    * Install Maven
    * Postman


* Run the application

  `mvn clean install`

  `docker-compose build`

  `docker-compose up`

Note: you can reach the application in POSTMAN in the next context:

Get Method:
`http://localhost:8080/api/monsters/{archetype}`

Ejm
`http://localhost:8080/api/monsters/Blue-Eyes`

To verify the view go to this url:

`http://localhost:8080/api/monsters/monsters?archetypeName=Crystron`