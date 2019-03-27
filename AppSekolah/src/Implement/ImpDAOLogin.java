/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Dao.Dao.DAOLogin;
import Entity.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import koneksiDB.Koneksi;









/**
 *
 * @author candraka21
 */
public class ImpDAOLogin implements DAOLogin {



  

    private Koneksi koneksiDB;
    private String query;
    private boolean status;
    private ResultSet rsLogin;
    
    
    private List<Login> listLogin;
    private String password;
    private String username;

    public ImpDAOLogin(){
    koneksiDB = new Koneksi();
    koneksiDB.getKoneksi();
    }

    @Override
    public boolean ceklogin(String username, String password) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  query = "Select nama_petugas,password" + " from petugas " 
          + " where nama_petugas='" + username +"'"
          + " and password = '" + password + "'";
        status = koneksiDB.eksekusiQuery(query, true);
        if (status) {
            rsLogin = koneksiDB.getRs();
          
            
            try{
                rsLogin.next();
                rsLogin.getString(1);
                        if (rsLogin == null){
                            status = false;
                        } else {
                            status = true;
                        }
        } catch (SQLException se) {
                
                status = false;
                }
        
    }
        return status;
    

    }
}
    
    
    

