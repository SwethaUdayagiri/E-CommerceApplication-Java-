
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UserRegistration extends JFrame {
    private static final long serialVersionUID=1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField username;
    private JTextField mob;
    private JPasswordField passwordField;
    private JTextField address;
    private JButton btnNewButton;
    private JButton goToHome;
    private JButton back;
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    HomePage hm=new HomePage("HomePage");
                    hm.setLocationRelativeTo(null);
                    hm.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public UserRegistration(String title){
        super(title);
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\img.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450,190,1014,650);
        setResizable(false);
        contentPane=new JPanel();
        contentPane.setBorder(new LineBorder(Color.ORANGE,10,true));
        contentPane.setBackground(Color.lightGray);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister=new JLabel("Complete your Profile");
        lblNewUserRegister.setFont(new Font("Times New Roman",Font.BOLD,30));
        lblNewUserRegister.setBounds(362,25,325,50);
        contentPane.add(lblNewUserRegister);

        ImageIcon imgThisImg = new ImageIcon("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\profile.png");
        JLabel profile=new JLabel();
        profile.setIcon(imgThisImg);
        profile.setBounds(450,75,95,95);
        contentPane.add(profile);

        JLabel lblName=new JLabel("First Name");
        lblName.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblName.setBounds(58,170,99,43);
        contentPane.add(lblName);

        JLabel lblLName=new JLabel("Last Name");
        lblLName.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblLName.setBounds(58,230,110,43);
        contentPane.add(lblLName);

        JLabel lblEmailAddress = new JLabel("Email address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEmailAddress.setBounds(58, 290, 124, 36);
        contentPane.add(lblEmailAddress);

        firstname=new JTextField();
        firstname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        firstname.setBounds(214,169,228,40);
        firstname.setColumns(10);
        contentPane.add(firstname);

        lastname=new JTextField();
        lastname.setFont(new Font("Times New Roman",Font.PLAIN,18));
        lastname.setBounds(214,229,228,40);
        lastname.setColumns(10);
        contentPane.add(lastname);

        email=new JTextField();
        email.setFont(new Font("Times New Roman",Font.PLAIN,18));
        email.setBounds(214,289,228,40);
        email.setColumns(20);
        contentPane.add(email);

        JLabel lblUserName=new JLabel("User Name");
        lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUserName.setBounds(542,170,99,43);
        contentPane.add(lblUserName);

        JLabel lblPassword=new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPassword.setBounds(542,230,99,43);
        contentPane.add(lblPassword);

        JLabel lblMobile=new JLabel("Mobile Number");
        lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMobile.setBounds(542,290, 124, 36);
        contentPane.add(lblMobile);

        username=new JTextField();
        username.setFont(new Font("Times New Roman",Font.PLAIN,18));
        username.setBounds(707,169,228,40);
        username.setColumns(10);
        contentPane.add(username);

        passwordField=new JPasswordField();
        passwordField.setFont(new Font("Times New Roman",Font.PLAIN,18));
        passwordField.setBounds(707,229,228,40);
        contentPane.add(passwordField);

        mob=new JTextField();
        mob.setFont(new Font("Times New Roman",Font.PLAIN,18));
        mob.setBounds(707,289,228,40);
        mob.setColumns(10);
        contentPane.add(mob);

        JLabel lblAddress=new JLabel("Address");
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAddress.setBounds(58, 350, 124, 36);
        contentPane.add(lblAddress);

        address=new JTextField();
        address.setFont(new Font("Times New Roman",Font.PLAIN,18));
        address.setBounds(214,350,700,150);
        contentPane.add(address);

        btnNewButton=new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName=firstname.getText();
                String lastName=lastname.getText();
                String emailId= email.getText();
                String userName=username.getText();
                String mobileNumber=mob.getText();
                String Address= address.getText();
                String password= String.valueOf(passwordField.getPassword());
                int len=mobileNumber.length();
                String msg=""+firstName;
                msg+="\n";
                if(len!=10){
                    JOptionPane.showMessageDialog(btnNewButton,"Enter a valid mobile number");
                }
                try{
                    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/registeredcustomers","root","swetha@02");
                    String query = "INSERT INTO table1 (firstName,lastName,email,userName,mobileNum,password,address)values('" + firstName + "','" + lastName + "','" + emailId+"','"+userName +"','"
                            + mobileNumber + "','" +password+"','"+Address+"')";
                    Statement sta=connection.createStatement();
                    int x=sta.executeUpdate(query);
                    if(x==0){
                        JOptionPane.showMessageDialog(btnNewButton,"you are already registered, Please Log in");
                    }
                    else{
                        JOptionPane.showMessageDialog(btnNewButton,"Welcome, "+msg+"Your account has been successfully created");
                    }
                    connection.close();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
                try{
                    dispose();
                    HomePage hm=new HomePage("HomePage");
                    hm.setLocationRelativeTo(null);
                    hm.setVisible(true);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma",Font.PLAIN,20));
        btnNewButton.setBounds(450,520,150,50);
        contentPane.add(btnNewButton);

        goToHome=new JButton();
        goToHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dispose();
                    HomePage hm=new HomePage("HomePage");
                    hm.setLocationRelativeTo(null);
                    hm.setVisible(true);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        ImageIcon home = new ImageIcon("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\home.png");
        goToHome.setIcon(home);
        goToHome.setBounds(10,70,56,57);
        contentPane.add(goToHome);

        back=new JButton();
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dispose();
                    HomePage hm=new HomePage("HomePage");
                    hm.setLocationRelativeTo(null);
                    hm.setVisible(true);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        ImageIcon Back = new ImageIcon("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\back.png");
        back.setIcon(Back);
        back.setBounds(10,10,56,57);
        contentPane.add(back);
    }
}
