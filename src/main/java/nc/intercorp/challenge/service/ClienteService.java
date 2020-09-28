package nc.intercorp.challenge.service;

import nc.intercorp.challenge.api.request.CreateClienteRequest;
import nc.intercorp.challenge.api.response.ClienteResponse;
import nc.intercorp.challenge.api.response.KpiResponse;
import nc.intercorp.challenge.model.Cliente;
import nc.intercorp.challenge.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private ClienteUtils clienteUtils;
    private KpiUtils kpiUtils;

    public ClienteResponse createCliente(CreateClienteRequest request) {
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombre(request.getNombre());
        nuevoCliente.setApellido(request.getApellido());
        nuevoCliente.setNacimiento(request.getFechaNacimiento());

        final Cliente saved = clienteRepository.save(nuevoCliente);
        return mapClienteToResponse(saved, false);
    }

    public List<ClienteResponse> getAllClientes() {
        List<ClienteResponse> allClients = new ArrayList<>();
        clienteRepository.findAll().forEach(cliente -> allClients.add(mapClienteToResponse(cliente, true)));
        return allClients;
    }

    private ClienteResponse mapClienteToResponse(Cliente cliente, boolean predictDeath) {
        ClienteResponse response = new ClienteResponse();
        response.setNombre(cliente.getNombre());
        response.setApellido(cliente.getApellido());
        response.setFechaNacimiento(cliente.getNacimiento());
        if (predictDeath) {
            response.setFechaProbableMuerte(clienteUtils.predictDayOfDeath(cliente.getNacimiento()));
        }
        int currentAge = clienteUtils.getAge(cliente.getNacimiento(), LocalDate.now());
        if (currentAge > clienteUtils.LIFE_EXPECTANCY) {
            //Assuming that the client is already dead, so setting age at the moment of passing away
            response.setEdad(clienteUtils.getAge(cliente.getNacimiento(), response.getFechaProbableMuerte()));
        }
        else {
            response.setEdad(currentAge);
        }

        return response;
    }

    public KpiResponse getKpis() {
        KpiResponse kpis = new KpiResponse();
        var allClientes = this.getAllClientes();
        kpis.setPromedioEdad(kpiUtils.calculateAverageAge(allClientes));
        kpis.setDesvEstandarEdad(kpiUtils.calculateStandardDeviation(allClientes));

        return kpis;

    }

    @Autowired
    public void setClienteRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Autowired
    public void setClienteUtils(ClienteUtils clienteUtils) {
        this.clienteUtils = clienteUtils;
    }

    @Autowired
    public void setKpiUtils(KpiUtils kpiUtils) {
        this.kpiUtils = kpiUtils;
    }
}
