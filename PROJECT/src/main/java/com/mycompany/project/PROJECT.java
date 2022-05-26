package com.mycompany.project;

import java.util.Scanner;

public class PROJECT {
    public static int[] Status;
    public static String Nome;
    public static int[] Nivel;
    public static int[] itens;
  
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

      Nome = "";

      Inicio();
      PrimeiraFase();
      Missao2();
      System.out.println("GENERAL- Finalmente nos conseguimos chegar no planeta com a nave reserva e com todos em segurança, devemos agir rapido, entrar e sair do planeta o mais rapido possivel e em segurança. Iremos dividir nossos super soldados e cada um terá um objetivo, serão três no total. Cada um terá um objetivo, e todos devem cumprir sua respectivas missões, so assim teremos sucesso em nosso objetivo. ");
      System.out.println("GENERAL- "+ Nome + "poderá escolher primeiro qual a missão deseja cumprir, as missoes são:\n1-Entrar furtivamente na instalação em que o cientista esta, resgata-lo e traze-lo em segurança para partimos de volta para a terra.\n2- Criar uma distração para que as outras duas partes possam cumprir sua missão\n3- Enfrentar o lider do planeta, para acabar com a guerra de uma vez por todas.\nQual missão você deseja cumprir?");
      String resp = Repeticao("1-RESGATE\n2-DISTRAÇÃO\n3-CHEFE", "RESGATE DISTRAÇÃO CHEFE");
      if(resp.equals("RESGATE")){
        Fase3();
      }else if(resp.equals("DISTRAÇÃO")){
        Fase3guardacostas();
      }else if(resp.equals("CHEFE")){
        Fase3Chefe();
      }
    }
      public static void dano1() {
  		Status[0] = Status[0] - 5;
  	}
  	public static void dano2() {
  		Status[0] = Status[0] - 10;		
  	}
  	public static void atirar() {
      if (Status[1] > 0){
        Status[1] = Status[1] - 1;
      }	
  	}
  	public static void recarregar() {
      if (Status[4] > 0){
        if (Status[4] >= 10){
          Status[1] = 10;
          Status[4] = Status[4] - 10;
        }else{
          Status[1] = Status[4];
          Status[4] = Status[4];
        }
      }else{
        System.out.println("Não Recarregou");
      }	
  	}
  public static void Granada() {
    if (Status[7] > 0){
      Status[7] = Status[7] - 1; 
    }else{
      System.out.println("Não tem mais granadas!");
    }
    
  }
  
  public static void PoteMana() {
    if (Status[5] > 0 && Status[2] == 0){
      Status[2]= 2;
      Status[5] = Status[5] - 1;
    }else{
      System.out.println("Você pode não ter mais potes de mana, ou ainda lhe sobram cargas de poder");
    }
  }

  public static void PoteVida() {
    if (Status[6] > 0){
      Status[0] = Status[0] + 15 ;
      Status[6] = Status[6] - 1;
    }else{
      System.out.println("Você pode não ter mais potes de mana, ou ainda lhe sobram cargas de poder");
    }
  }
  
  public static void chave() {
    Status[3]= 1;
  }
  
  public static void MenosChave() {
    Status[3]= 0;
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
    System.out.println("Vida: " + Status[0] +"\n" +
                      "Poder: " + Status[2] +"\n" +
                      "Balas na arma: " + Status[1] + "\n" +
                      "Munição: "+ Status[4] +
                      "Local: " + local +
                      "Potes de mana: " + Status[5] +"\n" +
                      "Potes de vida: " + Status[6]);
    
    System.out.println("Escolhas:");
  
    if(poder && Status[2] > 0){
        System.out.println("Seu poder pode ser usado!");
    }
  }

  public static void PrimeiraFase(){
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
        
        switch(Status[3]){
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

      //MostrarStatus(,false);
    }while(!Resp.contains(lcRosa));

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
    public static void Fundo() {
                    int fim = 0;
                    String resp = "";
                    System.out.println("voce decidiu entrar pelos fundos.");

                    System.out.println("VocÃª se depara com dois guardas guardando o portao. \n"
                                            + "existe uma caixa a direita e uma a esquerda, o guarda da esqueda olha na direÃ§Ã£o do segundo guarda \n"
                                            + "o outro guarda olha para a frente, existe uma  chance de chegar pelas costas de um dos dois\n"
                                            + ". Por qual caixa vocÃª deseja seguir?");
                    resp =Repeticao("1-ESQUERDA\n2-DIREITA","ESQUERDA,DIREITA");		
                    if (resp.equals("ESQUERDA")) {
                                    System.out.println("VocÃª se aproxima do alvo da esquerda, deseja abate-lo?");
                                    resp = Repeticao("1-SIM 2-NAO", "SIM NAO");
                                    if (resp.equals("SIM")) {
                                            System.out.println("vocÃª conseguiu abate-lo furtivamente, vocÃª deseja chegar perto do segundo:\n"
                                                            + "Aproximar-se furtivamente(1)\nAtirar nele de longe(2)");
                                            resp = Repeticao("1-FURTIVAMENTE 2-ATIRAR", "FURTIVAMENTE ATIRAR");
                                            if(resp.equals("FURTIVAMENTE")) {
                                                    System.out.println("Voce consegue se aproximar do segundo guarda sem ser visto, deseja abate-lo");
                                                    resp = Repeticao("1-FURTIVAMENTE 2-ATIRAR", "FURTIVAMENTE ATIRAR");
                                                                    if (resp.equals("FURTIVAMENTE")) {
                                                                            System.out.println("Voce consegue abater o alvo furitvamente");
                                                                    }else
                                                                            System.out.println("Voce consegue abater o alvo, mas perde uma bala");
                                                                            atirar();			
                                            }else
                                                    System.out.println("Voce consegue eliminar o segundo guarda com sua arma, mas perde uma bala");
                                                    atirar();
                                    }else {
                                    System.out.println("VocÃª consegue abater o primeiro guarda, porem o segundo te nota devido ao barulho de sua arma,\n"
                                                    + "antes que voce consiga fazer algo, ele consegue te acertar um tiro, voce deseja: \natirar nele de volta(1)\n"
                                                    + "correr na sua direÃ§Ã£o(2)?");
                                    atirar();
                                    dano1();
                                    resp = Repeticao("1-ATIRAR 2-CORRER", "ATIRAR CORRER");
                                    if (resp.equals("ATIRAR")) {
                                            System.out.println("voce consegue eliminar o segundo guarda, mas perde uma bala");
                                            atirar();
                                    }else
                                            System.out.println("enquanto voce corre na direÃ§Ã£o dele, voce toma outro tiro e perde vida\n "
                                                            + "ao chegar perto, voce deseja: \nabate-lo com as maos(1)\n Abate-lo com um tiro(2)?");
                                            dano1();
                                            resp = Repeticao("1-ABATER 2-ATIRAR", "ABATER ATIRAR");
                                            if (resp.equals("abater")) {
                                                    System.out.println("voce conseguiu abater o primeiro inimigo");
                                            }else {
                                                    System.out.println("Voce conseguiu abater o inimigo, porem gastou uma bala");
                                                    atirar();
                                            }

                            }
                    }else {
                            System.out.println("Voce consegue chegar no guarda sem ser visto\nabate-lo furtivamente (1)\n abalte-lo usando sua arma (2)?");
                            resp = Repeticao("1-FURTIVAMENTE 2-ATIRAR", "FURTIVAMENTE ATIRAR");
                            if (resp.equals("FURTIVAMENTE")) {
                                    System.out.println("Voce consegue abater o guarda, porem o segundo guarda te ve pois estava olhando em sua direÃ§Ã£o. \n"
                                                    + "Antes que voce possa fazer algo, ele te acerta um tiro. Voce deseja: \natirar nele (1)\ncorrer em sua direÃ§Ã£o (2)?");
                                    dano1();
                                    resp = Repeticao("1-ATIRAR 2-CORRER", "ATIRAR CORRER");
                                    if (resp.equals("ATIRAR")) {
                                            System.out.println("Voce consegue abater o segundo, porem perde uma bala");
                                            atirar();
                                    }else {
                                            System.out.println("Voce corre na direÃ§Ã£o do inimigo, porem ele te acerta um tiro no caminho. Ao chegar la"
                                                            + ", voce deseja: \natirar (1)\nabate-lo com as mÃ£os(2)?");
                                            dano2();
                                            resp = Repeticao("1-ATIRAR 2-ABATER", "ATIRAR ABATER");
                                            if (resp.equals("ATIRAR")) {
                                                    System.out.println("Voce consegue abater o segundo guarda, porem gasta muniÃ§Ã£o");
                                                    atirar();
                                            }else
                                                    System.out.println("Voce consegue abater o guarda com um soco");
                                    }
                                    // caminho usando a arma
                            }else {
                                    System.out.println("Voce consegue abater o guarda, porem o segundo guarda consegue ver.\n"
                                                    + "Antes que voce possa fazer algo, ele te acerta um tiro. Voce deseja: \natirar nele (1) \ncorrer em sua direÃ§Ã£o (2)?");
                                    dano1();
                                    resp = Repeticao("1-ATIRAR 2-ABATER", "ATIRAR ABATER");
                                    if (resp.equals("ATIRAR")) {
                                            System.out.println("voce consegue eliminar o segundo guarda, mas perde uma bala");
                                            atirar();
                                    }else{
                                            System.out.println("enquanto voce corre na direÃ§Ã£o dele, voce toma outro tiro e perde vida\n "
                                                            + "ao chegar perto, voce deseja: \nabate-lo com as maos(1)\n abate-lo com um tiro(2)?");
                                            dano1();
                                            resp = Repeticao("1-ABATER 2-ATIRAR", "ATIRAR ABATER");
                                            if (resp.equals("ABATER")) {
                                                    System.out.println("voce conseguiu abater o primeiro inimigo");
                                            }else{
                System.out.println("Voce conseguiu abater o inimigo, porem gastou uma bala");
                                                    atirar();
    }	
                                    }	
            }
            }//primeiro if/else
    }
		
public static void Fase3() {
			String resp = "";
	    Status[8] = 3;
			int fim = 0;
			System.out.println("General- Conseguimos informaÃ§oes que o cientista esta preso em uma instalaÃ§Ã£o\n"
					+", sua missÃ£o sera resgatar e traze-lo com vida, ele Ã© essencial para o sucesso an guerra\n"
					+ "e sem ele nosso planeta corre serios riscos, vocÃª irÃ¡ entrar furtivamente\n"
					+ ", devera entrar e sair sem alertar, seu companheiro dara um jeito de chamar atenÃ§ao dos guardas\n"
					+ "para eles sairem e facilitar sua entrada e saida. Localizamos duas possiveis entradas, \n"
					+ "uma pelos fundos, e outra pelos esgotos abaixo da instalaÃ§Ã£o, para qual voce deseja ir?");
			resp = Repeticao("1-FUNDO 2-ESGOTO", "FUNDO ESGOTO");
			if(resp.equals("FUNDO")) {
				Fundo();
			}else {
				esgoto(1);
			}
			
		}
		

	public static void esgoto (int a) {
			int fim = 0;
			String resp = "";
			System.out.println("voce decidiu entrar pelos esgotos.");
			System.out.println("Mesmo no ambiente sujo ao qual imaginava-se nao haver inimigos, vocÃª se depara com dois guardas guardando as estradas subterraneas. \n"
						+ "existe uma caixa a direita e uma a esquerda, o guarda da esqueda olha na direÃ§Ã£o do segundo guarda \n"
						+ "o outro guarda olha para a frente, existe uma  chance de chegar pelas costas de um dos dois\n"
						+ ". Por qual caixa vocÃª deseja seguir?");
			resp = Repeticao("1-ESQUERDA 2-DIREITA", "ESQUERDA DIREITA");
			if (resp.equals("ESQUERDA")) {
				System.out.println("VocÃª se aproxima do alvo da esquerda, deseja abate-lo?");
				resp = Repeticao("1-SIM 2-NAO", "SIM NAO");
				if (resp.equals("SIM")) {
					System.out.println("vocÃª conseguiu abate-lo furtivamente, vocÃª deseja chegar perto do segundo:\n"
							+ "Aproximar-se furtivamente(1)\nAtirar nele de longe(2)");
					resp = Repeticao("1-FURTIVAMENTE 2-ATIRAR", "FURTIVAMENTE ATIRAR");
					if(resp.equals("FURTIVAMENTE")) {
						System.out.println("Voce consegue se aproximar do segundo guarda sem ser visto, deseja abate-lo");
						resp = Repeticao("1-FURTIVAMENTE 2-ATIRAR", "FURTIVAMENTE ATIRAR");
								if (resp.equals("FURTIVAMENTE")) {
									System.out.println("Voce consegue abater o alvo furitvamente");
								}else
									System.out.println("Voce consegue abater o alvo, mas perde uma bala");
									atirar();			
					}else
						System.out.println("Voce consegue eliminar o segundo guarda com sua arma, mas perde uma bala");
						atirar();
				}else {
				System.out.println("VocÃª consegue abater o primeiro guarda, porem o segundo te nota devido ao barulho de sua arma,\n"
						+ "antes que voce consiga fazer algo, ele consegue te acertar um tiro, voce deseja: \natirar nele de volta(1)\n"
						+ "correr na sua direÃ§Ã£o(2)?");
				atirar();
				dano1();
				resp = Repeticao("1-ATIRAR 2-CORRER", "ATIRAR CORRER");
				if (resp.equals("ATIRAR")) {
					System.out.println("voce consegue eliminar o segundo guarda, mas perde uma bala");
					atirar();
				}else
					System.out.println("enquanto voce corre na direÃ§Ã£o dele, voce toma outro tiro e perde vida\n "
							+ "ao chegar perto, voce deseja: \nabate-lo com as maos(1)\n Abate-lo com um tiro(2)?");
					dano1();
					resp = Repeticao("1-ABATER 2-ATIRAR", "ABATER ATIRAR");
					if (resp.equals("abater")) {
						System.out.println("voce conseguiu abater o primeiro inimigo");
					}else {
						System.out.println("Voce conseguiu abater o inimigo, porem gastou uma bala");
						atirar();
					}
				
			}
		}else {
			System.out.println("Voce consegue chegar no guarda sem ser visto\nabate-lo furtivamente (1)\n abalte-lo usando sua arma (2)?");
			resp = Repeticao("1-FURTIVAMENTE 2-ATIRAR", "FURTIVAMENTE ATIRAR");
			if (resp.equals("FURTIVAMENTE")) {
				System.out.println("Voce consegue abater o guarda, porem o segundo guarda te ve pois estava olhando em sua direÃ§Ã£o. \n"
						+ "Antes que voce possa fazer algo, ele te acerta um tiro. Voce deseja: \natirar nele (1)\ncorrer em sua direÃ§Ã£o (2)?");
				dano1();
				resp = Repeticao("1-ATIRAR 2-CORRER", "ATIRAR CORRER");
				if (resp.equals("ATIRAR")) {
					System.out.println("Voce consegue abater o segundo, porem perde uma bala");
					atirar();
				}else {
					System.out.println("Voce corre na direÃ§Ã£o do inimigo, porem ele te acerta um tiro no caminho. Ao chegar la"
							+ ", voce deseja: \natirar (1)\nabate-lo com as mÃ£os(2)?");
					dano2();
					resp = Repeticao("1-ATIRAR 2-ABATER", "ATIRAR ABATER");
					if (resp.equals("ATIRAR")) {
						System.out.println("Voce consegue abater o segundo guarda, porem gasta muniÃ§Ã£o");
						atirar();
					}else
						System.out.println("Voce consegue abater o guarda com um soco");
				}
				// caminho usando a arma
			}else {
				System.out.println("Voce consegue abater o guarda, porem o segundo guarda consegue ver.\n"
						+ "Antes que voce possa fazer algo, ele te acerta um tiro. Voce deseja: \natirar nele (1) \ncorrer em sua direÃ§Ã£o (2)?");
				dano1();
				resp = Repeticao("1-ATIRAR 2-ABATER", "ATIRAR ABATER");
				if (resp.equals("ATIRAR")) {
					System.out.println("voce consegue eliminar o segundo guarda, mas perde uma bala");
					atirar();
				}else{
					System.out.println("enquanto voce corre na direÃ§Ã£o dele, voce toma outro tiro e perde vida\n "
							+ "ao chegar perto, voce deseja: \nabate-lo com as maos(1)\n abate-lo com um tiro(2)?");
					dano1();
					resp = Repeticao("1-ABATER 2-ATIRAR", "ATIRAR ABATER");
					if (resp.equals("ABATER")) {
						System.out.println("voce conseguiu abater o primeiro inimigo");
					}else{
            System.out.println("Voce conseguiu abater o inimigo, porem gastou uma bala");
						atirar();
					}	
				}	
			}
		}//primeiro if/else
	      entrou(1);
	}
	
	public static void entrou(int a) {
			int refil1 = 1;
			int chave1 = 0;
			int secreta = 0;
			int avancou = 0;
			int t = 0;
			String resp = "";
			int fim = 0;
			while(avancou != 1) {
				System.out.println("VocÃª esta em uma sala com tres portas. para qual vocÃª deseja ir?\nPorta leste(1)\nPorta Oeste(2)\nPorta Norte(3)");
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
						System.out.println("VocÃª entrou na porta Leste, Dentro da sala vocÃª acha uma chave, deseja pega-la?\nSim(1)\nNÃ£o(2)");
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
							System.out.println("VocÃª pegou a chave");
							chave1 = 1;
						}else
							System.out.println("vocÃª nao pegou a chave");
					}else {
						System.out.println("VocÃª entrou na porta Leste, mas nÃ£o encontra nada dentro da sala");
					}
					System.out.println("ApÃ³s verificar a sala, vocÃª volta para a sala inicial");
					break;
				case 2:
					if (refil1 == 1) {
					System.out.println("VocÃª entrou na sala Oeste, dentro da sala vocÃª encontra um refil para recarregar\n"
							+ "as balas da sua arma, deseja pegar?\nSim(1)\nNÃ£o(2)");
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
						System.out.println("VocÃª pegou o refil e recarregou sua arma");
						recarregar();
						refil1 = 0;
					}else
						System.out.println("vocÃª nao pegou o refil");
					}else
						System.out.println("VocÃª entrou na porta Oeste, mas nÃ£o encontra nada dentro da sala");
					break;
				case 3:
					if (chave1 == 0) {
						System.out.println("A porta estÃ¡ trancada, vocÃª precisa de uma chave, VocÃª volta para a sala principal");
					}else {
						System.out.println("VocÃª pode passar pela porta, porÃªm nao tera mais volta, \n"
								+ "voce deseja continuar mesmo assim?\nSim(1)\nNÃ¢o(2).");
						t = scan.nextInt();
						if (t == 1) {
							avancou = 1;
							System.out.println("VocÃª passou pela porta!");
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
			}else if(caminho == 7) {
					caminho = caminho7(caminho);
				}if(caminho == 8) {
					caminho = caminho8(caminho);
				}
		}
	}
	
	public static int caminho1(int a) {
			int t = 0;
			int fim = 0;
			String resp = "";
			System.out.println("VocÃª se encontra em um corredor, com uma porta ao norte e a continuaÃ§Ã£o do corredor a leste, para onde deseja ir?"
					+ "\nPorta ao norte(1)\nContinuar no corredor(2)");
			resp = Repeticao("1-NORTE 2-CONTINUAR", "NORTE CORREDOR");
			int caminho = 0;
			if (resp.equals("NORTE")) {
				caminho = 2;
				return caminho;
			}else
				caminho = 3;
				return caminho;
			
		}
		public static int caminho2(int a) {
			int t = 0;
			int fim = 0;
			int caminho = 0;
			String resp = "";
				if (Status[3] == 0){
					System.out.println("Na sala vocÃª avista um painel, porem precisa de uma chave para liberar, vocÃª volta ao corredor\n");
					caminho = 1;
					return caminho;
				}else
					System.out.println("Apos desbloquear o painel com a chave, vocÃª pode verefica-lo:\nVerificar computador(1)\nVoltar para o corredor(2)");
				resp = Repeticao("1-VERIFICAR 2-VOLTAR", "VERIFICAR VOLTAR");
						if (resp.equals("VERIFICAR")) {
							System.out.println("O painel apresenta uma senha, voce pode:\nHackear computador(1)\nDesistir(2)");
							resp = Repeticao("1-HACK 2-DESISTIR", "HACK DESISTIR");
								if (resp.equals("HACK")) {
									System.out.println("Para hackear o painel vocÃª precisa resolver um puzzle.\n"
											+ "Responda: raiz quadrada de 9");
								t = scan.nextInt();
									while (t != 3) {
										if (t != 3)
											System.out.println("resposta incorreta, tente novamente");
											t = scan.nextInt();
									}
									System.out.println("Ao conseguir, vocÃª escuta uma porta abrindo na sala atras de vocÃª\n"
											+ "VocÃª deseja entrar na porta ou retornar para o corredor?\nEntrar na porta(1)\nVoltar ao corredor(2)");
									resp = Repeticao("1-ENTRAR 2-VOLTAR", "ENTRAR VOLTAR");
										if (resp.equals("ENTRAR")) {
											System.out.println("vocÃª entrou na porta!");
											caminho = 7;
											return caminho;
										}else
											caminho = 1;
											return caminho;
									
						}else
							System.out.println("VocÃª voltou para o corredor");
							caminho = 1;
							return caminho;
				
			}else
				caminho = 1;
				return caminho;
			}
		
		public static int caminho3(int a) {
			int caminho = 0;
			int fim = 0;
			String resp = "";
			System.out.println("Ao chegar no final do corredor, voce encontra uma porta a leste\nEntrar na porta ao leste(1)\nVoltar a oeste para o comeÃ§o do corredor(2) ");
			while(fim == 0) {
				resp = Repeticao("1-ENTRAR 2-VOLTAR", "ENTRAR VOLTAR");
				if (resp.equals("ENTRAR")) {
					System.out.println("VocÃª passa pela porta");
					caminho = 4;
				}else
					System.out.println("VocÃª volta para o comeÃ§o do corredor");
					caminho = 1;		
			}
			return caminho;
		}
		
		public static int caminho4(int a) {
			int caminho = 0;
			int t2 = 1;
			String resp = "";
			while(t2 != 0) {
				System.out.println("norte(1)\nleste(2)\noeste(3)\nsul(4)");
				resp = Repeticao("1-NORTE 2-LESTE 3-OESTE 4-SUL", "NORTE LESTE OESTE SUL");
				if(resp.equals("NORTE")) {
					System.out.println("a sala esta vazia, voce volta para a sala principal");
				}else if(resp.equals("LESTE")) {
					System.out.println("VocÃª encontra uma poÃ§Ã£o de cura, voce deseja tomar?\nSim(1)\nNÃ£o(2)");
					resp = Repeticao("1-SIM 2-NAO", "SIM NAO");
					if (resp.equals("SIM")) {
                                            System.out.println("Sua vida foi regenerada, vocÃª volta para a sala anterior");
                                            PoteVida();
					}else
                                            System.out.println("VocÃª volta para a sala anterior");
				}else if(resp.equals("OESTE")) {
					System.out.println("VocÃª passa para a proxima sala");
					caminho = 5;
					
				}else if(resp.equals("SUL")){
					System.out.println("Voce volta para o corredor");
					caminho = 3;
                                }
			
		}
                        return caminho;
	}
		public static int caminho5(int a) {
			int caminho = 0;
			int t2 = 2;
			int c = 1;
			int fim = 0;
			String resp = "";
			while (t2 != 1) {
                            System.out.println("VocÃª se encontra em uma sala com trÃªs portas, norte, sul e leste,e uma a Oeste para voltar de onde veio.\nPara qual vocÃª deseja ir?\n"
                                            + "Leste(1)\nSul(2)\nOeste(3)");
                            resp = Repeticao("1-LESTE 2-SUL 3-OESTE", " LESTE OESTE SUL");
                            if (resp.equals("LESTE")) {
                                System.out.println("voce volta para a sala anterior");
                                caminho = 4;
                                return caminho;
                            }else if (resp.equals("SUL")) {
                                if (c == 1) {
                                    System.out.println("VocÃª encontra uma poção de mana, voce deseja pegar?\nSim(1)\nNÃ£o(2)");
                                    while(fim == 0) {
                                        resp = Repeticao("1-SIM 2-NAO", "SIM NAO");
                                        if (resp.equals("SIM")) {
                                            System.out.println("Pegou a poção, vocÃª volta para a sala anterior");
                                            PoteMana();
                                            c = 0;
                                        }else
                                            System.out.println("VocÃª volta para a sala anterior");
                                    }
                                    return caminho;
                                }else if(resp.equals("OESTE")){
                                    System.out.println("VocÃª avanÃ§a para a proxima sala!");
                                    caminho = 6;
                                    return caminho;
                            }else {
                                System.out.println("codigo errado");
                                
                            }			
		}
			
		}
                        return caminho;
	}
		public static int caminho6(int a) {
			int t = 0;
			int fim = 0;
			String resp = "";
			System.out.println("avanÃ§ar(1)\nRecuar(2)");
			resp = Repeticao("1-AVANCAR 2-RECUAR", "AVANCAR RECUAR");
			int caminho = 0;
			if (resp.equals("AVANCAR")) {
				caminho = 8;
			}else {
				caminho = 5;}
			return caminho;
				
		}

	//fim caminho 6
