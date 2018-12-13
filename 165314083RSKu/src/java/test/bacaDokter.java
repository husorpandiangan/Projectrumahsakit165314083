/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import helper.DokterHelper;
import java.util.List;
import pojos.Dokter;

/**
 *
 * @author asus
 */
public class bacaDokter {

    public static void main(String[] args) {
        DokterHelper test = new DokterHelper();
        List<Dokter> list = test.bacaSemuaDokter();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
}
