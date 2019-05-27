FROM openjdk:11
EXPOSE 8080
ADD ["target/user-service-0.0.1-SNAPSHOT.jar", "user.jar"]
RUN sh -c 'touch /user.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /user.jar" ]