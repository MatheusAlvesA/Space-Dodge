package jogo.States;

import java.awt.Graphics;

import jogo.jogo.Handler;

public abstract class State {
	
	private static State currentState = null;
	protected Handler handler;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getCurrentState() {
		return currentState;
	}
	
	
	public abstract void atualiza();
	public abstract void desenha(Graphics g);
	




	
}
