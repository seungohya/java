package lang;

public class StringEx4 {

	public static void main(String[] args) {
		String names[]= {"Queen","Tod","Park","Kim","Hong"};
		System.out.println(findKim(names));
		// 출력결과 
		// 김씨 성은 4번째에 있다
	}
	
	public static String findKim(String[] seoul) {
		int index = 0; // kim 이 있는 위치를 저장할 변수
		// Kim 찾기
		for (int i = 0; i < seoul.length; i++) {
			if(seoul[i].equals("Kim")) {
				index = i;
				break;
			}
		}
		// 리턴 구문의 형태는 출력문과 동일
		return "김씨 성은 "+ (index+1) + "번째에 있다";
	}
}
