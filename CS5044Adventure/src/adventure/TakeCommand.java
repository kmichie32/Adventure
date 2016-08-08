/**
 * 
 */
package adventure;

/**
 * Allows the player to take items 
 * and add to inventory
 * 
 * @version 2016.08.03
 * @author kmichie
 *
 */
public class TakeCommand extends Command {
    /**
     * Creates a TakeCommand object 
     * that calls to the super class
     */
    public TakeCommand() {
        super();
    }

    /**
     * Has the current state of player to take items
     * 
     * @param playerArg
     *            is the current state of the player
     * @return a message of the success of taking the object
     */
    @Override
    public String execute(Player playerArg) {
        EnhancedPlayer player = (EnhancedPlayer) playerArg;
        EnhancedRoom room = (EnhancedRoom) player.getCurrentRoom();
        Message message = new Message();
        if (!this.hasSecondWord()) {
            return "What do you want to take?";
        }

        if (this.getSecondWord().equals("bicycle") 
                && 
                room.containsItem(this.getSecondWord())
                && 
                room.getItem(getSecondWord()).
                    getDescription().equals("locked")) {
            return message.takeBicycleLockedMessage();
        }

        if (player.inventoryCheck(getSecondWord())) {
            return message.takeAlreadyHaveMessage(getSecondWord());
        }

        if (player.inventoryCheck("bicycle")) {
            return message.takeNotEnoughRoomMessage(getSecondWord());
        }

        if (room.containsItem(this.getSecondWord()) 
                && 
                player.getSizeOfInventory() < 2
                && 
                (!player.inventoryCheck("bicycle"))) {
            player.addToInventory(room.getItem(getSecondWord()));
            room.removeItem(room.getItem(getSecondWord()));
            if (getSecondWord().equals("ruby")) {
                player.setHasRuby(true);
            }
            return message.takeSuccessMessage(getSecondWord());
        }

        if (player.inventoryCheck(getSecondWord())) {
            return message.takeAlreadyHaveMessage(getSecondWord());
        }
        return message.takeNotEnoughRoomMessage(getSecondWord());
    }
}
