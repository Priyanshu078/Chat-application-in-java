package chatapplication;
import java.awt.*;  
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
public class Server extends JFrame implements ActionListener{
    JPanel p1;
    JTextField t1;
    JButton b1,b2;
    static JTextArea a1;
    
    static ServerSocket skt;
    static Socket s;
    static DataInputStream Din;
    static DataOutputStream Dout;
    
    Server() {
        
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("C:\\Users\\#Priyanshu Palliwal\\Desktop\\chatapp\\ChatApplication\\src\\chatapplication\\icons\\3.png"));
//        Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l1 = new JLabel(i3);
//        l1.setBounds(5, 17, 30, 30);
//        add(l1);
        setSize(450, 700);
        setLocation(200,100);
        
        getContentPane().setBackground(Color.white);
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.cyan);
        p1.setBounds(0,0,450,70);
        add(p1);
        
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chatapplication/icons/3icon.png"));
//        Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l4 = new JLabel(i3);
//        l4.setBounds(5, 17, 30, 30);
//        p1.add(l4);

        t1 = new JTextField();
        t1.setBounds(5, 640, 280, 50);
        t1.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
        add(t1);
        
        b1 = new JButton("Send");
        b1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        b1.setBackground(Color.CYAN);
        b1.setBounds(290, 640,75, 50);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Close");
        b2.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        b2.setBackground(Color.RED);
        b2.setForeground(Color.white);
        b2.setBounds(370,640,75,50);
        add(b2);
        
        a1 = new JTextArea();
        a1.setBounds(5, 75, 440, 560);
        a1.setBackground(Color.pink);
        a1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        a1.setEditable(false);
        a1.setWrapStyleWord(true);
        a1.setLineWrap(true);
        add(a1);
        
        b2.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent ae){
               System.exit(0);
           }
        });
                
        JLabel l1,l2; 
        l1=new JLabel("SERVER"); 
        l1.setFont(new Font("SAN_SERIF",Font.BOLD,30));
        l1.setBounds(150,30,150,30);  
        l2=new JLabel("");  
//        l2.setBounds(50,100,100,30);  
        p1.add(l1); 
        add(l2);
        l1.setLayout(null);
        setUndecorated(true);
        
        
//        setVisible(true);
//        JLabel l3  = new JLabel("SERVER");
//        l3.setBounds(200,20,10,);
//        add(l3);
    }
     public void actionPerformed(ActionEvent ae){
        try{
            String out = t1.getText();
            a1.setText(a1.getText()+"\n\t\t"+out);
            t1.setText("");
            Dout.writeUTF(out);
        }catch(Exception e){
        }
    }
    public static void main(String[] args){
        new Server().setVisible(true);
        
        String messageInput = "";
        
        try{
            skt = new ServerSocket(6001);
            while(true){
                s = skt.accept();
                Din = new DataInputStream(s.getInputStream());
                Dout = new DataOutputStream(s.getOutputStream());
                while(true){
                messageInput = Din.readUTF();
                a1.setText(a1.getText()+"\n" + messageInput);
                }
//                skt.close();
//                s.close();
            }
        }catch(Exception e){
            
        }
    }
}
