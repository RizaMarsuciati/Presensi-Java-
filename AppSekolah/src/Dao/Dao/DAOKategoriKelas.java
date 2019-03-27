/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Dao;

import Entity.KategoriKelas;
import java.util.List;

/**
 *
 * @author Riza
 */
public interface DAOKategoriKelas {
    boolean insertKategoriKelas (KategoriKelas kk);
    boolean updateKategoriKelas (KategoriKelas kk);
    boolean deleteKategoriKleas (String id_kategori);
    
    List SelectKategoriKelas();
    List SelectKelas();
    
}
