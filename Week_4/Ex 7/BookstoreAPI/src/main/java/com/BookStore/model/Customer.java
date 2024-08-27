package com.BookStore.model;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Customer {
    private Long id;
    private String name;
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "###-###-####")
    private String phone;

    private String address;

    // Getters and Setters
}
