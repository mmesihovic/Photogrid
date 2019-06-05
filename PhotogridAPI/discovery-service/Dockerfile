FROM openjdk:11
EXPOSE 8761
ADD ["target/discovery-service.jar", "discovery.jar"]
RUN sh -c 'touch /discovery.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /discovery.jar" ]