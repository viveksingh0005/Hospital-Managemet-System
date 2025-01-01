package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {
    Employee_info(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109,164,70));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(10,34,980,450);
        table.setBackground(new Color(109,164,170));
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(table);

        try{
            conn c=new conn();
            String q="select * from emp_info";
            ResultSet resultset=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultset));

        }
        catch(Exception e){
            e.printStackTrace();
        }
        JLabel label1=new JLabel("Name");
        label1.setBounds(41,11,70,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2=new JLabel("Age");
        label2.setBounds(181,11,70,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3=new JLabel("Phone Number");
        label3.setBounds(351,11,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4=new JLabel("Salary");
        label4.setBounds(511,11,70,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5=new JLabel("Gmail");
        label5.setBounds(681,11,70,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label6=new JLabel("Aadhar Number");
        label6.setBounds(850,11,150,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

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
        setLocation(250,100);
        setLayout(null);
        setVisible(true);


    }

    public static void main(String args[]){
        new Employee_info();

    }
}
