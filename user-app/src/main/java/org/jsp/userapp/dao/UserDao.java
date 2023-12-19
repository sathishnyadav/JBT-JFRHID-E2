package org.jsp.userapp.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.userapp.dto.User;

@SuppressWarnings("all")
public class UserDao {
	Session s = new Configuration().configure().buildSessionFactory().openSession();

	public User saveUser(User user) {
		Transaction t = s.beginTransaction();
		s.save(user);
		t.commit();
		return user;
	}

	public User updateUser(User user) {
		User dbUser = s.get(User.class, user.getId());
		if (dbUser != null) {
			dbUser.setName(user.getName());
			dbUser.setEmail(user.getEmail());
			dbUser.setGender(user.getGender());
			dbUser.setAge(user.getAge());
			dbUser.setPhone(user.getPhone());
			dbUser.setPassword(user.getPassword());
			Transaction t = s.beginTransaction();
			t.commit();
			return dbUser;
		}
		return null;
	}

	public User findUserById(int id) {
		return s.get(User.class, id);
	}

	public User verifyUser(long phone, String password) {
		Query<User> q = s.createQuery("select u from User u where u.phone=?1 and u.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User verifyUser(String email, String password) {
		Query<User> q = s.createQuery("select u from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User verifyUser(int id, String password) {
		Query<User> q = s.createQuery("select u from User u where u.id=?1 and u.password=?2");
		q.setParameter(1, id);
		q.setParameter(2, password);
		try {
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<User> findByName(String name) {
		Query<User> q = s.createQuery("select u from User u where u.name=?1");
		q.setParameter(1, name);
		return q.getResultList();
	}

	public List<User> findByAge(int age) {
		Query<User> q = s.createQuery("select u from User u where u.age=?1");
		q.setParameter(1, age);
		return q.getResultList();
	}

	public List<User> findByGender(String gender) {
		Query<User> q = s.createQuery("select u from User u where u.gender=?1");
		q.setParameter(1, gender);
		return q.getResultList();
	}

	public boolean deleteUser(int id) {
		User user = findUserById(id);
		if (user != null) {
			s.delete(user);
			Transaction t = s.beginTransaction();
			t.commit();
			return true;
		}
		return false;
	}

	public List<String> findNameByAge(int age) {
		Query<String> q = s.createQuery("select u.name from User u where u.age=?1");
		q.setParameter(1, age);
		return q.getResultList();
	}
}
