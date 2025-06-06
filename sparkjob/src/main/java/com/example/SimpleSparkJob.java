// Estrutura inicial do projeto Spark + Docker + Kubernetes

// 1. App Java com Spark - análise melhorada
// File: src/main/java/com/example/SimpleSparkJob.java
package com.example;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;

public class SimpleSparkJob {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("SimpleSparkJob")
                .getOrCreate();

        Dataset<Row> df = spark.read().option("header", true).option("inferSchema", true).csv("input/data.csv");

        // Análise mais robusta
        df.printSchema();
        df.show();

        // Total por categoria
        Dataset<Row> totalByCategory = df.groupBy("category")
                                         .agg(functions.sum("price").alias("total_value"),
                                              functions.avg("price").alias("avg_value"),
                                              functions.count("price").alias("count"));

        totalByCategory.show();

        totalByCategory.write().mode("overwrite").parquet("output/result");
        System.out.println("Aguardando para permitir cópia dos arquivos...");
        try { Thread.sleep(300000); } catch (InterruptedException e) {}
        spark.stop();
    }
}
