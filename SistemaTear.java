/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistematear;

/**
 *
 * @author fance
 */

import javax.swing.SwingUtilities;

public class SistemaTear {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginScreen.createAndShowLoginScreen();
            }
        });
    }
}

