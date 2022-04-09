package com.assessment.LockedMe;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		Main obj = new Main();
		List<String> Files = new ArrayList<String>(); 
		Files.add("Validation.txt");
		Files.add("Calculator.txt");
		Files.add("Menu.txt");
		Files.add("FileOperations.txt");
		welcome();
		int option = 0, fileOption = 0;
		while(option != 3) {
			option = obj.menu();
			if (option == 1) {
				obj.show(Files);
			}
			else if (option == 2) {
				while (fileOption != 4) {
					fileOption = obj.fileOperationMenu();
				    if (fileOption == 1) {
					    obj.addFile(Files);
				    }
				    else if (fileOption == 2) {
					    obj.deleteFile(Files);
			    	}
				    else if (fileOption == 3) {
					    obj.searchFile(Files);
			    	}
				    else if (fileOption == 4) {
				    	System.out.println("Returned to Main Menu. \n");
					    break;
				    }
				    else {
					    System.out.println("Wrong Input");
				    }
				}
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
		System.out.println("Developer : Mohd Shahrukh\n");
	}
	
	public int menu() {                                     // welcome Screen menu
		System.out.println("1 List all files.");
		System.out.println("2 show File option Menu.");
		System.out.println("3 Quit.\n");
		Scanner sc = new Scanner(System.in);
		try {
			return sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please input correct value .\n");
			return menu();
		}
	}
	
	public int fileOperationMenu() {                        // show menu to add,delete,search a file and return 
		System.out.println("1 Add a new File.");
		System.out.println("2 Delete a File.");
		System.out.println("3 search a File.");
		System.out.println("4 Return to Main Menu.\n");
		Scanner sc = new Scanner(System.in);
		try {
			return sc.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Please input correct value .\n");
			return fileOperationMenu();
		}
		
	}
	
	public void show(List<String> list) {    
		// To list all files present in a TreeSet
		TreeSet<String> newlist = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		list.forEach((e) -> {
		      newlist.add(e); 
		      });
		
		newlist.forEach((e) -> {
		      System.out.println(e); 
		      });
 		 System.out.print("\n");
	}
	
    private void searchFile(List<String> files) {       // Method to search for an existing File   
    	Scanner sc = new Scanner(System.in);
		System.out.println("Enter a file name that you want to search :");
		if ( files.contains(sc.nextLine()) )
			System.out.println("File Exists !!!\n");
		else 
			System.out.println("File not Found !!!\n");	
		
	}

	private void deleteFile(List<String> files) {       // Method to delete a file
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a file name that you want to delete :");
		String file = sc.nextLine();
		if ( files.contains(file) ) {
			files.remove(file);
			System.out.println("File Deleted Successfully !!!\n");
		}
		else 
			System.out.println("File not Found !!!\n");	
		
	}

	private void addFile(List<String> list) {         // Method to add a file 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a file name that you want to add :");
		String file = sc.nextLine();
		TreeSet<String> newlist = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		list.forEach((e) -> {
		      newlist.add(e); 
		      });
		
		if ( newlist.contains(file) ) {
			System.out.println("File already present !!!\n");
		}
		else {
			list.add(file);
			System.out.println("File added successfully !!!\n");
		}
		
	}

}
