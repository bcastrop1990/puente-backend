package pe.gob.senasa.interfaces;

import java.util.Date;

import javax.naming.NamingException;

import pe.gob.senasa.bean.AgenteAduanas;


public interface AgenteAduanasInterface {
    
    public AgenteAduanas obtenerAgenteAduanas(String numeroDocumento) throws NamingException;
    
    public AgenteAduanas obtenerAgenteAduanasXidPersona(String idPersona) throws NamingException;
    
    public double obtenerSaldoFavorAgenteAduanas(String rucAgenteAduanas);
    
    public String abonarSaldoFavorAgenteAduanasPapeleta(String rucAgenteAduanas,String papeletaID,
                                                     Double excedente);
    
    public String abonarSaldoFavorAgenteAduanasNotaAbono(String rucAgenteAduanas,String notaabono,
                                                 Double excedente);
    
    public String CrearPapeleta(String dniRucSolicitante,
                                  String tipodeposito,
                                  String numerodeposito,
                                  Date fechadeposito,
                                  Double montodepositado);
}
