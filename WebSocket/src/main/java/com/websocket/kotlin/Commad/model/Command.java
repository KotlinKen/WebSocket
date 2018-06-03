package com.websocket.kotlin.Commad.model;

public class Command {
	private String id;
	private String pass;
	private String name;
	
	public Command() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Command(String id, String pass, String name) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Command [id=" + id + ", pass=" + pass + ", name=" + name + "]";
	}
	
}
