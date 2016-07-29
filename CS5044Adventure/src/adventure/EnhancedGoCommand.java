/**
 * 
 */
package adventure;

/**
 * @author kmichie
 *
 */
public class EnhancedGoCommand extends GoCommand {
	
	public EnhancedGoCommand(String argsDirection) {
		setSecondWord(argsDirection);
		//super.execute(player);
	}
	
	@Override
	public String execute(Player playerArg) {
		EnhancedPlayer player = (EnhancedPlayer)playerArg;
		EnhancedRoom room = (EnhancedRoom) player.getCurrentRoom().getExit(super.getSecondWord());
		if(room == null){
			return Message.noExitInDirectionMessage();
		}
		player.setCurrentRoom(room);
		return "";
	}
	
}
