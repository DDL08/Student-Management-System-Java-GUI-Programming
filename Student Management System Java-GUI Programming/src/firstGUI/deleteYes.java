package firstGUI;

import javax.swing.*;
import java.awt.*;

public class deleteYes extends JFrame {//删除成功
    JPanel centerPanel=new JPanel(null);
    JLabel Yes=new JLabel("删除成功");
    public deleteYes(){
        Font centerFont=new Font("楷体",Font.PLAIN,20);
        Yes.setFont(centerFont);

        Yes.setLocation(50,40);
        Yes.setSize(200,35);

        centerPanel.add(Yes);

        setContentPane(centerPanel);
        setSize(200,150);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

}
