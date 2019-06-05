FROM openjdk:11
EXPOSE 8083
ADD ["target/notification-service-0.0.1-SNAPSHOT.jar", "notification.jar"]
RUN sh -c 'touch /notification.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /notification.jar" ]