/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Implement.ImpDAOAdmin;
import Dao.Dao.DAOAdmin;

/**
 *
 * @author Riza
 */
public class DAOFactoryAdmin {
     private static DAOAdmin adminDAO;
    
    
    public static DAOAdmin getadminDAO () {
        adminDAO = new ImpDAOAdmin();
        return adminDAO;
    }
}
