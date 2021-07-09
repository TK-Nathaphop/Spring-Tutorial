# Spring-Tutorial
My code from studying Java Spring Boot with Gradle.

## What I've learned?
- Basic restful API
  - `GET`, `POST`, `PUT`, and `DELETE`.
  - You can see from file name that contains `Controller`.
- Access SQL database
  - In `accessingDB` folder.
- Cache with Redis
  - In `accessingDB` and `cacheManager`
- Kafka Spring
  - Basic consumer and producer

## How to run it?
**Note that this running project is based on local computer.**
If you want to run this project on server (for what?), you need to do it by yourself.
(But if you do it, please tell me how did you run it (lol))

### Prerequired
- Docker
- Java 1.8
- Spring
- Gradle

### Run project
First of all, you need to run `docker-compose` file to set up `MySQL`, `Redis`, and `Kafka`.

`docker-compose up`

Then you can run the project with this command

`gradlew run`

### Build project

`./gradlew build`

**If you have questions or problems from running the project, just Google it**
