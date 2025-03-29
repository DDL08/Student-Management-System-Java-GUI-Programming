package base;

		public  class Course {
			String cno;
			String cname;
			float credit;
			public Course(){

			}
			public Course(String a,String b,float c){
				this.cno=a;
				this.cname=b;
				this.credit=c;
			}
			public String getCno() {
				return cno;
			}

			public void setCno(String cno) {
				this.cno = cno;
			}
			public String getCname() {
				return cname;
			}
			public void setCname(String cname) {
				this.cname = cname;
			}
			public float getCredit() {
				return credit;
			}
			public void setCredit(float credit) {
				this.credit = credit;
			}
			}
