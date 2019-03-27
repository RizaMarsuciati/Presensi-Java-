/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Dao.Dao.DAOKelas;
import Entity.Kelas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import koneksiDB.Koneksi;

/**
 *
 * @author Riza
 */
public class ImpDAOKelas implements DAOKelas{
    
    private String query;
    private Koneksi koneksidb;
    private boolean status;
    private ResultSet rsKelas;
    private List<Kelas> listKelas;
    
    public ImpDAOKelas() {
        koneksidb = new Koneksi();
        koneksidb.getKoneksi();
    }
    
    public List selectIDKELAS(){
        query = "SELECT id_kelas FROM kelas";
        status = koneksidb.eksekusiQuery(query, true);
        if (status){
            rsKelas = koneksidb.getRs();
            listKelas = new ArrayList<>();
            try {
                while (rsKelas.next()){
                    Kelas kategoriKelas = new Entity.Kelas();
                    kategoriKelas.setId_kelas(rsKelas.getString(1));
                    listKelas.add(kategoriKelas);
                }
                rsKelas.close();
                return listKelas;
            } catch (SQLException e){
                return null;
            }
            
            
        }
        return null;
    }

    @Override
    public boolean insertKelas(Kelas kl) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   status = false;
   query = "insert into kelas values ('"
           + kl.getId_kelas()+ "','"
           + kl.getNama_kelas()+ "')"; 
   
    status = koneksidb.eksekusiQuery(query, false);
        return status;
   
    }

    @Override
    public boolean updateKelas(Kelas kl) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    status = false;
    query = "update kelas set nama_kelas = '" + kl.getNama_kelas()
            + "' where id_kelas = '" + kl.getId_kelas()+ "'";
    
    status = koneksidb.eksekusiQuery(query, false);
        return status;
    
    }

    @Override
    public boolean deleteKleas(String id_kelas) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   status= false;
   query = "delete from kelas where id_kelas = '" + id_kelas + "'";
   
   status = koneksidb.eksekusiQuery(query, false);
        return status;
   
    }

    @Override
    public List SelectKelas() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    status = false;
    query = "select * from kelas";
   
        status = koneksidb.eksekusiQuery(query, true);
    if (status) {
        rsKelas = koneksidb.getRs();
        listKelas = new ArrayList<Kelas>();
        try {
            while (rsKelas.next()) {
                Kelas kls = new Kelas();
                kls.setId_kelas(rsKelas.getString(1));
                kls.setNama_kelas(rsKelas.getString(2));
                listKelas.add(kls);
            }
            rsKelas.close();
            return listKelas;
        } catch (SQLException e) {
            return null;
        }
        }
    return null;
    }
    
    }