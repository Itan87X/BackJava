package edu.ar.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import edu.ar.model.Usuario;

public class UsuariosDAO {

  private static final String SQL_SELECT = "SELECT * FROM Usuario";

  public static List<Usuario> obtener() {
    List<Usuario> usuarios = new ArrayList<>();
    try (Connection conn = Conexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(SQL_SELECT);
         ResultSet rs = ps.executeQuery()) {

      while (rs.next()) {
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String email = rs.getString("email");
        Usuario usuario = new Usuario(id, nombre, email);
        usuarios.add(usuario);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return usuarios;
  }
}
