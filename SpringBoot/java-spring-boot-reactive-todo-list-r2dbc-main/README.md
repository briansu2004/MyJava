[![CircleCI](https://circleci.com/gh/pictet-technologies-open-source/reactive-todo-list-r2dbc/tree/main.svg?style=shield&circle-token=fe1f6278e0274f19145214acdd9aa58853244494)](https://circleci.com/gh/pictet-technologies-open-source/reactive-todo-list-r2dbc)
[![CodeFactor](https://www.codefactor.io/repository/github/pictet-technologies-open-source/reactive-todo-list-r2dbc/badge/main?s=d8d979567cd99f075cc427c98b7c2136c77160cc)](https://www.codefactor.io/repository/github/pictet-technologies-open-source/reactive-todo-list-r2dbc/overview/main)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

[![Made with Love by Pictet Technologies](https://img.shields.io/badge/Made%20with%20love%20by-Pictet%20Technologies-ff3434.svg)](https://pictet-technologies.com/)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/alexandre-jacquot-34bb7b5)


[![Medium](https://img.shields.io/badge/Medium-12100E?style=badge&logo=medium&logoColor=white)](https://medium.com/@alexandre.jacquot/reactive-programming-with-spring-data-r2dbc-ee9f1c24848b)

# Reactive Todo List with PostgreSQL and Spring Data R2DBC

This project aims to explain how to build a fully reactive application with **Spring Boot**, **Spring Webflux**, **Angular**, **PostgreSQL** and **Spring Data R2DBC**.
It demonstrates how to deal with concurrent modifications using **optimistic locking**, **PostgreSQL Listen/Notify** and **Server Sent Events**.

### Project structure


Folder                    | Description                                                  
--------------------------|--------------------------------------------------------------
docker                    | Contains the docker-compose.yml used to setup the application 
todo-list-application     | Spring boot application (back-end) 
todo-list-ui              | Angular application (front-end)
 

### Local environment

#### Build the application

In order to build the application you need to have the following softwares installed:
- open JDK or oracle JDK >= 8
- docker & docker compose
- npm

```
$ build.sh
```

#### Start the application

```
$ start.sh
```

Once the application is started you can access it using the following links : 

Name                      | Link                                                  
--------------------------|--------------------------------------------------------------
UI                        | http://localhost:8080
Swagger UI                | http://localhost:8080/swagger-ui/#/item-controller
PgAdmin                   | http://localhost:5050/


If you only want to start postgres, execute the following command

```
$ start.sh -postgres-only
```

#### Configure PgAdmin (PostgreSQL web Client)

Login to PgAdmin: http://localhost:5050/

- Login: admin@admin.com
- Password: password

Create a connection

- Server: postgres
- Database name: todolist
- User: admin
- Password: password

#### Stop the application

```
$ stop.sh
```


### Production environment

#### Build the application

You need to have docker installed to build the application.

Ensure that the URL of the application has been correctly configured in the following file.

```
todo-list-ui/src/app/environments/environment.prod.ts
```

Then build the application in production mode.

```
$ mvnw clean install -Pprod
```
