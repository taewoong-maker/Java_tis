package net.tis.day25;


import java.util.StringTokenizer;

public class  Homework_StringTokenizer {
	public static void main(String[] args) {
		String data="2019/06/25/////목요일/점심시간/자바수업" ;
				
		String[ ] my=data.split("/"); //5개데이터로 분리해서 출력
		for(int i=0; i<my.length; i++) {
			System.out.println((i+1)+"번째 데이터=" + my[i]);
		}
		System.out.println();
	
		int cnt=1;
		StringTokenizer st= new StringTokenizer(data, "/");
		while(st.hasMoreTokens()==true) {
			System.out.println(cnt+"번째 데이터=" +st.nextToken());
			cnt++;
		}

		//정규식표현실습
		System.out.println("\n자바의 정규식 matches");
	  String jumin="801230-1736295";
	  System.out.println(jumin);
      if(jumin.matches("[0-9]+")==false) {
	 	System.out.println("주민번호에  특수문자가 있습니다");
	   }else {System.out.println("주민번호 숫자구성이 맞습니다"); }
    
      
    Homework_StringTokenizer.test();
	}//main end

public static void test( ){
	 System.out.println("\n\n자바의 String문자열");
	 //번외 문자열
		String a = "hello"; //예외적으로 만들어진 방식
		String b = "HeLLO"; //예외적으로 만들어진 방식
		//대소문자 변환
		System.out.println(a.toUpperCase());//대문자 변환
		System.out.println(b.toLowerCase());//소문자 변환
		
		//대소문자 무시한 비교 
		System.out.println(a.toUpperCase().equals(b.toUpperCase()));
		System.out.println(a.equalsIgnoreCase(b));

		String email = "kim1111@naver.com";
		System.out.println();
		System.out.println(email.startsWith("ki"));//시작문자열 검사
		System.out.println(email.endsWith("com"));//끝문자열 검사
		System.out.println(email.indexOf("naver"));//포함문자열 검사
  }//test end
}//class END
