package open.jiot.OpenJIoT.Connectors;

import lombok.Getter;
import lombok.Setter;
import open.jiot.OpenJIoT.DTO.ConnectorRequestBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public final class Connector extends HashMap<String, Object>{
    private final String name = "mqtt-source-connector";
    private final String brokerAddr = "mqtt";
    public Connector(ConnectorRequestBody connectorRequestBody) {
        this(
                connectorRequestBody.getConnectorName(),
                connectorRequestBody.getMqttTopic(),
                connectorRequestBody.getKafkaTopic(),
                connectorRequestBody.getMqttClientId()
        );
    }

    public Connector(
            String connectorName,
            String mqttTopic,
            String kafkaTopic,
            String mqttClientId
    ) {
        this.initialize(
                connectorName,
                mqttTopic,
                kafkaTopic,
                mqttClientId
        );
    }
    private void initialize(
            String connectorName,
            String mqttTopic,
            String kafkaTopic,
            String mqttClientId
    ) {
        this.putAll(Map.of(
                "name", connectorName,
                "config", Map.of(
                        "connector.class", "aj.programming.MQTTConnector.Source.MQTTSourceConnector",
                        "mqtt.topic", mqttTopic,
                        "kafka.topic", "iot-stream",
                        "mqtt.clientID", mqttClientId,
                        "mqtt.broker",String.format("tcp://%s:1883", this.brokerAddr),
                        "key.converter","org.apache.kafka.connect.storage.StringConverter",
                        "key.converter.schemas.enable",false,
                        "value.converter","org.apache.kafka.connect.storage.StringConverter",
                        "value.converter.schemas.enable",false
                )
        ));
    }
}
