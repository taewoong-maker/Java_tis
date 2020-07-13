package net.tis.day25;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class TestVectorSam {
	public static void main(String[] args) {
		Vector vt = new Vector();
		vt.add("dong");
		vt.add(24);
		vt.add(true);

		for (int i = 0; i < vt.size(); i++) {
			System.out.print(vt.get(i) + "  ");
		}
		System.out.println();

		Enumeration et = vt.elements();
		while (et.hasMoreElements() == true) {
			System.out.print(et.nextElement() + "  ");
		}
		System.out.println();

		Iterator it = vt.iterator();// ±ÇÀå! -
		while (it.hasNext()) {
			System.out.print(it.next() + "  ");
		}

	}// main end
}// class END
