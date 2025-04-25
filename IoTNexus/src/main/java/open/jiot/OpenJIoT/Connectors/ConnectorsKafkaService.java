package open.jiot.OpenJIoT.Connectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class ConnectorsKafkaService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    @Autowired
    public ConnectorsKafkaService(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendConnectorMessage(Connector connector) throws JsonProcessingException {
        String message = this.objectMapper.writeValueAsString(connector);
        this.sendMessage(message);
    }

    private void sendMessage(String message) {
        Message<String> kafkaMessage = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, "request-add-connector")
                .build();
        this.kafkaTemplate.send(kafkaMessage);
    }
}
