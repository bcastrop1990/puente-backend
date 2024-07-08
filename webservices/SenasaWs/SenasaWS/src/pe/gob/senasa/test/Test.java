package pe.gob.senasa.test;


public class Test {
    public Test() {
        super();
    }

    public static void main(String[] args) {
        
      /*try {
        Informacion informacion = null;
        informacion = new Informacion();
        ArrayList<Dato> listaDatosRemplazar = new ArrayList<Dato>();
        Dato d = null;

        d = new Dato();
        d.setEtiqueta("nrExp");
        d.setValor("00011129923");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("nroInfInspVrfPlagInsVet");
        d.setValor("00097974345");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("esI");
        d.setValor("X");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("esT");
        d.setValor("X");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("nrPerm");
        d.setValor("000239398");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("fechaInfInsp");
        d.setValor("07/11/2011");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("regtrs");
        d.setValor("4546");
        listaDatosRemplazar.add(d);

        //Datos del Importador
        d = new Dato();
        d.setEtiqueta("nomImptdr");
        d.setValor("Oswaldo Chavez Moreno");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("rucDniImptdr");
        d.setValor("54546797");
        listaDatosRemplazar.add(d);

        //Datos de la Agencia de Aduana
        d = new Dato();
        d.setEtiqueta("agncAdnNv");
        d.setValor("Importaciones y Exportaciones Veracruz");
        listaDatosRemplazar.add(d);

        //Datos del Certificado
        d = new Dato();
        d.setEtiqueta("nroCertf");
        d.setValor("0001289078");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("pesNet");
        d.setValor("1550");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("fecEmisn");
        d.setValor("07/11/2011");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("nroDuaDs");
        d.setValor("235.2008.10.100153");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("paisOrg");
        d.setValor("CANADA,EEUU");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("paisPrd");
        d.setValor("CANADA");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("paisDest");
        d.setValor("CHINA");
        listaDatosRemplazar.add(d);

        //DATOS DE LOS PRODUCTOS

        d = new Dato();
        d.setEtiqueta("totProdcts");
        d.setValor("USO COMERCIAL");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("fecLlegd");
        d.setValor("04/01/2012");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("psNetTot");
        d.setValor("5600");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("docEmb");
        d.setValor("0967556");
        listaDatosRemplazar.add(d);
        ArrayList<Dato> lstDatos = new ArrayList<Dato>();
        String[][] lstValores = null;
        d = new Dato();
        lstValores = new String[2][7];
        lstValores[0][0] = "TRIGO, harina";
        lstValores[0][1] = "11.01.00.00.00";
        lstValores[0][2] = "2500";
        lstValores[0][3] = "KILOGRAMOS";
        lstValores[0][4] = "BOLSAS";
        lstValores[0][5] = "3";
        lstValores[0][6] = "SI";

        lstValores[1][0] = "MAIZ AMARILLO, granoa";
        lstValores[1][1] = "10.05.90.11.00";
        lstValores[1][2] = "2300";
        lstValores[1][3] = "KILOGRAMOS";
        lstValores[1][4] = "CAJAS";
        lstValores[1][5] = "6";
        lstValores[1][6] = "SI";

        d.setListavaloresTabla(lstValores);
        d.setEtiqueta("lstProductos");
        lstDatos.add(d);
        informacion.setListaDatosTablas(lstDatos);

        d = new Dato();
        d.setEtiqueta("trmAlmcAut");
        d.setValor("DHL EXPRESS");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("plcRodCam");
        d.setValor("HG-4593");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("otroAlmc");
        d.setValor(" ");
        listaDatosRemplazar.add(d);

        //DATOS DEL RESULTADO DE LA INSPECCION
        d = new Dato();
        d.setEtiqueta("i1");
        d.setValor(" ");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("i2");
        d.setValor(" ");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("i3");
        d.setValor(" ");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("i4");
        d.setValor(" ");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("i5");
        d.setValor(" ");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("i6");
        d.setValor("X");
        listaDatosRemplazar.add(d);

        //Datos para la firma
        d = new Dato();
        d.setEtiqueta("bpmTagFirmaRemitente");
        d.setValor("");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("ID_CENTRO_TRAMITE");
        d.setValor("21");
        listaDatosRemplazar.add(d);

        d = new Dato();
        d.setEtiqueta("ID_SERVICIO");
        d.setValor("001");
        listaDatosRemplazar.add(d);
        //

        //Insertando la lista de datos a reemplazar
        informacion.setListaDatosRemplazar(listaDatosRemplazar);

      
        ArrayList<Propiedad> lstMetadatos = new ArrayList<Propiedad>();
        Propiedad prop = null;

        prop = new Propiedad();
        prop.setXPropiedad("dDocType");
        prop.setXValor("DORI");
        lstMetadatos.add(prop);

        prop = new Propiedad();
        prop.setXPropiedad("xProfileTrigger");
        prop.setXValor("TUPA-DORI");
        lstMetadatos.add(prop);

        prop = new Propiedad();
        prop.setXPropiedad("xNumeroExpediente");
        prop.setXValor("0000120108");
        lstMetadatos.add(prop);

        prop = new Propiedad();
        prop.setXPropiedad("dDocTitle");
        prop.setXValor("IIV Fit. " + " -0000120167-00000000098");
        lstMetadatos.add(prop);

        prop = new Propiedad();
        prop.setXPropiedad("xSubTipo");
        prop.setXValor("IIVI");
        lstMetadatos.add(prop);
        informacion.setMetadatos(lstMetadatos);
       
        String ucmid;
        CreacionDocumentos gs= new CreacionDocumentos();
      
        ucmid= gs.crearDocumento("12121","PLANTILLA_DORI-PEFI", informacion);
      
        } catch (Exception e) {
        e.getMessage();
        }
        */
        
        /*Test test = new Test();
        PermisoFitosanitarioImportacionWS ws = new PermisoFitosanitarioImportacionWS();
        PermisoFitosanitarioImportacion obj = ws.obtenerDatosPFIxExpediente("139900020107");*/
        //System.out.println("LLEGA AQUI");
        /*
        -- SNS022 O2015014846
        -- SNS009 O2015014809
        -- SNS023 O2015014661
        -- SNS019 O2015014097
        -- SNS010 O2015013448
        -- SNS012 O2015001945
        -- SNS020 O2014016633
        -- SNS013 O2014009792
        */
       // GestionSolicitud gs = new GestionSolicitud();
       // gs.generarSolicitudVUCE("74115", "O2015014846");
       /*GestionRecibo gr = new GestionRecibo();
        
      Recibo rec = new Recibo();
      rec.setCodigoRecibo("139900000146");
      ArrayList<Propiedad> metadatos = new ArrayList<Propiedad>();
      metadatos.add(new Propiedad("dDocTitle", " Sop. Pag. Rec. Pag. PRUEBA iREPORT para SOLCITUD"));
      metadatos.add(new Propiedad("dDocType", "SPGO"));
      metadatos.add(new Propiedad("xSubTipo", "RECP"));
      metadatos.add(new Propiedad("xProfileTrigger", "TUPA-SPGO"));
      metadatos.add(new Propiedad("xNumeroExpediente", "11111"));
      metadatos.add(new Propiedad("xNumeroBoletaRecibo", rec.getCodigoRecibo()));
      rec.setMetadatos(metadatos);
        
        gr.generarRecibo("13213", rec);*/
        
        //PermisoZoosanitarioImportacionWS ws = new PermisoZoosanitarioImportacionWS();
        //PermisoZoosanitarioImportacion perm = ws.obtenerDatosPZIxExpediente("129900008482");
        //System.out.println(perm.getFechaProbableIngreso());
        //System.out.println(perm.getFechaProbableSalida());
        
        //MsWordReplace word = new MsWordReplace();
        //String output = word.OpenAndSaveToPDF("E:\\Docs\\Copia de Lista de Reqs de Usuario 18032013.docx");
        //System.out.println(output);
    }
}
