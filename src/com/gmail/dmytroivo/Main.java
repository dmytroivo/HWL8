package com.gmail.dmytroivo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Run.printListCommands();
		Scanner sin = new Scanner(System.in);
		System.out.print("Открыть группу \nиз файла txt или grp? (1-txt 2-grp):");
		String firstCommandToStart=sin.nextLine();
		if (firstCommandToStart.equals("1")) {
			Run.loadGroupFromFileTXT();
		} else if (firstCommandToStart.equals("2")) {
			Run.loadGroupFromFileGRP();
		} else {
		System.out.println("Корректный выбор не сделан, группа не загружена");
		}
		String command = "";
		do {
			System.out.print("Введите команду: ");
			command = sin.nextLine();
			try{
			switch (command) {
			case "print":
				Run.printAllStudFromGroup();
				break;
			case "stxt":
				Run.saveGroupAsTXT();
				break;
			case "otxt":
				Run.loadGroupFromFileTXT();
				break;
			case "add":
				Run.addStudIntoGroup();
				break;
			case "del":
				Run.delStudFromGroup();
				break;
			case "find":
				Run.findStudFromGroup();
				break;
			case "sort":
				Run.sortStudFromGroup();
				break;
			case "help":
				Run.printListCommands();
				break;
			case "txt":
				Run.printAvailableFilesTXT();
				break;
			case "grp":
				Run.printAvailableFilesGRP();
				break;	
			case "tree":
				Run.tree();
				break;		
			case "exit":
				Run.exit();
				break;
			case "ogrp":
				Run.loadGroupFromFileGRP();
				break;
			case "sgrp":
				Run.saveGroupAsGRP();
				break;
			default:
				break;
			}
			} catch (NotLoadGroupException e){
				System.out.println(e);
			}
		}
		while (Run.isRunContinue());
	sin.close();
	}
}
