/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Connection {
    public static Connection connection = new Connection();
    private EntityManagerFactory emf;

    public Connection() {
        this.emf = Persistence.createEntityManagerFactory("CedulaPU");
    }

    public static Connection getConnection(){
        return Connection.connection;
    }
    
    public EntityManagerFactory getEmf() {
        return emf;
    }
    
    
    
    
}
