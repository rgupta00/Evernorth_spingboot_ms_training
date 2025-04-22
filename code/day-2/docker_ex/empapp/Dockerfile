#FROM openjdk:21
FROM openjdk:17-alpine
MAINTAINER email="rgupta.mtech@gmail.com"
EXPOSE 8080
ADD target/*.jar empapp.jar
ENTRYPOINT ["java","-jar","empapp.jar"]