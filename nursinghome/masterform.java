import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class masterform extends JFrame implements ActionListener
{
JMenuBar mb=new JMenuBar();
JMenu mnumaster=new JMenu("Master");
JMenu mnutransection=new JMenu("Transaction");
JMenu mnureport=new JMenu("Report");
JMenuItem ward=new JMenuItem("WARD");
JMenuItem test=new JMenuItem("TEST");
JMenuItem doctor=new JMenuItem("DOCTOR");
JMenuItem patient=new JMenuItem("PATIENT");
JMenuItem bedavailability=new JMenuItem("AVAILABLITY OF BED");
JMenuItem admit=new JMenuItem("ADMIT");
JMenuItem testupdate=new JMenuItem("TEST UPDATE");
JMenuItem discharge=new JMenuItem("DISCHARGE");
JMenuItem payment=new JMenuItem("PAYMENT");
JMenuItem refund=new JMenuItem("REFUND");

public masterform()
{
	setSize(1000,800);
	setLayout(null);
	setVisible(true);
	mnumaster.add(ward);
	mnumaster.add(test);
	mnumaster.add(doctor);
	mnumaster.add(patient);
	mnutransection.add(bedavailability);
	mnutransection.add(admit);
	mnutransection.add(testupdate);
	mnutransection.add(discharge);
	mnutransection.add(payment);
	mnutransection.add(refund);
	mb.add(mnumaster);
	mb.add(mnutransection);
	mb.add(mnureport);
	this.setJMenuBar(mb);
	this.setJMenuBar(mb);
	ward.addActionListener(this);
	test.addActionListener(this);
	doctor.addActionListener(this);
	patient.addActionListener(this);
	bedavailability.addActionListener(this);
	admit.addActionListener(this);
}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==ward)
		{
			ward obj1= new ward();
		}
		if(e.getSource()==patient)
		{
			Patient obj2=new Patient();
		}
		if(e.getSource()==test)
		{
			Test obj3=new Test();
		}
		if(e.getSource()==doctor)
		{
			Doctor obj4=new Doctor();
		}
		if(e.getSource()==bedavailability)
		{
			bedavailability obj5=new bedavailability();
		}
		if(e.getSource()==admit)
		{
			Admit obj6=new Admit(e.getActionCommand().toString());
		}
		
	}
	

public static void main(String args[])
{
	masterform ob=new masterform();
}
}