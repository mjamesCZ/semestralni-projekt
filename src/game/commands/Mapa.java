package game.commands;

import game.GamePlan;
import game.types.Room;
import ui.ColorCodes;

import java.util.ArrayList;

/******************************************************************************
 * Provedení příkazu vrátí aktuální mapu se zvýrazněním aktuální místnosti.
 *
 * Implementuje: ICommand
 ******************************************************************************/

public record Mapa(GamePlan gamePlan, String description) implements ICommand {

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String execute(String[] params) {
		return getMap(gamePlan);
	}

	private String getMap(GamePlan gamePlan) {
		ArrayList<String> symbols = new ArrayList<>();
		ArrayList<String> names = new ArrayList<>();
		ArrayList<String> indicators = new ArrayList<>();

		Room currentRoom = gamePlan.getCurrentRoom();

		for (Room room : gamePlan.getRooms()) {
			String roomName = "";
			String roomIndicator = " ";

			if (room == currentRoom) {
				roomName += ColorCodes.YELLOW_BOLD_BRIGHT;
				roomIndicator = ColorCodes.PURPLE_BOLD_BRIGHT + "^" + ColorCodes.RESET;
			}

			if (currentRoom.getNeighbours().contains(room))
				roomName += ColorCodes.CYAN_BRIGHT;

			roomName += room.getName() + ColorCodes.RESET;

			symbols.add(room.getSymbol());
			names.add(roomName);
			indicators.add(roomIndicator);
		}


		return String.format("""
                                                    
                                                    =============================
                                                    [     %s      |     %s      ]
                                                    [     %s     |    %s     ]
                                                    [      %s      |      %s      ]
                                =============       =============================================
                                [     %s️      |______[     %s      |     %s      |      %s       ]
                \033[1;95mMAPA:\033[0m           [   %s   | _ _ _[   %s   |    %s     |   %s   ]
                                [     %s      |______[      %s      |      %s      |       %s       ]
                                =============       =============================================
                                                    [     %s      |      %s     ]
                                                    [   %s   |   %s  ]
                                                    [      %s      |      %s      ]
                                                    =============================
                                                    
                """,
				// First row
				symbols.get(0), symbols.get(1),
				names.get(0), names.get(1),
				indicators.get(0), indicators.get(1),

				// Second row
				symbols.get(2), symbols.get(3), symbols.get(4), symbols.get(5),
				names.get(2), names.get(3), names.get(4), names.get(5),
				indicators.get(2), indicators.get(3), indicators.get(4), indicators.get(5),

				// Third row
				symbols.get(6), symbols.get(7),
				names.get(6), names.get(7),
				indicators.get(6), indicators.get(7)
		);
	}

}
