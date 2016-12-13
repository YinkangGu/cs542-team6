package com.database.group6.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.database.group6.dao.CourseDao;
import com.database.group6.dao.LoginDao;
import com.database.group6.dao.StucourseDao;
import com.database.group6.util.DBHelper;
import com.database.group6.util.StringHelper;
import com.database.group6.po.Course;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DropClassInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTable table;
	private String coursenum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DropClassInterface frame = new DropClassInterface();
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
	public DropClassInterface() {
		setTitle("DROP COURSE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourseSearch = new JLabel("COURSE SEARCH:");
		lblCourseSearch.setBounds(120, 17, 134, 16);
		contentPane.add(lblCourseSearch);
		
		textField_1 = new JTextField();
		textField_1.setBounds(305, 11, 319, 28);
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
		btnNewButton.setBounds(696, 12, 94, 29);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 45, 851, 211);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int row = table.getSelectedRow();
				coursenum = (String) table.getValueAt(row, 0);
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
		
		scrollPane.setViewportView(table);
		
		JButton btnDrop = new JButton("DROP");
		btnDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount = table.getSelectedRowCount();
				if(rowCount==0){
					JOptionPane.showMessageDialog(null, "Please choose a course!");
					return;
				}
				Connection con = null;
				DBHelper dbhelper = new DBHelper();
					try {
						con = dbhelper.getCon();
						ResultSet rs = StucourseDao.coursesList(con, coursenum);
						if(rs.next()){
							JOptionPane.showMessageDialog(null, "Someone chooses this course!");
							return;
						}
						int flag = CourseDao.courseDelete(con,coursenum);
						if (flag == 1) {
							JOptionPane.showMessageDialog(null, "Success!");
							DefaultTableModel dtm = (DefaultTableModel) table.getModel();
							dtm.setRowCount(0);
							Connection con1 = null;
							DBHelper dbhelper1 = new DBHelper();
							Course course=new Course();
							try {
								con1 = dbhelper1.getCon();
								ResultSet rs1 = CourseDao.allcourseList(con1, course);
								while (rs1.next()) {
									Vector v = new Vector();
									v.add(rs1.getString("CourseNum"));
									v.add(rs1.getString("CourseName"));
									v.add(rs1.getString("TeacherNum"));
									v.add(rs1.getString("MajorNum"));
									v.add(rs1.getString("CourseCredit"));
									v.add(rs1.getString("CourseTime"));
									dtm.addRow(v);
								}
							} catch (Exception e1) {
								e1.printStackTrace();
							} 
							return;
						} else {
							JOptionPane.showMessageDialog(null, "Failure!");
							return;
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Encounter a problem!");
						return;
					}
				
			}
		});
		btnDrop.setBounds(398, 268, 134, 29);
		contentPane.add(btnDrop);
		
		JButton btnExit = new JButton("BACK");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministraterInterface m = new AdministraterInterface();
				m.setVisible(true);
				dispose();
			}
		});
		
		btnExit.setBounds(686, 268, 121, 29);
		contentPane.add(btnExit);
		
		JButton btnShowAllCourse = new JButton("SHOW ALL COURSES");
		btnShowAllCourse.addActionListener(new ActionListener() {
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
		btnShowAllCourse.setBounds(101, 268, 152, 29);
		contentPane.add(btnShowAllCourse);
	}
}
