import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class ward extends JFrame implements ActionListener
{
JLabel  lblward=new JLabel("Ward");
JComboBox cmbward=new JComboBox();
JLabel  lblnumberofbeds=new JLabel("NUMBER OF BEDS");
TextField txtnumberofbeds=new  TextField(20);
JLabel  lblcharge=new JLabel("Charge");
TextField txtcharge=new  TextField(15);
JButton btnnew=new JButton("New");
JButton btnsave=new JButton("Save");
JButton btnsearch=new JButton("Search");
JButton btnedit=new JButton("Edit");
JButton btncancel=new JButton("Cancel");
	public ward()
	{
	setVisible(true);
	setLayout(null);
	setSize(1000,1000);
	lblward.setBounds(20,50,110,15);
	lblnumberofbeds.setBounds(400,80,120,15);
	lblcharge.setBounds(400,110,100,15);
    cmbward.addItem("General Male");
	cmbward.addItem("General Female");
	cmbward.addItem("ICU");
	cmbward.addItem("CCU");
	cmbward.setBounds(200,50,150,20);
	txtnumberofbeds.setBounds(600,80,100,25);
	txtcharge.setBounds(600,110,100,25);
	btnnew.setBounds(20,150,100,25);
	btnsave.setBounds(150,150,100,25);
	btnsearch.setBounds(280,150,100,25);
	btnedit.setBounds(410,150,100,25);
	btncancel.setBounds(540,150,100,25);
	add(lblward);
	add(lblnumberofbeds);
	add(lblcharge);
	add(cmbward);
	add(txtnumberofbeds);
	add(txtcharge);
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
	if(e.getSource()==btnnew)
	{
		btnsave.setEnabled(true);
	txtnumberofbeds.setText("");
	txtcharge.setText("");	
  	}

	if(e.getSource()==btnsave)
	{
		int i,x;
		try
		{
			int flg=0;
			Connection con1=DriverManager.getConnection("jdbc:odbc:nursingdsn");
			Statement st=con1.createStatement();
			String str2="select * from wardtbl where ward='"+cmbward.getSelectedItem()+"'";
			ResultSet res1=st.executeQuery(str2);
			while(res1.next())
			{
				flg=1;
			}
			if(flg==0)
			{
				String str1="insert into wardtbl values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				Connection con=DriverManager.getConnection("jdbc:odbc:Nursingdsn");
				PreparedStatement ps1=con.prepareStatement(str1);
				ps1.setString(1,""+cmbward.getSelectedItem());
		x=Integer.parseInt(txtnumberofbeds.getText());
		for(i=2;i<=x+1;i++)
		{
			ps1.setString(i,"A");
		}
		for(i=x+2;i<=16;i++)
		{
			ps1.setString(i,"X");
		}
		ps1.setString(17,txtcharge.getText());
		ps1.executeUpdate();
			JOptionPane.showMessageDialog(null,"Saved Successfully");
			btnsave.setEnabled(false);
		    }
			else
				JOptionPane.showMessageDialog(null,"Already exists");
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
		String str="Select * from wardtbl where ward='" +cmbward.getSelectedItem()+"'";
		ResultSet res=st.executeQuery(str);
		while(res.next())
		{
			txtnumberofbeds.setText(res.getString(2));
			txtcharge.setText(res.getString(3));
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
	if(e.getSource()==btnedit)
	{
		try
		{
			int flg=0;
			Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
			Statement st=con.createStatement();
			String str1="select * from wardtbl where ward='"+cmbward.getSelectedItem()+"'";
			ResultSet res1=st.executeQuery(str1);
			while(res1.next())
			{
				flg=1;
			}
			if(flg==1)
			{
			String str="update wardtbl set Numberofbed='"+txtnumberofbeds.getText()+"',Charge='"+txtcharge.getText()+"'";
		    st.executeUpdate(str);
			JOptionPane.showMessageDialog(null,"updated");
			btnedit.setEnabled(false);
			}
			else
				JOptionPane.showMessageDialog(null,"No such record to Edited.");
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
	if(e.getSource()==btncancel)
	{
		this.dispose();
	}
	
	

}

public static void main(String args[])
{
ward obj=new ward();
}
}