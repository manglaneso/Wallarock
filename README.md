# Wallarock API

REST API based on microservices built in Java using Spring Boot. Wallarock is a web application developed as a college project for learning purposes which implements the functionality of a second hand buying/selling platform in the style of [Wallapop](https://es.wallapop.com/).

## Architecture

![](Architecture_Diagram.png)

The API follows the microservices architectural style in which there are three different types of microservices:

1. The Client microservice is in charge of user management. Stores the user data in a SQL table.
2. The Catalog microservice is in charge of Products to buy/sell management. Stores the products data in a SQL table.
3. The Chat microservice is in charge of management of chats among users of the platform. Stores the chat data in a MongoDB collection
4. The [WallarockRestClient](https://github.com/manglaneso/Wallarock-client) is an example client for this API.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Installing

Follow the following steps for getting the development environment going

1. Install the [Spring Tool Suite (STS)](https://spring.io/tools/sts/all)
2. Clone the repo

```
git clone https://github.com/manglaneso/Wallarock-API.git
```
3. Open the Client, Catalog and Chat folder with STS
4. Install MariaDB
5. Install MongoDB
6. Load the [SQL script](generate.sql) in MariaDB in order to create the DB and the Catalog and Client tables
7. Start the three projects with STS Each one listens in a different port

## Built With

* [Spring](https://spring.io/projects/spring-boot) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [MariaDB](https://mariadb.org/) - Relational DB engine for the Client and Catalog microservice
* [MongoDB](https://www.mongodb.com) - Non relational DB engine for the Chat microservice

## Authors

* **Andrés Manglano** - *Initial work* - [manglaneso](https://github.com/manglaneso)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the GPL3 License - see the [LICENSE.md](LICENSE.md) file for details
