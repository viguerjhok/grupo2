/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_oracle;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alumno04
 */
public class conxionDB {
    public static  Connection conectar(){
        Connection cn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
             cn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","prueva2","viguerjhok");
        } catch (Exception e) {  e.printStackTrace();}
       return cn;
    }
}
