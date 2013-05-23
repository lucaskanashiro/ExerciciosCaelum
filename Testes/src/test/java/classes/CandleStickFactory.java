package classes;
import java.util.List;
import java.util.Calendar;


public class CandleStickFactory {

		public CandleStick constroiCandleParaData(Calendar data, List<Negocio> negocios){
		if(negocios.isEmpty())
		{
			return new CandleStick(0, 0, 0, 0, 0, Calendar.getInstance());
			
		}
			double maximo = negocios.get(0).getPreco();
			double minimo = negocios.get(0).getPreco();
			double volume = 0;	
			
			for(Negocio negocio : negocios){
				volume += negocio.getVolume();
				
				if(negocio.getPreco() > maximo){
					maximo = negocio.getPreco();
				}else if(negocio.getPreco() < minimo){
						minimo = negocio.getPreco();
				}
			}
			
			double abertura = negocios.get(0).getPreco();
			double fechamento = negocios.get(negocios.size()-1).getPreco();
			
			return new CandleStick(abertura, fechamento, minimo, maximo, volume, data);
			
			
		}
		
}
