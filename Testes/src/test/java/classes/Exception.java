package classes;

import java.util.Calendar;
import java.util.List;

public class Exception {
	
	private final static int ZERO = 0;

	public static void validaMaximoMinimo(double maximo, double minimo){
		if(maximo<minimo)
			throw new IllegalArgumentException("Valor máximo não pode ser menor que o minimo");

		if(maximo<0)
			throw new IllegalArgumentException("Máximo não pode ser negativo");
		
		if(minimo<0)
			throw new IllegalArgumentException("Minimo não pode ser negativo");
	}
	
	public static void validaAbertura(double abertura){
		if(abertura<0)
			throw new IllegalArgumentException("Abertura não pode ser negativo");
	}
	
	public static void validaFechamento(double fechamento){
		if(fechamento<0)
			throw new IllegalArgumentException("Fechamento não pode ser negativo");
	}
	
	public static void validaVolume(double volume){
		if(volume<0)
			throw new IllegalArgumentException("Volume não pode ser negativo");
	}
	
	public static void validaData(Calendar data){
		if(data == null)
			throw new IllegalArgumentException("Data não pode ser nula");
	}
	
	public static CandleStick validaNegocio(List<Negocio> negocios){
		if(negocios.isEmpty()){
			return new CandleStick(ZERO, ZERO, ZERO, ZERO, ZERO, Calendar.getInstance());
		}
		return null;
	}
}
