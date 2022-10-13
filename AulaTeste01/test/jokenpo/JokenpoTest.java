package jokenpo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JokenpoTest {
	private Jokenpo joken = new Jokenpo();
	
	@DisplayName("Tetando saidas Jokenpo")
	@Test
	public void testSaidaJokenpo() {
		Assertions.assertEquals(0, joken.jogar(1, 1));
		Assertions.assertEquals(0, joken.jogar(2, 2));
		Assertions.assertEquals(0, joken.jogar(3, 3));
		Assertions.assertEquals(1, joken.jogar(1, 2));
		Assertions.assertEquals(1, joken.jogar(2, 3));
		Assertions.assertEquals(2, joken.jogar(3, 2));
		Assertions.assertEquals(2, joken.jogar(2, 1));
	}
	
	@DisplayName("Tetando entradas Jokenpo")
	@Test
	public void testEntradaJokenpo() {
		Assertions.assertEquals(-1, joken.jogar(0, 0));
		Assertions.assertEquals(-1, joken.jogar(0, 4));
		Assertions.assertEquals(-1, joken.jogar(4, 0));
		Assertions.assertEquals(-1, joken.jogar(4, 4));
	}
}
