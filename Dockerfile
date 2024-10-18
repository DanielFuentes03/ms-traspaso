FROM openjdk:17

VOLUME /temp

LABEL mentainer="daniel.fuentes@profuturo.com.mx"

ENV TSP_PATH=/traspaso

EXPOSE 7070

WORKDIR /app

COPY target/Traspaso-0.0.1-SNAPSHOT.jar /app/Traspaso-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","Traspaso-0.0.1-SNAPSHOT.jar"]







