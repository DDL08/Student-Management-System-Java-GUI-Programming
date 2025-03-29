package firstGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Function.Function;
import base.Student;
import base.Course;
import base.Score;
public class Countage {
    public static void countage() {
        Font font = new Font("", Font.BOLD, 20);
        JFrame frame = new JFrame("统计年龄对应的学生人数");
        JLabel label1= new JLabel("年龄:");
        JTextField cagetextField1=new JTextField(20);
        label1.setFont(font);
        cagetextField1.setFont(font);
        JButton button1=new JButton("查询");
        JButton button2=new JButton("返回");
        button1.setFont(font);
        button2.setFont(font);

        JPanel p1=new JPanel();
        JPanel p2=new JPanel();


        p1.add(label1);
        p1.add(cagetextField1);
        p2.add(button1);
        p2.add(button2);

        frame.setLayout(new GridLayout(2,1));
        frame.add(p1);
        frame.add(p2);

        frame.setSize(400,400);
        frame.setLocation(1200,100);
        frame.setResizable(false);
        frame.pack();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String age=cagetextField1.getText();
                int num=0;
                int a=Integer.valueOf(age);
                //这里循环查询该年龄有多少人写入num
                try{
                	for(int i=0;i<Function.statisticsStudentByAge(a);i++){
                		num++;
                	}
                      Countage.bbb(num);
                	 
                	}
                catch(Exception E){
                	//throw new RuntimeException(e);
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

    }

    static void bbb(int n){
        JFrame a=new JFrame();
        JLabel b=new JLabel("年龄为指定年龄的人共有"+n+"人");
        a.add(b);
        a.setVisible(true);
        a.pack();
        a.setLocation(1200,150);
        a.setSize(300,100);
        a.setResizable(false);

    }

}
