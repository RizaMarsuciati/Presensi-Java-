/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Dao;

import Entity.Kasus;
import java.util.List;

/**
 *
 * @author Riza
 */
public interface DAOKasus {
    boolean insertKasus (Kasus ks);
    boolean updateKasus (Kasus ks);
    boolean deleteKasus (String id_kasus);
    
    List SelectKasus();
    List SelectNis();
    List SelectPelanggaran();
    List SelectPoinPelanggaran();
    
}

