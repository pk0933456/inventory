package tw.tedu.inventory.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import tw.tedu.inventory.entity.UserI;

public interface UserMapper {

	/**
	 * 插入用戶數據
	 * 
	 * @param user
	 * @return
	 */
	Integer insert(UserI user);

	/**
	 * 根據uid刪除使用者
	 * @param uid 使用者uid
	 * @return	  影響行數
	 */
	Integer deleteByUid(Integer uid);

	/**
	 * 根據用戶名稱查詢資料
	 * 
	 * @param username
	 * @return
	 */
	UserI findByUsername(String username);

	/**
	 * 根據用戶ID找尋用戶
	 * 
	 * @param uid
	 * @return
	 */
	UserI findByUid(Integer uid);

	/**
	 * 查詢未刪除的所有使用者
	 * @return	所有未刪除的使用者
	 */
	List<UserI> findByisDelete();

	/**
	 * 修改用戶個人訊息
	 * @param user
	 * @return 受影響行數
	 */
	Integer updateInfo(UserI user);

	/**
	 * 更新使用者頭像
	 * @param uid 使用者的id
	 * @param avatar 頭像的路徑
	 * @param modifiedUser 修改執行人
	 * @param modifiedTime 修改時間
	 * @return 影響行數
	 */
	Integer updateAvatar(
			@Param("uid") Integer uid,
			@Param("avatar") String avatar,
			@Param("modifiedUser") String modifiedUser,
			@Param("modifiedTime") Date modifiedTime);
	
	/**
	 * 更新密碼
	 * 
	 * @param uid
	 * @param password
	 * @param modifiedUser
	 * @param modifiedTime
	 * @return
	 */
	Integer updatePassword(
			@Param("uid") Integer uid, 
			@Param("password") String password,
			@Param("modifiedUser") String modifiedUser, 
			@Param("modifiedTime") Date modifiedTime);


	Integer updateInfo(
			@Param("uid") Integer uid,
			@Param("username") String username,
			@Param("permissions") Integer permissions,
			@Param("modifiedUser") String modifiedUser,
			@Param("modifiedTime") Date modifiedTime);
}
