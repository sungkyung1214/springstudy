package ex02_DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		// Spring container는 객체(Bean)를 생성하고 관리한다.
		// Container가 객체를 생성하고 관리할 수 있도록 설정 정보를 만들어야한다.
		
		// Spring Container => BeanFactory => AppplicationContext (java)
		//								   => WebApplicationContext(Web)
		
		// 해당 컨테이너가 설정정보를 읽어서 객체를 생성/관리하고 의존성 주입을 할 수 있다.
		ApplicationContext context = 
				new GenericXmlApplicationContext("ex02_DI/config.xml");
		
		// Service에 있는 biz() 실행
		// ex02_DI/config.xml에서 만들어진 객체 호출
		Service  service = (Service) context.getBean("service");
		service.biz();
	}
}
