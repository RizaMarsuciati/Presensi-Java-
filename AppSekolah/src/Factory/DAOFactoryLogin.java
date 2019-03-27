/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;


import Dao.Dao.DAOLogin;
import Implement.ImpDAOLogin;

/**
 *
 * @author Riza
 */
public class DAOFactoryLogin {
    private static DAOLogin loginDAO;
    
    
    public static DAOLogin getloginDAO () {
        loginDAO = new ImpDAOLogin();
        return loginDAO;
    }
}
