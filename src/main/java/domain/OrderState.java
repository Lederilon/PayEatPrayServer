package domain;

/**
 * Contains information about order state
 * @author KostyaHrishenko
 */
public class OrderState {
    private final int id;
    private StateNames name;

    /**
     * Constructor
     * @param id - order id
     * @param name - order name
     */
    public OrderState(int id, StateNames name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return - order state id
     */
    public int getId() {
        return id;
    }

    /**
     * @return - order state name
     */
    public StateNames getName(){
        return name;
    }

    /**
     * All names that states can have
     */
    public enum StateNames{
        R("Reviewed"),
        A("Accepted"),
        D("Declined"),
        E("Executed");

        private String name;

        /**
         * Crate state with given name
         * @param name - state name
         */
        StateNames(String  name) {
            this. name = name;
        }

        /**
         * @return state name
         */
        public String getName() {
            return name;
        }

    }

    /**
     * @return  String representation of a order state
     */
    public String toString(){
        return id + " " + name.getName();
    }
}
