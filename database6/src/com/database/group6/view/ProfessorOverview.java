package com.database.group6.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.database.group6.dao.AdministratorDao;
import com.database.group6.dao.CourseDao;
import com.database.group6.dao.StucourseDao;
import com.database.group6.po.Course;
import com.database.group6.po.Stucourse;
import com.database.group6.util.DBHelper;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class ProfessorOverview extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfessorOverview frame = new ProfessorOverview();
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
	public ProfessorOverview() {
		setTitle("Professor Course Overview");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(171, 45, 222, 150);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Connection con = null;
			DBHelper dbhelper = new DBHelper();
			Course course=new Course(textField.getText(),TeacherInterface.coursenum);
			try {
				con = dbhelper.getCon();
				int flag = CourseDao.courseDescModify(con,course);
				if (flag==1) {
					JOptionPane.showMessageDialog(null, "Success!");
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
		btnNewButton.setBounds(191, 221, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherInterface n =new TeacherInterface();
				n.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(320, 221, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblDescreption = new JLabel("DESCREPTION:");
		lblDescreption.setBounds(49, 45, 110, 16);
		contentPane.add(lblDescreption);
		
		JButton btnShowDescreption = new JButton("SHOW DESCREPTION");
		btnShowDescreption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				DBHelper dbhelper = new DBHelper();
				//String coursenum = AdminInterface.textField.getText();
				//Stucourse stucourse=new Stucourse(userName,coursenum);
				try {
					con = dbhelper.getCon();
					ResultSet rs = CourseDao.courseDesc(con,TeacherInterface.coursenum);
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
		btnShowDescreption.setBounds(6, 221, 173, 29);
		contentPane.add(btnShowDescreption);
		}
}


	

