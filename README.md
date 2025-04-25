# IoT Nexus

**Date of documentation creation:** 05.05.2025
**Author:** Adam Jambor
**Version:** 1

## Introduction

This project aims to create a scalable and efficient system for real-time processing of data from various MQTT sensor. The system enables industrial companies to monitor machine status and detect potential failures early, minimizing downtime and optimizing maintenance costs. It is based on a microservice architecture for flexibility and scalability. Data from MQTT sensors are received by a dedicated MQTT Broker and reliably transmitted via an MQTT Connector for the Confluent Kafka ecosystem to the central Kafka message broker. Data streams are processed and analyzed in real-time using Kafka Streams, allowing for quick reactions to detected events. Analysis results are stored in Elasticsearch for effective searching and visualization in Kibana dashboards, and in a PostgreSQL relational database for long-term archiving and advanced queries. An Angular-based user interface provides intuitive data visualization and system interaction.

## Components

* **MQTT Broker:** Accepts connections from MQTT clients, handles authentication and authorization, routes messages based on topics, and maintains client sessions.
* **MQTT Connector for Confluent Kafka (Kafka Connects):** Receives data from the MQTT broker, authorizes connector-broker sessions, and sends data to the Kafka broker.
* **Kafka Broker:** The central message bus, a distributed queuing system based on the publish-subscribe model, designed for high-throughput, low-latency real-time data streams.
* **Kafka Streams:** A library for building applications and microservices that process data streams stored in Apache Kafka. It subscribes to Kafka topics with sensor data and processing rules from PostgreSQL to process data in real-tim.
* **PostgreSQL:** A relational database used for storing user data, data processing rules for Kafka Streams, and information about registered MQTT sensors.
* **Elasticsearch:** A distributed, Lucene-based search and analytical NoSQL database used for storing processed and aggregated analytical data from Kafka Streams.
* **Kibana:** A data visualization and exploration tool that works with Elasticsearch, serving as the main user interface for analyzing data collected in Elasticsearch.
* **Angular:** A framework for building client-side user interfaces, used for an administrative panel to manage users, sensors, and processing rules. It can also potentially serve as an alternative interface for data visualization and analysi.

## Potential Applications

The project can be useful in various areas, including:

* **Smart Homes:** Monitoring energy consumption, security systems, lighting, and heating automation.
* **Industry:** Monitoring machine status, predictive maintenance, quality control, and production volume monitoring.
* **Agriculture:** Monitoring soil moisture and automating irrigation systems.
* **Cybersecurity:** Detecting anomalies in MQTT networks and other devices.
* **Medicine:** Monitoring patient health status and the technical condition of medical equipment.
* **Military:** Collecting data from field sensors, monitoring logistics, and collecting data from soldiers' personal equipment.

## Current Project Progress

* Implementation of the MQTT protocol for the Broker has been completed
* Full implementation of the MQTT Connector with unit tests is finished
* Integration of the Connector with Kafka Connect has been completed
* Integration of the Kafka ecosystem (Kafka Connects, Kafka, Kafka Streams) has been completed

## Get Started

1.  **Clone this repository**
2.  **Build the project**
    ```bash
    docker-compose build
    ```
3.  **Run docker in detached mode**
    ```bash
    docker-compose up -d
    ```
4.  **Add Source Connector to Kafka Connect**
    To add the connector, you need to make a POST request to `http://localhost:81/connectors` with the following payload:
    ```bash
        {
            "name": "SourceConnector",
            "config": {
                "connector.class": "aj.programming.MQTTConnector.Source.MQTTSourceConnector",
                "mqtt.clientId": "clientId",
                "mqtt.topic": "test-topic",
                "mqtt.broker": "tcp://mqtt-mosquitto:1883",
                "kafka.server": "http://kafka-broker:9092",
                "kafka.topic": "iot-topic",
                "uniqueId": "uniqueId"
            }
        }
    ```
5.  **Send an MQTT Message from any MQTT client to `tcp://localhost:1883`**

## Connector

More information about the connector can be found at https://github.com/ajambor91/mqtt-kafka-jconnector
In this project, all requests for Kafka Connect should be made to `http://localhost:81`.
Bin MQTTConnector files are attached to this project in `IoTKafkaConnet/bin`, and built package is placed in `IoTKafkaConnet/connector`

## Broker

Currently, the project utilizes the MQTT Mosquitto Broker, but in the future, Mosquitto will be replaced by our own broker, which can be found at https://github.com/ajambor91/jqtt, but broker is attached at this project in `IoTScratchBroker` directory.

## Important

**Note:** This project is not production-ready. At this moment, it only supports sending MQTT messages and handling them via Kafka Connect. Current development is focusing on passing messages to Kafka Streams.