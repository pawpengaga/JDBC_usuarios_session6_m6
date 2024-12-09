package com.pawpengaga.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {

  private String rut;
  private String nombre;
  private String correo;
  private String clave;
  private String usuario;

}
