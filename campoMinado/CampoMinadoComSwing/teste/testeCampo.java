import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import campoMinado.Campo;

class testeCampo {

	Campo C00 = new Campo(0,0);
	Campo C01 = new Campo(0,1);
	Campo C11 = new Campo(1,1);
	Campo C02 = new Campo(0,2);
	Campo C21 = new Campo(2,1);
	Campo C33 = new Campo(3,3);

	@Test
	void testIsVizinhoNorte() {
		boolean resultado = C11.isVizinho(C01);
		assertTrue(resultado);
	}
	
	@Test
	void testIsVizinhoSul() {
		boolean resultado = C11.isVizinho(C21);
		assertTrue(resultado);
	}

	@Test
	void testIsVizinhoNaoVizinho() {
		boolean resultado = C11.isVizinho(C33);
		assertFalse(resultado);
	}
	
	
}
