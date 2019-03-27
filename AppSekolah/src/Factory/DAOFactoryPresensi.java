/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Dao.Dao.DAOPresensi;
import Implement.ImpDAOPresensi;

/**
 *
 * @author Riza
 */
public class DAOFactoryPresensi {
        private static DAOPresensi presensiDAO;
    
    public static DAOPresensi getpresensiDAO () {
        presensiDAO = new ImpDAOPresensi();
        return presensiDAO;
}
}
