package classes;
import java.util.List;
import java.util.Calendar;

public class CandleStickFactory {

	public CandleStick constroiCandleParaData(Calendar data, List<Negocio> negocios){
		
		CandleStick candleStickValidado = Exception.validaNegocio(negocios);
		
		if(candleStickValidado != null)
			return candleStickValidado;
		
		double maximo = negocios.get(0).getPreco();
		double minimo = negocios.get(0).getPreco();	
		
		double volume = this.getVolume(negocios);
		
		maximo = this.getMaximoMinimo(negocios, maximo, minimo)[0];
		minimo = this.getMaximoMinimo(negocios, maximo, minimo)[1];
			
		double abertura = negocios.get(0).getPreco();
		double fechamento = negocios.get(negocios.size()-1).getPreco();
			
		return new CandleStick(abertura, fechamento, minimo, maximo, volume, data);
				
	}
		
	private double getVolume(List<Negocio> negocios){
		double volume = 0;
		
		for(Negocio negocio : negocios)
			volume += negocio.getVolume();
		
		return volume;
	}
	
	private double[] getMaximoMinimo(List<Negocio> negocios, double maximo, double minimo){
		double[] maxMin = new double[2];
		maxMin[0] = maximo;
		maxMin[1] = minimo;
		
		for(Negocio negocio : negocios){
			if(negocio.getPreco() > maxMin[0])
				maxMin[0] = negocio.getPreco();
			else if(negocio.getPreco() < maxMin[1])
					maxMin[1] = negocio.getPreco();
		}
		
		return maxMin;
	}
}
