package firstGUI;

import javax.swing.*;
import java.awt.*;

public class pdUser extends JFrame {//注册的用户名已有
    JPanel centerPanel=new JPanel(null);
    JLabel No=new JLabel("已有该用户名");
    public pdUser(){
        Font centerFont=new Font("楷体",Font.PLAIN,20);
        No.setFont(centerFont);

        No.setLocation(30,40);
        No.setSize(200,35);

        centerPanel.add(No);

        setContentPane(centerPanel);
        setSize(200,150);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

}
