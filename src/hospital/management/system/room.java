package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class room extends JFrame {
    JTable table;

        room(){
        JPanel panel =new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageicon=new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image=imageicon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageicon1=new ImageIcon(image);
        JLabel label =new JLabel(imageicon1);
        label.setBounds(600,200,200,200);
        panel.add(label);

        table= new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(90,156,163));
        panel.add(table);

        try{
            conn c =new conn();
            String q="select * from room";
            ResultSet resultset=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultset));


        }catch(Exception e){
            e.printStackTrace();
        }
        JLabel label1=new JLabel("Room No");
        label1.setBounds(12,15,80,15);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

            JLabel label2=new JLabel("Available");
            label2.setBounds(140,15,80,15);
            label2.setFont(new Font("Tahoma",Font.BOLD,14));
            panel.add(label2);

            JLabel label3=new JLabel("Price");
            label3.setBounds(290,15,80,15);
            label3.setFont(new Font("Tahoma",Font.BOLD,14));
            panel.add(label3);

            JLabel label4=new JLabel("Bed Type");
            label4.setBounds(400,15,80,15);
            label4.setFont(new Font("Tahoma",Font.BOLD,14));
            panel.add(label4);

            JButton back =new JButton("Back");
            back.setBounds(200,500,120,30);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            panel.add(back);
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });


        setSize(900,600);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);

    }
    public static void main(String args[]){
        new room();
    }
}
