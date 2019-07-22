import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Josh Gandolfo
 * @semester CS 121 035
 * this class implements LibraryInterface and sets up the methods
 *
 */
public  class Library implements LibraryInterface {
	final String DELIMITERS = (",");
	public ArrayList<Book> copyBook;

	//create arraylists of books
	private  ArrayList<Book> books = new ArrayList<Book>();



	/**
	 * Get a copy of the books ArrayList, not a reference to the internal
	 *    books instance variable itself.
	 * @return Copy of the books ArrayList
	 */
	public ArrayList<Book> getBooks() {			

		copyBook = new ArrayList<Book>(books);
		return copyBook;

	}

	/**
	 * Takes a Book object as a parameter and adds it to the internal 
	 * ArrayList of Books.
	 * @param newBook Book to add to Library
	 */
	public  void addBook(Book newBook) {
		books.add(newBook);

	}

	/**
	 * Remove the Book at the specified index with the ArrayList of Books
	 * @param index Index of book to remove from Library
	 */
	public  void removeBook(int index) {
		if (index >= 0 && index < books.size()) {  
			books.remove(index );
		}
	}



	/**
	 * Return a reference to the Book at the specified index.
	 * @param index Index of Book to retrieve from Library 
	 * @return Reference to the specified Book, null if index is out of bounds.
	 */
	public Book getBook(int index) {			
		if (index >= 0 && index < books.size()) {  
			return books.get(index);
		} else { return null; }
	}

	/**
	 * Return string containing a list of the books in the library
	 *    including their cooresponding index position within the
	 *    ArrayList.
	 * @return String with indexed booklist
	 */

	int index = 0;

	public String toString() {
		String a = ""; 
		String c = "";
		for (index = 0; index < books.size(); index++) {
			a = (index + " ");
			String b = (books.get(index) + "\n");
			c += a+b;
		} return c;	


	}

	int count = 0;
	public int getSize() {
		for (count = 0; count < books.size(); count++);

		return count  ;
	} 
	
	//load library from csv
	public  void loadLibraryFromCSV(String s) {
		File file = new File(s);

		// check if file exists

		if (file.exists() && file.isFile()) 
		{
			try {
				Scanner fileScan = new Scanner(file);

				//outer while loop to iterate through file
				while (fileScan.hasNext()) 
				{

					String line = fileScan.nextLine();
					Scanner lineScan = new Scanner(line);
					lineScan.useDelimiter(DELIMITERS);

					//inner while loop
					while(lineScan.hasNext())
					{
						String title = lineScan.next();
						String author = lineScan.next();
						String genre = lineScan.next();
						String fileName = lineScan.next();

						Book book =  new Book(title, author, genre, fileName);

						addBook(book);


					}
					lineScan.close();

					//for each loop to print out
				}

				fileScan.close();
			} catch (FileNotFoundException e) {
				System.out.println("it did not work");
			}
		}

	}

}



