package Guest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DVD.DVD;
import Manage.Manager;

public class Guest2 {

	static Scanner sc = new Scanner(System.in);

	private boolean member;
	private String name;

	//借りたのをListに格納
	private final List<DVD> rentedDVDs = new ArrayList<>();

	public Guest2(String name) {
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public void setMember(boolean found) {
		this.member = found;
	}

	public boolean member() {
		return member;
	}

	public void setRental(DVD[] dvd, Manager manage) {

		System.out.println("1～6の数字で,借りたい本を選んでください");

		for (int i = 0; i < dvd.length; i++) {
			dvd[i].display();
		}

		int n = sc.nextInt() - 1;

		if (dvd[n].getRented()) {
			System.out.println("そのDVDは貸出中です");
			return;
		}

		System.out.println("借りたのは");
		System.out.println(dvd[n].getName());
		System.out.println(dvd[n].getValue() + "です");

		manage.cal(dvd[n].getValue(), member());

		dvd[n].rent();
		rentedDVDs.add(dvd[n]);

		for (int i = 0; i < dvd.length; i++) {
			dvd[i].display();
		}
	}

	public void return1(DVD[] dvd) {

		if (rentedDVDs.size() == 0) {
			System.out.println("借りてるのはないです");
			return;
		}

		System.out.println("今借りてるのは");
		System.out.println("番号で選んでください");
		for (int i = 0; i < rentedDVDs.size(); i++) {
			DVD d = rentedDVDs.get(i);
			System.out.println((i + 1) + ":" + d.getName() + "\s" + d.getValue());
		}

		int n = sc.nextInt() - 1;

		DVD d = rentedDVDs.remove(n);
		d.giveBack();

		for (int i = 0; i < dvd.length; i++) {
			dvd[i].display();
		}
	}
}