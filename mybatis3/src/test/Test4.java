package test;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import entity.Classes;

public class Test4 {
	public static void main(String[] args) throws IOException {
		String resource = "conf.xml";
		// ����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
		Reader reader = Resources.getResourceAsReader(resource);
		// ����sqlSession�Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// ������ִ��ӳ���ļ���sql��sqlSession
		SqlSession session = sessionFactory.openSession();
		// ӳ��sql�ı�ʶ�ַ���
		
		// ʹ�÷�ʽ2
		String statement = "entity.classMapper.getClass2";
		// ִ�в�ѯ����һ��Ψһuser�����sql
		Classes classes = session.selectOne(statement, 1);
		System.out.println(classes.getName());
		System.out.println(classes.getTeacher().getName());
	}
}
