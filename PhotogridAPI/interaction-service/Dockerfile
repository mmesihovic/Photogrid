FROM openjdk:11
EXPOSE 8085
ADD ["target/interaction-service-0.0.1-SNAPSHOT.jar", "interaction.jar"]
RUN sh -c 'touch /interaction.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /interaction.jar" ]