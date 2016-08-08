/**
 * 
 */
package adventure;

/**
 * Allows the player to eat or not 
 * eat various items from their inventory in
 * various room locations.
 * 
 * @version 2016.08.03
 * @author kmichie
 *
 */
public class EatCommand extends Command {

    /**
     * Creates an EatCommand Object that calls 
     * to the super class.
     */

    public EatCommand() {
        super();
    }

    /**
     * Provides the ability for the player to eat 
     * an object if edible
     * 
     * @param playerArg
     *            identifies the different inventory 
     *            pieces the player has and
     *            checks if they can eat the item in 
     *            the room or inventory.
     * 
     * @return String that tells the user the ability 
     * to eat object in inventory
     * 
     * @see adventure.Command#execute(adventure.Player)
     */
    @Override
    public String execute(Player playerArg) {
        EnhancedPlayer player = (EnhancedPlayer) playerArg;
        Message message = new Message();
        if (!hasSecondWord()) {
            return "What would you like to eat?";
        }
        if (!player.inventoryCheck(getSecondWord())) {
            return message.commandDontHaveMessage(getSecondWord());
        }
        if (getSecondWord().equals("peanut-butter")) {
            player.removeFromInventory(player.getItem(getSecondWord()));
            player.setHungry(false);
            return message.eatSuccessMessage(getSecondWord());
        }
        return message.eatNotEdibleMessage(getSecondWord());
    }
}
