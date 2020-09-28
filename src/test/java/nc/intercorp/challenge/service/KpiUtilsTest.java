package nc.intercorp.challenge.service;

import nc.intercorp.challenge.api.response.ClienteResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KpiUtilsTest {
    private KpiUtils kpiUtils;

    @BeforeEach
    void setUp() {
        kpiUtils = new KpiUtils();
    }

    @Test
    void calculateAverageAge() {
        int expectedAverage = 40;
        int actualAverage = kpiUtils.calculateAverageAge(getMockedClientList());
        assertEquals(expectedAverage, actualAverage);
    }

    @Test
    void calculateStandardDeviation() {
        int expectedSd = 10;
        int actualSd = kpiUtils.calculateStandardDeviation(getMockedClientList());
        assertEquals(expectedSd, actualSd);
    }

    private List<ClienteResponse> getMockedClientList() {
        var allClients = new ArrayList<ClienteResponse>();
        // for this testing purpose, we just need to set the age
        ClienteResponse client1 = new ClienteResponse();
        client1.setEdad(40);
        allClients.add(client1);

        ClienteResponse client2 = new ClienteResponse();
        client2.setEdad(28);
        allClients.add(client2);

        ClienteResponse client3 = new ClienteResponse();
        client3.setEdad(53);
        allClients.add(client3);

        return allClients;
    }
}