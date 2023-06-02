# GameChanger

A simplistic store interface for managing a database of video games.

### Copyright
#### Authors
Rafal Nowak, Mikołaj Orzoł, Jakub Gabryszewski
#### License
MIT License

### Requirements specification
| Identifier | Name | Description | Priority | Category |
| --------------|-------|------|-----------|-----------|
| REQ-001 | Managing video games | The software should allow the user to add and remove video games from the cart. | High | Functionality |
| REQ-002 | Filtering results | The software should be able to filter the displayed video games using the search bar and genre. | High | Functionality | 
| REQ-003 | Database-based | The software should be integrated with a database. | High | Functionality | 
| REQ-004 | Graphical interface | The software should have a clear and responsive interface to facilitate interactions. | Medium | Usability | 
| REQ-005 | Optimization | The software should run quickly and efficiently so that users can work efficiently with the application. | Medium | Performance |
| REQ-006 | Interface Language | The software should have an interface in English. | Low | User interface | User interface | 

### Software architecture
#### Development architecture
The GameChanger project is written in Java Spring Boot.

The main functionality of the project is the ability pick from a handful of hard-coded video games and add them to the cart, which is integrated with the MySQL database. The option to remove said video games is also included in the project.

GameChanger uses a classic database integration structure; the data model is defined in the Game.java file, which is then referenced by the CartController. However, the different modules are encapsulated inside of the CartService. Finally, the GameRepository is used to interact with the MySQL database.

The interface was designed with the help of the <a href="https://getbootstrap.com/">Bootstrap library</a>, while the commits were structured according to the <a href="https://www.conventionalcommits.org/en/v1.0.0/">Conventional Commits</a> method.

#### Project Structure
```
GameChanger
    ├───.mvn
    │   └───wrapper
    ├───.vscode
    ├───src
    │   ├───main
    │   │   ├───java
    │   │   │   └───GCGroup
    │   │   │       └───GameChanger
    │   │   │           ├───Controllers
    │   │   │           └───Data
    │   │   └───resources
    │   │       ├───static
    │   │       │   ├───css
    |   |       |   ├───images
        |       |   ├───js
        │   └───test-annotations
        └───test-classes
            └───GCGroup
                └───GameChanger
```

#### You can find the projeckt mock-up <a href="https://l.facebook.com/l.php?u=https%3A%2F%2Fwhimsical.com%2Fgamechanger-ui-FoYKevN8XSpe8tYvdgjnjH%3Ffbclid%3DIwAR2Hw0f-4GPXfdaMFLV6b0l5ufrWSzl3QH2wc-5YalVib7HfoVJQ0qFtTPY&h=AT3gDKXSzl3u6ZOTOMOc2pI1gFc7Ho9S5adG4rlZ2dOGDi2vI4PAhw5OmG8pU5Agm3Be2v-oaSBqnn96CdFy0ev3GdRB_jJ4h7ZBp6tm33djeobe4NCqw0dfO6gD45jRKpgCTg">here</a>

#### Startup architecture
To run GameChanger, you need to perform two main steps:

1. Set up the Java Spring Boot environment:

First, download the latest version of the JDK from the <a href="https://www.oracle.com/java/technologies/downloads/">offical Oracle website</a>, and then download and unzip the source repository for this guide, or clone it using Git: 

```
git clone https://github.com/RWNowak/GameChanger
```

You can <a href="https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/">refer to the Spring Boot documentation for more details</a>

2. Configure the database connection:

To properly use the Cart functionality in GameChanger, you need to configure the connection to the database.
First, <a href="https://dev.mysql.com/doc/mysql-getting-started/en/">create a MySQL database</a> and add the necessary tables:
```
CREATE TABLE cart (
id INT AUTO_INCREMENT PRIMARY KEY,
game_id VARCHAR(50) NOT NULL,
title VARCHAR(500) NOT NULL
);
```
Modify the database access information, especially the password and database name, in the src>main>resources>application.properties file
```
spring.datasource.url=jdbc:mysql://localhost:3306/YOUR-DATABASE-NAME
spring.datasource.username=root
spring.datasource.password=YOUR-PASSWORD
```
Please note that this assumes that you're running your MySQL database with the default username and port. Please <a href="https://dev.mysql.com/doc/mysql-getting-started/en/">refer to the documentation<a> if your situation is different.
