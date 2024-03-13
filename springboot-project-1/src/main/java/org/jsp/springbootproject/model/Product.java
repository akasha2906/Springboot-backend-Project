package org.jsp.springbootproject.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int price;
	@Column(nullable = false)
	private String brand;
	@Column(nullable = false)
	private String model;
	@Column(nullable = false)
	private String about;
	@Column(nullable = false)
	private String imageurl;
	
	private String status;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Merchant merchant;
	

}
