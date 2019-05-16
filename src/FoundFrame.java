import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FoundFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoundFrame frame = new FoundFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FoundFrame() {
		
		setTitle("List of Students Found");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 56, 414, 195);
		contentPane.add(textArea);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setBounds(10, 13, 414, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
	}
	
	public void setFieldArea(String msg)
	{
		textField.setText("List of students found" + " under " + msg);
	}
	
	public void displayFound(ArrayList<Student> found)
	{
		String textAr = "";
		for(int i = 0; i < found.size(); i++)
		{
			Student stu = found.get(i);
			textAr += stu.getName() + "\n" + stu.getId() + "\n";
		}
		textArea.setText(textAr);
	}
	
	public void noneFound()
	{
		textArea.setText("No students found");
	}
}
