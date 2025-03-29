package firstGUI;
import Function.Function;
import base.Student;
import base.Course;
import base.Score;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class deleteClassOfCno extends JFrame {//根据课程号删除课程
    JPanel centerPanel=new JPanel(null);
    JLabel refercno=new JLabel("输入课程号");
    JTextField refercnoTxt= new JTextField();//输入课程号文本框
    JButton delete=new JButton("删除");
    public deleteClassOfCno(){
        Font centerFont=new Font("楷体",Font.BOLD,20);
        refercno.setFont(centerFont);
        delete.setFont(centerFont);


        refercno.setLocation(50,40);
        refercno.setSize(200,35);

        refercnoTxt.setLocation(160,40);
        refercnoTxt.setSize(80,35);

        delete.setLocation(253,310);
        delete.setSize(80,35);

        centerPanel.add(refercno);
        centerPanel.add(refercnoTxt);
        centerPanel.add(delete);

        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean flag =false;
                String cno=refercnoTxt.getText();//提取输入课程号
                try{
                    flag=Function.delCourseByCno(cno);
                }
                catch(Exception ex){
                    throw new RuntimeException(ex);
                }

                if(flag) {//找到弹出该窗口
                   deleteYes a=new deleteYes();
                }
               else{//没找到弹出该窗口
                  deleteNo a=new deleteNo();
                }
             }
           //清空文本框
       });


        setContentPane(centerPanel);
        setSize(600,400);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);


    }
}
