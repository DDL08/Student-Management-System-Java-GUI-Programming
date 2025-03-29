package firstGUI;

import javax.swing.*;
import java.util.*;
import base.Score;
import Function.Function;
import base.Student;
import base.Course;
import base.Score;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Scorepass {



    public static void scorepass() {
        Font font=new Font("",Font.BOLD,20);
        JFrame frame =new JFrame("统计不及格");
        JTextArea textArea = new JTextArea(20,20);//如果换行有问题可以调这里的参数改变行列大小
        JScrollPane JPanel = new JScrollPane(textArea);
        textArea.setEnabled(false);
        textArea.setFont(font);
        textArea.setLineWrap(true);
        JLabel label=new JLabel("学号            课程号           成绩");//十个空格
        label.setFont(font);



        List<Score> noPassStudents = new ArrayList<>();
        noPassStudents=Function.getNoPassScore();
        for(Score a:noPassStudents){
            textArea.append("学号"+a.getSno()+"课程号"+a.getCno()+"成绩"+a.getScore()+"\n");
        }
        //textArea.append("学号"+"课程号"+"成绩"+"\n");
        //在这里统计不及格的人并用appen方法加入文本域textArea内


        Panel panel=new Panel();
        panel.setLayout(new GridLayout(2,1));
        panel.add(label);
        panel.add(JPanel);
        panel.setLayout(new FlowLayout());

        frame.add(panel);







        frame.setSize(400,600);
        frame.setLocation(1200,100);
        frame.setResizable(false);
        //frame.pack();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
