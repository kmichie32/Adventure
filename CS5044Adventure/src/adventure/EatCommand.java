/**
 * 
 */
package adventure;

/**
 * @author kmichie
 *
 */
public class EatCommand extends Command {

	/* (non-Javadoc)
	 * @see adventure.Command#execute(adventure.Player)
	 */
	
	public EatCommand() {
		super();
	}
	
	@Override
	public String execute(Player playerArg) {
		EnhancedPlayer player = (EnhancedPlayer) playerArg;
		EnhancedRoom room = (EnhancedRoom) player.getCurrentRoom();
		Message message = new Message();
		if(!room.containsItem(getSecondWord())){
			return message.commandCantSeeMessage(getSecondWord());
		}
		switch(getSecondWord()){
		case "peanut-butter":
			return message.eatSuccessMessage(getSecondWord());
		default:
			return message.eatNotEdibleMessage(getSecondWord());
		}
	}

}
