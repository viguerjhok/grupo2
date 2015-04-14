/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_oracle;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author alumno04
 */
public class ConexionOracle {
   

  
    public Connection AbrirConexion(){
       Connection cn = conxionDB.conectar();  
       return cn;
    }
    public static void main(String[] args) {
         ConexionOracle co= new ConexionOracle();
//        if(conexionDB.conectar()== null){
//            System.out.println("lA CONEXION FUE UN ÉXITO");
//        }
//        else {
//            System.out.println(" la conexion fue un exito");
//        }
//    }
//   metodo  que se inserta  un registro en la bgase de datos 
       
        co.insert();
        
}
    public void insert(){
    Statement  st = null;
    String query = "INSERT INTO PERSONA VALUES(1,'REDER','TANTARICO','RIOJA´','6615307 )";
    try {
       st = AbrirConexion().createStatement(); 
       st =  conxionDB.conectar().createStatement();
       st.executeUpdate(query);
      AbrirConexion().commit();
      AbrirConexion().close();
    }
    catch (Exception e){
        e.printStackTrace();
    try {
      AbrirConexion().rollback();
      AbrirConexion().close();
        
    } catch (Exception ex){ }
        }
    
    }
}
