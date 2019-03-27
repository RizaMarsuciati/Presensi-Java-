/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Dao;

import Entity.Presensi;
import java.util.List;

/**
 *
 * @author Riza
 */
public interface DAOPresensi {
    boolean insertPresensi (Presensi pr);
    boolean updatePresensi (Presensi pr);
    boolean deletePresensi (String id_presensi);
    
    List SelectPresensi(String kode, String nama);
    List SelectKategoriKelas();
    List SelectKelas();
    List SelectSiswa();
}
