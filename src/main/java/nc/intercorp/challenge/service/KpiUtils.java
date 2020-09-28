package nc.intercorp.challenge.service;

import nc.intercorp.challenge.api.response.ClienteResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KpiUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(KpiUtils.class);

    /**
     * Method that calculates the average age for a given list of clients.
     * We assume we dont need decimals
     * @param allClientes the list of clients
     * @return the average age without decimals
     */
    public Integer calculateAverageAge(List<ClienteResponse> allClientes) {
        int total = 0;
        for (ClienteResponse client: allClientes) {
            total += client.getEdad();
        }
        int average = total / allClientes.size();
        LOGGER.info("Calculated average: {}", average);
        return average;
    }

    /**
     * Method that calculates the standard deviation age for a given list of clients.
     * We assume we dont need decimals
     * @param allClientes the list of clients
     * @return the standard deviation without decimals
     */
    public Integer calculateStandardDeviation(List<ClienteResponse> allClientes) {
        int sd = 0;
        double dif = 0;
        double sumDif = 0;
        int average = this.calculateAverageAge(allClientes);

        for (ClienteResponse client: allClientes) {
            dif = Math.pow(average - client.getEdad(),2);
            sumDif += dif;
        }
        sd = (int) Math.sqrt(sumDif/allClientes.size());
        LOGGER.info("Calculated standard deviation: {}", sd);
        return sd;
    }

}
