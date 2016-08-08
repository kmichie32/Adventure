/**
 * 
 */
package adventure;

/**
 * Allows the player to navigate 
 * various room locations.
 * 
 * @version 2016.08.03
 * @author kmichie
 *
 */
public class EnhancedGoCommand extends GoCommand {

    private String direction;

    /**
     * Creates an EnhancedGoCommand Object 
     * that calls to the super class and
     * takes a direction argument
     * 
     * @param argsDirection
     *            sets direction in the private direction method
     */
    public EnhancedGoCommand(String argsDirection) {
        super();
        this.direction = argsDirection;
    }

    /**
     * Has player execute a series of 
     * moves to enter and exit different rooms.
     * 
     * @param playerArg
     *            sets the player in the 
     *            current room they are interacting in.
     * 
     * @return String of player movement relative to location.
     */
    public String execute(Player playerArg) {
        EnhancedPlayer player = (EnhancedPlayer) playerArg;
        EnhancedRoom room = (EnhancedRoom) player.getCurrentRoom();
        if (room.getShortDescription().equals("in your living room") 
                && 
                direction.equals("south")) {
            if (player.isHungry()) {
                return Message.exitWithoutEatingPBMessage();
            }
            if (!player.isLockedBike()) {
                return Message.exitWithoutLockingBikeMessage();
            }
            if (!player.isHasRuby()) {
                return Message.exitWithoutTakingRubyMessage();
            } 
            else {
                return "You are outside your apartment.\n" 
                        + Message.youWinMessage();
            }

        }
        room = (EnhancedRoom) player.getCurrentRoom().getExit(direction);
        if (room == null) {
            return Message.noExitInDirectionMessage();
        }
        player.setCurrentRoom(room);
        return "";
    }

}
