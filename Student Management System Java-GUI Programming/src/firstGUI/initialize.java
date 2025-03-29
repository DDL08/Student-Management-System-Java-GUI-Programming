package firstGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Function.Function;
import javax.swing.*;

public class initialize extends JFrame {
    public initialize() {
        setTitle("基于Oracle数据库的配置");
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        // 创建一个内容面板，并设置其布局为GridLayout
        JPanel contentPane = new JPanel(new GridLayout(4, 2, 10, 10)); // 3行2列，水平和垂直间距为10

        Font centerFont = new Font("楷体", Font.BOLD, 20);

        JLabel ipLabel = new JLabel("ip");
        JLabel userLabel = new JLabel("用户");
        JLabel passwordLabel = new JLabel("密码");

        JTextField ipField = new JTextField("127.0.0.1/xe");
        JTextField userField = new JTextField("system");
        JTextField passwordField = new JTextField("800");

        JButton sureButton = new JButton("确定");
        JButton clearButton = new JButton("清除");

        // 设置字体
        ipLabel.setFont(centerFont);
        userLabel.setFont(centerFont);
        passwordLabel.setFont(centerFont);
        ipField.setFont(centerFont);
        userField.setFont(centerFont);
        passwordField.setFont(centerFont);

        // 添加组件到内容面板
        contentPane.add(ipLabel);
        contentPane.add(ipField);
        contentPane.add(userLabel);
        contentPane.add(userField);
        contentPane.add(passwordLabel);
        contentPane.add(passwordField);
        contentPane.add(sureButton);
        contentPane.add(clearButton);

        // 将内容面板设置为JFrame的内容面板
        setContentPane(contentPane);

        // 显示窗口
        setVisible(true);
        sureButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E){
                String a=ipField.getText();
                String b=userField.getText();
                String c=passwordField.getText();
                 if(Function.start01(a,b,c)){
                    new consuccessful();

                 }else  new confail() ;
            }

        });
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E){
                ipField.setText("");
                userField.setText("");
                passwordField.setText("");
            }

        });
    }

    // public static void main(String[] args) {
    //     new initialize();
    // }
}
