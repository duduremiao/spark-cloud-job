FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM bitnami/spark:3.5.0
WORKDIR /app
COPY --from=builder /app/target/spark-job.jar ./spark-job.jar
COPY input ./input
ENV HOME=/tmp
USER root
ENTRYPOINT ["/opt/bitnami/spark/bin/spark-submit", "--class", "com.example.SimpleSparkJob", "--master", "local[*]", "spark-job.jar"]