package database2;

import java.util.ArrayList;
import java.util.Scanner;

public class DeptMain {

	public static void main(String[] args) {
		DeptDao dao = new DeptDao();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("===================");
			System.out.println("1.특정 부서 조회 ");
			System.out.println("2.전체 부서 조회 ");
			System.out.println("3.새 부서 추가 ");
			System.out.println("4.부서 정보 수정 ");
			System.out.println("5.부서 정보 삭제 ");
			System.out.println("6.종료 ");
			System.out.println("===================");

			System.out.println("메뉴 입력 : ");
			int no = sc.nextInt();

			switch (no) {
			case 1:
				System.out.println("조회를 원하는 부서코드를 입력을 해주세요 : ");
				int deptno = sc.nextInt();
				// 하나조회하는 메소드
				DeptDTO row = dao.getRow(deptno);
				System.out.println(row);
				break;
			case 2:
				ArrayList<DeptDTO> list = dao.getRows();
				for (DeptDTO dto : list) {
					System.out.println(dto.getDeptno() + "\t" + dto.getDname() + "\t" + dto.getLoc());
				}
				break;

			case 3:
				System.out.println("새로운 부서 정보를 입력합니다.");
				System.out.print("부서 코드를 입력하세요: ");
				deptno = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 비우기
				System.out.print("부서 이름을 입력하세요: ");
				String dname = sc.nextLine();
				System.out.print("부서 위치를 입력하세요: ");
				String loc = sc.nextLine();
				DeptDTO newDept = new DeptDTO(deptno, dname, loc);
				boolean isSuccess = dao.insertRow(newDept);
				String result = (isSuccess) ? "성공" : "실패";
				System.out.println("부서 정보 입력 " + result);
				break;

			case 4:
				System.out.println("1) 부서명 수정 2) 위치수정 원하는 번호 입력");
				int updateNo = sc.nextInt();
				System.out.print("부서 코드를 입력하세요: ");
				deptno = sc.nextInt();
				System.out.print("수정할 정보를 입력하세요: ");
				if (updateNo == 1) { // 부서명 수정
					dname = sc.next();
					isSuccess = dao.updateRow(deptno, dname, null, updateNo);
					System.out.println(isSuccess ? "부서명 수정에 성공하였습니다." : "부서명 수정에 실패하였습니다.");

				} else if (updateNo == 2) { // 위치 수정
					loc = sc.next();
					isSuccess = dao.updateRow(deptno, null, loc, updateNo);
					System.out.println(isSuccess ? "위치 수정에 성공하였습니다." : "위치 수정에 실패하였습니다.");

				}
				break;

			case 5:
				System.out.println("삭제할 부서번호 입력 :");
				deptno = sc.nextInt();
				isSuccess = dao.removeDepartment(deptno);
				System.out.println(isSuccess? "삭제 완료 ": "삭제 실패");
				
				break;
			case 6:
				flag = false;
				break;

			default:
				System.out.println("번호를 다시 입력해 주세요.");
				break;
			}
		}

	}

}
