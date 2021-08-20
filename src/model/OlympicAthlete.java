package model;

import java.util.HashMap;

public class OlympicAthlete {
	
	private String nome;
	private int age;
	private String sex;
	private String comittee;
	private String sport;
	private HashMap<String, String> medals = new HashMap<>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getComittee() {
		return comittee;
	}
	public void setComittee(String comittee) {
		this.comittee = comittee;
	}
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
}
