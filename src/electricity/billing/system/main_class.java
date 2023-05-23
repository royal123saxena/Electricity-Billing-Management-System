package electricity.billing.system;

import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {

    String acctype;
    String meter_pass;
    main_class(String acctype, String meter_pass){
        this.meter_pass = meter_pass;
        this.acctype = acctype;
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/ebs.png"));
        Image image = imageIcon.getImage().getScaledInstance(1530,830,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imagelable = new JLabel(imageIcon2);
        add(imagelable);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("Serif",Font.PLAIN,18));


        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospace",Font.BOLD,15));
        ImageIcon customerImg = new ImageIcon(ClassLoader.getSystemResource("Icon/newcustomer.png"));
        Image customerImage = customerImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(customerImage));
        newcustomer.addActionListener(this);
        menu.add(newcustomer);

        JMenuItem customerDetails = new JMenuItem("Customer Details");
        customerDetails.setFont(new Font("monospace",Font.BOLD,15));
        ImageIcon customerDetailsImg = new ImageIcon(ClassLoader.getSystemResource("Icon/customerDetails.png"));
        Image customerDetailsImage = customerDetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerDetails.setIcon(new ImageIcon(customerDetailsImage));
        customerDetails.addActionListener(this);
        menu.add(customerDetails);

        JMenuItem depositDetails = new JMenuItem("Deposit Details");
        depositDetails.setFont(new Font("monospace",Font.BOLD,15));
//        ImageIcon depositDetailsImg = new ImageIcon(ClassLoader.getSystemResource("Icon/depositDetails.png"));
//        Image depositDetailsImage = depositDetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
//        depositDetails.setIcon(new ImageIcon(depositDetailsImage));
        depositDetails.addActionListener(this);
        menu.add(depositDetails);

        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospace",Font.BOLD,15));
        ImageIcon calculatebillImg = new ImageIcon(ClassLoader.getSystemResource("Icon/calculatorbills.png"));
        Image calculatebillImage = calculatebillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(calculatebillImage));
        calculatebill.addActionListener(this);
        menu.add(calculatebill);

        JMenu info = new JMenu("Information");
        info.setFont(new Font("Serif",Font.PLAIN,18));

        JMenuItem upinfo = new JMenuItem("Update Information");
        upinfo.setFont(new Font("monospace",Font.BOLD,15));
        ImageIcon upinfoImg = new ImageIcon(ClassLoader.getSystemResource("Icon/refresh.png"));
        Image upinfoImage = upinfoImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        upinfo.setIcon(new ImageIcon(upinfoImage));
        upinfo.addActionListener(this);
        info.add(upinfo);

        JMenuItem viewInfo = new JMenuItem("View Information");
        viewInfo.setFont(new Font("monospace",Font.BOLD,15));
        ImageIcon viewInfoImg = new ImageIcon(ClassLoader.getSystemResource("Icon/information.png"));
        Image viewInfoImage = viewInfoImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewInfo.setIcon(new ImageIcon(viewInfoImage));
        viewInfo.addActionListener(this);
        info.add(viewInfo);

        JMenu user = new JMenu("User");
        user.setFont(new Font("Serif",Font.PLAIN,18));

        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospace",Font.BOLD,15));
        ImageIcon paybillImg = new ImageIcon(ClassLoader.getSystemResource("Icon/pay.png"));
        Image paybillImage = paybillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(paybillImage));
        paybill.addActionListener(this);
        user.add(paybill);

        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospace",Font.BOLD,15));
        ImageIcon billdetailsImg = new ImageIcon(ClassLoader.getSystemResource("Icon/detail.png"));
        Image billdetailsImage = billdetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(billdetailsImage));
        billdetails.addActionListener(this);
        user.add(billdetails);

        JMenu bill = new JMenu("Bill");
        bill.setFont(new Font("Serif",Font.PLAIN,18));


        JMenuItem genBill = new JMenuItem("Generate Bill");
        genBill.setFont(new Font("monospace",Font.BOLD,15));
        ImageIcon genBillImg = new ImageIcon(ClassLoader.getSystemResource("Icon/bill.png"));
        Image genBillImage = genBillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        genBill.setIcon(new ImageIcon(genBillImage));
        genBill.addActionListener(this);
        bill.add(genBill);

        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("Serif",Font.PLAIN,18));

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospace",Font.BOLD,15));
        ImageIcon notepadImg = new ImageIcon(ClassLoader.getSystemResource("Icon/notepad.png"));
        Image notepadImage = notepadImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(notepadImage));
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospace",Font.BOLD,15));
        ImageIcon calculatorImg = new ImageIcon(ClassLoader.getSystemResource("Icon/calculator.png"));
        Image calculatorImage = calculatorImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(calculatorImage));
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("Serif",Font.PLAIN,18));

        JMenuItem eexit = new JMenuItem("Exit");
        eexit.setFont(new Font("monospace",Font.BOLD,15));
        ImageIcon eexitIMG = new ImageIcon(ClassLoader.getSystemResource("Icon/exit.png"));
        Image eexitImage = eexitIMG.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        eexit.setIcon(new ImageIcon(eexitImage));
        eexit.addActionListener(this);
        exit.add(eexit);


        if (acctype.equals("Admin")) {
            menuBar.add(menu);
        }else {
            menuBar.add(bill);
            menuBar.add(user);
            menuBar.add(info);
        }
        menuBar.add(utility);
        menuBar.add(exit);

        setLayout(new FlowLayout());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if (msg.equals("New Customer")){
            new newCustomer();
        } else if (msg.equals("Customer Details")) {
            new customer_details();
        } else if (msg.equals("Deposit Details")) {
            new deposit_detail();
        } else if (msg.equals("Calculate Bill")) {
            new calculate_bill();
        } else if (msg.equals("View Information")) {
            new view_information(meter_pass);
        } else if (msg.equals("Update Information")) {
            new update_information(meter_pass);
        } else if (msg.equals("Bill Details")) {
            new bill_detail(meter_pass);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (msg.equals("Exit")) {
            setVisible(false);
            new Login();
        } else if (msg.equals("Pay Bill")) {
            new pay_bill(meter_pass);
        } else if (msg.equals("Generate Bill")) {
            new generate_bill(meter_pass);
        }

    }

    public static void main(String[] args) {
        new main_class("","");
    }
}
