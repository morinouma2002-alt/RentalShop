package Guest;

import DVD.DVD;
import Manage.Manager;
public abstract class Guest {

	private boolean member;
	private String name;
	private int id;
	
	public Guest(String name,int id) {
		this.name=name;
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setMember(boolean found) {
		this.member=found;
	}
	
	public  boolean member() {
		return member;
	}
	public abstract void setRental(String name,String value,int index);
	public abstract void return1(DVD[]dvd);
	public abstract void proceRental(Guest guest,DVD[]dvd,Manager manage);
}
