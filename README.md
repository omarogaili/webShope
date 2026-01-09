# WebShop - En enkel e-handelsapplikation

## Beskrivning
WebShop är en skolprojekt utvecklad med Java och Spring Boot, Thymeleaf, Mysql och Spring Security. Applikationen tillåter användare att bläddra bland produkter. För att göra köp måste användaren vara inloggad. Användare kan registrera sig, logga in. 

## Teknologier
- **Backend:** Java, Spring Boot, Spring Security
- **Frontend:** Thymeleaf, HTML, CSS
- **Databas:** MySQL
- **Byggverktyg:** Maven

## Funktioner

- Användarregistrering och inloggning
- Säkerhetsfunktioner med Spring Security
- Responsiv design med Thymeleaf

## Installation
1. Klona detta repository:
    ```bash
    http
    git clone https://github.com/plugga-tech/login-omarogaili.git
    ```
    Eller 
    ```bash
    git clone git@github.com:plugga-tech/login-omarogaili.git
    ```

2. Navigera till projektmappen:
    ```bash
    cd login-omarogaili/Login
    ```
3. Bygg projektet med Maven:
    ```bash
    mvn clean install
    ```
4. Starta applikationen:
    ```bash
    mvn spring-boot:run
    ```
5. Öppna din webbläsare och navigera till `http://localhost:8080`

## Användning
- Registrera ett nytt konto eller logga in med befintliga uppgifter.
- Lösenordet måste vara minst 8 tecken långt. 
- Emailadressen måste vara unik.
- Vid registrering måste alla fält fyllas i korrekt.
- Användaren kan bläddra bland produkter men användaren måste vara inloggad för att göra köp.
- Efter inloggning kan användaren se sina ordrar.

## Konfiguration Databas 
Redigera `application.properties` filen för att konfigurera databasanslutningen:
```properties
spring.datasource.password=******
spring.datasource.username=***
```
## Projektstruktur
```
Login/ 
     
     src/main/

        java/com/loginapp/login/
            config/              # Säkerhetskonfiguration

            controllers/         #  controllers
            
            datatransferobjects/ # DTOs för dataöverföring  
            
            model/               # Entitetsklasser
            
            repository/          # Databasåtkomst
            
            services/            # Affärslogik
        
        resources/
            static/              # Statisk resursfiler (CSS, JS, bilder)    
                style/           # CSS-filtrering   
            templates/           # Thymeleaf-mallar
````

>>>>>>> old-repo/main
