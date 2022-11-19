package tw.tedu.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import tw.tedu.inventory.entity.ItemColumn;
import tw.tedu.inventory.entity.UserI;
import tw.tedu.inventory.service.IUserService;
import tw.tedu.inventory.util.JsonResult;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 處理使用者資料相關的控制器類
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController{
	
	@Autowired
	private IUserService userService;

	/**
	 * 執行註冊
	 * @param user
	 * @return
	 */
	@RequestMapping("reg")
	public JsonResult<Void> reg(UserI user){
		//執行註冊
		userService.reg(user);
		//響應操作成功
		return new JsonResult<Void>(SUCCESS);
	}

	/**
	 * 執行登錄
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("login")
	public JsonResult<UserI> login(String username, String password, HttpSession session){
		//執行登錄，並獲得返回結果
		UserI user = userService.login(username,password);
		//向Seccion封裝資訊
		session.setAttribute("uid",user.getUid());
		session.setAttribute("username",user.getUsername());
		session.setAttribute("permissions",user.getPermissions());
		//向客戶端響應成功
		return new JsonResult<>(SUCCESS,user);
	}

	/**
	 * 取得未刪除的使者用
	 * @return
	 */
	@GetMapping("get_info")
	public JsonResult<List<UserI>> getByIsDeleted(){
		List<UserI> data = userService.getByisDelete();
		return new JsonResult<>(SUCCESS,data);
	}

	/**
	 * 準備執行修改使用者資訊，對session寫入修改使用者對應的id
	 * @param uid
	 * @param session
	 * @return
	 */
	@RequestMapping("{uid}/updateU")
	public JsonResult<Void> updateSI(@PathVariable("uid") Integer uid, HttpSession session) {
		session.setAttribute("upuid",uid);
		return new JsonResult<>(SUCCESS);
	}

	@RequestMapping(value = "/upuser", method = {RequestMethod.POST})
	public JsonResult<Void> upuser(UserI user,HttpSession session){
		Integer upuid = (Integer) session.getAttribute("upuid");
		userService.updateInfo(user,upuid);
		return new JsonResult<Void>(SUCCESS);
	}

	/**
	 * 顯示選擇更新網址欄位的資訊
	 * @param session
	 * @return
	 */
	@GetMapping("showUpdateUser")
	public JsonResult<UserI> showUpdateUser(HttpSession session) {
		Integer upuid = (Integer) session.getAttribute("upuid");
		UserI user = userService.getByUid(upuid);
//		List<ItemColumn> ItemColumn = itemService.getItemColumnByiccoidAndCheckid(coid,checkid);
//		return new JsonResult<>(SUCCESS, UserI);
		return new JsonResult<>(SUCCESS, user);

	}

	/**
	 * 執行刪除使用者
	 * @param uid
	 * @param session
	 * @return
	 */
	@RequestMapping("{uid}/delete")
	public JsonResult<Void> delete(@PathVariable("uid") Integer uid,HttpSession session){
		String sessionName = getUserNameFromSession(session);
		userService.delete(uid);
		System.err.println("Controller > delete() > "+"uid : "+uid+" , by : "+sessionName);
		return new JsonResult<>(SUCCESS);
	}

	/**
	 *
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("userLogin")
	public JsonResult<UserI> userlogin(String username, String password, HttpSession session){
		//執行登錄，並獲得返回結果
		String sessionusername = SecurityContextHolder.getContext().getAuthentication().getName();
		session.setAttribute("username",sessionusername);
		UserI user = new UserI();
		user.setUsername(sessionusername);
		return new JsonResult<>(SUCCESS,user);
	}

	/**
	 * 設置登錄後的使用者權限
	 * @param session
	 * @return
	 */
	@RequestMapping("userpermissions")
	public JsonResult<UserI> useruserPermissions(HttpSession session){
		Integer sessionPermissions = getpermissionsFromSession(session);
		UserI user = new UserI();
		user.setPermissions(sessionPermissions);
		return new JsonResult<>(SUCCESS,user);
	}


}
