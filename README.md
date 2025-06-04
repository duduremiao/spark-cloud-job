# 🔥 Cloud-Native Spark Job with Docker and Kubernetes

This is a cloud-native Spark application designed to demonstrate cloud development best practices using:
- Apache Spark for distributed data processing
- Docker for containerization
- Kubernetes (Minikube) for orchestration

## 📊 What It Does

This project reads a sample CSV file with e-commerce sales data, processes it using Spark, and outputs summarized insights by category in Parquet format.

### Input Sample

```csv
product,category,price
Laptop,Electronics,999.99
Shirt,Clothing,29.99
```

### Output (Parquet)

Aggregated data per category:
- Total value
- Average value
- Count

## 🛠️ Technologies

- Java 17
- Apache Spark 3.5+
- Docker
- Kubernetes (Minikube)
- Maven

## 🚀 Run Locally with Docker

```bash
mvn clean package -DskipTests
docker build -t spark-job .
docker run --rm spark-job
```

## ☸️ Deploy on Kubernetes

```bash
minikube start
kubectl apply -f k8s/job.yaml
kubectl get pods
kubectl logs <pod-name>
```

## 📁 Output Location

The results are written to the `output/` folder inside the container in Parquet format.

## 📦 Cloud-Native Principles Covered

✅ Stateless batch job  
✅ Containerized execution  
✅ Kubernetes orchestration  
✅ ETL-friendly output (Parquet)  
✅ Ready for CI/CD pipelines

## 👤 Author

Eduardo – Java | Spark | Cloud-Native Developer
[LinkedIn](https://www.linkedin.com/in/eduardoremiao/) • [DockerHub](https://hub.docker.com/repositories/eremiao) • [GitHub](https://github.com/duduremiao/)