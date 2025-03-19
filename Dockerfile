FROM openjdk:17

#se copia y se le pone un nombre mas amigable a la copia
COPY target/crud-0.0.1-SNAPSHOT.jar java-app.jar
ENTRYPOINT [ "java", "-jar", "java-app.jar" ]