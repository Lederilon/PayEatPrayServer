package DAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *Describes the DAO creating
 *@author KostyaHrishenko
 */
public interface DAOFactory {
  /**
   * Create profileDAO
   * @return ProfileDAO
   * @throws SQLException
   */
  public ProfileDAO getProfileDAO() throws SQLException;
  /**
   *Create new connection
   * @return Connection
   * @throws SQLException
   */
  public Connection getConnection() throws SQLException;

}
