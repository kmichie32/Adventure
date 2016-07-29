/**
 * 
 */
package adventure;

import java.util.List;
import java.util.LinkedList;

/**
 * @author kmichie
 *
 */
public class EnhancedRoom extends Room {
	
	private List<Item> items;

	/**
	 * @param description
	 */
	public EnhancedRoom(String description) {
		super(description);
		items = new LinkedList<>();
		// TODO Auto-generated constructor stub
	}
	
	public void addItem(Item item) {
		items.add(item);
	}

    
	/**
	 * @return
	 */
	private String getListOfRoomObject() {
		// TODO Auto-generated method stub
		return null;
	}

	// void removeItem(Item item)
	public boolean containsItem(String itemName) {
		for(Item item : items) {
			if(item.getName().equals(itemName)) {
				return true;
			}
		}
		return false;
	}
	// Item getItem(String itemName)
	// Add something to list all items in the room
	
	@Override
	public String getLongDescription() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getLongDescription());
		sb.append(getListOfItems());
		return sb.toString();
	}
	
	private String getListOfItems() {
		if(items.isEmpty()) {
			return "";
		}
		String[] itemArray = new String[items.size()];
		for (int i = 0; i < itemArray.length; i++) {
			itemArray[i] = "the " + items.get(i).getName();
		}
		return "<p>You see " + Message.commaSeparatedList(itemArray) + "</p>";
	}
}
