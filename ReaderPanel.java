import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class ReaderPanel extends JPanel {
	private JLabel label, title, author, pageNumber;
	private JTextArea readBook;
	private JScrollPane bookWindow;
	private String bookTitle = "";
	private String bookAuthor = "";
	private JPanel information;
	private JScrollBar scroll;

	public ReaderPanel(String string) {
		// initialize

		label = new JLabel(string);
		add(label);
		this.setLayout(new BorderLayout());

		// top info area
		information = new JPanel();
		add(information, BorderLayout.NORTH);
		TitledBorder border2 = new TitledBorder("information");
		border2.setTitleJustification(TitledBorder.LEFT);
		border2.setTitlePosition(TitledBorder.CENTER);
		information.setBorder(border2);

		// buttons in info section
		information.setLayout(new BoxLayout(information, BoxLayout.X_AXIS));
		title = new JLabel();
		title.setText("Title:    ");
		information.add(title);
		author = new JLabel("Author:    ");
		information.add(author);

		// page number section
		pageNumber = new JLabel("Page:  ");
		information.add(pageNumber);

		// content area
		readBook = new JTextArea();
		
		// bottom navigation
		JPanel navigation = new JPanel();
		add(navigation, BorderLayout.SOUTH);
		TitledBorder border1 = new TitledBorder("navigation");
		border1.setTitleJustification(TitledBorder.LEFT);
		border1.setTitlePosition(TitledBorder.CENTER);
		navigation.setBorder(border1);

		// bottom nav button
		JButton pageUp = new JButton("Page Up");
		JButton pageDown = new JButton("Page Down");
		navigation.add(pageUp);
		pageUp.addActionListener(new PageUpListener());
		navigation.add(pageDown);
		pageDown.addActionListener(new PageDownListener());

		// scroll pane
		bookWindow = new JScrollPane(readBook); // JTextArea that you add to a scrollPane
		bookWindow.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		bookWindow.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		TitledBorder border = new TitledBorder("Content");
		border.setTitleJustification(TitledBorder.LEFT);
		border.setTitlePosition(TitledBorder.CENTER);
		bookWindow.setBorder(border);

		add(bookWindow, BorderLayout.CENTER);

		// make scroll to use for paging and movements
		// scroll = new JScrollBar();

		// scroll = bookWindow.getVerticalScrollBar();

	}

	public void setText(String text) {
		readBook.setText(text);
		readBook.setCaretPosition(0);
		readBook.invalidate();
		bookWindow.revalidate();
	}

	public void setBookTitle(String name) {
		this.bookTitle = name;
		title.setText("Title:  " + bookTitle + "  ");
	}

	public void setBookAuthor(String BookAuthor) {
		this.bookAuthor = BookAuthor;
		author.setText("Author:  " + bookAuthor + "  ");
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setPageNumber() { // this still isnt working

		// int p = scroll.getMinimum() - scroll.getMaximum();
		// System.out.println(p);

		// JScrollBar scroll1 = bookWindow.getVerticalScrollBar();

		double p = scroll.getMaximum();
		double o = scroll.getBlockIncrement(1);

		double paging = (p / o);
		System.out.println(p);
		System.out.println(o);
		pageNumber.setText("Page: 1/" + paging);

		// int p = scroll.getValue();
		// System.out.println(p);

	}

	public void setBook(Book b) {
		setText(b.getText());
		setBookTitle(b.getTitle());
		setBookAuthor(b.getAuthor());
		Runnable getPages = new Runnable() {
		     public void run() {
		    	 	double r = bookWindow.getVerticalScrollBar().getMaximum();
		    	 	System.out.println(r);
		     }
		 };

		 SwingUtilities.invokeLater(getPages);
		
		// double p = scroll1.getMaximum();

		// setPageNumber();
		// revalidate();

	}

	private class PageUpListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("you click page up ");
			scroll.setValue(scroll.getValue() - scroll.getBlockIncrement(1));

		}

	}

	private class PageDownListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("you click page down ");
			scroll.setValue(scroll.getValue() + scroll.getBlockIncrement(1));

		}

	}

}
