import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class Payment extends JFrame implements ActionListener
{
	JLabel lblpid=new JLabel("Pid");
	TextField txtpid=new TextField(15);
	JLabel lblpaymentid=new JLabel("Payment id");
	TextField txtpaymentid=new TextField(15);
	
	JLabel lblname=new JLabel("Name");
	TextField txtname=new TextField(15);
	JLabel lblcontact=new JLabel("Contact");
	TextField txtcontact=new TextField(15);
	JLabel lbltotalcharge=new JLabel("Test Charge");
	TextField txttotalcharge=new TextField(15);
	JLabel lblgst=new JLabel("GST");
	TextField txtgst=new TextField(15);
	JLabel lblpay=new JLabel("Pay");
	TextField txtpay=new TextField(15);
	JLabel lblpaymentpaid=new JLabel("Payment Paid");
	TextField txtpaymentpaid=new TextField(15);
	JLabel lblremainpayment=new JLabel("Remain Payment ");
	TextField txtremainpayment=new TextField(15);

	JButton btnnew=new JButton("New");
	JButton btnsave=new JButton("Save");
	
	public Payment()
	{
		setVisible(true);
		setLayout(null);
		setSize(1000,1000);
		lblpid.setBounds(20,20,50,25);
		txtpid.setBounds(80,20,80,25);
		lblpaymentid.setBounds(180,20,80,25);
		txtpaymentid.setBounds(340,20,80,25);
	
		lblname.setBounds(500,20,80,25);
		txtname.setBounds(620,20,80,25);
		lblcontact.setBounds(720,20,80,25);
		txtcontact.setBounds(820,20,80,25);
		lbltotalcharge.setBounds(750,450,80,25);
		txttotalcharge.setBounds(850,450,80,25);
		lblgst.setBounds(750,490,80,25);
		txtgst.setBounds(850,490,80,25);
		lblpay.setBounds(750,530,80,25);
		txtpay.setBounds(850,530,80,25);
		lblpaymentpaid.setBounds(750,570,80,25);
		txtpaymentpaid.setBounds(850,570,80,25);
		lblremainpayment.setBounds(750,610,100,25);
		txtremainpayment.setBounds(850,610,120,25);
		btnnew.setBounds(20,600,100,25);
		btnsave.setBounds(160,600,100,25);
		
		add(lblpid);
		add(txtpid);
		add(lblpaymentid);
		add(txtpaymentid);

		add(lblname);
		add(txtname);
		add(lblcontact);
		add(txtcontact);
		add(lbltotalcharge);
		add(txttotalcharge);
		add(lblgst);
		add(txtgst);
		add(lblpay);
		add(txtpay);
		add(lblpaymentpaid);
		add(txtpaymentpaid);
		add(lblremainpayment);
		add(txtremainpayment);

		add(btnnew);
		add(btnsave);
		
		btnnew.addActionListener(this);
		btnsave.addActionListener(this);
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		
		
	}
	public static void main(String args[])
	{
		Payment obj=new Payment();
	}
}