import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class bedavailability extends JFrame implements ActionListener,ItemListener
{
	JButton btnbed[]=new JButton[15];
	JLabel  lblward=new JLabel("Ward");
    JComboBox cmbward=new JComboBox();
	TextField txtbox=new  TextField(20);
	public bedavailability()
	{
		int i,j=0,x,y;
		setVisible(true);
		setLayout(null);
		setSize(1000,1000);
		lblward.setBounds(20,50,110,15);
		cmbward.setBounds(200,50,150,20);
		txtbox.setBounds(200,150,150,20);
		for(i=0 ;i<15;i++ )
		{
			btnbed[i]=new JButton();
		}
		for( i=0;i<15;i++)
		{
			if(i<5)
				btnbed[i].setBounds(50+i*80,200,80,50);
			else if(i>4 && i<10)
				btnbed[i].setBounds(50+(i-5)*80,270,80,50);
					else 
				btnbed[i].setBounds(50+(i-10)*80,340,80,50);

			
			btnbed[i].setBackground(new Color(0,255,0));
		    add(btnbed[i]);
		}
		
		add(lblward);
		add (cmbward);
		add(txtbox);
	try
		{
			Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
			Statement st=con.createStatement();
			String str="select * from wardtbl";
			ResultSet res=st.executeQuery(str);
			//System.out.println("1111111");
			while(res.next())
			{
				//System.out.println("2222");
				cmbward.addItem(res.getString(1));
			}
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
		cmbward.addItemListener(this);
		for(i=0;i<15;i++)
		{
			btnbed[i].addActionListener(this);
		}
	}
	public void itemStateChanged(ItemEvent ie)
	{
		try
		{
			int i;
			Connection con=DriverManager.getConnection("jdbc:odbc:nursingdsn");
			Statement st=con.createStatement();
			String str="select * from wardtbl where ward='"+cmbward.getSelectedItem()+"'";
			ResultSet res=st.executeQuery(str);
			for(i=0;i<15;i++)
			{
				btnbed[i].setVisible(false);
			}
			while(res.next())
			{
				for(i=2;i<17;i++)
				{
					//System.out.println(11);
					String tstatus=res.getString(i);
					if(tstatus.equals("A"))
					{
						btnbed[i-2].setVisible(true);
						btnbed[i-2].setBackground(new Color(0,255,0));
						
						 btnbed[i-2].setText(""+cmbward.getSelectedItem()+"/"+(i-1));
					}
					else 
					{	
					if(tstatus.equals("N"))
					{
						btnbed[i-2].setVisible(true);
						btnbed[i-2].setBackground(new Color(255,0,0));
						 btnbed[i-2].setText(""+cmbward.getSelectedItem()+"/"+(i-1));
					}
				    else
					{
						
					         btnbed[i-2].setVisible(false);
					}
					}
						
				}
			}
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	
	}
	public void actionPerformed(ActionEvent e)
	{
		//System.out.println(e.getActionCommand());
			Admit obj=new Admit(e.getActionCommand().toString());
			
	}
	public static void main(String args[])
	{
		bedavailability obj=new bedavailability();
	}
}