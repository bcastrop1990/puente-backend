package pe.gob.senasa.dbtypes;

import java.io.Serializable;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.Datum;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;


public class ListaGenerica implements ORAData, ORADataFactory,
                                             Serializable {


    private static final ListaGenerica arrayFactory =
        new ListaGenerica();

    private Collection collection;

    private String _SQL_NAME;


    public ListaGenerica() {

        this.collection = Collections.EMPTY_LIST;
    }

    public ListaGenerica(Collection collection) {
        this.collection = collection;
    }


    static synchronized public ListaGenerica getDataArray(Array datos) throws SQLException {
        List listData = null;
        ListaGenerica result = null;
        if (datos != null) {
            listData = Arrays.asList((Object[])datos.getArray());
            result = new ListaGenerica(listData);
        }
        return result;
    }


    public Datum toDatum(Connection conn) throws SQLException {

        ArrayDescriptor arrayDesc = null;
        try {
            arrayDesc =
                    ArrayDescriptor.createDescriptor(this.getSqlName(), conn);
        } catch (RuntimeException e1) {

            e1.printStackTrace();
        }

        ARRAY array = null;
        try {
            array = new ARRAY(arrayDesc, conn, collection.toArray());
        } catch (RuntimeException e2) {

            e2.printStackTrace();
        }

        return array;

    }

    public ORAData create(Datum datum, int intx) {

        if (datum == null) {

            return null;

        }

        try {

            ARRAY oracleArray = (ARRAY)datum;

            Object[] elements = (Object[])oracleArray.getArray();

            Collection arrayAsCollection = Arrays.asList(elements);

            return new ListaGenerica(arrayAsCollection);

        } catch (SQLException sqe) {

            return null;

        }
    }

    public Collection getCollection() {
        return this.collection;

    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public String getSqlName() {
        return _SQL_NAME;
    }

    public void setSqlName(String sqlName) {
        this._SQL_NAME = sqlName;
    }


    public static ORADataFactory getORADataFactory() {

        return arrayFactory;

    }


    public String toString() {
        StringBuffer buf = new StringBuffer();
        if (this.collection != null) {
            for (Iterator iter = collection.iterator(); iter.hasNext(); ) {
                Object element = iter.next();
                buf.append(element.toString());
            }

        }

        return buf.toString();
    }
}