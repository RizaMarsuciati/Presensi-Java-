/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Dao.Dao.DAOThang;
import Implement.ImpDAOThang;

/**
 *
 * @author Riza
 */
public class DAOFactoryThang {
        private static DAOThang thangDAO;
    
    public static DAOThang getthangDAO () {
        thangDAO = new ImpDAOThang();
        return thangDAO;
}
}
