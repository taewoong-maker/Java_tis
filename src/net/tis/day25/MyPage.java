package net.tis.day25;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

public class MyPage {
   public static void main(String[] args) {
	   
  	//Readable  rd = new Readable(); ����
  	 //Calendar cc = new Calendar(); ����
  	 //Scanner(Readable source) ������
  	 Scanner sc = new Scanner(new Readable() {
			 	@Override
				 public int read(CharBuffer cb) throws IOException {
					return 0;
				}
  	 });
  	 
   }
}//class END
