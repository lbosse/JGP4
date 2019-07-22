import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * @author Josh Gandolfo
 * @semester CS 121 035
 * this is the main class.It takes in inputs from the scanner to add, remove, read and print books.
 *
 */

public class LibraryOfBooks {

	public static void main(String[] args) {
		
		
		//Library instance
		Library library = new Library();
	
		// make the original interface

				System.out.println("***********************");
				System.out.println("*     Program Menu    *");
				System.out.println("***********************");
				System.out.println("(A)dd a book");
				System.out.println("(L)oad csv");
				System.out.println("(D)elete a book");
				System.out.println("(R)ead a book");
				System.out.println("(P)rint library");
				System.out.println("(Q)uit");
				System.out.println("");
				System.out.println("Please enter a command (press 'm' for Menu)");
				
				//open Scanner
				Scanner scan = new Scanner(System.in);
				String input = "";
				
				//open while loop
				while (!input.toLowerCase().equals("q"))  {
					 input = scan.nextLine();
					
					switch (input.toLowerCase()) {


					// print books
					case "p": 
						System.out.println("List index and books");
						System.out.println(library.toString());
						System.out.println("Please enter a new command");
													
						break;
						
					// add books
					case "a":
						System.out.println("Lets add a book");
						System.out.println("enter book title: ");
						String title = scan.nextLine();
						System.out.println("enter an author: ");
						String author = scan.nextLine();
						
						Book newBook = new Book(title, author);
						
						System.out.println("enter genre: ");
						String genre = scan.nextLine();
						newBook.setGenre(genre);
						System.out.println("enter file path: ");
						String fileName = scan.nextLine();
						newBook.setFilename(fileName);
						
						
						library.addBook(newBook);
						System.out.println(newBook);
						
						System.out.println("book was added");
						System.out.println("Please enter a new command");
						
						
						break;
						
		
					//delete books
					case "d":
						System.out.println("Delete Book: enter index of book you want to delete");
						 int deleteBookIndex = Integer.parseInt(scan.nextLine());										//if deleteindex is valid index of 
						 
						 if (deleteBookIndex >= 0 && deleteBookIndex < library.getSize()) 
						 {
					library.removeBook(deleteBookIndex);
					System.out.println("deletion sucessful");
					System.out.println("Please enter a new command");
						 } else {
							 System.out.println("that is not a valid index. Press D to try again");
							 	
						 }
					
						
						break;
							
					//read books
					case "r":									//catch book does not exist or array is out of bounds
						System.out.println("enter index of book you want to read");
						
						int bookIndex = Integer.parseInt(scan.nextLine());
						
						if ( bookIndex >= 0 && bookIndex < library.getSize()) {
							
						Book f = library.getBook(bookIndex);
						
						if (f.isValid() == true) 
						{
						//String y = f.getFilename();
						
						//Book newBoo = new Book();
							
							String d = f.getText();
						System.out.println(d);
						System.out.println("Please enter a new command");
						} else {
							System.out.println("that is not a valid book");
						} 
						} else {
							System.out.println("that is not a valid index"); 
						}
					
						break;
						
					
						
					//quit
					case "q":
						System.out.println("Goodbye");
						
						break;
						
					//load csv	
					case "l":
						System.out.println("enter a file to load");
						String s = scan.nextLine();
						library.loadLibraryFromCSV(s);
						 System.out.println("file added");
						System.out.println(s);
					
					break;
						
					//default option
					default:
						
						System.out.println("Invalid selection");
						System.out.println("Please enter a command (press 'm' for Menu)");
		
		
					}
				} scan.close();
		
		
		
	
		
	}


}