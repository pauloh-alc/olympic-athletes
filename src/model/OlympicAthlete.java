package model;

import java.util.ArrayList;
import java.util.List;

public class OlympicAthlete {
	
	private String name;
	private int age;
	private String sex;
	private String committee;
	private String sport;
	private List<Integer> medals = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String nome) {
		this.name = nome;
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
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	public String getCommittee() {
		return committee;
	}
	public void setCommittee(String committee) {
		this.committee = committee;
	}
	public List<Integer> getMedals() {
		return medals;
	}
	public void setMedals(Integer qttMedal) {
		medals.add(qttMedal);
	}
}
