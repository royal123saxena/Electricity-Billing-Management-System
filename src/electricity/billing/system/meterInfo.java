package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class meterInfo extends JFrame implements ActionListener {

    Choice meterLocCho,meterTypeCho,phaseCodeCho,billTypeCho;

    JButton submit;
    String meternumber;
    meterInfo(String meternumber){
        this.meternumber = meternumber;

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahome",Font.BOLD,20));
        panel.add(heading);

        JLabel meterNumber = new JLabel("Meter number");
        meterNumber.setBounds(50,80,100,20);
        panel.add(meterNumber);

        JLabel meternumberText = new JLabel(meternumber);
        meternumberText.setBounds(180,80,150,20);
        panel.add(meternumberText);

        JLabel meterLoc = new JLabel("Meter number");
        meterLoc.setBounds(50,120,100,20);
        panel.add(meterLoc);

        meterLocCho = new Choice();
        meterLocCho.add("Outside");
        meterLocCho.add("Inside");
        meterLocCho.setBounds(180,120,150,20);
        panel.add(meterLocCho);

        JLabel meterType = new JLabel("Meter Type");
        meterType.setBounds(50,160,100,20);
        panel.add(meterType);

        meterTypeCho = new Choice();
        meterTypeCho.add("Electric Meter");
        meterTypeCho.add("Solar Meter");
        meterTypeCho.add("Smart Meter");
        meterTypeCho.setBounds(180,160,150,20);
        panel.add(meterTypeCho);

        JLabel phaseCode = new JLabel("Phase Code");
        phaseCode.setBounds(50,200,100,20);
        panel.add(phaseCode);

        phaseCodeCho = new Choice();
        phaseCodeCho.add("111");
        phaseCodeCho.add("222");
        phaseCodeCho.add("333");
        phaseCodeCho.add("444");
        phaseCodeCho.add("555");
        phaseCodeCho.add("666");
        phaseCodeCho.add("777");
        phaseCodeCho.add("888");
        phaseCodeCho.add("999");
        phaseCodeCho.setBounds(180,200,150,20);
        panel.add(phaseCodeCho);

        JLabel billType = new JLabel("Bill Type");
        billType.setBounds(50,240,100,20);
        panel.add(billType);

        billTypeCho = new Choice();
        billTypeCho.add("Normal");
        billTypeCho.add("Industrial");
        billTypeCho.setBounds(180,240,150,20);
        panel.add(billTypeCho);

        JLabel day = new JLabel("30 Days Billing Time");
        day.setBounds(50,280,150,20);
        panel.add(day);

        JLabel note = new JLabel("Note:-");
        note.setBounds(50,320,100,20);
        panel.add(note);

        JLabel note1 = new JLabel("By default Bill is Calculated for 30 Days only");
        note1.setBounds(50,340,300,20);
        panel.add(note1);

        submit = new JButton("Submit");
        submit.setBounds(220,390,100,20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        panel.add(submit);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/details.png"));
        Image i2 = i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imglabel = new JLabel(i3);
        add(imglabel,"East");

        setSize(700,500);
        setLocation(400,200);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit){
            String smeterNum = meternumber;
            String smeterLoc = meterLocCho.getSelectedItem();
            String smeterType = meterTypeCho.getSelectedItem();
            String sphaseCode = phaseCodeCho.getSelectedItem();
            String sbillType = billTypeCho.getSelectedItem();
            String sday = "30";

            String q1 = "insert into meter_info values('"+smeterNum+"','"+smeterLoc+"','"+smeterType+"','"+sphaseCode+"','"+sbillType+"','"+sday+"')";
            try {
                database c = new database();
                c.statement.executeUpdate(q1);

                JOptionPane.showMessageDialog(null,"Meter Information Submitted Successfully");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new meterInfo("");
    }
}
