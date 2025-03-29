package Function;
import java.util.*;
import java.util.List;
import java.sql.*;
import javax.swing.*;
import base.Student;
import base.Score;
import base.Course;
import java.awt.*;
public class Function{
	private static Connection conn;

		public	static  boolean start01(String a,String b,String c) {	//建立连接函数
			//  String drivers="oracle.jdbc.driver.OracleDriver";
			//  String url="jdbc:oracle:thin:@127.0.0.1/xe";  
			//  String username="system";
			//  String passwd="800";  
			String drivers="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@"+a;  
			String username=b;
			String passwd=c;  
        	 PreparedStatement ps = null;

		try {
			Class.forName(drivers);           
			conn = DriverManager.getConnection(url, username,passwd);      
			return true;
		 } 
		 catch(ClassNotFoundException e) {   
			return false;  
			} 
		 catch(SQLException e) {
			return false; 
			}
		 catch (Exception e) {
			return false; 
			 }
		 finally{

		}}

/** 登录↓ */
public static int login(String usernm, String passwd){//登录成功返回1,密码错误返回0；数据库未连接返回-1；
	//不需要判断是否有表, 用户表名为users
	/*1.登录 */
	if(conn==null){
		return -1;
	}
	try{
	String sql = "SELECT 1 FROM users WHERE username = ? and password= ?";  
	PreparedStatement ps=conn.prepareStatement(sql);     
   ps.setString(1, usernm);
   ps.setString(2, passwd);
   ResultSet rs = ps.executeQuery();
   if(rs.next()==true)return 1; 
   else return 0;
	}
		 catch (SQLException e1) {
		}
		return 0;
	}
/**注册↓ */                
public static int eroll(String usernm, String passwd){//注册成功返回true,重复返回false
	if(conn==null){
		return -1;
	}
	try{
			 /*1.找用户名是否重复↓*/   
	 String sql = "SELECT 1 FROM users WHERE username = ?";  
	 PreparedStatement ps=conn.prepareStatement(sql);     
	ps.setString(1, usernm);
	ResultSet rs = ps.executeQuery();
	if(rs.next()==true) return 0;
	/*2.注册↓*/
	 sql = "insert into users values (?,?)";  
	ps=conn.prepareStatement(sql);    
	ps.setString(1, usernm);
	ps.setString(2, passwd);  
	ps.executeQuery();     
			rs.close();
	return 1; 
	}
	catch (SQLException e1) {
   }
   return 0;
		}   
		public static boolean addStudent(Student student) throws SQLException {
			try {
				// 数据校验
				// 检查学生学号是否重复,重复直接返回false
				// 告诉前端不允许添加
				if (haveStudent(student.getSno())) {
					return false;
				}
	
				String sql = "insert into student(sno,sname,gender,nation,age) values(?,?,?,?,?)";
				PreparedStatement prep = conn.prepareStatement(sql);
				prep.setString(1, student.getSno());
				prep.setString(2, student.getSname());
				prep.setString(3, student.getGender());
				prep.setString(4, student.getNation());
				prep.setInt(5, student.getAge());
	
				int r = prep.executeUpdate();
				return r > 0;
			} catch (SQLException e) {
				return false;
			}
			// 增加一个判断学生是否存在的函数
			// public static boolean haveStudent(String sno);
			// 最后应该校验是否加入成功
			// return haveStudent(student.getSno); 存在返回true, 不存在返回false添加失败
	
		}
	
