/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Dao.Dao.DAOPelanggaran;
import Implement.ImpDAOPelanggaran;

/**
 *
 * @author Riza
 */
public class DAOFactoryPelanggaran {
        private static DAOPelanggaran pelanggaranDAO;
    
    public static DAOPelanggaran getpelanggaranDAO () {
        pelanggaranDAO = new ImpDAOPelanggaran();
        return pelanggaranDAO;
}
}
