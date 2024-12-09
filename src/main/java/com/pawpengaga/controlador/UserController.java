package com.pawpengaga.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pawpengaga.modelo.Usuario;
import com.pawpengaga.servicios.UserService;

@Controller
@RequestMapping("/usuarios")
public class UserController {

  @Autowired
  UserService userService;

  int respuesta;

  // Ya se pueden empezar a trabajar los metodos GET y POST
  @GetMapping("/inicio")
  public ModelAndView inicio(){

    String tipo = null;
    String mensaje = null;
    ModelAndView mav = new ModelAndView("inicio");

    if (respuesta != 0) {
      // Por si acaso
      if (respuesta > 0) {
        tipo = "success";
        mensaje = "Registro agregado con éxito!";
      } else {
        tipo = "danger";
        mensaje = "Ha ocurrido un error";
      }
      System.out.println("*************************************************");
      System.out.println("TIPO: " + tipo + ", ALERTA: " + mensaje);
      System.out.println("*************************************************");
    }
    
    List<Usuario> listado = userService.getAllUsers();

    mav.addObject("mensaje", mensaje);
    mav.addObject("tipo", tipo);
    mav.addObject("listado", listado);
    return mav;
  }

  @GetMapping("/formulario")
  public String formulario(){
    return "formulario";
  }

  @PostMapping("/grabar")
  public String grabarUsuario(@ModelAttribute("Usuario") Usuario user){
    respuesta = userService.createUser(user);
    return "redirect:/usuarios/inicio";
  }
  
}
