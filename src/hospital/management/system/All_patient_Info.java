package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class All_patient_Info extends JFrame {
    All_patient_Info(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(10,40,960,450);
        table.setBackground(new Color(90,156,244));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);

        try{
            conn c=new conn();
            String q="select * from patient_info";
            ResultSet resultset=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultset));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        JLabel label1=new JLabel("Id");
        label1.setBounds(31,11,100,14);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2=new JLabel("Number");
        label2.setBounds(150,11,100,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3=new JLabel("Name");
        label3.setBounds(270,11,100,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4=new JLabel("Gender");
        label4.setBounds(380,11,100,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5=new JLabel("Disease");
        label5.setBounds(500,11,100,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label6=new JLabel("Room");
        label6.setBounds(620,11,100,14);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        JLabel label7=new JLabel("Time");
        label7.setBounds(740,11,100,14);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label7);

        JLabel label8=new JLabel("Deposit");
        label8.setBounds(860,11,100,14);
        label8.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label8);

        JButton b =new JButton("Back");
        b.setBounds(400,500,120,30);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        panel.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setSize(1000,600);
        setLayout(null);
        setLocation(200,100);
        setVisible(true);

    }
    public static void main(String args[]){
        new All_patient_Info();
    }
}
