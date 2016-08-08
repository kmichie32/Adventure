package adventure;

/**
 * Creates items and their descriptions
 * 
 * @version 2016.08.03
 * @author kmichie
 *
 */

public class MyGame extends Game {
    /**
     * Creates a new game and calls to the super class
     */
    public MyGame() {
        super(new EnhancedPlayer(), new Parser());
    }

    /**
     * used to create the new games and play
     * 
     * @param args
     *            from a string array
     */
    public static void main(String[] args) {
        Game game = new MyGame();
        game.play();
    }

    /**
     * Welcome's the user and shows them how to play
     * 
     * @return String welcoming the user
     */
    public String welcomeMessage() {
        return "<p>Welcome to The World of Simplicity!</p>" 
                + "<p>Type 'help' if you need help.</p>"
                + "<p>Hit [return] to continue...</p>";
    }

    /**
     * Creates rooms for the user to interact within
     */
    public void createRooms() {
        EnhancedRoom outsideApartment = 
                new EnhancedRoom("outside your apartment");
        EnhancedRoom livingRoom = new EnhancedRoom("in your living room");
        EnhancedRoom bedRoom = new EnhancedRoom("in your bedroom");
        EnhancedRoom kitchen = new EnhancedRoom("in your kitchen");
        EnhancedRoom hallBathroom = new EnhancedRoom("in your hall bathroom");
        EnhancedRoom basement = new EnhancedRoom("in your basement");
        EnhancedRoom attic = new EnhancedRoom("in your attic");
        EnhancedRoom masterBathroom = 
                new EnhancedRoom("in your master bathroom");
        EnhancedRoom videoGameRoom = 
                new EnhancedRoom("in your video gaming room");
        EnhancedRoom catRoom = new EnhancedRoom("in your cat room");

        outsideApartment.setExit("north", livingRoom);
        livingRoom.setExit("south", outsideApartment);
        livingRoom.setExit("west", bedRoom);
        livingRoom.setExit("east", kitchen);
        bedRoom.setExit("east", livingRoom);
        kitchen.setExit("west", livingRoom);
        kitchen.setExit("east", hallBathroom);
        hallBathroom.setExit("west", kitchen);
        basement.setExit("up", livingRoom);
        basement.setExit("east", videoGameRoom);
        videoGameRoom.setExit("west", basement);
        livingRoom.setExit("down", basement);
        bedRoom.setExit("up", attic);
        attic.setExit("down", bedRoom);
        bedRoom.setExit("west", masterBathroom);
        masterBathroom.setExit("east", bedRoom);
        attic.setExit("west", catRoom);
        catRoom.setExit("east", attic);

        Item bicycle = new Item("bicycle");
        Item ruby = new Item("ruby");
        Item peanutButter = new Item("peanut-butter");
        Item cat = new Item("cat");
        Item plunger = new Item("plunger");
        Item toiletPaper = new Item("toilet-paper");
        Item gameboy = new Item("gameboy");
        Item journal = new Item("journal");
        Item key = new Item("key");

        livingRoom.addItem(bicycle);
        bedRoom.addItem(ruby);
        bedRoom.addItem(key);
        kitchen.addItem(peanutButter);
        catRoom.addItem(cat);
        masterBathroom.addItem(plunger);
        hallBathroom.addItem(toiletPaper);
        videoGameRoom.addItem(gameboy);
        attic.addItem(journal);
        basement.addItem(key);
        // the player starts the game in the living room
        player().setCurrentRoom(livingRoom);
    }

    /**
     * provides commands for the users to use throughout the game
     */
    public void createCommands() {
        CommandWords commands = parser().commandWords();
        commands.addCommand("go", new GoCommand());
        commands.addCommand("help", new HelpCommand(commands));
        commands.addCommand("quit", new QuitCommand());
        commands.addCommand("examine", new ExamineCommand());
        commands.addCommand("eat", new EatCommand());
        commands.addCommand("take", new TakeCommand());
        commands.addCommand("drop", new DropCommand());
        commands.addCommand("inventory", new InventoryCommand());
        commands.addCommand("i", new InventoryCommand());
        commands.addCommand("lock", new LockCommand());
        commands.addCommand("east", new EnhancedGoCommand("east"));
        commands.addCommand("e", new EnhancedGoCommand("east"));
        commands.addCommand("west", new EnhancedGoCommand("west"));
        commands.addCommand("w", new EnhancedGoCommand("west"));
        commands.addCommand("north", new EnhancedGoCommand("north"));
        commands.addCommand("n", new EnhancedGoCommand("north"));
        commands.addCommand("south", new EnhancedGoCommand("south"));
        commands.addCommand("s", new EnhancedGoCommand("south"));
        commands.addCommand("up", new EnhancedGoCommand("up"));
        commands.addCommand("u", new EnhancedGoCommand("up"));
        commands.addCommand("down", new EnhancedGoCommand("down"));
        commands.addCommand("d", new EnhancedGoCommand("down"));
    }

}
