# Springboot AND apache-kafka

This guide provides instructions for installing and running Apache Kafka on a Linux system with SpringBoot.
About ApacheKafka: https://github.com/lumakos/apache-kafka-101 

### Start Zookeeper and Kafka

Apache Kafka requires Zookeeper to run. You will need to open two separate terminal windows for this process.

* **Terminal 1 (Start Zookeeper):**
    ```sh
    zookeeper-server-start.sh /opt/kafka/config/zookeeper.properties
    ```
* **Terminal 2 (Start Kafka):**
    ```sh
    kafka-server-start.sh /opt/kafka/config/server.properties
    ```

---

### Project Setup
First, you'll need a Spring Boot project. The easiest way to create one is by using the Spring Initializr.

1. Go to https://start.spring.io/.

2. Add the following dependencies:

- Spring Web: For building REST APIs (optional, but useful for a simple producer endpoint).

- Spring for Apache Kafka: This is the core dependency for Kafka integration.

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
http://localhost:8080/send?message=Hello%20Kafka


### Check terminal for producer messages and consumer messages