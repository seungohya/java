package util;

public class Test {
	private String name;
	private int no;
	private String tel;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Test [name=" + name + ", no=" + no + ", tel=" + tel + "]";
	}
	public Test(String name, int no, String tel) {
		super();
		this.name = name;
		this.no = no;
		this.tel = tel;
	}
	public void print () {}
	public void sum() {
		
	}

}
