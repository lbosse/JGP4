import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * @author Josh Gandolfo
 * @semester CS 121 035
 * this class implements BookInterface and sets up the methods
 *
 */
public class Book implements BookInterface {
	
		private String title, author, genre, fileName;
		
		
		//constructor
		public Book() {
			
		}
		public Book(String title, String author) {
			this.title = title;
			this.author = author;
			genre = "null";
			fileName = "null";
			
		}
		public Book(String title, String author, String genre, String fileName) {
			this.title = title;
			this.author = author;
			this.genre = genre;
			this.fileName = fileName;
			
		}
		
		//get title
		public String getTitle() {
			return title;
		}
		
		//set title
		public void setTitle(String title) {
			this.title = title;
		}
		
		//get author
		public String getAuthor() {
		return author; 
	}
		
		//set author
		public void setAuthor(String author) {
			this.author = author;
		}
		
		//get genre
		public String getGenre() {
			return genre;
		}
		
		//set genre
		public void setGenre(String genre) {
			this.genre = genre;
		}

		//get filename
		public String getFilename() {
			return fileName;
		}
		
		//set filename
		public void setFilename(String fileName) {
			this.fileName = fileName;
			
		}
		
		/**
		 * Ensure all the attributes are set (not null) 
		 * and that the referenced Filename exists.
		 * @return true if valid, false if not.
		 */
		//check if book is valid
		public boolean isValid() {
			
			
		if (fileName == null || genre == null || author == null || title == null ) {

			return false;
		} File file = new File(fileName);
		if (file.isFile()) {
		return true;
		} else {
			return false;
		}
		}
		/**
		 * Return a String that contains the text contents of the 
		 * file referenced by the Filename attribute. Since this 
		 * method will need to open a file it will need to catch 
		 * the FileNotFoundException. If this Exception is raised, 
		 * simply return a String stating that the file was not able 
		 * to be opened.
		 * @return String containing text contents of book
		 */
		
		//get text from book
		public String getText() {
			String s = this.getFilename();
			File file = new File(s);

			// open try catch for loading file
			try {

				Scanner fileScan = new Scanner(file);	//file not being found properly

			
				String words = "";
				while (fileScan.hasNext())  {
					 words += fileScan.nextLine() + "\n";
					
				} fileScan.close();
				return words;
				
				
			} catch (FileNotFoundException e) {
				return "File not found!";
			} 
		}
		
		//return book information
		public String toString() {
			return (title +" "+ author+" " + genre + " " + fileName);
		}
		
		
	}


