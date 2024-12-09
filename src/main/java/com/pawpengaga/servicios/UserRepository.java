package com.pawpengaga.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pawpengaga.modelo.Usuario;

@Repository
public class UserRepository {

  // Se inyecta el jdbc template
  @Autowired
  JdbcTemplate jdbc;

  // Se hace el rowMapper. El rowMapper devuelve los datos y es un simil del resultSet
  // Se usa un lambda para crearlo
  private final RowMapper<Usuario> rowMapper = (rs, rowNum) -> {
    
    Usuario user = new Usuario();
    user.setRut(rs.getString("rut"));
    user.setNombre(rs.getString("nombre"));
    user.setCorreo(rs.getString("correo"));
    user.setClave(rs.getString("clave"));
    user.setUsuario(rs.getString("usuario"));
    return user;

  };

  public List<Usuario> findAll(){
    // Los parametros son (Lo_que_entra, Lo_que_sale)
    return jdbc.query("SELECT * FROM usuarios", rowMapper);
  }

  public Usuario findByRut(String rut){
    return jdbc.queryForObject("SELECT * FROM usuarios WHERE rut = ?", rowMapper, rut);
  }

  public int save(Usuario user){
    String sql = "INSERT INTO usuarios (rot, nombre, correo, clave, usuario) VALUES (?,?,?,?,?)";
    return jdbc.update(sql, user.getRut(), user.getNombre(), user.getCorreo(), user.getClave(), user.getUsuario());
  }

  public int update(Usuario user){
    return jdbc.update("UPDATE usuarios SET nombre = ?, correo = ?, clave = ?, usuario = ? WHERE rut = ?", user.getNombre(), user.getCorreo(), user.getClave(), user.getUsuario(), user.getRut());
  }

  public int deleteByRut(String rut){
    return jdbc.update("DELETE FROM usuarios WHERE rut = ?");
  }


}
