package firstGUI;
import Function.Function;
import base.Score;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class referNumberOfSex extends JFrame {//根据性别查询年龄
    JPanel centerPanel=new JPanel(null);
    JLabel referSex=new JLabel("查询性别");
    JTextField referSexTxt= new JTextField();//查询姓名文本框
    JLabel number=new JLabel("人数");
    JTextField numberTxt= new JTextField();//输出人数文本框
    JButton refer=new JButton("查询");
    public referNumberOfSex(){
        numberTxt.setEnabled(false);
        Font centerFont=new Font("楷体",Font.BOLD,20);
        referSex.setFont(centerFont);
        number.setFont(centerFont);
        refer.setFont(centerFont);

        referSex.setLocation(50,50);
        referSex.setSize(220,35);

        referSexTxt.setLocation(150,40);
        referSexTxt.setSize(80,35);

        number.setLocation(50,180);
        number.setSize(80,35);

        numberTxt.setLocation(150,180);
        numberTxt.setSize(80,35);

        refer.setLocation(253,310);
        refer.setSize(80,35);

        centerPanel.add(referSex);
        centerPanel.add(referSexTxt);
        centerPanel.add(number);
        centerPanel.add(numberTxt);
        centerPanel.add(refer);

               refer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sex=referSexTxt.getText();//提取查询性别
                int a=Function.getStudentByGender(sex);
                String b=String.valueOf(a);
                numberTxt.setText(b);
            }
           //清空文本框
       });

        setContentPane(centerPanel);
        setSize(600,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
