package Guest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DVD.DVD;
import Manage.Manager;

public class HasDVD extends Guest {

	static Scanner sc = new Scanner(System.in);

	//連続で借りる可能性があるので、リスト化する

	//将来　rentalクラスにする 後で
	private List<String> getRental = new ArrayList<>();
	private List<String> getValue = new ArrayList<>();
	private List<Integer> index = new ArrayList<>();//どこなのかの番号を覚えておく

	public HasDVD(String name, int idkey) {
		super(name, idkey);
	}

	@Override
	public void setRental(String name, String value,
			int index) {
		this.getRental.add(name);
		this.getValue.add(value);
		this.index.add(index);
	}
	

	@Override
	public void return1(DVD[] dvd) {

		if (getRental.size() == 0) {
			System.out.println("借りてるのはないです");
			return;
		}

		System.out.println("今借りてるのは");
		System.out.println("番号で選んでください");
		for (int i = 0; i < getRental.size(); i++) {
			System.out.println((i + 1) + ":" + getRental.get(i) + "\s" + getValue.get(i));
		}

		int n = sc.nextInt() - 1;

		// 選んだDVDが元々あった棚番号
		int shelfIndex = index.get(n);

		DVD d = dvd[shelfIndex];
		d.shelfReturn(getRental.get(n), getValue.get(n));

		// ★返却したので、客の借り物リストから削除
		getRental.remove(n);
		getValue.remove(n);
		index.remove(n);

		//表示する
		for (int i = 0; i < dvd.length; i++) {
			dvd[i].display();
		}

	}

	@Override
	public void proceRental(Guest guest, DVD[] dvd, Manager manage) {

		System.out.println("1～6の数字で,借りたい本を選んでください");

		//dvd[]型で　実体の型→shelf型になっている

		//一覧表示
		for (int i = 0; i < dvd.length; i++) {
			dvd[i].display();
		}

		int n = sc.nextInt() - 1;

		if (dvd[n].getName().equals("貸出中")) {
			System.out.println("そのDVDは貸出中です");
			return;
		}

		System.out.println("借りたのは");
		System.out.println(dvd[n].getName());
		System.out.println(dvd[n].getValue() + "です");
		
		
		//作品の価値と、会員なのかをわたす
		manage.cal(dvd[n].getValue(),guest.member());

		guest.setRental(dvd[n].getName(), dvd[n].getValue(), n);

		dvd[n].rented();//借りた処理

		for (int i = 0; i < dvd.length; i++) {
			dvd[i].display();
		}

	}

}
