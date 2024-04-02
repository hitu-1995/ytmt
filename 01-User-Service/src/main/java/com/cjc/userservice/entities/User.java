package com.cjc.userservice.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class User {

	@Id
	@Column(name = "ID")
	private String uid;
	@Column(name = "NAME",length = 20)
	private String name;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "ABOUT")
	private String about;
	@Column(name = "MOBILE")
	private long mobile;
	
	@Transient
	private List<Rating> listOfRatings = new ArrayList<Rating>();
	
}
