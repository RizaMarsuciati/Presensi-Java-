/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Dao;

import Entity.Pelanggaran;
import java.util.List;

/**
 *
 * @author Riza
 */
public interface DAOPelanggaran {
    boolean insertPelanggaran (Pelanggaran pl);
    boolean updatePelanggaran (Pelanggaran pl);
    boolean deletePelanggaran (String id_pelanggaran);
    List TampilCariPelanggaran();
    List SelectPelanggaranList();
}
