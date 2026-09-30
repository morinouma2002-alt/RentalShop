package DVD;

import java.util.Scanner;

public class DVD {

	static Scanner sc = new Scanner(System.in);
	private final String name;
	private final String direc;
	private final String value;
	
	//★★　booleanで管理する
	private boolean rented = false;

	public DVD(String name, String direc, String value) {
		this.name = name;
		this.direc = direc;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public boolean getRented() {
		return rented;
	}

	public void rent() {
		rented = true;
	}

	public void giveBack() {
		rented = false;
	}

	public void display() {
		if (rented) {
			System.out.println("貸出中");
		} else {
			System.out.println(name + "\s" + value);
		}
	}

	public static void searchDVD(DVD[] dvd) {

		System.out.println("DVDの一覧です。検索すると監督名がでます");
		for (int i = 0; i < dvd.length; i++) {
			System.out.println(dvd[i].name + "\s" + dvd[i].value);
		}

		int n = sc.nextInt() - 1;
		DVD dvdSearch = dvd[n];
		System.out.println("監督は" + dvdSearch.direc + "です\n"
				+ "検索を続けますか？続けるならYES");

		boolean found = sc.next().equals("YES");

		if (found) {
			searchDVD(dvd);
		}
	}
}