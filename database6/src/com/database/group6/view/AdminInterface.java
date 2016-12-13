package com.database.group6.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.database.group6.dao.LoginDao;
import com.database.group6.po.Administrator;
import com.database.group6.po.Professor;
import com.database.group6.po.Student;
import com.database.group6.util.DBHelper;
import com.database.group6.util.StringHelper;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class AdminInterface extends JFrame {

	private JPanel contentPane;
	public static JTextField textField;
	private JPasswordField passwordField;
	public static int isDel;
	public static int isDel1;
	public static int isDel2;
	
	//JRadioButton rdbtnNewRadioButton = new JRadioButton("Student");
	//JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Professor");
	//JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Administrator");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminInterface frame = new AdminInterface();
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
	public AdminInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Record Keeping System");
		lblNewLabel.setBounds(176, 16, 210, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblAcount = new JLabel("Account:");
		lblAcount.setBounds(258, 64, 61, 16);
		contentPane.add(lblAcount);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(258, 148, 74, 16);
		contentPane.add(lblPassword);
				
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Student");
		rdbtnNewRadioButton.setBounds(70, 218, 141, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Professor");
		rdbtnNewRadioButton_1.setBounds(245, 218, 141, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		final JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Administrator");
		rdbtnNewRadioButton_2.setBounds(422, 218, 141, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		//organize a group of 3 button
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = textField.getText();
				String password = new String(passwordField.getPassword());
				if (StringHelper.isEmpty(userName)) {
					JOptionPane.showMessageDialog(null, "Empty account!");
					return;
				}
				if (StringHelper.isEmpty(password)) {
					JOptionPane.showMessageDialog(null, "Empty password!");
					return;
				}
				isDel = rdbtnNewRadioButton.isSelected()?1:0;
				isDel1 = rdbtnNewRadioButton_1.isSelected()?1:0;
				isDel2 = rdbtnNewRadioButton_2.isSelected()?1:0;
				if(isDel==0&&isDel1==0&&isDel2==0){
					JOptionPane.showMessageDialog(null, "Please choose an identity!");
					return;
				}
				Connection con = null;
				DBHelper dbhelper = new DBHelper();
				if(isDel==1){
					Student student = new Student(userName,password);
					try {
						con = dbhelper.getCon();
						Student currentStudent = LoginDao.studentlogin(con, student);
						if(currentStudent==null){
							JOptionPane.showMessageDialog(null, "Account or password is wrong!");
							return;
						}else{	
					StudentInterface jf = new StudentInterface();
					jf.setVisible(true);
					dispose();
					}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Encounter a problem!");
						return;
					}
				}
				if(isDel1==1){
					Professor professor = new Professor(userName,password);
					try {
						con = dbhelper.getCon();
						ResultSet rs = LoginDao.professorlogin(con, professor);
						if(rs.next()){
							TeacherInterface jf1= new TeacherInterface();
							jf1.setVisible(true);
							dispose();
						}else{
							JOptionPane.showMessageDialog(null, "Account or password is wrong!");
							return;
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Encounter a problem!");
						return;
					}
				}
				if(isDel2==1){
					Administrator administrator = new Administrator(userName,password);
					try {
						con = dbhelper.getCon();
						ResultSet rs = LoginDao.administratorlogin(con, administrator);
						if(rs.next()){
							AdministraterInterface jf2= new AdministraterInterface();
							jf2.setVisible(true);
							dispose();	
						}else{
							JOptionPane.showMessageDialog(null, "Account or password is wrong!");
							return;
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "ncounter a problem!");
						return;
					}
				}
			}
		});
		btnNewButton.setBounds(58, 282, 122, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
				rdbtnNewRadioButton.setSelected(true);	
			}
		});
		btnNewButton_1.setBounds(232, 282, 141, 34);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(334, 58, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(334, 142, 134, 28);
		contentPane.add(passwordField);
		
		//JLabel lblNewLabel_1 = new JLabel("New label");
		final JLabel jlHead = new JLabel("");
		jlHead.setIcon(new ImageIcon(AdminInterface.class.getResource("/com/database/group6/view/u303533296Aou4oVnO.jpg")));
		jlHead.setBounds(48, 76, 149, 117);
		contentPane.add(jlHead);
		jlHead.setBounds(48, 52, 163, 141);
		contentPane.add(jlHead);
		
		JButton btnModifyPassword = new JButton("Modify Password");
		btnModifyPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = textField.getText();
				String password = new String(passwordField.getPassword());
				if (StringHelper.isEmpty(userName)) {
					JOptionPane.showMessageDialog(null, "Empty account!");
					return;
				}
				if (StringHelper.isEmpty(password)) {
					JOptionPane.showMessageDialog(null, "Empty password!");
					return;
				}
				isDel = rdbtnNewRadioButton.isSelected()?1:0;
				isDel1 = rdbtnNewRadioButton_1.isSelected()?1:0;
				isDel2 = rdbtnNewRadioButton_2.isSelected()?1:0;
				if(isDel==0&&isDel1==0&&isDel2==0){
					JOptionPane.showMessageDialog(null, "Please choose an identity!");
					return;
				}
				Connection con = null;
				DBHelper dbhelper = new DBHelper();
				if(isDel==1){
					Student student = new Student(userName,password);
					try {
						con = dbhelper.getCon();
						Student currentStudent = LoginDao.studentlogin(con, student);
						if(currentStudent==null){
							JOptionPane.showMessageDialog(null, "Account or password is wrong!");
							return;
						}else{	
							PasswordInterface jf= new PasswordInterface();
						    jf.setVisible(true);
						    dispose();
					}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Encounter a problem!");
						return;
					}
				}
				if(isDel1==1){
					Professor professor = new Professor(userName,password);
					try {
						con = dbhelper.getCon();
						ResultSet rs = LoginDao.professorlogin(con, professor);
						if(rs.next()){
							PasswordInterface jf= new PasswordInterface();
						    jf.setVisible(true);
						    dispose();
						}else{
							JOptionPane.showMessageDialog(null, "Account or password is wrong!");
							return;
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Encounter a problem!");
						return;
					}
				}
				if(isDel2==1){
					Administrator administrator = new Administrator(userName,password);
					try {
						con = dbhelper.getCon();
						ResultSet rs = LoginDao.administratorlogin(con, administrator);
						if(rs.next()){
							PasswordInterface jf= new PasswordInterface();
						    jf.setVisible(true);
						    dispose();
						}else{
							JOptionPane.showMessageDialog(null, "Account or password is wrong!");
							return;
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Encounter a problem!!");
						return;
					}
				}
			}
		});
		
		btnModifyPassword.setBounds(422, 282, 141, 34);
		contentPane.add(btnModifyPassword);
	}
}