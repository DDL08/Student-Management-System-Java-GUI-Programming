package firstGUI;

import javax.swing.*;
import Function.Function;
import base.Score;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class referScoreOfSno extends JFrame {//根据学号查询该学生成绩
    JPanel centerPanel=new JPanel(null);
    JLabel refersno=new JLabel("输入学号");
    JTextField refersnoTxt= new JTextField();//输入学号
    JLabel score=new JLabel("成绩");
    //JTextField scoreTxt=new JTextField();//输出成绩文本框
    JButton refer=new JButton("查询");
    public referScoreOfSno(){
      //  scoreTxt.setEnabled(false);

        Font centerFont=new Font("楷体",Font.BOLD,20);
        refersno.setFont(centerFont);
        score.setFont(centerFont);
        refer.setFont(centerFont);

        refersno.setLocation(50,40);
        refersno.setSize(200,35);

        refersnoTxt.setLocation(150,40);
        refersnoTxt.setSize(80,35);

        score.setLocation(253,80);
        score.setSize(80,35);
/* */
Font font=new Font("",Font.BOLD,20);
JTextArea textArea = new JTextArea(50,20);//如果换行有问题可以调这里的参数改变行列大小
textArea.setEnabled(false);
textArea.setFont(font);
textArea.setLineWrap(true);//多行区域文本，用于控制换行行为
textArea.setLocation(100,120);
textArea.setSize(400,180);
        //scoreTxt.setLocation(100,120);
        //scoreTxt.setSize(400,180);

        refer.setLocation(253,310);
        refer.setSize(80,35);

        centerPanel.add(refersno);
        centerPanel.add(refersnoTxt);
        centerPanel.add(textArea);
        centerPanel.add(score);
        centerPanel.add(refer);
       refer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sno=refersnoTxt.getText();//提取查询学号
                try{
                    List<Score> scores = new ArrayList<>();
                    scores = Function.getScoreBySno(sno);
                     Iterator<Score> iterator = scores.iterator();
                     textArea.setText("");
                    while(iterator.hasNext()){
                    Score str = iterator.next();

                    textArea.append("\n课程号"+str.getCno()+"成绩"+str.getScore());

        }
                   
                }
                catch(Exception E){

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
