import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginPage extends JFrame{
    private JPanel contentPane;
    private JTextField Username;
    private JPasswordField Password;
    private JButton btnLButton;
    private JButton goToHome;
    private JButton back;
    public LoginPage(String title) {
        super(title);
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\img.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 650);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new LineBorder(Color.ORANGE, 100));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel signIn=new JLabel("Sign in");
        signIn.setBounds(400,100,200,50);
        signIn.setFont(new Font("AR DELANEY",Font.ITALIC,50));
        signIn.setForeground(Color.blue);
        contentPane.add(signIn);

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
        goToHome.setBounds(100,165,56,57);
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
        back.setBounds(100,100,56,57);
        contentPane.add(back);

        JLabel userName=new JLabel("User Name");
        userName.setBounds(200,200,150,40);
        userName.setFont(new Font("Tahoma",Font.PLAIN,25));
        contentPane.add(userName);

        JLabel password=new JLabel("Password");
        password.setBounds(200,300,150,40);
        password.setFont(new Font("Tahoma",Font.PLAIN,25));
        contentPane.add(password);

        Username=new JTextField();
        Username.setFont(new Font("Tahoma",Font.PLAIN,25));
        Username.setBounds(400,200,300,50);
        contentPane.add(Username);

        Password=new JPasswordField();
        Password.setFont(new Font("Tahoma",Font.PLAIN,25));
        Password.setBounds(400,300,300,50);
        contentPane.add(Password);

        btnLButton=new JButton("Sign in");
        btnLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName=Username.getText();
                String passWord= String.valueOf(Password.getPassword());
                try{
                    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/registeredcustomers","root","swetha@02");
                    String query = "SELECT * FROM table1 where userName='"+userName+"' and password='"+passWord+"'";
                    Statement sta=connection.createStatement();
                    ResultSet x=sta.executeQuery(query);
                    if(!(x.next())){
                        JOptionPane.showMessageDialog(btnLButton,"Please enter correct details");
                        dispose();
                        LoginPage loginPage=new LoginPage("BSmart");
                        loginPage.setLocationRelativeTo(null);
                        loginPage.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(btnLButton,"logged in successfully");
                        dispose();
                        Shop s=new Shop("BSmart",userName);
                        s.setLocationRelativeTo(null);
                        s.setVisible(true);
                    }
                    connection.close();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        btnLButton.setFont(new Font("Tahoma",Font.PLAIN,25));
        btnLButton.setBounds(400,400,150,50);
        contentPane.add(btnLButton);
    }
}
