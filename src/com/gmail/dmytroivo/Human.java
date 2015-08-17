package com.gmail.dmytroivo;

import java.io.Serializable;

public class Human implements Serializable{

	private String surname;
	private String name;
	private String patronymic;
	private boolean sex;
	private String birthDate;


	Human(){
	}
	
	Human(String surname, String name, String patronymic, boolean sex,
			String birthDate) {
		this.surname = surname;
		this.name = name;
		this.patronymic = patronymic;
		this.sex = sex;
		this.birthDate = birthDate;
	}
    
	@Override
	public String toString() {
		return "|"+surname + "|" + name + "|" + patronymic+ "|"+(sex==true?" м |":" ж |") + birthDate+"|";
	};

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
}
