package finalproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

 class StudentManagement extends JFrame{
    private Container C;
    private JLabel L,L1,L2,User,Pass;
    private Font F;
    private JButton Yes,No,Login,Clear;
    private JTextField TF;
    private JPasswordField PF;
    public StudentManagement(){
    
    Component();

    }
    public void Component(){
    
    C=this.getContentPane();
    C.setLayout(null);
    C.setBackground(Color.black);
    F=new Font("Arial",Font.BOLD,24);
    
    L=new JLabel(":Student Management:");
    L.setBounds(350,30,1000,150);
    L.setFont(F);
    L.setForeground(Color.yellow);
    C.add(L);
    
     
    L2=new JLabel("::SET Student's Info(ADMIN)::");
    L2.setBounds(100,200,1000,50);
    L2.setFont(F);
    L2.setForeground(Color.green);
    C.add(L2);
    
    User=new JLabel("USERNAME :");
    User.setBounds(100,300,1000,50);
    User.setFont(F);
    User.setForeground(Color.green);
    C.add(User);
   
    TF=new JTextField();
    TF.setFont(F);
    TF.setBounds(300,300,200,50);
    C.add(TF);
    
    Pass=new JLabel("PASSWORD :");
    Pass.setBounds(100,400,1000,50);
    Pass.setFont(F);
    Pass.setForeground(Color.green);
    C.add(Pass);
    
    PF=new JPasswordField();
    PF.setBounds(300,400, 200,50);
    PF.setFont(F);
    C.add(PF);
    
     Login=new JButton("LOGIN");
     Login.setBounds(300,500,110,50);
     Login.setFont(F);
     C.add(Login);
     
    Clear=new JButton("CLEAR");
    Clear.setBounds(420,500,120,50);
    Clear.setFont(F);
    C.add(Clear);
    
        Clear.addActionListener(new ActionListener(){
       // @Override
        public void actionPerformed(ActionEvent ae) {
        
        TF.setText("");
        PF.setText("");
            
        }
     
     });
        
           Login.addActionListener(new ActionListener(){
       // @Override
        public void actionPerformed(ActionEvent ae) {
        
            String Username=TF.getText();
            String Password=PF.getText();
            
           if(Username.equals("Saad") && Password.equals("123456")){
           
        JOptionPane.showMessageDialog(null,"Successfully Login");
        StudentManagement2 SM2=new StudentManagement2();
            SM2.setVisible(true);

           }
           else{
           
           JOptionPane.showMessageDialog(null,"Wrong Pass or User Name Try Again");
           
           }   
        } 
     });
    }
    public static void main(String[] args) {
        
    StudentManagement F=new StudentManagement();

    F.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    F.setBounds(500, 70, 1000,800);
    F.setResizable(false);
    F.setVisible(true);

    }
}