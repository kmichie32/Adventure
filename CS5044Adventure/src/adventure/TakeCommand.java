/**
 * 
 */
package adventure;

/**
 * @author kmichie
 *
 */
public class TakeCommand extends Command {
	/**
	 * 
	 */
	public TakeCommand() {
		// TODO Auto-generated constructor stub
		super();
	}

	/* (non-Javadoc)
	 * @see adventure.Command#execute(adventure.Player)
	 */
	@Override
	public String execute(Player playerArg) {
		EnhancedPlayer player = (EnhancedPlayer) playerArg;
		EnhancedRoom room = (EnhancedRoom) player.getCurrentRoom();
		
		if(!this.hasSecondWord()) {
			return "What do you want to take?";
		}
		
	
		
		if(this.getSecondWord().equals("computer")) {
			if(room.containsItem("computer")) {
				// puzzle solved
				player.solveComputerPuzzle();
				return "You turn on the computer. Congratulations,"
						+ " you have solved the computer puzzle";
			} else{
				return "This room does not have a computer";
			}
		} else {
			return "The " + this.getSecondWord() + " is not something"
					+ " that you can turn on.";
		}
		// If we turn on the computer in the lab, we solve the puzzle
		
		// If we "turn on" anything else, we get some message.
		
	}

}
