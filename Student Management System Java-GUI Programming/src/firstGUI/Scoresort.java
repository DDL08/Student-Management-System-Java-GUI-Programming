package firstGUI;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import Function.Function;
import base.Student;
import base.Course;
import base.Score;
import java.util.*;
public class Scoresort {
    public static void scoresort() {
        Font font=new Font("",Font.BOLD,20);
        JFrame frame =new JFrame("按平均成绩排序");
        JTextArea textArea = new JTextArea(50,20);//如果换行有问题可以调这里的参数改变行列大小
        JScrollPane JPanel = new JScrollPane(textArea);
        textArea.setEnabled(false);
        textArea.setFont(font);
        textArea.setLineWrap(true);//多行区域文本，用于控制换行行为
        JLabel label=new JLabel("学号           平均成绩");//十个空格
        label.setFont(font);




        Panel panel=new Panel();
        panel.setLayout(new GridLayout(2,1));
        panel.add(label);
        panel.add(JPanel);
        panel.setLayout(new FlowLayout());

        frame.add(panel);
        textArea.setText("");
        List<String[]> scoresByCno = Function.sortByavgScore();
        if (scoresByCno != null) {
            for (String[] scoreEntry : scoresByCno) {
                textArea.append("学号: " + scoreEntry[0] + ", 平均成绩: " + scoreEntry[1] + "\n");
            }
        } 
        else {
        }
        //在这里统计平均成绩并对平均成绩排序通过append方法添加到文本域textArea中



        frame.setSize(400,600);
        frame.setLocation(1200,100);
        frame.setResizable(false);
        //frame.pack();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);




    }
}
