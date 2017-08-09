package jogo.jogo;


public class Handler {
	private Jogo jogo;
	
	public Handler(Jogo jogo){
		this.jogo = jogo;
	}

	public KeyManager getKeyManager(){
		return jogo.getKeyManager();
	}
	public int getLargura(){
		return jogo.getLargura();
	}
	
	public int getAltura(){
		return jogo.getAltura();
	}
	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

}
