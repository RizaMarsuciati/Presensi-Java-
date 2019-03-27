/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Dao.Dao.DAOSiswa;
import Implement.ImpDAOSiswa;

/**
 *
 * @author Riza
 */
public class DAOFactorySiswa {
        private static DAOSiswa siswaDAO;
    
    public static DAOSiswa getsiswaDAO () {
        siswaDAO = new ImpDAOSiswa();
        return siswaDAO;
}
}
