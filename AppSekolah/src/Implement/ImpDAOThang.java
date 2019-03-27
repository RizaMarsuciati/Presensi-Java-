/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Dao.Dao.DAOThang;
import Entity.Thang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import koneksiDB.Koneksi;

/**
 *
 * @author Riza
 */
public class ImpDAOThang implements DAOThang{
    
    private String query;
    private Koneksi koneksidb;
    private boolean status;
    private ResultSet rsThang;
    private List<Thang> listThang;
    
    public ImpDAOThang() {
        koneksidb = new Koneksi();
        koneksidb.getKoneksi();
    }

    @Override
    public boolean insertThang(Thang t) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    status = false;
   query = "insert into thang values ('"
           + t.getId_thang()+ "','"
           + t.getTahun()+ "')"; 
   
    status = koneksidb.eksekusiQuery(query, false);
        return status;
   
    }

    @Override
    public boolean updateThang(Thang t) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    status = false;
    query = "update thang set tahun = '" + t.getTahun()
            + "' where id_thang = '" + t.getId_thang()+ "'";
    
    status = koneksidb.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean deleteThang(String id_thang) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    status= false;
   query = "delete from thang where id_thang = '" + id_thang + "'";
   
   status = koneksidb.eksekusiQuery(query, false);
        return status;
   
    
    }

    @Override
    public List SelectThang() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   status = false;
    query = "select * from thang";
   
        status = koneksidb.eksekusiQuery(query, true);
    if (status) {
        rsThang = koneksidb.getRs();
        listThang = new ArrayList<Thang>();
        try {
            while (rsThang.next()) {
                Thang th = new Thang();
                th.setId_thang(rsThang.getString(1));
                th.setTahun(rsThang.getString(2));
                listThang.add(th);
            }
            rsThang.close();
            return listThang;
        } catch (SQLException e) {
            return null;
        }
        }
    return null;
    
    }
    
}
