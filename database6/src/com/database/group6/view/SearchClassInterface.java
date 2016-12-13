package com.database.group6.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.database.group6.dao.CourseDao;
import com.database.group6.dao.StucourseDao;
import com.database.group6.po.Course;
import com.database.group6.po.Stucourse;
import com.database.group6.util.DBHelper;
import com.database.group6.util.StringHelper;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class SearchClassInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTable table;
	public static String coursenum; 
	private String coursetime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchClassInterface frame = new SearchClassInterface();
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
	public SearchClassInterface() {
		setTitle("Student Search Class");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourseSearch = new JLabel("COURSE SEARCH:");
		lblCourseSearch.setBounds(111, 17, 134, 16);
		contentPane.add(lblCourseSearch);
		
		textField_1 = new JTextField();
		textField_1.setBounds(311, 11, 276, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String allcourse = textField_1.getText();
				if (StringHelper.isEmpty(allcourse)) {
					JOptionPane.showMessageDialog(null, "Empty input!");
					table.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"CourseNum", "CourseName", "Teacher", "Major", "CourseCredit","CourseTime"
							}));
					return;
				} 
				Double n=-1.0;
				try {
				    Double.parseDouble(allcourse); 
				    n=Double.parseDouble(allcourse);
				} catch (Exception e1) {
				}
				Course course=new Course(allcourse,allcourse,allcourse,allcourse,n,allcourse);
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.setRowCount(0);
				Connection con=null;
				DBHelper dbhelper = new DBHelper();
				try {
					con = dbhelper.getCon();
					ResultSet rs = CourseDao.courseList(con, course);
						while (rs.next()) {
							Vector v = new Vector();
							v.add(rs.getString("CourseNum"));
							v.add(rs.getString("CourseName"));
							v.add(rs.getString("TeacherNum"));
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
		btnNewButton.setBounds(679, 12, 94, 29);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 45, 841, 210);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int row = table.getSelectedRow();
				coursenum = (String) table.getValueAt(row, 0);
				coursetime= (String) table.getValueAt(row, 5);
			}
		});
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"CourseNum", "CourseName", "Teacher", "Major", "CourseCredit","CourseTime"
				}){
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false, false};

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2){
				int row = table.getSelectedRow();
				coursenum = (String) table.getValueAt(row, 0);
				StudentOverview m = new StudentOverview();
				m.setVisible(true);
				dispose();
			}
			}		
		});
		
		scrollPane.setViewportView(table);
		
		JButton btnAddToThe = new JButton("ADD COURSE");
		btnAddToThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount = table.getSelectedRowCount();
				if(rowCount==0){
					JOptionPane.showMessageDialog(null, "Please choose a course!");
					return;
				}
				Connection con = null;
				DBHelper dbhelper = new DBHelper();
				String userName = AdminInterface.textField.getText();
				Stucourse stucourse=new Stucourse(userName,coursenum);
				try {
					con = dbhelper.getCon();
					ResultSet rs = StucourseDao.stucourseList(con, userName);
					while(rs.next()){
						if(coursetime.equals(rs.getString("CourseTime"))){
							JOptionPane.showMessageDialog(null, "Time conflict or already chosen!");
							return;
						}
					}
					int flag = StucourseDao.stucourseAdd(con,stucourse);
					if (flag == 1) {
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
		
		btnAddToThe.setBounds(388, 267, 142, 29);
		contentPane.add(btnAddToThe);
		
		JButton btnExit = new JButton("BACK");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentInterface m = new StudentInterface();
				m.setVisible(true);
				dispose();
			}
		});
		
		btnExit.setBounds(652, 267, 134, 29);
		contentPane.add(btnExit);
		
		JButton btnShowAllCourses = new JButton("SHOW ALL COURSES");
		btnShowAllCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.setRowCount(0);
				Connection con = null;
				DBHelper dbhelper = new DBHelper();
				Course course=new Course();
				try {
					con = dbhelper.getCon();
					ResultSet rs = CourseDao.allcourseList(con, course);
					while (rs.next()) {
						Vector v = new Vector();
						v.add(rs.getString("CourseNum"));
						v.add(rs.getString("CourseName"));
						v.add(rs.getString("TeacherNum"));
						v.add(rs.getString("MajorNum"));
						v.add(rs.getString("CourseCredit"));
						v.add(rs.getString("CourseTime"));
						dtm.addRow(v);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
			}
		});
		btnShowAllCourses.setBounds(99, 267, 151, 29);
		contentPane.add(btnShowAllCourses);
	}
}
