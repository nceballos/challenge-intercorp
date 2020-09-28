package nc.intercorp.challenge.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nc.intercorp.challenge.api.request.CreateClienteRequest;
import nc.intercorp.challenge.api.response.ClienteResponse;
import nc.intercorp.challenge.api.response.KpiResponse;
import nc.intercorp.challenge.api.response.WrapperResponse;
import nc.intercorp.challenge.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Cliente")
@RestController
@RequestMapping("/")
public class ClienteController {

    private ClienteService clienteService;

    @ApiOperation(value = "Alta de clientes")
    @PostMapping(value = "creacliente")
    public ResponseEntity<WrapperResponse<ClienteResponse>> create(@Valid @RequestBody CreateClienteRequest request) {
        WrapperResponse<ClienteResponse> response = new WrapperResponse();
        response.setApiResponse(clienteService.createCliente(request));
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Lista de todos los clientes")
    @GetMapping(value = "listclientes")
    public ResponseEntity<WrapperResponse<List<ClienteResponse>>> getAll() {
        WrapperResponse<List<ClienteResponse>> response = new WrapperResponse();
        response.setApiResponse(clienteService.getAllClientes());
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Lista de kpis")
    @GetMapping(value = "kpideclientes")
    public ResponseEntity<WrapperResponse<KpiResponse>> getKpis() {
        WrapperResponse<KpiResponse> response = new WrapperResponse();
        response.setApiResponse(clienteService.getKpis());
        return ResponseEntity.ok(response);
    }


    @Autowired
    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
}
