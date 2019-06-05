FROM openjdk:11
EXPOSE 8090
ADD ["target/document-service-0.0.1-SNAPSHOT.jar", "document.jar"]
RUN sh -c 'touch /document.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /document.jar" ]