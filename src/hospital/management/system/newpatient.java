package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class newpatient extends JFrame implements ActionListener {
    JComboBox combobox;
    JTextField textfieldnumber,textname,textdisease,textdeposit;
    JRadioButton r1,r2;
    Choice c1;
    JLabel date;
    JButton b1,b2;


    newpatient(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageicon=new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image=imageicon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageicon1=new ImageIcon(image);
        JLabel label=new JLabel(imageicon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel labelName=new JLabel("NEW PATIENT FORM");
        labelName.setBounds(270,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,23));
        labelName.setForeground(Color.DARK_GRAY);
        panel.add(labelName);

        JLabel labelID=new JLabel("ID:");
        labelID.setBounds(35,76,200,14);
        labelID.setFont(new Font("Tahoma",Font.BOLD,14));
        labelID.setForeground(Color.white);
        panel.add(labelID);

        combobox=new JComboBox(new String[]{ "Aadhar Card","Voter ID","Driving License"});
        combobox.setBounds(271,76,150,20);
        combobox.setBackground(new Color(3,45,48));
        combobox.setForeground(Color.white);
        combobox.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(combobox);

        JLabel labelnumber=new JLabel("Number:");
        labelnumber.setBounds(35,111,200,14);
        labelnumber.setFont(new Font("Tahoma",Font.BOLD,14));
        labelnumber.setForeground(Color.white);
        panel.add(labelnumber);

        textfieldnumber=new JTextField();
        textfieldnumber.setBounds(271,111,150,20);
        panel.add(textfieldnumber);

        JLabel labelname1=new JLabel("Name:");
        labelname1.setBounds(35,151,200,14);
        labelname1.setFont(new Font("Tahoma",Font.BOLD,14));
        labelname1.setForeground(Color.white);
        panel.add(labelname1);

        textname=new JTextField();
        textname.setBounds(271,151,150,20);
        panel.add(textname);

        JLabel labelgender=new JLabel("Gender:");
        labelgender.setBounds(35,191,200,14);
        labelgender.setFont(new Font("Tahoma",Font.BOLD,14));
        labelgender.setForeground(Color.white);
        panel.add(labelgender);

        r1=new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setBackground(new Color(109,164,170));
        r1.setForeground(Color.WHITE);
        r1.setBounds(271,191,80,15);
        panel.add(r1);

        r2=new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setBackground(new Color(109,164,170));
        r2.setForeground(Color.WHITE);
        r2.setBounds(350,191,80,15);
        panel.add(r2);

        JLabel labelDisease=new JLabel("Disease:");
        labelDisease.setBounds(35,231,200,14);
        labelDisease.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDisease.setForeground(Color.white);
        panel.add(labelDisease);

        textdisease=new JTextField();
        textdisease.setBounds(271,231,150,20);
        panel.add(textdisease);

        JLabel labelroom=new JLabel("Room:");
        labelroom.setBounds(35,274,200,14);
        labelroom.setFont(new Font("Tahoma",Font.BOLD,14));
        labelroom.setForeground(Color.white);
        panel.add(labelroom);

        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet resultset=c.statement.executeQuery("select * from Room");
            while(resultset.next()){
                c1.add(resultset.getString("room_no"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("Taoma",Font.BOLD,14));
        c1.setBackground(new Color(3,45,48));
        c1.setForeground(Color.white);
        panel.add(c1);

        JLabel labeltime=new JLabel("Time:");
        labeltime.setBounds(35,316,200,14);
        labeltime.setFont(new Font("Tahoma",Font.BOLD,14));
        labeltime.setForeground(Color.white);
        panel.add(labeltime);

        Date date1=new Date();
        date=new JLabel(""+date1);
        date.setBounds(271,316,250,14);
        date.setForeground(Color.white);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(date);

        JLabel labelDeposit=new JLabel("Deposit:");
        labelDeposit.setBounds(35,359,200,14);
        labelDeposit.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDeposit.setForeground(Color.white);
        panel.add(labelDeposit);

        textdeposit=new JTextField();
        textdeposit.setBounds(271,359,150,20);
        panel.add(textdeposit);

        b1=new JButton("ADD");
        b1.setBounds(100,430,120,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        panel.add(b1);

        b2=new JButton("BACK");
        b2.setBounds(260,430,120,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        panel.add(b2);







        setSize(850,550);
        setLayout(null);
        setLocation(250,150);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            conn c=new conn();
            String radiobtn=null;
            if(r1.isSelected()){
                radiobtn="Male";
            }
            else if(r2.isSelected()){
                radiobtn="Female";
            }
            String s1=(String)combobox.getSelectedItem();
            String s2=textfieldnumber.getText();
            String s3=textname.getText();
            String s4=radiobtn;
            String s5=textdisease.getText();
            String s6=c1.getSelectedItem();
            String s7=date.getText();
            String s8=textdeposit.getText();
            try{
                String q="insert into patient_info values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1="update room set Availability='Occupied' where room_no = "+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);

                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);
            }
            catch(Exception E){
                E.printStackTrace();
            }

        }
        else{
            setVisible(false);
        }

    }
    public static void main(String args[]){
        new newpatient();
    }


}
