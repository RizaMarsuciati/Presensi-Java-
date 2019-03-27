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
import Dao.Dao.DAOAdmin;

/**
 *
 * @author Riza
 */
public class ImpDAOAdmin implements DAOAdmin{
    private Koneksi koneksiDB;
    private String query;
    private boolean status;
    private ResultSet rsLogin;
    
    
    private List<Login> listLogin;
    private String passwords;
    private String username;

    public ImpDAOAdmin(){
    koneksiDB = new Koneksi();
    koneksiDB.getKoneksi();
    }

    @Override
    public boolean ceklogin(String username, String passwords) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   query = "Select nama_petugas,passwords" + " from petugas " 
          + " where nama_petugas='" + username +"'"
          + " and passwords = '" + passwords + "'";
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
    

