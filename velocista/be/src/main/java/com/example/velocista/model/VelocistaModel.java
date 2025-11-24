package com.example.velocista.model;

import jakarta.persistence.*;

@Entity
@Table(name="velocista")
public class VelocistaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nominativo;
	private Integer eta;
	private Double record;
	
	public VelocistaModel(Long id, String nominativo, Integer eta, Double record) {
		super();
		this.id = id;
		this.nominativo = nominativo;
		this.eta = eta;
		this.record = record;
	}

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

	public VelocistaModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
