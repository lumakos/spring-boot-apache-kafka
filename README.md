# Spring Boot and Apache Kafka

This guide explains how to run and send messages with Spring Boot using Apache Kafka on a Linux system.

About ApacheKafka: https://github.com/lumakos/apache-kafka-101 

### Stack
<b><u>
Gradle (Groovy DSL) 

Spring Boot 3.5.4 

Java 17

Apache Kafka 3.5.0</u></b>

### Start Zookeeper and Kafka

Apache Kafka requires Zookeeper to run. You will need to open two separate terminal windows for this process.


```
docker-compose up -d
```
---

### Project Setup
First, you'll need a Spring Boot project. The easiest way to create one is by using the Spring Initializr.

1. Go to https://start.spring.io/.

2. Add the following dependencies:

- <b>Spring Web</b>: For building REST APIs (optional, but useful for a simple producer endpoint)

- <b>Spring for Apache Kafka</b>: This is the core dependency for Kafka integration.

3.  Configuration
Spring Boot automatically detects the Kafka configuration in your application.properties file. You need to specify the bootstrap servers to connect to your Kafka cluster.

    <b>src/main/resources/application.properties</b>

    ```
    spring.kafka.bootstrap-servers=localhost:9092
    ```


### Run your Spring Boot application
```
./gradlew bootRun
```

### Now, open your browser and navigate to:
```
curl -X POST http://localhost:8080/api/transactions \
  -H "Content-Type: application/json" \
  -d '{
    "transactionId":"tx-123",
    "accountId":"acct-1",
    "amount": 15000.00,
    "currency": "EUR",
    "timestamp": "2025-08-10T12:30:00Z",
    "merchant":"BigStore",
    "location":"Athens"
  }'
```


### Check terminal for producer messages and consumer messages