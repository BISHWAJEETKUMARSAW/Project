import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
public class Loginform extends Frame implements ActionListener
{
	JLabel lblimg=new JLabel(new ImageIcon("splash.jpg"));
JLabel lbluser=new JLabel("user");
TextField txtuser=new TextField(25);
JLabel lblpassword=new JLabel("Passward");
JPasswordField txtpassword=new JPasswordField(15);
JButton btnok=new JButton("OK");
JButton btncancel=new JButton("CANCEL");
JLabel lblbk=new JLabel();
Label lblload=new Label();
	public Loginform()
	{
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	setLocation((int)(d.getWidth()/2)-300,(int)(d.getHeight()/2)-150);
	
	setVisible(true);
	setLayout(null);
	setSize(600,300);
	setResizable(false);
	lblbk.setBounds(180,30,320,130);
	lblload.setBounds(300,200,10,20);
	lblload.setBackground(new Color(200,200,255));
	lblbk.setOpaque(true);
	lbluser.setBounds(200,50,50,15);
	lblpassword.setBounds(200,100,70,15);
	txtuser.setBounds(300,50,150,25);
	txtpassword.setBounds(300,100,150,25);
	btnok.setBounds(300,180,80,25);
	btncancel.setBounds(400,180,80,25);
	lblimg.setBounds(50,50,100,100);
	add(lblimg);
	add(lbluser);
	add(lblpassword);
	add(txtuser);
	add(txtpassword);
	add(btnok);
	add(btncancel);
	add(lblbk);
	btnok.addActionListener(this);
	btncancel.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
	if(e.getSource()==btnok)
	{
	    int flg=0,x=0;
		try
		{
		Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
		Statement st=con.createStatement();
		String str="Select * from logintbl where usr='" +txtuser.getText()+"' and pwd='"+ txtpassword.getText()+"'";
		System.out.println(txtuser.getText());
		System.out.println(txtpassword.getText());
		ResultSet res=st.executeQuery(str);
		while(res.next())
		{
			try{
				for(int i=1;i<20;i++)
				{
				lblload.setBounds(300,200,10+x,20);
				x=x+20;
				Thread.sleep(100);
				repaint();
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
			JOptionPane.showMessageDialog(null,"Login Successfully");
			this.dispose();
			masterform obj=new masterform();
			flg=1;
		}
		if(flg==0)
		{
		JOptionPane.showMessageDialog(null,"Login unsuccessfully");
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
Loginform obj=new Loginform();
}
}