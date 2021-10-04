package campominado02.tabuleiro;

import java.util.ArrayList;
import java.util.List;

public class Campo {
	boolean aberto = false;
	boolean marcado = false;
	boolean minado = false;
	String tostring = "X";
	
	List<Campo> campos = new ArrayList<Campo>();
	List<CampoObservador> observadores = new ArrayList<CampoObservador>();
	
	public void adicionarObservador(CampoObservador observado){
		observadores.add(observado);
	}
	
	private void notificarObservadores(CampoEvento evento) {
		observadores.stream()
		.forEach(o -> o.EventoOcorreu(this, evento));
	}
	
	public Campo() {
		aberto = false;
		marcado = false;
		minado = false;
		tostring = "X";
	}
	
	public void AbrirCampo (Campo campo) {
		if(campo.marcado != false) {
			campo.aberto = true;
		}
	}
	
	public boolean MarcarCampo (Campo campo) {
		return campo.marcado = !campo.marcado;
	}
	
	public String ConteudoDoCampo(Campo campo) {
		if (campo.aberto == true && campo.minado == false) {
			return campo.tostring = "O";
		}else if (campo.aberto == false && campo.marcado == true ) {
			return campo.tostring = "!";
		}else if (campo.aberto == true && campo.minado == true) {
			return campo.tostring = "M";
		}else {
			return campo.tostring = "X";
		}
	}
	
	
}
