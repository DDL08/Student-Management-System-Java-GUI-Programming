package firstGUI;
import Function.Function;
import base.Score;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class referAverageScoreOfCno extends JFrame{//根据课程号查询平均成绩
    JPanel centerPanel=new JPanel(null);
    JLabel refercno=new JLabel("查询课程号");
    JTextField refercnoTxt= new JTextField();//查询课程号文本框
    JLabel averageScore=new JLabel("平均成绩");
    JTextField averageScoreTxt= new JTextField();//输出平均成绩文本框
    
    JButton refer=new JButton("查询");
    public referAverageScoreOfCno(){
        averageScoreTxt.setEnabled(false);
        
        Font centerFont=new Font("楷体",Font.BOLD,20);
        refercno.setFont(centerFont);
        averageScore.setFont(centerFont);
        refer.setFont(centerFont);

        refercno.setLocation(50,50);
        refercno.setSize(220,35);

        refercnoTxt.setLocation(160,50);
        refercnoTxt.setSize(80,35);

        averageScore.setLocation(50,180);
        averageScore.setSize(220,35);

        averageScoreTxt.setLocation(150,180);
        averageScoreTxt.setSize(80,35);

        refer.setLocation(253,310);
        refer.setSize(80,35);

        centerPanel.add(refercno);
        centerPanel.add(refercnoTxt);
        centerPanel.add(averageScore);
        centerPanel.add(averageScoreTxt);
        centerPanel.add(refer);

       refer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cno=refercnoTxt.getText();//提取查询课程号
                try{ 
                    double a=Function.getAverageScoreByCno(cno);
                    String b=String.valueOf(a);
                    averageScoreTxt.setText(b);
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
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
