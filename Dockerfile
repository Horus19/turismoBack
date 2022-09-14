FROM openjdk:20-slim-buster
COPY "./target/turismoBack-0.0.1-SNAPSHOT.jar" "app-turismo.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app-turismo.jar"]