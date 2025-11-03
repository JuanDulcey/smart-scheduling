# =======================================================
# Etapa 1: Construcción (Maven + JDK 21)
# =======================================================
FROM maven:3.9.9-eclipse-temurin-21 AS build

# Establecemos el directorio de trabajo
WORKDIR /app

# Copiamos el archivo pom.xml primero para aprovechar la caché de dependencias
COPY pom.xml .

# Descargamos las dependencias necesarias (modo offline)
RUN mvn -B dependency:go-offline

# Copiamos el código fuente completo
COPY src ./src

# Compilamos y empaquetamos el proyecto, saltando los tests (para CI/CD rápido)
RUN mvn -B clean package -DskipTests

# =======================================================
# Etapa 2: Ejecución (Runtime liviano)
# =======================================================
FROM eclipse-temurin:21-jre

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos solo el artefacto necesario desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto por defecto de Spring Boot
EXPOSE 8080

# Metadatos útiles
LABEL maintainer="Juan Esteban Dulcey Gómez <juan.dulcey@dulceyson.com>"
LABEL version="1.0.0"
LABEL description="Microservicio Smart Scheduling - Backend Spring Boot con soporte Docker y CI/CD"

# Variables de entorno por defecto (pueden sobreescribirse en .env o Docker Compose)
ENV JAVA_OPTS=""
ENV SERVER_PORT=8080

# Comando de ejecución
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
