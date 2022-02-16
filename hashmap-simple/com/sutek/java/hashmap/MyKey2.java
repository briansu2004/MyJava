package com.sutek.java.hashmap;

public class MyKey2 {
	private final String name;
	private final int id;

	public MyKey2(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		System.out.println("Calling hashCode()");
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Calling equals() for key: " + obj);

		if (!(obj instanceof MyKey2)) {
			return false;
		}

		return name.equals(((MyKey2) obj).getName());
	}

	@Override
	public String toString() {
		return "MyKey2{" +
			"name='" + name + '\'' +
			", id=" + id +
			'}';
	}
}