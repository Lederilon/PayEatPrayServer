package domain;

import java.util.Date;

/**
 * Contains informatin about an Order
 * @author KostyaHrishenko
 */
public class Order {
    private final int id;
    private Date creatingDate;
    private Date deliveryDate;
    private String address;
    private OrderState state;
    private Offer offer;
    private Profile customer;

    /**
     * Constructor
     * @param id order id
     * @param creatingDate order creating date
     * @param deliveryDate order delivery date
     * @param address order delivery address
     * @param state order state
     * @param offer offer that is ordered
     * @param customer customer who made the order
     */
    public Order(int id, Date creatingDate, Date deliveryDate, String address, OrderState state, Offer offer, Profile customer) {
        this.id = id;
        this.creatingDate = creatingDate;
        this.deliveryDate = deliveryDate;
        this.address = address;
        this.state = state;
        this.offer = offer;
        this.customer = customer;
    }

    /**
     * @return order id
     */
    public int getId() {
        return id;
    }

    /**
     * @return creating date
     */
    public Date getCreatingDate() {
        return creatingDate;
    }

    /**
     * @return delivery date
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @return delivery address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return order state
     */
    public OrderState getState() {
        return state;
    }

    /**
     * @return offer
     */
    public Offer getOffer() {
        return offer;
    }

    /**
     * @return customer
     */
    public Profile getCustomer() {
        return customer;
    }

    /**
     * @param creatingDate - creating date
     */
    public void setCreatingDate(Date creatingDate) {
        this.creatingDate = creatingDate;
    }

    /**
     * @param deliveryDate - delivery date
     */
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * @param address - delivery address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @param state - order state
     */
    public void setState(OrderState state) {
        this.state = state;
    }

    /**
     * @param offer - offer
     */
    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    /**
     * @param customer - customer
     */
    public void setCustomer(Profile customer) {
        this.customer = customer;
    }

    /**
     * @return String representation of order
     */
    public String toString(){
        return id+ " "+creatingDate+" "+deliveryDate+" "+address+" "+state+" "+offer+" "+customer;
    }
}
