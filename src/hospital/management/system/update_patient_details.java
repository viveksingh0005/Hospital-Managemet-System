package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {
    update_patient_details(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageicon=new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image=imageicon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageicon1=new ImageIcon(image);
        JLabel label=new JLabel(imageicon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1=new JLabel("Update Patient Details");
        label1.setBounds(125,11,250,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2=new JLabel("Name:");
        label2.setBounds(25,88,100,14);
        label2.setFont(new Font("Tahoma",Font.PLAIN,14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice=new Choice();
        choice.setBounds(248,85,140,25);
        panel.add(choice);

        try{
            conn c=new conn();
            ResultSet resultset = c.statement.executeQuery("select * from patient_info");
            while(resultset.next()){
                choice.add(resultset.getString("Name"));

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        JLabel label3=new JLabel("Room Number :");
        label3.setBounds(25,129,100,14);
        label3.setFont(new Font("Tahoma",Font.PLAIN,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField textfieldr=new JTextField();
        textfieldr.setBounds(248,129,140,20);
        panel.add(textfieldr);

        JLabel label4=new JLabel("In-Time :");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("Tahoma",Font.PLAIN,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField textfieldtime=new JTextField();
        textfieldtime.setBounds(248,174,140,20);
        panel.add(textfieldtime);

        JLabel label5=new JLabel("Amount Paid (Rs) :");
        label5.setBounds(25,216,130,14);
        label5.setFont(new Font("Tahoma",Font.PLAIN,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField textfieldamount=new JTextField();
        textfieldamount.setBounds(248,216,140,20);
        panel.add(textfieldamount);

        JLabel label6=new JLabel("Pending (Rs) :");
        label6.setBounds(25,261,100,14);
        label6.setFont(new Font("Tahoma",Font.PLAIN,14));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField textfieldpending=new JTextField();
        textfieldpending.setBounds(248,261,140,20);
        panel.add(textfieldpending);

        JButton check=new JButton("Check");
        check.setBounds(340,370,120,30);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=choice.getSelectedItem();
                String q="select * from patient_info where Name = '"+id+"'";
                try{
                    conn c=new conn();
                    ResultSet resultset=c.statement.executeQuery(q);
                    while(resultset.next()){
                        textfieldr.setText(resultset.getString("Room_number"));
                        textfieldtime.setText(resultset.getString("Time"));
                        textfieldamount.setText(resultset.getString("Deposit"));


                    }
                    ResultSet resultset1=c.statement.executeQuery("select * from room where room_no = '"+textfieldr.getText()+"'");
                    while(resultset1.next()){
                        String price=resultset1.getString("Price");
                        int amountPaid=Integer.parseInt(price)-Integer.parseInt(textfieldamount.getText());
                        textfieldpending.setText(""+amountPaid);
                    }

                }catch(Exception E){
                    E.printStackTrace();

                }
            }
        });

        JButton update=new JButton("Update");
        update.setBounds(56,370,120,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c=new conn();
                    String q=choice.getSelectedItem();
                    String room=textfieldr.getText();
                    String time=textfieldtime.getText();
                    String amount=textfieldamount.getText();
                    c.statement.executeUpdate("update patient_info set Room_number = '"+room+"','"+time+"','"+amount+"',Deposit='"+amount+"'");
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);
                }
                catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back=new JButton("Back");
        back.setBounds(200,370,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setSize(950,500);
        setLayout(null);
        setLocation(200,150);
        setVisible(true);
    }
    public static void main(String args[]){
        new update_patient_details();
    }
}
