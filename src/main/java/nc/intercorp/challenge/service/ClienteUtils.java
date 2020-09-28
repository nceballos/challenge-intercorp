package nc.intercorp.challenge.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ClienteUtils {
    public static final int LIFE_EXPECTANCY = 90;

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteUtils.class);


    /**
     * Method that predicts dates of death in the future or in the past, according the person's age
     * @param birthDate the person's day of birth
     * @return the predicted day of death
     */
    public LocalDate predictDayOfDeath(LocalDate birthDate) {
        if (getAge(birthDate, LocalDate.now()) > LIFE_EXPECTANCY) {
            //Client is probably already dead
            return getPastDayOfDeath(birthDate);
        }
        return getFutureDayOfDeath(birthDate);
    }

    public int getAge(LocalDate birthDate, LocalDate currentDate) {
        return Period.between(birthDate, currentDate).getYears();
    }

    /**
     * Method used to calculate possible day of death in the future. That date will be generated
     * between years 2021 and 2060, month 1 to 12 and days 1 to 30.
     * It will assume no one could live more years than the life expectancy set on LIFE_EXPECTANCY.
     * @param birthDate the person's day of birth
     * @return the predicted day of death in the future
     */
    private LocalDate getFutureDayOfDeath(LocalDate birthDate) {
        return getDayOfDeath(birthDate, 2021, 2061);
    }

    /**
     * Method used to generate possible day of death in the past, assuming that the client lived at least 20 years
     * and no more than 80
     * @param birthDate the person's day of birth
     * @return the predicted day of death in the past
     */
    private LocalDate getPastDayOfDeath(LocalDate birthDate) {
        int yearOfBirth = birthDate.getYear();
        return getDayOfDeath(birthDate, yearOfBirth + 20, yearOfBirth + 81);
    }


    private LocalDate getDayOfDeath(LocalDate birthDate, int yearFrom, int yearTo) {
        LocalDate deathDate;
        int ageAtDeath;
        do {
            int yearOfDeath = ThreadLocalRandom.current().nextInt(yearFrom, yearTo);
            int monthOfDeath = ThreadLocalRandom.current().nextInt(1, 13);
            int dayOfDeath = ThreadLocalRandom.current().nextInt(1, 31);
            deathDate = LocalDate.of(yearOfDeath, monthOfDeath, dayOfDeath);
            ageAtDeath = getAge(birthDate, deathDate);
            LOGGER.info("Generated date of death: {}", deathDate);

        } while (ageAtDeath > LIFE_EXPECTANCY);

        return deathDate;
    }

}
