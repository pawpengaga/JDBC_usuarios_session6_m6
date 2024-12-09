package com.pawpengaga.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pawpengaga.modelo.Usuario;

public class UserService {

  @Autowired
  UserRepository userRepo;

  public List<Usuario> getAllUsers(){
    return userRepo.findAll();
  }

  public Usuario getUserByRut(String rut){
    return userRepo.findByRut(rut);
  }

  public void createUser(Usuario user){
    userRepo.save(user);
  }

  public void updateUser(Usuario user){
    userRepo.update(user);
  }

  public void deleteUser(String rut){
    userRepo.deleteByRut(rut);
  }

}
