/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.project;

import java.util.Scanner;

/**
 *
 * @author Rael
 */
public class PROJECT {
    
    
    public static void main(String[] args) {
        System.out.println("*INICIO*");
        String lcResp;
        Scanner scan = new Scanner(System.in);

            Iniciar();
            System.out.print(">");
            lcResp = scan.nextLine();

            if(lcResp.contains("/c ")){
                lcResp = lcResp.substring(3);
                System.out.println(lcResp);
                Config(lcResp); 
            }
    }
    
    public static void Iniciar(){
        
    }
    
    public static void Config(String opcao){
        switch(opcao){
            case "Reiniciar":
                Iniciar();
            case "Creditos":
                System.out.println("Jogo produzido por:\n" +
                    "Rael Souza da Paixão\n" +
                    "Vitor Manoel Batista de Araujo\n" +
                    "Vinícius Matias\n" +
                    "Vinícius Santana\n" +
                    "Rafael\n" +
                    "Lucas");
            case "Sair":
                System.exit(0);        
        }
    }
}
