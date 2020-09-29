//import java.awt.*; 
//import javax.swing.*; 
//import java.awt.event.*; 
//public class progressbar extends JFrame {
//	public progressbar() {
//	} 
//  
//    // create a frame 
//    static JFrame f; 
//  
//    static JProgressBar b; 
//  
//    public static void main(String args[]) 
//    { 
//  
//        // create a frame 
//        f = new JFrame("ProgressBar demo"); 
//  
//        // create a panel 
//        JPanel p = new JPanel(); 
//  
//        // create a progressbar 
//        b = new JProgressBar(); 
//  
//        // set initial value 
//        b.setValue(0); 
//  
//        b.setStringPainted(true); 
//  
//        // add progressbar 
//        p.add(b); 
//  
//        // add panel 
//        f.getContentPane().add(p); 
//  
//        // set the size of the frame 
//        f.setSize(500, 500); 
//        f.setVisible(true); 
//  
//        fill(); 
//    } 
//  
//    // function to increase progress 
//    public static void fill() 
//    { 
//        int i = 0; 
//        try { 
//            while (i <= 100) { 
//                // fill the menu bar 
//                b.setValue(i + 10); 
//  
//                // delay the thread 
//                Thread.sleep(500); 
//                i += 1; 
//            } 
//        } 
//        catch (Exception e) { 
//        } 
//    } 
//} 


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class progressbar extends JFrame {

	private JPanel contentPane;
	private int counter=0;

	JProgressBar progressBarJava;
	JProgressBar progressBarCpp;
	JProgressBar progressBarSql;
	Dashborad1 dash;
	

	public progressbar(Dashborad1 dash) {
		this.dash = dash;
		setTitle("It's Quiz Time - Progress - "+ dash.uname);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500,500);
		contentPane = new JPanel();
		
		
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBarJava = new JProgressBar();
		//progressBar_1.setIndeterminate(true);
		progressBarJava.setBackground(Color.WHITE);
		progressBarJava.setStringPainted(true);
		progressBarJava.setMaximum(getQuestionCount("java"));
		progressBarJava.setValue(0);
		progressBarJava.setForeground(new Color(255, 69, 0));
		progressBarJava.setBounds(190, 122, 276, 32);
		contentPane.add(progressBarJava);
		
		progressBarCpp = new JProgressBar();
		//progressBar_2.setIndeterminate(true);
		progressBarCpp.setBackground(Color.WHITE);
		progressBarCpp.setValue(0);
		progressBarCpp.setStringPainted(true);
		progressBarCpp.setMaximum(getQuestionCount("cpp"));
		progressBarCpp.setForeground(Color.GREEN);
		progressBarCpp.setBounds(190, 177, 276, 32);
		contentPane.add(progressBarCpp);
		
		progressBarSql = new JProgressBar();
		//progressBar_3.setIndeterminate(true);
		progressBarSql.setBackground(Color.WHITE);
		progressBarSql.setValue(0);
		progressBarSql.setStringPainted(true);
		progressBarSql.setMaximum(getQuestionCount("sql"));
		progressBarSql.setForeground(new Color(138, 43, 226));
		progressBarSql.setBounds(190, 231, 276, 32);
		contentPane.add(progressBarSql);
		
		JLabel lblJava = new JLabel("JAVA");
		lblJava.setHorizontalAlignment(SwingConstants.LEFT);
		lblJava.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblJava.setBounds(68, 122, 102, 25);
		contentPane.add(lblJava);
		
		JLabel lblCpp = new JLabel("CPP");
		lblCpp.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpp.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblCpp.setBounds(68, 177, 102, 25);
		contentPane.add(lblCpp);
		
		JLabel lblSql = new JLabel("SQL");
		lblSql.setHorizontalAlignment(SwingConstants.LEFT);
		lblSql.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblSql.setBounds(68, 231, 102, 25);
		contentPane.add(lblSql);
		
		JLabel lblEligibleJava = new JLabel("You Are eligible to create quiz of JAVA");
		lblEligibleJava.setForeground(new Color(255, 69, 0));
		lblEligibleJava.setHorizontalAlignment(SwingConstants.LEFT);
		lblEligibleJava.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblEligibleJava.setBounds(108, 290, 305, 25);
		lblEligibleJava.setVisible(false);
		contentPane.add(lblEligibleJava);
		
		JLabel lblEligibleCpp = new JLabel("You Are eligible to create quiz of CPP");
		lblEligibleCpp.setForeground(Color.GREEN);
		lblEligibleCpp.setHorizontalAlignment(SwingConstants.LEFT);
		lblEligibleCpp.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblEligibleCpp.setBounds(108, 331, 305, 25);
		lblEligibleCpp.setVisible(false);
		contentPane.add(lblEligibleCpp);
		
		JLabel lblEligibleSql = new JLabel("You Are eligible to create quiz of SQL");
		lblEligibleSql.setForeground(new Color(138, 43, 226));
		lblEligibleSql.setHorizontalAlignment(SwingConstants.LEFT);
		lblEligibleSql.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblEligibleSql.setBounds(108, 367, 305, 25);
		lblEligibleSql.setVisible(false);
		contentPane.add(lblEligibleSql);
		
		JLabel lblProgressTitle = new JLabel("PROGRESS");
		lblProgressTitle.setForeground(Color.WHITE);
		lblProgressTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgressTitle.setFont(new Font("Arial Rounded MT Bold", Font.BOLD | Font.ITALIC, 33));
		lblProgressTitle.setBounds(165, 32, 276, 39);
		contentPane.add(lblProgressTitle);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(progressbar.class.getResource("/images/rising (2) (2).png")));
		lblNewLabel.setBounds(49, 0, 92, 100);
		contentPane.add(lblNewLabel);
		
		JLabel lblProgressBack = new JLabel("New label");
		lblProgressBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblProgressBack.setIcon(new ImageIcon(progressbar.class.getResource("/images/SignupBackground.jpg")));
		lblProgressBack.setBounds(0, 0, 492, 100);
		contentPane.add(lblProgressBack);
		
		JButton btnCreateQuiz = new JButton("Create Quiz");
		btnCreateQuiz.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnCreateQuiz.setBackground(Color.WHITE);
		btnCreateQuiz.setForeground(Color.BLUE);
		btnCreateQuiz.setBounds(54, 419, 171, 39);
		contentPane.add(btnCreateQuiz);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dash.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(Color.BLUE);
		btnBack.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(295, 419, 171, 39);
		contentPane.add(btnBack);
	
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(progressBarCpp.getPercentComplete() >= 0.5) {
					
					lblEligibleCpp.setVisible(true);
				}
				if(progressBarJava.getPercentComplete() >= 0.5) {
					lblEligibleJava.setVisible(true);
				}
				if(progressBarSql.getPercentComplete() >= 0.5) {
					lblEligibleSql.setVisible(true);
				}
			}
		});
	
	}
	public void progressBarFill(int val1,int val2,int val3){
		      progressBarJava.setValue(val1);
		      progressBarCpp.setValue(val2);
		      progressBarSql.setValue(val3);
	}
	public int getQuestionCount(String lang)
	{	int questionCount=0;
		try
		{
			DBConnection conn=new DBConnection();
			Connection con=conn.conn();
			PreparedStatement stmt=con.prepareStatement("select count(question) from quiz."+lang);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				questionCount=rs.getInt(1);
				//System.out.println(ans);
				return questionCount;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return questionCount;
	}

} 
 

