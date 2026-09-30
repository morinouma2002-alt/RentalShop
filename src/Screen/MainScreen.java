package Screen;

import DVD.DVD;
import Guest.Guest2;
import Manage.Manager;

public class MainScreen implements Screen {

	private DVD[] dvd;
	private Manager manage;

	public MainScreen(DVD[] dvd, Manager manage) {
		this.dvd = dvd;
		this.manage = manage;
	}

	@Override
	public void rental(Guest2 guest) {

		//またインスタンスしたら　矛盾してしまう g=new ReturuGuest()
		guest.setRental(dvd, manage);
	}

	@Override
	public void return11(Guest2 guest) {

		guest.return1(dvd);

	}

	@Override
	public void search(Guest2 guest) {

		System.out.println("1～６の数字を選んでください、作品の詳細がでます\n"
				+ "検索を続けたいならYESをおしてください");
		DVD.searchDVD(dvd);
	}
}
