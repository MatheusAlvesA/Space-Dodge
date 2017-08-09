package jogo.entidades;

import java.awt.Graphics;

public abstract class Item extends Entidade {
	
	public static final double velocidadeInicial =  1.0;
	public static final double aceleracao = 0.002;

	public Item(float x, float y, int largura, int altura) {
		super(x, y, largura, altura);
	}

	@Override
	public void atualiza() {
		
	}

	@Override
	public void desenha(Graphics g) {
		
	}
	
	public void Mover(){
		
	}
}
