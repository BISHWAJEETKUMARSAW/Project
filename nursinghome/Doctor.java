import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Doctor extends JFrame implements ActionListener,KeyListener
{
JLabel lbldoctorid=new JLabel("Doctor id");
TextField txtdoctorid=new TextField(15);
JLabel lblname=new JLabel("Name");
TextField txtname=new TextField(15);
JLabel lbladdress=new JLabel("Address");
TextField txtaddress=new TextField(15);
JLabel lblcontact=new JLabel("Contact");
TextField txtcontact=new TextField(15);
JLabel lblqualification=new JLabel("Qualification");
TextField txtqualification=new TextField(15);
JLabel lblspecialistin=new JLabel("Specilist in");
TextField txtspecialistin=new TextField(15);
JLabel lblemail=new JLabel("Email");
TextField txtemail=new TextField(15);
JLabel lblavailableon=new JLabel("Available on");
TextField txtavailableon=new TextField(15);
JLabel lbldateofjoining=new JLabel("Date of joining");
TextField txtdateofjoining=new TextField(15);
JLabel  lblgender=new JLabel("Gender");
JRadioButton rbtmale=new JRadioButton("MALE");
JRadioButton rbtfemale=new JRadioButton("FEMALE");

JLabel lblage=new JLabel("Age");
TextField txtage=new TextField(15);
JLabel lblexperience=new JLabel("Experience");
TextField txtexperience=new TextField(15);
JButton btnnew=new JButton("New");
JButton btnsave=new JButton("Save");
JButton btnsearch=new JButton("Search");
JButton btnedit=new JButton("Edit");
JButton btncancel=new JButton("Cancel");
	public Doctor()
	{
	setVisible(true);
	setLayout(null);
	setLocation(300,100);
	setResizable(false);
	setSize(1000,1000);
	lbldoctorid.setBounds(20,50,80,25);
	lblname.setBounds(20,100,80,25);
	lbladdress.setBounds(420,150,80,25);
	lblcontact.setBounds(20,200,80,25);
	lblqualification.setBounds(20,250,80,25);
	lblspecialistin.setBounds(20,300,80,25);
	lblemail.setBounds(20,350,80,25);
	lblavailableon.setBounds(20,400,80,25);
	lbldateofjoining.setBounds(20,450,80,25);
	lblgender.setBounds(20,500,80,25);
	lblage.setBounds(20,550,80,25);
	lblexperience.setBounds(20,600,80,25);
	txtdoctorid.setBounds(150,50,80,25);
	txtname.setBounds(150,100,200,25);
	txtaddress.setBounds(550,150,240,100);
	txtcontact.setBounds(150,200,160,25);
	txtqualification.setBounds(150,250,200,25);
	txtspecialistin.setBounds(150,300,160,25);
	txtemail.setBounds(150,350,160,25);
	txtavailableon.setBounds(150,400,80,25);
	txtdateofjoining.setBounds(150,450,80,25);
	rbtmale.setBounds(150,500,80,25);
	rbtfemale.setBounds(350,500,80,25);
	ButtonGroup group=new ButtonGroup();
	group.add(rbtmale);
	group.add(rbtfemale);
	txtage.setBounds(150,550,80,25);
	txtexperience.setBounds(150,600,80,25);
	btnnew.setBounds(20,650,80,25);
	btnsave.setBounds(120,650,80,25);
	btnsearch.setBounds(220,650,80,25);
	btnedit.setBounds(320,650,80,25);
	btncancel.setBounds(420,650,80,25);
	add(lbldoctorid);
	add(lblname);
	add(lbladdress);
	add(lblcontact);
	add(lblqualification);
	add(lblspecialistin);
	add(lblemail);
	add(lblavailableon);
	add(lbldateofjoining);
	add(lblgender);
	add(lblage);
	add(lblexperience);
	add(txtdoctorid);
	add(txtname);
	add(txtaddress);
	add(txtcontact);
	add(txtqualification);
	add(txtspecialistin);
	add(txtemail);
	add(txtavailableon);
	add(txtdateofjoining);
	add(rbtmale);
	add(rbtfemale);
	add(txtage);
	add(txtexperience);
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
	txtname.addKeyListener(this);
	txtcontact.addKeyListener(this);
	}
	public void keyReleased(KeyEvent k)
	{
		char ch1;
		String str1;
		str1=txtname.getText();
		ch1=str1.charAt(str1.length()-1);
		if(ch1>='0' && ch1<='9')
		{
			JOptionPane.showInputDialog(null,"wrong input");
			txtname.setText("");
		}
		char ch2;
		String str2;
		str2=txtcontact.getText();
		ch2=str2.charAt(str2.length()-1);
		if((ch2>='A' && ch2<='Z') || (ch2>='a' && ch2<='z'))
		{
			JOptionPane.showMessageDialog(null,"wrong input");
			txtcontact.setText("");
		}
		
	}
	public void keyPressed(KeyEvent k)
	{}
	public void keyTyped(KeyEvent k)
	{}

public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==btnnew)
	{
		btnsave.setEnabled(true);
	txtdoctorid.setText("");
	txtname.setText("");
	txtaddress.setText("");
	txtcontact.setText("");
	txtqualification.setText("");
	txtspecialistin.setText("");
	txtemail.setText("");
	txtavailableon.setText("");
	txtdateofjoining.setText("");
	
	txtage.setText("");
	txtexperience.setText("");
	
		try
		{
			Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
			Statement st=con.createStatement();
			String str="select  did from keytbl";
			ResultSet res=st.executeQuery(str);
			while(res.next())
			{
			txtdoctorid.setText("D/"+res.getString(1));
			}
		}
		catch(Exception ee)
		{
		System.out.println(ee);
		}
	}
