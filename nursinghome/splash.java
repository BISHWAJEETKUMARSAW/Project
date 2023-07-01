import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
 public class splash extends JFrame implements ActionListener
 {
	 JLabel lblheading=new JLabel("NURSING HOME MANAGEMENT SYSTEM");
	JLabel lbldeveloper=new JLabel("Developer:");
	TextField txtdeveloper=new TextField();
	JButton btnok=new JButton("OK");
	JButton btncancel=new JButton("CANCEL");
	JLabel img=new JLabel(new ImageIcon("splash.jpg"));
	public splash()
	{
		img.setBounds(0,0,400,500);
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	setLocation((int)(d.getWidth()/2)-300,(int)(d.getHeight()/2)-150);
		setVisible(true);
		setLayout(null);
		setSize(600,300);
		setResizable(false);
		lblheading.setBounds(150,25,250,15);
		lbldeveloper.setBounds(20,50,100,50); 
		txtdeveloper.setBounds(200,65,200,20);
		btnok.setBounds(20,400,100,20);
		btncancel.setBounds(150,400,100,20);
		////add(lblheading);
		//add(lbldeveloper);
		//add(txtdeveloper);
		add(btnok);
		add(btncancel);
		btnok.addActionListener(this);
		btncancel.addActionListener(this);
		add(img);	
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnok)
		{
			this.dispose();
			Loginform obj=new Loginform();
		}
		if(e.getSource()==btncancel)
		{
			this.dispose();
		}
		
	}
	public static void main(String args[])
	{
		splash obj=new splash();
	}
 }
