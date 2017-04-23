package domain;

import java.util.Date;

/**
 * Conatins information about an Offer
 * @author Kostya Hrishenko
 */
public class Offer {
    private int price;
    private final int id;
    private Date creationDate;
    private Goods goods;
    private Profile creator;

    /**
     * Construct new Offer
     * @param price - goods price
     * @param id
     * @param creationDate -
     * @param goods -
     * @param creator - profile that create offer
     */
    public Offer(int price, int id, Date creationDate, Goods goods, Profile creator) {
        this.price = price;

        this.id = id;
        this.creationDate = creationDate;
        this.goods = goods;
        this.creator = creator;
    }

    /**
     *
     * @return Date - when created
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Change creatin date
     * @param creationDate - when created
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     *
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
     *
     * @return goods in offer
     */
    public Goods getGoods() {
        return goods;
    }

    /**
     * Change goods in offer
     * @param goods
     */
    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    /**
     *
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
}
