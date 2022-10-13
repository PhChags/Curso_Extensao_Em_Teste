package calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

	private Calculadora calc = new Calculadora();
	
	@DisplayName("Testa soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(7, 3);		
		Assertions.assertEquals(10, soma);		
	}
	
	@DisplayName("Testa subtração de dois números")
	@Test
	public void testSubtracaoDoisNumeros() {
		int sub = calc.subtracao(7, 3);
		Assertions.assertEquals(4, sub);
	}
	
	@DisplayName("Testa multiplicação de dois números")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		Assertions.assertEquals(21, calc.multiplicacao(7, 3));
	}
	
	@DisplayName("Testa divisao de dois numeros")
	@Test
	public void testDivisaoDoisNumeros() {
		Assertions.assertEquals(2, calc.divisao(4, 2));
	}
	
	@DisplayName("Testa somatoria")
	@Test
	public void testSomatoria() {
		Assertions.assertEquals(28, calc.somatoria(7));
	}
	
	@DisplayName("Testa função é positivo")
	@Test
	public void testEhPositivo() {
		Assertions.assertTrue(calc.ehPositivo(7));
		Assertions.assertFalse(calc.ehPositivo(-3));
	}
	
	@DisplayName("Testa função compara")
	@Test
	public void testCompara() {
		Assertions.assertEquals(1, calc.compara(7, 3));
		Assertions.assertEquals(-1, calc.compara(3, 7));
		Assertions.assertEquals(0, calc.compara(73, 73));
	}
}

