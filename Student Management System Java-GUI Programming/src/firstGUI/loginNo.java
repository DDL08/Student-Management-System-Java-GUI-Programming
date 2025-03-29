package firstGUI;

import javax.swing.*;
import java.awt.*;

public class loginNo extends JFrame {//登录失败
    JPanel centerPanel=new JPanel(null);
    JLabel No=new JLabel("用户名或密码错误");
    public loginNo(){
        Font centerFont=new Font("楷体",Font.PLAIN,20);
        No.setFont(centerFont);

        No.setLocation(50,40);
        No.setSize(200,35);

        centerPanel.add(No);

        setContentPane(centerPanel);
        setSize(300,150);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

}
