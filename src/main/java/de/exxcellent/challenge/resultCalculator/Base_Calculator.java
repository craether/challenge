package de.exxcellent.challenge.resultCalculator;


import de.exxcellent.challenge.CSV_Reader;

/**
 * Abstract Base class for calculators
 * @author Caroline Raether
 */
public abstract class Base_Calculator {
    protected String file_name;
    protected CSV_Reader csv_reader; // the reader for the csv file

    /**
     * Constructor
     * @param file_name name of the input csv file for the calculation
     */
    public Base_Calculator(String file_name) {
        this.csv_reader = new CSV_Reader();
        this.file_name = file_name;
    }

    /**
     * Abstract method to be implemented in the actual result calculators
     * @return the string of the calculated result
     */
    public abstract String calculate_Result() throws Exception;
}
