FROM openjdk:8u111-jre-alpine
VOLUME /tmp
COPY target/od-0.0.1-SNAPSHOT.jar od.jar
CMD "java" "-jar" "od.jar"
EXPOSE 5000
