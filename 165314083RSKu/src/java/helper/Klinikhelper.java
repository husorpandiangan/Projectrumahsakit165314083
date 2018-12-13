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
import pojos.Klinik;

import util.NewHibernateUtil;

/**
 *
 * @author asus
 */
public class Klinikhelper {
    
    public List<Klinik> bacaSemuaLokasi() {
        List<Klinik> list = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Klinik l");
        list = q.list();
        tx.commit();
        session.close();
        return list;

    }
    
      public void addNewKlinik(
          String idKlinik, 
          String nama, 
          String spesialis
  ){
         Session session = NewHibernateUtil.getSessionFactory().openSession();
           Transaction tx = session.beginTransaction();
           Klinik pasien=new Klinik(idKlinik,nama,spesialis);
           session.saveOrUpdate(pasien);
           tx.commit();
           session.close();
  }
}
