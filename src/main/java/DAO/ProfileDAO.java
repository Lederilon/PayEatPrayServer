package DAO;

import domain.Profile;
import domain.ProfileCategory;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Describes work fork for persist Profile
 * @author KostyaHrishenko
 */
public interface ProfileDAO {
    /**
     *Create new profile and ad it ro the data base
     * @param login
     * @param password
     * @param registrationTime
     * @param name
     * @param sex
     * @param eMail
     * @param category
     * @return Profile - created profile
     */
    public Profile createProfile(String login, String password, Date registrationTime, String name, Profile.Sex sex, String eMail, ProfileCategory category) throws SQLException;

    /**
     *find profile by given Id
     * @param id - to find
     * @return Profile - founded profile
     */
    public Profile getById(int id) throws SQLException;

    /**
     *Delete Profile with given id
     * @param id - id to delete
     */
    public void deleteById(int id) throws SQLException;

    /**
     * Update given Profile in data base
     * @param profile - profile to update
     */
    public void updateProfile(Profile profile);

    /**
     *Find all profiles in data base
     * @return  - all profiles in data base
     */
    public List<Profile> getAll() throws SQLException;
}
