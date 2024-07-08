package pe.gob.senasa.vuce.integrador.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SincResultadoVUCE
{
	private List<SincResultadoErrorVUCE> errores;
	private String resultado;
	private String fecha;
	
	public SincResultadoVUCE(){
		errores = new ArrayList<SincResultadoErrorVUCE>();
	}
	
	public void addError(SincResultadoErrorVUCE error)
	{
		this.errores.add(error);
	}
	
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Date getFechaResultado() {
		if (this.getFecha() != null && this.getFecha().trim().length()>0)
		{
			try {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				return df.parse(this.getFecha());
			} catch (ParseException e) {
				try
				{
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					return df.parse(this.getFecha());
				} catch (ParseException e2) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public String showInfo()
	{
		return "XML Transaccion: " + this.errores.size() + " errores.";
	}
}