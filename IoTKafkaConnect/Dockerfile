FROM confluentinc/cp-kafka-connect

ENV CONNECT_BOOTSTRAP_SERVERS=kafka-broker-1:9092,kafka-broker-2:9092,kafka-broker-3:9092
ENV CONNECT_REST_PORT=8083
ENV CONNECT_GROUP_ID=connect-cluster
ENV CONNECT_CONFIG_STORAGE_TOPIC=quickstart-config
ENV CONNECT_OFFSET_STORAGE_TOPIC=quickstart-offsets
ENV CONNECT_STATUS_STORAGE_TOPIC=quickstart-status
ENV CONNECT_CONFIG_STORAGE_REPLICATION_FACTOR=3
ENV CONNECT_OFFSET_STORAGE_REPLICATION_FACTOR=3
ENV CONNECT_PLUGIN_PATH=/usr/share/kafka-connect-mqtt
ENV CONNECT_STATUS_STORAGE_REPLICATION_FACTOR=3
ENV CONNECT_KEY_CONVERTER=org.apache.kafka.connect.storage.StringConverter
ENV CONNECT_VALUE_CONVERTER=org.apache.kafka.connect.storage.StringConverter
ENV CONNECT_INTERNAL_KEY_CONVERTER=org.apache.kafka.connect.json.JsonConverter
ENV CONNECT_INTERNAL_VALUE_CONVERTER=org.apache.kafka.connect.json.JsonConverter
ENV CONNECT_REST_ADVERTISED_HOST_NAME=kafka-connect
COPY ./connector/kafka-connect-mqtt-1.1.0-package/mqtt /usr/share/kafka-connect-mqtt