/**
 * 
 */
package adventure;

/**
 * Allows the player to view the 
 * list of Items in the inventory 
 * of a player or
 * room.
 * 
 * @version 2016.08.03
 * @author kmichie
 *
 */
public class InventoryCommand extends Command {

    /**
     * Creates an InventoryCommand 
     * that calls to the super class.
     */

    public InventoryCommand() {
        super();
    }

    /**
     * returns a list of items in the inventory
     * 
     * @param playerArg
     *            that shows the current state of the player
     * @return String of items in a given inventory
     */
    @Override
    public String execute(Player playerArg) {
        EnhancedPlayer player = (EnhancedPlayer) playerArg;
        return player.getListOfItems();
    }
}