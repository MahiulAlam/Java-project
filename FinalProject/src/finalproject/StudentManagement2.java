package finalproject;
import java.io.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
                                  
    class StudentManagement2 extends JFrame implements ActionListener {
                         
    private JTable TA;
    public JScrollPane scroll,scroll1;//scrollable view of a component
    private DefaultTableModel DTM;//implementation of TableModel
    private Container Co;// contain other components inside itself
    private JLabel title,name,number,id,cgpa,Info;
    private JTextField NA_TF1,NUM_TF2,ID_TF3,CGA_TF4;
    private JTextArea JT;
    private Font F1;
    private JButton add,delete,update,clear,all;
    private String[] column={"Name","Number","Student ID","Student CGPA"};
    private String[] row=new String[4];
    
    StudentManagement2(){
                      
    IntComponent();//(method)
                      
    }  
    public void IntComponent(){
      this.setBounds(500,30,950,940);
      this.setResizable(false);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    Co=this.getContentPane();
    Co.setLayout(null);
    Co.setBackground(Color.gray);
    
    
    
    name=new JLabel("Enter Name              :");
    name.setBounds(20,130,500,50);
    name.setForeground(Color.blue);
    F1=new Font("Arial,",Font.BOLD,24);
    name.setFont(F1);
    Co.add(name);
    
    title=new JLabel("::: STUDENT INFORMATION :::");
    title.setBounds(320,20,500,50);
    title.setForeground(Color.black);
    title.setFont(F1);
    Co.add(title);
    
    NA_TF1=new JTextField();
    NA_TF1.setBounds(270,130,220,50);
    NA_TF1.setFont(F1);
    Co.add(NA_TF1);
    
    
    number=new JLabel("Enter Your Number  :");
    number.setBounds(20,210,500,50);
    number.setForeground(Color.blue);
    number.setFont(F1);
    Co.add(number);
    
    NUM_TF2=new JTextField();
    NUM_TF2.setBounds(270,210,220,50);
    NUM_TF2.setFont(F1);
    Co.add(NUM_TF2);
    
    id=new JLabel("Enter Your ID           :");
    id.setBounds(20,290,500,50);
    id.setForeground(Color.blue);
    id.setFont(F1);
    Co.add(id);
    
    ID_TF3=new JTextField();
    ID_TF3.setBounds(270,290,220,50);
    ID_TF3.setFont(F1);
    Co.add(ID_TF3);
    
    cgpa=new JLabel("Enter Your CGPA     :");
    cgpa.setBounds(20,370,500,50);
    cgpa.setForeground(Color.blue);
    cgpa.setFont(F1);
    Co.add(cgpa);
    
    CGA_TF4=new JTextField();
    CGA_TF4.setBounds(270,370,220,50);
    CGA_TF4.setFont(F1);
    Co.add(CGA_TF4);
    
    add=new JButton("Add");
    add.setBounds(600,130,120,50);
    add.setForeground(Color.red);
    add.setBackground(Color.black);
    add.setFont(F1);
    Co.add(add);
    
    delete=new JButton("Delete");
    delete.setBounds(600,210,120,50);
    delete.setForeground(Color.red);
    delete.setBackground(Color.black);
    delete.setFont(F1);
    Co.add(delete);
    
    update=new JButton("Update");
    update.setBounds(600,290,120,50);
    update.setForeground(Color.red);
    update.setBackground(Color.black);
    update.setFont(F1);
    Co.add(update);
    
    clear=new JButton("Clear");
    clear.setBounds(600,370,120,50);
    clear.setForeground(Color.red);
    clear.setBackground(Color.black);
    clear.setFont(F1);
    Co.add(clear);
   
    add.addActionListener(this);
    clear.addActionListener(this);
    delete.addActionListener(this);
    update.addActionListener(this);
     
    TA=new JTable();
    DTM=new DefaultTableModel();
    DTM.setColumnIdentifiers(column);
    TA.setModel(DTM);
    TA.setFont(F1);
  
    TA.setBackground(Color.orange);
    TA.setSelectionBackground(Color.green);
    TA.setRowHeight(30);
  
    scroll=new JScrollPane(TA);
    scroll.setBounds(40,450,740,265);
    Co.add(scroll);
    
    
    Info=new JLabel("Press Button To Show All Student Info:");
    Info.setBounds(40,728,500,50);
    Info.setForeground(Color.orange);
    Info.setFont(F1);
    Co.add(Info);
    
    
    all=new JButton("ALL Info");
    all.setBounds(600,728,150,50);
    all.setForeground(Color.red);
    all.setBackground(Color.black);
    all.setFont(F1);
    Co.add(all);
    
    JT=new JTextArea();
    JT.setBounds(40,800,740,80);
    JT.setFont(F1);
    Co.add(JT);
    scroll1=new JScrollPane(JT);
    scroll1.setBounds(40,800,740,80);
    Co.add(scroll1);
   
     all.addActionListener(new ActionListener(){
            
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            {}  
                       
        try{ 
            File file = new File("E:/FinalProject/Student info.txt");

           BufferedReader in = new BufferedReader(new FileReader(file));
           String line = in.readLine();
           while(line != null){
            JT.append(line + "\n");
             line = in.readLine();
              }
        }
             
             catch(Exception e){
                 System.out.println(e);    
              }
            
        }
     
     });

     TA.addMouseListener(new MouseAdapter(){
         
     public void mouseClicked(MouseEvent me){
     
     int R1=TA.getSelectedRow();
     
    String nName= DTM.getValueAt(R1,0).toString();
    String nNumber= DTM.getValueAt(R1,1).toString();
    String iId= DTM.getValueAt(R1,2).toString();
    String cCgpa= DTM.getValueAt(R1,3).toString();
     
    NA_TF1.setText(nName);// Clicked value show on Screen;
    NUM_TF2.setText(nNumber);// Clicked value show on Screen;
    ID_TF3.setText(iId);// Clicked value show on Screen;
    CGA_TF4.setText(cCgpa);// Clicked value show on Screen;
     
     } 
     });
        
    }
    
