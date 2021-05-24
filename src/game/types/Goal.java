package game.types;

import ui.ColorCodes;

/******************************************************************************
 *
 ******************************************************************************/

public class Goal {
    private final String goal;
    private final String onFailiure;
    private final String onCompletion;

    private boolean completed;

    public Goal(String goal, String onFailiure, String onCompletion) {
        this.goal = goal;
        this.onFailiure = onFailiure;
        this.onCompletion = onCompletion;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String complete() {
        completed = true;

        return ColorCodes.GREEN_BOLD + "\nÚkol splněn: " + onCompletion + ColorCodes.RESET;
    }

    public String fail() {
        return onFailiure;
    }

    @Override
    public String toString() {
        return goal;
    }
}
