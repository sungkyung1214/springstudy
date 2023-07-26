package ex03_DI;

public class TestMain_nonDI {
	public static void main(String[] args) {
		// 생성자를 이용하는 방법
		MyProcess mp = new MyProcess("둘둘리",23);
		mp.prn();
		System.out.println("=====================");
		
		
		MyProcess mp2 = new MyProcess("둘둘리",23);
		mp2.setName("희동이");
		mp2.setAge(3);
		mp2.prn();
		System.out.println("=====================");
		
	}
}
