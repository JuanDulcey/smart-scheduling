# =========================
# Etapa 1: Construcción
# =========================
FROM maven:3.9.8-eclipse-temurin-21 AS build

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo pom.xml y descargamos las dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el código fuente al contenedor
COPY src ./src

# Compilamos el proyecto y generamos el .jar
RUN mvn clean package -DskipTests

# =========================
# Etapa 2: Ejecución
# =========================
FROM eclipse-temurin:21-jdk

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el .jar desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto de la app
EXPOSE 8080

LABEL maintainer="Juan Esteban Dulcey Gómez"
LABEL version="1.0"
LABEL description="Backend Spring Boot para MS-Directory"

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
