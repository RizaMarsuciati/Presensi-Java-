/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Dao.Dao.DAOKasus;
import Entity.Kasus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import koneksiDB.Koneksi;

/**
 *
 * @author Riza
 */
public class ImpDAOKasus implements DAOKasus {
    
    private ResultSet rsKasus, rsIDSiswa, rsIDPelanggaran, rsPoinPelanggaran;
    private String query;
    private Koneksi koneksiDB;
    private boolean status;
    private ResultSet rsSiswa;
    private List<Kasus> listKasus, listIDSiswa, listIDPelanggaran, listPoinPelanggaran;
    
        public ImpDAOKasus() {
        koneksiDB = new Koneksi ();
        koneksiDB.getKoneksi();
    }

    @Override
    public boolean insertKasus(Kasus ks) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       status = false;
   query = "INSERT INTO kasus VALUES('"
           + ks.getId_kasus()+ "','"
           + ks.getNis()+ "','"
           + ks.getId_pelanggaran()+ "','"
           + ks.getKasus_pelanggaran()+ "','"
           + ks.getPoin_pelanggaran()+ "')";
   
   status = koneksiDB.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean updateKasus(Kasus ks) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     status = false;
    query = "UPDATE kasus SET nis = '" + ks.getNis()
            + "', id_pelanggaran = '"+ks.getId_pelanggaran()+"', kasus_pelanggaran = '"+ks.getKasus_pelanggaran()+"', poin_pelanggaran = '"+ks.getPoin_pelanggaran()+"' where id_kasus = '" + ks.getId_kasus()+ "'";
    
    status = koneksiDB.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean deleteKasus(String id_kasus) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       status = false;
    query = "delete from kasus where id_kasus = '" + id_kasus + "'";
    
    status = koneksiDB.eksekusiQuery(query, false);
        return status;
    }
    
    @Override
    public List SelectNis() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    query = "SELECT nama FROM siswa";
    status = koneksiDB.eksekusiQuery(query, true);
    if (status) {
        rsIDSiswa = koneksiDB.getRs();
        listIDSiswa = new ArrayList<Kasus>();
        try{
            while (rsIDSiswa.next()) {
                Kasus kas = new Kasus();
                kas.setNis(rsIDSiswa.getString(1));
                listIDSiswa.add(kas);
            }
            rsIDSiswa.close();
            return listIDSiswa;
        } catch (SQLException e) {
            return null;
        }
    }
        return null;
    }

    @Override
    public List SelectPelanggaran() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   query = "SELECT jenis_pelanggaran FROM pelanggaran";
    status = koneksiDB.eksekusiQuery(query, true);
    if (status) {
        rsIDPelanggaran = koneksiDB.getRs();
        listIDPelanggaran = new ArrayList<Kasus>();
        try{
            while (rsIDPelanggaran.next()) {
                Kasus kas = new Kasus();
                kas.setId_pelanggaran(rsIDPelanggaran.getString(1));
                listIDPelanggaran.add(kas);
            }
            rsIDPelanggaran.close();
            return listIDPelanggaran;
        } catch (SQLException e) {
            return null;
        }
    }
        return null;
    }

    @Override
    public List SelectPoinPelanggaran() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       query = "SELECT poin_pelanggaran FROM pelanggaran";
    status = koneksiDB.eksekusiQuery(query, true);
    if (status) {
        rsIDPelanggaran = koneksiDB.getRs();
        listIDPelanggaran = new ArrayList<Kasus>();
        try{
            while (rsIDPelanggaran.next()) {
                Kasus kas = new Kasus();
                kas.setPoin_pelanggaran(rsIDPelanggaran.getString(1));
                listIDPelanggaran.add(kas);
            }
            rsIDPelanggaran.close();
            return listIDPelanggaran;
        } catch (SQLException e) {
            return null;
        }
    }
        return null;
    }

    @Override
    public List SelectKasus() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    status = false;
    query = "select * from kasus";
    
    status = koneksiDB.eksekusiQuery(query, true);
    if (status) {
        rsKasus = koneksiDB.getRs();
        listKasus = new ArrayList<Kasus>();
        try {
            while (rsKasus.next()) {
                Kasus kas = new Kasus();
                kas.setId_kasus(rsKasus.getString(1));
                kas.setNis(rsKasus.getString(2));
                kas.setId_pelanggaran(rsKasus.getString(3));
                kas.setKasus_pelanggaran(rsKasus.getString(4));
                kas.setPoin_pelanggaran(rsKasus.getString(5));
                listKasus.add(kas);
            }
            rsKasus.close();
            return listKasus;
        } catch (SQLException e) {
            return null;
        }
        }
    return null;

    }
    
}
