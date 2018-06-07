/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinpong;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
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
  Connection conexion; 
     Statement sentencia; 
     String nombre;
     int Tiempo,Tiempo2,Tiempo3,Tiempo4;
     String sql;
String controlador;
    private Thread t;
 public void PrepararBaseDatos() { 
        try{ 
            controlador="Base.db"; 
            
        } 
        catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "Error al cargar el Controlador");
        } 
        try { 
            String DSN=("jdbc:sqlite:"+controlador); 
            String user=""; 
            String password=""; 
            conexion=DriverManager.getConnection("jdbc:sqlite:/home/local/DANIELCASTELAO/csampedroromero/sqlite-jdbc-3.23.1.jar"); 
        } 
        catch (SQLException e) { 
            JOptionPane.showMessageDialog(null,"Error al realizar la conexion "+e);
        } 
        try { 
            sentencia=conexion.createStatement(); 
        } 
        catch (Exception e) { 
            JOptionPane.showMessageDialog(null,"Error al crear el objeto sentencia "+e);
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
                
            
 

    public void recogerNombreTiempo(){
     
     sql="update into Nombre (Nombre,Tempo,Tempo2,Tempo3,Tempo4) values"+"("+nombre+","+Tiempo+","+Tiempo2+","+Tiempo3+","+Tiempo4+")";
     System.out.println(Tiempo);
     try{
         sentencia.executeUpdate(sql);
     }catch(SQLException ex){
         JOptionPane.showMessageDialog(null, "Error, sus datos no fueron ingresados"+ex);
     }
     
 }
}   