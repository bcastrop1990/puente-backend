package com.senasa.bpm.ng.model.response;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.senasa.bpm.ng.model.bean.RegformBean;
import com.senasa.bpm.ng.model.bean.ReggridBean;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrazabilidadResponse {
    private List<RegformBean> regformBean;
    private List<ReggridBean> reggridBean;

}
