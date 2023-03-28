package shop;

//상수, 모든메서드는 추상
public interface IShop {
	//public static abstract 자동
	void setTitle(String title);
	void genUser();
	void genProduct();
	void start();
}