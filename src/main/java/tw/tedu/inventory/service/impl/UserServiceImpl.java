package tw.tedu.inventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tw.tedu.inventory.entity.UserI;
import tw.tedu.inventory.mapper.UserMapper;
import tw.tedu.inventory.service.IUserService;
import tw.tedu.inventory.service.ex.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void reg(UserI user) throws UsernameDuplicateException, InsertException {
		// 根據參數user對像中的username屬性查詢數據:userMapper.findByUsername()
		String username = user.getUsername();
		UserI result = userMapper.findByUsername(username);
		// 判斷查詢結果是否不為null(查詢結果是存在的)
		if(result!=null) {
			// 是:使用者名稱已被佔用，拋出UsernameDuplicateException
			throw new UsernameDuplicateException("註冊失敗("+username+")使用者名稱已存在!");
		}
		// 得到鹽值
		System.err.println("使用者 :"+username+" 註冊成功！");
		System.err.println("reg() > password = "+user.getPassword());
//		String salt = UUID.randomUUID().toString();
		PasswordEncoder pe = new BCryptPasswordEncoder();
		String ecode = pe.encode(user.getPassword());
//		// 基於參數user對像中的password進行加密，得到加密後的密碼
//		String MD5Password = getMD5Password(user.getPassword(), salt);
//		// 將加密後的密碼和鹽值封裝到user中
//		user.setSalt(salt);
		user.setPassword(ecode);
		System.err.println("reg() > BCryptPasswordEncoder = "+ecode);
		// 注入權限值 預設值為0
		user.setPermissions(0);
		// 將user中的isDelete設置為0
		user.setIsDelete(0);
		// 封裝user中的4個日誌屬性
		Date now = new Date();
		user.setCreatedUser(username);
		user.setCreatedTime(now);
		user.setModifiedUser(username);
		user.setModifiedTime(now);
		// 執行註冊:userMapper.insert(user)
		Integer rows = userMapper.insert(user);
		if(rows!=1) {
			throw new InsertException("寫入使用者出現未知異常");
		}
	}

	@Override
	public UserI login(String username, String password) throws UserNotFoundException, PasswordNotMatchException {
		// 根據參數username執行查詢用戶數據
		UserI result = userMapper.findByUsername(username);
		// 判斷查詢結果是否為null
		if(username == ""){
			throw new UserNotFoundException("登錄失敗，未填入使用者!");
		}
		if(password == ""){
			throw new PasswordNotMatchException("登錄失敗，未填入密碼!");
		}
		// 拋出:UserNotFoundException
		if(result == null) {
			throw new UserNotFoundException("登錄失敗，使用者不存在");
		}
		// 判斷查詢結果中的isDelete為1 // 拋出:UserNotFoundException
		if(result.getIsDelete() == 1){
			throw new UserNotFoundException("登錄失敗，使用者不存在");
		}
		PasswordEncoder pe = new BCryptPasswordEncoder();
		boolean matches = pe.matches(password,result.getPassword());
		if(matches == false){
			// 拋出:PasswordNotMatchException
			throw new PasswordNotMatchException("登錄失敗，密碼錯誤");
		}
		// 將查詢結果中的password、salt、isDelete設置為null
		result.setPassword(null);
		result.setSalt(null);
		result.setIsDelete(null);
		// 返回查詢結果
		return result;
	}

	@Override
	public List<UserI> getByisDelete() {
		return findByisDelete();
	}

	@Override
	public void delete(Integer uid) throws DeleteException, AccessDeniedException {
		UserI result = userMapper.findByUid(uid);
		if(result == null) {
			throw new UserNotFoundException("失敗，使用者不存在");
		}
		//刪除
		deleteUserByUid(uid);
	}

	@Override
	public void changeInfo(Integer uid, String username, String permissions) throws UserNotFoundException, UpdateException {
//		// 根據uid查詢使用者
//		UserI result = userMapper.findByUid(uid);
//		// 判断判斷查詢是否為null
//		if (result == null) {
//			// 抛出：UserNotFoundException
//			throw new UserNotFoundException(
//					"修改失敗！用戶不存在！");
//		}
//		// 判斷查詢isDelete是否為1
//		if (result.getIsDelete() == 1) {
//			// 抛出：UserNotFoundException
//			throw new UserNotFoundException(
//					"修改失敗！用戶不存在！");
//		}
//		if(username.equals("root")){
//			throw new UserNotFoundException("錯誤！此名稱無法使用");
//		}
//		String modifiedUser = "admin";
//		Date modifiedTime = new Date();
//		Integer rows = userMapper.updateInfo(uid,username,permissions,modifiedUser,modifiedTime);
//		if (rows != 1) {
//			// 抛出：UpdateException
//			throw new UpdateException(
//					"修改失敗！更新時出現未知錯誤！");
//		}
	}

	@Override
	public UserI getByUid(Integer uid) {
		UserI user = userMapper.findByUid(uid);
		return user;
	}

	@Override
	public void updateInfo(UserI user,Integer upuid) throws UpdateException,UserNotFoundException,InsertException {
		Integer uid = upuid;
		UserI result = userMapper.findByUid(uid);
		// 判断判斷查詢是否為null
		if (result == null) {
			// 抛出：UserNotFoundException
			throw new UserNotFoundException("修改失敗！用戶不存在！");
		}
		String username = user.getUsername();
		if(username.equals("")){
			throw new UpdateException("名稱錯誤！");
		}
		if(username == "root"){
			throw new UpdateException("名稱錯誤！");
		}
		if(username.equals("root")){
			throw new UserNotFoundException("錯誤！此名稱無法使用");
		}
		Integer permissions = user.getPermissions();
		String modifiedUser = "admin";
		Date modifiedTime = new Date();
		Integer rows = userMapper.updateInfo(uid,username,permissions,modifiedUser,modifiedTime);
		if(rows!=1) {
			throw new InsertException("寫入使用者出現未知異常");
		}
	}

	private List<UserI> findByisDelete(){
		return userMapper.findByisDelete();
	}

	private void deleteUserByUid(Integer uid) throws DeleteException {
		Integer rows = userMapper.deleteByUid(uid);
		if(rows != 1){
			throw new DeleteException("刪除失敗，刪除出現未知錯誤");
		}
	}

	/**
	 * 對密碼進行加密
	 * @param password 原始密碼
	 * @param salt	   鹽值
	 * @return		   加密後的密碼
	 */
	private String getMD5Password(String password,String salt) {
		String str = password+salt;
		for(int i=0;i<3;i++) {
			str = DigestUtils.md5DigestAsHex(str.getBytes());
		}
		return str;
	}

}
