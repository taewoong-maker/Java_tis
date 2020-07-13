package net.tis.day25;

import java.util.Scanner;

public class  Homework_PassWord_String {
	public static void main(String[] args) {
		 Scanner cin = new Scanner(System.in);
		
		System.out.print("변경할 비밀번호? ");
		String pass =cin.next();
		System.out.print("비밀번호 재확인? ");
		String repass =cin.next();
		//=======================================================
		// 비밀번호설정은 최소 4글자 입니다.
		// 비밀번호는 알파벳 소문자로만 구성되어야 합니다.
		if(pass.length()<4) {
			System.out.println("비밀번호는 최소 4글자 입니다.");
		//}else if(pass.matches("[a-z]+")==false){
		}else if(pass.matches("[0-9]+")==false){
			//System.out.println("알파벳으로만 구성해주세요.");
			System.out.println("숫자로만 구성해주세요.");
		}else {
			if(pass.equals(repass)) {
				System.out.println("변경에 성공하였습니다.");
				String sp = pass.substring(0, 1);
				int cnt = pass.length()-1;
				for(int i=1; i<= cnt ; i++){
					sp+="*";
				}
				System.out.println(sp+" 로 설정됨.");
			}else {	System.out.println("비밀번호가 일치하지 않습니다.");}
		}
	}//main end
}//class END
