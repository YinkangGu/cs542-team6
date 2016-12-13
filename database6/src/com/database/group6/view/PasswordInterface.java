package com.database.group6.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.database.group6.dao.AdministratorDao;
import com.database.group6.dao.LoginDao;
import com.database.group6.dao.ProfessorDao;
import com.database.group6.dao.StudentDao;
import com.database.group6.po.Administrator;
import com.database.group6.po.Professor;
import com.database.group6.po.Student;
import com.database.group6.util.DBHelper;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class PasswordInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordInterface frame = new PasswordInterface();
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
	public PasswordInterface() {
		setTitle("Password Modify");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOldPassword = new JLabel("New Password:");
		lblOldPassword.setBounds(58, 66, 95, 16);
		contentPane.add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("Confirm Password:");
		lblNewPassword.setBounds(58, 136, 130, 16);
		contentPane.add(lblNewPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(218, 61, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(218, 131, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ap=textField_1.getText();
				String afp=textField_2.getText();
				String a="M";
				if(Pattern.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$",ap)){
				if(!ap.equals(afp)){
					textField_1.setText("");
					textField_2.setText("");
					JOptionPane.showMessageDialog(null, "Different Entry!");
				}
				if(ap.equals(afp)){
					String userName = AdminInterface.textField.getText();
					//String password = new String(AdminInterface.passwordField.getPassword());
					Connection con = null;
					DBHelper dbhelper = new DBHelper();
					if(AdminInterface.isDel2==1){
						Administrator admin = new Administrator(ap,userName,a);
						try {
							con = dbhelper.getCon();
							int current = AdministratorDao.passwordModify(con, admin);
							if(current==0){
								JOptionPane.showMessageDialog(null, "Failure!");
								return;
							}else{
						JOptionPane.showMessageDialog(null, "Success!");
						textField_1.setText("");
						textField_2.setText("");
						return;
						}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Encounter a problem!");
							return;
						}
					}
					if(AdminInterface.isDel1==1){
						Professor prof = new Professor(ap,userName,a);
						try {
							con = dbhelper.getCon();
							int current = ProfessorDao.passwordModify(con, prof);
							if(current==0){
								JOptionPane.showMessageDialog(null, "Failure!");
								return;
							}else{
						JOptionPane.showMessageDialog(null, "Success!");
						textField_1.setText("");
						textField_2.setText("");
						return;
						}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Encounter a problem!");
							return;
						}
					}
					if(AdminInterface.isDel==1){
						Student stu = new Student(ap,userName,a);
						try {
							con = dbhelper.getCon();
							int current = StudentDao.passwordModify(con, stu);
							
							if(current==0){
								JOptionPane.showMessageDialog(null, "Failure!");
								return;
							}else{
						JOptionPane.showMessageDialog(null, "Success!");
						textField_1.setText("");
						textField_2.setText("");
						return;
						}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Encounter a problem!");
							return;
						}
					}
				}
			}else{
				JOptionPane.showMessageDialog(null, "Password should be consisted with numbers and letters!");
				return;
			}
		}
		});
		btnConfirm.setBounds(20, 210, 117, 29);
		contentPane.add(btnConfirm);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnReset.setBounds(164, 210, 117, 29);
		contentPane.add(btnReset);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminInterface jf= new AdminInterface();
				jf.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(310, 210, 117, 29);
		contentPane.add(btnBack);
	}
}
