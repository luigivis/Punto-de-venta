/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Semantic UI
 */
//public class Conexion {
    /*public static Connection getConnection() throws Exception{
  try{






   Connection conn = DriverManager.getConnection( "jdbc:sqlite:C:Ingrid.db");
   System.out.println("Connected");
   return conn;
  } catch(Exception e){System.out.println(e);}
  
  
  return null;
 }
*/
    public class Conexion {


    static Connection contacto = null;
    public static Connection CONN() 
        {
            //tring url = "jdbc:sqlserver://lecasaDB.mssql.somee.com:1433;databaseName=LecasaDB";
            //try 
                //{
                    //Class.forName("com.microsoft.sqlite.jdbc.sqlite");
                //} catch (ClassNotFoundException e) 
                  //  {
                        
                       // JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion... revisar el Driver" + e.getMessage(),"Error de Conexion", JOptionPane.ERROR_MESSAGE);
                    //}
                    try 
                        {
                            contacto = DriverManager.getConnection("jdbc:sqlite:C:Ingrid.db");
                        } catch (SQLException e) 
                            {
                                
                                JOptionPane.showMessageDialog(null, "No es posible conectar con la web" + e.getMessage(), "Error de Conexion",JOptionPane.ERROR_MESSAGE);
                            }
            return contacto;
        }


}

//}
