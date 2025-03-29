package firstGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Function.Function;
import base.Student;
import base.Course;
import base.Score;
public class classin {
    public static void classinn() {
        Font font=new Font("",Font.BOLD,20);
        JTextField text = new JTextField();

        JFrame frame=new JFrame("课程输入界面");
        JPanel panel=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();
        JPanel panel5=new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label1=new JLabel("课程号");
        label1.setFont(font);
        JLabel label2=new JLabel("课程名");
        label2.setFont(font);
        JLabel label3=new JLabel("  学分");
        label3.setFont(font);


        //    final ButtonGroup[] sex = {new ButtonGroup()};

//        sex[0].add(button1);
//        sex[0].add(button2);

        JTextField ctextField1=new JTextField(20);//课程号
        ctextField1.setFont(font);
        JTextField ctextField2=new JTextField(20);//课程名
        ctextField2.setFont(font);
        JTextField ctextField3=new JTextField(20);//学分
        ctextField3.setFont(font);

        panel.add(label1);
        panel.add(ctextField1);
        panel2.add(label2);
        panel2.add(ctextField2);
        panel3.add(label3);
        panel3.add(ctextField3);




        JButton button3=new JButton("确定");
        button3.setFont(font);
        panel5.add(button3);
        JButton button4=new JButton("下一个");
        button4.setFont(font);
        panel5.add(button4);
        JButton button5=new JButton("结束");
        button5.setFont(font);
        panel5.add(button5);





        frame.setLayout(new GridLayout(5,1));
        frame.add(panel);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);
        frame.setSize(400,400);
        frame.setLocation(100,100);
        // frame.setResizable(false);
        frame.pack();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        new Ytrue();




        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cno=ctextField1.getText();
                String cname=ctextField2.getText();
                String score=ctextField3.getText();
                if (cno.isEmpty()||cname.isEmpty()||score.isEmpty()) 
                aaa();
                Float c=Float.valueOf(score);
                Course student =new Course(cno,cname,c);
                try{Function.addCourse(student);}
                catch(Exception E){}

            }
            //添加课程信息逻辑，判断是否有变量为空，如果有，调用aaa()函数并且不保存数据
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ctextField1.setText("");
                ctextField2.setText("");
                ctextField3.setText("");
            }
            //清空文本框
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//               sbutton4.setEnabled(false);
//                sbutton5.setEnabled(false);
//                sbutton3.setEnabled(false);
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
