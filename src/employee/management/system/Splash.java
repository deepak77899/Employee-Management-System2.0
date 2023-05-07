package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {
    
    Splash() {
        
        setLayout(new FlowLayout());
        
        //Screen Dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int widthScreen = screenSize.width;
        final int heightScreen = screenSize.height;
        
        //Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        
        //Heading
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM",SwingConstants.CENTER);
        heading.setPreferredSize(new Dimension(1200,60));
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.RED);
        
        
        
        //Continue Button
        JButton clickhere = new JButton("Login As Admin");
        clickhere.setPreferredSize(new Dimension(300,70));
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        
        //Continue Button
        JButton clickhere2 = new JButton("Login As Employee");
        clickhere2.setPreferredSize(new Dimension(300,70));
        clickhere2.setBackground(Color.BLACK);
        clickhere2.setForeground(Color.WHITE);
        clickhere2.addActionListener(this);
        
        //panel for all content
        JPanel p=new JPanel();
        p.setPreferredSize(new Dimension(widthScreen,heightScreen));
        p.setOpaque(false);
        p.setLayout(new GridLayout(2,1));
        p.add(heading);
        
        //panel for buttons
        JPanel pbtn=new JPanel();
        GridBagLayout g=new GridBagLayout();
        GridBagConstraints gbc=new GridBagConstraints();
        pbtn.setLayout(g);
        
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=2;
        
        pbtn.add(clickhere,gbc);
        gbc.gridx=2;
        gbc.gridy=0;
        pbtn.add(clickhere2,gbc);
        pbtn.setOpaque(false);
        
        p.add(pbtn);
        
        //adding image to the background
       JLabel backImage=new JLabel(i1);
       backImage.setPreferredSize(new Dimension(i1.getIconWidth(), i1.getIconHeight()));
       backImage.setLayout(new FlowLayout());
        backImage.add(p);
       
        setContentPane(backImage);
        setSize(1170, 650);
        setLocation(100, 50);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String args[]) {
        new Splash();
    }
}
