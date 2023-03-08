package me.silenio;
import java.util.Scanner;
public class Jogo {
	static int x,y,winner=0;
	static Scanner scan = new Scanner(System.in);
	public static int [][] game = new int [3][3];
	
	public static int[][] player1() {
		
		System.out.println("Informe a posiçao na coluna");
		int column = scan.nextInt();
		column-=1;
		System.out.println("Informe a posiçao na linha");
		int line = scan.nextInt();
		line-=1;
		game[line][column] = 1;
		return game;
	}
	
	public static int[][] player2() {
		
		
		System.out.println("Informe a posiçao na coluna");
		int column = scan.nextInt();
		column-=1;
		System.out.println("Informe a posiçao na linha");
		int line = scan.nextInt();
		line-=1;
		game[line][column] = -1;
		return game;
	}
	
	public static int verifyDiagonally() {
		
		if(game[0][0] + game[1][1] +  game[2][2] == 3) {
			winner = 1;
		}else if(game[0][0] + game[1][1] + game[2][2] ==1) {
			winner = 2;
		}
		
		if(game[3][0] + game[1][1] + game[2][0] == 1) {
			winner=1;
		}else if(game[3][0] + game[1][1] + game[2][0] == -1) {
			winner=2;
	}
		
		return winner;
	}
	
	public static int verifyVertically() {

		for(int column=0 ; column<3 ; column++){

			if( (game[0][column] + game[1][column] + game[2][column]) == 3)
				winner=1;
			if( (game[0][column] + game[1][column] + game[2][column]) == -3)
				winner=2;
		}

		return winner;
	}
	
	public static int verifyHorizontally() {

		
		for(int line=0 ; line<3 ; line++){

			if( (game[line][0] + game[line][1] + game[line][2]) == 3)
				winner=1;
			if( (game[line][0] + game[line][1] + game[line][2]) == -3)
				winner=2;
		}

		return winner;
	}

	
	public static void verifyWinner() {
		
	
		if(verifyHorizontally()==1) {
			winner=1;
			System.out.println("Vencedor: " +winner);
		}else if(verifyHorizontally()==2){
			winner=2;
			System.out.println("Vencedor: " +winner);
		}
		
		if(verifyDiagonally()==1) {
			winner=1;
			System.out.println("Vencedor: " +winner);
		}else if(verifyDiagonally()==2){
			winner=2;
			System.out.println("Vencedor: " +winner);
		}
		
		if(verifyVertically()==1) {
			winner=1;
			System.out.println("Vencedor: " +winner);
		}else if(verifyVertically()==2){
			winner=2;
			System.out.println("Vencedor: " +winner);
		}
		
		if(winner==0) {
			System.out.println("Empate");
		}
		
		
		
	}
	
	
	public static void printGame(int game[][]) {
		
		for(int x=0;x<game.length;x++) {
			System.out.println("\s\s");
			for(int y=0;y<game.length;y++) {
				System.out.print("["+game[x][y]+"]");
			}
			System.out.println("\s\s");
		}
		
	}
	
	public static void exec() {
		player1();
		printGame(game);
		player2();
		printGame(game);
		player1();
		printGame(game);
		player2();
		printGame(game);
		player1();
		printGame(game);
		player2();
		printGame(game);
		verifyWinner();
	}
}
