package com.mycompany.project;

import java.util.Scanner;

public class PROJECT {
    public static int[] Status = new int[10];
    public static String Nome;
    public static int[] Nivel = new int[2];
    public static int[] itens = new int[2];
  
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
      Finalizar();
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
 
 public static void Inicio() {
	String resp = "";
	System.out.println("No ano de 2040, Em razao da evolucao da medicina as pessoas pararam de morrer por envelhecimento,\n "
				+ "o que resultou em uma drastica diminuicao de novas criancas nascendo biologicamente, ate o ano de 2070,\n"
				+ "que a biologia humana evoluiu, e as pessoas nao tinham mais a capacidade de ter filhos biologicamente.\n"
				+ "Um medico descobriu uma forma de criar bebes em laboratorio, essas novas criancas ja nasciam destinadas \n"
				+ "a cumprir um papel pre designado para a sociedade\n");
	System.out.println("Em 2407, tivemos nosso primeiro contato com uma raca inteligente vinda de outro planeta, logo foram\n "
				+ "compartilhados conhecimentos e formas como sociedade a sociedade funciona. Em uma vinda repentina, seres desse \n"
				+ "planeta vieram nos visitar, dizendo ser para estudos. Ao  ver a quantidade de recursos disponiveis na terra, logo \n"
				+ "iniciaram uma tentativa de tomada do planeta.\r \n"
				+ "Apos 30 anos de uma guerra extremamente destrutiva, a humanidade estava em desvantagem, e a derrota estava iminente,\n"
				+ "porem, o mesmo medico que inventou a criacao de criancas por meio de laboratorio, fez uma descoberta que pode mudar\n"
				+ "o rumo da guerra. Ele descobriu uma forma de dar poderes a essas criancas que eram criadas,\n"
				+ "soldados foram criados e treinados para o combate.\n"
				+ "ai que voce nasceu, na primeira leva de super soldados\n");
	System.out.println("\n Qual o seu nome?");
	Nome = scan.nextLine();
	System.out.println("Muito bem "+ Nome +", agora escolha a sua classe digitando o numero referente a cada uma delas:");
	System.out.println("Classe 1 = Voador - Voe para passar por obstaculos e para te auxiliar na batalha\n"
				+ "Classe 2 = Super forca - Com a super forca, voce pode se livrar de obstaculos e usar na batalha\n"
				+ "Classe 3 = Poder Psiquico - Possuia a capacidade de puxar objetos com o poder da mente, tambem pode ser usado contra adversarios\n");
		resp = Repeticao("1-VOADOR 2-FORCA 3-PSI", "VOADOR FORCA PSI");
		if(resp.equals("VOADOR")) {
			resp = "VOADOR";
			Status[9] = 1;	
		}else if(resp.equals("FORCA")) {
			resp = "FORCA";
			Status[9] = 2;
		}else if(resp.equals("PSI")) {
			resp = "PSI";
			Status[9] = 3;
		}
			System.out.println("classe escolhida: "+ resp);
		
 }
 public static void PrimeiraFase(){
     Status[8] = 1;
     String lcTutorial = Repeticao("Deseja jogar o tutorial?","SIM,NAO");
     
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
   } else  
   System.out.println("Bem, finalizamos o treinamento.\n"
           + "Boa sorte na sua próxima missão soldado!");
   }
 public static void Missao2() {
		int sala = 1;
		System.out.println("GENERAL-Equanto estamos nos encaminhando para o planeta, nossa nave acaba sendo interceptada\n"
				+ "pelos inimigos. Eles ja conseguiram entrar, nos juntamos a equipe para decidir qual sera\n"
				+ "o plano para seguirmos a missao. Eles estao em maior numero, entao devemos seguir ate\n"
				+ "a nave reserva para seguirmos viagem. Para isso devemos alem de chegar ate la, implantar uma\n"
				+ "bomba no gerador principal, para abater os inimigos e ser possivel seguir viagem com a outra nave.Fale com Aya para ela\n"
				+ "te indicar quais materiais voce deve encontrar.");
		System.out.println("Aya- Os materiais que voce deve encontrar sao o EXPLOSIVO e o DETONADOR, voce tambem deve encontrar um mapa da nave para\n"
				+ "facilitar nosso caminho.Siga para a sala da frente e procure pela area, apos achar os materiais siga para a porta ao norte e\n"
				+ " iniciaremos a missao");
		while (sala != 4) {
			if(sala == 1) {
				sala = sala1(sala);
			}else if(sala == 2) {
				sala = sala2(sala);
			}else if(sala == 3) {
				sala = sala3(sala);
			}
		}	
			System.out.println("GENERAL- Voce conseguiu achar os materiais para a construcao da bomba, porem ainda devemos intalar ela e chegar a nave\n"
					+ "te dou a liberdade de escolher qual sera a sua missao, achar a nave ou explodir a nave");
			String missao = Repeticao("1-NAVE 2-EXPLODIR", "NAVE EXPLODIR");
			if (missao.equals("NAVE")) {
				System.out.println("GENERAL- Voce decidiu procurar pela nave, boa sorte em sua busca por ela, \n"
						+ "cuidado com possiveis obstaculos pelo caminho");
				labirinto();
			}else {
				System.out.println("GENERAL- Voce decidiu usar o explosivo, boa sorte, \n"
						+ "cuidado com possiveis obstaculos pelo caminho");
				ExplodirNave();
			}
		}
 public static int sala1(int a) {
		int sala = 0;
		System.out.println("Voce esta em uma sala, existem tres portas, uma ao norte, voce so deve avancar por essa apos achar os materiais,\n"
				+ "uma a leste e uma a oeste, para qual voce deve seguir?");
		String caminho = Repeticao("1-NORTE\n2-LESTE\n3-OESTE", ("NORTE LESTE OESTE"));
		if(caminho.equals("NORTE")) {
			if((itens[0] == 1)&&(itens[1] == 1)) {
				System.out.println("Voce conseguiu os materiais e avanca");
				sala = 4;
				return sala;
			}else {
				System.out.println("Voce nao encontrou os itens da missao, continue procurando");
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
			System.out.println("Voce esta na sala OESTE, nessa sala existem 4 portas, para qual deseja seguir?");
			caminho = Repeticao("1-NORTE\n2-OESTE\n3-SUL\n4LESTE(voltar a sala anterior)", "NORTE OESTE SUL LESTE");
			if(caminho.equals("NORTE")) {
				System.out.println("VocÃª entrou para a porta norte, porem a sala esta vazia, voce volta para a sala anterior");
			
			
			}else if(caminho.equals("SUL")) {
				if(itens[0] == 0) {
					System.out.println("Voce entrou na porta sul, dentro dela se encontra o EXPLOSIVO, voce deseja pega-lo?");
					caminho = Repeticao("1-SIM 2-NAO", "SIM NAO");
					if(caminho.equals("SIM")) {
						System.out.println("VocÃª pegou o explosivo. Voce volta para a sala anterior");
						itens[0] = 1;
					}else
					System.out.println("Nao pegou, voce volta para a sala anterior");
				}else {
					System.out.println("A sala esta vazia, vocÃª volta para a sala anterior");
				}
			
			}else if(caminho.equals("OESTE")){
				if(map == 0) {	
					System.out.println("Voce entra na sala, dentro dela voce encontra um mapa da nave, deseja pela-lo?");
					caminho = Repeticao("1-SIM 2-NAO", "SIM NAO");
					if(caminho.equals("SIM")) {
						System.out.println("Voce pegou o mapa. Voce volta para a sala anterior");
						int mapa1 = 1;
					}else
						System.out.println("Nao pegou, voce volta para a sala anterior");
				}else
					System.out.println("A sala esta vazia, voce volta para a sala anterior");
			
			}else if(caminho.equals("LESTE")){
				System.out.println("Voce voltou para a sala principal a LESTE");
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
			System.out.println("Voce esta na sala LESTE, nessa sala existem 3 portas, para qual deseja seguir?");
			caminho = Repeticao("1-NORTE 2-OESTE(voltar) 3-SUL", "SUL NORTE OESTE");
			if(caminho.equals("NORTE")) {
				System.out.println("Voce entrou para a porta norte, porem a sala esta vazia, voce volta para a sala anterior");
				
			}else if(caminho.equals("SUL")) {
				if(detonador == 0) {
					System.out.println("Voce entrou na porta sul, dentro dela se encontra o DETONADOR, voce deseja pega-lo?");
					String item = Repeticao("1-SIM 2-NAO", "SIM NAO");
					if(item.equals("SIM")) {
						System.out.println("Voce pegou o detonador. Voce volta para a sala anterior");
						itens[1] = 1;
					}else
						System.out.println("Nao pegou, voce volta para a sala anterior");
				}else
					System.out.println("A sala esta vazia, voce volta para a sala anterior");
			
			}else if(caminho.equals("OESTE")){
				System.out.println("Voce voltou para a sala principal a OESTE");
				fim = 1;
			}
		}
		return sala;
	}
	public static void labirinto() {
		int sala = 1;
		System.out.println("GENERAL- Lembre-se pois nao irei repetir, o caminho correto é: LESTE-OESTE-SUL");
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
			System.out.println("Voce esta em uma sala principal, existem duas portas, uma a leste e uma a oeste, para qual voce deve seguir?");
			resp = Repeticao("1-LESTE 2-OESTE","LESTE OESTE");
			if(resp.equals("OESTE")) {
				System.out.println("Voce entrou na sala OESTE");
				s = 2;
			}else if(resp.equals("LESTE")){
				System.out.println("Voce entrou na sala LESTE");
				s = 4;
			}
			return s;
		}
		public static int s2(int a) {
			int s = 2;
			int fim = 0;
			String resp = "";
			System.out.println("Voce esta na sala2, ao lado da principal, existem duas portas, uma a leste para voltar a sala principal\n"
					+ " e uma a sul, para qual voce deve seguir?");
			resp = Repeticao("1-LESTE(sala 3) 2-SUL(voltar a sala inicial)", "LESTE SUL");
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
			System.out.println("Voce esta em uma sala sem saida, voce volta para a sala anterior(sala 2)");
			
			return s;
		}
		public static int s4(int a) {
			int s = 2;
			int fim = 0;
			String resp = "";
			System.out.println("Voce esta na sala 4, existem duas portas, uma a leste(sala 5) e uma a oeste(sala 8), \n"
					+ "e uma ao norte para voltar para a sala principal. Para qual voce deve seguir?");
			resp = Repeticao("1-LESTE 2-OESTE 3-NORTE(voltar a sala inicial)", "LESTE OESTE NORTE");
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
			System.out.println("Voce esta em uma sala, existem duas portas, uma a sul e uma a norte, \n"
					+ "e uma a oeste para voltar para a sala anterior. Para qual voce deve seguir?");
			resp = Repeticao("1-SUL(sala 7) 2-NORTE(sala 6) 3-OESTE(voltar a sala 4)", "SUL OESTE NORTE");
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
			System.out.println("Voce esta em uma sala sem saida, voce volta para a sala anterior");
			
			return s;
		}
		public static int s6(int a) {
			int s = 5;
			int fim = 0;
			System.out.println("Voce esta em uma sala sem saida, voce volta para a sala anterior");
			
			return s;
		}

		public static int s8(int a) {
			int s = 2;
			int fim = 0;
			String resp = "";
			System.out.println("Voce esta em uma sala, existem duas portas, uma a sul e uma a leste, \n"
					+ "e uma a norte para voltar para a sala anterior. Para qual voce deve seguir?");
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
			System.out.println("Voce esta em uma sala sem saida, voce volta para a sala anterior");
			
			return s;
		}
		public static int s10(int a) {
			int s = 11;
			int fim = 0;
			System.out.println("Voce encontrou a nave, porem existem inimigos guardando elas e voce deve elimina-los.");
			Wave2();
			System.out.println("Parabens soldado,conseguimos chegar na nave em segurança");
			
			return s;
          }
		public static void ExplodirNave() {
			int sala = 1;
			int fim = 0;
			while (fim == 0) {
				if(sala == 1) {
					sala = c1(sala);
						if(sala == 4)
							fim = 1;
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
		System.out.println("Você está em uma sala, existem tres portas, uma a leste uma a oeste e uma a norte, para seguir para a luta, para qual voce deve seguir?");
		resp = Repeticao("1-LESTE\n2-OESTE\n3-NORTE","NORTE LESTE OESTE");
		if(resp.equals("LESTE")) {
			System.out.println("Você entrou na sala LESTE");
			s = 2;
		}else if(resp.equals("OESTE")){
			System.out.println("Você entrou na sala OESTE");
			s = 3;}
		else if(resp.equals("NORTE")){
			if(Status[9] == 1) {
				System.out.println("Você avista um portao, voce ele esta trancado e aparenta ser bem resistente\n"
						+ "mas voce pode voar por cima dele, deseja usar seu poder?");
				resp = Repeticao("1-SIM 2-NAO", "SIM NAO");
				if(resp.equals("SIM")) {
					if(Status[2] >= 1) {
						System.out.println("Você voa por cima do portao e passa por ele");
						s = 4;
					}else
						System.out.println("Você nao tem mana, procure por uma poção ou use uma");
						
				}
			}else if(Status[9] == 2) {
				System.out.println("Você avista um portao, voce ele esta trancado e aparenta ser bem resistente\n"
						+ "mas voce pode quebrar com sua força, deseja usar seu poder?");
				resp = Repeticao("1-SIM 2-NAO", "SIM NAO");
				if(resp.equals("SIM")) {
					if(Status[2] >= 1) {
						System.out.println("Você destroi o portao e passa por ele");
						s = 4;
					}else
						System.out.println("Você nao tem mana, procure por uma poção ou use uma");
						
				}
				
			}else if(Status[9] == 3) {
				System.out.println("Você avista um portao, voce ele esta trancado e aparenta ser bem resistente\n"
							+ "mas voce pode abrir ele com sua força psiquica, deseja usar seu poder?");
				resp = Repeticao("1-SIM 2-NAO", "SIM NAO");
				if(resp.equals("SIM")) {
					if(Status[2] >= 1) {
						System.out.println("Você abre o portao com sua mente e passa por ele");
						s = 4;
					}else
						System.out.println("Você nao tem mana, procure por uma poção ou use uma");
							
					}
				}
		}
	return s;
	}
		public static int c2(int a) {
			int s = 1;
			int fim = 0;
			String resp = "";
			System.out.println("Você está em uma sala, existe um pote de mana, deseja pegar?");
			
			resp = Repeticao("1-SIM 2-NAO","SIM NAO");
			if(resp.equals("SIM")) {
				System.out.println("Você pegou a poçao");
				Status[5]++;
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
		resp = Repeticao("1-SIM 2-NAO","SIM NAO");
		if(resp.equals("SIM")) {
			System.out.println("Você pegou o item");
			Status[8]++;	
		}else if(resp.equals("NAO")){
			System.out.println("Você não pegou o item");			
		}
		System.out.println("Você volta para a sala anterior");
		return s;
	}
	public static void Fase3() {
		String resp = "";
		Status[8] = 3;
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
			esgoto();
		}
		
	}
	

	public static void esgoto () {
		String resp = "";
		System.out.println("voce decidiu entrar pelos esgotos.");
		System.out.println("Mesmo no ambiente sujo ao qual imaginava-se nao haver inimigos, voce se depara com dois guardas guardando as estradas subterraneas. \n"
					+ "existe uma caixa a direita e uma a esquerda, o guarda da esqueda olha na direcao do segundo guarda \n"
					+ "o outro guarda olha para a frente, existe uma  chance de chegar pelas costas de um dos dois\n"
					+ ". Por qual caixa voce deseja seguir?");
		resp = Repeticao("1-ESQUERDA 2-DIREITA", "ESQUERDA DIREITA");
		if (resp.equals("ESQUERDA")) {
			System.out.println("Voce se aproxima do alvo da esquerda, deseja abate-lo?");
			resp = Repeticao("1-SIM 2-NAO", "SIM NAO");
			if (resp.equals("SIM")) {
				System.out.println("voce conseguiu abate-lo furtivamente, voce deseja chegar perto do segundo:\n"
						+ "Aproximar-se furtivamente ou Atirar nele de longe");
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
					+ "antes que voce consiga fazer algo, ele consegue te acertar um tiro, voce deseja atirar nele de volta ou"
					+ "correr na sua direcaoo(2)?");
			atirar();
			dano1();
			resp = Repeticao("1-ATIRAR 2-CORRER", "ATIRAR CORRER");
			if (resp.equals("ATIRAR")) {
				System.out.println("voce consegue eliminar o segundo guarda, mas perde uma bala");
				atirar();
			}else
				System.out.println("enquanto voce corre na direcaoo dele, voce toma outro tiro e perde vida\n "
						+ "ao chegar perto, voce deseja abate-lo com as maos ou Abate-lo com um tiro?");
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
			System.out.println("Voce consegue abater o guarda, porem o segundo guarda te ve pois estava olhando em sua direcao. \n"
					+ "Antes que voce possa fazer algo, ele te acerta um tiro. Voce deseja atirar nele ou correr em sua direcao?");
			dano1();
			resp = Repeticao("1-ATIRAR 2-CORRER", "ATIRAR CORRER");
			if (resp.equals("ATIRAR")) {
				System.out.println("Voce consegue abater o segundo, porem perde uma bala");
				atirar();
			}else {
				System.out.println("Voce corre na direcao do inimigo, porem ele te acerta um tiro no caminho. Ao chegar la"
						+ ", voce deseja atirar ou abate-lo com as maos?");
				dano2();
				resp = Repeticao("1-ATIRAR 2-ABATER", "ATIRAR ABATER");
				if (resp.equals("ATIRAR")) {
					System.out.println("Voce consegue abater o segundo guarda, porem gasta municao");
					atirar();
				}else
					System.out.println("Voce consegue abater o guarda com um soco");
			}
			// caminho usando a arma
		}else {
			System.out.println("Voce consegue abater o guarda, porem o segundo guarda consegue ver.\n"
					+ "Antes que voce possa fazer algo, ele te acerta um tiro. Voce deseja atirar nele ou correr em sua direcao?");
			dano1();
			resp = Repeticao("1-ATIRAR 2-ABATER", "ATIRAR ABATER");
			if (resp.equals("ATIRAR")) {
				System.out.println("voce consegue eliminar o segundo guarda, mas perde uma bala");
				atirar();
			}else{
				System.out.println("enquanto voce corre na direcao dele, voce toma outro tiro e perde vida\n "
						+ "ao chegar perto, voce deseja abate-lo com as maos ou abate-lo com um tiro?");
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
      entrou();
}

	public static void Fundo() {
	    String resp = "";
	    System.out.println("voce decidiu entrar pelos fundos.");
	
	    System.out.println("VocÃª se depara com dois guardas guardando o portao. \n"
	                            + "existe uma caixa a direita e uma a esquerda, o guarda da esqueda olha na direcaoo do segundo guarda \n"
	                            + "o outro guarda olha para a frente, existe uma  chance de chegar pelas costas de um dos dois\n"
	                            + ". Por qual caixa voce deseja seguir?");
	    resp =Repeticao("1-ESQUERDA\n2-DIREITA","ESQUERDA,DIREITA");		
	    if (resp.equals("ESQUERDA")) {
	                    System.out.println("VocÃª se aproxima do alvo da esquerda, deseja abate-lo?");
	                    resp = Repeticao("1-SIM 2-NAO", "SIM NAO");
	                    if (resp.equals("SIM")) {
	                            System.out.println("vocÃª conseguiu abate-lo furtivamente, vocÃª deseja chegar perto do segundo:\n"
	                                            + "Aproximar-se furtivamente ou Atirar nele de longe");
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
	                                    + "antes que voce consiga fazer algo, ele consegue te acertar um tiro, voce deseja atirar nele de volta ou"
	                                    + "correr na sua direcao)?");
	                    atirar();
	                    dano1();
	                    resp = Repeticao("1-ATIRAR 2-CORRER", "ATIRAR CORRER");
	                    if (resp.equals("ATIRAR")) {
	                            System.out.println("voce consegue eliminar o segundo guarda, mas perde uma bala");
	                            atirar();
	                    }else
	                            System.out.println("enquanto voce corre na direÃ§Ã£o dele, voce toma outro tiro e perde vida\n "
	                                            + "ao chegar perto, voce deseja abate-lo com as maos ou Abate-lo com um tiro?");
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
	                    System.out.println("Voce consegue abater o guarda, porem o segundo guarda te ve pois estava olhando em sua direcao. \n"
	                                    + "Antes que voce possa fazer algo, ele te acerta um tiro. Voce deseja atirar nele ou correr em sua direcao?");
	                    dano1();
	                    resp = Repeticao("1-ATIRAR 2-CORRER", "ATIRAR CORRER");
	                    if (resp.equals("ATIRAR")) {
	                            System.out.println("Voce consegue abater o segundo, porem perde uma bala");
	                            atirar();
	                    }else {
	                            System.out.println("Voce corre na direÃ§Ã£o do inimigo, porem ele te acerta um tiro no caminho. Ao chegar la"
	                                            + ", voce deseja atirar ou abate-lo com as maos?");
	                            dano2();
	                            resp = Repeticao("1-ATIRAR 2-ABATER", "ATIRAR ABATER");
	                            if (resp.equals("ATIRAR")) {
	                                    System.out.println("Voce consegue abater o segundo guarda, porem gasta municao");
	                                    atirar();
	                            }else
	                                    System.out.println("Voce consegue abater o guarda com um soco");
	                    }
	                    // caminho usando a arma
	            }else {
	                    System.out.println("Voce consegue abater o guarda, porem o segundo guarda consegue ver.\n"
	                                    + "Antes que voce possa fazer algo, ele te acerta um tiro. Voce deseja atirar nele ou correr em sua direcao?");
	                    dano1();
	                    resp = Repeticao("1-ATIRAR 2-CORRER", "ATIRAR CORRER");
	                    if (resp.equals("ATIRAR")) {
	                            System.out.println("voce consegue eliminar o segundo guarda, mas perde uma bala");
	                            atirar();
	                    }else{
	                            System.out.println("enquanto voce corre na direÃ§Ã£o dele, voce toma outro tiro e perde vida\n "
	                                            + "ao chegar perto, voce deseja abate-lo com as maos ou abate-lo com um tiro?");
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
	entrou();
	}

	public static void entrou() {
		int refil1 = 1;
		int chave1 = 0;
		int avancou = 0;
		int t = 0;
		String resp = "";
		while(avancou != 1) {
			System.out.println("VocÃª esta em uma sala com tres portas. para qual voce deseja ir?");
			resp = Repeticao("1-LESTE 2-OESTE 3-NORTE", "LESTE OESTE NORTE");
			if(resp.equals("LESTE")){
				t = 1;
			}else if(resp.equals("OESTE")) {
				t = 2;
			}else if(resp.equals("NORTE")) {
				t = 3;
			}
			switch (t) {
			case 1:
				if (chave1 == 0) {	
					System.out.println("Voce entrou na porta Leste, Dentro da sala vocÃª acha uma chave, deseja pega-la?");
					resp = Repeticao("1-SIM 2-NAO", "SIM NAO");
					if (resp.equals("SIM")) {
						System.out.println("Voce pegou a chave");
						chave1 = 1;
					}else
						System.out.println("voce nao pegou a chave");
				}else {
					System.out.println("Voce entrou na porta Leste, mas nao encontra nada dentro da sala");
				}
				System.out.println("Aposs verificar a sala, voce volta para a sala inicial");
				break;
			case 2:
				if (refil1 == 1) {
				System.out.println("Voce entrou na sala Oeste, dentro da sala voce encontra um refil para recarregar\n"
						+ "as balas da sua arma, deseja pegar o refil?");
				resp = Repeticao("1-SIM 2-NAO", "SIM NAO");
				if (resp.equals("SIM")) {
					System.out.println("Voce pegou o refil e recarregou sua arma");
					recarregar();
					refil1 = 0;
				}else
					System.out.println("voce nao pegou o refil");
				}else
					System.out.println("Voce entrou na porta Oeste, mas nao encontra nada dentro da sala");
				break;
			case 3:
				if (chave1 == 0) {
					System.out.println("A porta esta trancada, voce precisa de uma chave, Voce volta para a sala principal");
				}else {
					System.out.println("Voce pode passar pela porta, porem nao tera mais volta, \n"
							+ "voce deseja continuar mesmo assim?.");
				resp = Repeticao("1-SIM 2-NAO", "SIM NAO");
					if (resp.equals("SIM")) {
						avancou = 1;
						System.out.println("Voce passou pela porta!");
						break;
					}	
				}break;
			}
		}//while 1
		caminho1();
	}
	
	public static void caminho1() {
			String resp = "";
			System.out.println("Voce se encontra em um corredor, com uma porta ao norte e a continuaÃ§Ã£o do corredor a leste, para onde deseja ir?"
					+ "Porta ao norte ou Continuar no corredor");
			resp = Repeticao("1-NORTE 2-CONTINUAR", "NORTE CONTINUAR");

			if (resp.equals("NORTE")) {
				caminho2();
				
			}else
				caminho3();	
		}
	public static void caminho2() {
		int t = 0;
		String resp = "";
			if (Status[3] == 0){
				System.out.println("Na sala 2 voce avista um painel, porem precisa de uma chave para liberar, voce volta ao corredor\n");
				caminho1();
					
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
										caminho8();
										
									}else
										caminho1();
											
									
						}else
							System.out.println("VocÃª voltou para o corredor");
							caminho1();
							
				
			}else
				caminho1();
				
			}
		
		public static void caminho3() {
			int fim = 0;
			String resp = "";
			System.out.println("Ao chegar no final do corredor, voce encontra uma porta a leste. Entrar na porta ao leste ou Voltar a oeste para o comeco do corredor ");
			while(fim == 0) {
				resp = Repeticao("1-ENTRAR 2-VOLTAR", "ENTRAR VOLTAR");
				if (resp.equals("ENTRAR")) {
					System.out.println("Voceª passa pela porta");
					caminho4();
				}else
					System.out.println("VocÃª volta para o comeÃ§o do corredor");
					caminho1();		
			}
		}
		
		public static void caminho4() {
			int t2 = 1;
			String resp = "";
			while(t2 != 0) {
				System.out.println("Voce enta na sala 4 e avista quatro portas");
				resp = Repeticao("1-NORTE 2-LESTE 3-OESTE(avancar a sala 5) 4-SUL(voltar a sala 3)", "NORTE LESTE OESTE SUL");
				if(resp.equals("NORTE")) {
					System.out.println("a sala esta vazia, voce volta para a sala principal");
				}else if(resp.equals("LESTE")) {
					System.out.println("Voce encontra uma pocao de cura, voce deseja tomar?");
					resp = Repeticao("1-SIM 2-NAO", "SIM NAO");
					if (resp.equals("SIM")) {
                        System.out.println("Sua vida foi regenerada, voce volta para a sala anterior");
                        PoteVida();
					}else
                        System.out.println("Voce volta para a sala anterior");
				}else if(resp.equals("OESTE")) {
					System.out.println("Voce passa para a proxima sala");
					caminho5();
					
				}else if(resp.equals("SUL")){
					System.out.println("Voce volta para o corredor");
					caminho3();
                }	
		}
	}
	public static void caminho5() {
		int t2 = 2;
		int fim = 0;
		itens[0] = 1;
		String resp = "";
		while (t2 != 1) {
        System.out.println("Voce se encontra em uma sala com tres portas, norte, sul e leste,e uma a Oeste para voltar de onde veio.Para qual vocÃª deseja ir?");
        resp = Repeticao("1-LESTE(voltar a sala 4) 2-SUL 3-OESTE(avancar a sala 6)", " LESTE OESTE SUL");
        if (resp.equals("LESTE")) {
            System.out.println("voce volta para a sala anterior");
            caminho4();
        }else if (resp.equals("SUL")) {
             if (itens[0] == 1) {
                 System.out.println("VocÃª encontra uma poção de mana, voce deseja pegar?");
                 while(fim == 0) {
                 resp = Repeticao("1-SIM 2-NAO", "SIM NAO");
	                 if (resp.equals("SIM")) {
	                	 System.out.println("Pegou a pocao, voce volta para a sala anterior");
	                	 PoteMana();
	                	 itens[0] = 0;
	                	 fim = 1;
                     }else
                         System.out.println("Voce volta para a sala anterior");
	                 	fim = 1;
                     }
              }else
            	  System.out.println("Sala vazia, voce volta");
            }else if(resp.equals("OESTE")){
                    System.out.println("Voce avanca para a proxima sala!");
                    caminho6();		
			}
			
		}
	}
	public static void caminho6() {
			String resp = "";
			System.out.println("avancar a sala 7, voltar para sala 5");
			resp = Repeticao("1-AVANCAR 2-RECUAR", "AVANCAR RECUAR");
			if (resp.equals("AVANCAR")) {
				caminho7();
			}else {
				caminho5();
			}
			
				
		}
	public static void caminho7() {
			System.out.println("Voce enta na sala 7 se depara com alguns guardas fazendo a segurança da chave para a cela do cientista, você deve lutar para conseguir\n"
					+ "a chave e liberta-lo");
			Wave2();
			System.out.println("Você conseguiu a chave, volte ate a sala 2 para seguir a missao.");
			Status[3] = 1;
			caminho6();
					
		}
	public static void caminho8() {
			System.out.println("Voce entrou na sala e se deparou com o cientista, você precisa resolver um puzzle para liberta-lo");
			System.out.println("Responda a charada corretamente: ");
			String resp = Repeticao("Sempre quando chego trago a tristeza\r\n"
					+ "Mas sempre chego na hora certa\r\n"
					+ "As vezes venho depois de uma doença\r\n"
					+ "E outras, depois de um ato de violência", "TEMPO");
			if(resp.equals("TEMPO")) {
				System.out.println("PARABENS SOLDADO, você conseguiu cumprir sua missao, volte para a base para voltarmos ao nosso planeta.");
			}
			Finalizar();		
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
  public static void Finalizar() {
		System.out.println("GENERAL- Parabens soldado, nos conseguimos cumprir nossa missao. Salvamos o cientista e abatemos\n"
				+ "e abatemos os lideres, o que ira os abalar, com certeza a guerra tera outro fim, graças\n"
				+ "aos nossos super soldados. Agora voltaremos para casa.");
	}
}
