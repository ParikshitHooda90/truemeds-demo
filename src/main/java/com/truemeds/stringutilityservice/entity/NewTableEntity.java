package com.truemeds.stringutilityservice.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Generated;

@Entity(name = "firstname_lastname_java_output")
public class NewTableEntity {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	private Long id;
	
	@Column(name = "final_output")
	private String finalOutput;
	
	private Integer count;
	private String name;
	private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	public String getFinalOutput() {
		return finalOutput;
	}
	public void setFinalOutput(String finalOutput) {
		this.finalOutput = finalOutput;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
