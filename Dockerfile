# Stage 1: Build the Spring Boot app
FROM maven:3.9.1-openjdk-17 as build
COPY . .  
RUN mvn clean package -DskipTests

# Stage 2: Run the Spring Boot app
FROM openjdk:17-jdk-slim

COPY --from=build /target/ToursandTravels-0.0.1-SNAPSHOT.jar ToursandTravels.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "ToursandTravel.jar"]
