package pe.gob.senasa.ws.trazabilidad.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.ws.trazabilidad.bean.Trazabilidad;
import pe.gob.senasa.helper.DataTypeHelper;
import pe.gob.senasa.ws.trazabilidad.TrazabilidadWS;

public class Test {
    public Test() {
        super();
    }

    public static void main(String[] args) throws ParseException {
        DBHelper.TEST = true;
        DBHelper.CONNECTION_STRING = "jdbc:oracle:thin:finalbpm/senasa@10.0.0.160:1521:SIG";
        Test test = new Test();
        Trazabilidad tx = new Trazabilidad();
        tx.setProceso("BPM");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date d = df.parse("2014-04-16 00:05:05");
        tx.setFechaHora(d);
        java.sql.Date dx = DataTypeHelper.convertirFechaParaSQL(d);
        System.out.println("1" + d.getTime());
        System.out.println("2" + dx.getTime());
        TrazabilidadWS serv = new TrazabilidadWS();
        Trazabilidad tx2 = serv.insertarTrazabilidad("JM", tx);
        System.out.println(tx2.getSecuencial());
    }
}
