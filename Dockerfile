FROM openjdk:17
VOLUME /temp
ENV IMG_PATH=/img
EXPOSE 7070
RUN mkdir -p /img
ADD ./target/Traspaso-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java","-jar","/app.jar" ]
