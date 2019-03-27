/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Dao;

import Entity.Kelas;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Riza
 */
public interface DAOKelas {
    boolean insertKelas (Kelas kl);
    boolean updateKelas (Kelas kl);
    boolean deleteKleas (String id_kelas);
    
    List SelectKelas();
}
