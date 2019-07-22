import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class ReaderPanel extends JPanel {
	private JLabel label;
	
	public ReaderPanel(String string) {
		label = new JLabel(string);
		add(label);
		this.setLayout(new BorderLayout());
		
		//top infor area
		JPanel information = new JPanel();
		add(information, BorderLayout.NORTH);
		TitledBorder border2 = new TitledBorder("information");
		border2.setTitleJustification(TitledBorder.LEFT);
		border2.setTitlePosition(TitledBorder.CENTER);
		information.setBorder(border2);
		
		
		// content area
		JPanel readBook = new JPanel();
		add(readBook, BorderLayout.CENTER);
		TitledBorder border = new TitledBorder("Content");
		border.setTitleJustification(TitledBorder.LEFT);
		border.setTitlePosition(TitledBorder.CENTER);
		readBook.setBorder(border);
		
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
		JScrollPane bookWindow = new JScrollPane(readBook);
		bookWindow.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		bookWindow.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(bookWindow, BorderLayout.CENTER);
		
		
		
		
		
		
		
		
		
		
	}

}
