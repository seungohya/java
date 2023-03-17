package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
 * Map
 * 키(key) : 유일값
 * 값(value) : 중복 가능
 */
public class MapEx1 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		
		// put(key, value) : 요소 추가(key 값이 동일하다면 나중에 추가한 요소만 남게 됨)
		map.put("myId1", "1234");
		map.put("myId2", "4321");
		map.put("myId3", "1545");
		map.put("myId4", "1975");
		
		System.out.println(map);
		
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("id와 password를 입력해 주세요");
			// key에 해당하는 id 입력받기
			System.out.print("아이디 : ");
			String id = sc.nextLine().trim(); // 홍길동  엔터 id="홍길동  "  equals("홍길동")
			
			// value 에 해당하는 password 입력받기
			System.out.print("비밀번호 : ");
			String password = sc.nextLine().trim();
			
			// map에 입력받은 id 가 존재하지 않는 경우 "입력하신 아이디는 존재하지 않습니다. 다시 입력해주세요"
			// 메세지 출력 후 다시 id 입력받기
			
			// containsKey(Object key) : HashMap에 키를 포함하고 있느냐?
			// containsValue(Object value) : HashMap에 value를 포함하고 있느냐?
			if(!map.containsKey(id)) {
				System.out.println("입력하신 아이디는 존재하지 않습니다. 다시 입력해주세요.");
				continue;
			}		
			
			// 입력받은 비밀번호가 일치하는지 확인한 후 
			// 비밀번호가 일치하면 프로그램 종료, 일치하지 않는 경우 "다시 입력해 주세요"
			// get(Object key) : key의 값을 반환, 못찾으면 null
			if(!map.get(id).equals(password)) {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해 주세요");
			}else {
				System.out.println("아이디와 비밀번호가 일치합니다.");
				break;
			}
		}
	}
}
















