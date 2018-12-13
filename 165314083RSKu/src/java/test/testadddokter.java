/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.DokterHelper;

/**
 *
 * @author asus
 */
public class testadddokter {
        public static void main(String[] args){
      String nama="dr.Husor";
      String spesialis="kulit dan kelamin";
         DokterHelper helper=new DokterHelper();
        helper.addNewDokter(nama, spesialis);
       
    }
}
