import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Cart extends JFrame {
    private JPanel contentPane;
    private JPanel tab;
    private JTable cartTbl;
    private JScrollPane jsp;
    private JButton submit;
    private JButton goToHome;
    private JButton back;
    public Cart(String title, String username) {
        super(title);
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mohan\\Desktop\\myfirstWebsite\\img.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450,190,1014,650);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new LineBorder(Color.ORANGE, 3, false));
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblShop=new JLabel("Books in your cart");
        lblShop.setBounds(370,10,1200,30);
        lblShop.setFont(new Font("Tahoma",Font.BOLD,25));
        lblShop.setForeground(Color.blue);
        contentPane.add(lblShop);

        String[] header = { "Book", "Price"};
        int i=0,cost=0;
        String[][] rec=new String[20][20];

        try{
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/registeredcustomers","root","swetha@02");
            String query = "select product, price from cart where userName='"+username+"'";
            Statement sta=connection.createStatement();
            ResultSet x=sta.executeQuery(query);
            while (x.next()){
                String product=x.getString("product");
                String price=x.getString("price");
                String tdData[]={product,price};
                cost+=Integer.parseInt(price);
                rec[i]=tdData;
                i++;
            }
        }catch(Exception exception){
            exception.printStackTrace();
        }

        final int len=i;
        tab=new JPanel();
        tab.setBounds(250,65,500,440);
        tab.setBorder(new LineBorder(Color.BLUE,3));
        contentPane.add(tab);

        rec[i][0]="You have to pay          ==>";rec[i][1]=Integer.toString(cost);
        cartTbl = new JTable(rec, header);
        cartTbl.setFont(new Font("Tahoma",Font.BOLD,15));
        cartTbl.setRowHeight(20);
        cartTbl.setRowHeight(i,30);
        cartTbl.setShowGrid(false);

        jsp=new JScrollPane(cartTbl);
        tab.add(jsp,BorderLayout.CENTER);

        submit=new JButton("Place Your Order");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/registeredcustomers","root","swetha@02");
                    int x=0;
                    String query="";
                    Statement sta=connection.createStatement();;
                    for(int j=0;j<len;j++){
                        query= "INSERT INTO orders values('" +username +"','"+rec[j][0]+ "'," +rec[j][1]+")";
                        x=sta.executeUpdate(query);
                    }
                    if(x!=0){
                        query ="DELETE FROM cart";
                        //sta=connection.createStatement();
                        x=sta.executeUpdate(query);
                        if(x!=0) {
                            JOptionPane.showMessageDialog(submit,"Your order has been placed successfully, you have to pay on delivery");
                            dispose();
                            Shop s=new Shop("BSmart",username);
                            s.setLocationRelativeTo(null);
                            s.setVisible(true);
                        }
                        else{
                            JOptionPane.showMessageDialog(submit,"your order is not placed, please try after a while");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(submit,"your order is not placed, please try after a while");
                    }
                    connection.close();
                }catch (Exception exception){
                    exception.printStackTrace();
                }

            }
        });
        submit.setFont(new Font("Tahoma",Font.PLAIN,20));
        submit.setBounds(400,530,200,40);
        contentPane.add(submit);

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
                    Shop s=new Shop("BSmart",username);
                    s.setLocationRelativeTo(null);
                    s.setVisible(true);
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
