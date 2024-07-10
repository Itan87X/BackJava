package edu.ar.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

  private static final String URL = "jdbc:mysql://localhost:3306/RegistroUsuarios";
  private static final String USER = "root";
  private static final String PASSWORD = ""; //no muestro la password porque estará público

  public static Connection getConexion() throws SQLException {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      return DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      throw new SQLException("No se encontró el driver de MySQL", e);
    }
  }

  public static void close(Connection conn) {
    try {
      if (conn != null && !conn.isClosed()) {
        conn.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
