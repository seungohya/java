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
