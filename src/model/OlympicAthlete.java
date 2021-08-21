package model;

import java.util.ArrayList;
import java.util.List;

public class OlympicAthlete {
	
	private int id;
	private String name;
	private int age;
	private String sex;
	private String committee;
	private String sport;
	private List<Integer> medals = new ArrayList<>();

	public OlympicAthlete(int id, String name, int age, String sex, String committee, String sport, int gold, int silver,
			int bronze) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.committee = committee;
		this.sport = sport;
		this.medals.add(gold);
		this.medals.add(silver);
		this.medals.add(bronze);
	}
	
	public OlympicAthlete() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
