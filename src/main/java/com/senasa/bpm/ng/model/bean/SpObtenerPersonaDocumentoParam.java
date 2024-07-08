package com.senasa.bpm.ng.model.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@Builder
public class SpObtenerPersonaDocumentoParam {

    private String ptidodoc;
    private String pnumdoc;
    private String pnombre;


}
