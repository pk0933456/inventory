package tw.tedu.inventory.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tw.tedu.inventory.entity.UserI;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserIMapperTests {

	@Autowired
	private UserMapper mapper;

	@Test
	public void insert() {
		UserI user = new UserI();
		user.setUsername("測試");
		user.setPassword("1234");
		Integer rows = mapper.insert(user);
		System.err.println("rows=" + rows);
	}
	
	
	@Test
	public void updatePassword() {
	    Integer uid = 1;
	    String password = "888888";
	    String modifiedUser = "超级管理员";
	    Date modifiedTime = new Date();
	    Integer rows = mapper.updatePassword(uid, password, modifiedUser, modifiedTime);
	    System.err.println("rows=" + rows);
	}

	@Test
	public void updateInfo() {
		Integer uid = 3;
		String username = "user03";
		String modifiedUser = "root";
		Integer permissions = 1;
		Date modifiedTime = new Date();
		Integer rows = mapper.updateInfo(uid, username, permissions, modifiedUser, modifiedTime);
		System.err.println("rows=" + rows);
	}

	@Test
	public void updateAvarta() {
		Integer uid = 10;
		String avatar = "newImgUrl";
		String modifiedUser = "systemAdmin";
		Date modifiedTime = new Date();
		Integer rows = mapper.updateAvatar(uid, avatar, modifiedUser, modifiedTime);
		System.err.println("rows=" + rows);
	}

	@Test
	public void updateUserInfo() {
		UserI user = new UserI();
		Date modifiedTime = new Date();
		user.setUid(3);
		user.setModifiedUser("root");
		user.setModifiedTime(modifiedTime);
	    Integer rows = mapper.updateInfo(user);
	    System.err.println("rows=" + rows);
	}

	@Test
	public void findByUid() {
	    Integer uid = 3;
	    UserI user = mapper.findByUid(uid);
	    System.err.println(user);
	}

	
	
	@Test
	public void findByUsername() {
		String username = "root";
		UserI user = mapper.findByUsername(username);
		System.err.println(user);
	}

	@Test
	public void findByisDelete(){
		List<UserI> list = mapper.findByisDelete();
		for(UserI user : list){
			System.err.println("Begin!");
			System.err.println(user);
		}
			System.err.println("end!");
	}

	@Test
	public void deleteByUid(){
		Integer uid =27;
		Integer rows = mapper.deleteByUid(uid);
		System.err.println("rows="+rows);
	}
}
