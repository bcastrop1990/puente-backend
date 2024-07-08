package pe.gob.senasa.tupa;

import java.awt.FontMetrics;

import java.util.ArrayList;

import javax.swing.JLabel;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Dato;
import pe.gob.senasa.bean.RequisitoSanitario;


public class Metrics extends JLabel {
    protected static Logger logger = Logger.getLogger(CreacionDocumentos.class);

    FontMetrics fm;

    public Metrics() {
        super();
        fm = getFontMetrics(getFont());
    }

    public int calcularTamañoPixeles(String fila, String palabra) {
        return (fm.stringWidth(fila) + fm.stringWidth(palabra));
    }

    public String cantidadEspaciosSangria(String sangria) {
        if (sangria == null || sangria.equals("0")) {
            return "";
        }
        if (sangria.equals("1")) {
            return "    ";
        } else if (sangria.equals("2")) {
            return "           ";
        } else {
            return "                    ";
        }
    }

    public String cantidadEspaciosEtiqueta(String etiqueta) {
        String espacios = "";
        if (etiqueta != null && !etiqueta.equals("")) {
            for (int i = 0; i < etiqueta.length(); i++) {
                espacios = espacios + " ";
            }
        }
        return espacios;
    }

    public String[][] enviarLista(ArrayList<String> xlista) {
        String[][] array = new String[xlista.size()][1];
        for (int i = 0; i < xlista.size(); i++) {
            array[i][0] = xlista.get(i);
        }
        return array;
    }

    public String[][] ordenarSalidaListaReq(Dato listaDatosReq) {
        ArrayList<String> xlista = new ArrayList<String>();
        try {
            logger.debug("ORDENDAR SALIDA LISTA REQUISITOS INICIANDO");
            String palabra = "";
            String fila = "";
            String etiq = "";
            String sangria = "";
            boolean termina = false;
            boolean terminaReq = false;
            int c = 0;
            logger.debug("ANCHO DE PAGINA A IMPRIMIR: " + listaDatosReq.getAnchoPagPixel());
            int anchoPagPix = listaDatosReq.getAnchoPagPixel();
            for (RequisitoSanitario xreq : listaDatosReq.getListaRequisitos()) {
                if (xreq.getDescripcionRequisito() == null)
                    xreq.setDescripcionRequisito("");
                if (xreq.getEtiqueta() == null)
                    xreq.setEtiqueta("");
                if (xreq.getClase() == null)
                    xreq.setClase("");

                //if (listaDatosReq.isCpe()) {
                if (xreq.getClase().equals("P")) {
                    if (xreq.getEtiqueta() == null || xreq.getEtiqueta().equals("")) {
                        if (c == 0) {
                            fila = fila + sangria + this.cantidadEspaciosEtiqueta(etiq) + xreq.getDescripcionRequisito();
                            c++;
                            terminaReq = true;
                        } else {
                            terminaReq = false;
                            if (this.calcularTamañoPixeles(fila, xreq.getDescripcionRequisito()) < anchoPagPix) {
                                fila = fila + ", " + xreq.getDescripcionRequisito();
                                terminaReq = true;
                            } else {
                                //buscar metodo para cambiar el espacio en duro
                                xlista.add("    " + fila);
                                fila = "";
                                fila = fila + sangria + this.cantidadEspaciosEtiqueta(etiq) + xreq.getDescripcionRequisito();
                                terminaReq = true;
                            }
                        }
                        continue;
                    }
                }
                if (terminaReq) {
                    logger.debug("TERMINANDO DE SETEAR LA LISTA DE PLAGAS A MOSTRAR");
                    //buscar metodo para cambiar el espacio en duro
                    xlista.add("    " + fila + ".");
                    fila = "";
                    terminaReq = false;
                    c = 0;
                }
                //Modificado 04 de Enero del 2012
                etiq = xreq.getEtiqueta();
                sangria = this.cantidadEspaciosSangria(xreq.getSangria());
                for (int i = 0; i < xreq.getDescripcionRequisito().length(); i++) {
                    if (xreq.getDescripcionRequisito().charAt(i) != ' ') {
                        palabra = (i == 0 ? (sangria + etiq + " ") : palabra);
                        palabra = palabra + xreq.getDescripcionRequisito().charAt(i);
                    } else {
                        termina = false;
                        if (this.calcularTamañoPixeles(fila, palabra) < anchoPagPix) {
                            fila = fila + palabra + " ";
                            termina = true;
                        } else {
                            termina = true;
                            xlista.add(fila);
                            if (sangria.equals("")) {
                                fila = " " + this.cantidadEspaciosEtiqueta(etiq) + palabra + " ";
                            } else {
                                fila = " " + sangria + this.cantidadEspaciosEtiqueta(etiq) + palabra + " ";
                            }
                        }
                        palabra = "";
                    }
                }
                if (termina) {
                    xlista.add(fila + palabra);
                }
                fila = "";
                palabra = "";
            }
            logger.debug("CANTIDA DE FILAS A IMPRIMIR: " + xlista.size());
        } catch (Exception e) {
            logger.debug(e.getMessage());
            e.printStackTrace();
        }
        return this.enviarLista(xlista);
    }

}
