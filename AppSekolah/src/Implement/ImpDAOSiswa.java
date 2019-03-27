/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Dao.Dao.DAOSiswa;
import Entity.Siswa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import koneksiDB.Koneksi;

/**
 *
 * @author Riza
 */
public class ImpDAOSiswa implements DAOSiswa {
    private ResultSet rsIDKelas, rsIDKategoriKelas, rsIDThang;
    private String query;
    private Koneksi koneksiDB;
    private boolean status;
    private ResultSet rsSiswa;
    private List<Siswa> listSiswa, listIDkategoriKelas, listIDKelas, listIDThang;
    
    public ImpDAOSiswa() {
        koneksiDB = new Koneksi ();
        koneksiDB.getKoneksi();
    }
    @Override
    public boolean insertSiswa(Siswa s) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    status = false;
   query = "INSERT INTO siswa VALUES('"
           + s.getNis()+ "','"
           + s.getId_kelas()+ "','"
           + s.getId_thang()+ "','"
           + s.getNama()+ "','"
           + s.getJenkel()+ "','"
           + s.getTempat_lahir()+ "','"
           + s.getTgl_lahir()+ "','"
           + s.getAlamat()+ "','"
           + s.getNo_telp()+ "','"
           + s.getId_kategori()+ "')";
   
   status = koneksiDB.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean updateSiswa(Siswa s) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    status = false;
    query = "UPDATE siswa SET id_kelas = '" + s.getId_kelas()
           + "', id_thang = '"+s.getId_thang()+"', nama = '"+s.getNama()+"' , jenkel = '"+s.getJenkel()+"' , tempat_lahir = '"+s.getTempat_lahir()+"' , tgl_lahir = '"+s.getTgl_lahir()+"' , alamat = '"+s.getAlamat()+"', no_telp = '"+s.getNo_telp()+"', id_kategori = '"+s.getId_kategori()+"' where nis = '" + s.getNis()+ "'";
    
    status = koneksiDB.eksekusiQuery(query, false);
        return status;

    }

    @Override
    public boolean deleteSiswa(String nis) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    status = false;
    query = "delete from siswa where nis = '" + nis + "'";
    
    status = koneksiDB.eksekusiQuery(query, false);
        return status;
    
    }


    @Override
    public List SelectKelas() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    query = "SELECT nama_kelas FROM kelas";
    status = koneksiDB.eksekusiQuery(query, true);
    if (status) {
        rsIDKelas = koneksiDB.getRs();
        listIDKelas = new ArrayList<Siswa>();
        try{
            while (rsIDKelas.next()) {
                Siswa sis = new Siswa();
                sis.setId_kelas(rsIDKelas.getString(1));
                listIDKelas.add(sis);
            }
            rsIDKelas.close();
            return listIDKelas;
        } catch (SQLException e) {
            return null;
        }
    }
        return null;
    }

    @Override
    public List SelectKategoriKelas() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    query = "SELECT daftar_kelas FROM kategorikelas";
   status = koneksiDB.eksekusiQuery(query, true);
   if (status) {
       rsIDKategoriKelas = koneksiDB.getRs();
       listIDkategoriKelas = new ArrayList<Siswa>();
       try {
           while (rsIDKategoriKelas.next()) {
               Siswa sis = new Siswa();
               sis.setId_kategori(rsIDKategoriKelas.getString(1));
               listIDkategoriKelas.add(sis);
           }
           rsIDKategoriKelas.close();
           return listIDkategoriKelas;
       } catch(SQLException e) {
           return null;
       }
   }
        return null;
    }

    @Override
    public List SelectThang() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    query = "SELECT tahun FROM thang";
    status = koneksiDB.eksekusiQuery(query, true);
    if (status) {
    rsIDThang = koneksiDB.getRs();
    listIDThang = new ArrayList<Siswa>();
    try {
        while (rsIDThang.next()) {
            Siswa sis = new Siswa();
            sis.setId_thang(rsIDThang.getString(1));
            listIDThang.add(sis);
        }
        rsIDThang.close();
        return listIDThang;
        } catch (SQLException e) {
            return null;
        }
    }
        return null;
    }

    @Override
    public List SelectSiswa(String kode, String nama) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   status = false;
    query = "SELECT nis, id_kelas,id_thang,nama, jenkel,tempat_lahir,tgl_lahir,alamat,no_telp,id_kategori FROM siswa "
                + "WHERE nis LIKE '%" + kode + "%' "
                + "OR nama LIKE '%" + nama + "%'";
    
    status = koneksiDB.eksekusiQuery(query, true);
    if (status) {
        rsSiswa = koneksiDB.getRs();
        listSiswa = new ArrayList<Siswa>();
        try {
            while (rsSiswa.next()) {
                Siswa sis = new Siswa();
                sis.setNis(rsSiswa.getString(1));
                sis.setId_kelas(rsSiswa.getString(2));
                sis.setId_thang(rsSiswa.getString(3));
                sis.setNama(rsSiswa.getString(4));
                sis.setJenkel(rsSiswa.getString(5));
                sis.setTempat_lahir(rsSiswa.getString(6));
                sis.setTgl_lahir(rsSiswa.getString(7));
                sis.setAlamat(rsSiswa.getString(8));
                sis.setNo_telp(rsSiswa.getString(9));
                sis.setId_kategori(rsSiswa.getString(10));
                listSiswa.add(sis);
            }
            rsSiswa.close();
            return listSiswa;
        } catch (SQLException e) {
            return null;
        }
        }
    return null;
           }
    }

    

