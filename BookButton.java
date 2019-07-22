import javax.swing.JButton;

public class BookButton extends JButton {
	private Book book;
	
	public BookButton(Book book) {
	this.book = book;
	this.setText(book.toString());
	
	}
	
	public String getBookButton() {
		return book.toString();
	}
	
	

}
