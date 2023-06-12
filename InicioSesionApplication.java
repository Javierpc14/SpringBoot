package com.example.InicioSesion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InicioSesionApplication {

	public static void main(String[] args) {
		SpringApplication.run(InicioSesionApplication.class, args);
	}

}

/**
 * Primero construyo mis 4 vistas(html) en la carpeta static
 *  1 - login html se enlaza con un a a otra vista
 *  2 - registro
 *      - En login y registro solo hay que hacer buscar y añadir si no esta en la BD.
 *      - Static entityManager.find();
 * a
 *  3 - base de datos que liste
 *  4 - base de datos que administre
 * a
 *  Formato del login
 * -                login Titulo(Iniciar Sesion)
 * -                        usuario
 * -                      contraseña
 * -                   boton iniciar sesion
 * - enlace que lleve a registro en caso de que no este logeado
 *a
 * Tabla Campos
 *  id  Nombre  Password    Rol
 *   1  Pepe    1234        1   --> Es administrador se le envia a la BD administre
 *   2  Lola    123456      0   --> Es usuario se le envia a la BD que liste
 *a
 *   -- Con esto se comprueba si es administrador o no y se le envia a la pagina que le corresponda
 *   if(usuario.rol == 0){
 *       document(location: "enlace_pagina_a_la_que_se_le_evia");
 *   }
 *a
 *   -- La base de datos esta formada po:
 *      1 - Tabla usuarios es registro habra administradores y no
 *      2 - Tabla alumnos con las notas
 *a
 *   -- Registro, saldra:
 *      1 - Nombre
 *      2 - Contraseña
 *      3 - codigo de administrador (1234 por ejemplo) si lo mete bien es administrador y se le asigna un 1 al rol
 */
