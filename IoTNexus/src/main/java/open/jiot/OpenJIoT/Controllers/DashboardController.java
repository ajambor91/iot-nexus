package open.jiot.OpenJIoT.Controllers;


import jakarta.validation.Valid;
import open.jiot.OpenJIoT.Connectors.ConnectorsService;
import open.jiot.OpenJIoT.DTO.ConnectorRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DashboardController {

    private final ConnectorsService connectorsService;

    @Autowired
    public DashboardController(ConnectorsService connectorsService) {
        this.connectorsService = connectorsService;
    }

    @PostMapping("/create-connector")
    public ResponseEntity<?> createConnector(@RequestBody @Valid ConnectorRequestBody connectorRequestBody) {
        this.connectorsService.addConnector(connectorRequestBody);

        return ResponseEntity.ok(200);
    }
}
