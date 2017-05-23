package DAO;

import domain.Offer;
import domain.Profile;

import java.sql.SQLException;
import java.util.List;

/**
 * Describes work fork for persist Offer
 * @author KostyaHrishenko
 */
public interface OfferDAO {
    /**
     * Create new offer in database
     * @param price - offer price
     * @param name - offer name
     * @param creator - offer creator
     * @return new offer
     * @throws SQLException
     */
    public Offer createOffer(int price, String name, Profile creator) throws SQLException;

    /**
     * Find offer by given Id
     * @param id - to find
     * @return Offer - found offer
     */
    public Offer getById(int id) throws SQLException;

    /**
     * Delete Offer with given id
     * @param id - id to delete
     */
    public void deleteById(int id) throws SQLException;

    /**
     * Update given Offer in database
     * @param offer - offer to update
     */
    public void updateOffer(Offer offer) throws SQLException;

    /**
     * Find all offers in database
     * @return  - all offers in data base
     */
    public List<Offer> getAll() throws SQLException;
}
