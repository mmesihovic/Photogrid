FROM openjdk:11
EXPOSE 8081
ADD ["target/post-service-0.0.1-SNAPSHOT.jar", "post.jar"]
RUN sh -c 'touch /post.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /post.jar" ]