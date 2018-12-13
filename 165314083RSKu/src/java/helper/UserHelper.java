/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.User;
import util.NewHibernateUtil;

/**
 *
 * @author asus
 */
public class UserHelper {

    public UserHelper() {

    }

     public User login(String email,String password){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String q = "From User a where a.email=:email AND a.password =:password";
        
        Query query = session.createQuery(q);
        query.setParameter("email", email);
        query.setParameter("password", password);
        
        return (User) query.uniqueResult();
    }

    
    public User cariUser(String email) {
        // Create session
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        // Create String query
        String query = "from User u where u.email=:email";
        Query q = session.createQuery(query);
        q.setParameter("email", email);
        // siapkan list,hasil pencarian dan panggil pencarian
        List<User> list = q.list();
        // tutuup session
        session.close();

        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

}
