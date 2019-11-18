package de.exxcellent.challenge.resultCalculator;

import de.exxcellent.challenge.models.Football_entry;

/**
 * Model for calculations based on football entries
 * @author Caroline Raether
 */
public class Football_Calculator extends Base_Calculator{

    /**
     * Constructor using the super class constructor
     * @param file_name input file name of the csv file
     */
    public Football_Calculator(String file_name) {
        super(file_name);
    }


    /**
     * Method for reading the football data and calculating the minimal distance between goals and goals allowed
     * for all football entries
     * @return the team with the minimal distance
     * @throws Exception
     */
    @Override
    public String calculate_Result() throws Exception {
        Football_entry[] data = csv_reader.readFootballData(this.file_name); // read data from file

        Football_entry min = data[0];
        for(Football_entry current:data) { // walk over data
            if (current.getGoalDiff() < min.getGoalDiff() ) {
                min = current; // find minimum
            }
        }

        return min.getTeam();
    }
}
