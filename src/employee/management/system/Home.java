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

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(620, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);

        add = new JButton("Add Employee");
        add.setBounds(650, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View Employees");
        view.setBounds(820, 80, 150, 40);
        view.addActionListener(this);
        image.add(view);

        update = new JButton("Update Employee");
        update.setBounds(650, 140, 150, 40);
        update.addActionListener(this);
        image.add(update);

        remove = new JButton("Remove Employee");
        remove.setBounds(820, 140, 150, 40);
        remove.addActionListener(this);
        image.add(remove);
        
        chat = new JButton("Chat with Employees");
        chat.setBounds(750, 200, 150, 40);
        chat.addActionListener(this);
        image.add(chat);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
              if(role.equals("Employee")){
                  chat.setText("Chat with HR");
                  chat.setBounds(500, 300, 150, 40);
                  heading.setBounds(390, 20, 400, 40);
                  heading.setForeground(Color.WHITE);
                  add.setVisible(false);
                  view.setVisible(false);
                  update.setVisible(false);
                  remove.setVisible(false);
              }
            }
        });
        setSize(1120, 630);
        setLocation(100, 100);
        setVisible(true);
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
        
    }
}
