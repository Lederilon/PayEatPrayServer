package DAO;

import domain.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Describes work fork for persist Order
 * @author KostyaHrishenko
 */
public interface OrderDAO {
    /**
     * Create new order in database
     * @param creatingDate - order creating date
     * @param deliveryDate - order delivery date
     * @param address - order address
     * @param state - order state
     * @param offer - order offer
     * @param customer - order customer
     * @return new order
     * @throws SQLException
     */
    public Order createOrder(Date creatingDate, Date deliveryDate, String address, OrderState state, Offer offer, Profile customer) throws SQLException;

    /**
     * Find order by given Id
     * @param id - to find
     * @return Order - found order
     */
    public Order getById(int id) throws SQLException;

    /**
     * Delete Order with given id
     * @param id - id to delete
     */
    public void deleteById(int id) throws SQLException;

    /**
     * Update given Order in database
     * @param order - order to update
     */
    public void updateOrder(Order order) throws SQLException;

    /**
     * Find all orders in database
     * @return  - all orders in data base
     */
    public List<Order> getAll() throws SQLException;
}
