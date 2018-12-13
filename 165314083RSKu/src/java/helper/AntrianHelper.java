/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Antrian;

import util.NewHibernateUtil;

/**
 *
 * @author asus
 */
public class AntrianHelper {

      public AntrianHelper() {

    }

    public List<Antrian> bacaSemuaLokasi() {
        List<Antrian> list = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Antrian l");
        list = q.list();
        tx.commit();
        session.close();
        return list;

    }
    
//     public Antrian cariAntrian(String tanggal) {
//        // Create session
//        Session session = NewHibernateUtil.getSessionFactory().openSession();
//        // Create String query
//        String query = "from antrian u where u.tanggal=:tanggal";
//        Query q = session.createQuery(query);
//        q.setParameter("tanggal", tanggal);
//        // siapkan list,hasil pencarian dan panggil pencarian
//        List<Antrian> list = q.list();
//        // tutuup session
//        session.close();
//
//        if (list.size() > 0) {
//            return list.get(0);
//        } else {
//            return null;
//        }
//    }
     
      public void addNewAntrian(
          Date tanggal, 
          String noRm, 
          String nama, 
          String alamat, 
          String namaKlinik 
  ){
         Session session = NewHibernateUtil.getSessionFactory().openSession();
           Transaction tx = session.beginTransaction();
           Antrian antrian=new Antrian(tanggal,noRm,nama,alamat,namaKlinik);
           session.saveOrUpdate(antrian);
           tx.commit();
           session.close();
  }
    
}
