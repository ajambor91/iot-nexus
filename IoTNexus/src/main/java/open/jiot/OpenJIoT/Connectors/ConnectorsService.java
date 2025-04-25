package open.jiot.OpenJIoT.Connectors;

import open.jiot.OpenJIoT.DTO.ConnectorRequestBody;
import open.jiot.OpenJIoT.Services.RestClient;
import org.springframework.stereotype.Component;

@Component
public class ConnectorsService {

    private final RestClient restClient;
    private final ConnectorsKafkaService connectorsKafkaService;
    public ConnectorsService(RestClient restClient, ConnectorsKafkaService connectorsKafkaService) {
        this.restClient = restClient;
        this.connectorsKafkaService = connectorsKafkaService;
    }

    public void addConnector(ConnectorRequestBody connectorRequestBody) {
        Connector connector = new Connector(connectorRequestBody);
        System.out.println(connector.values());
        this.restClient.sendRequest("http://connectors:8083/connectors", connector);
    }
}
