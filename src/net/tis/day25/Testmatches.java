package net.tis.day25;

//���� ����Ʈ
//http://www.regexper.com
//API������ java.util.regex.Pattern 

import java.util.Scanner;

public class Testmatches {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		System.out.print("������ ��й�ȣ? ");
		String pass =cin.next();
		System.out.print("��й�ȣ ��Ȯ��? ");
		String repass =cin.next();
		//=======================================================
		// ��й�ȣ������ �ּ� 4���� �Դϴ�.
		// ��й�ȣ�� ����/���ĺ� �ҹ��ڷθ� �����Ǿ�� �մϴ�.
		if(pass.length()<4) {
			System.out.println("��й�ȣ�� �ּ� 4���� �Դϴ�.");
		//}else if(pass.matches("[a-z]+")==false){ ���ĺ��ҹ��ڷθ� ���� 
		}else if(pass.matches("[0-9]+")==false){
			//System.out.println("���ĺ����θ� �������ּ���.");
			System.out.println("���ڷθ� �������ּ���.");
		}else {
			if(pass.equals(repass)) {
				System.out.println("���濡 �����Ͽ����ϴ�\n");
				String sp = pass.substring(0, 1);
				int cnt = pass.length()-1;
				for(int i=1; i<= cnt ; i++){
					sp+="*";
				}
				System.out.println(sp+" ���漺���Ǿ����ϴ�");
			}else {	System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");}
		}
	}

}//class END