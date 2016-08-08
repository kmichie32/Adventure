/**
 * 
 */
package adventure;

import java.util.LinkedList;
import java.util.List;

/**
 * Checks the status of the 
 * player as they navigate 
 * various room locations.
 * 
 * @version 2016.08.03
 * @author kmichie
 *
 */
public class EnhancedPlayer extends Player {

    /**
     * inventory for the player 
     * to store items within
     */
    public List<Item> inventory;

    /**
     * @return the isHunrgy
     */
    public boolean isHungry() {
        return isHungry;
    }

    /**
     * @param areYouHungry
     *            the isHunrgy to set
     */
    public void setHungry(boolean areYouHungry) {
        this.isHungry = areYouHungry;
    }

    /**
     * @return the lockedBike
     */
    public boolean isLockedBike() {
        return lockedBike;
    }

    /**
     * @param lockedBike
     *            the lockedBike to set
     */
    public void setLockedBike(boolean lockedBike) {
        this.lockedBike = lockedBike;
    }

    /**
     * @return the hasRuby
     */
    public boolean isHasRuby() {
        return hasRuby;
    }

    /**
     * @param hasRuby
     *            the hasRuby to set
     */
    public void setHasRuby(boolean hasRuby) {
        this.hasRuby = hasRuby;
    }

    private boolean isHungry = true;

    private boolean lockedBike = false;

    private boolean hasRuby = false;

    /**
     * Creates an EnhancedPlayer 
     * Object that calls the super class and
     * establishes the inventory of the player
     */
    public EnhancedPlayer() {
        super();
        inventory = new LinkedList<>();
    }

    /**
     * Gets the current size of the inventory
     * 
     * @return integer for inventory size
     */
    public int getSizeOfInventory() {
        return inventory.size();
    }

    /**
     * Adds items to the inventory
     * 
     * @param itemName
     *            for adding items to inventory
     */
    public void addToInventory(Item itemName) {
        inventory.add(itemName);
    }

    /**
     * Removes item from inventory
     * 
     * @param itemName
     *            for removing items from inventory
     */
    public void removeFromInventory(Item itemName) {
        inventory.remove(itemName);
    }

    /**
     * Only used with containsItem being true. Do not use without checking
     * contains Item.
     * 
     * @param itemName
     *            name of item you want to create as part of the Item class
     * @return Item class version of the String passed.
     */
    public Item getItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equals(itemName)) {
                return item;
            } 
        }
        return null;
    }

    /**
     * Checks to see if the item is in your inventory.
     * 
     * @param item
     *            in search for
     * @return boolean for item in inventory
     */
    public boolean inventoryCheck(String item) {
        String[] inventoryArray = new String[inventory.size()];
        for (int i = 0; i < inventoryArray.length; i++) {
            if (inventory.get(i).getName().equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prints out the list of items in your inventory.
     * 
     * @return list of items in inventory
     */
    public String getListOfItems() {
        Message message = new Message();
        if (inventory.isEmpty()) {
            return message.inventoryEmptyMessage();
        }
        String[] inventoryArray = new String[inventory.size()];
        for (int i = 0; i < inventoryArray.length; i++) {
            inventoryArray[i] = "the " + inventory.get(i).getName();
        }
        return "<p>You are carrying " + 
                Message.commaSeparatedList(inventoryArray) + "</p>";
    }

}
