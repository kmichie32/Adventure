package adventure;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Creates test for all of the cases throughout the game
 * 
 * @author kmichie
 * @version 08.03.2016
 */
public class MyGameTest {

    private String message;
    private String roomDesc;
    private String longDesc;
    private Game game;

    /**
     * Creates a MyGameTest object empty to establish constructor
     */
    public MyGameTest() {
        //empty to establish a constructor
    }

    /**
     * set's up all of the parameters for the game
     */
    @Before
    public void setUp() {
        game = new MyGame();
        game.createCommands();
        game.createRooms();
    }

    /**
     * test to check your current room.
     */
    @Test
    public void testInit() {
        roomDesc = game.player().getCurrentRoom().getShortDescription();
        assertEquals("in your living room", roomDesc);
    }

    /**
     * Test's the success of the Drop Command
     */
    @Test
    public void testDropCommandSuccess() {
        executeMoves("take bicycle", "drop bicycle");
        assertEquals("You placed bicycle down.", message);
    }
    /**
     * Test the long description of the current room
     */
    @Test
    public void testLongDescription() {
        executeMoves("take bicycle");
        assertEquals("<p>You are in your living room. "
                + "There are exits to the east, south, "
                + "west and down.</p>", longDesc);
    }

    /**
     * Test the failure of the Drop Command
     */
    @Test
    public void testDropCommandFailure() {
        executeMoves("drop");
        assertEquals("What do you want to drop?", message);
        executeMoves("drop ruby");
        assertEquals(Message.dropDontHaveMessage("ruby"), message);
    }

    /**
     * tests the success to eat certain objects
     */
    @Test
    public void testEatCommandSuccess() {
        executeMoves("e","take peanut-butter", "eat peanut-butter");
        assertEquals(Message.eatSuccessMessage("peanut-butter"), message);
        executeMoves("w", "w", "take ruby", "eat ruby");
        assertEquals(Message.eatNotEdibleMessage("ruby"), message);
    }

    /**
     * Tests the failure to eat certain objects
     */
    @Test
    public void testEatCommandFailure() {
        executeMoves("eat peanut-butter");
        assertEquals(Message.commandDontHaveMessage("peanut-butter"), message);
        executeMoves("take bicycle", "eat bicycle");
        assertEquals(Message.eatNotEdibleMessage("bicycle"), message);
    }

    /**
     * Tests nothing to eat
     */
    @Test
    public void testNothingToEat() {
        executeMoves("eat");
        assertEquals("What would you like to eat?", message);
    }

    /**
     * Test already having object in inventory
     */
    @Test
    public void testAlreadyHave() {
        executeMoves("down", "take key", "up", "w", "take key");
        assertEquals(Message.takeAlreadyHaveMessage("key"), message);
    }

    /**
     * tests the ability to create comma separated lists from String arrays
     */
    @Test
    public void testCommaSeparatedList() {
        String[] zero = {};
        String[] one = { "cat" };
        String[] two = { "cat", "dog" };
        String[] three = { "cat", "dog", "fish" };
        assertEquals(Message.commaSeparatedList(zero), "");
        assertEquals(Message.commaSeparatedList(one), "cat");
        assertEquals(Message.commaSeparatedList(two), "cat and dog");
        assertEquals(Message.commaSeparatedList(three), "cat, dog and fish");
    }

    /**
     * Tests the items in the inventory
     */
    @Test
    public void testPlayerInventory() {
        executeMoves("take bicycle", "drop ruby");
        assertEquals(Message.commandDontHaveMessage("ruby"), message);
        executeMoves("i");
        assertEquals("<p>You are carrying the bicycle</p>", message);
        executeMoves("drop bicycle", "i");
        assertEquals(Message.inventoryEmptyMessage(), message);
    }

    /**
     * Tests if an object is a retrievable item from player perspective.
     */
    @Test
    public void testPlayerGetItem() {
        EnhancedPlayer player = new EnhancedPlayer();
        Item bicycle = new Item("bicycle");
        player.addToInventory(bicycle);
        assertEquals(player.getItem("bicycle").getName(), "bicycle");
        assertTrue(player.getItem("bicycle").getName().equals("bicycle"));
        player.removeFromInventory(bicycle);
        assertNull(player.getItem("bicycle"));
    }

    /**
     * Tests if an object is a retrievable item from room perspective.
     */
    @Test
    public void testRoomGetItemAndCheck() {
        EnhancedRoom room = new EnhancedRoom("in your living room");
        Item bicycle = new Item("bicycle");
        room.addItem(bicycle);
        assertEquals(room.getItem("bicycle").getName(), "bicycle");
        assertTrue(room.getItem("bicycle").getName().equals("bicycle"));
        assertFalse(room.containsItem("ruby"));
        room.removeItem(bicycle);
        assertNull(room.getItem("bicycle"));
    }

