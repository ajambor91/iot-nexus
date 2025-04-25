package open.jiot.OpenJIoT.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConnectorRequestBody {
    private String connectorName;
    private String mqttTopic;
    private String kafkaTopic;
    private String mqttClientId;

    public ConnectorRequestBody() {}
}
