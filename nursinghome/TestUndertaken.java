import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class TestUndertaken extends JFrame implements ActionListener
{
JLabel lblpatientid=new JLabel("Patient id");
TextField txtpatientid=new TextField(15);
JLabel lblpatientname=new JLabel("Patient Name");
TextField txtpatientname=new TextField(15);
JLabel lblcontact=new JLabel("Contact");
TextField txtcontact=new TextField(15);
JLabel lbltestid=new JLabel("Test id");
TextField txttestid=new TextField(15);
JLabel lbltestinfo=new JLabel("Test Information");
TextField txttestinfo=new TextField(15);
JLabel lbldate=new JLabel("Date");
TextField txtdate=new TextField(15);
JLabel lblamount=new JLabel("Amount");
TextField txtamount=new TextField(15);
JButton btnnew=new JButton("New");
JButton btnsave=new JButton("Save");
JButton btnsearch=new JButton("Search");
JButton btnedit=new JButton("Edit");
JButton btncancel=new JButton("Cancel");
		public TestUndertaken()
		{
	setVisible(true);
	setLayout(null);
	setSize(1000,1000);
	lblpatientid.setBounds(20,20,80,20);
	txtpatientid.setBounds(120,20,75,20);
	lblpatientname.setBounds(20,50,80,20);
	txtpatientname.setBounds(120,50,75,20);
	lblcontact.setBounds(20,80,80,20);
	txtcontact.setBounds(120,80,75,20);
	lbltestid.setBounds(20,110,80,20);
	txttestid.setBounds(120,110,75,20);
	lbltestinfo.setBounds(20,140,120,20);
	txttestinfo.setBounds(120,140,75,20);
	lbldate.setBounds(20,170,80,20);
	txtdate.setBounds(120,170,75,20);
	lblamount.setBounds(20,200,80,20);
	txtamount.setBounds(120,200,75,20);
	btnnew.setBounds(20,250,80,25);
	btnsave.setBounds(120,250,80,25);
	btnsearch.setBounds(220,250,80,25);
	btnedit.setBounds(320,250,80,25);
	btncancel.setBounds(420,250,80,25);
	add(lblpatientid);
	add(txtpatientid);
	add(lblpatientname);
	add(txtpatientname);
	add(lblcontact);
	add(txtcontact);
	add(lbltestid);
	add(txttestid);
	add(lbltestinfo);
	add(txttestinfo);
	add(lbldate);
	add(txtdate);
	add(lblamount);
	add(txtamount);
	add(btnnew);
	add(btnsave);
	add(btnsearch);
	add(btnedit);
	add(btncancel);
	btnnew.addActionListener(this);
	btnsave.addActionListener(this);
	btnsearch.addActionListener(this);
	btnedit.addActionListener(this);
	btncancel.addActionListener(this);
	
		}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btnnew)
			{
				btnsave.setEnabled(true);
				txtpatientid.setText("");
				txtpatientname.setText("");
				txtcontact.setText("");
				txttestid.setText("");
				txttestinfo.setText("");
				txtdate.setText("");
				txtamount.setText("");
				try
				{
			Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
			Statement st=con.createStatement();
			String str="select  pid from keytbl";
			ResultSet res=st.executeQuery(str);
				}
				catch(Exception ee)
				{
					System.out.println(ee);
				}
			}
			if(e.getSource()==btnsave)
			{}
		    if(e.getSource()==btnsearch)
			{}
			if(e.getSource()==btnedit)
			{}
            if(e.getSource()==btncancel)
			{}

			
		}
		public static void main(String args[])
		{
			TestUndertaken obj=new TestUndertaken();
		}
}