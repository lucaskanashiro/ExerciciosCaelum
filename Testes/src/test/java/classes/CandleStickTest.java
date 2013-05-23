package classes;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class CandleStickTest {

	@Test(expected = IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueOMinimo() {
		new CandleStick(10,20,10,5,15,Calendar.getInstance());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void aberturaNaoPodeSerNegativo() {
		new CandleStick(-10,20,10,15,15,Calendar.getInstance());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void fechamentoNaoPodeSerNegativo() {
		new CandleStick(10,-20,10,15,15,Calendar.getInstance());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void minimoNaoPodeSerNegativo() {
		new CandleStick(10,20,-10,15,15,Calendar.getInstance());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void maximoNaoPodeSerNegativo() {
		new CandleStick(10,20,10,-15,15,Calendar.getInstance());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void volumeNaoPodeSerNegativo() {
		new CandleStick(10,20,10,15,-15,Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void dataNaoPodeSerNula() {
		new CandleStick(10,20,10,15,15,null);
	}

}
