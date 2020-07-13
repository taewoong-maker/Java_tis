package net.tis.day25;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMaskRegex  {
	public static void main(String[] args) {
	  String data="27�� ����� �����մϴ�"
	  		+"�� ��ȭ��ȣ 02-990-1200�̸�" 
	  		+"�繫�� ��ȣ 02-75-3400�̸�"
	  		+"��ģ1 ��ȣ 010-7100-6500�̸�"
	  		+"¦�� ��ȣ 010-34700-1200�̸�"
	  		+"�ڵ��� ��ȣ 010-6789-5600�Դϴ�";
	  
     //�����ڵ��� \\d{2,3}-\\d{3,4}-\\d{4} 
	   String format="\\d{2,3}-\\d{3,4}-\\d{4}";
	   Pattern pt=Pattern.compile(format);
	   Matcher mt=pt.matcher(data);
	   
	   int count=0;
	   while(mt.find()==true) {
	  	 count++;
	  	 System.out.println("��ȭ��ȣ: " + mt.group());
	   }
	   
	 	 System.out.println("�߰ߵ� ��ȭ��ȣ �� : " + count);
	}//main end
}//class END







