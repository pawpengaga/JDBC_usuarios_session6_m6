package com.pawpengaga.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawpengaga.modelo.Usuario;

@Service
public class UserService {

  @Autowired
  UserRepository userRepo;

  public List<Usuario> getAllUsers(){
    return userRepo.findAll();
  }

  public Usuario getUserByRut(String rut){
    return userRepo.findByRut(rut);
  }

  public int createUser(Usuario user){
    return userRepo.save(user);
  }

  public int updateUser(Usuario user){
    return userRepo.update(user);
  }

  public int deleteUser(String rut){
    return userRepo.deleteByRut(rut);
  }

}
