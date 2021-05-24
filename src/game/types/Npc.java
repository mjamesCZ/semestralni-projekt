package game.types;

import game.types.Item;
import ui.ColorCodes;

public class Npc {
    private final String name;

    private final String[] dialogues;
    private final String questItemName;

    private QuestStatus status = QuestStatus.NEW;
    public enum QuestStatus {
        NEW,
        TAKEN,
        COMPLETED,
        RETIRED
    }

    public Npc(String name, String[] dialogues, String questItemName) {
        this.name = name;
        this.dialogues = dialogues;
        this.questItemName = questItemName;
    }


    public String getName() {
        return name;
    }

    public QuestStatus getStatus() {
        return status;
    }

    public void setStatus(QuestStatus status) {
        this.status = status;
    }

    public String getDialogue() {
        return switch (status) {
            case NEW -> dialogues[0];
            case TAKEN -> dialogues[1];
            case COMPLETED -> dialogues[2];
            case RETIRED -> dialogues[3];
        };
    }

    public String getQuestItem() {
        return questItemName;
    }

    @Override
    public String toString() {
        return ColorCodes.PURPLE_UNDERLINED + name + ColorCodes.RESET;
    }
}
