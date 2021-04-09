# Guest Book Service

<p align="center">
  <a href="#">
    <img src="./img/img.png" alt="guest book logo" width="247" height="73">
  </a>
</p>

<h3 align="center">Guest Book Service (Back-End Spring Boot REST API)</h3>

<p align="center">
  Guest Book is a service where the user can go and post a comment with the name and also can see all the comments.
  <br>

  <br>
</p>

## Table of contents

- [Technology Used](#technology-used)
- [Installation Instruction](#installation-instruction)
- [Auto-Deploy Instructions](#auto-deploy-instructions)
- [API](#api)
- [What's Included](#whats-included)
- [Creators](#developers)


## Technology Used

- Gradle as Build Tool
- Spring boot is used for the backend Services.
- H2 database for Tests
- Postgres database to store the data.
- Junit and Mockito for Tests.
- Deployed on Heroku

## Installation Instruction

Software Requirement:
1. Gradle ([install](https://gradle.org/install/))

2. Java (minimum java 8) ([install](https://www.oracle.com/java/technologies/javase-downloads.html))

3. Docker ([install](https://docs.docker.com/get-docker/))

4. Heroku CLI - Optional for Deployment. ([install](https://devcenter.heroku.com/articles/heroku-cli)) 
Follow these easy step:


1. Clone the repository:
     ```
     https://github.com/kbhar01/guestBook.git
     ```
2. Execute this on command line:

     ```shell
     $ cd guestBook
     $ docker build -t <your email>/guestbook .
     $ docker network create --driver bridge guestbooknetwork
     $ docker run -d -p 5432:5432 -e POSTGRES_USER=devuser -e  POSTGRES_PASSWORD=cog -e POSTGRES_DB=guestbookdb --network guestbooknetwork --name guestbookpostgres postgres
     $ docker run -d -p 8081:8080 -e SPRING_PROFILES_ACTIVE=dockerlocal --network guestbooknetwork --name guestbookservice <your email>/guestbook
     ```
3. Heroku Deployment (Heroku CLI Required.)
   
   ```shell
   $ heroku login
   $ heroku create
   $ heroku git:remote -a
   $ heroku container:login
   $ heroku container:push web
   $ heroku container:release web
   ```
   

4. Enjoy

## Auto-Deploy Instructions
Follow these to deploy the container automatically.
Files Required:
- Dockerfile
- heroku.yml
Steps:

1. Login into heroku.
```shell
heroku login
```

2. Add Heroku Git Remote
```shell
# guest-book-service is my app name. Please use yours 
heroku git:remote -a guest-book-service 
```

3. Use Heroku Stack to set heroku.yml
```shell
heroku stack:set container
```

4. Commit and Push into heroku remote.
```shell
git add --all 
git commit -m "heroku commit"
git push heroku master 
```

5. Open App
```shell
heroku open
```

Hint: For auto deploy please follow step 4.
## Sample Server
Feel free to play with our sample server. 

-  ([Server# 1](https://guestbook-koustav-javed.herokuapp.com/))

## API
```text
Base URL: /, Version: 1.1, local port: 8081

Default request content-types: application/json

Default response content-types: application/json

Schemes: http 
```

## API Reference
<table style="
    width: 100%;
    max-width: 100%;
    margin-bottom: 20px;
    border: 1px solid #ddd;
    border-collapse: collapse;
    border-spacing: 0;
    background-color: transparent;
    display: table;
">
    <thead>
    <tr>
        <th>Path</th>
        <th>Operation</th>
        <th>Description</th>
        <th>Controller -> Method</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;" rowspan="2">
            <a href="#summary">/</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#get-entries">GET</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Get list of comments. </p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>GuestBookController -> getAllEntries()</p>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#post-comment">POST</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Post new Comment.</p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>GuestBookController -> addNewComment()</p>
        </td>
    </tr>
    </tbody>
</table>

#### API Details

#### POST /
Response Header
```text
    Status: 201 CREATED
```
Request Body
```json5
{
   "name":"Superman",
   "comment":"I like to Fly."
}
```

Response Header
```text
[Content-Type:"application/json"]
```

Response Body
```json5
{
  "message": "Comment is Successfully Created."
}
```

#### GET /
Response Header
```text
    Status: 200 OK
```

Response Body
```json5
[
   {
      "name":"G1",
      "comment":"G1 Comment"
   },
   {
      "name":"G2",
      "comment":"G2 Comment"
   }
   ...
]
```

## What's included

Within the download you'll find the following directories and files, logically grouping common assets and providing both compiled and minified variations. You'll see something like this:

<details>
<summary>
File Tree.
</summary>


```text
│   .gitignore
│   build.gradle
│   Command.sh
│   Dockerfile
│   gradlew
│   gradlew.bat
│   heroku.yml
│   Readme.md
│   settings.gradle
└───src
    ├───docs
    │   └───asciidoc
    │           index.adoc
    │
    ├───main
    │   ├───generated
    │   ├───java
    │   │   └───com
    │   │       └───cognizant
    │   │           └───guestBook
    │   │               │   GuestBookApplication.java
    │   │               │
    │   │               ├───controller
    │   │               │       GuestBookController.java
    │   │               │
    │   │               ├───entity
    │   │               │       GuestBookEntity.java
    │   │               │
    │   │               ├───repository
    │   │               │       GuestBookRepo.java
    │   │               │
    │   │               ├───request
    │   │               │       GuestBookRequest.java
    │   │               │
    │   │               ├───response
    │   │               │       GuestBookResponse.java
    │   │               │
    │   │               └───service
    │   │                       GuestBookService.java
    │   │
    │   └───resources
    │           application-dev.properties
    │           application-dockerlocal.properties
    │           application-production.properties
    │           application-qa.properties
    │           application.properties
    │
    └───test
        └───java
            └───com
                └───cognizant
                     └───guestBook
                        │   GuestBookApplicationTests.java
                        │
                        ├───integration
                        │       GuestBookTest.java
                        │
                        └───unit
                            ├───controller
                            │       GuestBookControllerTest.java
                            │
                            └───service
                                    GuestBookServiceTest.java


```

</details>


## Developers

**Koustav Bhar**

- <https://github.com/kbhar01>

**Mohammad Javed**

- <https://github.com/gajjuCoderBoi>
