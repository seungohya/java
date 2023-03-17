package generics;

import java.util.Comparator;

public class Student2 implements Comparator<Student2>{
	private String name;
	private int ban;
	private int no;
	public Student2(String name, int ban, int no) {
		super();
		this.name = name;
		this.ban = ban;
		this.no = no;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public int compare(Student2 o1, Student2 o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
