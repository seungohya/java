package database2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EmpMain {

	public static void main(String[] args) throws Exception {
		EmpDao dao = new EmpDao();
		Scanner sc = new Scanner(System.in);

		boolean flag = true;

		while (flag) {
			System.out.println("===================");
			System.out.println("1.사원 추가 ");
			System.out.println("2.사원 삭제 ");
			System.out.println("3.사원 급여 수정 ");
			System.out.println("4.사원 조회 (사번) ");
			System.out.println("5.사원 조회 (이름) ");
			System.out.println("6.종료 ");
			System.out.println("===================");

			int no = sc.nextInt();

			switch (no) {

			case 1:
				System.out.println("추가할 사원 정보를 입력하세요.");
				System.out.print("사원번호: ");
				int empno = sc.nextInt();
				System.out.print("이름: ");
				String ename = sc.next();
				System.out.print("직급: ");
				String job = sc.next();
				System.out.print("상사번호: ");
				int mgr = sc.nextInt();
				System.out.print("입사일(yyyy-mm-dd): ");
				String hiredateStr = sc.next();
				Date hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(hiredateStr);
				System.out.print("급여: ");
				int sal = sc.nextInt();
				System.out.print("보너스: ");
				int comm = sc.nextInt();
				System.out.print("부서번호: ");
				int deptno = sc.nextInt();
				EmpDTO dto = new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				dao.insertEmp(dto);
				System.out.println("새로운 사원 정보가 추가되었습니다.");

				break;

			case 2:
				System.out.println("삭제할 사원의 사번을 입력하세요.");
				int deleteEmpno = sc.nextInt();

				try {
					dao.deleteEmpByEmpno(deleteEmpno);
					System.out.println("사원 삭제 완료!");
				} catch (Exception e) {
					System.out.println("사원 삭제 실패!");
					e.printStackTrace();
				}

				break;
			case 3:
			    System.out.println("사원 번호 입력");
			    int empno3 = sc.nextInt();
			    EmpDTO emp3 = dao.getEmpByEmpno(empno3);
			    if (emp3 != null) {
			        System.out.println(emp3);
			        System.out.println("변동 급여 입력 : ");
			        int sal3 = sc.nextInt();

			        emp3.setSal(sal3);
			        dao.updateEmp(emp3); // 데이터베이스에 업데이트

			        System.out.println("사원 정보가 수정되었습니다.");
			    } else {
			        System.out.println("해당 사원이 존재하지 않습니다.");
			    }
			    break;


			case 4:
				System.out.println("조회할 사원의 사번을 입력하세요:");
				empno = sc.nextInt();
				EmpDTO emp = dao.getEmpByEmpno(empno);
				if (emp != null) {
					System.out.println("사번: " + emp.getEmpno() + ", 이름: " + emp.getEname() + ", 직책: " + emp.getJob()
							+ ", 급여: " + emp.getSal() + ", 추가수당 : " + emp.getComm() + ", 부서번호 : " + emp.getDeptno());

				} else {
					System.out.println("해당 사번의 사원이 없습니다.");
				}
				break;

			case 5:
				System.out.println("조회할 사원 이름 입력:");
				String name = sc.next();
				ArrayList<EmpDTO> list = dao.getEmpByName(name);
				if (list.isEmpty()) {
					System.out.println("해당 이름의 사원이 없습니다.");
				} else {
					for (EmpDTO emptemp : list) {
						System.out.printf("%5d %-10s %10s %10s\n", emptemp.getEmpno(), emptemp.getEname(),
								emptemp.getJob(),
								emptemp.getHiredate() != null ? emptemp.getHiredate().toString() : "N/A");
					}

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
