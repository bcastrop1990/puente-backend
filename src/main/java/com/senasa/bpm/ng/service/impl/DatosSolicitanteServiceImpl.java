package com.senasa.bpm.ng.service.impl;

import com.senasa.bpm.ng.dao.TipoDocumentoDao;
import com.senasa.bpm.ng.model.bean.*;
import com.senasa.bpm.ng.model.request.GrabarInactivoRequest;
import com.senasa.bpm.ng.model.request.ListarProcedimientoRequest;
import com.senasa.bpm.ng.model.response.*;
import com.senasa.bpm.ng.service.DatosSolicitanteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DatosSolicitanteServiceImpl implements DatosSolicitanteService {

   private TipoDocumentoDao tipoDocumentoDao;

    @Override
    public List<TipoDocumentoResponse> listarTipodocumento() {
        List<TipoDocumentoBean> areaBean = tipoDocumentoDao.listarTipoDocumento();
        List<TipoDocumentoResponse> response = new ArrayList<>();

        for (TipoDocumentoBean tipoDoc : areaBean) {
            TipoDocumentoResponse tipoDocumentoResponse = TipoDocumentoResponse.builder()
                    .codigdocumento(tipoDoc.getCodigdocumento())
                    .descripcionCompleta(tipoDoc.getDescripcionTipoDocumento())
                    .descripcionTipoDocumento(tipoDoc.getDescripcionCompleta())
                    .build();
            response.add(tipoDocumentoResponse);
        }
        return response;
    }

    @Override
    public List<RepresentanteLegalResponse> listarRepresentanteLegal (String representanteLegal) {
        List<RepresentanteLegalBean> repreSentanteLegalBean = tipoDocumentoDao.listarRepresentanteLegal(representanteLegal);
        List<RepresentanteLegalResponse> response = new ArrayList<>();

        for (RepresentanteLegalBean documento : repreSentanteLegalBean) {
            RepresentanteLegalResponse representanteLegalResponse = RepresentanteLegalResponse.builder()
                    .representante_Id(documento.getRepresentante_Id())
                    .nombre_Razon_Social(documento.getNombre_Razon_Social())
                    .persona_Tipo(documento.getPersona_Tipo())
                    .documento_Tipo(documento.getDocumento_Tipo())
                    .persona_Id(documento.getPersona_Id())
                    .provincia_Id(documento.getProvincia_Id())
                    .documento_Numero(documento.getDocumento_Numero())
                    .apellido_Paterno(documento.getApellido_Paterno())
                    .apellido_Materno(documento.getApellido_Materno())
                    .nombres(documento.getNombres())
                    .direccion(documento.getDireccion())
                    .departamento_Id(documento.getDepartamento_Id())
                    .nomb_Dpto_Dpt(documento.getNomb_Dpto_Dpt())
                    .distrito_Id(documento.getDistrito_Id())
                    .telefono(documento.getTelefono())
                    .telefono_Movil(documento.getTelefono_Movil())
                    .referencia(documento.getReferencia())
                    .correo_Electronico(documento.getCorreo_Electronico())
                    .pais_Id(documento.getCorreo_Electronico())
                    .estado_1(documento.getEstado_1())
                    .fecha_Nacimiento(documento.getFecha_Nacimiento())
                    .nombre_Razsoc_Comp(documento.getCorreo_Electronico())
                    .cargo(documento.getCargo())
                    .fecha_Desde(documento.getFecha_Desde())
                    .persona_Id(documento.getCorreo_Electronico())
                    .build();
            response.add(representanteLegalResponse);
        }
        return response;
    }


}