@Override
    public void actionPerformed(ActionEvent ae) {
        
    if(ae.getSource()==add){
             
            row[0]=NA_TF1.getText();
            row[1]=NUM_TF2.getText();
            row[2]=ID_TF3.getText();
            row[3]=CGA_TF4.getText();
            DTM.addRow(row);
            
            
            try{   
         
             FileOutputStream fout=new FileOutputStream("Student info.txt",true);    
                     String  s=NA_TF1.getText()+" ";
                     
			  if(s.length()>1){
				byte b[]=s.getBytes();//converting string into byte array    
				fout.write(b);    
				fout.close();    
				System.out.println("Done!!");
				//NA_TF1.setText("Write something?");
                              
        }
			}
        
          catch(Exception ex){
				System.out.println(ex);
			}
            
           try{   
             FileOutputStream fout=new FileOutputStream("Student info.txt",true);    
                     String  s=NUM_TF2.getText()+" ";
                     
			if(s.length()>1){
				byte b[]=s.getBytes();//converting string into byte array    
				fout.write(b);    
				fout.close();    
				System.out.println("Done!!");
				//NUM_TF2.setText("Write something?");
           }                  
			}
          catch(Exception ex){
				System.out.println(ex);
			}
           
           try{   
         
             FileOutputStream fout=new FileOutputStream("Student info.txt",true);    
                     String  s=ID_TF3.getText()+" ";
                     
			  if(s.length()>1){
				byte b[]=s.getBytes();//converting string into byte array    
				fout.write(b);    
				fout.close();    
				System.out.println("Done!!");
				//ID_TF3.setText("Write something ");                     
        }
			}
          catch(Exception ex){
				System.out.println(ex);
			}
           
           try{   
             FileOutputStream fout=new FileOutputStream("Student info.txt",true);    
                     String  s=CGA_TF4.getText()+"\n";
                     
			  if(s.length()>1){
				byte b[]=s.getBytes();//converting string into byte array    
				fout.write(b);    
				fout.close();    
				System.out.println("Done!!");
				//CGA_TF4.setText("Write something ");                  
        }
			}
          catch(Exception ex){
				System.out.println(ex);
			}
            
        }
         else if(ae.getSource()==clear){
             
        NUM_TF2.setText(" ");
        ID_TF3.setText(" ");
        NA_TF1.setText(" ");
        CGA_TF4.setText(" ");
        
        }
        
        
         else if(ae.getSource()==delete){
         
         int ROW = TA.getSelectedRow();
         
         if(ROW>=0){
         
          DTM.removeRow(ROW);
         
         }
         else{

         JOptionPane.showMessageDialog(null,"Don't select Row/s or No row There!!");
         
         }
         }
        
         else if(ae.getSource()==update){
             
             
             int NROW=TA.getSelectedRow();
             
             String Fname=NA_TF1.getText();
             String Fnumber=NUM_TF2.getText();
             String FID=ID_TF3.getText();
             String Fcgpa=CGA_TF4.getText();
                   
             DTM.setValueAt(Fname, NROW,0);
             DTM.setValueAt(Fnumber, NROW,1);
             DTM.setValueAt(FID, NROW,2);
             DTM.setValueAt(Fcgpa, NROW,3);
                  
         }
    }  
    public static void main(String[] args) {

            StudentManagement2 SM2=new StudentManagement2();
            SM2.setVisible(true);    
    }
    }