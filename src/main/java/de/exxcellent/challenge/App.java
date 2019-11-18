package de.exxcellent.challenge;

import de.exxcellent.challenge.resultCalculator.Football_Calculator;
import de.exxcellent.challenge.resultCalculator.Weather_Calculator;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code
        Weather_Calculator weatherCalculator = new Weather_Calculator("/home/paula/Desktop/todo/programming-challenge/src/main/resources/de/exxcellent/challenge/weather.csv");
        try {
            String dayWithSmallestTempSpread = weatherCalculator.calculate_Result();     // Your day analysis function call …
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        } catch (Exception x) {
            x.printStackTrace();
        }

        Football_Calculator footballCalculator = new Football_Calculator("/home/paula/Desktop/todo/programming-challenge/src/main/resources/de/exxcellent/challenge/football.csv");
        try {
            String teamWithSmallestGoalSpread = footballCalculator.calculate_Result(); // Your goal analysis function call …
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
