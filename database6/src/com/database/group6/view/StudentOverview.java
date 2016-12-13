package com.database.group6.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.database.group6.dao.CourseDao;
import com.database.group6.util.DBHelper;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class StudentOverview extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentOverview frame = new StudentOverview();
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
	public StudentOverview() {
		setTitle("Student Course Overview");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(151, 50, 244, 124);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescreption = new JLabel("DESCREPTION:");
		lblDescreption.setBounds(37, 50, 102, 16);
		contentPane.add(lblDescreption);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchClassInterface l=new SearchClassInterface();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(260, 220, 150, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SHOW DESCREPTION");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				DBHelper dbhelper = new DBHelper();
				//String coursenum = AdminInterface.textField.getText();
				//Stucourse stucourse=new Stucourse(userName,coursenum);
				try {
					con = dbhelper.getCon();
					ResultSet rs = CourseDao.courseDesc(con,SearchClassInterface.coursenum);
					if (rs.next()) {
						textField.setText(rs.getString("CourseDesc"));
						return;	
					}else{	
						JOptionPane.showMessageDialog(null, "Failure!");
						return;
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Encounter a problem!");
					return;
				}	
			}
		});
		btnNewButton_1.setBounds(35, 220, 180, 29);
		contentPane.add(btnNewButton_1);
	}
}
