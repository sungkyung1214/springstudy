package com.ict.db;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public class DAO {
	// 실제 사용하는 클래스 : sqlSessionTemplate
	// SqlSessionTemplate클래스를 자료형으로 사용함. 이 클래스를 객체로 사용할려면 객체로 만들어져있어야함
	// jsp에서 사용한 sqlsession과 사용법이 같다
	

	private SqlSessionTemplate session;

	public SqlSessionTemplate getSession() {
		return session;
	}

	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}


	public List<VO> getList(){
		List<VO> list = session.selectList("members.list");
		return list;
	}	
}
