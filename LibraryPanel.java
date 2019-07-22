import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class LibraryPanel extends JPanel {
	private JLabel label;
	JScrollPane libraryPane; 
	private JButton bookButton;
	private JPanel listPanel, loadLibraryPanel;
	JTextField description = new JTextField(15);

	public LibraryPanel(String string) {
		label = new JLabel(string);
		this.setLayout(new BorderLayout());
		

		//make book list panel
		listPanel = new JPanel();
		


		bookButton = new JButton("Add Task");
		JButton bookButton2 = new JButton("Add Task");
		listPanel.add(bookButton);
		listPanel.add(bookButton2);
		TitledBorder border = new TitledBorder("Book List");
		border.setTitleJustification(TitledBorder.LEFT);
		border.setTitlePosition(TitledBorder.CENTER);
		listPanel.setBorder(border);
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		

		//import library panel
		loadLibraryPanel = new JPanel();
		loadLibraryPanel.add(description);
		JButton load = new JButton("Load File");
		TitledBorder border1 = new TitledBorder("Import File");
		border1.setTitleJustification(TitledBorder.LEFT);
		border1.setTitlePosition(TitledBorder.CENTER);
		loadLibraryPanel.setBorder(border1);
		loadLibraryPanel.add(load);
		load.addActionListener(new loadListener());



		libraryPane = new JScrollPane(listPanel);
		libraryPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		libraryPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(libraryPane, BorderLayout.CENTER);
		add(loadLibraryPanel, BorderLayout.SOUTH);
		//add(label, BorderLayout.NORTH);




	}
	
	private class loadListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
		
		String a = description.getText();
		Library lib = new Library();
		lib.loadLibraryFromCSV(a);
		
		
		for (int index = 0; index < lib.getSize(); index++) {
			//String s = lib.
			//JButton button = new JButton(lib.getBook(index).getTitle());
			BookButton button = new BookButton(lib.getBook(index));
			//Book b = new Book();
			//BookButton button = new BookButton(button.getBookButton());
			//button.addActionListener(book listner here);
			listPanel.add(button);
			System.out.println(a);
			
		}
		listPanel.revalidate();

	}

	}
	
	private class bookButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			// on click load book to bookWindow
			
			
		}
		
		
		
	}
}
