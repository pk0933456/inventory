package tw.tedu.inventory.service;

import org.apache.ibatis.annotations.Param;
import tw.tedu.inventory.entity.UserI;
import tw.tedu.inventory.service.ex.*;

import java.util.Date;
import java.util.List;


/**
 *	處理使用者數據的業務曾接口
 */
public interface IUserService {

	/**
	 * 使用者註冊接口
	 * @param user 使用者資料對象
	 * @throws UsernameDuplicateException
	 * @throws InsertException
	 */
	void reg(UserI user) throws UsernameDuplicateException, InsertException;

	/**
	 * 使用者登錄
	 * @param username	使用者名稱
	 * @param password	密碼
	 * @return	登錄成功的使用者資訊
	 * @throws UserNotFoundException		使用者名稱異常、為註冊、被刪除
	 * @throws PasswordNotMatchException	登錄密碼異常
	 */
	UserI login(String username, String password) throws UserNotFoundException, PasswordNotMatchException;

	/**
	 * 獲得未刪除的所有使用者
	 * @return	所有未刪除的所有使用者
	 */
	List<UserI> getByisDelete();

	/**
	 * 根據使用者uid刪除使用者
	 * @param uid	使用者uid
	 * @throws DeleteException
	 * @throws AccessDeniedException
	 */
	void delete(Integer uid) throws DeleteException,AccessDeniedException;

	/**
	 * 簡易修改使用者資料
	 * @param uid
	 * @param username
	 * @param permissions
	 * @throws UserNotFoundException
	 * @throws UpdateException
	 */
	void changeInfo(
			Integer uid, String username,String permissions)
				throws UserNotFoundException,UpdateException;

	UserI getByUid(Integer uid);

	void updateInfo(UserI user,Integer upuid)throws UpdateException,UserNotFoundException,InsertException;

}
