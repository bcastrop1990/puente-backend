package pe.gob.senasa.vuce.integrador.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DocumentoVuce {
	
	private String tipo;
	private String numero;
	private Double monto;
	private String fecha;
	
	public DocumentoVuce()
	{
	}
	
	public DocumentoVuce(String tipo, String numero) {
		super();
		this.tipo = tipo;
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public Date getFechaDoc()
	{
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

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}
}
