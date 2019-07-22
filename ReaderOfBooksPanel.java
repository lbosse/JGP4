import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ReaderOfBooksPanel extends JPanel  {
	private ReaderPanel readerPanel;
	private LibraryPanel libraryPanel;

	public  ReaderOfBooksPanel() {
		
		this.setLayout(new BorderLayout());
		//listPanel = new ToDoListPanel("My TODO List");
		readerPanel = new ReaderPanel("Reader");
		add(readerPanel, BorderLayout.CENTER);
		TitledBorder readerBorder = new TitledBorder("Reader");
		readerBorder.setTitleJustification(TitledBorder.LEFT);
		readerBorder.setTitlePosition(TitledBorder.TOP);
		readerPanel.setBorder(readerBorder);
		
		libraryPanel = new LibraryPanel("library");
		add(libraryPanel, BorderLayout.WEST);
		TitledBorder libraryBorder = new TitledBorder("Library");
		libraryBorder.setTitleJustification(TitledBorder.LEFT);
		libraryBorder.setTitlePosition(TitledBorder.TOP);
		libraryPanel.setBorder(libraryBorder);
		
		this.setPreferredSize(new Dimension(1000, 600));	
	}
	
	
	
	
}
