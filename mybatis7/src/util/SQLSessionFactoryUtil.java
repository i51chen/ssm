package util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SQLSessionFactoryUtil {
	// ���ȴ�����̬��Ա����sqlSessionFactory����̬���������еĶ���������
	public static SqlSessionFactory sqlSessionFactory = null;

	public static SqlSessionFactory getSqlSessionFactory() {
		// ���sqlSessionFactoryû�б������Ͷ�ȡȫ�������ļ��������Ѿ����������ˣ���ʹ���Ѿ����ڵ�sqlsessionfactory��
		// ���������˵���ģʽ��Ч��
		if (sqlSessionFactory == null) {
			String resource = "conf.xml";
			try {
				Reader reader = Resources.getResourceAsReader(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;
	}
}
