package domain;

/**
 * Conatins information about an Offer
 * @author Kostya Hrishenko
 */
public class Offer {
    private final int id;
    private int price;
    private String name;
    private Profile creator;

    /**
     * Constructor
     * @param id offer id
     * @param price offer price
     * @param name offer name
     * @param creator offer creator
     */
    public Offer(int id, int price, String name, Profile creator) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.creator = creator;
    }

    /**
     * @return int - goods price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Change offer price
     * @param price - goods price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return name - offer name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name - offer name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Profile - creator profile
     */
    public Profile getCreator() {
        return creator;
    }

    /**
     * Change offer creator
     * @param creator - offer creator
     */
    public void setCreator(Profile creator) {
        this.creator = creator;
    }

    /**
     * @return OfferId
     */
    public int getId() {
        return id;
    }

    /**
     * @return String representation of offer
     */
    public String toString(){
        return id+ " "+price+" "+name+" "+creator;
    }
}
