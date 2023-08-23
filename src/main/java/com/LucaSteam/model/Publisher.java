package com.LucaSteam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="entity")
public class Publisher {
	private long id_publisher;
	private String publisher_name;
	
	public Publisher() {
	}
	
	public Publisher(long id_publisher, String publisher_name) {
		this.id_publisher = id_publisher;
		this.publisher_name = publisher_name;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publisher")
	public long getId_publisher() {
		return id_publisher;
	}
	public void setId_publisher(long id_publisher) {
		this.id_publisher = id_publisher;
	}

	public String getPublisher_name() {
		return publisher_name;
	}
	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}
}
