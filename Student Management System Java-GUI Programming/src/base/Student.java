package base;

public  class Student  {
	private String sno;
	private String name;
	private int age;
	private String gender;
	private String nation;
	
	public Student(String sno,String name,int age,String gender,String nation) {
		this.sno=sno;
        this.name=name;
        this.age=age;
		this.gender=gender;
        this.nation=nation;
		}
	public  Student() {
		
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return name;
	}
	public void setSname(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}           

}