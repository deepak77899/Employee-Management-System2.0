package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    JButton view, add, update, remove,chat;
    String role;

    Home(String role) {
        this.role=role;
        setLayout(null);
        
        //Screen Dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int widthScreen = screenSize.width;
        final int heightScreen = screenSize.height;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(widthScreen, heightScreen, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, widthScreen, heightScreen);
        add(image);

        JLabel heading = new JLabel("Employee Management System");
        heading.setPreferredSize(new Dimension(1200,90));
        heading.setBounds(320, 110, 800, 80);
        heading.setFont(new Font("Raleway", Font.BOLD, 50));
        heading.setForeground(Color.WHITE);
        image.add(heading);

        add = new JButton("Add Employee");
        add.setBounds(500, 280, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFocusable(false);
        image.add(add);

        view = new JButton("View Employees");
        view.setBounds(700, 280, 150, 40);
        view.addActionListener(this);
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        view.setFocusable(false);
        image.add(view);

        update = new JButton("Update Employee");
        update.setBounds(500, 340, 150, 40);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFocusable(false);
        image.add(update);

        remove = new JButton("Remove Employee");
        remove.setBounds(700, 340, 150, 40);
        remove.addActionListener(this);
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
        remove.setFocusable(false);
        image.add(remove);
        
        chat = new JButton("Chat with Employees");
        chat.setBounds(600, 400, 150, 40);
        chat.addActionListener(this);
        chat.setBackground(Color.BLACK);
        chat.setForeground(Color.WHITE);
        chat.setFocusable(false);
        image.add(chat);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
              if(role.equals("Employee")){
                  chat.setText("Chat with HR");
                  chat.setBounds(widthScreen/2-75, heightScreen/2-20, 150, 40);
//                  heading.setBounds(390, 20, 400, 40);
                  heading.setForeground(Color.WHITE);
                  add.setVisible(false);
                  view.setVisible(false);
                  update.setVisible(false);
                  remove.setVisible(false);
              }
            }
        });
//        setSize(1120, 630);
        setLocation(100, 100);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee(role);
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployee(role);
        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewEmployee(role);
        }else if (ae.getSource() == chat) {
            setVisible(false);
            if(role.equals("Employee")){
                new Client(role);
            }else{
                new Server(role);
            }
        }
        else {
            setVisible(false);
            new RemoveEmployee(role);
        }
    }

    public static void main(String[] args) {
        new Home("Admin");
//        new Home("Employee");
    }
}
