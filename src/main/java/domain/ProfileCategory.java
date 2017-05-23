package domain;

/**
 * Contain information about profile's category
 * @author KostyaHrishenko
 */
public class ProfileCategory {
    private final int id;
    private CategoryNames name;

    /**
     * Constructor
     * @param id - category id
     * @param name - category name
     */
    public ProfileCategory(int id, CategoryNames name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return category id
     */
    public int getId() {
        return id;
    }

    /**
     * @return - category name
     */
    public CategoryNames getName()
    {
        return name;
    }

    /**
     * All names that categury can have
     * @author KostyaHrishenko
     */
    public enum  CategoryNames{
        F("Catering facilities"),
        D("Delivery Service"),
        C("Consumer");
        private String name;

        /**
         * Crate category with given name
         * @param name - category name
         */
         CategoryNames(String  name) {
            this. name = name;
        }

        /**
         * @return category name
         */
        public String getName() {
            return  name;
        }

    }

    /**
     * @return  String representation of a profile category
     */
    public String toString(){
        return id + " " + name.getName();
}

}
