package net.tis.day25;


import java.util.StringTokenizer;

public class  Homework_StringTokenizer {
	public static void main(String[] args) {
		String data="2019/06/25/////�����/���ɽð�/�ڹټ���" ;
				
		String[ ] my=data.split("/"); //5�������ͷ� �и��ؼ� ���
		for(int i=0; i<my.length; i++) {
			System.out.println((i+1)+"��° ������=" + my[i]);
		}
		System.out.println();
	
		int cnt=1;
		StringTokenizer st= new StringTokenizer(data, "/");
		while(st.hasMoreTokens()==true) {
			System.out.println(cnt+"��° ������=" +st.nextToken());
			cnt++;
		}

		//���Խ�ǥ���ǽ�
		System.out.println("\n�ڹ��� ���Խ� matches");
	  String jumin="801230-1736295";
	  System.out.println(jumin);
      if(jumin.matches("[0-9]+")==false) {
	 	System.out.println("�ֹι�ȣ��  Ư�����ڰ� �ֽ��ϴ�");
	   }else {System.out.println("�ֹι�ȣ ���ڱ����� �½��ϴ�"); }
    
      
    Homework_StringTokenizer.test();
	}//main end

public static void test( ){
	 System.out.println("\n\n�ڹ��� String���ڿ�");
	 //���� ���ڿ�
		String a = "hello"; //���������� ������� ���
		String b = "HeLLO"; //���������� ������� ���
		//��ҹ��� ��ȯ
		System.out.println(a.toUpperCase());//�빮�� ��ȯ
		System.out.println(b.toLowerCase());//�ҹ��� ��ȯ
		
		//��ҹ��� ������ �� 
		System.out.println(a.toUpperCase().equals(b.toUpperCase()));
		System.out.println(a.equalsIgnoreCase(b));

		String email = "kim1111@naver.com";
		System.out.println();
		System.out.println(email.startsWith("ki"));//���۹��ڿ� �˻�
		System.out.println(email.endsWith("com"));//�����ڿ� �˻�
		System.out.println(email.indexOf("naver"));//���Թ��ڿ� �˻�
  }//test end
}//class END