public static int caminho7(int a) {
				System.out.println("Voce se depara com alguns guardas fazendo a segurança da chave para a cela do cientista, você deve lutar para conseguir\n"
						+ "a chave e liberta-lo");
				Wave2();
				System.out.println("Você conseguiu a chave");
				Status[3] = 1;
				return 6;
						
			}
			public static int caminho8(int a) {
				System.out.println("Voce entrou na sala e se deparou com o cientista, você precisa resolver um puzzle para liberta-lo");
				System.out.println("Responda a charada corretamente: ");
				String resp = Repeticao("Sempre quando chego trago a tristeza\r\n"
						+ "Mas sempre chego na hora certa\r\n"
						+ "As vezes venho depois de uma doença\r\n"
						+ "E outras, depois de um ato de violência", "TEMPO");
				if(resp.equals("TEMPO")) {
					System.out.println("PARABENS SOLDADO, você conseguiu cumprir sua missao, volte para a base para voltarmos ao nosso planeta.");
				}
				return 6;
						
			}

  
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
  Wave2();

  System.out.println("-Perfeita luta soldado!");

  String resp = Repeticao("-Vamos avançar para NORTE, ele está trancado em umas das próximas salas","NORTE");
}

public static void Fase3Caminho3(){
  Repeticao("-Está sala tem muita munição, pegue quanto for necessário","PEGAR");
  Status[1] += 30;
  System.out.println("Você pegou cerca de 30 balas.");

  String resp = Repeticao("-Vamos avançar para NORTE e ver o que pode ter lá","NORTE");

  Fase3Caminho4();
}

