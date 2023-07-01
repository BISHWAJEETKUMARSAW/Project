import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class  Patient extends JFrame implements ActionListener
{
JLabel lblpatientid=new JLabel("Patient id");
TextField txtpatientid=new TextField(15);
JLabel lblpatientname=new JLabel("Patient Name");
TextField txtpatientname=new TextField(25);
JLabel lbladdress=new JLabel("Address");
TextField txtaddress=new TextField(25);
JLabel lblaadharnumber=new JLabel("Aadhar number");
TextField txtaadharnumber=new TextField(25);
JLabel lblage=new JLabel("Age");
TextField txtage=new TextField(15);
JLabel lbldateofbirth=new JLabel("Date of Birth");
TextField txtdateofbirth=new TextField(15);
JLabel lbldateofconsultation=new JLabel("Date of consultation");
TextField txtdateofconsultation=new TextField(15);
JLabel lblgender=new JLabel("Gender");
JRadioButton rbtmale=new JRadioButton("MALE");
JRadioButton rbtfemale=new JRadioButton("FEMALE");
ButtonGroup bg=new ButtonGroup();
JLabel lblalergies=new JLabel("Alergies");
TextField txtalergies=new TextField(25);
JLabel lblreferences=new JLabel("References");
TextField txtreferences=new TextField(15);
JButton btnnew=new  JButton("New");
JButton btnsave=new  JButton("Save");
JButton btnsearch=new  JButton("Search");
JButton btnedit=new  JButton("Edit");
JButton btncancel=new  JButton("Cancel");
	public Patient()
	{
	setVisible(true);
	setLayout(null);
	setSize(1000,1000);	
	lblpatientid.setBounds(20,30,100,50);
	lblpatientname.setBounds(20,80,150,50);
	lbladdress.setBounds(510,130,150,50);
	lblaadharnumber.setBounds(20,180,150,50);
	lblage.setBounds(20,230,150,50);
	lbldateofbirth.setBounds(20,280,150,50);
	lbldateofconsultation.setBounds(20,330,150,50);
	lblgender.setBounds(20,380,150,50);
	lblalergies.setBounds(20,430,150,50);
	lblreferences.setBounds(20,480,150,50);
	txtpatientid.setBounds(190,45,100,25);
	txtpatientname.setBounds(190,95,300,25);
	txtaddress.setBounds(660,130,300,150);
	txtaadharnumber.setBounds(190,190,200,25);
	txtage.setBounds(190,240,200,25);
	txtdateofbirth.setBounds(190,290,200,25);
	txtdateofconsultation.setBounds(190,340,200,25);
	rbtmale.setBounds(190,390,200,25);
	rbtfemale.setBounds(450,390,200,25);
	txtalergies.setBounds(190,440,200,25);
	txtreferences.setBounds(190,490,200,25);
	btnnew.setBounds(20,530,100,30);
	btnsave.setBounds(150,530,100,30);
	btnsearch.setBounds(280,530,100,30);
	btnedit.setBounds(420,530,100,30);
	btncancel.setBounds(550,530,100,30);
	add(lblpatientid);
	add(txtpatientid);
	add(lblpatientname);
	add(txtpatientname);
	add(lbladdress);
	add(txtaddress);
	add(lblaadharnumber);
	add(txtaadharnumber);
	add(lblage);
	add(txtage);
	add(lbldateofbirth);
	add(txtdateofbirth);
	add(lbldateofconsultation);
	add(txtdateofconsultation);
	add(lblgender);
	add(rbtmale);
	add(rbtfemale);
	add(lblalergies);
	add(txtalergies);
	add(lblreferences);
	add(txtreferences);
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
	bg.add(rbtmale);
	bg.add(rbtfemale);
	
	}
	
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==btnnew)
	{
		btnsave.setEnabled(true);
	txtpatientid.setText("");
	txtpatientname.setText("");
	txtaddress.setText("");
	txtaadharnumber.setText("");
	txtage.setText("");
	txtdateofbirth.setText("");
	txtdateofconsultation.setText("");
	
	txtalergies.setText("");
	txtreferences.setText("");
		try
		{
		Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
		Statement st=con.createStatement();
		String str="select pid  from keytbl";
		ResultSet res=st.executeQuery(str);
		while(res.next())
		{
		txtpatientid.setText("P/"+res.getString(1));
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
			String str1="select * from patienttbl where patientid='"+txtpatientid.getText()+"'";
			ResultSet res1=st.executeQuery(str1);
			while(res1.next())
			{
				flg=1;
			}
			if(flg==0)
			{
				if(txtpatientid.getText().length()!=0 && txtpatientname.getText().length()!=0 && txtaddress.getText().length()!=0 && txtaadharnumber.getText().length()!=0 && txtage.getText().length()!=0 && txtdateofbirth.getText().length()!=0 && txtdateofconsultation.getText().length()!=0 && txtalergies.getText().length()!=0 && txtreferences.getText().length()!=0)
				{
			String str="insert into patienttbl(patientid,patientname,address,Aadharno,age,dob,doc,Gender,Alergies,Refrences)values(?,?,?,?,?,?,?,?,?,?)"	;
			PreparedStatement ps=con.prepareStatement(str);
			ps.setString(1,txtpatientid.getText());
			ps.setString(2,txtpatientname.getText());
			ps.setString(3,txtaddress.getText());
			ps.setString(4,txtaadharnumber.getText());
			ps.setString(5,txtage.getText());
			ps.setString(6,txtdateofbirth.getText());
			ps.setString(7,txtdateofconsultation.getText());
			if(rbtmale.isSelected())
				gen="male";
			else
				gen="female";
			ps.setString(8,gen);
			ps.setString(9,txtalergies.getText());
			ps.setString(10,txtreferences.getText());

			ps.executeUpdate();
			JOptionPane.showMessageDialog(null,"Saved Successfully");
			btnsave.setEnabled(false);
			Statement st1=con.createStatement();
			String str2="update keytbl set pid=pid+1";
			st1.executeUpdate(str2);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please Fill The Details.");
					
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
				 String ppatientid=JOptionPane.showInputDialog("Enter Patientid");
				 String str="Select * from patienttbl where patientid='" +ppatientid+"'";
				 	ResultSet res=st.executeQuery(str);
					while(res.next())
		{
			txtpatientid.setText(res.getString(1));
			txtpatientname.setText(res.getString(2));
			txtaddress.setText(res.getString(3));
			txtaadharnumber.setText(res.getString(4));
			txtage.setText(res.getString(5));
			txtdateofbirth.setText(res.getString(6));
			txtdateofconsultation.setText(res.getString(7));
			if(res.getString(8).equalsIgnoreCase("male"))
				rbtmale.setSelected(true);
			else
				rbtfemale.setSelected(true);
			txtalergies.setText(res.getString(9));
			txtreferences.setText(res.getString(10));
			
			flg=1;
		}
		if(flg==0)
		{
			JOptionPane.showMessageDialog(null,"no such records found");
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
				Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
				Statement st=con.createStatement();
				if(rbtmale.isSelected())
					gen="male";
				else
					gen="female";
				
				String str="update patienttbl set Patientname='"+txtpatientname.getText()+"',Address='"+txtaddress.getText()+"',Age='"+txtage.getText()+"',Dob='"+txtdateofbirth.getText()+"',Doc='"+txtdateofconsultation.getText()+"',Gender='"+gen+"',Alergies='"+txtalergies.getText()+"',Refrences='"+txtreferences.getText()+"' where patientid='"+txtpatientid.getText()+"'"  ;
		st.executeUpdate(str);

   JOptionPane.showMessageDialog(null,"updated");
			btnedit.setEnabled(false);
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
			Patient obj=new Patient();
		}
}