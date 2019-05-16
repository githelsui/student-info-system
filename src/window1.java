import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;

public class window1 extends JFrame {

	private IdCompleter completer;
	private JOptionPane frame;
	private Roster rosterFrame;
	private FoundFrame foundF;
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField idTextField;
	private JTextField promptTitleField;
	private JTextField titleField;
	private String myFileName;
	private JTextField introMsg1;
	private JTextField introMsg2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window1 frame = new window1();
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
	public window1() {
		setTitle("SIS");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 287, 220);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameLbl = new JLabel("Name");
		nameLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameLbl.setBounds(10, 85, 211, 20);
		contentPane.add(nameLbl);
		nameLbl.setVisible(false);
		
		JLabel idLbl = new JLabel("ID");
		idLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		idLbl.setBounds(10, 120, 211, 20);
		contentPane.add(idLbl);
		idLbl.setVisible(false);
		
		JLabel lbldigits = new JLabel("(6-Digits)");
		lbldigits.setBounds(50, 104, 81, 14);
		contentPane.add(lbldigits);
		lbldigits.setVisible(false);
		
		JLabel lbllastFirst = new JLabel("(Last, First)");
		lbllastFirst.setBounds(50, 70, 70, 14);
		contentPane.add(lbllastFirst);
		lbllastFirst.setVisible(false);
		
		introMsg1 = new JTextField();
		introMsg1.setEditable(false);
		introMsg1.setBounds(10, 83, 251, 27);
		contentPane.add(introMsg1);
		introMsg1.setColumns(10);
		introMsg1.setVisible(false);
		introMsg2 = new JTextField();
		introMsg2.setEditable(false);
		introMsg2.setColumns(10);
		introMsg2.setBounds(10, 121, 251, 27);
		contentPane.add(introMsg2);
		introMsg2.setVisible(false);
		
		promptTitleField = new JTextField();
		promptTitleField.setHorizontalAlignment(SwingConstants.CENTER);
		promptTitleField.setText("Name of text file:");
		promptTitleField.setEditable(false);
		promptTitleField.setBounds(10, 60, 251, 27);
		contentPane.add(promptTitleField);
		promptTitleField.setColumns(10);
		
		titleField = new JTextField();
		titleField.setBounds(20, 98, 222, 27);
		contentPane.add(titleField);
		titleField.setColumns(10);
		
		
		
		JLabel quoteLbl = new JLabel("\"");
		quoteLbl.setFont(new Font("Arial", Font.BOLD, 11));
		quoteLbl.setBounds(10, 107, 46, 14);
		contentPane.add(quoteLbl);
		
