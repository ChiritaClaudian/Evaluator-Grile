/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import gui.login.LoginGUI;



/**
 *
 * @author chiri
 */
public class Main {
    
    private static LoginGUI loginGui;
    public static void main(String[] args) {
        loginGui = new LoginGUI();
        loginGui.launch(args);
    }
    
  
    
}
