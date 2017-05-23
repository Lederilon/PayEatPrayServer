package DAO;

import domain.Profile;
import domain.ProfileCategory;

import java.sql.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static domain.ProfileCategory.*;
import static domain.ProfileCategory.CategoryNames.*;

/**
 * ProfileDAO implementation for MySQL
 * @author KostyaHrishenko
 */
public class ProfileDAOMySQL implements ProfileDAO{
    private DAOFactory connectionSource;

    /**
     * Constructor
     * @param connSource - connection source
     */
    public ProfileDAOMySQL(DAOFactory connSource){
        connectionSource = connSource;
    }

    /**
     * Create new profile in database
     * @param login profile login
     * @param password prifile password
     * @param registrationTime registration time
     * @param name profile name
     * @param sex profile sex
     * @param eMail profile eMail
     * @param category profile category
     * @return Profile
     */
    public Profile createProfile(String login, String password, Date registrationTime, String name, Profile.Sex sex, String eMail, ProfileCategory category) throws SQLException {
        Connection connection = connectionSource.getConnection();
        try {
          int id;
          PreparedStatement statement =
                  connection.prepareStatement("INSERT INTO profiles(name,login,password,email,registertime,sex,profilecategories_id) VALUES(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
          statement.setString(2,login);
          statement.setString(3,password);
          statement.setDate(5,new java.sql.Date(registrationTime.getTime()));
          statement.setString(1,name);
          statement.setString(6,sex.getName());
          statement.setString(4,eMail);
          statement.setInt(7,category.getId());
          statement.executeUpdate();
          ResultSet rs =  statement.getGeneratedKeys();
          if (rs.next()) {
               id = rs.getInt(1);
           } else {
                throw new SQLException();
           }
           return new Profile(id,login,password,registrationTime,name,sex,eMail,category);
       }
       finally {
           connection.close();
       }
    }

    /**
     * Get profile from database by id
     * @param id profile id
     * @return profile
     * @throws SQLException
     */
    public Profile getById(int id) throws SQLException {
        Connection connection = connectionSource.getConnection();
        try{
            String name;
            String login;
            String password;
            String eMail;
            Profile.Sex sex;
            ProfileCategory category;
            Date creationDate;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM profiles WHERE ID = ?");
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                name = rs.getString(2);
                login = rs.getString(3);
                password = rs.getString(4);
                eMail = rs.getString(5);
                creationDate = rs.getDate(6);
                sex = Profile.Sex.valueOf(rs.getString(7));
                CategoryDAO categoryDAO = new CategoryDAO(connectionSource);
                category = categoryDAO.getCategoryById(rs.getInt(8));
                return new Profile(id,login,password,creationDate,name,sex,eMail,category);
            }
           else
               throw new IllegalArgumentException();
        }
        finally{
            connection.close();
        }
    }

    /**
     * Delete profile from database by id
     * @param id profile id
     * @throws SQLException
     */
    public void deleteById(int id) throws SQLException {
        Connection connection = connectionSource.getConnection();
        try{
           PreparedStatement statement = connection.prepareStatement("DELETE FROM profiles WHERE id = ?;");
           statement.setInt(1,id);
           statement.executeUpdate();
        }
        finally{
            connection.close();}
    }

    /**
     * Update given Profile in database
     * @param profile - profile to update
     */
    public void updateProfile(Profile profile) throws SQLException{
        Connection connection = connectionSource.getConnection();
        try {
            PreparedStatement statement =
                    connection.prepareStatement("UPDATE profiles SET name = ?,login = ?,password = ?,email = ?,registertime = ?,sex = ?,profilecategories_id = ? WHERE id = ?");
            statement.setInt(8, profile.getId());
            statement.setString(2, profile.getLogin());
            statement.setString(3, profile.getPassword());
            statement.setDate(5,new java.sql.Date(profile.getRegistrationTime().getTime()));
            statement.setString(1,profile.getName());
            statement.setString(6,profile.getSex().getName());
            statement.setString(4, profile.getEmail());
            statement.setInt(7,profile.getCategory().getId());
            statement.executeUpdate();
        }
        finally {
            connection.close();
        }
    }

    /**
     * Get all profiles from profiles table in database
     * @return list of all profiles
     * @throws SQLException
     */
    public List<Profile> getAll() throws SQLException {
        Connection connection = connectionSource.getConnection();
        List<Profile> profiles = new LinkedList<Profile>();
        try{
            int id;
            String name;
            String login;
            String password;
            String eMail;
            Profile.Sex sex;
            ProfileCategory category;
            Date creationDate;
            int categoryCode;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM profiles");
             while(rs.next()){
                id = rs.getInt(1);
                name = rs.getString(2);
                login = rs.getString(3);
                password = rs.getString(4);
                eMail = rs.getString(5);
                creationDate = rs.getDate(6);
                sex = Profile.Sex.valueOf(rs.getString(7));
                categoryCode = rs.getInt(8);
                CategoryDAO dao = new CategoryDAO(connectionSource);
                category = dao.getCategoryById(categoryCode);
                Profile profile =  new Profile(id,login,password,creationDate,name,sex,eMail,category);
                profiles.add(profile);
            }
          return profiles;
        }
        finally{
            connection.close();
        }
    }

    /**
     * DAO implemented to work with Categories
     */
    private class CategoryDAO {
        private DAOFactory connectionSource;

        /**
         * Constructor
         * @param connSource source of the connection
         */
        public CategoryDAO(DAOFactory connSource){
            connectionSource = connSource;
        }

        /**
         * Get category by id
         * @param id category id
         * @return returns ProfileCategory object
         * @throws SQLException
         */
        public ProfileCategory getCategoryById(int id) throws SQLException {
            Connection connection = connectionSource.getConnection();
            try {
                String name;
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM profilecategories WHERE ID = ?");
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    name = rs.getString(2);
                    CategoryNames category;
                    switch(name)
                    {
                        case "Delivery Service":
                            category = D;
                            break;

                        case "Catering facilities":
                            category = F;
                            break;

                        default:
                            category = C;
                            break;

                    }
                    return new ProfileCategory(id, category);
                } else
                    throw new IllegalArgumentException();
            }
            finally {
                connection.close();
            }
        }
    }
}
