/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.UserHelper;

/**
 *
 * @author basisa02
 */
public class testUser2 {
    public static void main(String[] args) {
        UserHelper helper = new UserHelper();
        System.out.println("Login = "+helper.login("puspa@usd.ac.id", "123456789"));
    }
}
