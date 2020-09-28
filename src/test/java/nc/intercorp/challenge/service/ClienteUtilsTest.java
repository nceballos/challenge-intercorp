package nc.intercorp.challenge.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClienteUtilsTest {

    private ClienteUtils utils;

    @BeforeEach
    void setup() {
        this.utils = new ClienteUtils();
    }

    @Test
    void getAge() {
        final int expectedAge = 20;
        final LocalDate birthDate = LocalDate.of(2000, 4, 16);
        final LocalDate currentDate = LocalDate.of(2020, 9, 27);
        final int actualAge = this.utils.getAge(birthDate, currentDate);
        assertEquals(expectedAge, actualAge);
    }

    @Test
    void predictDayOfDeathFromPast() {
        final LocalDate birthDate = LocalDate.of(1920, 1, 23);
        final LocalDate dayOfDeath = utils.predictDayOfDeath(birthDate);
        assertTrue(dayOfDeath.isAfter(birthDate));
        assertTrue(dayOfDeath.isBefore(LocalDate.now()));
    }

    @Test
    void predictDayOfDeathFromFuture() {
        final LocalDate birthDate = LocalDate.of(1970, 7, 14);
        final LocalDate dayOfDeath = utils.predictDayOfDeath(birthDate);
        assertTrue(dayOfDeath.isAfter(birthDate));
        assertTrue(dayOfDeath.isAfter(LocalDate.now()));
    }
}