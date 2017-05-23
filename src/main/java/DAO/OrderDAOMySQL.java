package DAO;

import domain.*;

import java.sql.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * OrderDAO implementation for MySQL
 * @author KostyaHrishenko
 */
public class OrderDAOMySQL implements OrderDAO {
    private DAOFactory connectionSource;

    /**
     * Constructor
     * @param connSource - connection source
     */
    public OrderDAOMySQL(DAOFactory connSource){
        connectionSource = connSource;
    }

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
    public Order createOrder(Date creatingDate, Date deliveryDate, String address, OrderState state, Offer offer, Profile customer) throws SQLException {
        Connection connection = connectionSource.getConnection();
        try {
            int id;
            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO order(creationdate,deliverytime,address,orderstate_id,offer_id,profile_id) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, new java.sql.Date(creatingDate.getTime()));
            statement.setDate(2, new java.sql.Date(deliveryDate.getTime()));
            statement.setString(3, address);
            statement.setInt(4,state.getId());
            statement.setInt(5,offer.getId());
            statement.setInt(6,customer.getId());
            statement.executeUpdate();
            ResultSet rs =  statement.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                throw new SQLException();
            }
            return new Order(id, creatingDate, deliveryDate, address, state, offer, customer);
        }
        finally {
            connection.close();
        }
    }

    /**
     * Find order by given Id
     * @param id - to find
     * @return Order - found order
     */
    public Order getById(int id) throws SQLException {
        Connection connection = connectionSource.getConnection();
        try{
            Date creatingDate;
            Date deliveryDate;
            String address;
            OrderState state;
            Offer offer;
            Profile customer;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM order WHERE ID = ?");
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                creatingDate = rs.getDate(2);
                deliveryDate = rs.getDate(3);
                address = rs.getString(4);
                OrderStateDAO orderStateDAO = new OrderStateDAO(connectionSource);
                state = orderStateDAO.getStateById(rs.getInt(5));
                OfferDAO offerDAO = new OfferDAOMySQL(connectionSource);
                offer = offerDAO.getById(rs.getInt(6));
                ProfileDAO profileDAO = new ProfileDAOMySQL(connectionSource);
                customer = profileDAO.getById(rs.getInt(7));
                return new Order(id, creatingDate, deliveryDate, address, state, offer, customer);
            }
            else
                throw new IllegalArgumentException();
        }
        finally{
            connection.close();
        }
    }

    /**
     * Delete Order with given id
     * @param id - id to delete
     */
    public void deleteById(int id) throws SQLException {
        Connection connection = connectionSource.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM order WHERE id = ?;");
            statement.setInt(1,id);
            statement.executeUpdate();
        }
        finally{
            connection.close();}
    }

    /**
     * Update given Order in database
     * @param order - order to update
     */
    public void updateOrder(Order order) throws SQLException {
        Connection connection = connectionSource.getConnection();
        try {
            PreparedStatement statement =
                    connection.prepareStatement("UPDATE order SET creationdate = ?,deliverytime = ?,address = ?,orderstate_id = ?,offer_id = ?,profile_id = ? WHERE id = ?");
            statement.setInt(7, order.getId());
            statement.setDate(1, new java.sql.Date(order.getCreatingDate().getTime()));
            statement.setDate(2, new java.sql.Date(order.getDeliveryDate().getTime()));
            statement.setString(3, order.getAddress());
            statement.setInt(4,order.getState().getId());
            statement.setInt(5,order.getOffer().getId());
            statement.setInt(6,order.getCustomer().getId());
            statement.executeUpdate();
        }
        finally {
            connection.close();
        }
    }

    /**
     * Find all orders in database
     * @return  - all orders in data base
     */
    public List<Order> getAll() throws SQLException {
        Connection connection = connectionSource.getConnection();
        List<Order> orders = new LinkedList<>();
        try{
            int id;
            Date creatingDate;
            Date deliveryDate;
            String address;
            OrderState state;
            Offer offer;
            Profile customer;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM order");
            while(rs.next()){
                id = rs.getInt(1);
                creatingDate = rs.getDate(2);
                deliveryDate = rs.getDate(3);
                address = rs.getString(4);
                OrderStateDAO orderStateDAO = new OrderStateDAO(connectionSource);
                state = orderStateDAO.getStateById(rs.getInt(5));
                OfferDAO offerDAO = new OfferDAOMySQL(connectionSource);
                offer = offerDAO.getById(rs.getInt(6));
                ProfileDAO profileDAO = new ProfileDAOMySQL(connectionSource);
                customer = profileDAO.getById(rs.getInt(7));
                Order order = new Order(id, creatingDate, deliveryDate, address, state, offer, customer);
                orders.add(order);
            }
            return orders;
        }
        finally{
            connection.close();
        }
    }

    /**
     * DAO implemented to work with Order States
     */
    private class OrderStateDAO {
        private DAOFactory connectionSource;

        /**
         * Constructor
         * @param connSource source of the connection
         */
        public OrderStateDAO(DAOFactory connSource){
            connectionSource = connSource;
        }

        /**
         * Get state by id
         * @param id state id
         * @return returns OrderState object
         * @throws SQLException
         */
        public OrderState getStateById(int id) throws SQLException {
            Connection connection = connectionSource.getConnection();
            try {
                String name;
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM orderstates WHERE ID = ?");
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    name = rs.getString(2);
                    OrderState.StateNames state;
                    switch(name)
                    {
                        case "Accepted":
                            state = OrderState.StateNames.A;
                            break;

                        case "Declined":
                            state = OrderState.StateNames.D;
                            break;

                        case "Executed":
                            state = OrderState.StateNames.E;
                            break;

                        default:
                            state = OrderState.StateNames.R;
                            break;

                    }
                    return new OrderState(id, state);
                } else
                    throw new IllegalArgumentException();
            }
            finally {
                connection.close();
            }
        }
    }
}
