package jogo.jogo;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import jogo.States.GameState;
import jogo.States.Menu;
import jogo.States.State;
import jogo.tela.Janela;

public class Jogo implements Runnable{
	private Janela janela;
	private int largura, altura;
	private String titulo;
	
	private Thread thread;
	private boolean rodando = false;
	
	private BufferStrategy bs;
	private Graphics g;	
	
	//States
	private State gameState;
	private State menuState;
	
	//Input
	private KeyManager keyManager;
	//Handler
	
	private Handler handler;
	public Jogo(String titulo, int largura, int altura){ //construtor de jogo
		this.largura = largura;
		this.altura = altura;
		this.titulo = titulo;
		keyManager = new KeyManager();
	}
	
	private void init() {
		janela = new Janela(titulo, largura, altura);
		janela.getJanela().addKeyListener(keyManager);
		
		handler = new Handler(this);
		gameState = new GameState(this.handler);
		menuState = new Menu(this.handler);
		
		State.setState(menuState);
		
	}
	
	private void atualiza(){
		keyManager.tick();
		if(State.getCurrentState() != null){
			State.getCurrentState().atualiza();
		}
	}
	
	private void desenha(){
		bs = janela.getTela().getBufferStrategy();
		if(bs == null){
			janela.getTela().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, largura, altura);
		//Desenhos aqui		
		if(State.getCurrentState() != null){
			State.getCurrentState().desenha(g);
		}		
		//Até aqui
		bs.show();
		g.dispose();
	}
	
	public void run(){
		 init();	
		//Variaveis para padronizar o tempo do loop
		int fps = 60;
		double timeUpdate = 1000000000/fps;
		double delta = 0;
		long now;
		long LastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;	
		while(rodando){
			//Padronizção tempo do loop para que o jogo seja atualizado 60 vezes por segundo
			now = System.nanoTime();
			delta += (now - LastTime)/ timeUpdate;
			timer += now - LastTime;
			LastTime = now;
			// fim da padronização
			if( delta >= 1){ //condição se verifica se está na hora de utilizar os metodos;
				atualiza();
				desenha();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000){ //if de controle
				System.out.println("Ticks and frames: " +ticks);
				ticks = 0;
				timer = 0;
			}
		}
		parar();		 
	}
	
	public KeyManager getKeyManager(){
		return this.keyManager;
	}
	
	public synchronized void iniciar(){ //metódo que inicializa a thread onde o jogo está rodando
		if(rodando)
			return;
		rodando = true;
		thread = new Thread(this); 
		thread.start();
	}
	
	public synchronized void parar(){ //metódo que parar o thread em que e o jogo está funcionando
		if(!rodando)
			return;
		rodando = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	
	public void changeState(){
		if(State.getCurrentState() == this.menuState){
			State.setState(gameState);
			return;
		}
		if(State.getCurrentState() == this.gameState){
			State.setState(menuState);
			return;
		}
	}

}
