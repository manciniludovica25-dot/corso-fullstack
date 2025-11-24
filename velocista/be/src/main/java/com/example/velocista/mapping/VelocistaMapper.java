package com.example.velocista.mapping;

import org.springframework.stereotype.*;

import com.example.velocista.dto.VelocistaDTO;
import com.example.velocista.model.VelocistaModel;

@Component
public class VelocistaMapper {
	
	public VelocistaDTO toDTO (VelocistaModel model) {
		VelocistaDTO dto = new VelocistaDTO();
		dto.setId(model.getId());
		dto.setNominativo(model.getNominativo());
		dto.setEta(model.getEta());
		dto.setRecord(model.getRecord());
		
		return dto;
		
	}
	
	public VelocistaModel toEntity (VelocistaDTO dto) {
		VelocistaModel model = new VelocistaModel();
		model.setId(dto.getId());
		model.setNominativo(dto.getNominativo());
		model.setEta(dto.getEta());
		model.setRecord(dto.getRecord());
		return model;
	}

}
