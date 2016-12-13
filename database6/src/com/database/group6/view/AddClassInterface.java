package com.database.group6.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.database.group6.util.DBHelper;
import com.database.group6.util.StringHelper;
import com.database.group6.dao.CourseDao;
import com.database.group6.po.Course;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class AddClassInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;
	private JButton btnReset;
	private JButton btnPublish;
	private JButton btnBack;
	private JLabel lblMajorNumber;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddClassInterface frame = new AddClassInterface();
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
	public AddClassInterface() {
		setTitle("ADD COURSE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourseId = new JLabel("COURSE NUMBER:");
		lblCourseId.setBounds(62, 22, 113, 16);
		contentPane.add(lblCourseId);
		
		JLabel lblCourseName = new JLabel("COURSE NAME:");
		lblCourseName.setBounds(62, 50, 113, 28);
		contentPane.add(lblCourseName);
		
		JLabel lblNewLabel = new JLabel("COURSE CREDIT:");
		lblNewLabel.setBounds(62, 157, 113, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(267, 16, 134, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(267, 50, 134, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(267, 84, 134, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSchedule = new JLabel("SCHEDULE：");
		lblSchedule.setBounds(62, 185, 97, 22);
		contentPane.add(lblSchedule);
	
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MON: 8:00AM-10:00AM", "MON: 10:00AM-12:00PM", "MON: 1:00PM-3:00PM", "MON: 3:00PM-5:00PM", "MON: 6:00PM-9:00PM", "TUE: 8:00AM-10:00AM", "TUE: 10:00AM-12:00PM", "TUE: 1:00PM-3:00PM", "TUE: 3:00PM-5:00PM", "TUE: 6:00PM-9:00PM", "WED: 8:00AM-10:00AM", "WED: 10:00AM-12:00PM", "WED: 1:00PM-3:00PM", "WED: 3:00PM-5:00PM", "WED: 6:00PM-9:00PM", "THU: 8:00AM-10:00AM", "THU: 10:00AM-12:00PM", "THU: 1:00PM-3:00PM", "THU: 3:00PM-5:00PM", "THU: 6:00PM-9:00PM", "FRI: 8:00AM-10:00AM", "FRI: 10:00AM-12:00PM", "FRI: 1:00PM-3:00PM", "FRI: 3:00PM-5:00PM", "FRI: 6:00PM-9:00PM"}));
		comboBox.setSelectedIndex(-1);
		comboBox.setToolTipText("");
		//comboBox.setToolTipText("Mon: 10:00-12:00PM");
		comboBox.setMaximumRowCount(24);
		comboBox.setBounds(267, 184, 199, 27);
		contentPane.add(comboBox);
		
		btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				comboBox.setSelectedIndex(-1);
			}
		});
		btnReset.setBounds(35, 231, 117, 29);
		contentPane.add(btnReset);
		
		btnPublish = new JButton("PUBLISH");
		btnPublish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String coursenumber = textField.getText();
				String coursename = textField_1.getText();
				String teachernumber = textField_2.getText();
				String majornumber = textField_3.getText();
				String coursecredit = textField_4.getText();
				if (StringHelper.isEmpty(coursenumber)) {
					JOptionPane.showMessageDialog(null, "Empty coursenumber!");
					return;
				}
				if (StringHelper.isEmpty(coursename)) {
					JOptionPane.showMessageDialog(null, "Empty coursename!");
					return;
				}
				if (StringHelper.isEmpty(teachernumber)) {
					JOptionPane.showMessageDialog(null, "Empty teachernumber!");
					return;
				}
				if (StringHelper.isEmpty(majornumber)) {
					JOptionPane.showMessageDialog(null, "Empty majornumber!");
					return;
				}
				if (StringHelper.isEmpty(coursecredit)) {
					JOptionPane.showMessageDialog(null, "Empty coursecredit!");
					return;
				}else{
					try {
					    Double.parseDouble(coursecredit); 
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Wrong coursecredit!");
						return;
					}
				}
				if(comboBox.getSelectedIndex()==-1){
					JOptionPane.showMessageDialog(null, "Please choose a schedule!");
					return;
				}
				String schedule = comboBox.getSelectedItem().toString();
				Course course=new Course(coursenumber,coursename,teachernumber,majornumber,Float.parseFloat(coursecredit),schedule);
				Connection con=null;
				DBHelper dbhelper = new DBHelper();
				try {
					con = dbhelper.getCon();
					int n=CourseDao.courseAdd(con, course);
					if(n==1){
						JOptionPane.showMessageDialog(null, "Success!");
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						comboBox.setSelectedIndex(-1);
						return;
					}else{
						JOptionPane.showMessageDialog(null, "Fail!");
						return;
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Encounter a problem!");
					return;
				}
			}
		});
		btnPublish.setBounds(209, 231, 117, 29);
		contentPane.add(btnPublish);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministraterInterface jf= new AdministraterInterface();
				jf.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(360, 231, 117, 29);
		contentPane.add(btnBack);
		
		JLabel lblTeacher = new JLabel("TEACHER NUMBER:");
		lblTeacher.setBounds(62, 83, 123, 28);
		contentPane.add(lblTeacher );
		
		lblMajorNumber = new JLabel("MAJOR NUMBER:");
		lblMajorNumber.setBounds(62, 118, 113, 27);
		contentPane.add(lblMajorNumber);
		
		textField_3 = new JTextField();
		textField_3.setBounds(267, 118, 134, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(267, 152, 134, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}
}
