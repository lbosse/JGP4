import java.awt.BorderLayout;
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



		libraryPane = new JScrollPane(listPanel);
		libraryPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		libraryPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(libraryPane, BorderLayout.CENTER);
		add(loadLibraryPanel, BorderLayout.SOUTH);
		//add(label, BorderLayout.NORTH);




	}


}
