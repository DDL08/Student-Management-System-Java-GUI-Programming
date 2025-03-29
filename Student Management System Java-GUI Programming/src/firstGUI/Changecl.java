package firstGUI;

import javax.swing.*;
import base.Student;
import base.Course;
import base.Score;
import base.Course;
import Function.Function;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Changecl {
    public static void changecl() {
        Font font=new Font("",Font.BOLD,20);
        JFrame frame=new JFrame("课程号修改信息");

        JPanel panel1=new JPanel();
        JLabel label1=new JLabel("       课程号:");
        JPanel panel9=new JPanel();
        label1.setFont(font);
        panel1.add(label1);

        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();
        JPanel panel5=new JPanel();
        JPanel panel6=new JPanel();

        JLabel label2=new JLabel("修改后课程名");
        label2.setFont(font);
        JLabel label3=new JLabel("修改后学分");
        label3.setFont(font);

        JTextField stextField1=new JTextField(20);//课程号
        stextField1.setFont(font);
        JTextField stextField2=new JTextField(20);//课程名
        stextField2.setFont(font);
        JTextField stextField3=new JTextField(20);//学分
        stextField3.setFont(font);


        panel1.add(label1);
        panel1.add(stextField1);
        panel2.add(label2);
        panel2.add(stextField2);
        panel3.add(label3);
        panel3.add(stextField3);


        JButton sbutton3=new JButton("确定");
        panel9.add(sbutton3);
        sbutton3.setFont(font);

        frame.setLayout(new GridLayout(7,1));
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel5);
        frame.add(panel9);
        frame.setSize(500,500);
        frame.setLocation(100,100);
        frame.setResizable(false);
        //frame.pack();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

         sbutton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cno=stextField1.getText();
                String cname=stextField2.getText();
               String credit=stextField3.getText();
                //在这里寻找课程号等于cno的课程将数据改为如上数据，如果找到调用bbb()方法，否则调用aaa()方
                float c=Float.valueOf(credit);
                Course course = new Course(cno,cname,c);
              
                boolean flag=false;
                try{
                	flag=Function.updateCourseByCno(cno,course);
                } catch(Exception ex){
             	   throw new RuntimeException(ex);
                }

                if(!flag) {//找到弹出该窗口
                	Changecl.aaa();
                }
                else{//没找到弹出该窗口
                	Changecl.bbb();
                }
            }
        });


    }

    static void aaa(){
        JFrame a=new JFrame();
        JPanel b=new JPanel();
        JLabel c=new JLabel("未找到该课程！！！");
        b.add(c);
        a.add(b);
        a.setVisible(true);
        a.setSize(150,150);
        a.setLocation(150,100);
        a.setResizable(false);
    }
    static void bbb(){
        JFrame a=new JFrame();
        JPanel b=new JPanel();
        JLabel c=new JLabel("修改成功！！！");
        b.add(c);
        a.add(b);
        a.setVisible(true);
        a.setSize(150,150);
        a.setLocation(150,100);
        a.setResizable(false);
    }
}
