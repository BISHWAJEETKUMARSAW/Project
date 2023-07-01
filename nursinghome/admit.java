import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Admit extends JFrame implements ActionListener,FocusListener
{
	JLabel lblpatientid=new JLabel("Patient ID:");
	TextField txtpatientid=new TextField(15);
	JLabel lblpatientname=new JLabel("Patient Name");
	TextField txtpatientname=new TextField(35);
	JLabel lbladmitid=new JLabel("Admit ID:");
	TextField txtadmitid=new TextField(35);
	JLabel lbladdress=new JLabel("ADDRESS");
	TextField txtaddress=new TextField(25);
	JLabel lblreferby=new JLabel("REFER BY");
	TextField txtreferby=new TextField(15);
	JLabel lbldiagnosed=new JLabel("DIAGNOSED FOR");
	TextField txtdiagnosed=new TextField(15);
	JLabel lbldocument=new JLabel("DOCUMENT SUBMITTED:");
	TextField txtdocument=new TextField(15);
	JLabel lbldoctorname=new JLabel("DOCTOR NAME");
	TextField txtdoctorname=new TextField(15);
	JLabel lblbedno=new JLabel("BED NUMBER");
	TextField txtbedno=new TextField(15);

	JButton btnnew=new JButton("New");
	JButton btnsave=new JButton("Save");
	JButton btnsearch=new JButton("Search");
	JButton btnedit=new JButton("Edit");
	JButton btncancel=new JButton("Cancel");
	String tbed="";
	public Admit(String bed)
	{
		tbed=bed;
		setVisible(true);
		setLayout(null);
		setSize(1000,1000);
		lblpatientid.setBounds(20,20,80,30);
		txtpatientid.setBounds(100,20,80,30);
		lblpatientname.setBounds(250,20,80,30);
		txtpatientname.setBounds(350,20,180,30);
		lbladmitid.setBounds(260,50,80,70);
		txtadmitid.setBounds(350,70,180,30);
		lbladdress.setBounds(550,20,80,30);
		txtaddress.setBounds(670,20,250,100);
		lblreferby.setBounds(20,70,100,30);
		txtreferby.setBounds(100,70,150,30);
		lbldiagnosed.setBounds(20,140,150,30);
		txtdiagnosed.setBounds(200,140,100,30);
		lbldocument.setBounds(20,170,150,30);
		txtdocument.setBounds(200,170,100,30);
		lbldoctorname.setBounds(20,200,100,30);
		txtdoctorname.setBounds(200,200,100,30);
		lblbedno.setBounds(550,200,100,30);
		txtbedno.setBounds(670,200,100,30);
		btnnew.setBounds(20,250,80,30);
		btnsave.setBounds(120,250,80,30);
		btnsearch.setBounds(220,250,80,30);
		btnedit.setBounds(320,250,80,30);
		btncancel.setBounds(420,250,80,30);
		add(lblpatientid);
		add(txtpatientid);
		add(lblpatientname);
		add(txtpatientname);
		add(lbladmitid);
		add(txtadmitid);
		add(lbladdress);
		add(txtaddress);
		add(lblreferby);
		add(txtreferby);
		add(lbldiagnosed);
		add(txtdiagnosed);
		add(lbldocument);
		add(txtdocument);
		add(lbldoctorname);
		add(txtdoctorname);
		add(lblbedno);
		add(txtbedno);
		add(btnnew);
		add(btnsave);
		add(btnsearch);
		add(btnedit);
		add(btncancel);
		txtbedno.setText(tbed);
	btnnew.addActionListener(this);
	btnsave.addActionListener(this);
	btnsearch.addActionListener(this);
	btnedit.addActionListener(this);
	btncancel.addActionListener(this);
	txtpatientid.addFocusListener(this);
	}
	public void focusGained(FocusEvent fe)
	{
	}
	public void focusLost(FocusEvent fe)
	{
		if(fe.getSource()==txtpatientid)
		{
			//System.out.println("Good day");
			String tstat="";
			try
			{
				int flg=0;
				 Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
				 Statement st=con.createStatement();
				 String str="Select * from patienttbl where patientid='" +txtpatientid.getText()+"'";
				 ResultSet res=st.executeQuery(str);
				 String str1="select aid from keytbl";
				  Statement st1=con.createStatement();
				 ResultSet res1=st1.executeQuery(str1);
				 String taid="";
				 //String tststue="";
				 while(res1.next())
				 {
					  taid=res1.getString(1);
				 }
				while(res.next())
		        {
					tstat=res.getString(11);
					txtpatientname.setText(res.getString(2));
					txtaddress.setText(res.getString(3));
					flg=1;
					txtadmitid.setText(txtpatientid.getText()+"/"+"Nov/2022/"+taid);	
				}				
				if(flg==0)
				{
					JOptionPane.showMessageDialog(null,"no such records found");
					btnsave.setEnabled(false);
					txtpatientid.setText("");
					txtpatientname.setText("");
					txtaddress.setText("");
					txtadmitid.setText("");
					txtdiagnosed.setText("");
					txtdocument.setText("");
					txtreferby.setText("");
					txtdoctorname.setText("");	
				}
				if(tstat.equals("a"))
				{
					JOptionPane.showMessageDialog(null,"Already admitted");
					btnsave.setEnabled(false);
					txtpatientid.setText("");
					txtpatientname.setText("");
					txtaddress.setText("");
					txtadmitid.setText("");
					}
			}
			catch(Exception ee)
			{
			System.out.println(ee);
			}
	
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnnew)
		{
			btnsearch.setEnabled(true);
			btnsave.setEnabled(false);
			
			btnedit.setEnabled(false);
			txtpatientid.setText("");
			txtpatientname.setText("");
			txtadmitid.setText("");
			txtaddress.setText("");
			txtreferby.setText("");
			txtdiagnosed.setText("");
			txtdocument.setText("");
			txtdoctorname.setText("");
		}
	    if(e.getSource()==btnsave)
		{
		
			try
			{
				int flg=0;
			Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
			Statement st=con.createStatement();
			String str="select * from Admittbl where admitid='"+txtadmitid.getText()+"'";
			ResultSet res=st.executeQuery(str);
			  
   if(txtpatientid.getText().length()!=0 && txtpatientname.getText().length()!=0 && txtadmitid.getText().length()!=0 && txtaddress.getText().length()!=0 && txtreferby.getText().length()!=0 && txtdiagnosed.getText().length()!=0 && txtdocument.getText().length()!=0 && txtdoctorname.getText().length()!=0)
				  {
   String str1="insert into Admittbl(patientid,patientname,admitid,address,referby,diagnosed,document,doctorname)values(?,?,?,?,?,?,?,?)";  
				   PreparedStatement ps=con.prepareStatement(str1);
				   ps.setString(1,txtpatientid.getText());
				   ps.setString(2,txtpatientname.getText());
					ps.setString(3,txtadmitid.getText());
					ps.setString(4,txtaddress.getText());
					ps.setString(5,txtreferby.getText());
					ps.setString(6,txtdiagnosed.getText());
					ps.setString(7,txtdocument.getText());
					ps.setString(8,txtdoctorname.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"saved successfully");
				    String strup="update patienttbl set status='a' where patientid='"+txtpatientid.getText()+"'";
					Statement stup=con.createStatement();
					stup.executeUpdate(strup);
				
					Statement st1=con.createStatement();
					String str2="update keytbl set aid=aid+1";
					st1.executeUpdate(str2);
					Statement st3=con.createStatement();
					String strbed[]=txtbedno.getText().split("/");
					int n=Integer.parseInt(strbed[1]);
					String str3="update wardtbl set b"+n+"='N' where ward='"+strbed[0]+"'";
					st3.executeUpdate(str3);
						btnsave.setEnabled(false);
				  }
				  else
				  {
					  JOptionPane.showMessageDialog(null,"Please fill the details.");
				  }
				  
			   
			 
			   			  
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
				btnnew.setEnabled(false);
				btnsave.setEnabled(false);
					
					
				Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
				Statement st=con.createStatement();
				String admitid=JOptionPane.showInputDialog("Enter admitid");
				String str="select * from Admittbl where admitid='"+admitid+"'";
				ResultSet res=st.executeQuery(str);
				btnedit.setEnabled(true);
					btnsave.setEnabled(true);
				while(res.next())
				{
					txtpatientid.setText(res.getString(1));
					txtpatientname.setText(res.getString(2));
					txtadmitid.setText(res.getString(3));
					txtaddress.setText(res.getString(4));
					txtreferby.setText(res.getString(5));
					txtdiagnosed.setText(res.getString(6));
					txtdocument.setText(res.getString(7));
					txtdoctorname.setText(res.getString(8));
					flg=1;
					
				}
				if(flg==0)
				{
					JOptionPane.showMessageDialog(null,"no such records found.");
			

					
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
			 
			  Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
			  Statement st=con.createStatement();
			  String str="update Admittbl set patientid='"+txtpatientid.getText()+"',patientname='"+txtpatientname.getText()+"',admitid='"+txtadmitid.getText()+"',address='"+txtaddress.getText()+"',referby='"+txtreferby.getText()+"',diagnosed='"+txtdiagnosed.getText()+"',document='"+txtdocument.getText()+"',doctorname='"+txtdoctorname.getText()+"' where admitid='"+txtadmitid.getText()+"'";
			  st.executeUpdate(str);
			  JOptionPane.showMessageDialog(null,"updated");
			  btnedit.setEnabled(false);
			  	btnsave.setEnabled(false);
				 btnnew.setEnabled(true);
				
			  
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
	/*public static void main(String args[])
	{
		Admit obj=new Admit();
	}*/
}