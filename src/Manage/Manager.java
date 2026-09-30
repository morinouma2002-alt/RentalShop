package Manage;

import java.util.ArrayList;
import java.util.List;

import 不要.Guest;

public class Manager {

	private int assets = 0;
	private int[] priceV = { 150, 100, 50 };

	//将来的に　誰がなにを登録し、何を購入したかをここから見れるようにしたい
	List<Guest> check = new ArrayList<>();
	
	
	public void cal(String value, boolean member) {

		int cal;
		if (member) {
			System.out.println("会員なので、新作が20%オフされる");

			cal = calValue(value, member);
		} else {
			System.out.println("非会員なので、旧作が20%オフされる");
			cal = calValue(value, member);
		}
		
		System.out.println(cal+"円でした");
	}

	public int calValue(String value, boolean member) {

		int price = 0;
		if (member) {
			if (value.equals("新作")) {
				price = (int) (priceV[0] * 0.8);
				assets += price;
			} else if (value.equals("普通")) {
				price = priceV[1];
				assets += priceV[1];
			} else {
				price = priceV[2];
				assets += priceV[2];
			}

		} else {
			if (value.equals("新作")) {
				price=priceV[0];
				assets += priceV[0];
			} else if (value.equals("普通")) {
				price=priceV[1];
				assets += priceV[1];
			} else {
			     price = (int) (priceV[2] * 0.8);
				assets += price;
			}
			
			
		}
		return price;

	}
	
	public  void assets() {
		System.out.println("店の財産は"+this.assets);
	}

}
