FROM openjdk:17
ADD target/user-App.jar user-App.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "user-App.jar"]