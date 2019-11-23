package test;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import entity.Classes;
import entity.Student;

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
		// ʹ�÷�ʽ1
		String statement = "entity.classMapper.getClass4";
		// ִ�в�ѯ����һ��Ψһuser�����sql
		Classes classes = session.selectOne(statement, 1);
		System.out.println(classes.getName());
		// ��ȡ��ʦ��Ϣ
		System.out.println(classes.getTeacher().getName());
		// ��ȡѧ����Ϣ
		List<Student> students = classes.getStudents();
		for (Student s : students) {
			System.out.println(s.getName());
		}

	}
}
