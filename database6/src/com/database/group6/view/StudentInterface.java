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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StudentInterface extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String coursenum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInterface frame = new StudentInterface();
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
	public StudentInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JLabel lblStudentSchedule = new JLabel("STUDENT SCHEDULE");
		lblStudentSchedule.setBounds(384, 6, 159, 16);
		contentPane.add(lblStudentSchedule);
		
		JButton btnNewButton_1 = new JButton("DROP");
		btnNewButton_1.addActionListener(new ActionListener() {
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
					int flag = StucourseDao.stucourseDelete(con,stucourse);
					if (flag == 1) {
						JOptionPane.showMessageDialog(null, "Success!");
						DefaultTableModel dtm = (DefaultTableModel) table.getModel();
						dtm.setRowCount(0);
						Connection con1 = null;
						DBHelper dbhelper1 = new DBHelper();
						Course course=new Course();
						try {
							con1 = dbhelper1.getCon();
							ResultSet rs1 = StucourseDao.stucourseList(con, userName);
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
					}else{
						JOptionPane.showMessageDialog(null, "Failure!");
						return;
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_1.setBounds(533, 258, 92, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ADD CLASS");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchClassInterface jf = new SearchClassInterface();
				jf.setVisible(true);
				dispose();
			}
		});

		btnNewButton_2.setBounds(324, 258, 104, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("BACK");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminInterface jf = new AdminInterface();
				jf.setVisible(true);
				dispose();
			}
		});
		
		btnNewButton_3.setBounds(714, 258, 92, 29);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 34, 843, 212);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		JButton btnShowSchedule = new JButton("SHOW SCHEDULE");
		btnShowSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = AdminInterface.textField.getText();
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.setRowCount(0);
				Connection con=null;
				DBHelper dbhelper = new DBHelper();
				try {
					con = dbhelper.getCon();
					ResultSet rs = StucourseDao.stucourseList(con, userName);
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
		btnShowSchedule.setBounds(98, 258, 134, 29);
		contentPane.add(btnShowSchedule);
	}
}
