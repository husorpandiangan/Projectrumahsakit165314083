/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Location;
import util.NewHibernateUtil;

/**
 *
 * @author asus
 */
public class LokasiHelper {
      public LokasiHelper() {

    }

    public List<Location> bacaSemuaLokasi() {
        List<Location> list = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Location l");
        list = q.list();
        tx.commit();
        session.close();
        return list;

    }
}
