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
    Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
      Status[0] = 50;//vida
	    Status[1] = 10;//balas
	    Status[2] = 2;//mana
	    Status[3] = 0;//chave
      Status[4] = 60;//municão
      Status[5] = 3;//PoteMana
      Status[6] = 3;//PoteVida
      Status[7] = 3;//Granadas
      Status[8] = 0;
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
    if (status[5] > 0 && status[2] = 0){
      status[2]= 2;
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
      
      String lcPegar = ("digite PEGAR RIFLE para pegar sua arma inicial.","PEGAR RIFLE");
      
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
	public static void Fundo (int a) {
    Status[8] = 31;
		int t = 1;
		int balas = 10;
		int vida = 50;
		if (t == 1) {
			System.out.println("General- Conseguimos informaçoes que o cientista esta preso em uma instalação,\n"
					+ "sua missão será resgatar e traze-lo com vida, ele é essencial para o sucesso nesta guerra\n"
					+ "e sem ele nosso planeta corre sérios riscos, você irá entrar pelos fundos furtivamente,\n"
					+ "devera entrar e sair sem alertar, seu companheiro dara um jeito de chamar atençao dos guardas\n"
					+ "para eles sairem e facilitar sua entrada e saida, boa sorte!.");
			System.out.println("O seu companheiro está chamando atençao para distrair os guardas, \n"
					+ "você escolhe o: \ncaminho 1(ir pelos fundos)\ncaminho2(entrar pelo tunel do esgoto?)");
			t = scan.nextInt();
			if (t == 1) {
				System.out.println("voce decidiu entrar pelos fundos. Você se depara com dois guardas guardando o portao. \n"
						+ "existe uma caixa a direita e uma a esquerda, o guarda da esqueda olha na direção do segundo guarda \n"
						+ "o outro guarda olha para a frente, existe uma  chance de chegar pelas costas de um dos dois\n"
						+ ". Por qual caixa você deseja seguir? \nEsquerda(1)\nDireita(2)");
				t = scan.nextInt();
				if (t == 1) {
					System.out.println("Você se aproxima do alvo da esquerda, deseja abate-lo: \n furtivamente(1)\nCom sua arma(2)");
					t = scan.nextInt();
					if (t == 1) {
						System.out.println("você conseguiu abate-lo furtivamente, você deseja chegar perto do segundo:\n"
								+ "Aproximar-se furtivamente(1)\nAtirar nele de longe(2)");
					}
					if(t == 1) {
						System.out.println("Voce consegue se aproximar do segundo guarda sem ser visto, deseja abate-lo\n"
								+ "furtivamente(1)\natirar nele(2)?");
								t = scan.nextInt();
								if (t == 1) {
									System.out.println("Voce consegue abater o alvo furitvamente");
								}else
									System.out.println("Voce consegue abater o alvo, mas perde uma bala");
									balas --;
						
					}else
						System.out.println("Voce consegue eliminar o segundo guarda com sua arma, mas perde uma bala");
						balas --;
						
						
				//caminho 2, usando a arma
					
				}else {
					System.out.println("Você consegue abater o primeiro guarda, porem o segundo te nota devido ao barulho de sua arma,\n"
							+ "antes que voce consiga fazer algo, ele consegue te acertar um tiro, voce deseja: \natirar nele de volta(1)\n"
							+ "correr na sua direção(2)?");
					balas --;
					vida =vida - 5;
					t = scan.nextInt();
					if (t == 1) {
						System.out.println("voce consegue eliminar o segundo guarda, mas perde uma bala");
						balas --;
					}else
						System.out.println("enquanto voce corre na direção dele, voce toma outro tiro e perde vida\n "
								+ "ao chegar perto, voce deseja: \nabate-lo com as maos(1)\n Abate-locom um tiro(2)?");
						vida = vida - 5;
						t = scan.nextInt();
						if (t == 1) {
							System.out.println("voce conseguiu abater o primeiro inimigo");
						}else {
							System.out.println("Voce conseguiu abater o inimigo, porem gastou uma bala");
							balas --;
						}
				
				}
			}else {
				System.out.println("Voce consegue chegar no guarda sem ser visto\nabate-lo furtivamente (1)\n abalte-lo usando sua arma (2)?");
				t = scan.nextInt();
				if (t == 1) {
					System.out.println("Voce consegue abater o guarda, porem o segundo guarda te ve pois estava olhando em sua direção. \n"
							+ "Antes que voce possa fazer algo, ele te acerta um tiro. Voce deseja: \natirar nele (1)\ncorrer em sua direção (2)?");
					vida = vida - 5;
					t = scan.nextInt();
					if (t == 1) {
						System.out.println("Voce consegue abater o segundo, porem perde uma bala");
						balas --;
					}else {
						System.out.println("Voce corre na direção do inimigo, porem ele te acerta um tiro no caminho. Ao chegar la"
								+ ", voce deseja: \natirar (1)\nabate-lo com um soco(2)?");
						vida = vida - 5;
						t = scan.nextInt();
						if (t == 1) {
							System.out.println("Voce consegue abater o segundo guarda, porem gasta munição");
							balas --;
						}else
							System.out.println("Voce consegue abater o guarda com um soco");
					}
					// caminho usando a arma
				}else {
					System.out.println("Voce consegue abater o guarda, porem o segundo guarda consegue ver.\n"
							+ "Antes que voce possa fazer algo, ele te acerta um tiro. Voce deseja: \natirar nele (1) \ncorrer em sua direção (2)?");
					vida = vida - 5;
					t = scan.nextInt();
					if (t == 1) {
						System.out.println("voce consegue eliminar o segundo guarda, mas perde uma bala");
						balas --;
					}else
						System.out.println("enquanto voce corre na direção dele, voce toma outro tiro e perde vida\n "
								+ "ao chegar perto, voce deseja: \nabate-lo com as maos(1)\n abate-lo com um tiro(2)?");
						vida = vida - 5;
						t = scan.nextInt();
						if (t == 1) {
							System.out.println("voce conseguiu abater o primeiro inimigo");
						}else
							System.out.println("Voce conseguiu abater o inimigo, porem gastou uma bala");
							balas --;
							
				}	
			}//primeiro if/else
		}//if fundo
		
	}//fundo
	
	
	
	public static void entrou(int a) {
		Scanner scan = new Scanner(System.in);
		int balas = 10;
		int vida = 50;
		int chave1 = 0;
		int secreta = 0;
		int avançou = 0;
		int refil1 = 0;
		int t = 0;
		while(avançou != 1) {
			System.out.println("Você esta em uma sala com tres portas. para qual você deseja ir?\nPorta leste(1)\nPorta Oeste(2)\nPorta Norte(3)");
			t = scan.nextInt();
			switch (t) {
			case 1:
				if (chave1 == 0) {	
					System.out.println("Você entrou na porta Leste, Dentro da sala você acha uma chave, deseja pega-la?\nSim(1)\nNão(2)");
					t = scan.nextInt();
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
				t = scan.nextInt();
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
		
	}//fim função entrou
	
	public static int caminho1(int a) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Você se encontra em um corredor, com uma porta ao norte e a continuação do corredor a leste, para onde deseja ir?"
				+ "\nPorta ao norte(1)\nContinuar no corredor(2)");
		int t = scan.nextInt();
		int caminho = 0;
		if (t == 1) {
			caminho = 2;
			return caminho;
		}else
			caminho = 3;
			return caminho;
		
	}// fim função caminho1
	
	public static int caminho2(int a, int b) {
		Scanner scan = new Scanner(System.in);
		int fim = 0;
		int t = 1;
		int chave = b;
		int caminho = 0;
			if (chave == 0){
				System.out.println("Na sala você avista um painel, porem precisa de uma chave para liberar, você volta ao corredor\n");
				caminho = 1;
				return caminho;
			}else
				System.out.println("Apos desbloquear o painel com a chave, você pode verefica-lo:\nVerificar computador(1)\nVoltar para o corredor(2)");
				t = scan.nextInt();
					if (t == 1) {
						System.out.println("O painel apresenta uma senha, voce pode:\nHackear computador(1)\nDesistir(2)");
						t = scan.nextInt();
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
									t = scan.nextInt();
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
		}//fim caminho 2
	
	public static int caminho3(int a) {
		Scanner scan = new Scanner(System.in);
		int t = 0;
		int caminho = 0;
		System.out.println("Ao chegar no final do corredor, voce encontra uma porta a leste\nEntrar na porta ao leste(1)\nVoltar a oeste para o começo do corredor(2) ");
		t = scan.nextInt();
			if (t == 1) {
				System.out.println("Você passa pela porta");
				caminho = 4;
				return caminho;
			}else
				System.out.println("Você volta para o começo do corredor");
				caminho = 1;
				return caminho;
		}//fim caminho 4
	
	public static int caminho4(int a) {
		Scanner scan = new Scanner(System.in);
		int t = 0;
		int caminho = 0;
		int t2 = 1;
		int vida = 40;
		int poção = 1;
		while(t2 != 0) {
			System.out.println("norte(1)\nleste(2)\noeste(3)\nsul(4)");
			t = scan.nextInt();
			if(t == 1) {
				System.out.println("a sala esta vazia, voce volta para a sala anterior");
			}else if(t == 2) {
				System.out.println("Você encontra uma poção de cura, voce deseja tomar?\nSim(1)\nNão(2)");
				t = scan.nextInt();
				if (t == 1) {
					System.out.println("Sua vida foi regenerada, você volta para a sala anterior");
					vida = 50;
				}else
					System.out.println("Você volta para a sala anterior");
			}else if(t == 3) {
				System.out.println("Você passa para outra sala");
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
	}//fim caminho 4
	
	public static int caminho5(int a) {
		Scanner scan = new Scanner(System.in);
		int t = 0;
		int caminho = 0;
		int t2 = 2;
		int c = 1;
		while (t2 != 1) {
			System.out.println("Você se encontra em uma sala com três portas, norte, sul e leste,e uma a Oeste para voltar de onde veio.\nPara qual você deseja ir?\n"
					+ "Norte(1)\nSul(2)\nOeste(3)");
			t = scan.nextInt();
			if (t == 1) {
				System.out.println("voce volta para a sala anterior");
				caminho = 4;
			}else if (t == 2) {
				if (c == 1) {
				System.out.println("Você encontra uma chave, voce deseja pegar?\nSim(1)\nNão(2)");
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
	//fim caminho 5
	
	public static int caminho6(int a) {
		Scanner scan = new Scanner(System.in);
		System.out.println("avançar(1)\nRecuar(2)");
		int t = scan.nextInt();
		int caminho = 0;
		if (t == 1) {
			caminho = 8;
		}else {
			caminho = 5;}
		return caminho;
			
	}//fim caminho 6

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
  Scanner scan = new Scanner (System.in);
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
    
if (t == 1 ) {
     System.out.println("Você encontrou uma entrada de ar na parte superior da nave, para chegar até lá será necessário encontrar algo para escalar/n "
      + "Você encontrou uma lixeira, pode empura-la e subir para conseguir acessar a saída de ar/n  "
       + " Empurrar lixeira (1)/n Buscar outra alternativa(2 ) ");
      t = scan.nextInt(); 

  
      if (t == 1){ 
        System.out.println(" Você conseguiu acessar a saída de ar "); 
       
        }else {
        System.out.println(" Personagem - Droga, não tenho muitas opções. "); 
        }
      System.out.println(" Os dutos de ar vão por duas direções, você deseja seguir pela Direita(1) ou Esquerda(2)");
      t = scan.nextInt(); 
      
      if (t == 1 ){
        System.out.println("Saída encontrada. (1) para sair do duto e pular na sala, (2) para voltar ");
        t = scan.nextInt(); 
       
        if (t == 1 ){
          System.out.println("Você está em uma sala desconhecida. pode tentar sair (1) ou buscar por recursos (2)"); 
          t = scan.nextInt(); 
         
          if (t == 2){ 
            System.out.println(" Você encontrou um kit de ferramentas e um teaser (com ele você pode abater guardas silenciosamente)/n"
           // funcão olhar  
        + "Com o kit de ferramentas você poderá abrir a porta segunda sáida do duto de ar. Deseja retornar para o duto ? Sim (1) Não (2) " ); 
            t = scan.nextInt(); 
           
            if (t == 1){ 
              System.out.println("Você usou o kit de ferramentas para abrir o a saida e encontrou a sala de controle da nave, plante a bomba e aguarde contato dos aliados para iniciar o cronometro/n "
        + "Personagem 2 - Personagem 1, encontramos o cientista e estamos saindo da nave, estamos com o Personagem 3 que acabou de matar o chefe final. Plante a bomba e nos encontre no console de naves, vamos escapar com uma sub-nave.");
            System.out.println("Digite 1 para plantar a bomba"); 
              t = scan.nextInt(); 
            
              if ( t == 1 ){
              System.out.println("A bomba foi plantada, vá para o ponto de encontro o mais rápido possivel para evadir da nave inimiga. ");
            
                }else 
              System.out.println("Você precisa plantar a bomba agora."); 
             
              }else 
              System.out.println("Você pode procurar por mais itens mas deve seguir pelo duto para continuar sua missão ");
           
            }else 
            System.out.println("A sala está trancada, aparentemente existe uma barricada do outro lado ");
         
          }else
          System.out.println("Você está voltando para a entrada principal. ");
       
        }else 
        System.out.println("A saida desse lado está fechada, é possivel abri-la com ferramentas mas você não tem nenhuma, pode buscar outras alternativas");
      }
}
    
}