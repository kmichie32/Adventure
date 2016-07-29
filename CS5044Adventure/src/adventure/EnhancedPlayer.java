/**
 * 
 */
package adventure;

/**
 * @author kmichie
 *
 */
public class EnhancedPlayer extends Player {

	private boolean computerPuzzleSolved;
	
	public EnhancedPlayer() {
		super();
		computerPuzzleSolved = false;
	}
	
	public void solveComputerPuzzle() {
		computerPuzzleSolved = true;
	}
	
	public boolean computerPuzzleSolved() {
		return computerPuzzleSolved;
	}

	
}
