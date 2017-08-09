//Trabalho prático de LPOO
//Aluno: Fernando de Macedo Passsos
//Matricula: 201516980

package jogo.tela;

import jogo.jogo.Jogo;

public class inicializador {
	public static void main(String[] args) {
		Jogo game = new Jogo("My Spaceship will go on!", 800, 600);
		game.iniciar();
		
	}
}
