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
                                         .agg(functions.sum("value").alias("total_value"),
                                              functions.avg("value").alias("avg_value"),
                                              functions.count("value").alias("count"));

        totalByCategory.show();

        totalByCategory.write().mode("overwrite").parquet("output/result");
        spark.stop();
    }
}
