package adventure;

import java.util.HashSet;
import java.util.Set;

public class Item {
	
	private String name;
	private String description;
	private Set<String> properties;
	// add
	// remove
	// contains
	// optional-containsall
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
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

	
	public Item(String nameArg) {
		this(nameArg, ""); //calls the HashSet
	}
	
	public Item(String nameArg, String descArg) {
		name = nameArg;
		description = descArg;
		properties = new HashSet<>();
	}
}
