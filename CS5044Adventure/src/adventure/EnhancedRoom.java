/**
 * 
 */
package adventure;

import java.util.List;
import java.util.LinkedList;

/**
 * Allows the player to add or 
 * remove items from a room
 * 
 * @version 2016.08.03
 * @author kmichie
 *
 */
public class EnhancedRoom extends Room {

    private List<Item> items;

    /**
     * Creates a new EnhancedRoom Object
     * 
     * @param description
     *            of object in the room
     */
    public EnhancedRoom(String description) {
        super(description);
        items = new LinkedList<>();
    }

    /**
     * Adds item to room inventory
     * 
     * @param item
     *            to be added to room
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Removes item from room inventory
     * 
     * @param item
     *            to be removed from the room
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Retrieves the Item equal to the String value
     * 
     * @param itemName
     *            that you are using to search for items
     * @return an Item or null depending if the item is in inventory
     */
    public Item getItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Checks if the item is in the inventory
     * 
     * @param itemName
     *            that is being checked
     * @return boolean value of the room 
     * containing the object or not
     */
    public boolean containsItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the description of the room
     * 
     * @return String of the room description
     */
    @Override
    public String getLongDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getLongDescription());
        sb.append(getListOfItems());
        return sb.toString();
    }

    /**
     * Returns a list of items in the room
     * 
     * @return a list of items in the room
     */
    private String getListOfItems() {
        if (items.isEmpty()) {
            return "";
        }
        String[] itemArray = new String[items.size()];
        for (int i = 0; i < itemArray.length; i++) {
            itemArray[i] = "the " + items.get(i).getName();
        }
        return "<p>You see " + 
                Message.commaSeparatedList(itemArray) + "</p>";
    }
}
