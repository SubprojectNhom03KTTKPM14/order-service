FROM openjdk:11 
EXPOSE 8083
COPY target/order-service-0.0.1-SNAPSHOT.jar order-service-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "order-service-0.0.1-SNAPSHOT.jar"]