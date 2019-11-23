package test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test5 {
	public static void main(String[] args) throws IOException {
		String resource = "conf.xml";
		// ����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
		Reader reader = Resources.getResourceAsReader(resource);
		// ����sqlSession�Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// ������ִ��ӳ���ļ���sql��sqlSession
		SqlSession session = sessionFactory.openSession();

		// ӳ��sql�ı�ʶ�ַ���
		String statement = "entity.classMapper.getCount";

		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("sex_id", 1);

		session.selectOne(statement, paramMap);

		Integer userCount = paramMap.get("user_count");
		System.out.println(userCount);

	}
}