public static void Fase3Caminho4(){
  String resp = Repeticao("Aqui a somente uma chave, digite PEGAR para adquirir a chave","PEGAR");

  if(Status[3] <= 0){
    System.out.println("-Pegou a chave");
    Status[3] = 1;
  }

  resp = Repeticao("Não temos mais nada por aqui, vamos voltar pra SUL","SUL");

  Fase3Caminho1();
  
}

public static void Fase3Caminho5(){
  System.out.println("Bom, parece que estamos chegando no fim da linha. /n Queria dizer que independente do resultado da próxima batalha, /n fui um prazer lutar essa guerra com você!");

  String lcResp = Repeticao("Está preparado?","SIM,NÃO");

  if (Status[3] <= 0){
    lcResp = "NÃO";

    System.out.println("Você não achou a chave desta sala, vasculhe outras salas antes de proceguir");
  }
  if (lcResp == "SIM"){
    Status[3] = Status[3] - 1;
    System.out.println("-Sua chave foi gasta!");

    System.out.println("Parece que vem alguns inimigos por aí!, vamos ter que lutar!");
    Wave2();

    System.out.println("Mandou bem, acho que não preciso mais te chamar de soldado, /n quando voltarmos talvez seja coronel ou mais agora!(Risos)");
    Fase3Chefe();
  }else{
    Fase3Caminho1();
  }
}

