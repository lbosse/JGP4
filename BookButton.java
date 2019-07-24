import javax.swing.JButton;

@SuppressWarnings("serial")
public class BookButton extends JButton {
	private Book book;
	
	public  BookButton(Book book) {
	this.book = book;
	String s = book.getTitle();
	System.out.println(s.length());
	if (s.length() < 19) {
		this.setText(s);
	} else {
		this.setText(s.substring(0, 19));
	}

	
	}
	
	public Book getBookButton() {
		return book;
	}
	
	

}
