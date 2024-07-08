<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:tns="http://documentos.ws.senasa.gob.pe" xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.MediatorExtnFunction" xmlns:ns0="http://soa.senasa.gob.pe/service/ORG/procedimiento/proceso_procedimiento_tupa-v1.0" xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xp20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20" xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions" xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator" xmlns:oracle-xsl-mapper="http://www.oracle.com/xsl/mapper/schemas" xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue" xmlns:oraxsl="http://www.oracle.com/XSL/Transform/java" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" exclude-result-prefixes=" xsd oracle-xsl-mapper xsi xsl ns0 tns mhdr oraext xp20 xref socket dvm oraxsl">
   <oracle-xsl-mapper:schema>
      <!--SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY.-->
      <oracle-xsl-mapper:mapSources>
         <oracle-xsl-mapper:source type="XSD">
            <oracle-xsl-mapper:schema location="../Schemas/ProcesoProcedimientoTUPA.xsd"/>
            <oracle-xsl-mapper:rootElement name="procedimiento" namespace="http://soa.senasa.gob.pe/service/ORG/procedimiento/proceso_procedimiento_tupa-v1.0"/>
            <oracle-xsl-mapper:param name="procedimiento"/>
         </oracle-xsl-mapper:source>
      </oracle-xsl-mapper:mapSources>
      <oracle-xsl-mapper:mapTargets>
         <oracle-xsl-mapper:target type="XSD">
            <oracle-xsl-mapper:schema location="../Schemas/GestionVUCEPort_xsd_1.xsd"/>
            <oracle-xsl-mapper:rootElement name="cierreTramite" namespace="http://documentos.ws.senasa.gob.pe"/>
         </oracle-xsl-mapper:target>
      </oracle-xsl-mapper:mapTargets>
      <!--GENERATED BY ORACLE XSL MAPPER 12.2.1.3.0(XSLT Build 170820.1700.2557) AT [WED JUN 05 21:30:45 COT 2024].-->
   </oracle-xsl-mapper:schema>
   <!--User Editing allowed BELOW this line - DO NOT DELETE THIS LINE-->
   <xsl:template match="/">
      <tns:cierreTramite>
         <nroExpediente>
            <xsl:value-of select="/ns0:procedimiento/ns0:numeroExpediente"/>
         </nroExpediente>
         <idServicio>
            <xsl:value-of select="/ns0:procedimiento/ns0:codigoServicio"/>
         </idServicio>
         <idOrden>
            <xsl:value-of select="/ns0:procedimiento/ns0:ordenVuce"/>
         </idOrden>
         
            <documentosAdjuntos>
                <xsl:if test="/ns0:procedimiento/ns0:documentosAdjuntos">
                   <xsl:for-each select="/ns0:procedimiento/ns0:documentosAdjuntos">
                      <listaAdjuntos>
                         <nombre>
                            <xsl:value-of select="ns0:nombre"/>
                         </nombre>
                         <ucmId>
                            <xsl:value-of select="ns0:ucmid"/>
                         </ucmId>
                      </listaAdjuntos>
                   </xsl:for-each>
               </xsl:if>
               <xsl:if test="/ns0:procedimiento/ns0:cfeUcmId">
                    <listaAdjuntos>
                     <nombre>
                        <xsl:value-of select="/ns0:procedimiento/ns0:cfeNombre"/>
                     </nombre>
                     <ucmId>
                        <xsl:value-of select="/ns0:procedimiento/ns0:cfeUcmId"/>
                     </ucmId>
                  </listaAdjuntos>
               </xsl:if>
            </documentosAdjuntos>
         
      </tns:cierreTramite>
   </xsl:template>
</xsl:stylesheet>