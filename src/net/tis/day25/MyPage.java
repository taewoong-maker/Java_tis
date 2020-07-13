package net.tis.day25;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

public class MyPage {
   public static void main(String[] args) {
	   
  	//Readable  rd = new Readable(); 에러
  	 //Calendar cc = new Calendar(); 에러
  	 //Scanner(Readable source) 생성자
  	 Scanner sc = new Scanner(new Readable() {
			 	@Override
				 public int read(CharBuffer cb) throws IOException {
					return 0;
				}
  	 });
  	 
   }
}//class END
