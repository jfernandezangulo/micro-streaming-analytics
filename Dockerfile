FROM openjdk:8-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

#Host de mongodb
ENV MONGODB_HOST_NAME mongodb

#Host de rabbitmq
ENV RABBITMQ_HOST_NAME rabbitmq

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/micro-streaming-analytics-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
COPY ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]