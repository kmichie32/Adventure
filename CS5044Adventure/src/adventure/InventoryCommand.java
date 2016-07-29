/**
 * 
 */
package adventure;

import java.util.LinkedList;
import java.util.List;

/**
 * @author kmichie
 *
 */
public class InventoryCommand extends Command {

	/* (non-Javadoc)
	 * @see adventure.Command#execute(adventure.Player)
	 */
	private List<Item> inventory;
	
	public InventoryCommand() {
		inventory = new LinkedList<>();
	}
	
	private String getListOfItems() {
		Message message = new Message();
		if(inventory.isEmpty()) {
			return message.inventoryEmptyMessage();
		}
		String[] inventoryArray = new String[inventory.size()];
		for (int i = 0; i < inventoryArray.length; i++) {
			inventoryArray[i] = "the " + inventory.get(i).getName();
		}
		return "<p>You are carrying " + Message.commaSeparatedList(inventoryArray) + "</p>";
	}
	
	@Override
	public String execute(Player playerArg) {
		EnhancedPlayer player = (EnhancedPlayer) playerArg;
		EnhancedRoom room = (EnhancedRoom) player.getCurrentRoom();
		return getListOfItems();

	}

}