    /**
     * Tests if it is possible to win the game
     */
    @Test
    public void testExitLivingRoom() {
        executeMoves("up");
        assertEquals(Message.noExitInDirectionMessage(), message);
        executeMoves("down");
        assertEquals("in your basement", roomDesc);
        executeMoves("up", "s");
        assertEquals(Message.exitWithoutEatingPBMessage(), message);
        executeMoves("e", "take peanut-butter", "eat peanut-butter", "w", "s");
        assertEquals(Message.exitWithoutLockingBikeMessage(), message);
        executeMoves("lock bicycle", "s");
        assertEquals(Message.exitWithoutTakingRubyMessage(), message);
        executeMoves("w", "take ruby", "e", "s");
        assertEquals("You are outside your apartment.\n" 
                    + Message.youWinMessage(), message);
    }

    /**
     * Tests the ability to examine objects
     */
    @Test
    public void examineObjects() {
        executeMoves("examine");
        assertEquals("What would you like to examine?", message);
        executeMoves("examine bicycle");
        assertEquals(Message.bicycleDescriptionMessage(), message);
        executeMoves("take bicycle", "examine bicycle");
        assertEquals(Message.bicycleDescriptionMessage(), message);
        executeMoves("drop bicycle", "lock bicycle", "examine bicycle");
        assertEquals(Message.bicycleLockedMessage(), message);
        executeMoves("w", "examine ruby");
        assertEquals(Message.rubyDescriptionMessage(), message);
        executeMoves("take ruby", "examine ruby");
        assertEquals(Message.rubyDescriptionMessage(), message);
        executeMoves("drop ruby", "e", "e", "examine peanut-butter");
        assertEquals(Message.peanutButterDescriptionMessage(), message);
        executeMoves("take peanut-butter", "examine peanut-butter");
        assertEquals(Message.peanutButterDescriptionMessage(), message);
        executeMoves("drop peanut-butter", "e", "examine toilet-paper");
        assertEquals(Message.examineDefaultMessage("toilet-paper"), message);
        executeMoves("take toilet-paper", "examine toilet-paper");
        assertEquals(Message.examineDefaultMessage("toilet-paper"), message);
        executeMoves("examine cat");
        assertEquals(Message.commandCantSeeMessage("cat"), message);
    }

    /**
     * Tests checking the inventory
     */
    @Test
    public void testInventoryCheck() {
        EnhancedPlayer player = new EnhancedPlayer();
        Item bicycle = new Item("bicycle");
        player.addToInventory(bicycle);
        assertTrue(player.inventoryCheck("bicycle"));
        assertFalse(player.inventoryCheck("ruby"));
    }

    /**
     * Tests to Lock Command on different objects
     */
    @Test
    public void testLock() {
        executeMoves("lock");
        assertEquals("What do you want to lock?", message);
        executeMoves("w", "lock bicycle");
        assertEquals(Message.lockBicycleNotHereMessage(), message);
        executeMoves("lock ruby");
        assertEquals(Message.lockNotPossibleMessage("ruby"), message);
        executeMoves("e", "take bicycle", "lock bicycle");
        assertEquals(Message.lockPutBicycleDownMessage(), message);
        executeMoves("drop bicycle", "lock bicycle");
        assertEquals(Message.lockBicycleMessage(), message);
        executeMoves("take bicycle");
        assertEquals(Message.takeBicycleLockedMessage(), message);
    }

    /**
     * Tests what a room contains
     */
    @Test
    public void roomContains() {
        EnhancedRoom room = new EnhancedRoom("in your living room");
        Item bicycle = new Item("bicycle");
        room.addItem(bicycle);
        assertTrue(room.containsItem("bicycle"));
        assertFalse(room.containsItem("ruby"));
    }

    /**
     * Tests what you can and cannot take
     */
    @Test
    public void testTakeCommand() {
        executeMoves("take");
        assertEquals("What do you want to take?", message);
        executeMoves("down", "take key", "up", "w", "take key");
        assertEquals(Message.takeAlreadyHaveMessage("key"), message);
        executeMoves("take ruby", "w", "take plunger");
        assertEquals(Message.takeNotEnoughRoomMessage("plunger"), message);
    }

    /**
     * Tests ability to take ruby
     */
    @Test
    public void testTakeRuby() {
        executeMoves("go west", "take ruby");
        assertEquals("in your bedroom", roomDesc);
        assertEquals(Message.takeSuccessMessage("ruby"), message);
    }

    /**
     * helps to test executing moves through testing
     * 
     * @param inputs
     *            of the user to move throughout game
     */
    private void executeMoves(String... inputs) {
        for (String input : inputs) {
            Command command = game.parser().getCommand(input);
            message = command.execute(game.player());
        }
        roomDesc = game.player().getCurrentRoom().getShortDescription();
        longDesc = game.player().getCurrentRoom().getLongDescription();
    }
}
