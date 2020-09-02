package practice02;

import java.util.HashSet;
import java.util.Set;

public class UnigueEmailAdress {
	public static void main(String[] args) {
		String emails[] = {
				"test.email+JAMES.aa@coding.com",
				"test.em.ail+wowlol@coding.com",
				"test.email+hahaha@cod.ing.com"
		};
		UnigueEmailAdress uea = new UnigueEmailAdress();
		System.out.println(uea.solve(emails));
	}
//	public int solve(String[] emails) {
//		String at[] = new String[emails.length];
//		Set<String> set = new HashSet<String>();
//		for(int i=0;i<emails.length;i++) {
//			at=emails[i].split("@");
//			set.add(at[1]);
//		}
//		int dup =set.size();
//		return dup;
//	}
	public int solve(String[] emails) {
		Set<String> set = new HashSet<String>();
		for(String email : emails) {
			String localName=localName(email);
			String domainName=domainName(email);
			set.add(localName+domainName);
		}
		return set.size();
	}
	
	public String domainName(String email) {
//		StringBuilder sb = new StringBuilder();
//		for(int i=email.length()-1;i>0;i--) {
//			if(email.charAt(i)=='@')
//				break;
//			sb.append(email.charAt(i));
//		}
//		System.out.println(sb);
//		return sb.toString();
		System.out.println(email.substring(email.indexOf("@")+1));
		return email.substring(email.indexOf("@")+1);
	}
	
	public String localName(String email) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<email.length();i++) {
			if(email.charAt(i)=='.')
				continue;
			if(email.charAt(i)=='+')
				break;
			if(email.charAt(i)=='@')
				break;
			
			sb.append(email.charAt(i));
		}
		System.out.println(sb);
		return sb.toString();
	}
}
