FROM adoptopenjdk/openjdk11:ubi
WORKDIR /opt/app
COPY . .
RUN ./mvnw package
EXPOSE 8080
CMD ["java", "-jar", "target/pedido-hamburguer-0.0.1-SNAPSHOT.jar"]