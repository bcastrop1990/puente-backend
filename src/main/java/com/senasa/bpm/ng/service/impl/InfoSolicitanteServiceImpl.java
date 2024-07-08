package com.senasa.bpm.ng.service.impl;

import com.senasa.bpm.ng.dao.InfoSolicitanteDao;
import com.senasa.bpm.ng.model.bean.PersonaBean;
import com.senasa.bpm.ng.model.request.DniVuceRequest;
import com.senasa.bpm.ng.model.request.PersonaPorDocumentoResponse;
import com.senasa.bpm.ng.model.response.PersonaPorDocVuceResponse;
import com.senasa.bpm.ng.service.InfoSolicitanteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class InfoSolicitanteServiceImpl implements InfoSolicitanteService {

   private InfoSolicitanteDao infoSolicitanteDao;

    @Override
    public List<PersonaPorDocVuceResponse> obtenerPeronaPorDocVuce(DniVuceRequest request) {
        List<PersonaBean> areaBean = infoSolicitanteDao.obtenerPeronaPorDocVuce(request);
        List<PersonaPorDocVuceResponse> response = new ArrayList<>();

        for (PersonaBean tipoDoc : areaBean) {
            PersonaPorDocVuceResponse tipoDocumentoResponse = PersonaPorDocVuceResponse.builder()
                    .persona_Id(tipoDoc.getPersona_Id())
                    .nombre_Razon_Social(tipoDoc.getNombre_Razon_Social())
                    .persona_Tipo(tipoDoc.getPersona_Tipo())
                    .documento_Tipo(tipoDoc.getDocumento_Tipo())
                    .apellido_Paterno(tipoDoc.getApellido_Paterno())
                    .apellido_Materno(tipoDoc.getApellido_Materno())
                    .nombres(tipoDoc.getNombres())
                    .direccion(tipoDoc.getDireccion())
                    .departamento_Id(tipoDoc.getDepartamento_Id())
                    .nomb_Dpto_Dpt(tipoDoc.getNomb_Dpto_Dpt())
                    .provincia_Id(tipoDoc.getProvincia_Id())
                    .nomb_Prov_Tpr(tipoDoc.getNomb_Prov_Tpr())
                    .distrito_Id(tipoDoc.getDistrito_Id())
                    .nomb_Dist_Tdi(tipoDoc.getNomb_Dist_Tdi())
                    .telefono(tipoDoc.getTelefono())
                    .centro_Poblado_Id(tipoDoc.getCentro_Poblado_Id())
                    .telefono_Movil(tipoDoc.getTelefono_Movil())
                    .referencia_Direccion(tipoDoc.getReferencia_Direccion())
                    .estado(tipoDoc.getEstado())
                    .pais_Id(tipoDoc.getPais_Id())
                    .fecha_Nacimiento(tipoDoc.getFecha_Nacimiento())
                    .nombre_Razsoc_Comp(tipoDoc.getNombre_Razsoc_Comp())
                    .regi_Padr_Emp(tipoDoc.getRegi_Padr_Emp())
                    .build();
            response.add(tipoDocumentoResponse);
        }
        return response;
    }

    @Override
    public List<PersonaPorDocumentoResponse> obtenerPersonaPorDocumento(DniVuceRequest request) {
        List<PersonaBean> areaBean = infoSolicitanteDao.obtenerPersonaPorDocumento(request);
        List<PersonaPorDocumentoResponse> response = new ArrayList<>();

        for (PersonaBean tipoDoc : areaBean) {
            PersonaPorDocumentoResponse tipoDocumentoResponse = PersonaPorDocumentoResponse.builder()
                    .persona_Id(tipoDoc.getPersona_Id())
                    .nombre_Razon_Social(tipoDoc.getNombre_Razon_Social())
                    .persona_Tipo(tipoDoc.getPersona_Tipo())
                    .documento_Tipo(tipoDoc.getDocumento_Tipo())
                    .documento_Numero(tipoDoc.getDocumento_Numero())
                    .apellido_Paterno(tipoDoc.getApellido_Paterno())
                    .apellido_Materno(tipoDoc.getApellido_Materno())
                    .nombres(tipoDoc.getNombres())
                    .direccion(tipoDoc.getDireccion())
                    .departamento_Id(tipoDoc.getDepartamento_Id())
                    .nomb_Dpto_Dpt(tipoDoc.getNomb_Dpto_Dpt())
                    .provincia_Id(tipoDoc.getProvincia_Id())
                    .nomb_Prov_Tpr(tipoDoc.getNomb_Prov_Tpr())
                    .distrito_Id(tipoDoc.getDistrito_Id())
                    .nomb_Dist_Tdi(tipoDoc.getNomb_Dist_Tdi())
                    .telefono(tipoDoc.getTelefono())
                    .centro_Poblado_Id(tipoDoc.getCentro_Poblado_Id())
                    .telefono_Movil(tipoDoc.getTelefono_Movil())
                    .correo_Electronico(tipoDoc.getCorreo_Electronico())
                    .referencia_Direccion(tipoDoc.getReferencia_Direccion())
                    .estado(tipoDoc.getEstado())
                    .pais_Id(tipoDoc.getPais_Id())
                    .fecha_Nacimiento(tipoDoc.getFecha_Nacimiento())
                    .nombre_Razsoc_Comp(tipoDoc.getNombre_Razsoc_Comp())
                    .build();
            response.add(tipoDocumentoResponse);
        }
        return response;
    }
}



