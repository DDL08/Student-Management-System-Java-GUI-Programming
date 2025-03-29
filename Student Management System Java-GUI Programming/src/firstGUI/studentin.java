package firstGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import Function.Function;
import base.Student;
import base.Course;
import base.Score;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class studentin {
    public static void studentinn() {
        Font font=new Font("",Font.BOLD,20);
        JTextField text = new JTextField();

        JFrame frame=new JFrame("学生输入界面");
        JPanel panel=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();
        JPanel panel5=new JPanel();
        JPanel panel6=new JPanel();
        //panel.setLayout(new FlowLayout());

        JLabel label1=new JLabel("学号");
        label1.setFont(font);
        JLabel label2=new JLabel("姓名");
        label2.setFont(font);
        JLabel label3=new JLabel("年龄");
        label3.setFont(font);
        JLabel label4=new JLabel("性别");
        label4.setFont(font);
        JLabel label6=new JLabel("民族");
        label6.setFont(font);


        JTextField stextField1=new JTextField(20);//学号
        stextField1.setFont(font);
        JTextField stextField2=new JTextField(20);//姓名
        stextField2.setFont(font);
        
        JTextField stextField3=new JTextField(20);//年龄
        stextField3.setFont(font);
        JTextField stextField4=new JTextField(20);//xin
        stextField4.setFont(font);
        JTextField stextField5=new JTextField(20);//民族
        stextField5.setFont(font);

        panel.add(label1);
        panel.add(stextField1);
        panel2.add(label2);
        panel2.add(stextField2);
        panel3.add(label3);
        panel3.add(stextField3);
        panel6.add(label4);
        panel6.add(stextField4);
        panel4.add(label6);
        panel4.add(stextField5);



        JButton sbutton3=new JButton("确定");
        sbutton3.setFont(font);
        panel5.add(sbutton3);
        JButton sbutton4=new JButton("下一个");
        sbutton4.setFont(font);
        panel5.add(sbutton4);
        JButton sbutton5=new JButton("结束");
        sbutton5.setFont(font);
        panel5.add(sbutton5);

        frame.setLayout(new GridLayout(6,1));
        frame.add(panel);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel6);
        frame.add(panel4);
        frame.add(panel5);
        frame.setSize(400,400);
        frame.setLocation(100,100);
        frame.setResizable(false);
        frame.pack();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);



        sbutton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sno=stextField1.getText();
                String sname=stextField2.getText();
                String age=stextField3.getText();
                int a=Integer.valueOf(age);
                String gender=stextField4.getText();
                String nation=stextField5.getText();
                if (sno.isEmpty() || sname.isEmpty() || age.isEmpty() || gender.isEmpty() || nation.isEmpty()) 
                aaa();
                Student student =new Student(sno,sname,a,gender,nation);
                new Ytrue();
                try{Function.addStudent(student);}
                catch(Exception E){}
            }
            
            
        });

        sbutton4.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 stextField5.setText("");
                 stextField1.setText("");
                 stextField2.setText("");
                 stextField3.setText("");
                 stextField4.setText("");
             }
            //清空文本框
        });
        sbutton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sbutton4.setEnabled(false);
               sbutton5.setEnabled(false);
               sbutton3.setEnabled(false);
                frame.setVisible(false);
            }
        });



    }
    static void aaa(){
        JFrame a=new JFrame();
        JPanel b=new JPanel();
        JLabel c=new JLabel("有数据未输入！！！");
        b.add(c);
        a.add(b);
        a.setVisible(true);
        a.setSize(150,150);
        a.setLocation(150,100);
        a.setResizable(false);
    }

}
