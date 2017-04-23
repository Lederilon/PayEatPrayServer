package domain;

/**
 * Describes action can be produced on Order
 * @author KostyaHrishenko
 */
public class ActionType {
    private String name;

    /**
     * Create ActionType
     * @param name - actionType name
     */
    public ActionType(String name) {
        this.name = name;
    }

    /**
     * Get name of action Type
     * @return String - actionType name
     */
    public String getName() {
        return name;
    }

    /**
     * Change name of actionType
     * @param name - actiontype name
     */
    public void setName(String name) {
        this.name = name;
    }
}
