/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Dao.Dao.DAOPresensi;
import Entity.Presensi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import koneksiDB.Koneksi;

/**
 *
 * @author Riza
 */
public class ImpDAOPresensi implements DAOPresensi{
    private String query;
    private Koneksi koneksiDB;
    private boolean status;
    private ResultSet rsPresensi, rsIdkategorikelas, rsIdkelas, rsIdsiswa;
    private List<Presensi> listPresensi, listIDkategorikelas, listIDkelas, listIDsiswa;
    
    public ImpDAOPresensi() {
        koneksiDB = new Koneksi ();
        koneksiDB.getKoneksi();
    }

    @Override
    public boolean insertPresensi(Presensi pr) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   status = false;
   query = "insert into presensi values ('"
           + pr.getId_presensi()+ "','"
           + pr.getNis()+ "','"
           + pr.getTgl_presensi()+ "','"
           + pr.getStatus()+ "','"
           + pr.getId_kategori()+ "','"
           + pr.getId_kelas()+ "','"
           + pr.getKet()+ "')";
   
   status = koneksiDB.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean updatePresensi(Presensi pr) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   status = false;
    query = "UPDATE presensi SET nis = '" + pr.getNis()
           + "', tgl_presensi = '"+pr.getTgl_presensi()+"' , status = '"+pr.getStatus()+"' , id_kategori = '"+pr.getId_kategori()+"' , id_kelas = '"+pr.getId_kelas()+"' , ket = '"+pr.getKet()+"' where id_presensi = '" + pr.getId_presensi()+ "'";
    
    status = koneksiDB.eksekusiQuery(query, false);
        return status;

    }

    @Override
    public boolean deletePresensi(String id_presensi) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    status = false;
    query = "delete from presensi where id_presensi = '" + id_presensi + "'";
    
    status = koneksiDB.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public List SelectKategoriKelas() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    query = "SELECT daftar_kelas FROM kategorikelas";
    status = koneksiDB.eksekusiQuery(query, true);
    if (status){
        rsIdkategorikelas = koneksiDB.getRs();
        listIDkategorikelas = new ArrayList<Presensi>();
        try {
            while (rsIdkategorikelas.next()) {
                Presensi pre = new Presensi();
                pre.setId_kategori(rsIdkategorikelas.getString(1));
                listIDkategorikelas.add(pre);
            }
            rsIdkategorikelas.close();
            return listIDkategorikelas;
        } catch (SQLException e){
            return null;
        }
    }
        return null;
    }

    @Override
    public List SelectKelas() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   query = "SELECT nama_kelas FROM kelas";
   status = koneksiDB.eksekusiQuery(query, true);
   if (status){
       rsIdkelas = koneksiDB.getRs();
       listIDkelas = new ArrayList<Presensi>();
       try{
           while (rsIdkelas.next()) {
               Presensi pre = new Presensi();
               pre.setId_kelas(rsIdkelas.getString(1));
               listIDkelas.add(pre);
           }
           rsIdkelas.close();
           return listIDkelas;
       }catch (SQLException e){
           return null;
       }
       
   }
        return null;
    }

    @Override
    public List SelectSiswa() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   query = "SELECT nama FROM siswa";
   status = koneksiDB.eksekusiQuery(query, true);
   if (status){
       rsIdsiswa = koneksiDB.getRs();
       listIDsiswa = new ArrayList<Presensi>();
       try {
           while (rsIdsiswa.next()) {
               Presensi pre = new Presensi();
               pre.setNis(rsIdsiswa.getString(1));
               listIDsiswa.add(pre);
           }
           rsIdsiswa.close();
           return listIDsiswa;
       }catch (SQLException e){
           return null;
       }
   }
        return null;
    }

    @Override
    public List SelectPresensi(String kode, String nama) {
     status = false;
    query = "SELECT id_presensi, nis,tgl_presensi,status,id_kategori,id_kelas,ket FROM presensi "
                + "WHERE id_presensi LIKE '%" + kode + "%' "
                + "OR nis LIKE '%" + nama + "%'";
    
    status = koneksiDB.eksekusiQuery(query, true);
    if (status) {
        rsPresensi = koneksiDB.getRs();
        listPresensi = new ArrayList<Presensi>();
        try {
            while (rsPresensi.next()) {
                Presensi pre = new Presensi();
                pre.setId_presensi(rsPresensi.getString(1));
                pre.setNis(rsPresensi.getString(2));
                pre.setTgl_presensi(rsPresensi.getString(3));
                pre.setStatus(rsPresensi.getString(4));
                pre.setId_kategori(rsPresensi.getString(5));
                pre.setId_kelas(rsPresensi.getString(6));
                pre.setKet(rsPresensi.getString(7));
                listPresensi.add(pre);
            }
            rsPresensi.close();
            return listPresensi;
        } catch (SQLException e) {
            return null;
        }
        }
    return null;
    }
    
}
