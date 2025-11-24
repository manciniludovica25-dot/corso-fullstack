package com.example.velocista.dto;

import jakarta.validation.constraints.*;


public class VelocistaDTO {
	
	@Positive
	private Long id;
	@NotBlank
	private String nominativo;
	@Positive
	@NotNull
	private Integer eta;
	@Positive
	private Double record;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	public Double getRecord() {
		return record;
	}

	public void setRecord(Double record) {
		this.record = record;
	}

	public VelocistaDTO(@Positive Long id, @NotBlank String nominativo, @Positive @NotNull Integer eta,
			@Positive Double record) {
		super();
		this.id = id;
		this.nominativo = nominativo;
		this.eta = eta;
		this.record = record;
	}

	public VelocistaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
