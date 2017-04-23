package DAO;

import domain.Profile;
import domain.ProfileCategory;

import java.sql.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * ProfileDAO implementation for MySQL
 * @author KostyaHrishenko
 */
public class ProfileDAOMySQL implements ProfileDAO{
    private DAOFactory connectionSource;
    public ProfileDAOMySQL(DAOFactory connSource){
        connectionSource = connSource;
    }

    /**
     * @param login
     * @param password
     * @param registrationTime
     * @param name
     * @param sex
     * @param eMail
     * @param category
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
     *
     * @param id
     * @return
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
                //!!!!!!!Change after adding categoryDAO
                category = new ProfileCategory(rs.getInt(8),ProfileCategory.CategoryNames.C);
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
     *
     * @param id
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
     *
     * @param profile
     */
    public void updateProfile(Profile profile) {

    }

    /**
     *
     * @return
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
                //!!!!!!!Change after adding categoryDAO
                 category = new ProfileCategory(rs.getInt(8),ProfileCategory.CategoryNames.C);
                Profile profile =  new Profile(id,login,password,creationDate,name,sex,eMail,category);
                profiles.add(profile);
            }
          return profiles;
        }
        finally{
            connection.close();
        }
    }
}
