/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Dao.Dao.DAOKategoriKelas;
import Entity.KategoriKelas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import koneksiDB.Koneksi;

/**
 *
 * @author Riza
 */
public class ImpDAOKategoriKelas implements DAOKategoriKelas{
    
    private String query;
    private Koneksi koneksiDB;
    private boolean status;
    private ResultSet rsIDKelas, rsKategoriKelas;
    private List<KategoriKelas> listKategoriKelas, listIDKelas;
    
    public ImpDAOKategoriKelas() {
        koneksiDB = new Koneksi ();
        koneksiDB.getKoneksi();
    }

    @Override
    public boolean insertKategoriKelas(KategoriKelas kk) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   status = false;
   query = "insert into kategorikelas values ('"
           + kk.getId_kategori() + "','"
           + kk.getDaftar_kelas() + "','"
           + kk.getId_kelas() + "')"; 
   
   status = koneksiDB.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean updateKategoriKelas(KategoriKelas kk) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    status = false;
    query = "update kategorikelas set daftar_kelas = '" + kk.getDaftar_kelas()
            + "', id_kelas = '"+kk.getId_kelas()+"' where id_kategori = '" + kk.getId_kategori()+ "'";
    
    status = koneksiDB.eksekusiQuery(query, false);
        return status;
    
    }

    @Override
    public boolean deleteKategoriKleas(String id_kategori) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    status = false;
    query = "delete from kategorikelas where id_kategori = '" + id_kategori + "'";
    
    status = koneksiDB.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public List SelectKategoriKelas() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    status = false;
    query = "select * from kategorikelas";
    
    status = koneksiDB.eksekusiQuery(query, true);
    if (status) {
        rsKategoriKelas = koneksiDB.getRs();
        listKategoriKelas = new ArrayList<KategoriKelas>();
        try {
            while (rsKategoriKelas.next()) {
                KategoriKelas kat = new KategoriKelas();
                kat.setId_kategori(rsKategoriKelas.getString(1));
                kat.setDaftar_kelas(rsKategoriKelas.getString(2));
                kat.setId_kelas(rsKategoriKelas.getString(3));
                listKategoriKelas.add(kat);
            }
            rsKategoriKelas.close();
            return listKategoriKelas;
        } catch (SQLException e) {
            return null;
        }
        }
    return null;
    }

    @Override
    public List SelectKelas() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   query = "SELECT nama_kelas From kelas";
   status =koneksiDB.eksekusiQuery(query, true);
   if (status) {
       rsIDKelas = koneksiDB.getRs();
       listIDKelas = new ArrayList<KategoriKelas>();
       try {
           while (rsIDKelas.next()){
               KategoriKelas katkelas = new KategoriKelas();
               katkelas.setId_kelas(rsIDKelas.getString(1));
               listIDKelas.add(katkelas);
           }
           rsIDKelas.close();
           return listIDKelas;
       } catch (SQLException e) {
           return null;
       }
   }
   return null;
    }
    }
