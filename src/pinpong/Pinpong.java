/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinpong;

import java.sql.SQLException;


/**
 *
 * @author HOME
 */
public class Pinpong {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Conexion conn = new Conexion();
        conn.PrepararBaseDatos();
        conn.guardarNombre();
        Ventana ventana = new Ventana();
        conn.recogerNombreTiempo();
    }
}
