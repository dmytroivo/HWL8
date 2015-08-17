package com.gmail.dmytroivo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Run.help();
		Scanner sin = new Scanner(System.in);
		System.out.print("Открыть группу \nиз файла txt или grp? (1-txt 2-grp):");
		String load=sin.nextLine();
		if (load.equals("1")) {
			Run.Initializate();
		} else if (load.equals("2")) {
			Run.InitSeriz();
		} else {
		System.out.println("Ошибка выбора, инициализирована команда \"otxt\"");
		}
		String command = "";
		do {
			System.out.print("Введите команду: ");
			command = sin.nextLine();
			switch (command) {
			case "print":
				Run.print();
				break;
			case "stxt":
				Run.stxt();
				break;
			case "otxt":
				Run.otxt();
				break;
			case "add":
				Run.add();
				break;
			case "del":
				Run.del();
				break;
			case "find":
				Run.find();
				break;
			case "sort":
				Run.sort();
				break;
			case "help":
				Run.help();
				break;
			case "txt":
				Run.txt();
				break;
			case "grp":
				Run.grp();
				break;	
			case "tree":
				Run.tree();
				break;		
			case "exit":
				Run.exit();
				break;
			case "ogrp":
				Run.ogrp();
				break;
			case "sgrp":
				Run.sgrp();
				break;
			default:
				break;
			}
		}
		while (Run.isRunContinue());
	sin.close();
	}
}
