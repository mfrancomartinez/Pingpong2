/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinpong;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Marcos
 */
public class Conexion {
  Connection conexion = null; 
   Statement sentencia;
     String nombre;
     int Tiempo,Tiempo2,Tiempo3,Tiempo4;
     String sql;
String controlador;
    private Thread t;
 public void PrepararBaseDatos() throws ClassNotFoundException, SQLException {        
    try
    {        
      conexion = DriverManager.getConnection("jdbc:sqlite:Base.db");
      sentencia = conexion.createStatement();

     } catch(SQLException e)
    {      
      System.err.println(e.getMessage());
    }
    finally
    {
      try
      {
        if(conexion != null)
          conexion.close();
      }
      catch(SQLException e)
      {
        // Fallo de cierre de conexion.
        System.err.println(e);
      }
    }
        
        
        
 }
 
 public void guardarNombre(){
     nombre = JOptionPane.showInputDialog("Inserta el nombre de los contrincantes.");
 }
 public void Tempo(){
     Thread t = null;
     ArrayList <Integer> a= new ArrayList<>();
     int h=0,m=0,s=0,cs = 0;
            this.t = new Thread();
     
                    
                      try{
                          sleep(10);
                      
                        cs++;
                        if(cs==100){
                            cs=0;
                            ++s;
                        }
                        if(s==60){
                            s=0;
                            ++m;
                        }
                        if(m==60){
                            m=0;
                            ++h;}
                        
                        } 
                      
                      catch (Exception e) {
             System.out.println("NO");
         }
Tiempo=cs;Tiempo2=s;Tiempo3=m;Tiempo4=h;
                        
         if(Ventana.setVisible==true){
             t.start();
         }else{
             t.stop();
         }           
}
                
            
 

    public void recogerNombreTiempo() throws SQLException{
      sentencia.executeUpdate("drop table if exists Nombre");
      sentencia.executeUpdate("create table Nombre (nombre string, Tempo float, Tempo2 float, Tempo3 float, Tempo4 float);");
      sentencia.executeUpdate("insert into Nombre values("+nombre+","+Tiempo+","+Tiempo2+","+Tiempo3+","+Tiempo4+");");
      ResultSet rs = sentencia.executeQuery("select * from Nombre;");
      while(rs.next())
      {        
        System.out.println("Nombres de los contrincantes = " + rs.getString("nombre"));
        System.out.println("Tiempo = " + rs.getFloat("Tempo"));
      }  
     
     
 }
}   