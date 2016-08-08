package adventure;

/**
 * Creates items and their descriptions
 * 
 * @version 2016.08.03
 * @author kmichie
 *
 */

public class Item {

    private String name;
    private String description;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Creates a new Item Object
     * 
     * @param nameArg
     *            is name of item
     */
    public Item(String nameArg) {
        this(nameArg, "");
    }

    /**
     * Creates a new Item Object
     * 
     * @param nameArg
     *            is name of item
     * @param descArg
     *            describes the item
     */
    public Item(String nameArg, String descArg) {
        name = nameArg;
        description = descArg;
    }
}
