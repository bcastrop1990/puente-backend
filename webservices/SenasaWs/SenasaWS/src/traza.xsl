<?xml version="1.0" encoding="UTF-8" ?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 
  <xsl:template match="/"> 
	
	<xsl:for-each select="trazabilidad/proceso">
     <table>
		<tr>
			<td style="font-weight:bold">Proceso BPM:</td>
			<td><xsl:value-of select="id_proceso"/></td>
		</tr>
		<tr>
			<td style="font-weight:bold">Solicitud</td>
			<td><xsl:value-of select="id_original"/></td>
		</tr>
		<tr>
			<td style="font-weight:bold">Expediente</td>
			<td><xsl:value-of select="id_final"/></td>
		</tr>

	 </table>
	 </xsl:for-each>
	<br></br>
	<table style = "border: 1px solid #000000;text-align:center" border="1" cellpadding = "1" cellspacing = "1">
		<tr class="titulo">
			<td colspan="2">Remitente</td>
			<td colspan="2">Destinatario</td>
			<td rowspan="2">Fecha Hora</td>
			<td rowspan="2">Accion</td>
			<td rowspan="2">Estado</td>

		</tr>

		<tr style="font-weight:bold">
			<td>Area/Entidad</td>
			<td>Persona</td>
			<td>Area</td>
			<td>Persona</td>

		</tr>
		<xsl:for-each select="trazabilidad/actividad/item">

		<tr>
			<td><xsl:value-of select="remitente_area"/></td>
			<td><xsl:value-of select="remitente_persona"/></td>
			<td><xsl:value-of select="destinatario_area"/></td>
			<td><xsl:value-of select="destinatario_persona"/></td>
			<td><xsl:value-of select="fecha_hora"/></td>
			<td><xsl:value-of select="accion"/></td>
			<td><xsl:value-of select="estado"/></td>
		
		</tr>
		</xsl:for-each>

	 </table>
 
</xsl:template> 
</xsl:stylesheet>
