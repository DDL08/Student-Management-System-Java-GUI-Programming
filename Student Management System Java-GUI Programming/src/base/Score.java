package base;
/*成绩类↓ */
			public  class Score {
				String sno;
				String cno;
				float score;
				public  Score(){

				}
				public  Score(String a,String b,float c){
					this.sno=a;
					this.cno=b;
					this.score=c;
				}
				public String getSno() {
					return sno;
				}
				public void setSno(String sno) {
					this.sno = sno;
				}
				public String getCno() {
					return cno;
				}
				public void setCno(String cno) {
					this.cno = cno;
				}
				public float getScore() {
					return score;
				}
				public void setScore(float score) {
					this.score = score;
				}

				}