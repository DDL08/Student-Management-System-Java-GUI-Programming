package firstGUI;
import Function.Function;
import base.Student;
import base.Course;
import base.Score;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class deleteScoreOfSnoAndCno extends JFrame {//根据学号，课程号删除成绩
    JPanel centerPanel=new JPanel(null);
    JLabel refersno=new JLabel("输入学号");
    JTextField refersnoTxt= new JTextField();//输入学号文本框
    JLabel refercno=new JLabel("输入课程号");
    JTextField refercnoTxt= new JTextField();//输入课程号文本框
    JButton delete=new JButton("删除");
    public  deleteScoreOfSnoAndCno(){
        Font centerFont=new Font("楷体",Font.BOLD,20);
        refersno.setFont(centerFont);
        refercno.setFont(centerFont);
        delete.setFont(centerFont);


        refersno.setLocation(50,40);
        refersno.setSize(200,35);

        refersnoTxt.setLocation(160,40);
        refersnoTxt.setSize(80,35);

        refercno.setLocation(50,80);
        refercno.setSize(220,35);

        refercnoTxt.setLocation(160,80);
        refercnoTxt.setSize(80,35);

        delete.setLocation(253,310);
        delete.setSize(80,35);

        centerPanel.add(refersno);
        centerPanel.add(refersnoTxt);
        centerPanel.add(refercno);
        centerPanel.add(refercnoTxt);
        centerPanel.add(delete);

        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             boolean flag =false;
                String sno=refersnoTxt.getText();//提取输入学号
               String cno=refercnoTxt.getText();//提取输入课程号
                 try{
                     flag=Function.delScoreBySnoAndCno(sno, cno);
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
        setResizable(false);
        setVisible(true);
    }
}
