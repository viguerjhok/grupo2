/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_oracle;

import com.sun.jmx.snmp.daemon.SnmpInformRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

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
       
      //  co.insert();
        // se muestra los registros de la db
        co.Select();
         //se elimina
        // co.Delete(1);
}
    public void insert(){
    Statement  st = null;
    String query = "INSERT INTO PERSONA VALUES(1,'REDER','TANTARICO','RIOJA´','6615307 )";
    try {
       st = AbrirConexion().createStatement(); 
       st.executeUpdate(query);
      AbrirConexion().commit();
      AbrirConexion().close();
        System.out.println(" SE INSERTÓ SATISFACTORIAMENTE");   
    } catch (Exception e){
        e.printStackTrace();
    try {
      AbrirConexion().rollback();
      AbrirConexion().close();
        
    } catch (Exception ex){ }
    }
    }
    
     
    
    public void Select(){
       Statement st = null;
       ResultSet rs =null;
       String query =  "SELECT * FROM PERSONA ";
        try {
            st = AbrirConexion().createStatement();
            rs= st.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID:"+rs.getInt("IDPERSONA")+", NOMBRE:"+rs.getString("NOMBRE")+", APELLIDO_PAT:"+
                rs.getString("APELLIDO_PAT")+"APELLIDO_MAT:"+rs.getString("APELLIDO_MAT")+",DNI:"+rs.getInt("DNI"));
                
            }
            AbrirConexion().close();
            
            
        } catch (Exception e) { 
            e.printStackTrace(); try {
                AbrirConexion().close();
            } catch (Exception ex) {
            }
        }
    }
    public void Delete( int ID){
        Statement st=  null;
        String query = "DELETE * FROM PERSONA WHERE IDPERSONA="+ID;
        try{
    st = AbrirConexion().createStatement();
     st.executeUpdate(query);
      AbrirConexion().commit();
      AbrirConexion().close();
  } catch (Exception e) { 
            e.printStackTrace();
            
            try {
                 AbrirConexion().rollback();
                 AbrirConexion().close();
            } catch (Exception ex) {
            }
        }
   }
    
  public void Update(int ID, String NOMBRE,String APELLIDO_PAT,String APELLIDO_MAT,int DNI){
    
    Statement st=null;
    String query ="UPDATE PERSONA SET NOMBRE:"+NOMBRE+", APELLIDO_PAT:"+APELLIDO_MAT
            +", APELLIDO_MAT:"+ APELLIDO_MAT+",DNI:"+DNI+"WHERE  IDPERSONA="+ID;
     try{
    st = AbrirConexion().createStatement();
     st.executeUpdate(query);
      AbrirConexion().commit();
      AbrirConexion().close();
  } catch (Exception e) { 
            e.printStackTrace();
            
            try {
                 AbrirConexion().rollback();
                 AbrirConexion().close();
            } catch (Exception ex) {
            }
        }
    }
}
