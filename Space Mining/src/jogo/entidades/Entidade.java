package jogo.entidades;

import java.awt.Graphics;

public abstract class Entidade {
	protected float x, y;
	protected int largura, altura;
	
	public Entidade(float x, float y, int largura, int altura){
		this.x = x;
		this.y = y;
		this.largura = largura;
		this.altura = altura;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public abstract void atualiza();
	public abstract void desenha(Graphics g);
}
