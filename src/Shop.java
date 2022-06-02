import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Shop extends JFrame {
    private JPanel contentPane;
    private JButton addToCart1;
    private JButton addToCart2;
    private JButton addToCart3;
    private JButton addToCart4;
    private JButton addToCart5;
    private JButton addToCart6;
    private JButton addToCart7;
    private JButton addToCart8;
    private JButton addToCart9;
    private JButton goToCart;
    private JButton goToHome;
    private JButton back;
    public Shop(String title,String user){
        super(title);
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\img.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450,190,1350,745);
        setResizable(false);
        contentPane=new JPanel();
        contentPane.setBorder(new LineBorder(Color.ORANGE,3,false));
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblShop=new JLabel("Buy your favourite book and fly in fantasy");
        lblShop.setBounds(400,10,550,30);
        lblShop.setFont(new Font("Tahoma",Font.BOLD,25));
        lblShop.setForeground(Color.blue);
        contentPane.add(lblShop);

        ImageIcon book1 = new ImageIcon("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\1.png");
        JLabel Book1=new JLabel();
        Book1.setIcon(book1);
        Book1.setBounds(5,60,200,270);
        contentPane.add(Book1);

        ImageIcon book2 = new ImageIcon("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\2.png");
        JLabel Book2=new JLabel();
        Book2.setIcon(book2);
        Book2.setBounds(215,60,200,270);
        contentPane.add(Book2);

        ImageIcon book3 = new ImageIcon("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\3.png");
        JLabel Book3=new JLabel();
        Book3.setIcon(book3);
        Book3.setBounds(425,60,200,270);
        contentPane.add(Book3);

        ImageIcon book4 = new ImageIcon("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\4.png");
        JLabel Book4=new JLabel();
        Book4.setIcon(book4);
        Book4.setBounds(635,60,200,270);
        contentPane.add(Book4);

        ImageIcon book5 = new ImageIcon("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\5.png");
        JLabel Book5=new JLabel();
        Book5.setIcon(book5);
        Book5.setBounds(845,60,200,270);
        contentPane.add(Book5);

        ImageIcon book6 = new ImageIcon("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\6.png");
        JLabel Book6=new JLabel();
        Book6.setIcon(book6);
        Book6.setBounds(1055,60,200,270);
        contentPane.add(Book6);

        addToCart1=new JButton("Add to cart");
        addToCart1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/registeredcustomers","root","swetha@02");
                    String query = "INSERT INTO cart values('BedTimeStories',108,'"+user+"')";
                    Statement sta=connection.createStatement();
                    int x=sta.executeUpdate(query);
                    if(x!=0){
                        JOptionPane.showMessageDialog(addToCart1,"added to cart");
                    }
                    else{
                        JOptionPane.showMessageDialog(addToCart1,"not added to cart");
                    }
                    connection.close();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        addToCart1.setFont(new Font("Tahoma",Font.PLAIN,12));
        addToCart1.setBounds(40,340,120,30);
        contentPane.add(addToCart1);

        addToCart2=new JButton("Add to cart");
        addToCart2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/registeredcustomers","root","swetha@02");
                    String query = "INSERT INTO cart values('Mahabharata',150,'"+user+"')";
                    Statement sta=connection.createStatement();
                    int x=sta.executeUpdate(query);
                    if(x!=0){
                        JOptionPane.showMessageDialog(addToCart2,"added to cart");
                    }
                    else{
                        JOptionPane.showMessageDialog(addToCart2,"not added to cart");
                    }
                    connection.close();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        addToCart2.setFont(new Font("Tahoma",Font.PLAIN,12));
        addToCart2.setBounds(250,340,120,30);
        contentPane.add(addToCart2);

        addToCart3=new JButton("Add to cart");
        addToCart3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/registeredcustomers","root","swetha@02");
                    String query = "INSERT INTO cart values('Panchatantra',162,'"+user+"')";
                    Statement sta=connection.createStatement();
                    int x=sta.executeUpdate(query);
                    if(x!=0){
                        JOptionPane.showMessageDialog(addToCart3,"added to cart");
                    }
                    else{
                        JOptionPane.showMessageDialog(addToCart3,"not added to cart");
                    }
                    connection.close();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        addToCart3.setFont(new Font("Tahoma",Font.PLAIN,12));
        addToCart3.setBounds(460,340,120,30);
        contentPane.add(addToCart3);

        addToCart4=new JButton("Add to cart");
        addToCart4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/registeredcustomers","root","swetha@02");
                    String query = "INSERT INTO cart values('Panchatantra-101',120,'"+user+"')";
                    Statement sta=connection.createStatement();
                    int x=sta.executeUpdate(query);
                    if(x!=0){
                        JOptionPane.showMessageDialog(addToCart4,"added to cart");
                    }
                    else{
                        JOptionPane.showMessageDialog(addToCart4,"not added to cart");
                    }
                    connection.close();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        addToCart4.setFont(new Font("Tahoma",Font.PLAIN,12));
        addToCart4.setBounds(670,340,120,30);
        contentPane.add(addToCart4);

        addToCart5=new JButton("Add to cart");
        addToCart5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/registeredcustomers","root","swetha@02");
                    String query = "INSERT INTO cart values('BedTimeStories-101',151,'"+user+"')";
                    Statement sta=connection.createStatement();
                    int x=sta.executeUpdate(query);
                    if(x!=0){
                        JOptionPane.showMessageDialog(addToCart5,"added to cart");
                    }
                    else{
                        JOptionPane.showMessageDialog(addToCart5,"not added to cart");
                    }
                    connection.close();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        addToCart5.setFont(new Font("Tahoma",Font.PLAIN,12));
        addToCart5.setBounds(880,340,120,30);
        contentPane.add(addToCart5);

        addToCart6=new JButton("Add to cart");
        addToCart6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/registeredcustomers","root","swetha@02");
                    String query = "INSERT INTO cart values('AnimalStories',120,'"+user+"')";
                    Statement sta=connection.createStatement();
                    int x=sta.executeUpdate(query);
                    if(x!=0){
                        JOptionPane.showMessageDialog(addToCart6,"added to cart");
                    }
                    else{
                        JOptionPane.showMessageDialog(addToCart6,"not added to cart");
                    }
                    connection.close();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        addToCart6.setFont(new Font("Tahoma",Font.PLAIN,12));
        addToCart6.setBounds(1090,340,120,30);
        contentPane.add(addToCart6);

        JLabel lblBS=new JLabel("Best sellers");
        lblBS.setBounds(20,380,150,30);
        lblBS.setFont(new Font("Tahoma",Font.BOLD,23));
        lblBS.setForeground(Color.blue);
        contentPane.add(lblBS);

        addToCart7=new JButton("Add to cart");
        addToCart7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/registeredcustomers","root","swetha@02");
                    String query = "INSERT INTO cart values('GrandmaBag',163,'"+user+"')";
                    Statement sta=connection.createStatement();
                    int x=sta.executeUpdate(query);
                    if(x!=0){
                        JOptionPane.showMessageDialog(addToCart7,"added to cart");
                    }
                    else{
                        JOptionPane.showMessageDialog(addToCart7,"not added to cart");
                    }
                    connection.close();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        addToCart7.setFont(new Font("Tahoma",Font.PLAIN,12));
        addToCart7.setBounds(345,635,120,30);
        contentPane.add(addToCart7);

        addToCart8=new JButton("Add to cart");
        addToCart8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/registeredcustomers","root","swetha@02");
                    String query = "INSERT INTO cart values('Panchatantra-108',99,'"+user+"')";
                    Statement sta=connection.createStatement();
                    int x=sta.executeUpdate(query);
                    if(x!=0){
                        JOptionPane.showMessageDialog(addToCart8,"added to cart");
                    }
                    else{
                        JOptionPane.showMessageDialog(addToCart8,"not added to cart");
                    }
                    connection.close();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        addToCart8.setFont(new Font("Tahoma",Font.PLAIN,12));
        addToCart8.setBounds(670,635,120,30);
        contentPane.add(addToCart8);

        addToCart9=new JButton("Add to cart");
        addToCart9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/registeredcustomers","root","swetha@02");
                    String query = "INSERT INTO cart values('Stories',184,'"+user+"')";
                    Statement sta=connection.createStatement();
                    int x=sta.executeUpdate(query);
                    if(x!=0){
                        JOptionPane.showMessageDialog(addToCart9,"added to cart");
                    }
                    else{
                        JOptionPane.showMessageDialog(addToCart9,"not added to cart");
                    }
                    connection.close();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        addToCart9.setFont(new Font("Tahoma",Font.PLAIN,12));
        addToCart9.setBounds(970,635,120,30);
        contentPane.add(addToCart9);

        ImageIcon bBook1 = new ImageIcon("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\B1.png");
        JLabel BBook1=new JLabel();
        BBook1.setIcon(bBook1);
        BBook1.setBounds(225,370,200,305);
        contentPane.add(BBook1);

        ImageIcon bBook2 = new ImageIcon("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\B2.png");
        JLabel BBook2=new JLabel();
        BBook2.setIcon(bBook2);
        BBook2.setBounds(550,370,200,305);
        contentPane.add(BBook2);

        ImageIcon bBook3 = new ImageIcon("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\B3.png");
        JLabel BBook3=new JLabel();
        BBook3.setIcon(bBook3);
        BBook3.setBounds(850,370,200,305);
        contentPane.add(BBook3);

        goToCart=new JButton();
        goToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dispose();
                    Cart c=new Cart("My Cart",user);
                    c.setLocationRelativeTo(null);
                    c.setVisible(true);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        ImageIcon cart = new ImageIcon("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\cart.png");
        goToCart.setIcon(cart);
        goToCart.setBounds(1265,60,56,57);
        contentPane.add(goToCart);

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
        goToHome.setBounds(1265,125,56,57);
        contentPane.add(goToHome);

        back=new JButton();
        back.addActionListener(new ActionListener() {
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
        ImageIcon Back = new ImageIcon("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\back.png");
        back.setIcon(Back);
        back.setBounds(1265,190,56,57);
        contentPane.add(back);
    }
}
