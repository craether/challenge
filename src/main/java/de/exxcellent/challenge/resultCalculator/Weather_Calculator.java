package de.exxcellent.challenge.resultCalculator;

import de.exxcellent.challenge.CSV_Reader;
import de.exxcellent.challenge.models.Weather_entry;

/**
 * Model for calculations based on weather data
 * @author Caroline Raether
 */
public class Weather_Calculator extends Base_Calculator{

    /**
     * Constructor based on super class constructor
     * @param file_name input file name of the csv file
     */
    public Weather_Calculator(String file_name) {
        super(file_name);
    }

    /**
     * Find the day with the minimal temeprature spread
     * @return the result string for the weather task
     */
    @Override
    public String calculate_Result() throws Exception {
        Weather_entry[] data = csv_reader.readWeatherData(this.file_name); // read data from file

        Weather_entry min = data[0]; // the weather entry with the minimum temeprature spread
        for(Weather_entry current:data){ // walk over data
            if (current.getTempDiff() < min.getTempDiff()) { // find minimum
                min = current;
            }
        }
        return Integer.toString(min.getDay()); // return the day
    }
}
