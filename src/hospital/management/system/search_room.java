package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class search_room extends JFrame {
    Choice choice;
    JTable table;
    search_room(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JLabel search=new JLabel("Search For Room");
        search.setBounds(250,11,186,31);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(search);

        JLabel satus=new JLabel("Status :");
        satus.setBounds(70,70,100,20);
        satus.setForeground(Color.WHITE);
        satus.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(satus);

        choice=new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table=new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            conn c=new conn();
            String q="select * from Room";
            ResultSet resultset=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultset));

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel roomno=new JLabel("Room No ");
        roomno.setBounds(23,162,100,20);
        roomno.setForeground(Color.WHITE);
        roomno.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(roomno);

        JLabel available=new JLabel("Availability ");
        available.setBounds(175,162,100,20);
        available.setForeground(Color.WHITE);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(available);

        JLabel price=new JLabel("Price ");
        price.setBounds(350,162,100,20);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(price);

        JLabel bed=new JLabel("Bed ");
        bed.setBounds(530,162,100,20);
        bed.setForeground(Color.WHITE);
        bed.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(bed);

        JButton searc=new JButton("Search");
        searc.setBounds(200,420,120,25);
        searc.setBackground(Color.BLACK);
        searc.setForeground(Color.WHITE);
        panel.add(searc);
        searc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q="select * from Room where Availability = '"+choice.getSelectedItem()+"'";
                try{
                    conn c=new conn();
                    ResultSet resultset=c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultset));
                }
                catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back=new JButton("Back");
        back.setBounds(380,420,120,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setSize(700,500);
        setLayout(null);
        setLocation(450,150);
        setVisible(true);
    }
    public static void main(String args[]){
        new search_room();
    }
}
