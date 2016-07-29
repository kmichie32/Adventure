/**
 * 
 */
package adventure;

/**
 * @author kmichie
 *
 */
public class ExamineCommand extends Command {

	/* (non-Javadoc)
	 * @see adventure.Command#execute(adventure.Player)
	 */
	
	public ExamineCommand() {
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
			return message.peanutButterDescriptionMessage();
		case "ruby":
			return message.rubyDescriptionMessage();
		case "bicycle":
			return message.bicycleDescriptionMessage();
		case "inventory":
			
		default:
			return message.examineDefaultMessage(getSecondWord());
		}
	}

}
