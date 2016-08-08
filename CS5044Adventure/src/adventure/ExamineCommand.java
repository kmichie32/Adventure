/**
 * 
 */
package adventure;

/**
 * Allows the player to 
 * examine items in the room
 * 
 * @version 2016.08.03
 * @author kmichie
 *
 */
public class ExamineCommand extends Command {

    /**
     * Creates a new Examine Command
     *  Object that calls to the super class.
     * 
     */

    public ExamineCommand() {
        super();
    }

    /**
     * Used to examine surroundings and 
     * inventory of objects
     * 
     * @param playerArg
     *            that shows the current state 
     *            of the player.
     * @return a String description of the 
     * objects you interact with
     */
    @Override
    public String execute(Player playerArg) {
        EnhancedPlayer player = (EnhancedPlayer) playerArg;
        EnhancedRoom room = (EnhancedRoom) player.getCurrentRoom();
        Message message = new Message();
        if (!hasSecondWord()) {
            return "What would you like to examine?";
        }
        if (!room.containsItem(getSecondWord()) 
                && 
                !player.inventoryCheck(getSecondWord())) {
            return message.commandCantSeeMessage(getSecondWord());
        }
        if (getSecondWord().equals("peanut-butter")
                && (room.containsItem(getSecondWord()) 
                        || 
                        player.inventoryCheck(getSecondWord()))) {
            return message.peanutButterDescriptionMessage();
        }
        if (getSecondWord().equals("ruby")
                && (room.containsItem(getSecondWord()) 
                        || 
                        player.inventoryCheck(getSecondWord()))) {
            return message.rubyDescriptionMessage();
        }
        if (getSecondWord().equals("bicycle") 
                && 
                (room.containsItem(getSecondWord()) 
                        && 
                        player.isLockedBike())) {
            return message.bicycleLockedMessage();
        }
        if (getSecondWord().equals("bicycle")
                && 
                (room.containsItem(getSecondWord()) 
                        || 
                        player.inventoryCheck(getSecondWord()))) {
            return message.bicycleDescriptionMessage();
        } 
        else {
            return message.examineDefaultMessage(getSecondWord());
        }
    }
}
