package de.pqul2183.backend.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
public class DeliveryTimeService {

    private static final Map<String, String> COUNTRY_TO_CONTINENT = new HashMap<>();
    static {
        
        COUNTRY_TO_CONTINENT.put("GERMANY", "EUROPE");
        COUNTRY_TO_CONTINENT.put("FRANCE", "EUROPE");
        COUNTRY_TO_CONTINENT.put("NETHERLANDS", "EUROPE");
        COUNTRY_TO_CONTINENT.put("USA", "AMERICA");
        COUNTRY_TO_CONTINENT.put("TURKEY", "ASIA");
        COUNTRY_TO_CONTINENT.put("AUSTRIA", "EUROPE");
       }

    public int calculateDays(City origin, City destination, FreightType type) {
        if (origin == null || destination == null || type == null) {
            throw new IllegalArgumentException("origin, destination and type must not be null");
        }

        String oCountry = safeUpper(origin.getCountry());
        String dCountry = safeUpper(destination.getCountry());

        boolean sameCountry = !oCountry.isEmpty() && oCountry.equals(dCountry);

        String oCont = COUNTRY_TO_CONTINENT.getOrDefault(oCountry, "UNKNOWN");
        String dCont = COUNTRY_TO_CONTINENT.getOrDefault(dCountry, "UNKNOWN");
        boolean sameContinent = !oCont.equals("UNKNOWN") && oCont.equals(dCont) && !sameCountry;

        int min, max;
        if (sameCountry) {
            if (type == FreightType.AIR) { min = 1; max = 1; }
            else { min = 3; max = 3; }
        } else if (sameContinent) {
            if (type == FreightType.AIR) { min = 2; max = 3; }
            else { min = 7; max = 10; }
        } else {
            if (type == FreightType.AIR) { min = 5; max = 7; }
            else { min = 20; max = 35; }
        }

        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private String safeUpper(String s) {
        return s == null ? "" : s.trim().toUpperCase();
    }
}