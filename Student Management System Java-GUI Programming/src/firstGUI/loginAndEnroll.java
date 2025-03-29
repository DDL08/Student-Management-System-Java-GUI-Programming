package firstGUI;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import Function.Function;
import static firstGUI.menu.bmenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
public class loginAndEnroll extends JFrame{//登录界面
    JPanel centerPanel=new JPanel(null);
    JLabel nameLabel=new JLabel("教务三管系统");
    JLabel userNameLabel=new JLabel("用户名");
    JTextField userTxt= new JTextField();
    JLabel pwdLabel=new JLabel("密码");
    JPasswordField pwdField=new JPasswordField();
    JButton loginBtn=new JButton("登录");
    JButton resetBtn=new JButton("注册");

    JMenuBar menuBar = new JMenuBar();
    JMenu menu1=new JMenu("帮助");
    JMenuItem menuItem1=new JMenuItem("关于本产品");
    JMenuItem menuItem2=new JMenuItem("合作");
    JMenuItem menuItem3=new JMenuItem("使用说明");

    JMenu menu2=new JMenu("设置");
    JMenuItem menuItem4=new JMenuItem("数据库连接");
    JMenu menu3=new JMenu("游客模式");
    JMenuItem menuItem5=new JMenuItem("仅供GUI阅览");
    // JMenuItem menuItem5=new JMenuItem("输入成绩表");
    // JMenuItem menuItem6=new JMenuItem("输入学生表");


    public loginAndEnroll(){


        Font centerFont1=new Font("华文行楷",Font.PLAIN,40);
        Font centerFont=new Font("楷体",Font.BOLD,20);
        nameLabel.setFont(centerFont1);
        userNameLabel.setFont(centerFont);
        pwdLabel.setFont(centerFont);
        loginBtn.setFont(centerFont);
        resetBtn.setFont(centerFont);

        nameLabel.setLocation(170,40);
        nameLabel.setSize(1000,35);

        userNameLabel.setLocation(60,120);
        userNameLabel.setSize(100,35);

        userTxt.setLocation(130,120);
        userTxt.setSize(300,35);

        pwdLabel.setLocation(60,160);
        pwdLabel.setSize(100,35);

        pwdField.setLocation(130,160);
        pwdField.setSize(300,35);

        loginBtn.setLocation(120,210);
        loginBtn.setSize(80,35);

        resetBtn.setLocation(300,210);
        resetBtn.setSize(80,35);

        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu1.add(menuItem3);
        menu2.add(menuItem4);
        menu3.add(menuItem5);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        setJMenuBar(menuBar);
        //centerPanel.add(menuBar);
        centerPanel.add(nameLabel);
        centerPanel.add(userNameLabel);
        centerPanel.add(userTxt);
        centerPanel.add(pwdLabel);
        centerPanel.add(pwdField);
        centerPanel.add(loginBtn);
        centerPanel.add(resetBtn);

        menuItem4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new initialize();
            }
        });
        
        menuItem5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                bmenu();
            }
        });

        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user=userTxt.getText();//提取输入用户名
                String pws=pwdField.getText();//提取输入密码   
                int temp=Function.login(user,pws);
                    if(temp==-1) {//如果正确调用bmenu
                        connNO a=new connNO();
                    }
                    else if(temp==1){
                        bmenu();
                    }
                    else{//如果错误
                        loginNo a=new loginNo();
                    }
             }
           //清空文本框
       });
       resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                 enroll a=new enroll();//进入注册页面

             }
           //清空文本框
       });
        setContentPane(centerPanel);
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        userTxt.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent event) {
            
            char keyChar = event.getKeyChar();
            
            if (keyChar >= 65 && keyChar <= 90 // 只接收字母
            
            //|| (keyChar == '.' && ((JTextField)event.getSource()).getText().indexOf(".") == -1)//小数点唯一
            
            // 可以接收小数点
            
            || keyChar == '\b' // 可以接收 backspace
            ||keyChar >= 97 && keyChar <= 122 // 只接收字母
            ||keyChar >= '0' && keyChar <= '9' // 只接收字母
            
            ) {
            
            return;
            
            }
            
            // 当输入在限制之外，发出声音提示
            
            Toolkit.getDefaultToolkit().beep();
            
            // 限制之外的输入不出现在文本框中
            
            event.consume();//用于指示当前事件已被处理，不应再由其他组件或监听器进一步处理。
            
            }
            
            });
            pwdField.addKeyListener(new KeyAdapter() {

                public void keyTyped(KeyEvent event) {
                
                char keyChar = event.getKeyChar();
                
                if (keyChar >= 65 && keyChar <= 90 // 只接收字母
                
                //|| (keyChar == '.' && ((JTextField)event.getSource()).getText().indexOf(".") == -1)//小数点唯一
                
                // 可以接收小数点
                
                || keyChar == '\b' // 可以接收 backspace
                ||keyChar >= 97 && keyChar <= 122 // 只接收字母
                ||keyChar >= '0' && keyChar <= '9' // 只接收字母
                
                ) {
                
                return;
                
                }
                
                // 当输入在限制之外，发出声音提示
                
                Toolkit.getDefaultToolkit().beep();
                
                // 限制之外的输入不出现在文本框中
                
                event.consume();
                
                }
                
                });
    }

    public static void main(String[] args) {
        loginAndEnroll a=new loginAndEnroll();
    }
}