public static void Fase3Final(){
  
}
  public static void Fase3guardacostas (){
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
    
  
    do {
      System.out.println("Você foi encontrado pelos inimigos e raptado. Voltará para o início da missão ");
      }while ( t == 2);
    
  if (t == 1 ){   System.out.println("Você encontrou uma entrada de ar na parte superior da nave, para chegar até lá será necessário encontrar algo para escalar/n "
      + "Você encontrou uma lixeira, pode empura-la e subir para conseguir acessar a saída de ar/n");
                                     
      }
     System.out.println("Você encontrou uma lixeira, pode empura-la e subir para conseguir acessar a saída de ar/n "
 
    + " Empurrar lixeira (1)/n Buscar outra alternativa(2 ) "); 
    t = scan.nextInt(); 

    
    do{
      System.out.println(" Personagem - Caramba olhei por todos os lados e acredito que não exista outra alternativa");
       
    }while (t == 2);
      
      if (t == 1); {
      System.out.println("Você conseguiu acessar a saída de ar");
      }
    System.out.println(" Os dutos de ar vão por duas direções, você deseja seguir pela Direita(1) ou Esquerda(2)");
    t = scan.nextInt(); 
     
    do {
      System.out.println("A saida desse lado está fechada, é possivel abri-la com ferramentas mas você não tem nenhuma, pode buscar outras alternativas"); 
    }while ( t == 2);
      if (t == 1 ){
      System.out.println("Saída encontrada, você está em uma sala desconhecida. pode voltar para o duto de ar (2) ou buscar por recursos(1)");
      t = scan.nextInt(); 
      
      do {
        System.out.println("Você voltou para o duto de ar mas precisa de recursos para conseguir abrir a outra saída, procure opções na sala anterior."); 
      }while (t == 2 ); 
        if (t == 1 ){
        System.out.println("Você encontrou a chave da para a saída trancada. Pode buscar mais recursos na sala (1) ou ir para a sala de controle para plantar a bomba(2)"); }
        t = scan.nextInt(); 
       
          do {
            System.out.println("Não existem mais itens disponiveis nessa sala. ");
          } while (t == 1);
            if (t == 2 ){
            System.out.println("Você está na sala de controle da nave inimiga. Aguarde o posicionamento dos aliados para plantar a bomba e fugir da nave"); 
            }
         System.out.println("Radio: Personagem 2 - Personagem 1, encontramos o cientista e estamos saindo da nave, estamos com o Personagem 3 que acabou de matar o chefe final. Plante a bomba e nos encontre no console de naves, vamos escapar com uma sub-nave."
          + "Digite (1) para plantar a bomba " ); 
             t = scan.nextInt();
      
           if ( t == 1 ){
              System.out.println("A bomba foi plantada, vá para o ponto de encontro o mais rápido possivel para evadir da nave inimiga. ");
             
      }


    
      }
  }
    public static void Inicio() {
						String resp = "";
						int fim = 0;
						System.out.println("No ano de 2040, Em razao da evoluÃ§Ã£o da medicina as pessoas pararam de morrer por envelhecimento,\n "
								+ " o que resultou em uma drastica diminuiÃ§Ã£o de novas crianÃ§as nascendo biologicamente, ate o ano de 2070,\n"
								+ "	que a biologia humana evoluiu, e as pessoas nÃ£o tinham mais a capacidade de ter filhos biologicamente.\n"
								+ "	Um medico descobriu uma forma de criar bebes em laboratorio, essas novas crianÃ§as ja nasciam destinadas \n"
								+ " a cumprir um papel prÃ© designado para a sociedade\n");
						System.out.println(" Em 2407, tivemos nosso primeiro contato com uma raÃ§a inteligente vinda de outro planeta, logo foram\n "
								+ "compartilhados conhecimentos e formas como sociedade a sociedade funciona. Em uma vinda repentina, seres desse \n"
								+ " planeta vieram nos visitar, dizendo ser para estudos. Ao  ver a quantidade de recursos disponiveis na terra, logo \n"
								+ " iniciaram uma tentativa de tomada do planeta.\r \n"
								+ "Apos 30 anos de uma guerra extremamente destrutiva, a humanidade estava em desvantagem, e a derrota estava iminente,\n"
								+ "porÃªm, o mesmo medico que inventou a crianÃ§ao de crianÃ§as por meio de laboratorio, fez uma descoberta que pode mudar\n"
								+ " o rumo da guerra. Ele descobriu uma forma de dar poderes a essas crianÃ§as que eram criadas, logo a primeira leva de super\n"
								+ "soldados foram criados e treinados para o combate.\n"
								+ "Ã‰ ai que vocÃª nasceu, na primeira leva de super soldados\n");
						System.out.println("\n Qual o seu nome?");
						Nome = scan.nextLine();
						
						String poder = "";
						System.out.println("Muito bem "+ Nome +", agora escolha a sua classe digitando o numero referente a cada uma delas:");
						System.out.println("Classe 1 = Voador - Voe para passar por obstaculos e para te auxiliar na batalha\n"
								+ "Classe 2 = Super forÃ§a - Com a super forÃ§a, vocÃª pode se livrar de obstaculos e usar na batalha\n"
								+ "Classe 3 = Poder Psiquico - Possuia a capacidade de puxar objetos com o poder da mente, tambÃ©m pode ser usado contra adversarios\n");
						
						while(fim == 0) {
							System.out.println("1-VOADOR\n2-FORÃ‡A\n-3PSI");
							resp = scan.nextLine().toUpperCase();
							if(resp.equals("VOADOR")) {
								resp = "VOADOR";
			          Status[9] = 1;
								fim = 1;	
							}else if(resp.equals("FORÃ‡A")) {
								resp = "FORÃ‡A";
			          Status[9] = 2;
								fim = 1;
							}else if(resp.equals("PSI")) {
								resp = "PSI";
			          Status[9] = 3;
								fim = 1;
							}
						}fim = 0;
						
							System.out.println("classe escolhida: "+ resp);
			    		
			  }//missão dois, começo.

	public static void Missao2() {
				int sala = 1;
				System.out.println("GENERAL-Equanto estamos nos encaminhando para o planeta, nossa nave acaba sendo interceptada\n"
						+ "pelos inimigos. Eles ja conseguiram entrar, nos juntamos a equipe para decidir qual serÃ¡\n"
						+ "o plano para seguirmos a missao. Eles estÃ£o em maior numero, entao devemos seguir atÃ©\n"
						+ "a nave reserva para seguirmos viagem. Para isso devemos alem de chegar atÃ© la, implantar uma\n"
						+ "bomba no gerador principal, para abater os inimigos e ser possivel seguir viagem com a outra nave.Fale com Aya para ela\n"
						+ "te indicar quais materiais vocÃª deve encontrar.");
				System.out.println("Aya- Os materiais que vocÃª deve encontrar sÃ£o o EXPLOSIVO e o DETONADOR, vocÃª tambem deve encontrar um mapa da nave para\n"
						+ "facilitar nosso caminho.Siga para a sala da frente e procure pela area, apÃ³s achar os materiais siga para a porta ao norte e\n"
						+ " iniciaremos a missÃ£o");
				while (sala != 4) {
					if(sala == 1) {
						sala = sala1(sala);
					}else if(sala == 2) {
						sala = sala2(sala);
					}else if(sala == 3) {
						sala = sala3(sala);
					}
				}	
					System.out.println("GENERAL- VocÃª conseguiu achar os materiais para a construÃ§Ã£o da bomba, porem ainda devemos intalar ela e chegar a nave\n"
							+ "te dou a liberdade de escolher qual serÃ¡ a sua missÃ£o, achar a nave ou explodir a nave\n"
							+ "1-NAVE\n2-EXPLODIR");
					String missao = scan.nextLine();
					if (missao.equals("nave")) {
						System.out.println("GENERAL- VocÃª decidiu procurar pela nave, boa sorte em sua busca por ela, \n"
								+ "cuidado com possiveis obstaculos pelo caminho");
						int s = 1;
						labirinto(1);
					}else {
						System.out.println("GENERAL- VocÃª decidiu usar o explosivo, boa sorte, \n"
								+ "cuidado com possiveis obstaculos pelo caminho");
			      ExplodirNave();
					}
				}
				public static int sala1(int a) {
					int sala = 0;
					System.out.println("VocÃª estÃ¡ em uma sala, existem tres portas, uma ao norte, vocÃª so deve avanÃ§ar por essa apÃ³s achar os materiais,\n"
							+ " uma a leste e uma a oeste, para qual voce deve seguir?");
					String caminho = Repeticao("1-NORTE\n2-LESTE\n3-OESTE", ("NORTE LESTE OESTE"));
					if(caminho.equals("NORTE")) {
						if((itens[0] == 1)&&(itens[1] == 1)) {
							System.out.println("VocÃª conseguiu os materiais e avanÃ§a");
							sala = 4;
							return sala;
						}else {
							System.out.println("VocÃª nÃ£o encontrou os itens da missÃ£o, continue procurando");
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
						System.out.println("VocÃª estÃ¡ na sala OESTE, nessa sala existem 4 portas, para qual deseja seguir?");
						caminho = Repeticao("1-NORTE\n2-OESTE\n3-SUL\n4LESTE(voltar a sala anterior)", "NORTE OESTE SUL LESTE");
						if(caminho.equals("NORTE")) {
							System.out.println("VocÃª entrou para a porta norte, porem a sala esta vazia, vocÃª volta para a sala anterior");
						
						
						}else if(caminho.equals("SUL")) {
							if(itens[0] == 0) {
								System.out.println("VocÃª entrou na porta sul, dentro dela se encontra o EXPLOSIVO, vocÃª deseja pega-lo?\n1- SIM\n2- NÃƒO");
								caminho = Repeticao("1-SIM 2-NAO", "SIM NAO");
								if(caminho.equals("SIM")) {
									System.out.println("VocÃª pegou o explosivo. VocÃª volta para a sala anterior");
									itens[0] = 1;
								}else
								System.out.println("NÃ£o pegou, vocÃª volta para a sala anterior");
							}else {
								System.out.println("A sala estÃ¡ vazia, vocÃª volta para a sala anterior");
							}
						
						}else if(caminho.equals("OESTE")){
							if(map == 0) {	
								System.out.println("VocÃª entra na sala, dentro dela voce encontra um mapa da nave, deseja pela-lo?\n1- SIM\n2- NÃƒO");
								caminho = Repeticao("1-SIM 2-NAO", "SIM NAO");
								if(caminho.equals("SIM")) {
									System.out.println("VocÃª pegou o mapa. VocÃª volta para a sala anterior");
									int mapa1 = 1;
								}else
									System.out.println("NÃ£o pegou, vocÃª volta para a sala anterior");
							}else
								System.out.println("A sala estÃ¡ vazia, vocÃª volta para a sala anterior");
						
						}else if(caminho.equals("LESTE")){
							System.out.println("VocÃª voltou para a sala principal a LESTE");
							fim = 1;
						
						}
					
				}
				return sala;
			}
				public static int sala3(int a) {
					int fim = 0;
					int sala = 1;
					int detonador = 0;
					String caminho = "";
					while(fim != 1) {	
						System.out.println("VocÃª estÃ¡ na sala LESTE, nessa sala existem 3 portas, para qual deseja seguir?\n1-NORTE\n2-OESTE(Voltar a sala principal)\n3-SUL)");
						caminho = Repeticao("1-NORTE 2-OESTE 3-SUL", "SUL NORTE OESTE");
						if(caminho.equals("NORTE")) {
							System.out.println("VocÃª entrou para a porta norte, porem a sala esta vazia, vocÃª volta para a sala anterior");
							
						}else if(caminho.equals("SUL")) {
							if(detonador == 0) {
								System.out.println("VocÃª entrou na porta sul, dentro dela se encontra o DETONADOR, vocÃª deseja pega-lo?\n1- SIM\n2- NÃƒO");
								String item = Repeticao("1-SIM 2-NAO", "SIM NAO");
								if(item.equals("SIM")) {
									System.out.println("VocÃª pegou o detonador. VocÃª volta para a sala anterior");
									itens[1] = 1;
								}else
									System.out.println("NÃ£o pegou, vocÃª volta para a sala anterior");
							}else
								System.out.println("A sala estÃ¡ vazia, vocÃª volta para a sala anterior");
						
						}else if(caminho.equals("OESTE")){
							System.out.println("VocÃª voltou para a sala principal a OESTE");
							fim = 1;
						}
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
			System.out.println("VocÃª estÃ¡ em uma sala, existem duas portas, uma a leste e uma a oeste, para qual voce deve seguir?n1- LESTE\n 2- OESTE");
			resp = Repeticao("1-LESTE\n-2OESTE","LESTE OESTE");
			if(resp.equals("OESTE")) {
				System.out.println("VocÃª entrou na sala OESTE");
				s = 2;
			}else if(resp.equals("OESTE")){
				System.out.println("VocÃª entrou na sala LESTE");
				s = 4;
			}
			return s;
		}
		public static int s2(int a) {
			int s = 2;
			int fim = 0;
			String resp = "";
			System.out.println("VocÃª estÃ¡ em uma sala, existem duas portas, uma a leste para voltar a sala principal e uma a sul, para qual voce deve seguir?n1- LESTE\n 2- SUL");
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
			System.out.println("VocÃª estÃ¡ em uma sala sem saida, vocÃª volta para a sala anterior");
			
			return s;
		}
		public static int s4(int a) {
			int s = 2;
			int fim = 0;
			String resp = "";
			System.out.println("VocÃª estÃ¡ em uma sala, existem duas portas, uma a leste e uma a oeste, \n"
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
			System.out.println("VocÃª estÃ¡ em uma sala, existem duas portas, uma a sul e uma a norte, \n"
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
			System.out.println("VocÃª estÃ¡ em uma sala sem saida, vocÃª volta para a sala anterior");
			
			return s;
		}
		public static int s6(int a) {
			int s = 5;
			int fim = 0;
			System.out.println("VocÃª estÃ¡ em uma sala sem saida, vocÃª volta para a sala anterior");
			
			return s;
		}

		public static int s8(int a) {
			int s = 2;
			int fim = 0;
			String resp = "";
			System.out.println("VocÃª estÃ¡ em uma sala, existem duas portas, uma a sul e uma a leste, \n"
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
			System.out.println("VocÃª estÃ¡ em uma sala sem saida, vocÃª volta para a sala anterior");
			
			return s;
		}
		public static int s10(int a) {
			int s = 11;
			int fim = 0;
			System.out.println("VocÃª encontrou a nave, porem existem inimigos guardando elas e vocÃª deve elimina-los.");
				Wave2();
			System.out.println("Parabens soldado,conseguimos chegar na nave em segurança");
			
			return s;
                }                   
      public static void Wave2(){
        System.out.println("Começamos uma luta");

        int vida = 50;
        do{
          System.out.println("O que deseja fazer?");
          String resp = Repeticao(" 1-MIRAR \n 2-ATIRAR \n 3-USAR POTE \n 4-ATIVAR PROTEÇÃO","MIRAR , ATIRAR , USAR POTE , ATIVAR PROTEÇÃO");

          if(resp.contains("MIRAR")){
            vida = vida - 10;
          }else if(resp.contains("ATIRAR")){
            if(Sorteio()){
              vida = vida - 10;
            }else{
              vida = vida - 5;
            } 
          }else if(resp.contains("USAR") || resp.contains("POTE")){
            PoteVida();
          }else if(resp.contains("ATIRAR") || resp.contains("PROTEÇÃO")){
            Status[8]++;
          }

          int randon = (int)(Math.random() * 4);

          if(randon == 0){
            dano1();
          }else if(randon == 1){
            vida = vida + 5;
          }else if(randon == 2){
            
          }
          
          
        }while(vida > 0 || Status[0] > 0);
        }
      
   public static void ExplodirNave() {
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
		Wave2();
		System.out.println("Você passou pelos inimigos, porem na sala seguinte existe um guarda, assegurando a posição onde você deve instalar a bomba, \n"
				+ "ele aparenta ser mais forte que os outros");
		Wave2();
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
