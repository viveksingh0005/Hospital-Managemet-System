package hospital.management.system;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class department extends JFrame{
    department(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,690,600);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JTable table=new JTable();
        table.setBounds(30,40,690,300);
        table.setBackground(new Color(90,156,163));


        panel.add(table);

        try{
            conn c=new conn();
            String q="select * from department";
            ResultSet resultset =c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultset));

        }

        catch(Exception e){
            e.printStackTrace();
        }

        JLabel label1=new JLabel("Department");
        label1.setBounds(130,11,105,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2=new JLabel("Phone Number");
        label2.setBounds(410,11,105,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JButton b =new JButton("Back");
        b.setBounds(400,400,120,30);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        panel.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setSize(700,600);
        setLayout(null);
        setLocation(350,160);
        setVisible(true);



    }
    public static void main(String args[]){
        new department();
    }
}
