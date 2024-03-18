Proyecto API-Medicos
======================================

- Spring Boot 2
- Web application (WAR) packaging as well as self-contained JAR
- `Thymeleaf` with following dialects: Java 17 Time, Layout and Security
- `WebJars`

Prerequisites
-------------

- `JDK 11` and `JAVA_HOME` environment variable set 

Building the project
--------------------

Clone the repository:

    git clone https://github.com/hunGyTech/API-Medicos

Navigate to the newly created folder:

    cd spring-boot-apirest

Run the project with:

    ./mvnw clean spring-boot:run

Navigate to:

    http://localhost:8080/api/status/

Package the application
-----------------------

To package the project run:

    ./mvnw clean package

#   API MEDICOS