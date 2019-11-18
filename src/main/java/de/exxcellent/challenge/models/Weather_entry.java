package de.exxcellent.challenge.models;

/**
 * Model for one weather entry
 * @author Caroline Raether
 */
public class Weather_entry {
    // Attributes
    private int day; // Identifier

    private int Mxt; // Maximum temperature of day
    private int Mnt; // Minimum temperature of day

    /**
     * Construct one Weather entry with
     * @param entry_Day a day of the month
     * @param entry_Mxt maximum temperature of this day
     * @param entry_Mnt minimum temperature of this day
     */
    public Weather_entry(int entry_Day, int entry_Mxt, int entry_Mnt) {
        this.day = entry_Day;
        this.Mxt = entry_Mxt;
        this.Mnt = entry_Mnt;
    }

    // Methods

    /**
     *
     * @return the entry's day of the month
     */
    public int getDay() {
        return day;
    }

    /**
     *
     * @return the entry's maximum temperature of the day
     */
    public int getMxt() {
        return Mxt;
    }

    /**
     *
     * @return the entry's minimum temperature of the day
     */
    public int getMnT() {
        return Mnt;
    }

    /**
     * Computes the temperature spread
     * @return the entry's temperature spread between maximum and minimum temperature of the day
     */
    public int getTempDiff() {
        return Mxt - Mnt;
    }

}
