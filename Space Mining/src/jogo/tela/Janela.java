package jogo.tela;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Janela{
	//Declaração dos atributos da tela
	private JFrame janela;
	private Canvas tela;
	
	private String titulo;
	private int altura, largura;
	
	//Construtor da tela
	public Janela(String titulo, int largura, int altura){
		this.titulo= titulo;
		this.altura= altura;
		this.largura = largura;
		
		criaTela(); // metódo para setar o JFrame
	}
	
	private void criaTela(){
		janela = new JFrame(titulo); //Define o nome da janela
		janela.setSize(largura, altura); //Define o tamanho da janela
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Faz com que a aplicação feche ao clicar no X
		janela.setResizable(false); //Impede que o usuario redimensione a tela por questõe de sprites e afins
		janela.setLocationRelativeTo(null); //Faz com que a tela apareça no meio
		janela.setVisible(true); //Ativa a visibilidade da tela
		
		tela = new Canvas(); //Inicia o atributo tela para que seja possível adicionar gráfico para a janela
		tela.setPreferredSize(new Dimension(largura, altura));
		tela.setMaximumSize(new Dimension(largura, altura));
		tela.setMinimumSize(new Dimension(largura, altura));
		tela.setFocusable(false);
		
		janela.add(tela);
		janela.pack();
		
	}
	
	public Canvas getTela(){
		return this.tela;
	}
	
	public JFrame getJanela(){
		return janela;
	}
}

