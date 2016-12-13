package com.database.group6.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AdministraterInterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministraterInterface frame = new AdministraterInterface();
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
	public AdministraterInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdministratorManagement = new JLabel("Administrator Management");
		lblAdministratorManagement.setBounds(156, 6, 241, 16);
		contentPane.add(lblAdministratorManagement);
		
		JButton btnAddClass = new JButton("ADD COURSE");
		btnAddClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddClassInterface jf= new AddClassInterface();
				jf.setVisible(true);
				dispose();
			}
		});
		btnAddClass.setBounds(67, 90, 145, 29);
		contentPane.add(btnAddClass);
		
		JButton btnDropCourse = new JButton("DROP COURSE");
		btnDropCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DropClassInterface jf= new DropClassInterface();
				jf.setVisible(true);
				dispose();
			}
		});
		btnDropCourse.setBounds(300, 90, 133, 29);
		contentPane.add(btnDropCourse);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminInterface jf= new AdminInterface();
				jf.setVisible(true);
				dispose();
			}
		});
		
		btnBack.setBounds(300, 198, 133, 29);
		contentPane.add(btnBack);
		
		JButton btnChangeCourse = new JButton("UPDATE COURSE");
		btnChangeCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeClassInterface jf= new ChangeClassInterface();
				jf.setVisible(true);
				dispose();
			}
		});
		btnChangeCourse.setBounds(67, 198, 145, 29);
		contentPane.add(btnChangeCourse);
	}
}
