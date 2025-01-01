package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class patient_discharge extends JFrame {
    patient_discharge(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel label=new JLabel("Check-Out");
        label.setBounds(100,20,150,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.white);
        panel.add(label);

        JLabel label2=new JLabel("Customer Id");
        label2.setBounds(30,80,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice=new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try {
            conn c=new conn();
            ResultSet resultset=c.statement.executeQuery("select * from patient_info");
            while(resultset.next()){
                choice.add(resultset.getString("number"));

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        JLabel label3=new JLabel("Room Number");
        label3.setBounds(30,130,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JLabel roomno=new JLabel();
        roomno.setBounds(200,130,150,20);
        roomno.setFont(new Font("Tahoma",Font.BOLD,14));
        roomno.setForeground(Color.white);
        panel.add(roomno);

        JLabel label4=new JLabel("In Time");
        label4.setBounds(30,180,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JLabel inTime=new JLabel();
        inTime.setBounds(200,180,150,20);
        inTime.setFont(new Font("Tahoma",Font.BOLD,14));
        inTime.setForeground(Color.white);
        panel.add(inTime);


        JLabel label5=new JLabel("Out Time");
        label5.setBounds(30,230,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        Date date=new Date();


        JLabel outtime=new JLabel(""+date);
        outtime.setBounds(200,230,250,20);
        outtime.setFont(new Font("Tahoma",Font.BOLD,14));
        outtime.setForeground(Color.white);
        panel.add(outtime);

        JButton discharge=new JButton("Discharge");
        discharge.setBounds(150,300,120,30);
        discharge.setBackground(Color.black);
        discharge.setForeground(Color.white);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c=new conn();
               try{
                   c.statement.executeUpdate("delete from patient_info where number = '"+choice.getSelectedItem()+"'");
                   c.statement.executeUpdate("update room set Availability ='Available' where room_no ='"+roomno.getText()+"'");
                   JOptionPane.showMessageDialog(null,"Done");
                   setVisible(false);
               }
               catch(Exception E){
                   E.printStackTrace();
               }
            }
        });

        JButton check=new JButton("Check");
        check.setBounds(310,300,120,30);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c=new conn();
                try{
                    ResultSet resultset = c.statement.executeQuery("select * from patient_info where number = '"+choice.getSelectedItem()+"'");

                    while(resultset.next()){
                        roomno.setText(resultset.getString("Room_number"));
                        inTime.setText(resultset.getString("Time"));
                    }
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });


        JButton back=new JButton("Back");
        back.setBounds(470,300,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });





        setSize(800,400);
        setLayout(null);
        setLocation(340,250);
        setVisible(true);
    }
    public static void main(String args[]){
        new patient_discharge();
    }
}
