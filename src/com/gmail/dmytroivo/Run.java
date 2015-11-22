package com.gmail.dmytroivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Run {

	private static Group group;
	private static boolean runContinue = true;
	private static File fileGroupTXT;

	public static boolean isRunContinue() {
		return runContinue;
	}
	
    public static void loadGroupFromFileGRP() {
			System.out.print("Введите имя группы (grp):");
			Scanner sin = new Scanner(System.in);
			String nameGroup = sin.nextLine();
		try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(
				nameGroup + ".grp"))) {
			group = (Group) OIS.readObject();
			group.setNameGroup(nameGroup);
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Файл *.grp не найден!");
		}
		}

	public static void loadGroupFromFileTXT() {
		System.out.print("Введите имя группы (txt):");
		Scanner sin = new Scanner(System.in);
		String nameGroup = sin.nextLine();
		group = new Group(nameGroup);
		fileGroupTXT = new File(group.getNameGroup() + ".txt");
		if (fileGroupTXT.exists()) {
			try (BufferedReader bufReadFile = new BufferedReader(new FileReader(fileGroupTXT))) {
				String[] astr = new String[9];
				String line=new String("");
				for (int i =0;line!=null;i++){
					line=bufReadFile.readLine();
					if(line!=null){
					astr = line.split("\\|");
					group.loadStudent(astr[1].trim(),
							astr[2].trim(),
							astr[3].trim(),
							astr[4].trim().equals("м") ? true : false,
							astr[5],Integer.parseInt(astr[6].trim()), 
							Double.parseDouble(astr[8].trim()));
					}
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		}

	}

	
	public static void saveGroupAsTXT() throws NotLoadGroupException{
		if(group==null) throw new NotLoadGroupException();
		try {
			if (!fileGroupTXT.exists()) {
				fileGroupTXT.createNewFile();
			}
		} catch (IOException e) {
			System.out.println("Error create file");
		}
		try (PrintWriter printwr=new PrintWriter(fileGroupTXT)){
		printwr.write(group.toString());
		printwr.flush();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void delStudFromGroup() throws NotLoadGroupException {
		if(group==null) throw new NotLoadGroupException();	
		System.out.print("Введите номер зачетки, для удаления студента из группы:");
		Scanner sin = new Scanner(System.in);
		group.delStudent(sin.nextInt());
	}

	public static void findStudFromGroup() throws NotLoadGroupException{
		if(group==null) throw new NotLoadGroupException();	
		System.out.print("Введите Фимилию стутдента:");
		Scanner sin = new Scanner(System.in);
		System.out.println(group.findStudent(sin.nextLine()));
	}

	public static void sortStudFromGroup() throws NotLoadGroupException{
		if(group==null) throw new NotLoadGroupException();
		group.sortGroup();
	}

	public static void printAllStudFromGroup() throws NotLoadGroupException{
		if(group==null) throw new NotLoadGroupException();
		System.out.println(group);
	}

	public static void exit() {
		System.out.print("Программа завершена");
		Run.runContinue = false;
	}

	public static void printListCommands() {
		System.out.println("Команды программы:\n"
				+ "=== экран ===\n"
				+ "print - вывод на экран студентов группы\n"
				+ "txt   - вывод на экран файлов *.txt\n"
				+ "grp   - вывод на экран файлов *.grp\n"
				+ "tree  - вывод на экран структуры папки с проэктом\n"
				+ "=== файлы ===\n"
				+ "otxt  - открыть файл группы *.txt\n"
				+ "stxt  - сохранить файл группы *.txt\n"
				+ "ogrp  - открыть файл группы *.grp\n"
				+ "sgrp  - сохранить файл группы *.grp\n"
				+ "=== группа ===\n"
				+ "add   - добавление стутдента в группу\n"
				+ "del   - удаление студента из группы\n"
				+ "find  - поиск студента в группе\n"
				+ "sort  - сортировка группы по фамилии\n"
				+ "=== программа ===\n"
				+ "help  - вывод допустимых команд\n"
				+ "exit  - выход\n"
				);
	}
	
	public static void saveGroupAsGRP() throws NotLoadGroupException{
		if(group==null) throw new NotLoadGroupException();
		try (ObjectOutputStream OOS = new ObjectOutputStream(
				new FileOutputStream(group.getNameGroup() + ".grp"))) {
			OOS.writeObject(group);
		} catch (IOException e) {
			System.out.println("Ошибка сохранения файла "+group.getNameGroup()+".grp");
		}
	}
	
	public static void tree() {
		File folder = new File(System.getProperty("user.dir"));
		//TODO
		//System.out.println("Введите путь к дериктории для посторения дерева:");
		Run.printtree(folder," ",true);
	}
	
	public static void printAvailableFilesTXT() {
		Run.printFilesByEXT("txt");
	}
	
	public static void printAvailableFilesGRP() {
		Run.printFilesByEXT("grp");
	}
	
	public static void addStudIntoGroup() throws NotLoadGroupException{
	if(group==null) throw new NotLoadGroupException();
	Scanner sin=new Scanner(System.in);
	System.out.println("Ведите Фамилию стутдента:");
	String s=sin.nextLine();
	System.out.println("Ведите Имя стутдента:");
	String n=sin.nextLine();
	System.out.println("Ведите Отчество стутдента:");
	String p=sin.nextLine();
	System.out.println("Ведите пол стутдента (1-муж, 2-жен):");
	String sx=sin.nextLine();
	System.out.println("Ведите дату рождения в формате \"00.00.0000\":");
	String d=sin.nextLine();
	group.addStudent(new Student(s,n,p,sx.equals("1")?true:false,d));
	}
	
	private static void printFilesByEXT(String ext) {
		File folder = new File(System.getProperty("user.dir"));
		System.out.println(folder.getName() + ":");
		boolean f=false;
		for (String x : folder.list()) {
			if (x.substring(x.length() - 3, x.length()).equals(ext)) {
				System.out.println("  -" + x);
                f=true;
			}
		}
		System.out.println(f==false?"файлы не найдены":"");
	}
	
	private static void printtree(File f, String tab, boolean flag) {
		StringBuilder tabfin = new StringBuilder(tab);
		if (!flag) {
			tabfin.setCharAt(tabfin.length() - 1, '├');
		} else {
			tabfin.setCharAt(tabfin.length() - 1, '└');
		}
		if (!f.isDirectory()) {
			System.out.println(tabfin + f.getName());
		} else {
			System.out.println(tabfin + f.getName());
			File[] listFile = f.listFiles();
			if (listFile.length > 0) {
				for (int i = 0; i < listFile.length; i++) {
					printtree(listFile[i], tab
							+ (i < listFile.length - 1 ? " │" : "  "),
							(i == listFile.length - 1 ? true : false));

				}
			}
		}
	}

	

}
