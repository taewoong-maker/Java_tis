package net.tis.day25;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMaskRegex  {
	public static void main(String[] args) {
	  String data="27세 서울시 거주합니다"
	  		+"집 전화번호 02-990-1200이며" 
	  		+"사무실 번호 02-75-3400이며"
	  		+"절친1 번호 010-7100-6500이며"
	  		+"짝궁 번호 010-34700-1200이며"
	  		+"핸드폰 번호 010-6789-5600입니다";
	  
     //숫자핸드폰 \\d{2,3}-\\d{3,4}-\\d{4} 
	   String format="\\d{2,3}-\\d{3,4}-\\d{4}";
	   Pattern pt=Pattern.compile(format);
	   Matcher mt=pt.matcher(data);
	   
	   int count=0;
	   while(mt.find()==true) {
	  	 count++;
	  	 System.out.println("전화번호: " + mt.group());
	   }
	   
	 	 System.out.println("발견된 전화번호 수 : " + count);
	}//main end
}//class END







