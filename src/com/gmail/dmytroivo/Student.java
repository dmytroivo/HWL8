package com.gmail.dmytroivo;

import java.io.Serializable;

public class Student extends Human implements Comparable<Object>, Serializable{

	private String group="абитуриент";
	private int srb=0;
	private double avgRating = 0; 
	
	Student(String surname, String name, String patronymic, boolean sex,
			String birthDate) {
		super(surname, name, patronymic, sex, birthDate);
	}

	Student(String group) {
		super();
		this.group = group;
	}
	
	@Override
	public String toString() {
		return super.toString() + srb + "|" + group + "|" + avgRating;
	}

	@Override
	public int compareTo(Object o) {
		Student s=(Student) o;
        return this.getSurname().compareTo(s.getSurname());
	}
	
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public int getSrb() {
		return srb;
	}

	public void setSrb(int srb) {
		this.srb = srb;
	}

	
	
	
}
