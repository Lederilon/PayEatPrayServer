package DAO;

import domain.Offer;
import domain.Profile;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * OfferDAO implementation for MySQL
 * @author KostyaHrishenko
 */
public class OfferDAOMySQL implements OfferDAO{
    private DAOFactory connectionSource;

    /**
     * Constructor
     * @param connSource - connection source
     */
    public OfferDAOMySQL(DAOFactory connSource){
        connectionSource = connSource;
    }

    /**
     * Create new offer in database
     * @param price - offer price
     * @param name - offer name
     * @param creator - offer creator
     * @return new offer
     * @throws SQLException
     */
    public Offer createOffer(int price, String name, Profile creator) throws SQLException {
        Connection connection = connectionSource.getConnection();
        try {
            int id;
            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO offers(price, name, Profiles_id) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, price);
            statement.setString(2, name);
            statement.setInt(3, creator.getId());
            statement.executeUpdate();
            ResultSet rs =  statement.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                throw new SQLException();
            }
            return new Offer(id, price, name, creator);
        }
        finally {
            connection.close();
        }
    }

    /**
     * Find offer by given Id
     * @param id - to find
     * @return Offer - found offer
     */
    public Offer getById(int id) throws SQLException {
        Connection connection = connectionSource.getConnection();
        try{
            int price;
            String name;
            Profile creator;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM offers WHERE ID = ?");
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                price = rs.getInt(2);
                name = rs.getString(3);
                ProfileDAO profileDAO = new ProfileDAOMySQL(connectionSource);
                creator = profileDAO.getById(rs.getInt(4));
                return new Offer(id, price, name, creator);
            }
            else
                throw new IllegalArgumentException();
        }
        finally{
            connection.close();
        }
    }

    /**
     * Delete Offer with given id
     * @param id - id to delete
     */
    public void deleteById(int id) throws SQLException {
        Connection connection = connectionSource.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM offers WHERE id = ?;");
            statement.setInt(1,id);
            statement.executeUpdate();
        }
        finally{
            connection.close();}
    }

    /**
     * Update given Offer in database
     * @param offer - offer to update
     */
    public void updateOffer(Offer offer) throws SQLException {
        Connection connection = connectionSource.getConnection();
        try {
            PreparedStatement statement =
                    connection.prepareStatement("UPDATE offers SET price = ?,name = ?,Profiles_id = ? WHERE id = ?");
            statement.setInt(4, offer.getId());
            statement.setInt(1, offer.getPrice());
            statement.setString(2, offer.getName());
            statement.setInt(3, offer.getCreator().getId());
            statement.executeUpdate();
        }
        finally {
            connection.close();
        }
    }

    /**
     * Find all offers in database
     * @return  - all offers in data base
     */
    public List<Offer> getAll() throws SQLException {
        Connection connection = connectionSource.getConnection();
        List<Offer> offers = new LinkedList<>();
        try{
            int id;
            int price;
            String name;
            Profile creator;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM offers");
            while(rs.next()){
                id = rs.getInt(1);
                price = rs.getInt(2);
                name = rs.getString(3);
                ProfileDAO profileDAO = new ProfileDAOMySQL(connectionSource);
                creator = profileDAO.getById(rs.getInt(4));
                Offer offer = new Offer(id, price, name, creator);
                offers.add(offer);
            }
            return offers;
        }
        finally{
            connection.close();
        }
    }
}
