FROM openjdk:17-jdk-slim
COPY . /app
WORKDIR /app
RUN ./mvnw package -DskipTests
CMD ["java", "-jar", "target/TotalCareApplication.jar"]
