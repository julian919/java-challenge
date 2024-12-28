FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY ./pom.xml /app/.
COPY ./src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
EXPOSE 8761
COPY --from=build /app/target/*.jar eureka-service.jar
ENTRYPOINT ["java", "-jar", "eureka-service.jar"]