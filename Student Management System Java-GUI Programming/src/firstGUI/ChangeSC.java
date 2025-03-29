package firstGUI;
import Function.Function;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import base.Student;
import base.Course;
import base.Score;
public class ChangeSC {
    public static void changesc() {

        Font font=new Font("",Font.BOLD,20);
        JFrame frame=new JFrame("按学号和课程号修改成绩");

        JPanel panel1=new JPanel();
        JLabel label1=new JLabel("               学号:");
        JTextField field1=new JTextField(20);
        label1.setFont(font);
        field1.setFont(font);
        panel1.add(label1);
        panel1.add(field1);


        JPanel panel2=new JPanel();
        JLabel label2=new JLabel("           课程号:");
        JTextField field2=new JTextField(20);
        label2.setFont(font);
        field2.setFont(font);
        panel2.add(label2);
        panel2.add(field2);

        JPanel panel3=new JPanel();
        JLabel label3=new JLabel("将成绩修改为:");
        JTextField field3=new JTextField(20);
        label3.setFont(font);
        field3.setFont(font);
        panel3.add(label3);
        panel3.add(field3);

        JButton button=new JButton("确认修改");
        button.setFont(font);

        frame.setLayout(new GridLayout(4,1));
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(button);

        frame.setSize(400,600);
        frame.setLocation(100,200);
        frame.pack();
        frame.setResizable(false);
        //frame.pack();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sno=field1.getText();
                String cno=field2.getText();
                String score=field3.getText();
                boolean flag=false;
                Float c=Float.valueOf(score);
                Score a=new Score(sno,cno,c);
                //在这里寻找学号等于sno课程号等于cno的学生将成绩改为score 如果找到调用bbb()方法，否则调用aaa()方法
                try{
                	flag=Function.updateScoreBySnoAndCno(sno,cno,a);
                } catch(Exception ex){
             	   throw new RuntimeException(ex);
                }

                if(flag) {//找到弹出该窗口
                	ChangeSC.bbb();
                }
                else{//没找到弹出该窗口
                	ChangeSC.aaa();
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
