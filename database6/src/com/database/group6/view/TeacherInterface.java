package com.database.group6.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.database.group6.dao.CourseDao;
import com.database.group6.dao.StucourseDao;
import com.database.group6.util.DBHelper;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class TeacherInterface extends JFrame {

	private JPanel contentPane;
	private JTable table;
    public static String coursenum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherInterface frame = new TeacherInterface();
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
	public TeacherInterface() {
		setTitle("Professor Schedule");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 26, 707, 193);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2){
				int row = table.getSelectedRow();
				coursenum = (String) table.getValueAt(row, 0);
				ProfessorOverview m = new ProfessorOverview();
				m.setVisible(true);
				dispose();
			}
			}		
		});
	
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"CourseNum", "CourseName", "Major", "CourseCredit","CourseTime"
				}){
			boolean[] canEdit = new boolean[] { false, false, false,
					false, false};

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminInterface m = new AdminInterface();
				m.setVisible(true);
				dispose();
			}
		});
		
		scrollPane.setViewportView(table);
		
		btnBack.setBounds(502, 231, 143, 29);
		contentPane.add(btnBack);
		
		JButton btnNewButton = new JButton("SHOW ALL COURSES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = AdminInterface.textField.getText();
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.setRowCount(0);
				Connection con=null;
				DBHelper dbhelper = new DBHelper();
				try {
					con = dbhelper.getCon();
					ResultSet rs = CourseDao.professorList(con, userName);
					while (rs.next()) {
						Vector v = new Vector();
						v.add(rs.getString("CourseNum"));
						v.add(rs.getString("CourseName"));
						v.add(rs.getString("MajorNum"));
						v.add(rs.getString("CourseCredit"));
						v.add(rs.getString("CourseTime"));
						dtm.addRow(v);
					}	
				}catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	});
		btnNewButton.setBounds(90, 231, 160, 29);
		contentPane.add(btnNewButton);
	}
}
