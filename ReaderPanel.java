import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class ReaderPanel extends JPanel {
	private JLabel label, title, author;
	private JTextArea readBook;
	private JScrollPane bookWindow;
	private String bookTitle = "";
	private String bookAuthor = "";
	private JPanel information;


	public ReaderPanel(String string) {
		//initialize 



		label = new JLabel(string);
		add(label);
		this.setLayout(new BorderLayout());

		//top infor area
		information = new JPanel();
		add(information, BorderLayout.NORTH);
		TitledBorder border2 = new TitledBorder("information");
		border2.setTitleJustification(TitledBorder.LEFT);
		border2.setTitlePosition(TitledBorder.CENTER);
		information.setBorder(border2);

		// buttons in info section
		information.setLayout(new BoxLayout(information, BoxLayout.X_AXIS));

		
		title = new JLabel();
		title.setText("title 11" + getBookTitle());
		information.add(title);
System.out.println(bookTitle + "222");
		 author = new JLabel("Author");
		//JLabel pageNumber = new JLabel("Page");
		
		information.add(author);
		//information.add(pageNumber);

		


		// content area
		readBook = new JTextArea();

		add(readBook, BorderLayout.CENTER);


		//bottom navigation
		JPanel navigation = new JPanel();
		add(navigation, BorderLayout.SOUTH);
		TitledBorder border1 = new TitledBorder("navigation");
		border1.setTitleJustification(TitledBorder.LEFT);
		border1.setTitlePosition(TitledBorder.CENTER);
		navigation.setBorder(border1);

		//bottom nav button
		JButton pageUp = new JButton("Page Up");
		JButton pageDown = new JButton("Page Down");
		navigation.add(pageUp);
		navigation.add(pageDown);


		//scroll pane
		bookWindow = new JScrollPane(readBook); //JTextArea that you add to a scrollPane 
		bookWindow.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		bookWindow.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		TitledBorder border = new TitledBorder("Content");
		border.setTitleJustification(TitledBorder.LEFT);
		border.setTitlePosition(TitledBorder.CENTER);
		bookWindow.setBorder(border);

		add(bookWindow, BorderLayout.CENTER);
















	}
	public void setText(String text) {
		readBook.setText(text);
		//	readBook.revalidate();
	}
	public void setBookTitle(String name) {
		this.bookTitle = name;
		//title.revalidate();
		System.out.println(bookTitle);
		information.remove(title);
		
		JLabel n = new JLabel("title "+ bookTitle);
		information.add(n);
		//information.revalidate();
		


	}
	public void setBookAuthor(String BookAuthor) {
		this.bookAuthor= BookAuthor;
		information.remove(author);
		JLabel a = new JLabel("Author " + bookAuthor);
		information.add(a);
		//information.revalidate();
		
		
	}
public String getBookTitle() {
	return bookTitle;
}
}
