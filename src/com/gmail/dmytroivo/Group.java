package com.gmail.dmytroivo;

import java.io.Serializable;
import java.util.Arrays;

public class Group implements Serializable  {

	private int countaddStudent = 1;
	private int countStudent = 0;
	private String nameGroup;
	private Student[] aStudents = new Student[10];

	Group(String nameGroup) {
		this.nameGroup = nameGroup;
	}
	
	
	public void setNameGroup(String nameGroup) {
		this.nameGroup = nameGroup;
	}


	public void loadStudent(String s, String n, String p, boolean sx, String bd, int srb, double avg ){
		aStudents[countStudent]=new Student(nameGroup);
		aStudents[countStudent].setSurname(s);
		aStudents[countStudent].setName(n);
		aStudents[countStudent].setPatronymic(p);
		aStudents[countStudent].setSex(sx);
		aStudents[countStudent].setBirthDate(bd);
		aStudents[countStudent].setSrb(srb);
		aStudents[countStudent].setAvgRating(avg);
		countStudent++;
		countaddStudent++;
	}
	
	public String getNameGroup() {
		return nameGroup;
	}

	public String findStudent(String surname) {
		for (int i = 0; i < countStudent; i++) {
			if (aStudents[i].getSurname().equalsIgnoreCase(surname)) {
			    return aStudents[i].toString();
			}
		}
		return "Студент не найден.";
	}

	public void addStudent(Student s) {
		try {
			if (countStudent == 10) {
				throw new OverflowGroupException();
			}
			if (s.getGroup().equals("абитуриент")) {
				aStudents[countStudent]=s;
				aStudents[countStudent].setGroup(nameGroup);
				aStudents[countStudent++].setSrb(Integer.parseInt("777"+countaddStudent++));
			} else {
				}
		} catch (OverflowGroupException e) {
			System.out.println(e);
		}
	}

	public void delStudent(int srb) {
		try {
			if (countStudent == 0) {
				throw new NullGroupException();
			} else {
				for (int i=0;i<countStudent;i++) {
					if (aStudents[i].getSrb()==srb) {
						aStudents[i].setGroup("абитуриент");
						for (; i < countStudent - 1; i++) {
							aStudents[i] = aStudents[i + 1];
						}
						aStudents[9]=null;
						countStudent--;
					}
				}
			}
		} catch (NullGroupException e) {
			System.out.println(e);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		String[] line=new String[9];
        for(int i=0;i<countStudent;i++){
        line=aStudents[i].toString().split("\\|");
        sb.append(String.format("%-2s",String.valueOf(i+1)));
        sb.append(line[0]+"|");
        sb.append(String.format("%-10s",line[1])+"|");
        sb.append(String.format("%-10s",line[2])+"|");
        sb.append(String.format("%-15s",line[3])+"|");
        sb.append(line[4]+"|");
        sb.append(line[5]+"|");
        sb.append(String.format("%-5s",line[6])+"|");
        sb.append(line[7]+"|");
        sb.append(line[8]);
        sb.append("\r\n");	
        }
    	return sb.toString();
    }

	public void sortGroup() {
		Arrays.sort(aStudents,0,countStudent);
	}

}