		JLabel txtfileLbl = new JLabel(".txt\"");
		txtfileLbl.setBounds(244, 107, 46, 14);
		contentPane.add(txtfileLbl);
		
		
		JLabel lblStudentInformationSystem = new JLabel("Student Information System");
		lblStudentInformationSystem.setForeground(Color.BLACK);
		lblStudentInformationSystem.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblStudentInformationSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentInformationSystem.setVerticalAlignment(SwingConstants.TOP);
		lblStudentInformationSystem.setBounds(26, 11, 222, 27);
		contentPane.add(lblStudentInformationSystem);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(50, 85, 211, 20);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		nameTextField.setVisible(false);
		nameTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0)
			{
				char c = arg0.getKeyChar();
						if(!(Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)))
						{
							if(!(Character.isWhitespace(c) || (c == ',')))
									{
										getToolkit().beep();
										arg0.consume();
									}
						}	
			}
		});
		
	
		
		idTextField = new JTextField();
		idTextField.setBounds(50, 120, 211, 20);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		idTextField.setVisible(false);
		idTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0)
			{
				char c = arg0.getKeyChar();
						if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)) )
						{
							getToolkit().beep();
							arg0.consume();
						}
						if(idTextField.getText().length() > 5)
						{
							getToolkit().beep();
							arg0.consume();
						}
				
			}
		});
		
		JButton findBtn = new JButton("Find Student");
		findBtn.setBounds(80, 148, 126, 23);
		contentPane.add(findBtn);
		findBtn.setVisible(false);
		
		JButton addBtn = new JButton("Add Student");
		addBtn.setBounds(80, 148, 126, 23);
		contentPane.add(addBtn);
		addBtn.setVisible(false);
		
		JButton removeBtn = new JButton("Remove");
		removeBtn.setBounds(80, 148, 126, 23);
		contentPane.add(removeBtn);
		removeBtn.setVisible(false);
		
		rosterFrame = new Roster();
		JComboBox comboBox = new JComboBox();
		comboBox.setVisible(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"select an action", "display roster", "add students", "find students", "remove students", "save & quit"}));
		comboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				JComboBox<String> combo = (JComboBox<String>) event.getSource();
				String selectedOp = (String) combo.getSelectedItem();
				
					if(selectedOp.equals("display roster"))
					{
						
						rosterFrame.setVisible(true);
						rosterFrame.setLocationRelativeTo(null);
						rosterUpdate();
					}
					else if(selectedOp.equals("add students"))
					{
						
						nameTextField.setVisible(true);
						nameLbl.setVisible(true);
						idLbl.setVisible(true);
						idTextField.setVisible(true);
						findBtn.setVisible(false);
						addBtn.setVisible(true);
						removeBtn.setVisible(true);
						introMsg1.setVisible(false);
						introMsg2.setVisible(false);
						nameTextField.setText("");
						idTextField.setText("");
						lbllastFirst.setVisible(true);
						lbldigits.setVisible(true);
						
						
					}
					else if(selectedOp.equals("find students"))
					{
						nameTextField.setVisible(true);
						nameLbl.setVisible(true);
						idLbl.setVisible(true);
						idTextField.setVisible(true);
						findBtn.setVisible(true);
						addBtn.setVisible(false);
						removeBtn.setVisible(true);
						introMsg1.setVisible(false);
						introMsg2.setVisible(false);
						nameTextField.setText("");
						idTextField.setText("");
						lbllastFirst.setVisible(true);
						lbldigits.setVisible(true);
					}
					else if(selectedOp.equals("remove students"))
					{	
						nameTextField.setVisible(true);
						nameLbl.setVisible(true);
						idLbl.setVisible(true);
						idTextField.setVisible(true);
						findBtn.setVisible(false);
						addBtn.setVisible(false);
						removeBtn.setVisible(true);
						introMsg1.setVisible(false);
						introMsg2.setVisible(false);
						nameTextField.setText("");
						idTextField.setText("");
						lbllastFirst.setVisible(true);
						lbldigits.setVisible(true);
					}
					else if(selectedOp.equals("save & quit"))
					{
						
						completer.updateFile();
						System.exit(0);
					}
					else
						JOptionPane.showMessageDialog(frame, "Please choose an option");
				}
				
			
		});
		comboBox.setBounds(80, 40, 126, 25);
		contentPane.add(comboBox);
		
		JButton enterBtn = new JButton("Enter");
		enterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!titleField.getText().equals(""))
				{
				myFileName = titleField.getText() + ".txt";
				makeAFile();
				completer = new IdCompleter(myFileName);
				
				titleField.setVisible(false);
				promptTitleField.setVisible(false);
				quoteLbl.setVisible(false);
				txtfileLbl.setVisible(false);
				comboBox.setVisible(true);
				enterBtn.setVisible(false);
				introMsg1.setVisible(true);
				introMsg2.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Please enter the name of your file.");
				}
			}
		});
		enterBtn.setBounds(80, 138, 126, 23);
		contentPane.add( enterBtn);
		enterBtn.setVisible(true);
		
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!textFieldEmpty())
				{
					Student stu = new Student(nameTextField.getText().toUpperCase(), idTextField.getText());
					if(stu.getId().length() < 6)
					{
					 fixStudentsId(stu);
					}
					addStudent(stu);
					rosterUpdate();
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Please fill out name or id before entering.");
				}
					
			}
		});

		findBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(nameTextField.getText().length() > 0)
				{
					
	
						findStudent(nameTextField.getText().toUpperCase());
						rosterUpdate();
					}
	
				
				else
				{
					JOptionPane.showMessageDialog(frame, "Please fill out name before entering.");
				}
					
			}
		});
		
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!textFieldEmpty())
				{
					Student stu = new Student(nameTextField.getText().toUpperCase(), idTextField.getText());
					if(stu.getId().length() < 6)
					{
					 fixStudentsId(stu);
					}
					removeStudent(stu);
					rosterUpdate();
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Please fill out name or id before entering.");
				}
					
			}
		});
	}
	
	
	
	private void addStudent(Student stu)
	{
	
		completer.addStudent(stu);
	}
	
	
	private void findStudent(String name)
	{
		
		foundF = new FoundFrame();
		foundF.setVisible(true);
		foundF.setLocationRelativeTo(null);
		foundF.setFieldArea(name);
		
		ArrayList<Student> found = completer.findStudent(name);
		if(found.size() >= 1)
			{
				foundF.displayFound(found);
			}
		else
			{
				foundF.noneFound();
			}
		}
	
	private void removeStudent(Student stu)
	{
		
		completer.removeStudent(stu);
	}
	
	public String getFileName()
	{
		return myFileName;
	}
	
	private void makeAFile()
	{
		File newfile = new File(getFileName());
		if(newfile.exists()){
			introMsg1.setText( getFileName() + " has been selected.");
			introMsg2.setText("Please choose an option to perform.");
		}
		else{
			
			try{
				newfile.createNewFile();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			introMsg1.setText( getFileName() + " has been created.");
			introMsg2.setText("Please choose an option to perform.");
		}
	}
		
		private void rosterUpdate()
		{
			completer = new IdCompleter(getFileName());
			if(completer.isFileEmpty() == false)
			{
			rosterFrame.getNameTextField().setText(completer.displayNames());
			rosterFrame.getIdTextField().setText(completer.displayIds());
			}
			else
			{
				rosterFrame.getNameTextField().setText("No students currently in list");
				rosterFrame.getIdTextField().setText("No students currently in list");
			}
		}
		
		private boolean textFieldEmpty()
		{
			if(idTextField.getText().equals("") || nameTextField.getText().equals(""))
			{
				return true;
			}
			return false;
		}
		
		public void fixStudentsId(Student stu)
		{
				String id = stu.getId();
				while(id.length() < 6)
				{
					id = "0" + id;
				}
				stu.setId(id);

		}
	}

