import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Test extends JFrame implements ActionListener
{
JLabel lbltestid=new JLabel("Test id");
TextField txttestid=new TextField(25);
JLabel lbltestname=new JLabel("Test Name");
TextField txttestname=new TextField(30);
JLabel lbltestcharge=new JLabel("Test charge");
TextField txttestcharge=new TextField(25);
JLabel lbltestdescription=new JLabel("Test Description");
TextField txttestdescription=new TextField(30);
JButton btnnew=new JButton("New");
JButton btnsave=new JButton("Save");
JButton btnsearch=new JButton("Search");
JButton btnedit=new JButton("Edit");
JButton btncancel=new JButton("Cancel");
   	public Test()
	{
	setVisible(true);
	setLayout(null);
	setSize(1000,1000);
	lbltestid.setBounds(20,50,100,25);
	lbltestname.setBounds(20,100,100,25);
	lbltestcharge.setBounds(20,150,100,25);
	lbltestdescription.setBounds(20,200,100,25);
	txttestid.setBounds(150,50,100,25);
	txttestname.setBounds(150,100,200,25);
	txttestcharge.setBounds(150,150,100,25);
	txttestdescription.setBounds(150,200,250,75);
	btnnew.setBounds(20,300,80,25);
	btnsave.setBounds(120,300,80,25);
	btnsearch.setBounds(220,300,100,25);
	btnedit.setBounds(340,300,100,25);
	btncancel.setBounds(460,300,100,25);
	add(lbltestid);
	add(lbltestname);
	add(lbltestcharge);
	add(lbltestdescription);
	add(txttestid);
	add(txttestname);
	add(txttestcharge);
	add(txttestdescription);
	add(btnnew);
	add(btnsave);
	add(btnsearch);
	add(btnedit);
	add(btncancel);
	btnsave.setEnabled(false);
	btnedit.setEnabled(false);
	btnnew.addActionListener(this);
	btnsave.addActionListener(this);
	btnsearch.addActionListener(this);
	btnedit.addActionListener(this);
	btncancel.addActionListener(this);
	}


public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==btncancel)
	{
		this.dispose();
	}
	if(e.getSource()==btnedit)
	{
		try
		{
			int flg=0;
		Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
		Statement st=con.createStatement();
		String str="update testtbl set testname='"+txttestname.getText()
		+"', testdiscription='"+txttestdescription.getText()
		+"', testcharge='"+txttestcharge.getText()+"' where testid='"+txttestid.getText()+"'";
    	st.executeUpdate(str);
		JOptionPane.showMessageDialog(null,"Record Updated");
		btnedit.setEnabled(false);
		
	}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
	if(e.getSource()==btnsearch)
	{
		int flg=0;
		try
		{
			btnedit.setEnabled(true);
		Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
		Statement st=con.createStatement();
		String ttestid=JOptionPane.showInputDialog("Enter testid:");
		String str="Select * from testtbl where testid='" +ttestid+"'";
		ResultSet res=st.executeQuery(str);
		while(res.next())
		{
			txttestid.setText(res.getString(1));
			txttestname.setText(res.getString(2));
			txttestcharge.setText(res.getString(3));
			txttestdescription.setText(res.getString(4));
			flg=1;
		}
		if(flg==0)
		{
		JOptionPane.showMessageDialog(null,"No such record found");
		}
		}
  		catch(Exception ee)		
		{
			System.out.println(ee);
		}
	}
	if(e.getSource()==btnnew)
	{
		btnsave.setEnabled(true);
	txttestid.setText("");
	txttestname.setText("");
	txttestcharge.setText("");
	txttestdescription.setText("");
  	try
    	{
		Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
		Statement st=con.createStatement();
		String str="select * from keytbl";
		ResultSet res=st.executeQuery(str);
		while(res.next())
		{
			txttestid.setText("T/"+res.getString(1));
		}
	}
	catch(Exception ee)
	{
		System.out.println(ee);
	}
               }
               if(e.getSource()==btnsave)
	{
		try
		{
			int flg=0;
			Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
			Statement st=con.createStatement();
			String str1="select * from testtbl where testid='"+txttestid.getText()+"'";
			ResultSet res1=st.executeQuery(str1);
			while(res1.next())
			{
				flg=1;
			}
			if(flg==0)
			{
				if(txttestid.getText().length()!=0&&txttestname.getText().length()!=0&&txttestcharge.getText().length()!=0&&txttestdescription.getText().length()!=0)
				{
			String str="insert into testtbl(testid,testname,testcharge,testdiscription)values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(str);
			ps.setString(1,txttestid.getText());
			ps.setString(2,txttestname.getText());
			ps.setString(3,txttestcharge.getText());
			ps.setString(4,txttestdescription.getText());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null,"Saved Successfully");
			btnsave.setEnabled(false);
			Statement st1=con.createStatement();
			String str2="update keytbl set tid=tid+1";
			st1.executeUpdate(str2);
			}
			else
			{
					JOptionPane.showMessageDialog(null,"Please fill details");
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Already Exist.");
			}
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
}
public static void main(String args[])
{
Test obj=new Test();
}
}