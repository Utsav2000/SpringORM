package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentdao = context.getBean("studentDao", StudentDao.class);
//     Student std = new Student(123,"utsav","guj");
//     int r = studentdao.insert(std);
//     System.out.println("done"+r);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;
		while (go) {
			System.out.println("Enter 1 for add new student");
			System.out.println("Enter 2 for display all students");
			System.out.println("Enter 3 for display single student");
			System.out.println("Enter 4 for delete student");
			System.out.println("Enter 5 for update student");
			System.out.println("Enter 6 for Exit");

			try {
				int input = Integer.parseInt(br.readLine());
				switch (input) {
				case 1:
					System.out.println("enter student id:");
					int id = Integer.parseInt(br.readLine());
					System.out.println("enter student name:");
					String name = br.readLine();
					System.out.println("enter student city:");
					String city = br.readLine();
					Student std = new Student(id, name, city);
					int insert = studentdao.insert(std);
					System.out.println("student " + insert + " is inserted");
					System.out.println("**********************************");
					System.out.println();
					break;
				case 2:
					List<Student> getallstudent = studentdao.getallstudent();
					for (Student st : getallstudent) {
						System.out.println("Id:" + st.getId());
						System.out.println("Name:" + st.getStudent_name());
						System.out.println("City:" + st.getStudent_city());
						System.out.println("-----------------------------");

					}
					System.out.println("**********************************");
					break;
				case 3:
					System.out.println("enter student id:");
					int std_id = Integer.parseInt(br.readLine());
					Student getsinglestudent = studentdao.getsinglestudent(std_id);
					System.out.println();
					System.out.println("-------------------------------------------");
					System.out.println("Name:" + getsinglestudent.getStudent_name());
					System.out.println("City:" + getsinglestudent.getStudent_city());
					System.out.println("-------------------------------------------");
					System.out.println();
					break;
				case 4:
					System.out.println("enter student id for delete");
					int delete_id = Integer.parseInt(br.readLine());
					studentdao.delete(delete_id);
					System.out.println("______________________________");
					System.out.println("Deleted!!!!!!!!!!!!");
					System.out.println("______________________________");
					break;
				case 5:
					System.out.println("enter student id:");
					int update_id = Integer.parseInt(br.readLine());
					System.out.println("enter student name:");
					String update_name = br.readLine();
					System.out.println("enter student city:");
					String update_city = br.readLine();
					Student update_std = new Student(update_id, update_name, update_city);
					studentdao.update(update_std);
					System.out.println();
					System.out.println("updated!!!!!!!!!!!!!!!!");
					System.out.println();
					break;
				case 6:

					go = false;
					break;
				}
			} catch (Exception e) {
				System.out.println("Pls.. select  correct option");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("thanks for using my application");
		System.out.println("See you soon");

	}
}
