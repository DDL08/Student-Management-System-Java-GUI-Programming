package firstGUI;

import javax.swing.*;
import java.awt.*;

public class bgg extends JFrame {
    JPanel centerPanel=new JPanel(null);
    JLabel No=new JLabel("注册成功");
    public bgg(){
        Font centerFont=new Font("楷体",Font.PLAIN,20);
        No.setFont(centerFont);

        No.setLocation(30,40);
        No.setSize(200,35);

        centerPanel.add(No);

        setContentPane(centerPanel);
        setSize(200,150);//型号
        setLocationRelativeTo(null);
        setResizable(false);//可转变
        setVisible(true);//可见
    }
}