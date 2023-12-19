package org.jsp.userapp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.userapp.dao.UserDao;
import org.jsp.userapp.dto.User;

public class UserController {
	static Scanner s = new Scanner(System.in);
	static UserDao dao = new UserDao();

	public static void main(String[] args) {

		System.out.println("1.Save User");
		System.out.println("2.Update User");
		System.out.println("3.Find User By Id");
		System.out.println("4.Verify User by Phone and password");
		System.out.println("5.Verify User by Email and password");
		System.out.println("6.Verify User by Id and password");
		System.out.println("7.Find User By Name");
		System.out.println("8.Find User By Age");
		System.out.println("9.Find User By gender");
		System.out.println("10.Delete User");
		System.out.println("11.Find names by age");
		switch (s.nextInt()) {
		case 1: {
			save();
			break;
		}
		case 2: {
			update();
			break;
		}
		case 3: {
			findUserById();
			break;
		}
		case 4: {
			verifyUserByPhone();
			break;
		}
		case 5: {
			verifyUserByEmail();
			break;
		}
		case 6: {
			verifyUserById();
			break;
		}
		case 7: {
			findByName();
			break;
		}
		case 8: {
			findByAge();
			break;
		}
		case 9: {
			findByGender();
			break;
		}
		case 10: {
			delete();
			break;
		}
		case 11: {
			findNameByAge();
			break;
		}
		default: {
			System.err.println("Invalid Choice");
		}
		}
	}

	public static void save() {
		System.out.println("Enter the name,phone,email,age,gender and password to save user");
		User u = new User();
		u.setName(s.next());
		u.setPhone(s.nextLong());
		u.setEmail(s.next());
		u.setAge(s.nextInt());
		u.setGender(s.next());
		u.setPassword(s.next());
		u = dao.saveUser(u);
		System.out.println("user saved with Id:" + u.getId());
	}

	public static void update() {
		System.out.println("Enter the user Id to update");
		int id = s.nextInt();
		System.out.println("Enter the name,phone,email,age,gender and password to update user");
		User u = new User();
		u.setId(id);
		u.setName(s.next());
		u.setPhone(s.nextLong());
		u.setEmail(s.next());
		u.setAge(s.nextInt());
		u.setGender(s.next());
		u.setPassword(s.next());
		u = dao.updateUser(u);
		if (u != null)
			System.out.println("user Updated with Id:" + u.getId());
		else
			System.err.println("Cannot Update User as Entered Id is invalid");
	}

	public static void verifyUserByPhone() {
		System.out.println("Enter the Phone Number and Password to verify");
		long phone = s.nextLong();
		String password = s.next();
		User u = dao.verifyUser(phone, password);
		if (u != null) {
			System.out.println("verification Succesfull");
			System.out.println("User Id:" + u.getId());
			System.out.println("User Name:" + u.getName());
			System.out.println("Phone Number:" + u.getPhone());
			System.out.println("Age:" + u.getAge());
			System.out.println("Email id:" + u.getEmail());
			System.out.println("gender:" + u.getGender());
		} else {
			System.err.println("Invalid Phone Number or Password");
		}
	}

	public static void verifyUserByEmail() {
		System.out.println("Enter the Email Id and Password to verify");
		String email = s.next();
		String password = s.next();
		User u = dao.verifyUser(email, password);
		if (u != null) {
			System.out.println("verification Succesfull");
			System.out.println("User Id:" + u.getId());
			System.out.println("User Name:" + u.getName());
			System.out.println("Phone Number:" + u.getPhone());
			System.out.println("Age:" + u.getAge());
			System.out.println("Email id:" + u.getEmail());
			System.out.println("gender:" + u.getGender());
		} else {
			System.err.println("Invalid email Id or Password");
		}
	}

	public static void verifyUserById() {
		System.out.println("Enter the User Id and Password to verify");
		int id = s.nextInt();
		String password = s.next();
		User u = dao.verifyUser(id, password);
		if (u != null) {
			System.out.println("verification Succesfull");
			System.out.println("User Id:" + u.getId());
			System.out.println("User Name:" + u.getName());
			System.out.println("Phone Number:" + u.getPhone());
			System.out.println("Age:" + u.getAge());
			System.out.println("Email id:" + u.getEmail());
			System.out.println("gender:" + u.getGender());
		} else {
			System.err.println("Invalid User Id or Password");
		}
	}

	public static void findUserById() {
		System.out.println("Enter the User Id to display details");
		int id = s.nextInt();
		User u = dao.findUserById(id);
		if (u != null) {
			System.out.println("verification Succesfull");
			System.out.println("User Id:" + u.getId());
			System.out.println("User Name:" + u.getName());
			System.out.println("Phone Number:" + u.getPhone());
			System.out.println("Age:" + u.getAge());
			System.out.println("Email id:" + u.getEmail());
			System.out.println("gender:" + u.getGender());
		} else {
			System.err.println("Invalid Id");
		}
	}

	public static void findByName() {
		System.out.println("Enter the name to display details");
		String name = s.next();
		List<User> users = dao.findByName(name);
		if (users.size() > 0) {
			for (User u : users) {
				System.out.println("User Id:" + u.getId());
				System.out.println("User Name:" + u.getName());
				System.out.println("Phone Number:" + u.getPhone());
				System.out.println("Age:" + u.getAge());
				System.out.println("Email id:" + u.getEmail());
				System.out.println("gender:" + u.getGender());
				System.out.println("---------------------------");
			}
		} else
			System.err.println("No user with the entered name");
	}

	public static void findByAge() {
		System.out.println("Enter the age to display details");
		int age = s.nextInt();
		List<User> users = dao.findByAge(age);
		if (users.size() > 0) {
			for (User u : users) {
				System.out.println("User Id:" + u.getId());
				System.out.println("User Name:" + u.getName());
				System.out.println("Phone Number:" + u.getPhone());
				System.out.println("Age:" + u.getAge());
				System.out.println("Email id:" + u.getEmail());
				System.out.println("gender:" + u.getGender());
				System.out.println("---------------------------");
			}
		} else
			System.err.println("No user with the entered age");
	}

	public static void findByGender() {
		System.out.println("Enter the gender to display details");
		String gender = s.next();
		List<User> users = dao.findByGender(gender);
		if (users.size() > 0) {
			for (User u : users) {
				System.out.println("User Id:" + u.getId());
				System.out.println("User Name:" + u.getName());
				System.out.println("Phone Number:" + u.getPhone());
				System.out.println("Age:" + u.getAge());
				System.out.println("Email id:" + u.getEmail());
				System.out.println("gender:" + u.getGender());
				System.out.println("---------------------------");
			}
		} else
			System.err.println("No user with the entered gender");
	}

	public static void delete() {
		System.out.println("Enter the user Id to delete");
		int id = s.nextInt();
		boolean deleted = dao.deleteUser(id);
		if (deleted)
			System.out.println("User deleted");
		else
			System.err.println("Cannot delete user as Id is Invalid");
	}

	public static void findNameByAge() {
		System.out.println("Enter the age to display User names");
		int age = s.nextInt();
		List<String> names = dao.findNameByAge(age);
		if (names.size() > 0) {
			for (String name : names)
				System.out.println(name);
		} else
			System.err.println("No user with the age:" + age);
	}
}
