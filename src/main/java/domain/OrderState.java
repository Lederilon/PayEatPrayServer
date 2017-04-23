package domain;

/**
 * Contains information about order state
 * @author KostyaHrishenko
 */
public class OrderState {
    private String name;

    /**
     *
     * @param name - order state name
     */
    public OrderState(String name) {
        this.name = name;
    }

    /**
     *
     * @return String - order state name
     */
    public String getName() {
        return name;
    }

    /**
     * Change order state name
     * @param name - order state name
     */
    public void setName(String name) {
        this.name = name;
    }
}
