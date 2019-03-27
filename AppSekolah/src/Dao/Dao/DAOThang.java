/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Dao;

import Entity.Thang;
import java.util.List;

/**
 *
 * @author Riza
 */
public interface DAOThang {
    boolean insertThang (Thang t);
    boolean updateThang (Thang t);
    boolean deleteThang (String id_thang);
    
    List SelectThang();
}
