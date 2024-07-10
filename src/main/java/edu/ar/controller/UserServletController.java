package edu.ar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ar.data.UsuariosDAO;
import edu.ar.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/users")
public class UserServletController extends HttpServlet {
static Logger logger = LoggerFactory.getLogger(UserServletController.class);
  List<Usuario> usersList = new ArrayList<>();
  ObjectMapper mapper = new ObjectMapper();


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("application/json; charset=UTF-8");
    List<Usuario> usersList = UsuariosDAO.obtener();
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(res.getWriter(), usersList);
  }
}
