package domain;

/**
 * Contain information about profile's category
 * @author KostyaHrishenko
 */
public class ProfileCategory {
    private final int id;

    public ProfileCategory(int id, CategoryNames name) {
        this.id = id;
        this.name = name;
    }

    /**
     *
     * @return category id
     *
     */
    public int getId() {
        return id;
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
         * Crate categiry with given name
         * @param name
         */
         CategoryNames(String  name) {
            this. name = name;
        }

        /**
         *
         * @return category name
         */
        public String getName() {
            return  name;
        }

    };
    private CategoryNames name;
    public CategoryNames getName()
    {
        return name;
    }
    /**
     *
     * @return  String representation of profile category
     */
    public String toString(){
        return id + " " +name.getName();
}

}
