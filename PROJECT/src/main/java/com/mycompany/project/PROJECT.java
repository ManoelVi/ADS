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
    
    public static void Status(int[] status,String local, String escolha, boolean poder){
        System.out.println("Vida:" + status[1] +"\n" +
            "Resistencia:" + status[2] + "\n" +
            "Local: " + local);
        
        System.out.println("Escolhas:");
        
        if (escolha.equals("Movimentação")){
            System.out.println("Norte\n" +
                "Leste\n" +
                "Oeste\n" +
                "Sul");
        }else if(escolha.equals("Combate")){
            System.out.println("Atacar\n" +
                "Fugir\n" +
                "Esquivar");
        }
        
        System.out.println("");
        if(poder){
            System.out.println("Seu poder pode ser usado!");
        }
    }
    
    public static boolean Sorte(){
        
        return true;
    }
    public static void PrimeiraFase(int[] status){
        Scanner scan = new Scanner(System.in);

        System.out.println("Deseja jogar o tutorial?");
        String lcTutorial = scan.next();
        
        if ("SIM".equals(lcTutorial.toUpperCase())){
            System.out.println("Bem vindo a área de treino da Atlas!\n"
                    + " aqui você vai aprender os comandos básicos e funcionalidades da sua equipe!");
            
            System.out.println("");
            System.out.println("Vamos começar!");
            System.out.println("");
            
            String lcRosa = "";
            do{
                System.out.println("Estamos na entrada, digite NORTE para entrar no campo.");
                lcRosa = scan.next().toUpperCase();

            }while(lcRosa.equals("NORTE"));
            
            System.out.println("Entramos no stand de tiros.\n" +
                "");
            
            String lcPegar = "";
            boolean llRifle = false;
            do{
                System.out.println("digite PEGAR RIFLE para pegar sua arma inicial.");
                lcPegar = scan.next().toUpperCase();
                
                if(lcPegar.equals("PEGAR RIFLE")){
                    llRifle = true;
                }else{
                    if(lcPegar.contains("PEGAR")){
                        System.out.println("Não tem esse item nesta área");
                    }
                }

            }while(!lcRosa.equals("PEGAR RIFLE"));
            
            System.out.println("Temos alguns alvos a frente, você pode MIRAR para ter melhor precisão, ou ATIRAR aleatóriamente.\n" +
                "A escolha é sua agora!");
            
            String lcEscolha = "";
            do{
                lcEscolha = scan.next().toUpperCase();
                
                if(lcEscolha.equals("MIRAR")){
                    System.out.println("Tiros perfeitos, parabéns!");
                }else{
                    boolean llTiro = Sorte();
                    
                    if(llTiro){
                        System.out.println("Tiros perfeitos, parabéns!");
                    }else{
                        System.out.println("Você errou, mais sorte na próxima vez!");
                    }
                    
                }
                
                System.out.println("Deseja passar para a próxima etapa agora? você pode ficar aqui mais um tempo se quiser.");
                lcEscolha = scan.next();
                
                if(!lcEscolha.equals("SIM")){
                   /*
                        Dar nvl2 Pra mira
                    */
                    System.out.println("Pode MIRAR ou ATIRAR novamente.");
                }
            }while(lcEscolha.equals("SIM"));

            do{
                System.out.println("Vamos ver se já sabe usar um pouco das coisas que adicionaram no seu corpo.\n"
                    + "digite LESTE para ir para a área livre");
                lcRosa = scan.next().toUpperCase();

            }while(lcRosa.equals("LESTE"));
            
            System.out.println("Na área livre você pode testar granadas, estilos de combate e seus poderes.");
            
            System.out.println("Vamos começar pelas granadas, elas são ajustadas para seguir aqueles bichos, então fique tranquilo quanto a mira;");
            System.out.println("Os bonecos nessa área estão sujos com aquela gosma dos visitantes.");
            
            do{
                System.out.println("Digite LANÇAR GRANADA e veja o que acontece");
                lcEscolha = scan.next().toUpperCase();
            }while(!lcEscolha.equals("LANÇAR GRANADA"));
            
            System.out.println("Belo lançamento!");
            System.out.println("Mas tome cuidado, você tem uma carga máxima para essas granadas, e elas chamam bastante atenção, fique espeto!");
            
            System.out.println("você tem jeitos de lutar também, não precisa matar todos seus inimigos, mas sim comprir seus objetivos soldado.\n" +
                "Vamos tentar o modo stealth para passar pelos bonecos.");
                        
            do{
                System.out.println("Digite ESCONDER para ir para a proteção mais próxima.");
                lcEscolha = scan.next().toUpperCase();

            }while(!lcEscolha.equals("ESCONDER"));
            
            System.out.println("Perfeito, agora, precisamos avançar.\n"
                + " a oeste você está vendo uma parede certo?\n"
                + " e a leste temos um caixote mais próximo,\n"
                + " faça sua escolha!");
            
            lcRosa = "";
            while(!lcRosa.equals("OESTE") && !lcRosa.equals("LESTE")){
                lcRosa = scan.next().toUpperCase();
            }
            
            if (lcRosa == "Leste"){
                System.out.println("Cuidado!\n"
                        + " o boneco de testes te viu, ele tem poder de fogo.\n"
                        + " Use seu PODER, para escapar, RÁPIDO!!!");
                
                do{
                    System.out.println("Digite PODER e veja o que acontece");
                    lcEscolha = scan.next().toUpperCase();
                }while(!lcEscolha.equals("PODER"));
                
                switch(status[3]){
                    case 1:
                        System.out.println("- Você sai voando de perto do boneco de teste.");
                    case 2:
                        System.out.println("- Você dá um soco para frente, fazendo um efeito com o ar que acaba derrubando o boneco e o quebrando!");
                    case 3:
                        System.out.println("- Você usa seu poder para levantar o boneco e jogar na parede.");
                }       
            }
            
            System.out.println("Boa jogada, um caixote não me parece um lugar ideal para de esconder!");
                
            System.out.println("A partir daqui pode passar para NORTE, não tem mais problemas!");
            do{
                System.out.println("Pode passar para NORTE");
                lcRosa = scan.next().toUpperCase();

            }while(!lcRosa.equals("NORTE"));
        }
        
        System.out.println("Bem, finalizamos o treinamento.\n"
                + "Boa sorte na sua próxima missão soldado!");
    }

}
