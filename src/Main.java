import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DVD.DVD;
import Guest.Guest2;
import  Manage.Manager;
import Screen.MainScreen;
import Screen.Screen;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static final int customerCnt = 5;	// 来客数

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DVD[] dvd = { new DVD("ミッション", "秋", "新作"), new DVD("博士", "太郎", "普通"), new DVD("先生", "山", "旧作"),
				new DVD("情報", "冬", "新作"), new DVD("可能", "玲子", "普通"), new DVD("定め", "配列", "旧作") };
		
		Manager manage =new Manager();
		//続き
		Screen scr = new MainScreen(dvd,manage);

		visitCustomer(scr);
		
		manage.assets();

	}

	public static void visitCustomer(Screen scr) {

		List<Guest2> list = new ArrayList<>();
		

		for (int i = 0; i < customerCnt; i++) {

			System.out.println("いらっしゃいませ");

			String textBlock = """
					1,名前と
					2,会員か非会員かどっちですか
					会員なら　YES　非会員ならNO
					""";
			System.out.println(textBlock);

			String name = sc.next();

			Guest2 g = null;
			g = check(name, list);
			if (g != null) {
				System.out.println("おかえりなさい");//既存の客の処理

			} else {

				g = new Guest2(name);

				String mem = sc.next();

				//登録してない者は、旧作20%引き、登録者は　新作20%引き
				boolean found;
				if (mem.equals("YES")) {
					found = true;
				} else {
					found = false;
				}
				g.setMember(found);//会員or非会員

				list.add(g);
			}

			scr.print(g);

		}

	}

	public static Guest2 check(String name, List<Guest2> list) {

		for (Guest2 g : list) {
			if (g.getName().equals(name)) {
				return g;
			}
		}
		return null;
	}

}
