/**
 * 
 */
package adventure;

/**
 * Allows the player to change 
 * the state of the lock on the bike
 * 
 * @version 2016.08.03
 * @author kmichie
 *
 */
public class LockCommand extends Command {

    /**
     * Creates the LockCommand object 
     * that calls to the super class
     */
    public LockCommand() {
        super();
    }

    /**
     * Executes the locking 
     * mechanism from the current player
     * 
     * @param playerArg
     *            gives current player state
     * @return String message telling you the state of the object
     */
    @Override
    public String execute(Player playerArg) {
        EnhancedPlayer player = (EnhancedPlayer) playerArg;
        EnhancedRoom room = (EnhancedRoom) player.getCurrentRoom();
        Message message = new Message();

        if (!this.hasSecondWord()) {
            return "What do you want to lock?";
        }

        if (this.getSecondWord().equals("bicycle") 
                && 
                room.containsItem("bicycle")) {
            room.getItem(getSecondWord()).setDescription("locked");
            player.setLockedBike(true);
            return message.lockBicycleMessage();
        }

        if (this.getSecondWord().equals("bicycle") 
                && 
                player.inventoryCheck("bicycle")) {
            return message.lockPutBicycleDownMessage();
        }

        if (this.getSecondWord().equals("bicycle") 
                && 
                !room.containsItem("bicycle")) {
            return message.lockBicycleNotHereMessage();
        }

        return message.lockNotPossibleMessage(this.getSecondWord());

    }

}
