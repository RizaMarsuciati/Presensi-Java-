/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Dao.Dao.DAOPelanggaran;
import Entity.Pelanggaran;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import koneksiDB.Koneksi;

/**
 *
 * @author Riza
 */
public class ImpDAOPelanggaran implements DAOPelanggaran{
    private String query;
    private Koneksi koneksiDB;
    private boolean status;
    private ResultSet rsPelanggaran;
    private List<Pelanggaran> listPelanggaran;
    
    public ImpDAOPelanggaran() {
        koneksiDB = new Koneksi ();
        koneksiDB.getKoneksi();
    }

    @Override
    public boolean insertPelanggaran(Pelanggaran pl) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   status = false;
   query = "insert into pelanggaran values ('"
           + pl.getId_pelanggaran()+ "','"
           + pl.getJenis_pelanggaran()+ "','"
           + pl.getPoint_pelanggaran()+ "')"; 
   
   status = koneksiDB.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean updatePelanggaran(Pelanggaran pl) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    status = false;
    query = "update pelanggaran set jenis_pelanggaran = '" + pl.getJenis_pelanggaran()
            + "', poin_pelanggaran = '"+pl.getPoint_pelanggaran()+"' where id_pelanggaran = '" + pl.getId_pelanggaran()+ "'";
    
    status = koneksiDB.eksekusiQuery(query, false);
        return status;

    }

    @Override
    public boolean deletePelanggaran(String id_pelanggaran) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    status = false;
    query = "delete from pelanggaran where id_pelanggaran = '" + id_pelanggaran + "'";
    
    status = koneksiDB.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public List SelectPelanggaranList() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   status = false;
    query = "select * from pelanggaran";
    
    status = koneksiDB.eksekusiQuery(query, true);
    if (status) {
        rsPelanggaran = koneksiDB.getRs();
        listPelanggaran = new ArrayList<Pelanggaran>();
        try {
            while (rsPelanggaran.next()) {
                Pelanggaran pel = new Pelanggaran();
                pel.setId_pelanggaran(rsPelanggaran.getString(1));
                pel.setJenis_pelanggaran(rsPelanggaran.getString(2));
                pel.setPoint_pelanggaran(rsPelanggaran.getString(3));
                listPelanggaran.add(pel);
            }
            rsPelanggaran.close();
            return listPelanggaran;
        } catch (SQLException e) {
            return null;
        }
        }
    return null;
    }

    @Override
    public List TampilCariPelanggaran() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
