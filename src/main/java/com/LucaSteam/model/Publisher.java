package com.LucaSteam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="publisher")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_publisher")
	private long id_publisher;

	@Column(name = "publisher_name")
	private String name;
	
	public Publisher() {
	}
	
	public Publisher(long id_publisher, String publisher_name) {
		this.id_publisher = id_publisher;
		this.name = publisher_name;
	}

	public long getId_publisher() {
		return id_publisher;
	}
	public void setId_publisher(long id_publisher) {
		this.id_publisher = id_publisher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
