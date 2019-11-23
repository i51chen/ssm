package test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import entity.ConditionUser;
import entity.User;

public class UserTest {
	public static void main(String[] args) throws IOException {
		String resource = "conf.xml";
		// 加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		// 构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();

		// 映射sql的标识字符串
		String statement = "entity.classMapper.getUser";

		List<User> users = session.selectList(statement, new ConditionUser("%ac%", 11, 13));

		for (User u : users) {
			System.out.println(u.getName());
		}

	}
}
