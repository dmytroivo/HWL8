package com.gmail.dmytroivo;

public class NotLoadGroupException extends Exception{

	private static final long serialVersionUID = 7L;
	
	@Override
	public String toString(){
	return "Группа не загружена";
	}
}
