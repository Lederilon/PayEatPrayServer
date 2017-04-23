package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  Incapsulate connection to the MySQL database
 * @author KostyaHrishernko
 */
public class DAOFactoryMySQL implements DAOFactory {
    private String connectionString;

    /**
     * Create factory for given connectionString
     * @param connectionString
     */
    public DAOFactoryMySQL(String connectionString){
        this.connectionString = connectionString;
    }

    /**
     *
     * @return ProfileDAO- DAO that works with MySQL data base
     * @throws SQLException
     */
    public ProfileDAO getProfileDAO() throws SQLException {       ;
        return new ProfileDAOMySQL(this);
    }

    /**
     *
     * @return Connection - connection to the data base
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionString);
    }
}
