/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Dao.Dao.DAOKategoriKelas;
import Implement.ImpDAOKategoriKelas;

/**
 *
 * @author Riza
 */
public class DAOFactoryKategoriKelas {
        private static DAOKategoriKelas kategorikelasDAO;
    
    public static DAOKategoriKelas getkategorikelasDAO () {
        kategorikelasDAO = new ImpDAOKategoriKelas();
        return kategorikelasDAO;
}
}
