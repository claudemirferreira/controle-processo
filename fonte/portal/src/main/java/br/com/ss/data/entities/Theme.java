package br.com.ss.data.entities;

import java.io.Serializable;

public class Theme implements Serializable {

	private static final long serialVersionUID = -3284102216546471503L;

	private String name;

	private String image;

	public Theme() {
	}

	public Theme(String name, String image) {
		this.name = name;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}