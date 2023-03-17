package lang;

/* 자바에서 문자열 다루기
 * 1) String
 * 2) StringBuffer : 원본 문자열 변경 가능 / 멀티쓰레드 안전
 * 3) StringBuilder : 원본 문자열 변경 가능 / StringBuffer 똑같은데 멀티쓰레드 부분만 제거된 클래스
 */

public class StringBufferEx1 {
	public static void main(String[] args) {
		StringBuffer sb1=new StringBuffer(); // initial capacity of 16 characters(버퍼의 크기가 16)
		StringBuffer sb2=new StringBuffer(100); // 버퍼의 크기가 100
		StringBuffer sb3=new StringBuffer("Hello"); // 버퍼의 크기는 문자열 길이만큼
		
		// StringBuffer sb4 = "Hello"; (X)
		System.out.println(sb2); // 버퍼안의 내용이 없음
		System.out.println(sb3);
		
		// append() : 원본 문자열 뒤에 추가
//		sb2.append(false);
//		sb2.append("abc");
//		sb2.append('d');
		
		sb2.append(false).append("abc").append('d');		
		System.out.println(sb2);
		
		// equals() 를 Object 가 넘겨준 상태(주소 비교)로 사용
		StringBuffer sb4 = new StringBuffer("Hello");
		System.out.println("equals() "+sb3.equals(sb4)); // false
		
		// 값비교를 해야 한다면? String 으로 변경
		String str1 = sb3.toString();
		String str2 = sb4.toString();
		System.out.println("String equals() "+str1.equals(str2));
		
		// delete(int start, int end) : 시작위치에서 끝위치-1 사이의 문자를 제거
		StringBuffer sb5 = new StringBuffer("0123456");
		StringBuffer sb6 = sb5.delete(3, 6);
		System.out.println("sb5 "+ sb5);
		System.out.println("sb6 "+ sb6);
		
		// deleteCharAt(int index) : index 의 문자 제거
		sb5 = new StringBuffer("0123456");
		sb6 = sb5.deleteCharAt(4);
		System.out.println("sb5 "+ sb5);
		System.out.println("sb6 "+ sb6);
		
		// insert(int offset,삽입할 값) : offset 위치에 값을 삽입
		sb5.insert(4, "-");
		System.out.println("insert() "+sb5);
		
		// replace(int start, int end, String str)
		sb5 = new StringBuffer("0123456");
		sb5.replace(3, 6, "ABC");
		System.out.println("replace() "+sb5);
		
		
		str2 = "0123456789";
		// 출력 9876543210
		for (int i = str2.length()-1; i >= 0; i--) {
			System.out.print(str2.charAt(i));
		}
		
		// reverse() : 거꾸로 나열
		System.out.println();
		sb5 = new StringBuffer(str2);
		System.out.println(sb5.reverse());
		
		// setCharAt()
		sb5 = new StringBuffer("0123456");
		sb5.setCharAt(4, 'A');
		System.out.println("setCharAt() "+sb5);
		
	}
}

















