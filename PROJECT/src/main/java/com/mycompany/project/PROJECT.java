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
    public static int[] Status;
    public static String Nome;
    public static int[] Nivel;
  
    public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
      Status[0] = 50;//vida
	    Status[1] = 10;//balas
	    Status[2] = 2;//mana
	    Status[3] = 0;//chave
      Status[4] = 60;//municão
      Status[5] = 3;//PoteMana
      Status[6] = 3;//PoteVida
      Status[7] = 3;//Granadas
      Status[8] = 0;//Proteção
      Status[9] = 0;//poder

      Nivel[0] = 1;//Nivel
      Nivel[1] = 0;//XP

      Nome[0] = "";

      inicio(1);
      PrimeiraFase(1);
      Missao2(1);
      System.out.println("GENERAL- Finalmente nos conseguimos chegar no planeta com a nave reserva e com todos em segurança, devemos agir rapido, entrar e sair do planeta o mais rapido possivel e em segurança. Iremos dividir nossos super soldados e cada um terá um objetivo, serão três no total. Cada um terá um objetivo, e todos devem cumprir sua respectivas missões, so assim teremos sucesso em nosso objetivo. ");
      System.out.println("GENERAL- "+ Nome[0]+ "poderá escolher primeiro qual a missão deseja cumprir, as missoes são:\n1-Entrar furtivamente na instalação em que o cientista esta, resgata-lo e traze-lo em segurança para partimos de volta para a terra.\n2- Criar uma distração para que as outras duas partes possam cumprir sua missão\n3- Enfrentar o lider do planeta, para acabar com a guerra de uma vez por todas.\nQual missão você deseja cumprir?");
      String resp = Repeticao("1-RESGATE\n2-DISTRAÇÃO\n3-CHEFE", "RESGATE DISTRAÇÃO CHEFE");
      if(resp.equals("RESGATE")){
        fase3(1);
      }else if(resp.equals("DISTRAÇÃO")){
        fase3guardacostas(1);
      }else if(resp.equals("CHEFE")){
        Fase3Chefe();
      }
    }
      public static void dano1(int a) {
  		status[0] = status[0] - 5;
  	}
  	public static void dano2(int a) {
  		status[0] = status[0] - 10;		
  	}
  	public static void atirar(int a) {
      if (status[1] > 0){
        status[1] = status[1] - 1;
      }	
  	}
  	public static void recarregar(int a) {
      if (status[4] > 0){
        if (status[4] >= 10){
          status[1] = 10;
          status[4] = status[4] - 10;
        }else{
          status[1] = status[4];
          status[4] = status[4];
        }
      }else{
        System.out.println("Não Recarregou");
      }	
  	}
  public static void Granada(int a) {
    if (status[7] > 0){
      status[7] = status[7] - 1; 
    }else{
      System.out.println("Não tem mais granadas!");
    }
    
  }
  
  public static void PoteMana(int a) {
    if (status[5] > 0 && status[2] == 0){
      status[2]= 2;
      status[5] = status[5] - 1;
    }else{
      System.out.println("Você pode não ter mais potes de mana, ou ainda lhe sobram cargas de poder");
    }
  }

  public static void PoteVida(int a) {
    if (status[6] > 0){
      status[0] = status[0] + 15 ;
      status[6] = status[6] - 1;
    }else{
      System.out.println("Você pode não ter mais potes de mana, ou ainda lhe sobram cargas de poder");
    }
  }
  
  public static void chave(int a) {
    status[3]= 1;
  }
  
  public static void MenosChave(int a) {
    status[3]= 0;
  }
  
  public static void Config(String opcao){
      switch(opcao){
          case "Reiniciar":
          
          case "Creditos":
            System.out.println("Jogo produzido por:\n" +
                "Rael Souza da Paixão\n" +
                "Vitor Manoel Batista de Araujo\n" +
                "Vinícius Matias\n" +
                "Vinícius Santana\n" +
                "Rafael");
          case "Sair":
            System.exit(0);
          default:
            System.out.println("Opções > Creditos , Reiniciar , Sair");
      }    
  }
  
  public static void MostrarStatus(String local, boolean poder){
    System.out.println("Vida: " + status[0] +"\n" +
                      "Poder: " + status[2] +"\n" +
                      "Balas na arma: " + status[1] + "\n" +
                      "Munição: "+ Status[4] +
                      "Local: " + local +
                      "Potes de mana: " + status[5] +"\n" +
                      "Potes de vida: " + status[6]);
    
    System.out.println("Escolhas:");
  
    if(poder && Status[2] > 0){
        System.out.println("Seu poder pode ser usado!");
    }
  }

  public static void PrimeiraFase(int[] status){
    Status[8] = 1;
    String lcTutorial = Repeticao("Deseja jogar o tutorial?","SIM,NÃO");
    
    if ("SIM".equals(lcTutorial.toUpperCase())){
      System.out.println("Bem vindo a área de treino da Atlas!\n"
                        + " aqui você vai aprender os comandos básicos e funcionalidades da sua equipe!");
      System.out.println("");
      System.out.println("Vamos começar!");
      System.out.println("");
      
      String lcRosa = Repeticao("Estamos na entrada, digite NORTE para entrar no campo.","NORTE");
      
      System.out.println("Entramos no stand de tiros.");
      
      String lcPegar = Repeticao("digite PEGAR RIFLE para pegar sua arma inicial.","PEGAR RIFLE");
      
      String lcEscolha = Repeticao("Temos alguns alvos a frente, você pode MIRAR para ter melhor precisão, ou ATIRAR aleatóriamente.\n"                               +"A escolha é sua agora!","MIRAR,ATIRAR");
      
      do{
        if(lcEscolha.equals("MIRAR")){
          System.out.println("Tiros perfeitos, parabéns!");
        }else{
          boolean llTiro = Sorteio();
          
          if(llTiro){
            System.out.println("Tiros perfeitos, parabéns!");
          }else{
            System.out.println("Você errou, mais sorte na próxima vez!");
          }
        }
        System.out.println("Deseja passar para a próxima etapa agora? você pode ficar aqui mais um tempo se quiser.");
        lcEscolha = scan.next();
        
        if(!lcEscolha.equals("SIM")){
          System.out.println("Pode MIRAR ou ATIRAR novamente.");
        }
      }while(lcEscolha.equals("SIM"));
      
      lcRosa = Repeticao("Vamos ver se já sabe usar um pouco das coisas que adicionaram no seu corpo.\n"
            + "digite LESTE para ir para a área livre","LESTE");
      
      System.out.println("Na área livre você pode testar granadas, estilos de combate e seus poderes.");
      
      System.out.println("Vamos começar pelas granadas, elas são ajustadas para seguir aqueles bichos, então fique tranquilo quanto a mira;");
      System.out.println("(Os bonecos nessa área estão sujos com aquela gosma dos visitantes.)");
      
      lcEscolha = Repeticao("Digite LANÇAR GRANADA e veja o que acontece","LANÇAR GRANADA");
      
      System.out.println("Belo lançamento!");
      System.out.println("Mas tome cuidado, você tem uma carga máxima para essas granadas, e elas chamam bastante atenção, fique espeto!");
      
      System.out.println("você tem jeitos de lutar também, não precisa matar todos seus inimigos, mas sim comprir seus objetivos soldado.\n"                           +"Vamos tentar o modo stealth para passar pelos bonecos.");
                  
      lcEscolha = Repeticao("Digite ESCONDER para ir para a proteção mais próxima.","ESCONDER");
      
      lcRosa = Repeticao("Perfeito, agora, precisamos avançar.\n"
                        + " a OESTE você está vendo uma parede certo?\n"
                        + " e a LESTE temos um caixote mais próximo,\n"
                        + " faça sua escolha!","OESTE,LESTE");
      
      if (lcRosa == "LESTE"){
        lcEscolha = Repeticao("Cuidado!\n"
                + " o boneco de testes te viu, ele tem poder de fogo.\n"
                + " Use seu PODER, para escapar, RÁPIDO!!","Poder");
        
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
        
      lcRosa = Repeticao("Pode passar para NORTE","NORTE");
  }   
  System.out.println("Bem, finalizamos o treinamento.\n"
          + "Boa sorte na sua próxima missão soldado!");
  }

  public static String Repeticao(String Texto, String Resp){
    String lcRosa = "";
    
    do{
      System.out.println(Texto);
      lcRosa = scan.next().toUpperCase();

      if(lcRosa.contains("CONFIG")){
        Config(lcRosa.substring(6));
      }

      MostrarStatus(local,false);
    }while(!Resp.contains(lcRosa);

    return lcRosa;
  }

  public static boolean Sorteio(){
    int randon = (int)(Math.random() * 2);

    if(randon == 0){
      return true;
    }else{
      return false;
    }
  }
  }
	public static void Fundo() {
		int t = 1;
		int balas = 10;
		int vida = 50;
		int fim = 0;
		String resp = "";
		System.out.println("voce decidiu entrar pelos fundos.");
		t = 1;
		if (t == 1) {
			System.out.println("Você se depara com dois guardas guardando o portao. \n"
					+ "existe uma caixa a direita e uma a esquerda, o guarda da esqueda olha na direção do segundo guarda \n"
					+ "o outro guarda olha para a frente, existe uma  chance de chegar pelas costas de um dos dois\n"
					+ ". Por qual caixa você deseja seguir?");
			while(fim == 0) {
				resp =Repeticao("1-ESQUERDA\n2-DIREITA","ESQUERDA,DIREITA");
				if(resp.equals("ESQUERDA")) {
					resp = "ESQUERDA";
					fim = 1;	
				}else if(resp.equals("DIREITA")) {
					resp = "DIREITA";
					fim = 1;
					}
			}fim = 0;
			if (resp.equals("ESQUERDA")) {
				System.out.println("Você se aproxima do alvo da esquerda, deseja abate-lo:");
				while(fim == 0) {
					System.out.println("1-FURTIVAMENTE\n2-ATIRAR");
					resp = scan.nextLine().toUpperCase();
					if(resp.equals("FURTIVAMENTE")) {
						t = 1;
						fim = 1;	
					}else if(resp.equals("ATIRAR")) {
						t = 2;
						fim = 1;
						}
				}fim = 0;
				if (t == 1) {
					System.out.println("você conseguiu abate-lo furtivamente, você deseja chegar perto do segundo:\n"
							+ "Aproximar-se furtivamente(1)\nAtirar nele de longe(2)");
					if(t == 1) {
						System.out.println("Voce consegue se aproximar do segundo guarda sem ser visto, deseja abate-lo");
						while(fim == 0) {
							System.out.println("1-FURTIVAMENTE\n2-ATIRAR");
							resp = scan.nextLine().toUpperCase();
							if(resp.equals("FURTIVAMENTE")) {
								t = 1;
								fim = 1;	
							}else if(resp.equals("ATIRAR")) {
								t = 2;
								fim = 1;
								}
						}fim = 0;
								if (t == 1) {
									System.out.println("Voce consegue abater o alvo furitvamente");
								}else
									System.out.println("Voce consegue abater o alvo, mas perde uma bala");
									atirar(1);			
					}else
						System.out.println("Voce consegue eliminar o segundo guarda com sua arma, mas perde uma bala");
						atirar(1);
				}
						
						
				//caminho 2, usando a arma
					
			}else {
				System.out.println("Você consegue abater o primeiro guarda, porem o segundo te nota devido ao barulho de sua arma,\n"
						+ "antes que voce consiga fazer algo, ele consegue te acertar um tiro, voce deseja: \natirar nele de volta(1)\n"
						+ "correr na sua direção(2)?");
				atirar(1);
				dano1(1);
				while(fim == 0) {
					System.out.println("1-ATIRAR\n2-CORRER");
					resp = scan.nextLine().toUpperCase();
					if(resp.equals("ATIRAR")) {
						t = 1;
						fim = 1;	
					}else if(resp.equals("CORRER")) {
						t = 2;
						fim = 1;
						}
				}fim = 0;
				if (t == 1) {
					System.out.println("voce consegue eliminar o segundo guarda, mas perde uma bala");
					atirar(1);
				}else
					System.out.println("enquanto voce corre na direção dele, voce toma outro tiro e perde vida\n "
							+ "ao chegar perto, voce deseja: \nabate-lo com as maos(1)\n Abate-lo com um tiro(2)?");
					dano1(2);
					while(fim == 0) {
						System.out.println("1-ABATER\n2-ATIRAR");
						resp = scan.nextLine().toUpperCase();
						if(resp.equals("ABATER")) {
							t = 1;
							fim = 1;	
						}else if(resp.equals("ATIRAR")) {
							t = 2;
							fim = 1;
							}
					}fim = 0;
					if (t == 1) {
						System.out.println("voce conseguiu abater o primeiro inimigo");
					}else {
						System.out.println("Voce conseguiu abater o inimigo, porem gastou uma bala");
						atirar(1);
					}
				
			}
		}else {
			System.out.println("Voce consegue chegar no guarda sem ser visto\nabate-lo furtivamente (1)\n abalte-lo usando sua arma (2)?");
			while(fim == 0) {
				System.out.println("1-FURTIVAMENTE\n2-ATIRAR");
				resp = scan.nextLine().toUpperCase();
				if(resp.equals("FURTIVAMENTE")) {
					t = 1;
					fim = 1;	
				}else if(resp.equals("ATIRAR")) {
					t = 2;
					fim = 1;
					}
			}fim = 0;
			if (t == 1) {
				System.out.println("Voce consegue abater o guarda, porem o segundo guarda te ve pois estava olhando em sua direção. \n"
						+ "Antes que voce possa fazer algo, ele te acerta um tiro. Voce deseja: \natirar nele (1)\ncorrer em sua direção (2)?");
				dano1();
				t = scan.nextInt();
				if (t == 1) {
					System.out.println("Voce consegue abater o segundo, porem perde uma bala");
					atirar();
				}else {
					System.out.println("Voce corre na direção do inimigo, porem ele te acerta um tiro no caminho. Ao chegar la"
							+ ", voce deseja: \natirar (1)\nabate-lo com as mãos(2)?");
					dano2();
					while(fim == 0) {
						System.out.println("1-ATIRAR\n2-ABATER");
						resp = scan.nextLine().toUpperCase();
						if(resp.equals("ATIRAR")) {
							t = 1;
							fim = 1;	
						}else if(resp.equals("ABATER")) {
							t = 2;
							fim = 1;
							}
					}fim = 0;
					if (t == 1) {
						System.out.println("Voce consegue abater o segundo guarda, porem gasta munição");
						atirar();
					}else
						System.out.println("Voce consegue abater o guarda com um soco");
				}
				// caminho usando a arma
			}else {
				System.out.println("Voce consegue abater o guarda, porem o segundo guarda consegue ver.\n"
						+ "Antes que voce possa fazer algo, ele te acerta um tiro. Voce deseja: \natirar nele (1) \ncorrer em sua direção (2)?");
				dano1();
				t = scan.nextInt();
				if (t == 1) {
					System.out.println("voce consegue eliminar o segundo guarda, mas perde uma bala");
					atirar();
				}else{
					System.out.println("enquanto voce corre na direção dele, voce toma outro tiro e perde vida\n "
							+ "ao chegar perto, voce deseja: \nabate-lo com as maos(1)\n abate-lo com um tiro(2)?");
					dano1();
					while(fim == 0) {
						System.out.println("1-ABATER\n2-ATIRAR");
						resp = scan.nextLine().toUpperCase();
						if(resp.equals("ABATER")) {
							t = 1;
							fim = 1;	
						}else if(resp.equals("ATIRAR")) {
							t = 2;
							fim = 1;
							}
					}fim = 0;
					if (t == 1) {
						System.out.println("voce conseguiu abater o primeiro inimigo");
					}else{
            System.out.println("Voce conseguiu abater o inimigo, porem gastou uma bala");
						atirar();
          }	
					}	
        }
				}//primeiro if/else
			}
		
	public static String FASE3(int a) {
		String resp = "";
    Status[8] = 3;
		int fim = 0;
		System.out.println("General- Conseguimos informaçoes que o cientista esta preso em uma instalação\n"
				+", sua missão sera resgatar e traze-lo com vida, ele é essencial para o sucesso an guerra\n"
				+ "e sem ele nosso planeta corre serios riscos, você irá entrar furtivamente\n"
				+ ", devera entrar e sair sem alertar, seu companheiro dara um jeito de chamar atençao dos guardas\n"
				+ "para eles sairem e facilitar sua entrada e saida. Localizamos duas possiveis entradas, \n"
				+ "uma pelos fundos, e outra pelos esgotos abaixo da instalação, para qual voce deseja ir?");
		while(fim == 0) {
			System.out.println("1-FUNDO\n2-ESGOTO");
			resp = scan.nextLine().toUpperCase();
			if(resp.equals("FUNDO")) {
				resp = "FUNDO";
        Fundo();
				fim = 1;	
			}else if(resp.equals("ESGOTO")) {
				resp = "ESGOTO";
				fim = 1;
				}
		}fim = 0;
		return resp;
		
	}
		

	public static void esgoto (int a) {
		int t = 1;
		int balas = 10;
		int vida = 50;
		int fim = 0;
		String resp = "";
		System.out.println("voce decidiu entrar pelos esgotos.");
		t = 1;
		if (t == 1) {
			System.out.println("Mesmo no ambiente sujo ao qual imaginava-se nao haver inimigos, você se depara com dois guardas guardando as estradas subterraneas. \n"
					+ "existe uma caixa a direita e uma a esquerda, o guarda da esqueda olha na direção do segundo guarda \n"
					+ "o outro guarda olha para a frente, existe uma  chance de chegar pelas costas de um dos dois\n"
					+ ". Por qual caixa você deseja seguir?");
			while(fim == 0) {
				System.out.println("1-ESQUERDA\n2-DIREITA");
				resp = scan.nextLine().toUpperCase();
				if(resp.equals("ESQUERDA")) {
					resp = "ESQUERDA";
					fim = 1;	
				}else if(resp.equals("DIREITA")) {
					resp = "DIREITA";
					fim = 1;
					}
			}fim = 0;
			if (resp.equals("ESQUERDA")) {
				System.out.println("Você se aproxima do alvo da esquerda, deseja abate-lo:");
				while(fim == 0) {
					System.out.println("1-FURTIVAMENTE\n2-ATIRAR");
					resp = scan.nextLine().toUpperCase();
					if(resp.equals("FURTIVAMENTE")) {
						t = 1;
						fim = 1;	
					}else if(resp.equals("ATIRAR")) {
						t = 2;
						fim = 1;
						}
				}fim = 0;
				if (t == 1) {
					System.out.println("você conseguiu abate-lo furtivamente, você deseja chegar perto do segundo:\n"
							+ "Aproximar-se furtivamente(1)\nAtirar nele de longe(2)");
					if(t == 1) {
						System.out.println("Voce consegue se aproximar do segundo guarda sem ser visto, deseja abate-lo");
						while(fim == 0) {
							System.out.println("1-FURTIVAMENTE\n2-ATIRAR");
							resp = scan.nextLine().toUpperCase();
							if(resp.equals("FURTIVAMENTE")) {
								t = 1;
								fim = 1;	
							}else if(resp.equals("ATIRAR")) {
								t = 2;
								fim = 1;
								}
						}fim = 0;
								if (t == 1) {
									System.out.println("Voce consegue abater o alvo furitvamente");
								}else
									System.out.println("Voce consegue abater o alvo, mas perde uma bala");
									atirar(1);			
					}else
						System.out.println("Voce consegue eliminar o segundo guarda com sua arma, mas perde uma bala");
						atirar(1);
				}
						
						
				//caminho 2, usando a arma
					
			}else {
				System.out.println("Você consegue abater o primeiro guarda, porem o segundo te nota devido ao barulho de sua arma,\n"
						+ "antes que voce consiga fazer algo, ele consegue te acertar um tiro, voce deseja: \natirar nele de volta(1)\n"
						+ "correr na sua direção(2)?");
				atirar(1);
				dano1(1);
				while(fim == 0) {
					System.out.println("1-ATIRAR\n2-CORRER");
					resp = scan.nextLine().toUpperCase();
					if(resp.equals("ATIRAR")) {
						t = 1;
						fim = 1;	
					}else if(resp.equals("CORRER")) {
						t = 2;
						fim = 1;
						}
				}fim = 0;
				if (t == 1) {
					System.out.println("voce consegue eliminar o segundo guarda, mas perde uma bala");
					atirar(1);
				}else
					System.out.println("enquanto voce corre na direção dele, voce toma outro tiro e perde vida\n "
							+ "ao chegar perto, voce deseja: \nabate-lo com as maos(1)\n Abate-lo com um tiro(2)?");
					dano1(2);
					while(fim == 0) {
						System.out.println("1-ABATER\n2-ATIRAR");
						resp = scan.nextLine().toUpperCase();
						if(resp.equals("ABATER")) {
							t = 1;
							fim = 1;	
						}else if(resp.equals("ATIRAR")) {
							t = 2;
							fim = 1;
							}
					}fim = 0;
					if (t == 1) {
						System.out.println("voce conseguiu abater o primeiro inimigo");
					}else {
						System.out.println("Voce conseguiu abater o inimigo, porem gastou uma bala");
						atirar(1);
					}
				
			}
		}else {
			System.out.println("Voce consegue chegar no guarda sem ser visto\nabate-lo furtivamente (1)\n abalte-lo usando sua arma (2)?");
			while(fim == 0) {
				System.out.println("1-FURTIVAMENTE\n2-ATIRAR");
				resp = scan.nextLine().toUpperCase();
				if(resp.equals("FURTIVAMENTE")) {
					t = 1;
					fim = 1;	
				}else if(resp.equals("ATIRAR")) {
					t = 2;
					fim = 1;
					}
			}fim = 0;
			if (t == 1) {
				System.out.println("Voce consegue abater o guarda, porem o segundo guarda te ve pois estava olhando em sua direção. \n"
						+ "Antes que voce possa fazer algo, ele te acerta um tiro. Voce deseja: \natirar nele (1)\ncorrer em sua direção (2)?");
				dano1(1);
				t = scan.nextInt();
				if (t == 1) {
					System.out.println("Voce consegue abater o segundo, porem perde uma bala");
					atirar(1);
				}else {
					System.out.println("Voce corre na direção do inimigo, porem ele te acerta um tiro no caminho. Ao chegar la"
							+ ", voce deseja: \natirar (1)\nabate-lo com as mãos(2)?");
					dano2(1);
					while(fim == 0) {
						System.out.println("1-ATIRAR\n2-ABATER");
						resp = scan.nextLine().toUpperCase();
						if(resp.equals("ATIRAR")) {
							t = 1;
							fim = 1;	
						}else if(resp.equals("ABATER")) {
							t = 2;
							fim = 1;
							}
					}fim = 0;
					if (t == 1) {
						System.out.println("Voce consegue abater o segundo guarda, porem gasta munição");
						atirar(1);
					}else
						System.out.println("Voce consegue abater o guarda com um soco");
				}
				// caminho usando a arma
			}else {
				System.out.println("Voce consegue abater o guarda, porem o segundo guarda consegue ver.\n"
						+ "Antes que voce possa fazer algo, ele te acerta um tiro. Voce deseja: \natirar nele (1) \ncorrer em sua direção (2)?");
				dano1(1);
				t = scan.nextInt();
				if (t == 1) {
					System.out.println("voce consegue eliminar o segundo guarda, mas perde uma bala");
					atirar(1);
				}else
					System.out.println("enquanto voce corre na direção dele, voce toma outro tiro e perde vida\n "
							+ "ao chegar perto, voce deseja: \nabate-lo com as maos(1)\n abate-lo com um tiro(2)?");
					dano1(1);
					while(fim == 0) {
						System.out.println("1-ABATER\n2-ATIRAR");
						resp = scan.nextLine().toUpperCase();
						if(resp.equals("ABATER")) {
							t = 1;
							fim = 1;	
						}else if(resp.equals("ATIRAR")) {
							t = 2;
							fim = 1;
							}
					}fim = 0;
					if (t == 1) {
						System.out.println("voce conseguiu abater o primeiro inimigo");
					}else
						System.out.println("Voce conseguiu abater o inimigo, porem gastou uma bala");
						atirar(1);
							
					}	
				}//primeiro if/else
      entrou(1);
			}
	
	public static void entrou(int a) {
		int balas = 10;
		int vida = 50;
		int chave1 = 0;
		int secreta = 0;
		int avançou = 0;
		int refil1 = 0;
		int t = 0;
		String resp = "";
		int fim = 0;
		while(avançou != 1) {
			System.out.println("Você esta em uma sala com tres portas. para qual você deseja ir?\nPorta leste(1)\nPorta Oeste(2)\nPorta Norte(3)");
			while(fim == 0) {
				System.out.println("1-LESTE\n2-OESTE\n3-NORTE");
				resp = scan.nextLine().toUpperCase();
				if(resp.equals("LESTE")) {
					t = 1;
					fim = 1;	
				}else if(resp.equals("OESTE")) {
					t = 2;
					fim = 1;
				}else if(resp.equals("NORTE")) {
					t = 3;
					fim = 1;
				}
			}fim = 0;
			switch (t) {
			case 1:
				if (chave1 == 0) {	
					System.out.println("Você entrou na porta Leste, Dentro da sala você acha uma chave, deseja pega-la?\nSim(1)\nNão(2)");
					while(fim == 0) {
						System.out.println("1-SIM\n2-NAO");
						resp = scan.nextLine().toUpperCase();
						if(resp.equals("SIM")) {
							t = 1;
							fim = 1;	
						}else if(resp.equals("NAO")) {
							t = 2;
							fim = 1;
							}
					}fim = 0;
					if (t == 1) {
						System.out.println("Você pegou a chave");
						chave1 = 1;
					}else
						System.out.println("você nao pegou a chave");
				}else {
					System.out.println("Você entrou na porta Leste, mas não encontra nada dentro da sala");
				}
				System.out.println("Após verificar a sala, você volta para a sala inicial");
				break;
			case 2:
				if (refil1 == 0) {
				System.out.println("Você entrou na sala Oeste, dentro da sala você encontra um refil para recarregar\n"
						+ "as balas da sua arma, deseja pegar?\nSim(1)\nNão(2)");
				while(fim == 0) {
					System.out.println("1-SIM\n2-NAO");
					resp = scan.nextLine().toUpperCase();
					if(resp.equals("SIM")) {
						t = 1;
						fim = 1;	
					}else if(resp.equals("NAO")) {
						t = 2;
						fim = 1;
						}
				}fim = 0;
				if (t == 1) {
					System.out.println("Você pegou o refil e recarregou sua arma");
					balas = 10;
					refil1 = 1;
				}else
					System.out.println("você nao pegou o refil");
				}else
					System.out.println("Você entrou na porta Oeste, mas não encontra nada dentro da sala");
				break;
			case 3:
				if (chave1 == 0) {
					System.out.println("A porta está trancada, você precisa de uma chave, Você volta para a sala principal");
				}else {
					System.out.println("Você pode passar pela porta, porêm nao tera mais volta, \n"
							+ "voce deseja continuar mesmo assim?\nSim(1)\nNâo(2).");
					t = scan.nextInt();
					if (t == 1) {
						avançou = 1;
						System.out.println("Você passou pela porta!");
						break;
					}	
				}break;
			}
		}//while 1
		salas(1);
	}
	
	public static void salas(int a) {
		int caminho = 1;
		int fim = 0;
		while (fim != 1) {
			if(caminho == 1) {
				caminho = caminho1(caminho);
			}else if(caminho == 2) {
				caminho = caminho2(caminho);
			}else if(caminho == 3) {
				caminho = caminho3(caminho);
			}else if(caminho == 4) {
				caminho = caminho4(caminho);
			}else if(caminho == 5) {
				caminho = caminho5(caminho);
			}else if(caminho == 6) {
				caminho = caminho6(caminho);
			}
		}
	}
	
	public static int caminho1(int a) {
		int t = 0;
		int fim = 0;
		String resp = "";
		System.out.println("Você se encontra em um corredor, com uma porta ao norte e a continuação do corredor a leste, para onde deseja ir?"
				+ "\nPorta ao norte(1)\nContinuar no corredor(2)");
		while(fim == 0) {
			System.out.println("1-NORTE\n2-CONTINUAR");
			resp = scan.nextLine().toUpperCase();
			if(resp.equals("NORTE")) {
				t = 1;
				fim = 1;	
			}else if(resp.equals("CONTINUAR")) {
				t = 2;
				fim = 1;
				}
		}fim = 0;
		int caminho = 0;
		if (t == 1) {
			caminho = 2;
			return caminho;
		}else
			caminho = 3;
			return caminho;
		
	}
	public static int caminho2(int a) {
		int fim = 0;
		int t = 1;
		int caminho = 0;
		String resp = "";
			if (status[3] == 0){
				System.out.println("Na sala você avista um painel, porem precisa de uma chave para liberar, você volta ao corredor\n");
				caminho = 1;
				return caminho;
			}else
				System.out.println("Apos desbloquear o painel com a chave, você pode verefica-lo:\nVerificar computador(1)\nVoltar para o corredor(2)");
			while(fim == 0) {
				System.out.println("1-VERIFICAR\n2-VOLTAR");
				resp = scan.nextLine().toUpperCase();
				if(resp.equals("VERIFICAR")) {
					t = 1;
					fim = 1;	
				}else if(resp.equals("VOLTAR")) {
					t = 2;
					fim = 1;
					}
			}fim = 0;
					if (t == 1) {
						System.out.println("O painel apresenta uma senha, voce pode:\nHackear computador(1)\nDesistir(2)");
						while(fim == 0) {
							System.out.println("1-HACK\n2-DESISTIR");
							resp = scan.nextLine().toUpperCase();
							if(resp.equals("HACK")) {
								t = 1;
								fim = 1;	
							}else if(resp.equals("DESISTIR")) {
								t = 2;
								fim = 1;
								}
						}fim = 0;
							if (t == 1) {
								System.out.println("Para hackear o painel você precisa resolver um puzzle.\n"
										+ "Responda: raiz quadrada de 9");
							t = scan.nextInt();
								while (t != 3) {
									if (t != 3)
										System.out.println("resposta incorreta, tente novamente");
										t = scan.nextInt();
								}
								System.out.println("Ao conseguir, você escuta uma porta abrindo na sala atras de você\n"
										+ "Você deseja entrar na porta ou retornar para o corredor?\nEntrar na porta(1)\nVoltar ao corredor(2)");
								while(fim == 0) {
									System.out.println("1-ENTRAR\n2-VOLTAR");
									resp = scan.nextLine().toUpperCase();
									if(resp.equals("ENTRAR")) {
										t = 1;
										fim = 1;	
									}else if(resp.equals("VOLTAR")) {
										t = 2;
										fim = 1;
										}
								}fim = 0;
									if (t == 1) {
										System.out.println("você entrou na porta!");
										caminho = 7;
										return caminho;
									}else
										caminho = 1;
										return caminho;
								
					}else
						System.out.println("Você voltou para o corredor");
						caminho = 1;
						return caminho;
			
		}else
			caminho = 1;
			return caminho;
		}
	
	public static int caminho3(int a) {
		int t = 0;
		int caminho = 0;
		int fim = 0;
		String resp = "";
		System.out.println("Ao chegar no final do corredor, voce encontra uma porta a leste\nEntrar na porta ao leste(1)\nVoltar a oeste para o começo do corredor(2) ");
		while(fim == 0) {
			System.out.println("1-ENTRAR\n2-VOLTAR");
			resp = scan.nextLine().toUpperCase();
			if(resp.equals("ENTRAR")) {
				t = 1;
				fim = 1;	
			}else if(resp.equals("VOLTAR")) {
				t = 2;
				fim = 1;
				}
		}fim = 0;
			if (t == 1) {
				System.out.println("Você passa pela porta");
				caminho = 4;
				return caminho;
			}else
				System.out.println("Você volta para o começo do corredor");
				caminho = 1;
				return caminho;
		}
	
	public static int caminho4(int a) {
		int t = 0;
		int caminho = 0;
		int t2 = 1;
		int vida = 40;
		int poção = 1;
		int fim = 0;
		String resp = "";
		while(t2 != 0) {
			System.out.println("norte(1)\nleste(2)\noeste(3)\nsul(4)");
			while(fim == 0) {
				System.out.println("1-NORTE\n2-LESTE\n3-OESTE\n4-SUL");
				resp = scan.nextLine().toUpperCase();
				if(resp.equals("NORTE")) {
					t = 1;
					fim = 1;	
				}else if(resp.equals("LESTE")) {
					t = 2;
					fim = 1;
				}else if(resp.equals("OESTE")) {
					t = 3;
					fim = 1;
				}else if(resp.equals("SUL")) {
					t = 4;
					fim = 1;
				}
			}fim = 0;
			if(t == 1) {
				System.out.println("a sala esta vazia, voce volta para a sala principal");
			}else if(t == 2) {
				System.out.println("Você encontra uma poção de cura, voce deseja tomar?\nSim(1)\nNão(2)");
				while(fim == 0) {
					System.out.println("1-SIM\n2-NÃO");
					resp = scan.nextLine().toUpperCase();
					if(resp.equals("SIM")) {
						t = 1;
						fim = 1;	
					}else if(resp.equals("NAO")) {
						t = 2;
						fim = 1;
						}
				}fim = 0;
				if (t == 1) {
					System.out.println("Sua vida foi regenerada, você volta para a sala anterior");
					vida = 50;
				}else
					System.out.println("Você volta para a sala anterior");
			}else if(t == 3) {
				System.out.println("Você passa para a proxima sala");
				caminho = 5;
				return caminho;
			}else if(t == 4){
				System.out.println("Voce volta para o corredor");
				caminho = 3;
				return caminho;
			}else
				System.out.println("Comando errado");
				
		}
		return caminho;
	}
	
	public static int caminho5(int a) {
		int t = 0;
		int caminho = 0;
		int t2 = 2;
		int c = 1;
		int fim = 0;
		String resp = "";
		while (t2 != 1) {
			System.out.println("Você se encontra em uma sala com três portas, norte, sul e leste,e uma a Oeste para voltar de onde veio.\nPara qual você deseja ir?\n"
					+ "Leste(1)\nSul(2)\nOeste(3)");
			while(fim == 0) {
				System.out.println("1-LESTE\n2-SUL\n3-OESTE");
				resp = scan.nextLine().toUpperCase();
				if(resp.equals("LESTE")) {
					t = 1;
					fim = 1;	
				}else if(resp.equals("SUL")) {
					t = 2;
					fim = 1;
				}else if(resp.equals("OESTE")) {
					t = 2;
					fim = 1;
				}
			}fim = 0;
			if (t == 1) {
				System.out.println("voce volta para a sala anterior");
				caminho = 4;
			}else if (t == 2) {
				if (c == 1) {
				System.out.println("Você encontra uma chave, voce deseja pegar?\nSim(1)\nNão(2)");
				while(fim == 0) {
					System.out.println("1-SIM\n2-NÃO");
					resp = scan.nextLine().toUpperCase();
					if(resp.equals("SIM")) {
						t = 1;
						fim = 1;	
					}else if(resp.equals("NAO")) {
						t = 2;
						fim = 1;
						}
				}fim = 0;
					if (t == 1) {
						System.out.println("Pegou a chave, você volta para a sala anterior");
						c = 1;
					}else
						System.out.println("Você volta para a sala anterior");
				}else
					System.out.println("Sala vazia, você volta para a sala anteior");
			}else if(t == 3){
				System.out.println("Você avança para a proxima sala!");
				caminho = 6;
				return caminho;
		}else {
			System.out.println("codigo errado");
			return caminho;
		}			
		}
		return caminho;
	}
	public static int caminho6(int a) {
		int t = 0;
		int fim = 0;
		String resp = "";
		System.out.println("avançar(1)\nRecuar(2)");
		while(fim == 0) {
			System.out.println("1-AVANÇAR\n2-RECUAR");
			resp = scan.nextLine().toUpperCase();
			if(resp.equals("AVANÇAR")) {
				t = 1;
				fim = 1;	
			}else if(resp.equals("RECUAR")) {
				t = 2;
				fim = 1;
				}
		}fim = 0;
		int caminho = 0;
		if (t == 1) {
			caminho = 8;
		}else {
			caminho = 5;}
		return caminho;
			
	}
	//fim caminho 6

  public static void Fase3Chefe(){
    String resp = Repeticao("Vamos atrás do maioral deste planeta imundo, Vamos para NORTE agora","NORTE");
    
    Fase3Caminho1();
  }

public static void Fase3Caminho1(){
    System.out.println("-Você está em um salão grande e vazio e aparentemente sem inimigos /n"+
                       "-Na sala parece que aconteceu uma intensa luta, com uma gosma estranha(Provável sangue dos mesmos) /n");
    String resp = Repeticao("- Tem Salas tanto para a OESTE quanto para LESTE","LESTE,OESTE");

    if(resp.equals("LESTE")){
      Fase3Caminho2();
    }else{
      Fase3Caminho3();
    }
  }
public static void Fase3Caminho2(){
  Wave();

  System.out.println("-Perfeita luta soldado!");

  String resp = Repeticao("-Vamos avançar para NORTE, ele está trancado em umas das próximas salas","NORTE");
}

public static void Fase3Caminho3(){
  Repeticao("-Está sala tem muita munição, pegue quanto for necessário","PEGAR");
  Status[1] += 30;
  System.out.println("Você pegou cerca de 30 balas.")

  String resp = Repeticao("-Vamos avançar para NORTE e ver o que pode ter lá","NORTE");

  Fase3Caminho4()
}

public static void Fase3Caminho4(){
  String resp = Repeticao("Aqui a somente uma chave, digite PEGAR para adquirir a chave","PEGAR");

  if(Status[3] <= 0){
    System.out.println("-Pegou a chave");
    Status[3] = 1
  }

  resp = Repeticao("Não temos mais nada por aqui, vamos voltar pra SUL","SUL");

  Fase3Caminho1();
  
}

public static void Fase3Caminho5(){
  System.out.println("Bom, parece que estamos chegando no fim da linha. /n Queria dizer que independente do resultado da próxima batalha, /n fui um prazer lutar essa guerra com você!");

  String lcResp = Repeticao("Está preparado?","SIM,NÃO");

  if (!Status[3] > 0){
    lcResp = "NÃO";

    System.out.println("Você não achou a chave desta sala, vasculhe outras salas antes de proceguir");
  }
  if (lcResp == "SIM"){
    Status[3] = Status[3] - 1
    System.out.println("-Sua chave foi gasta!");

    System.out.println("Parece que vem alguns inimigos por aí!, vamos ter que lutar!");
    Wave();

    System.out.println("Mandou bem, acho que não preciso mais te chamar de soldado, /n quando voltarmos talvez seja coronel ou mais agora!(Risos)");
    Fase3Chefe();
  }else{
    Fase3Caminho1();
  }
}

public static void Fase3Final(){
  

  public static void fase3guardacostas (int a){
  System.out.println(" General - Soldado, seu aliados estão a caminho de derrotar o inimigo e salvar o cientista\n"
    + ", Sua missão principal é destruir a nave mãe dos alienigenas para acabar com qualquer chance de uma nova invasão a nossa terra ! Sabotando  a nave chame a atenção dos guardas para que a equipe 1 consiga salvar o cientista. \n"
    + " Esse caça que você está com o Capitão Jorge vai passar pela rota 70 metros acima da nave inimiga para não ser identificado, você deve saltar do avião e aterrisar furtivamente na nave inimiga, boa sorte na sua missão, o futuro da nossa raça está em suas mãos.\n"      
  + " Personagem - Voar 70 metros nesse tempo nublado ? Isso sim eu chamo de missão suicida\n " 
   + " Capt. Jorge - Criança, esse tempo é uma das nossas estratégias, com o céu nublado os inimgos não conseguirão ve-lo, tome muito cuidado ao aterrisar, se voce for localizado as coisas ficaram muito mais dificeis/n " 
    + " Use a roupa de Wingsuit que está no armário esquerdo, estamos a 9 minutos do ponto de salto."
  // Se o personagem tiver o poder de voar, ele responderá dessa forma, caso contrário pegará o wingsuit 
  + "Personagem - Wingsuit ? Acredito que eu consiga voar até lá/n "
  + "Capt. Jorge - Então é  você que pode voar ? Sempre quis ter essa sensação, por isso sou piloto dessa nave./n   "
   + " 15 segundos para salto, se prepare vou abrir a porta!\n "
   + " Levantar e ficar em posição de salto: (1) "); 

  System.out.println("Capt. Jorge - 5\n 4\n 3\n 2\n 1\n"
    + "Saltar (1)\n"
    + "Você pousou com sucesso na nave inimiga, agora deve buscar uma forma de invadir a nave /n"
    +" Buscar uma entrada escondida (1)\n Entrar pela porta principal da nave (2)");
    int t = scan.nextInt(); 
    
  while ( t == 2);
    do {
      System.out.println("Você foi encontrado pelos inimigos e raptado. Voltará para o início da missão ");
      }
    
  if (t == 1 ){   System.out.println("Você encontrou uma entrada de ar na parte superior da nave, para chegar até lá será necessário encontrar algo para escalar/n "
      + "Você encontrou uma lixeira, pode empura-la e subir para conseguir acessar a saída de ar/n");
                                     
      }
     System.out.println("Você encontrou uma lixeira, pode empura-la e subir para conseguir acessar a saída de ar/n "
 
    + " Empurrar lixeira (1)/n Buscar outra alternativa(2 ) "); 
    t = scan.nextInt(); 

    while (t == 2);
    do{
      System.out.println(" Personagem - Caramba olhei por todos os lados e acredito que não exista outra alternativa");
       
    }
      
      if (t == 1); {
      System.out.println("Você conseguiu acessar a saída de ar");
      }
    System.out.println(" Os dutos de ar vão por duas direções, você deseja seguir pela Direita(1) ou Esquerda(2)");
    t = scan.nextInt(); 
    while ( t == 2); 
    do {
      System.out.println("A saida desse lado está fechada, é possivel abri-la com ferramentas mas você não tem nenhuma, pode buscar outras alternativas"); 
    }
      if (t == 1 ){
      System.out.println("Saída encontrada, você está em uma sala desconhecida. pode voltar para o duto de ar (2) ou buscar por recursos(1)");
      t = scan.nextInt(); 
      while (t == 2 ); 
      do {
        System.out.println("Você voltou para o duto de ar mas precisa de recursos para conseguir abrir a outra saída, procure opções na sala anterior."); 
      }
        if (t == 1 ){
        System.out.println("Você encontrou a chave da para a saída trancada. Pode buscar mais recursos na sala (1) ou ir para a sala de controle para plantar a bomba(2)"); }
        t = scan.nextInt(); 
        while (t == 1);
          do {
            System.out.println("Não existem mais itens disponiveis nessa sala. ");
          }
            if (t == 2 ){
            System.out.println("Você está na sala de controle da nave inimiga. Aguarde o posicionamento dos aliados para plantar a bomba e fugir da nave"); 
            }
         System.out.println("Radio: Personagem 2 - Personagem 1, encontramos o cientista e estamos saindo da nave, estamos com o Personagem 3 que acabou de matar o chefe final. Plante a bomba e nos encontre no console de naves, vamos escapar com uma sub-nave."
          + "Digite (1) para plantar a bomba " ); 
             t = scan.nextInt();
      
           if ( t == 1 ){
              System.out.println("A bomba foi plantada, vá para o ponto de encontro o mais rápido possivel para evadir da nave inimiga. ");
             
      }


    

 public static void Inicio(int a) {
			String resp = "";
			int fim = 0;
			System.out.println("No ano de 2040, Em razao da evolução da medicina as pessoas pararam de morrer por envelhecimento,\n "
					+ " o que resultou em uma drastica diminuição de novas crianças nascendo biologicamente, ate o ano de 2070,\n"
					+ "	que a biologia humana evoluiu, e as pessoas não tinham mais a capacidade de ter filhos biologicamente.\n"
					+ "	Um medico descobriu uma forma de criar bebes em laboratorio, essas novas crianças ja nasciam destinadas \n"
					+ " a cumprir um papel pré designado para a sociedade\n");
			System.out.println(" Em 2407, tivemos nosso primeiro contato com uma raça inteligente vinda de outro planeta, logo foram\n "
					+ "compartilhados conhecimentos e formas como sociedade a sociedade funciona. Em uma vinda repentina, seres desse \n"
					+ " planeta vieram nos visitar, dizendo ser para estudos. Ao  ver a quantidade de recursos disponiveis na terra, logo \n"
					+ " iniciaram uma tentativa de tomada do planeta.\r \n"
					+ "Apos 30 anos de uma guerra extremamente destrutiva, a humanidade estava em desvantagem, e a derrota estava iminente,\n"
					+ "porêm, o mesmo medico que inventou a criançao de crianças por meio de laboratorio, fez uma descoberta que pode mudar\n"
					+ " o rumo da guerra. Ele descobriu uma forma de dar poderes a essas crianças que eram criadas, logo a primeira leva de super\n"
					+ "soldados foram criados e treinados para o combate.\n"
					+ "É ai que você nasceu, na primeira leva de super soldados\n");
			System.out.println("\n Qual o seu nome?");
			Nome[0] = scan.nextLine();
			
			String poder = "";
			System.out.println("Muito bem "+ nome +", agora escolha a sua classe digitando o numero referente a cada uma delas:");
			System.out.println("Classe 1 = Voador - Voe para passar por obstaculos e para te auxiliar na batalha\n"
					+ "Classe 2 = Super força - Com a super força, você pode se livrar de obstaculos e usar na batalha\n"
					+ "Classe 3 = Poder Psiquico - Possuia a capacidade de puxar objetos com o poder da mente, também pode ser usado contra adversarios\n");
			
			while(fim == 0) {
				System.out.println("1-VOADOR\n2-FORÇA\n-3PSI");
				resp = scan.nextLine().toUpperCase();
				if(resp.equals("VOADOR")) {
					resp = "VOADOR";
          Status[9] = 1;
					fim = 1;	
				}else if(resp.equals("FORÇA")) {
					resp = "FORÇA";
          Status[9] = 2;
					fim = 1;
				}else if(resp.equals("PSI")) {
					resp = "PSI";
          Status[9] = 3;
					fim = 1;
				}
			}fim = 0;
			
				System.out.println("classe escolhida: "+ resp);
    		
  }

//missão dois, começo.
public static void Missao2(int a) {
	int sala = 1;
	System.out.println("GENERAL-Equanto estamos nos encaminhando para o planeta, nossa nave acaba sendo interceptada\n"
			+ "pelos inimigos. Eles ja conseguiram entrar, nos juntamos a equipe para decidir qual será\n"
			+ "o plano para seguirmos a missao. Eles estão em maior numero, entao devemos seguir até\n"
			+ "a nave reserva para seguirmos viagem. Para isso devemos alem de chegar até la, implantar uma\n"
			+ "bomba no gerador principal, para abater os inimigos e ser possivel seguir viagem com a outra nave.Fale com Aya para ela\n"
			+ "te indicar quais materiais você deve encontrar.");
	System.out.println("Aya- Os materiais que você deve encontrar são o EXPLOSIVO e o DETONADOR, você tambem deve encontrar um mapa da nave para\n"
			+ "facilitar nosso caminho.Siga para a sala da frente e procure pela area, após achar os materiais siga para a porta ao norte e\n"
			+ " iniciaremos a missão");
	while (sala != 4) {
		if(sala == 1) {
			sala = sala1(sala);
		}else if(sala == 2) {
			sala = sala2(sala);
		}else if(sala == 3) {
			sala = sala3(sala);
		}
	}	
		System.out.println("GENERAL- Você conseguiu achar os materiais para a construção da bomba, porem ainda devemos intalar ela e chegar a nave\n"
				+ "te dou a liberdade de escolher qual será a sua missão, achar a nave ou explodir a nave\n"
				+ "1-NAVE\n2-EXPLODIR");
		String missao = scan.nextLine();
		if (missao.equals("nave")) {
			System.out.println("GENERAL- Você decidiu procurar pela nave, boa sorte em sua busca por ela, \n"
					+ "cuidado com possiveis obstaculos pelo caminho");
			int s = 1;
			labirinto(1);
		}else {
			System.out.println("GENERAL- Você decidiu usar o explosivo, boa sorte, \n"
					+ "cuidado com possiveis obstaculos pelo caminho");
      ExplodirNave(1);
		}
	}
	public static int sala1(int a) {
		int sala = 0;
		System.out.println("Você está em uma sala, existem tres portas, uma ao norte, você so deve avançar por essa após achar os materiais,\n"
				+ " uma a leste e uma a oeste, para qual voce deve seguir?");
		String caminho = Repeticao("1-NORTE\n2-LESTE\n3-OESTE", ("NORTE LESTE OESTE"));
		if(caminho.equals("NORTE")) {
			if((itens[0] == 1)&&(itens[1] == 1)) {
				System.out.println("Você conseguiu os materiais e avança");
				sala = 4;
				return sala;
			}else {
				System.out.println("Você não encontrou os itens da missão, continue procurando");
				sala = 1;
				return sala;
			}
		}else if(caminho.equals("LESTE")) {
			sala = 3;
			return sala;
		}else if(caminho.equals("OESTE")) {
			sala = 2;
			return sala;
		}
			
		return sala;
	}
	public static int sala2(int a) {
		int fim = 0;
		int sala = 1;
		int map = 0;
		int explosivo = 0;
		String caminho = "";
		while(fim != 1) {	
			System.out.println("Você está na sala OESTE, nessa sala existem 4 portas, para qual deseja seguir?\n1-NORTE\n2-OESTE\n3-SUL\n4LESTE(voltar a sala anterior)");
			caminho = scan.nextLine().toLowerCase();
			if(caminho.equals("norte")) {
				System.out.println("Você entrou para a porta norte, porem a sala esta vazia, você volta para a sala anterior");
			
			
			}else if(caminho.equals("sul")) {
				if(explosivo == 0) {
					System.out.println("Você entrou na porta sul, dentro dela se encontra o EXPLOSIVO, você deseja pega-lo?\n1- SIM\n2- NÃO");
					String item = scan.nextLine().toLowerCase();
					if(item.equals("sim")) {
						System.out.println("Você pegou o explosivo. Você volta para a sala anterior");
						itens[0] = 1;
					}else
					System.out.println("Não pegou, você volta para a sala anterior");
				}else {
					System.out.println("A sala está vazia, você volta para a sala anterior");
				}
			
			}else if(caminho.equals("oeste")){
				if(map == 0) {	
					System.out.println("Você entra na sala, dentro dela voce encontra um mapa da nave, deseja pela-lo?\n1- SIM\n2- NÃO");
					String mapa = scan.nextLine();
					if(mapa.equals("sim")) {
						System.out.println("Você pegou o mapa. Você volta para a sala anterior");
						int mapa1 = 1;
					}else
						System.out.println("Não pegou, você volta para a sala anterior");
				}else
					System.out.println("A sala está vazia, você volta para a sala anterior");
			
			}else if(caminho.equals("leste")){
				System.out.println("Você voltou para a sala principal a LESTE");
				fim = 1;
			}else
				System.out.println("Resposta invalida");
		}
		return sala;
	}
	public static int sala3(int a) {
		int fim = 0;
		int sala = 1;
		int detonador = 0;
		String caminho = "";
		while(fim != 1) {	
			System.out.println("Você está na sala LESTE, nessa sala existem 3 portas, para qual deseja seguir?\n1-NORTE\n2-OESTE(Voltar a sala principal)\n3-SUL)");
			caminho = scan.nextLine().toLowerCase();
			if(caminho.equals("norte")) {
				System.out.println("Você entrou para a porta norte, porem a sala esta vazia, você volta para a sala anterior");
				
			}else if(caminho.equals("sul")) {
				if(detonador == 0) {
					System.out.println("Você entrou na porta sul, dentro dela se encontra o DETONADOR, você deseja pega-lo?\n1- SIM\n2- NÃO");
					String item = scan.nextLine().toLowerCase();
					if(item.equals("sim")) {
						System.out.println("Você pegou o detonador. Você volta para a sala anterior");
						itens[1] = 1;
					}else
						System.out.println("Não pegou, você volta para a sala anterior");
				}else
					System.out.println("A sala está vazia, você volta para a sala anterior");
			
			}else if(caminho.equals("oeste")){
				System.out.println("Você voltou para a sala principal a OESTE");
				fim = 1;
			}else
				System.out.println("Valor invalido");
		}
		return sala;
	}
	

	
	public static void labirinto(int a) {
		int sala = 1;
		while (sala != 11) {
			if(sala == 1) {
				sala = s1(sala);
			}else if(sala == 2) {
				sala = s2(sala);
			}else if(sala == 3) {
				sala = s3(sala);
			}else if(sala == 4) {
				sala = s4(sala);
			}else if(sala == 5) {
				sala = s5(sala);
			}else if(sala == 6) {
				sala = s6(sala);
			}else if(sala == 7) {
				sala = s7(sala);
			}else if(sala == 8) {
				sala = s8(sala);
			}else if(sala == 10) {
				sala = s10(sala);
			}
		}	
		
	}
	
	//labirinto!!
	public static int s1(int a) {
		int s = 1;
		int fim = 0;
		String resp = "";
		System.out.println("Você está em uma sala, existem duas portas, uma a leste e uma a oeste, para qual voce deve seguir?n1- LESTE\n 2- OESTE");
		String sala = scan.nextLine().toLowerCase();
		resp = Repeticao("1-LESTE\n-2OESTE","LESTE OESTE");
		if(resp.equals("OESTE")) {
			System.out.println("Você entrou na sala OESTE");
			s = 2;
		}else if(resp.equals("OESTE")){
			System.out.println("Você entrou na sala LESTE");
			s = 4;
		}
		return s;
	}
	public static int s2(int a) {
		int s = 2;
		int fim = 0;
		String resp = "";
		System.out.println("Você está em uma sala, existem duas portas, uma a leste para voltar a sala principal e uma a sul, para qual voce deve seguir?n1- LESTE\n 2- SUL");
		resp = Repeticao("1-LESTE\n2-SUL", "LESTE SUL");
		if(resp.equals("LESTE")) {
			s = 3;
		}else if(resp.equals("SUL")){
			s = 1;
		}
		
		return s;
	}
	public static int s3(int a) {
		int s = 2;
		int fim = 0;
		System.out.println("Você está em uma sala sem saida, você volta para a sala anterior");
		
		return s;
	}
	public static int s4(int a) {
		int s = 2;
		int fim = 0;
		String resp = "";
		System.out.println("Você está em uma sala, existem duas portas, uma a leste e uma a oeste, \n"
				+ "e uma ao norte para voltar para a sala principal. Para qual voce deve seguir?n1-LESTE\n2-OESTE\n3-NORTE");
		resp = Repeticao("1-LESTE\n2-OESTE\n3-NORTE", "LESTE OESTE NORTE");
		if(resp.equals("LESTE")) {
			s = 5;
		}else if(resp.equals("OESTE")){
			s = 8;
		}else if(resp.equals("NORTE")) {
			s = 1;
		}
		
		return s;
	}
	public static int s5(int a) {
		int s = 2;
		int fim = 0;
		String resp = "";
		System.out.println("Você está em uma sala, existem duas portas, uma a sul e uma a norte, \n"
				+ "e uma a oeste para voltar para a sala anterior. Para qual voce deve seguir?n1-SUL\n2-NORTE\n3-OESTE");
		resp = Repeticao("1-SUL\n2-NORTE\n3-EOSTE", "SUL OESTE NORTE");
		if(resp.equals("SUL")) {
			s = 7;
		}else if(resp.equals("OESTE")){
			s = 4;
		}else if(resp.equals("NORTE")) {
			s = 6;
		}
		
		return s;
	}
	public static int s7(int a) {
		int s = 5;
		int fim = 0;
		System.out.println("Você está em uma sala sem saida, você volta para a sala anterior");
		
		return s;
	}
	public static int s6(int a) {
		int s = 5;
		int fim = 0;
		System.out.println("Você está em uma sala sem saida, você volta para a sala anterior");
		
		return s;
	}

	public static int s8(int a) {
		int s = 2;
		int fim = 0;
		String resp = "";
		System.out.println("Você está em uma sala, existem duas portas, uma a sul e uma a leste, \n"
				+ "e uma a norte para voltar para a sala anterior. Para qual voce deve seguir?n1-SUL\n2-NORTE\n3-OESTE");
		resp = Repeticao("1-SUL\n2-NORTE\n3-LESTE", "SUL LESTE NORTE");
		if(resp.equals("SUL")) {
			s = 10;
		}else if(resp.equals("LESTE")){
			s = 9;
		}else if(resp.equals("NORTE")) {
			s = 4;
		}
		return s;
	}
	public static int s9(int a) {
		int s = 8;
		int fim = 0;
		System.out.println("Você está em uma sala sem saida, você volta para a sala anterior");
		
		return s;
	}
	public static int s10(int a) {
		int s = 11;
		int fim = 0;
		System.out.println("Você encontrou a nave, porem existem inimigos guardando elas e você deve elimina-los.");
		
		return s;

	}

 
    public Static void Wave(){
      
		int t = 1;
		int balas = 10;
		int vida = 50;
		int fim = 0;
		String resp = "";
		System.out.println(" Chegando nas coordenadas mandada pela base observa de longe que é uma emboscada,o inimigo te cerca e começa á atirar sem cessar .");
		t = 1;
		if (t == 1) {
			System.out.println("o inimigo te ataca, com vários tiros . \n"
					+ "tu corre e se esconde \n"
					+ "desvia e atira no inimigo \n"
					+ "qual será sua reação?");
			while(fim == 0) {
				System.out.println("1-CORRER \n2-ATACAR ");
				resp = scan.nextLine().toUpperCase();
				if(resp.equals("CORRER")) {
					resp = "CORRER";
					fim = 1;	
				}else if(resp.equals("ATACAR")) {
					resp = "ATACAR";
					fim = 1;
					}
			}fim = 0;
			if (resp.equals("ATACAR")) {
				System.out.println("Você pega um destroço e se abriga em seguida atira na direção do inimigo :");
				while(fim == 0) {
					System.out.println("1-CONTINUAR ATACANDO \n2-AGUARDAR REAÇÃO DO INIMIGO");
					resp = scan.nextLine().toUpperCase();
					if(resp.equals("CONTINUAR ATACANDO")) {
						t = 1;
						fim = 1;	
					}else if(resp.equals("REAÇÃO DO INIMIGO")) {
						t = 2;
						fim = 1;
						}
				}fim = 0;
				if (t == 1) {
					System.out.println("Você conseguiu afastar o inimigo, deseja avançar e ganhar território ?:\n continuar avançando e atirando(1) / aguardar movimento inimigo(2)");
					if(t == 1) {
						System.out.println("O inimigo está sem saída, avançar?");
						while(fim == 0) {
							System.out.println("1-\n2-ATIRAR");
							resp = scan.nextLine().toUpperCase();
							if(resp.equals("AGUARDAR INIMIGO")) {
								t = 1;
								fim = 1;	
							}else if(resp.equals("ATIRAR")) {
								t = 2;
								fim = 1;
								}
						}fim = 0;
								if (t == 1) {
									System.out.println("Sua munição está acabando, está vindo reforço");
								}else
									System.out.println("acabou sua munição mas elimnou o inimigo!");
									atirar(1);			
					}else
						System.out.println("Voçê conseguiu eliminar todos os inimigo, continue avançando");
						atirar(1);
				}
						
					
				
					
			}else {
				System.out.println("Outro pilotão de inimigos está avançando, aguardar reforço? ,\n"
						+ "antes que voce consiga fazer algo, entre em contato com a base, voce deseja: falar enviar sua localização?(1)\n"
						+ " aguardar em silêncio(2)?");
				atirar(1);
				dano1(1);
				while(fim == 0) {
					System.out.println("1-INFORMAR\n2-CORRER");
					resp = scan.nextLine().toUpperCase();
					if(resp.equals("INFORMAR")) {
						t = 1;
						fim = 1;	
					}else if(resp.equals("CORRER")) {
						t = 2;
						fim = 1;
						}
				}fim = 0;
				if (t == 1) {
					System.out.println("Voçê enviou sua localização o grupo de apoio está chegando, há poucas balas no pente");
					atirar(1);
				}else
					System.out.println("estão jogando bombas de fumaças\n "
							+ "um inimigo chegando muito próximo, voce deseja: \ gastar as últimas balas do pente?(1)\n golpear com as mãos(2)?");
					dano1(2);
					while(fim == 0) {
						System.out.println("1-ABATER\n2-ATIRAR");
						resp = scan.nextLine().toUpperCase();
						if(resp.equals("ABATER")) {
							t = 1;
							fim = 1;	
						}else if(resp.equals("ATIRAR")) {
							t = 2;
							fim = 1;
							}
					}fim = 0;
					if (t == 1) {
						System.out.println("voce conseguiu abater o primeiro inimigo");
					}else {
						System.out.println("Voce conseguiu abater o inimigo, porém gastou uma bala");
						atirar(1);
					}
				
			}
		}else {
			System.out.println(" inimigo morto \ aguarde o apoio quieto(1)\n sair e procurar outro lugar para ficar(2)?");
			while(fim == 0) {
				System.out.println("1-AGUARDAR \n2-ATIRAR");
				resp = scan.nextLine().toUpperCase();
				if(resp.equals("AGUARDAR")) {
					t = 1;
					fim = 1;	
				}else if(resp.equals("ATIRAR")) {
					t = 2;
					fim = 1;
					}
			}fim = 0;
			if (t == 1) {
				System.out.println("Te acharam e atirarm na sua direção  \n"
						+ "Antes que voce possa fazer algo, ele te acerta um tiro. Voce deseja: \ se esconder (1)\ correr em direção a sua nave(2)?");
				dano1(1);
				t = scan.nextInt();
				if (t == 1) {
					System.out.println("Voçê achou um pente de balas no colete, desejar atirar para afastar inimigos");
					atirar(1);
				}else {
					System.out.println("Voçê deu de frente com um inimigo e atirou, ele está agonizando na sua frente"
							+ ", voce deseja: \ deixar ele agonizando? (1)\ abate-lo com as mãos(2)?");
					dano2(1);
					while(fim == 0) {
						System.out.println("1-DEIXAR \n2-MATAR");
						resp = scan.nextLine().toUpperCase();
						if(resp.equals("DEIXAR")) {
							t = 1;
							fim = 1;	
						}else if(resp.equals("MATAR")) {
							t = 2;
							fim = 1;
							}
					}fim = 0;
					if (t == 1) {
						System.out.println("O reforço chegou, está um combate intenso, quer atirar?");
						atirar(1);
					}else
						System.out.println("Voçê segue atirando nos inimigos");
				}
				
			}else {
				System.out.println("Os inimigos estão recuando, seus aliados começam a ganhar a batalha .\n"
						+ " estão vindo os útltimos inimigos da esquerda, estão sem saída . Voce deseja: \n atirar nele (1) \nrecuar com os aliados (2)?");
				dano1(1);
				t = scan.nextInt();
				if (t == 1) {
					System.out.println("Voçê matou mais um inimigo, perdeu mais duas balas");
					atirar(1);" só restam poucas balas no pente "
				}else
					System.out.println("enquanto você se esconde, voce toma outro tiro e perde vida\n "
							+ "seus inimigos chegaran perto, voce deseja: \nabate-lo com as maos(1)\n abate-lo com um tiro(2)?");
					dano1(1);
					while(fim == 0) {
						System.out.println("1-MATAR\n2-ATIRAR");
						resp = scan.nextLine().toUpperCase();
						if(resp.equals("MATAR")) {
							t = 1;
							fim = 1;	
						}else if(resp.equals("ATIRAR")) {
							t = 2;
							fim = 1;
							}
					}fim = 0;
					if (t == 1) {
						System.out.println("você venceu a batalha! ");
					}else
						System.out.println("volte para a base ");
				
							
					}	
				} 

      public static void Wave2(){
        System.out.println("Começamos uma luta");

        int vida = 50;
        do{
          System.out.println("O que deseja fazer?");
          String resp = Repeticao(" 1-MIRAR \n 2-ATIRAR \n 3-USAR POTE \n 4-ATIVAR PROTEÇÃO","MIRAR , ATIRAR , USAR POTE , ATIVAR PROTEÇÃO");

          if(resp.contains("MIRAR")){
            vida = vida - 10;
          }else if(resp.contains("ATIRAR"){
            if(Sorteio()){
              vida = vida - 10;
            }else{
              vida = vida - 5;
            } 
          }else if(resp.contains("USAR") || resp.contains("POTE")){
            PoteVida();
          }else if(resp.contains("ATIRAR") || resp.contains("PROTEÇÃO")){
            status[8] ++;
          }

          int randon = (int)(Math.random() * 4);

          if(randon == 0){
            dano1();
          }else if(randon == 1){
            vida = vida + 5;
          }else if(randon == 2){
            
          }
          
          
        }
      }
			}
}
   public static void ExplodirNave(int a) {
		int sala = 1;
		while (sala != 4) {
			if(sala == 1) {
				sala = c1(sala);
			}else if(sala == 2) {
				sala = c2(sala);
			}else if(sala == 3) {
				sala = c3(sala);
			}
		}
		System.out.println("Você passou para a proxima sala, você avista inimigos a frente");
		Wave;
		System.out.println("Você passou pelos inimigos, porem na sala seguinte existe um guarda, assegurando a posição onde você deve instalar a bomba, \n"
				+ "ele aparenta ser mais forte que os outros");
		Wave2;
	}
	
	public static int c1(int a) {
		int s = 1;
		int fim = 0;
		String resp = "";
		System.out.println("Você está em uma sala, existem tres portas, uma a lestez uma a oeste e uma a norte, para seguir para a luta, para qual voce deve seguir?");
		String sala = scan.nextLine().toLowerCase();
		resp = Repeticao("1-LESTE\n2-OESTE","LESTE OESTE");
		if(resp.equals("LESTE")) {
			System.out.println("Você entrou na sala OESTE");
			s = 2;
		}else if(resp.equals("OESTE")){
			System.out.println("Você entrou na sala LESTE");
			s = 3;}
		else if(resp.equals("NORTE")){
			System.out.println("Você entrou na sala LESTE");
			s = 4;}
		return s;
		}
		public static int c2(int a) {
			int s = 1;
			int fim = 0;
			String resp = "";
			System.out.println("Você está em uma sala, existem um equipamento para sua arma, para aumentar a capacidade de munição, deseja pegar?");
			String sala = scan.nextLine().toLowerCase();
			resp = Repeticao("1-SIM\n2-NAO","SIM NAO");
			if(resp.equals("SIM")) {
				System.out.println("Você pegou o item");
				
			}else if(resp.equals("NAO")){
				System.out.println("Você não pegou o item");
				
			}
			System.out.println("Você volta para a sala anterior");
			return s;
		}
		public static int c3(int a) {
			int s = 1;
			int fim = 0;
			String resp = "";
			System.out.println("Você está em uma sala, existem um colete que serve para aumentar sua vida maxima, deseja pegar?");
			String sala = scan.nextLine().toLowerCase();
			resp = Repeticao("1-SIM\n2-NAO","SIM NAO");
			if(resp.equals("SIM")) {
				System.out.println("Você pegou o item");
				
			}else if(resp.equals("NAO")){
				System.out.println("Você não pegou o item");
				
			}
			System.out.println("Você volta para a sala anterior");
			return s;
		}
		

	   
}
