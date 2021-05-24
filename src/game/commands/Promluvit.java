package game.commands;

import game.Game;
import game.Goals;
import game.Inventory;
import game.types.Npc;
import ui.ColorCodes;

/******************************************************************************
 * Provedení příkazu vrátí konverzaci s postavou v daném prostoru.
 *
 * Implementuje: ICommand
 ******************************************************************************/

public record Promluvit(Game game, String description) implements ICommand {

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String execute(String[] params) {
		Npc npc = game.getGamePlan().getCurrentRoom().getNpc();

		if (npc == null)
			return ColorCodes.RED + "V tomto prostoru si nemáš s kým promluvit." + ColorCodes.RESET;

		String questItem = npc.getQuestItem();
		Inventory inventory = game().getInventory();

		if (npc.getStatus() == Npc.QuestStatus.TAKEN && inventory.containsItem(questItem)) {
			inventory.removeItem(questItem);
			npc.setStatus(Npc.QuestStatus.COMPLETED);
		}

		String returned = npc.getDialogue();
		String completed = "";


		// Pouze v poslední místnosti
		if (questItem.isEmpty())
			if (checkForQuestCompletion()) {
				game.setStatus(Game.GameStatus.COMPLETED);
				return game.getGoals().complete("boss");
			} else {
				game.setStatus(Game.GameStatus.FAILED);
				return game.getGoals().fail("boss");
			}


		if (npc.getStatus() == Npc.QuestStatus.NEW)
			npc.setStatus(Npc.QuestStatus.TAKEN);

		if (npc.getStatus() == Npc.QuestStatus.COMPLETED) {
			completed = game.getGoals().complete(npc.getQuestItem());
			npc.setStatus(Npc.QuestStatus.RETIRED);
		}

		return "seq" + npc + ": " + returned + completed;
	}

	private boolean checkForQuestCompletion() {
		Goals goals = game.getGoals();

		return goals.isCompleted("doktorzhor") &&
				goals.isCompleted("zradloanoviny") &&
				goals.isCompleted("licence");
	}
}
