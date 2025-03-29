package firstGUI;
import Function.Function;
import base.Score;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class referOneScoreOfSnoAndCno extends JFrame {//根据学号，课程号查询成绩
    JPanel centerPanel=new JPanel(null);
    JLabel refersno=new JLabel("输入学号");
    JTextField refersnoTxt= new JTextField();//输入学号文本框
    JLabel refercno=new JLabel("输入课程号");
    JTextField refercnoTxt= new JTextField();//输入课程号文本框
    JLabel score=new JLabel("成绩");
    JTextField scoreTxt=new JTextField();//输出成绩文本框
    JButton refer=new JButton("查询");
    public referOneScoreOfSnoAndCno(){
        scoreTxt.setEnabled(false);

        Font centerFont=new Font("楷体",Font.BOLD,20);
        refersno.setFont(centerFont);
        refercno.setFont(centerFont);
        score.setFont(centerFont);
        refer.setFont(centerFont);

        refersno.setLocation(50,40);
        refersno.setSize(200,35);

        refersnoTxt.setLocation(160,40);
        refersnoTxt.setSize(80,35);

        refercno.setLocation(50,80);
        refercno.setSize(220,35);

        refercnoTxt.setLocation(160,80);
        refercnoTxt.setSize(80,35);

        score.setLocation(50,180);
        score.setSize(80,35);

        scoreTxt.setLocation(160,180);
        scoreTxt.setSize(80,35);

        refer.setLocation(253,310);
        refer.setSize(80,35);

        centerPanel.add(refersno);
        centerPanel.add(refersnoTxt);
        centerPanel.add(refercno);
        centerPanel.add(refercnoTxt);
        centerPanel.add(scoreTxt);
        centerPanel.add(score);
        centerPanel.add(refer);
       refer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sno=refersnoTxt.getText();//提取输入学号
                String cno=refercnoTxt.getText();//提取输入课程号
                try{Score a=Function.getScoreBySnoAndCno(sno,cno);
                    String b=String.valueOf(a.getScore());
                    scoreTxt.setText(b);}
                    catch(Exception E){
                        
                    }
                
                
            }
           //清空文本框
       });

        setContentPane(centerPanel);
        setSize(600,400);
        setLocationRelativeTo(null);
        setResizable(false);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
