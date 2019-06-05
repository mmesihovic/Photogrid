FROM openjdk:11
EXPOSE 8762
ADD ["target/api-gateway-0.0.1-SNAPSHOT.jar", "api.jar"]
RUN sh -c 'touch /api.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /api.jar" ]