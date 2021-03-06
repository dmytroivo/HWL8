package com.gmail.dmytroivo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student extends Human implements Comparable<Object>, Serializable{

	private String group="абитуриент";
	private int studRecBook=0;
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
		return super.toString() + studRecBook + "|" + group + "|" + avgRating;
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

	public int getStudRecBook() {
		return studRecBook;
	}

	public void setStudRecBook(int srb) {
		this.studRecBook = srb;
	}

	
	
	
}
