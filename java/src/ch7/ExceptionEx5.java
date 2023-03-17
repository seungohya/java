package ch7;

/* 컴파일에러 : 컴파일 시에 발생하는 에러
 * 런타임에러 : 실행 시에 발생하는 에러
 * 논리적에러 : 실행은 되지만, 의도와 다르게 동작하는 것
 * 
 * 에러(error) : 코드에 의해서 수습될 수 없는 심각한 오류 ex) 메모리부족, 스택오버플로우
 * 예외(exception) : 코드에 의해서 수습될 수 있는 미약한 오류
 * 
 * 
 * Exception
 * 1) Exception 클래스들 : 사용자의 실수와 같은 외적인 요인에 의해 발생하는 예외
 * 2) RuntimeException 클래스들: 프로그래머의 실수로 발생하는 예외
 *    - 배열 범위 벗어나기, NullPointerException, ClassCastException...
 *    
 * Exception 처리   
 * try ~ catch
 * 예외 던지기 : main 메소드를 호출하는 곳(jvm)에서 처리   
 */
public class ExceptionEx5 {
	public static void main(String[] args) {
		int arr[]=new int[0];
		try {
			getAverage(arr);
		} catch (Exception e) {			
//			e.printStackTrace();
			//예외 메세지만 출력
			System.out.println(e.getMessage());
		}
	}
	// getAverage 메서드에 예외 선언
	// getAverage를 호출하면 예외가 발생할 수 있음
	static double getAverage(int arr[]) throws Exception{
		if(arr.length == 0) {
			//강제로 예외 발생
			//Exception 클래스 사용 시 컴파일시 예외
			throw new Exception("비어있는 배열입니다.");
			//실행시 예외
			//throw new RuntimeException("비어있는 배열입니다.");
		}
		return getTotal(arr)/arr.length;
	}
	
	static int getTotal(int arr[]) {
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		return total;
	}
}














