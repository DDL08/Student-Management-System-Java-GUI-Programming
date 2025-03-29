package firstGUI;
import Function.Function;
import base.Student;
import base.Course;
import base.Score;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Changestu {
    public static void changestu() {
        Font font=new Font("",Font.BOLD,20);
        JFrame frame=new JFrame("按学号修改信息");

        JPanel panel1=new JPanel();
        JLabel label1=new JLabel("         学号:");
        label1.setFont(font);
        panel1.add(label1);

        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();
        JPanel panel5=new JPanel();
        JPanel panel6=new JPanel();

        JLabel label2=new JLabel("修改后姓名");
        label2.setFont(font);
        JLabel label3=new JLabel("修改后年龄");
        label3.setFont(font);
        JLabel label4=new JLabel("修改后性别");
        label4.setFont(font);
        JLabel label6=new JLabel("修改后民族");
        label6.setFont(font);

        JTextField stextField1=new JTextField(20);//学号
        stextField1.setFont(font);
        JTextField stextField2=new JTextField(20);//姓名
        stextField2.setFont(font);
        JTextField stextField3=new JTextField(20);//年龄
        stextField3.setFont(font);
        JTextField stextField4=new JTextField(20);//民族
        stextField4.setFont(font);
        JTextField stextField5=new JTextField(20);//民族
        stextField5.setFont(font);

        panel1.add(label1);
        panel1.add(stextField1);
        panel2.add(label2);
        panel2.add(stextField2);
        panel3.add(label3);
        panel3.add(stextField3);
        panel6.add(label6);
        panel6.add(stextField4);
        panel4.add(label4);
        panel4.add(stextField5);

        JButton sbutton3=new JButton("确定");
        sbutton3.setFont(font);

        frame.setLayout(new GridLayout(7,1));
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel6);
        frame.add(panel4);
        frame.add(panel5);
        frame.add(sbutton3);
        frame.setSize(500,500);
        frame.setLocation(100,100);
        frame.setResizable(false);
        //frame.pack();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        sbutton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sno=stextField1.getText();
                String sname=stextField2.getText();
                String age=stextField3.getText();
                String gender=stextField4.getText();
                String nation=stextField5.getText();
                int a=Integer.valueOf(age);
                //在这里寻找学号等于sno的学生将数据改为如上数据，如果找到调用bbb()方法，否则调用aaa()方
                Student student =new Student(sno,sname,a,gender,nation);
               
                boolean flag=false;
                try{
                	flag=Function.updateStudentBySno(sno,student);
                } catch(Exception ex){
             	   throw new RuntimeException(ex);
                }

                if(!flag) {//找到弹出该窗口
                	Changestu.aaa();
                }
                else{//没找到弹出该窗口
                	Changestu.bbb();
                }
            }
        });

    }

    static void aaa(){
        JFrame a=new JFrame();
        JPanel b=new JPanel();
        JLabel c=new JLabel("未找到该学生！！！");
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
