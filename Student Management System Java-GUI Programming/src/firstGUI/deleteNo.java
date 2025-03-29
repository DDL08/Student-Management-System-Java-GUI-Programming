package firstGUI;

import javax.swing.*;
import java.awt.*;

public class deleteNo extends JFrame {//删除失败
    JPanel centerPanel=new JPanel(null);
    JLabel No=new JLabel("删除失败");
    public deleteNo(){
        Font centerFont=new Font("楷体",Font.PLAIN,20);
        No.setFont(centerFont);

        No.setLocation(50,40);
        No.setSize(200,35);

        centerPanel.add(No);

        setContentPane(centerPanel);
        setSize(200,150);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

}
