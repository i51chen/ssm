package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import entity.User;

public interface UserMapper {
	@Insert("insert into users(name, age) values(#{name}, #{age})")
	public int insertUser(User user);

	@Delete("delete from users where id=#{id}")
	public int deleteUserById(int id);

	@Update("update users set name=#{name},age=#{age} where id=#{id}")
	public int updateUser(User user);

	@Select("select * from users where id=#{id}")
	public User getUserById(int id);

	@Select("select * from users")
	public List<User> getAllUser();
}
