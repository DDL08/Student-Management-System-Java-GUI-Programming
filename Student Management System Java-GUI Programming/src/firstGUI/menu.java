package firstGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static firstGUI.ChangeSC.changesc;
import static firstGUI.Changecl.changecl;
import static firstGUI.Changestu.changestu;
import static firstGUI.Countage.countage;
import static firstGUI.Cscoresort.cscoresort;
import static firstGUI.Scorepass.scorepass;
import static firstGUI.Scoresort.scoresort;
import static firstGUI.classin.classinn;
import static firstGUI.scorein.scoreinn;
import static firstGUI.studentin.studentinn;

public class menu {
    public static void bmenu() {

        Font font=new Font("",Font.BOLD,20);//字体
        JFrame frame= new JFrame("学生管理系统主菜单");
        JPanel panel1=new JPanel();
        Font font2=new Font("",Font.BOLD,50);//标签字体
        JLabel label=new JLabel("任务框");
        label.setFont(font2);
        panel1.add(label);



        frame.setFont(font);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1=new JMenu("数据输入");
        JMenu menu2=new JMenu("数据查询");
        JMenu menu3=new JMenu("数据统计");
        JMenu menu4=new JMenu("数据排序");
        JMenu menu5=new JMenu("数据删除");
        JMenu menu6=new JMenu("数据修改");
       // JMenu menu7=new JMenu("回到主页");

        JMenuItem menuItem1=new JMenuItem("输入学生表");
        JMenuItem menuItem2=new JMenuItem("输入课程表");
        JMenuItem menuItem3=new JMenuItem("输入成绩表");

        JMenuItem menuItem4=new JMenuItem("按学号查询学生的自然情况");
        JMenuItem menuItem5=new JMenuItem("按学号查询学生成绩明细");
        JMenuItem menuItem6=new JMenuItem("按课程查询平均成绩");
        JMenuItem menuItem7=new JMenuItem("按性别查询学生人数");
        JMenuItem menuItem8=new JMenuItem("查询某学生选某课程的成绩");

        JMenuItem menuItem9=new JMenuItem("统计年龄对应的学生人数");
        JMenuItem menuItem10=new JMenuItem("统计至少有一门课程不及格的学生(学号、课程号和成绩)");

        JMenuItem menuItem11=new JMenuItem("按平均成绩排序,显示学号和平均成绩");
        JMenuItem menuItem12=new JMenuItem("按某门课程成绩排序");

        JMenuItem menuItem13=new JMenuItem("按学号和课程号删除成绩信息");
        JMenuItem menuItem14=new JMenuItem("按学号删除学生");
        JMenuItem menuItem15=new JMenuItem("按课程号删除课程");

        JMenuItem menuItem16=new JMenuItem("按学号和课程号修改成绩信息");
        JMenuItem menuItem17=new JMenuItem("修改学生信息");
        JMenuItem menuItem18=new JMenuItem("修改课程信息");

        JMenuItem menuItem19=new JMenuItem("返回");

        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu1.add(menuItem3);
        menu2.add(menuItem4);
        menu2.add(menuItem5);
        menu2.add(menuItem6);
        menu2.add(menuItem7);
        menu2.add(menuItem8);
        menu3.add(menuItem9);
        menu3.add(menuItem10);
        menu4.add(menuItem11);
        menu4.add(menuItem12);
        menu5.add(menuItem13);
        menu5.add(menuItem14);
        menu5.add(menuItem15);
        menu6.add(menuItem16);
        menu6.add(menuItem17);
        menu6.add(menuItem18);
      //  menu7.add(menuItem19);


        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menuBar.add(menu5);
        menuBar.add(menu6);
       // menuBar.add(menu7);

        frame.setJMenuBar(menuBar);
        frame.add(panel1);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        frame.setSize(500,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classinn();
            }
        });

        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentinn();
            }
        });

        menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scoreinn();
            }
        });

        menuItem9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countage();
            }
        });

        menuItem10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               scorepass();
            }
        });

        menuItem11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scoresort();
            }
        });

        menuItem12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cscoresort();
            }
        });

        menuItem16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changesc();
            }
        });

        menuItem17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changestu();
            }
        });

        menuItem18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changecl();
            }
        });


        menuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               referStudentMessage res=new referStudentMessage();
            }
        });
        menuItem5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                referScoreOfSno res=new referScoreOfSno();
            }
        });
        menuItem6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                referAverageScoreOfCno res=new referAverageScoreOfCno();
            }
        });
        menuItem7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                referNumberOfSex res=new referNumberOfSex();
            }
        });
        menuItem8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                referOneScoreOfSnoAndCno res=new referOneScoreOfSnoAndCno();
            }
        });

        menuItem13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 deleteScoreOfSnoAndCno res=new deleteScoreOfSnoAndCno();
            }
        });
        menuItem14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudentOfSno res=new deleteStudentOfSno();
            }
        });
        menuItem15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteClassOfCno res=new deleteClassOfCno();
            }
        });



    }
}
