FROM openjdk:11
EXPOSE 8083
ADD target/update-player.jar update-player.jar
ENTRYPOINT ["java","-jar","/update-player.jar"]