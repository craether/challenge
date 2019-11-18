package de.exxcellent.challenge.models;

/**
 * Modell for one football entry
 * @author Caroline Raether
 */
public class Football_entry {
    // Attributes
    private String team; // the name of the football team
    private int goals; //the number of goals the football team scored
    private int goals_allowed; //the number of goals the football team allowed in

    /**
     * Constructor from one line in the data
     * @param entry_team the name of the football team
     * @param entry_goals the number of goals the football team scored
     * @param entry_goals_allowed the number of goals the football team allowed in
     */
    public Football_entry(String entry_team, int entry_goals, int entry_goals_allowed) {
        this.team = entry_team;
        this.goals = entry_goals;
        this.goals_allowed = entry_goals_allowed;
    }

    // Methods

    /**
     * Getter
     * @return the team name of the entry
     */
    public String getTeam() {
        return team;
    }

    /**
     * Getter
     * @return the goals from the team
     */
    public int getGoals() {
        return goals;
    }

    /**
     * Getter
     * @return the goals that the team allowed in
     */
    public int getGoals_allowed() {
        return goals_allowed;
    }

    /**
     * Compute the goal difference between goals and goals_allowed
     * @return the absolute goal difference
     */
    public int getGoalDiff() {
        return Math.abs(goals - goals_allowed);
    }
}
