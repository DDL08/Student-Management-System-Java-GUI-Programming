package firstGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Function.Function;
public class enroll extends JFrame  {//注册界面
    JPanel centerPanel=new JPanel(null);
    JLabel nameLabel=new JLabel("注册页面");
    JLabel userNameLabel=new JLabel("用户名");
    JTextField userTxt= new JTextField();
    JLabel pwdLabel=new JLabel("密码");
    JLabel pwdLabelagain=new JLabel("确认密码");
    JPasswordField pwdField=new JPasswordField();
    JPasswordField pwdFieldagain=new JPasswordField();
    JButton resetBtn=new JButton("注册");

    public enroll() {
        Font centerFont1 = new Font("华文行楷", Font.PLAIN, 40);
        Font centerFont = new Font("楷体", Font.BOLD, 20);
        nameLabel.setFont(centerFont1);
        userNameLabel.setFont(centerFont);
        pwdLabel.setFont(centerFont);
        pwdLabelagain.setFont(centerFont);
        resetBtn.setFont(centerFont);

        nameLabel.setLocation(170, 40);
        nameLabel.setSize(1000, 35);

        userNameLabel.setLocation(60, 120);
        userNameLabel.setSize(100, 35);

        userTxt.setLocation(150, 120);
        userTxt.setSize(300, 35);

        pwdLabel.setLocation(60, 160);
        pwdLabel.setSize(100, 35);

        pwdField.setLocation(150, 160);
        pwdField.setSize(300, 35);

        pwdLabelagain.setLocation(60, 200);
        pwdLabelagain.setSize(100, 35);

        pwdFieldagain.setLocation(150, 200);
        pwdFieldagain.setSize(300, 35);


        resetBtn.setLocation(300, 250);
        resetBtn.setSize(80, 35);

        centerPanel.add(nameLabel);
        centerPanel.add(userNameLabel);
        centerPanel.add(userTxt);
        centerPanel.add(pwdLabel);
        centerPanel.add(pwdField);
        centerPanel.add(pwdLabelagain);
        centerPanel.add(pwdFieldagain);
        centerPanel.add(resetBtn);
       resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 String user=userTxt.getText();
                 String pws=pwdField.getText();
                 String pwsAgain=pwdFieldagain.getText();
                    int temp=Function.eroll(user,pws);
                        if(temp==-1){
                            connNO a=new connNO();
                         }
                         else if(!pws.equals(pwsAgain)){//确定密码不一致
                             byy a=new byy();
                         }
                         else if(temp==0){
                           
                            pdUser a=new pdUser();
                         }
                         else{//注册成功.进行登录
                                bgg a=new bgg();
                         }


             }
           //清空文本框
       });
        setContentPane(centerPanel);
        setSize(600,400);
        setLocationRelativeTo(null);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
     //   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //窗体关闭，程序结束运行。
    }
}
