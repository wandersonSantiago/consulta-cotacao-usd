FROM openjdk:11
VOLUME /tmp
ADD /target/*.jar microservice.jar
ENTRYPOINT ["java", "-jar", "/microservice.jar"]
