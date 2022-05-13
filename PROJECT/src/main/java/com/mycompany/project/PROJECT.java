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

  public static String Repeticao(String Texto, String Resp){
    String lcRosa = "";
    
    do{
      System.out.println(Texto);
      lcRosa = scan.next().toUpperCase();

    }while(!lcRosa.contains(Resp.toUpperCase()));

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
  public static void fundo (int a) {
		Scanner scan = new Scanner(System.in);
		int t = 1;
		int balas = 10;
		int vida = 50;
		if (t == a) {
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
		int t2 = 0;
		int vida = 40;
		int poção = 1;
		while (t2 != 1) {
			System.out.println("Você se encontra em uma sala com três portas, norte, sul e leste,e uma a Oeste para voltar de onde veio.\nPara qual você deseja ir?\n"
					+ "Norte(1)\nLeste(2)\nSul(3)\nOeste(4)");
			t = scan.nextInt();
			if (t == 1) {
				System.out.println("a sala esta vazia, voce volta para a sala anterior");
			}else if (t == 2) {
				if (poção == 1) {
				System.out.println("Você encontra uma poção de cura, voce deseja tomar?\nSim(1)\nNão(2)");
				t = scan.nextInt();
					if (t == 1) {
						System.out.println("Sua vida foi regenerada, você volta para a sala anterior");
						vida = 50;
					}else
						System.out.println("Você volta para a sala anterior");
				}else
					System.out.println("Sala vazia, você volta para a sala anteior");
			}else if(t == 3){
				System.out.println("Você passa para outra sala");
				caminho = 5;
				t2 = 1;
			}else
				System.out.println("Você volta para o corredor");
				caminho = 3;
				t2 = 1;
		}
			return caminho;
			
	}//fim caminho 4
	
	public static int caminho5(int a) {
		Scanner scan = new Scanner(System.in);
		int t = 0;
		int caminho = 0;
		int t2 = 0;
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
			}else
				System.out.println("Você avança para a proxima sala!");
				caminho = 6;
		}
			return caminho;
			
	}//fim caminho 5
	
	public static int caminho6(int a) {
		Scanner scan = new Scanner(System.in);
		System.out.println("avançar(1)\nRecuar(2)");
		int t = scan.nextInt();
		int caminho = 0;
		if (t == 1) {
			caminho = 8;
		}else
			caminho = 5;
		return caminho;
			
	}
}
