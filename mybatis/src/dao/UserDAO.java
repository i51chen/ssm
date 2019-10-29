package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import entity.User;
import util.SQLSessionFactoryUtil;

public class UserDAO {
	public User getUserById(int id) {
		SqlSession session = SQLSessionFactoryUtil.getSqlSessionFactory().openSession();
		User user = session.selectOne("entity.userMapper.selectUser", id);
		session.close();
		return user;
	}

	public void addUser(User user) {
		SqlSession session = SQLSessionFactoryUtil.getSqlSessionFactory().openSession();
		session.insert("entity.userMapper.insertUser", user);
		session.commit();
	}

	public void updateUser(User user) {
		SqlSession session = SQLSessionFactoryUtil.getSqlSessionFactory().openSession();
		session.update("entity.userMapper.updateUser", user);
		session.commit();
	}

	public void deleteUser(int id) {
		SqlSession session = SQLSessionFactoryUtil.getSqlSessionFactory().openSession();
		session.update("entity.userMapper.deleteUser", id);
		session.commit();
	}

	public List<User> listAll() {
		SqlSession session = SQLSessionFactoryUtil.getSqlSessionFactory().openSession();
		List<User> all = session.selectList("entity.userMapper.selectAllUsers");
		return all;
	}

	public static void main(String[] args) {
		// 1-查询id=2的记录
//		System.out.println(new UserDAO().getUserById(2).getName());

		// 2-增加记录：name=Mike，age=33的用户
//		User user = new User();
//		user.setName("Mike");
//		user.setAge(33);
//		new UserDAO().addUser(user);

		// 3-更新id=23的用户的name为John-2
//		UserDAO userDao = new UserDAO();
//		User user2 = userDao.getUserById(2);
//		user2.setName("John");
//		userDao.updateUser(user2);

		// 4-删除id=最后的一个用户
//		UserDAO userDao = new UserDAO();
//		User user2 = userDao.getUserById(5);
//		userDao.deleteUser(user2.getId());

		// 5-获取全部记录
		UserDAO userDao = new UserDAO();
		List<User> all = userDao.listAll();
		for (User u : all) {
			System.out.println(u.getName());
		}

	}

}
