import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Roster extends JFrame {
	
	private IdCompleter completer;
	private JPanel contentPane;
	private JOptionPane frame;
	private JTextArea nameText;
	private JTextArea idText;
	private window1 thisFile;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Roster frame = new Roster();
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
	public Roster() {
		
	
		setTitle("Student Roster");
		
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Arial", Font.BOLD, 11));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(56, 35, 95, 14);
		contentPane.add(lblName);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(351, 35, 62, 14);
		contentPane.add(lblId);
		
		 nameText = new JTextArea();
		nameText.setEditable(false);
		nameText.setBounds(10, 60, 223, 647);
		contentPane.add(nameText);
		
		
		idText = new JTextArea();
		idText.setEditable(false);
		idText.setBounds(263, 60, 223, 647);
		contentPane.add(idText);
		
		
		JLabel rosterName = new JLabel("Roster");
		rosterName.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		rosterName.setBounds(206, 11, 89, 23);
		rosterName.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(rosterName);
	}
	

		
		public JTextArea getNameTextField()
		{
			return nameText;
		}
		
		public JTextArea getIdTextField()
		{
			return idText;
		}
	}
	


