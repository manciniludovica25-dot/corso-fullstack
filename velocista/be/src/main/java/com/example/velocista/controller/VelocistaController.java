package com.example.velocista.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.velocista.dto.VelocistaDTO;
import com.example.velocista.mapping.VelocistaMapper;
import com.example.velocista.model.VelocistaModel;
import com.example.velocista.service.VelocistaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/velocisti")
public class VelocistaController {

	@Autowired
	private VelocistaService velSer;

	@Autowired
	private VelocistaMapper mapper;

	@GetMapping
	public ResponseEntity<List<VelocistaDTO>> getAllVelocisti(@RequestParam(required = false) Integer eta) {
		List<VelocistaModel> entities;

		if (eta != null) {
			entities = velSer.findByEta(eta); // lista filtrata per età
		} else {
			entities = velSer.findAll(); // lista completa
		}

		List<VelocistaDTO> dtos = entities.stream().map(mapper::toDTO).toList();

		return ResponseEntity.ok(dtos);
	}

	@PostMapping("/new")
	public ResponseEntity<VelocistaDTO> create(@RequestBody VelocistaDTO dto) {
		VelocistaModel entity = mapper.toEntity(dto);
		VelocistaModel savedModel = velSer.create(entity);
		VelocistaDTO savedDTO = mapper.toDTO(savedModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedDTO);
	}

}
