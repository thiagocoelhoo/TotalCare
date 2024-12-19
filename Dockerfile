FROM openjdk:17-jdk-slim

# Copie o código fonte e o Maven Wrapper
COPY . /app
WORKDIR /app

# Permita execução do Maven Wrapper
RUN chmod +x ./mvnw

# Compile o projeto com Maven e crie o JAR
RUN ./mvnw clean package -DskipTests

# Execute o JAR gerado
CMD ["java", "-jar", "target/totalCare-0.0.1-SNAPSHOT.jar"]
