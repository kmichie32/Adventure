/**
 * 
 */
package adventure;

/**
 * Allows the player to drop various 
 * items from their inventory in various room
 * locations.
 * 
 * @version 2016.08.03
 * @author kmichie
 *
 */
public class DropCommand extends Command {

    /**
     * Creates a new DropCommand object with command being called as well.
     */

    public DropCommand() {
        super();
    }

    /**
     * Provides the ability for the player to drop objects in various rooms
     * 
     * @param playerArg
     *            identifies the different inventory pieces the player has and
     *            checks if they can drop the item in the room.
     * @return String that tells the player where they dropped the
     * object
     * 
     * @see adventure.Command#execute(adventure.Player)
     */

    @Override
    public String execute(Player playerArg) {
        EnhancedPlayer player = (EnhancedPlayer) playerArg;
        EnhancedRoom room = (EnhancedRoom) player.getCurrentRoom();
        Message message = new Message();
        if (!this.hasSecondWord()) {
            return "What do you want to drop?";
        }

        if (player.inventoryCheck(this.getSecondWord())) {
            room.addItem(player.getItem(this.getSecondWord()));
            player.removeFromInventory(player.getItem(this.getSecondWord()));
            return "You placed " + getSecondWord() + " down.";
        }

        return message.dropDontHaveMessage(this.getSecondWord());

    }
}
