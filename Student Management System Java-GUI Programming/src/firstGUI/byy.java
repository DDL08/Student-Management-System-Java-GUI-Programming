package firstGUI;

import javax.swing.*;
import java.awt.*;

public class byy extends JFrame {//密码不一致
    JPanel centerPanel=new JPanel(null);
    JLabel No=new JLabel("密码不一致");
    public byy(){
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