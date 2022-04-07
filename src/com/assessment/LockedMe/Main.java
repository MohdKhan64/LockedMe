package com.assessment.LockedMe;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		Main obj = new Main();
		TreeSet<String> Files = new TreeSet<String>(); 
		Files.add("Validation.txt");
		Files.add("Calculator.txt");
		Files.add("Menu.txt");
		Files.add("FileOperations.txt");
		welcome();
		int option = 0, fileOption = 0;
		while(true) {
			option = obj.menu();
			if (option == 1) {
				obj.show(Files);
			}
			else if (option == 2) {
				fileOption = obj.fileOperationMenu();
			}
			else if (option == 3) {
				System.out.println("Thanks for using the application.");
				break;
			}
			else {
				System.out.println("Wrong Input");
			}
		}
		
	}
	
	public static void welcome() {                           // Welcome screen
		System.out.println("Project : Lockedme.com");
		System.out.println("Developer : Mohd Shahrukh");
	}
	
	public int menu() {                                     // welcome Screen menu
		System.out.println("1 List all files.");
		System.out.println("2 show File option Menu.");
		System.out.println("3 Quit");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public int fileOperationMenu() {                        // show menu to add,delete,search a file and return 
		System.out.println("1 Add a new File.");
		System.out.println("2 Delete an existing File.");
		System.out.println("3 search a File.");
		System.out.println("4 Return to Main Menu.");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public void show(TreeSet<String> list) {               // To list all files present in a TreeSet
 		 list.forEach((e) -> {
		      System.out.println(e); 
		      });
	}

}
