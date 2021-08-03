package com.example.demo.domain;

public class Member {

	private Integer id;
	private String name;
	private Integer depId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", depId=" + depId + "]";
	}

}
