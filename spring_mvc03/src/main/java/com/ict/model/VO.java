package com.ict.model;

public class VO {
	// 파라미터도 저장할 수 있다.
	private String s1,s2,op,cPgae;
	private String[] hobby;
	// 파라미터 넘어오는 이름이랑 무조건 동일해야한다.
	// 그러면 getparme 이걸로 받을 필요가 없다.
	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getcPgae() {
		return cPgae;
	}
	public void setcPgae(String cPgae) {
		this.cPgae = cPgae;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	
}
