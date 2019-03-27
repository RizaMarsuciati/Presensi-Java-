/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Dao.Dao.DAOKasus;
import Implement.ImpDAOKasus;

/**
 *
 * @author Riza
 */
public class DAOFactoryKasus {
          private static DAOKasus kasusDAO;
    
    public static DAOKasus getkasusDAO () {
        kasusDAO = new ImpDAOKasus();
        return kasusDAO;
    
}
}