		public static boolean haveStudent(String sno) throws SQLException {
			String sql = "select count(*) from student where sno=?";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setString(1, sno);
			ResultSet rs = prep.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return count > 0; // 如果学生已存在，则返回true，否则返回false
			} else {
				return false;
			}
		}
	
		public static boolean addCourse(Course course) {
			try {
				// 数据校验课程是否存在
				if (haveCourse(course.getCno())) {
					return false; // 如果课程已经存在，返回false表示添加失败
				}
				String sql = "insert into course(cno,cname,credit) values(?,?,?)";
				PreparedStatement prep = conn.prepareStatement(sql);
				prep.setString(1, course.getCno());
				prep.setString(2, course.getCname());
				prep.setFloat(3, course.getCredit());
	
				int r = prep.executeUpdate();
				return r > 0;
			} catch (SQLException e) {
				//e.printStackTrace();
				return false;
			}
	
			// 增加一个判断课程是否存在的函数
			// public static boolean haveCourse(String cno);
			// 最后应该校验是否加入成功
			// return haveCourse(course.getCno); 存在返回true, 不存在返回false添加失败
		}
	
		public static boolean haveCourse(String cno) throws SQLException {
			String sql = "select count(*) from course where cno=?";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setString(1, cno);
			ResultSet rs = prep.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return count > 0; // 如果学生已存在，则返回true，否则返回false
			} else {
				return false;
			}
		}
	
		public static boolean addScore(Score score) {
			try {
				// 数据校验
				// 成绩是否重复, 输入的学号,课程号存不存在,调用在上面要求添加的判断存在函数
				if (!haveStudent(score.getSno()) || !haveCourse(score.getCno())
						|| haveScore(score.getSno(), score.getCno())) {
					return false; // 如果学号或课程号不存在，或者成绩已经存在，返回false表示添加失败
				}
				String sql = "insert into score(sno,cno,score) values(?,?,?)";
				PreparedStatement prep = conn.prepareStatement(sql);
				prep.setString(1, score.getSno());
				prep.setString(2, score.getCno());
				prep.setFloat(3, score.getScore());
	
				int r = prep.executeUpdate();
				return r > 0;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	
			// 增加判断函数
			// public static boolean haveScore(String sno, String cno);
			// return haveScore(score.getSno(), score.getCno());
		}
	
		public static boolean haveScore(String sno, String cno) {
			try {
				String sql = "select count(*) from score where sno=? and cno=?";
				PreparedStatement prep = conn.prepareStatement(sql);
				prep.setString(1, sno);
				prep.setString(2, cno);
				ResultSet rs = prep.executeQuery();
				if (rs.next()) {
					int count = rs.getInt(1);
					return count > 0; // 如果查询到记录，表示成绩存在，返回true；否则返回false
				} else {
					return false; // 如果查询不到记录，表示成绩不存在，返回false
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false; // 出现异常时返回false
			}
		}
	
		public static Student getStudentBySno(String sno) {// 按学号查询学生的自然情况
			Student student = null;
			String sql = "select * from student where sno=?";
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, sno);
				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						student = new Student();
						student.setSno(rs.getString("sno"));
						student.setSname(rs.getString("sname"));
						student.setGender(rs.getString("gender"));
						student.setNation(rs.getString("nation"));
						student.setAge(rs.getInt("age"));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return student;
		}
	
		public static List<Score> getScoreBySno(String sno) {// 按学号查询学生成绩明细
			List<Score> scores = new ArrayList<>();
			String sql = "select * from score where sno = ?";
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, sno);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					String cno = rs.getString("cno");
					float score = rs.getFloat("score");
					scores.add(new Score(sno, cno, score));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return scores;
		}
	
		public static double getAverageScoreByCno(String cno) {// 按课程查询平均成绩
			double avg = 0;
			int count = 0;
			try {
				String sql = "select avg(score) as avgscore from score where cno = ?";
				PreparedStatement prep = conn.prepareStatement(sql);
				prep.setString(1, cno);
				ResultSet rs = prep.executeQuery();
				if (rs.next()) {
					avg = rs.getDouble("avgscore");
					count++;
				}
				rs.close();
				prep.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return count == 0 ? 0 : avg;
		}
	
		public static int getStudentByGender(String gender) {// 按性别查询学生人数
			int count = 0;
			try {
				String sql = "select count(*) as scount from student where lower(gender) = ?";
				PreparedStatement prep = conn.prepareStatement(sql);
				prep.setString(1, gender.toLowerCase());
	
				ResultSet rs = prep.executeQuery();
	
				if (rs.next()) {
					count = rs.getInt("scount");
				}
	
				rs.close();
				prep.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return count;
		}
	
		public static Score getScoreBySnoAndCno(String sno, String cno) {// 查询某学生选某课程的成绩
			Score score = null;
			try {
				String sql = "select * from score where sno = ? and cno = ?";
				PreparedStatement prep = conn.prepareStatement(sql);
				prep.setString(1, sno);
				prep.setString(2, cno);
	
				ResultSet rs = prep.executeQuery();
	
				if (rs.next()) {
					score = new Score();
					score.setSno(rs.getString("sno"));
					score.setCno(rs.getString("cno"));
					score.setScore(rs.getInt("score"));
				}
	
				rs.close();
				prep.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return score;
		}
	
		public static int statisticsStudentByAge(int age) {// 统计年龄对应的学生人数
			int count = 0;
			try {
				String sql = "select count(*) as count from student where age = ?";
				PreparedStatement prep = conn.prepareStatement(sql);
				prep.setInt(1, age);
	
				ResultSet rs = prep.executeQuery();
	
				if (rs.next()) {
					count = rs.getInt("count");
				}
	
				rs.close();
				prep.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return count;
		}
	
		public static List<Score> getNoPassScore() {// 统计至少有一门课程不及格的学生（学号、课程号和成绩）
			List<Score> noPassStudents = new ArrayList<>();
			try {
				String sql = "select sno, cno, score from score where score < 60";
				PreparedStatement prep = conn.prepareStatement(sql);
	
				ResultSet rs = prep.executeQuery();
	
				while (rs.next()) {
					String sno = rs.getString("sno");
					String cno = rs.getString("cno");
					int score = rs.getInt("score");
					Score noPassStudent = new Score(sno, cno, score);
					noPassStudents.add(noPassStudent);
				}
	
				rs.close();
				prep.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return noPassStudents;
		}
	

//------------------------------------------------排序模块--------------------------------------------------
//按平均成绩排序,显示学号与平均成绩
public static List<String[]> sortByavgScore() {
List<String[]> result = new ArrayList<>();
try {
// SQL查询语句，计算每个学号的平均成绩
String sql = "SELECT sno, TO_CHAR(AVG(score), 'FM999999999.00') as avgScore FROM score GROUP BY sno ORDER BY AVG(score) DESC";
PreparedStatement stmt = conn.prepareStatement(sql);
ResultSet rs = stmt.executeQuery();

// 遍历结果集，将学号和平均成绩存入列表
while (rs.next()) {
	String[] row = new String[2];
	row[0] = rs.getString("sno"); // 学号
	row[1] = String.format("%.2f", rs.getDouble("avgScore")); // 平均成绩，保留两位小数
	result.add(row);
}

//没有按平均成绩排序排序
Collections.sort(result, new Comparator<String[]>() {
	@Override
	public int compare(String[] o1, String[] o2) {
		float credit1 = Float.parseFloat(o1[1]); // 将字符串转换为浮点数
		float credit2 = Float.parseFloat(o2[1]);
		return Float.compare(credit1, credit2); // 升序排序
	}
});

// 关闭资源
rs.close();
stmt.close();
} catch (SQLException e) {
e.printStackTrace();
}
return result;
}


//按某门课程的成绩排序 
public static List<String[]> sortScoreByCno(String cno) {
 List<String[]> scoresByCno = new ArrayList<>();
        try {
            // 准备SQL语句
            String sql = "SELECT sno, score FROM score WHERE cno = ?";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, cno); // 设置课程号参数
            ResultSet rs = prep.executeQuery();

            // 从数据库结果集中提取所有记录
            while (rs.next()) {
                String sno = rs.getString("sno");
                float credit = rs.getFloat("score"); // 获取浮点数学分
                String creditStr = String.format("%.2f", credit); // 将学分转换为保留两位小数的字符串
                scoresByCno.add(new String[] {sno, creditStr});
            }

            // 根据学分进行排序
            Collections.sort(scoresByCno, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    float credit1 = Float.parseFloat(o1[1]); // 将字符串转换为浮点数
                    float credit2 = Float.parseFloat(o2[1]);
                    return Float.compare(credit1, credit2); // 升序排序
                }
            });

// 关闭资源
rs.close();
prep.close();

return scoresByCno;
} catch (SQLException e) {
e.printStackTrace();
}
return null; // 发生异常时返回null
}

//--------------------------------删除模块--------------------------------------------	 
//（1）	按学号和课程号删除成绩信息
public static boolean delScoreBySnoAndCno(String sno, String cno)throws SQLException{
	if (!haveScore(sno,cno)) {
		return false;// 如果不存在，返回false表示失败
	}
//校验学生是否存在
try {
String sql = "delete from score where sno=? and cno=?";
PreparedStatement prep = conn.prepareStatement(sql);
prep.setString(1,sno);
prep.setString(2,cno);
int r = prep.executeUpdate();
return r > 0;
} catch (SQLException e) {
e.printStackTrace();
return false;
}
//用判断函数返回,参考添加, 以下的删除也要修改
}
//（2）	按学号删除学生
public static boolean delStudentBySno(String sno)throws SQLException{
	if (!haveStudent(sno)) {
		return false;// 如果不存在，返回false表示失败
	}
try {
String sql = "delete from student where sno=?";
PreparedStatement prep = conn.prepareStatement(sql);
prep.setString(1,sno);
int r = prep.executeUpdate();
return r > 0;
} catch (SQLException e) {
e.printStackTrace();
return false;
}
}
//（3）	按课程号删除课程
public static boolean delCourseByCno( String cno)throws SQLException{
	if (!haveCourse(cno)) {
		return false; // 如果不存在，返回false表示失败
	}
try {
String sql = "delete from course where cno=?";
PreparedStatement prep = conn.prepareStatement(sql);
prep.setString(1,cno);
int r = prep.executeUpdate();
return r > 0;
} catch (SQLException e) {
e.printStackTrace();
return false;
}
}
//------------------------------------------修改模块-------------------------------------------------------------	
// （1）	按学号和课程号修改成绩信息
public static boolean updateScoreBySnoAndCno(String sno, String cno, Score score)throws SQLException{

//数据校验, 以下的修改函数也要做数据校验
if (!haveScore(score.getSno(),score.getCno())) {
	return false;// 如果不存在，返回false表示失败
}

try {
String sql = "update score set score=? , sno=? , cno=? where sno=? and cno=?";
PreparedStatement prep = conn.prepareStatement(sql);
String cno2=score.getCno();
String sno2=score.getSno();
float score2=score.getScore();
prep.setFloat(1,score2);
prep.setString(2,sno2);
prep.setString(3,cno2);
prep.setString(4,sno);
prep.setString(5,cno);
int r = prep.executeUpdate();
return true;
} catch (SQLException e) {
e.printStackTrace();
return false;
}

}
//（2）	修改学生信息
public static boolean updateStudentBySno(String sno, Student student)throws SQLException{
	if (!haveStudent(student.getSno())) {
		return false;// 如果不存在，返回false表示失败
	}
try {
String sql = "update student set sname=? , sno=? , age=? , nation=? , gender=? where sno=?";
PreparedStatement prep = conn.prepareStatement(sql);
String name2=student.getSname();
String sno2=student.getSno();
int age2=student.getAge();
String nation2=student.getNation();
String gender2=student.getGender();

prep.setString(1,name2);
prep.setString(2,sno2);
prep.setInt(3,age2);
prep.setString(4,nation2);
prep.setString(5,gender2);
prep.setString(6,sno);
int r = prep.executeUpdate();
return true;	
} catch (SQLException e) {
e.printStackTrace();
return false;
}

}
//（3）	修改课程信息 
public static boolean updateCourseByCno(String cno, Course course)throws SQLException{
	if (!haveCourse(course.getCno())) {
		return false; // 如果不存在，返回false表示失败
	}
try {
String sql = "update course set cno=? , cname=? , credit=? where cno=?";
PreparedStatement prep = conn.prepareStatement(sql);
String cno2=course.getCno();
String cname2=course.getCname();
float credit2=course.getCredit();
prep.setString(1,cno2);
prep.setString(2,cname2);
prep.setFloat(3,credit2);
prep.setString(4,cno);
int r = prep.executeUpdate();	
return true;
} catch (SQLException e) {
e.printStackTrace();
return false;
}
}	 
//--------------------------------------------分割线--------------------------------------------------------------
}
