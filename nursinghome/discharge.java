import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class Discharge extends JFrame implements ActionListener
{
	JLabel lblid=new JLabel("id");
	TextField txtid=new TextField(15);
	JLabel lblpatientid=new JLabel("Patient id");
	TextField txtpatientid=new TextField(15);
	JLabel lbltodaysdate=new JLabel("Today's Date");
	TextField txttodaysdate=new TextField(15);
	JLabel lblpatientname=new JLabel("Patient name");
	TextField txtpatientname=new TextField(15);
	JLabel lblcontact=new JLabel("contact");
	TextField txtcontact=new TextField(15);
	JLabel lbldate=new JLabel("Date");
	TextField txtdate=new TextField(15);
	JLabel lbltotalbill=new JLabel("Total Bill");
	TextField txttotalbill=new TextField(15);
	JLabel lbltotalpaid=new JLabel("Total Paid");
	TextField txttotalpaid=new TextField(15);
	JLabel lblamount=new JLabel("Amount to be Paid");
	TextField txtamount=new TextField(15);
	
	
	JButton btnnew=new JButton("New");
	JButton btnsave=new JButton("Save");
	JButton btnsearch=new JButton("Search");
	JButton btnedit=new JButton("Edit");
	JButton btncancel=new JButton("Cancel");
   public Discharge()
   {
	   setVisible(true);
	   setLayout(null);
	   setSize(1000,1000);
	   lblid.setBounds(20,20,25,25);
	   txtid.setBounds(70,20,25,25);
	   lbltodaysdate.setBounds(125,20,25,25);
	   txttodaysdate.setBounds(175,20,25,25);
	   lblpatientid.setBounds(20,50,25,25);
	   txtpatientid.setBounds(70,50,25,25);
	   lblpatientname.setBounds(20,80,25,25);
	   txtpatientname.setBounds(70,80,25,25);
	   lblcontact.setBounds(20,110,25,25);
	   txtcontact.setBounds(70,110,25,25);
	   lbldate.setBounds(20,140,25,25);
	   txtdate.setBounds(70,140,25,25);
	   lbltotalbill.setBounds(20,170,25,25);
	   txttotalbill.setBounds(70,170,25,25);
	   lbltotalpaid.setBounds(20,200,25,25);
	   txttotalpaid.setBounds(70,200,25,25);
	   lblamount.setBounds(20,230,25,25);
	   txtamount.setBounds(70,230,25,25);
	   
	   
	   btnnew.setBounds(20,600,30,30);
	   btnsave.setBounds(100,600,30,30);
	   btnsearch.setBounds(180,600,30,30);
	   btnedit.setBounds(160,600,30,30);
	   btncancel.setBounds(240,600,30,30);
   }
}