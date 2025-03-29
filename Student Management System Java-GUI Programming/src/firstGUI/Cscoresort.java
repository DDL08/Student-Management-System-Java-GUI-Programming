package firstGUI;
import Function.Function;
import base.Student;
import base.Course;
import java.util.List;
import base.Score;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import static firstGUI.Scoresort.scoresort;

public class Cscoresort {

    public static void cscoresort() {
        Font font=new Font("",Font.BOLD,20);
        JFrame frame =new JFrame("按某门课程分数排序");
        JLabel lable1=new JLabel("课程号：");
        JLabel lable2=new JLabel("学号               成绩");//十五个空格
        JTextField TextField=new JTextField(20);
        JButton button=new JButton("确定");
        JPanel panel1=new JPanel();
        JPanel a=new JPanel();
        JPanel b=new JPanel();
        JPanel c=new JPanel();

        panel1.setLayout(new GridLayout(3,1));
        frame.setLayout(new GridLayout(2,1));

        lable1.setFont(font);
        lable2.setFont(font);
        TextField.setFont(font);
        button.setFont(font);


        a.add(lable1);
        a.add(TextField);
        b.add(button);
        c.add(lable2);

        panel1.add(a);
        panel1.add(b);
        panel1.add(c);


        JTextArea textArea = new JTextArea(50,20);//如果换行有问题可以调这里的参数改变行列大小
        JScrollPane JPanel = new JScrollPane(textArea);
        textArea.setEnabled(false);
        textArea.setFont(font);
        textArea.setLineWrap(true);
        Panel panel=new Panel();
        panel.add(JPanel);
        panel.setLayout(new FlowLayout());



        frame.add(panel1);
        frame.add(panel);
        frame.setSize(400,600);
        frame.setLocation(100,200);
        frame.setResizable(false);
        //frame.pack();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = TextField.getText(); 
                textArea.setText("");
               // List<String[]>scores = Function.sortScoreByCno(s);       
               // JTextArea textArea = new JTextArea();
                List<String[]> scoresByCno = Function.sortScoreByCno(s);
                if (scoresByCno != null) {
                    for (String[] scoreEntry : scoresByCno) {
                        textArea.append("学号: " + scoreEntry[0] + ", 分数: " + scoreEntry[1] + "\n");
                    }
                } 
                else {
                }
            }
        });
        
    
    }
}