if(e.getSource()==btnsave)
	{
		String gen="";
	    try
		{
			int flg=0;
			Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
			Statement st=con.createStatement();
			String str1="select * from doctortbl where doctorid='"+txtdoctorid.getText()+"'";
			ResultSet res1=st.executeQuery(str1);
			while(res1.next())
			{
				flg=1;
			}
			if(flg==0)
			{	
				if(txtdoctorid.getText().length()!=0 && txtname.getText().length()!=0 && txtaddress.getText().length()!=0 && txtcontact.getText().length()!=0 && txtqualification.getText().length()!=0 && txtspecialistin.getText().length()!=0 && txtemail.getText().length()!=0 && txtavailableon.getText().length()!=0 && txtdateofjoining.getText().length()!=0  )
				{
			String str="insert into doctortbl(doctorid,doctorname,address,contact,Qualification,Specialistin,Email,Availableon,Dateofjoining,Gender,Age,Experience)values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(str);
			ps.setString(1,txtdoctorid.getText());
			ps.setString(2,txtname.getText());
			ps.setString(3,txtaddress.getText());
			ps.setString(4,txtcontact.getText());
			ps.setString(5,txtqualification.getText());
			ps.setString(6,txtspecialistin.getText());
			ps.setString(7,txtemail.getText());
			ps.setString(8,txtavailableon.getText());
			ps.setString(9,txtdateofjoining.getText());
			if(rbtfemale.isSelected())
				gen="female";
			else
				gen="male";
			ps.setString(10,gen);
			ps.setString(11,txtage.getText());
			ps.setString(12,txtexperience.getText());

			ps.executeUpdate();
			JOptionPane.showMessageDialog(null,"Saved Successfully");
			btnsave.setEnabled(false);
			Statement st1=con.createStatement();
			String str2="update keytbl set did=did+1";
			st1.executeUpdate(str2);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Please Fill the details.");
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
  if(e.getSource()==btnsearch)
  {
    int flg=0;
	try
	{
		btnedit.setEnabled(true);
	 Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
	 Statement st=con.createStatement();
	 String doctorid=JOptionPane.showInputDialog("Enter DoctorId");
	 String str="Select * from doctortbl where doctorid='" +doctorid+"'";
		ResultSet res=st.executeQuery(str);
		while(res.next())
		{
			txtdoctorid.setText(res.getString(1));
			txtname.setText(res.getString(2));
			txtaddress.setText(res.getString(3));
			txtcontact.setText(res.getString(4));
			txtqualification.setText(res.getString(5));
			txtspecialistin.setText(res.getString(6));
			txtemail.setText(res.getString(7));
			txtavailableon.setText(res.getString(8));
			txtdateofjoining.setText(res.getString(9));
			if(res.getString(10).equalsIgnoreCase("female"))
				rbtfemale.setSelected(true);
			else
				rbtmale.setSelected(true);
		
			txtage.setText(res.getString(11));
			txtexperience.setText(res.getString(12));
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
	   String gen="";
	   try
	   { 
			int flg=0;
		   Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
			Statement st=con.createStatement();
			String str1="select * from doctortbl where doctorid='"+txtdoctorid.getText()+"'";
			ResultSet res2=st.executeQuery(str1);
			while(res2.next())
			{
				flg=1;
			}
			if(flg==1)
			{
			if(rbtfemale.isSelected())
				gen="female";
			else
				gen="male";
			String str="update doctortbl set doctorname='"+txtname.getText()+"',address='"+txtaddress.getText()+"',contact='"+txtaddress.getText()+"', Qualification='"+txtqualification.getText()+"',Specialistin='"+txtspecialistin.getText()+"',Email='"+txtemail.getText()+"',Availableon='"+txtavailableon.getText()+"',Dateofjoining='"+txtdateofjoining.getText()+"',Gender='"+gen+"',Age='"+txtage.getText()+"',Experience='"+txtexperience.getText()+"'";
			st.executeUpdate(str);
	        JOptionPane.showMessageDialog(null,"updated");
			btnedit.setEnabled(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"No such records to Edited.");
			}
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
Doctor obj=new Doctor();
}
}