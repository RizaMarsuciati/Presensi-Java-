/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Dao;

import Entity.Siswa;
import java.util.List;

/**
 *
 * @author Riza
 */
public interface DAOSiswa {
    boolean insertSiswa (Siswa s);
    boolean updateSiswa (Siswa s);
    boolean deleteSiswa (String nis);
    
    List SelectSiswa(String kode, String nama);
    List SelectKelas();
    List SelectKategoriKelas();
    List SelectThang();
}
