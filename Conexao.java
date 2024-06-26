/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematear;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fance
 */
public class Conexao 
{
    public static void main(String[] args)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado...");
        }
        
    }
    
}/////
