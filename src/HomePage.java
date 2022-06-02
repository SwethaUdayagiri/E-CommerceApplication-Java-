import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {
    private JPanel contentPane;
    private JButton btnButton1;
    private JButton btnButton2;
    public HomePage(String title) {
        super(title);
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\img.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 650);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new LineBorder(Color.ORANGE, 10, true));
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister=new JLabel("BSmart");
        lblNewUserRegister.setFont(new Font("AR DELANEY",Font.ITALIC,50));
        lblNewUserRegister.setForeground(Color.blue);
        lblNewUserRegister.setBounds(390,25,180,40);
        contentPane.add(lblNewUserRegister);

        ImageIcon imgThisImg = new ImageIcon("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\dummy.png");
        JLabel profile=new JLabel();
        profile.setIcon(imgThisImg);
        profile.setBounds(10,80,1000,250);
        contentPane.add(profile);

        JLabel lblCon1=new JLabel("Please sign in or register to buy");
        lblCon1.setFont(new Font("Tahoma",Font.PLAIN,25));
        lblCon1.setBounds(300,340,500,30);
        lblCon1.setForeground(Color.RED);
        contentPane.add(lblCon1);

        JLabel lblCon2=new JLabel("your favourite book...");
        lblCon2.setFont(new Font("Tahoma",Font.PLAIN,25));
        lblCon2.setBounds(350,380,500,43);
        lblCon2.setForeground(Color.RED);
        contentPane.add(lblCon2);

        btnButton1 = new JButton("Sign in");
        btnButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dispose();
                    LoginPage loginPage=new LoginPage("BSmart");
                    loginPage.setLocationRelativeTo(null);
                    loginPage.setVisible(true);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        btnButton1.setFont(new Font("Tahoma",Font.PLAIN,20));
        btnButton1.setBounds(300,450,150,50);
        contentPane.add(btnButton1);

        btnButton2=new JButton("Register");
        btnButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dispose();
                    UserRegistration frame=new UserRegistration("BSmart");
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        btnButton2.setFont(new Font("Tahoma",Font.PLAIN,20));
        btnButton2.setBounds(470,450,150,50);
        contentPane.add(btnButton2);
    }
}
