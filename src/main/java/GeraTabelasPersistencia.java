
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 20161d13gr0112
 */
public class GeraTabelasPersistencia {
    
    public static void main(String []args){
        
        EntityManagerFactory factory = Persistence.
                     createEntityManagerFactory("persistence");

         factory.close();
    }
}
