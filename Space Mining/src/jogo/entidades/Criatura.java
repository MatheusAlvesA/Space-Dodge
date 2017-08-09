package jogo.entidades;

public abstract class Criatura extends Entidade {
	
	protected double velocidade;
	public static final double velocidadePadrao =  6.5;
	public static final int larguraPadrao = 64, alturaPadrao = 64;
	public static final int vidapadrao = 1;
	protected int vidas;
	protected float xMove, yMove;
	
	public Criatura(float x, float y, int largura, int altura) {
		super(x, y, largura, altura);
		this.vidas= vidapadrao;
		velocidade = velocidadePadrao;
		xMove = 0;
		yMove = 0;
	}

	public void Mover(){
		this.x+=xMove;
		this.y+=yMove;
	}
	
	//Getters e Setters

	public double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(float velocidade) {
		this.velocidade = velocidade;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
 
}
