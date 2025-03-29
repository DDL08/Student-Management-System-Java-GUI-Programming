package firstGUI;
import Function.Function;
import base.Student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class referStudentMessage extends JFrame {//根据学号查询学生信息
    JPanel centerPanel=new JPanel(null);
    JLabel refersno=new JLabel("输入学号");
    JLabel sno=new JLabel("学号");
    JLabel name=new JLabel("姓名");
    JLabel sex=new JLabel("性别");
    JLabel age=new JLabel("年龄");
    JLabel nation=new JLabel("民族");
    JButton refer=new JButton("查询");
    JTextField refersnoTxt= new JTextField();//输入学号文本框
    JTextField snoTxt= new JTextField();//输出学号文本框
    JTextField nameTxt= new JTextField();//输出姓名文本框
    JTextField sexTxt= new JTextField();//输出性别文本框
    JTextField ageTxt= new JTextField();//输出年龄文本框
    JTextField nationTxt= new JTextField();//输出民族文本框
    public referStudentMessage(){
        snoTxt.setEnabled(false);
        nameTxt.setEnabled(false);
        sexTxt.setEnabled(false);
        ageTxt.setEnabled(false);
        nationTxt.setEnabled(false);

        Font centerFont=new Font("楷体",Font.BOLD,20);
        refersno.setFont(centerFont);
        sno.setFont(centerFont);
        name.setFont(centerFont);
        sex.setFont(centerFont);
        age.setFont(centerFont);
        nation.setFont(centerFont);
        refer.setFont(centerFont);
        //snoTxt.setPreferredSize(new Dimension(200,30));

        refersno.setLocation(50,40);
        refersno.setSize(200,35);

        sno.setLocation(50,120);
        sno.setSize(80,35);

        name.setLocation(150,120);
        name.setSize(80,35);

        sex.setLocation(250,120);
        sex.setSize(80,35);

        age.setLocation(350,120);
        age.setSize(80,35);

        nation.setLocation(450,120);
        nation.setSize(80,35);

        refersnoTxt.setLocation(150,40);
        refersnoTxt.setSize(80,35);

        snoTxt.setLocation(30,160);
        snoTxt.setSize(80,35);

        nameTxt.setLocation(130,160);
        nameTxt.setSize(80,35);

        sexTxt.setLocation(230,160);
        sexTxt.setSize(80,35);

        ageTxt.setLocation(330,160);
        ageTxt.setSize(80,35);

        nationTxt.setLocation(430,160);
        nationTxt.setSize(80,35);

        refer.setLocation(230,230);
        refer.setSize(80,35);

        centerPanel.add(refersno);
        centerPanel.add(sno);
        centerPanel.add(name);
        centerPanel.add(sex);
        centerPanel.add(age);
        centerPanel.add(nation);
        centerPanel.add(refersnoTxt);
        centerPanel.add(snoTxt);
        centerPanel.add(nameTxt);
        centerPanel.add(sexTxt);
        centerPanel.add(ageTxt);
        centerPanel.add(nationTxt);
        centerPanel.add(refer);

       refer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sno=refersnoTxt.getText();//提取查询学号
                try{                Student a=Function.getStudentBySno(sno);
                    snoTxt.setText(a.getSno());
                     nameTxt.setText(a.getSname());
                    sexTxt.setText(a.getGender());
                    String b = String.valueOf(a.getAge());
                     ageTxt.setText(b);
                    nationTxt.setText(a.getNation());
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
