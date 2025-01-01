package hospital.management.system;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reception extends JFrame {
    public reception(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1340,670);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1340,150);
        panel1.setBackground(new Color(109,164,170));
        add(panel1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image=i1.getImage() .getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(image);
        JLabel label=new JLabel(i2);
        label.setBounds(1150,0,250,250);
        panel1.add(label);

        ImageIcon ia1=new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image imagea1=ia1.getImage() .getScaledInstance(300,100,Image.SCALE_DEFAULT);
        ImageIcon ia2=new ImageIcon(imagea1);
        JLabel labela1=new JLabel(ia2);
        labela1.setBounds(850,50,300,100);
        panel1.add(labela1);

        JButton button1=new JButton("Add New Patient");
        button1.setBounds(30,15,200,30);
        button1.setBackground(new Color(246,215,118));
        panel1.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new newpatient();
            }
        });

        JButton button2=new JButton("Room");
        button2.setBounds(30,58,200,30);
        button2.setBackground(new Color(246,215,118));
        panel1.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new room();
            }
        });

        JButton button3=new JButton("Department");
        button3.setBounds(30,100,200,30);
        button3.setBackground(new Color(246,215,118));
        panel1.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new department();
            }
        });

        JButton button4=new JButton("All Employee Info");
        button4.setBounds(270,15,200,30);
        button4.setBackground(new Color(246,215,118));
        panel1.add(button4);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee_info();
            }
        });

        JButton button5=new JButton("Patient Info");
        button5.setBounds(270,58,200,30);
        button5.setBackground(new Color(246,215,118));
        panel1.add(button5);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new All_patient_Info();
            }
        });

        JButton button6=new JButton("Patient Discharge");
        button6.setBounds(270,100,200,30);
        button6.setBackground(new Color(246,215,118));
        panel1.add(button6);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new patient_discharge();
            }
        });

        JButton button7=new JButton("Update Patient Details");
        button7.setBounds(510,15,200,30);
        button7.setBackground(new Color(246,215,118));
        panel1.add(button7);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new update_patient_details();
            }
        });

        JButton button8=new JButton("Hospital Ambulance");
        button8.setBounds(510,58,200,30);
        button8.setBackground(new Color(246,215,118));
        panel1.add(button8);
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ambulance();
            }
        });

        JButton button9=new JButton("Search Room");
        button9.setBounds(510,100,200,30);
        button9.setBackground(new Color(246,215,118));
        panel1.add(button9);
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new search_room();
            }
        });

        JButton button10=new JButton("Logout");
        button10.setBounds(750,15,200,30);
        button10.setBackground(new Color(246,215,118));
        panel1.add(button10);
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();

            }
        });







        setSize(1950,1090);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);


    }
    public static void main(String args[]){
        new reception();
    }
}
