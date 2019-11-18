package de.exxcellent.challenge;

import de.exxcellent.challenge.models.Football_entry;
import de.exxcellent.challenge.models.Weather_entry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Class for reading data
 * @author Caroline Raether
 */
public class CSV_Reader {
    private final String SEPARATING_CHARACTER = ","; // the separator for a csv file

    // Column Positions for values
    //Weather: Day,MxT,MnT,AvT,AvDP,1HrP TPcpn,PDir,AvSp,Dir,MxS,SkyC,MxR,Mn,R AvSLP
    private final int INDEX_WEATHER_DAY = 0;
    private final int INDEX_WEATHER_MXT = 1;
    private final int INDEX_WEATHER_MNT = 2;

    // Football: Team,Games,Wins,Losses,Draws,Goals,Goals Allowed,Points
    private final int INDEX_FOOTBALL_TEAM = 0;
    private final int INDEX_FOOTBALL_GOALS = 5;
    private final int INDEX_FOOTBALL_GOALS_ALLOWED = 6;

    /**
     * Constructor
     */
    public CSV_Reader() {}

    /**
     *
     * @param file_name the input file to be read
     * @return an array list containing the lines of the processed file as string arrays (one string per value)
     * @throws Exception if something goes wrong
     */
    private ArrayList<String[]> readCSV(String file_name) throws Exception {
        BufferedReader csvReader = new BufferedReader(new FileReader(file_name)); // Open file with given file_name

        // Variables
        String row;
        ArrayList<String[]> result = new ArrayList<>();

        // Read the file line by line
        while ((row = csvReader.readLine()) != null) {
            result.add(row.split(SEPARATING_CHARACTER)); // add tokenized lines to result
        }
        csvReader.close(); // close the file after reading
        return result; //return the result
    }

    /**
     * read in the weather data and return
     * @param file_name of the data to be read
     * @return an array of weather entries
     * @throws Exception
     */
    public Weather_entry[] readWeatherData(String file_name) throws Exception{
        // read the Csv file
        ArrayList<String[]> raw_data = readCSV(file_name);

        Weather_entry[] result = new Weather_entry[raw_data.size() - 1]; // First line is the header and will be skipped

        // assign to Weather_entry
        for (int i =1; i<raw_data.size(); i++){ // skip first line
            String[] line = raw_data.get(i);  // read the entry

            // Parse
            int day = Integer.parseInt(line[INDEX_WEATHER_DAY]);
            int mxt = Integer.parseInt(line[INDEX_WEATHER_MXT]);
            int mnt = Integer.parseInt(line[INDEX_WEATHER_MNT]);

            result[i -1] = new Weather_entry(day, mxt, mnt); // construct the weather entry
        }

        return result;
    }

    /**
     * read in the football data from file_name
     * @param file_name of the data to be read
     * @return an array of football entries
     * @throws Exception
     */
    public Football_entry[] readFootballData(String file_name) throws Exception{
        // read the Csv file
        ArrayList<String[]> raw_data = readCSV(file_name);

        Football_entry[] result = new Football_entry[raw_data.size() -1]; // First line is the header and will be skipped

        // assign to Football entry
        for (int i =1; i<raw_data.size(); i++){ // skip first line
            String[] line = raw_data.get(i);  // read the entry

            // Parse
            String team = line[INDEX_FOOTBALL_TEAM];
            int goals = Integer.parseInt(line[INDEX_FOOTBALL_GOALS]);
            int goals_allowed = Integer.parseInt(line[INDEX_FOOTBALL_GOALS_ALLOWED]);

            result[i -1] = new Football_entry(team, goals, goals_allowed); // construct the weather entry
        }

        return result;
    }

}
