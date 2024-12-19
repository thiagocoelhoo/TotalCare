FROM openjdk:17-jdk-slim

# Instale o Maven
RUN apt-get update && apt-get install -y maven

# Copie o código fonte e o wrapper do Maven
COPY . /app
WORKDIR /app

# Conceda permissão de execução ao Maven Wrapper
RUN chmod +x ./mvnw

# Ajuste as permissões dos arquivos e diretórios
RUN chown -R root:root /app && chmod -R 755 /app

# Execute o build do Maven para gerar o JAR
RUN ./mvnw clean package -DskipTests

# Execute o JAR gerado
CMD ["java", "-jar", "target/totalCare-0.0.1-SNAPSHOT.jar"]