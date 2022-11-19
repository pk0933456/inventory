package tw.tedu.inventory.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import tw.tedu.inventory.service.ex.*;
import tw.tedu.inventory.util.JsonResult;

import javax.servlet.http.HttpSession;

/**
 * 控制器的基礎類
 */
public abstract class BaseController {
	
	public static final Integer SUCCESS = 2000;

	/**
	 * 從session中取得使用者uid
	 * @param session
	 * @return
	 */
	protected final Integer getUidFromSession(HttpSession session){
		return Integer.valueOf(session.getAttribute("uid").toString());
	}

	/**
	 * 從session中取得使用者名稱
	 * @param session
	 * @return
	 */
	protected final String getUserNameFromSession(HttpSession session){
		return String.valueOf(session.getAttribute("username").toString());
	}

	/**
	 * 從session中取得使用者permissions
	 * @param session
	 * @return
	 */
	protected final Integer getpermissionsFromSession(HttpSession session){
		return Integer.valueOf(session.getAttribute("permissions").toString());
	}

	/**
	 * 從session中取得使用者coid
	 * @param session
	 * @return
	 */
	protected final Integer getCoidFromSession(HttpSession session){
		return Integer.valueOf(session.getAttribute("coid").toString());
	}

	/**
	 * 從session中取得使用者coid
	 * @param session
	 * @return
	 */
	protected final Integer getsicidFromSession(HttpSession session){
		return Integer.valueOf(session.getAttribute("sicid").toString());
	}

	/**
	 * 從session中取得使用者coid
	 * @param session
	 * @return
	 */
	protected final Integer getCheckidFromSession(HttpSession session){
		return Integer.valueOf(session.getAttribute("checkid").toString());
	}
	
	@ExceptionHandler(ServiceException.class)
	public JsonResult<Void> handleException(Throwable e) {
		JsonResult<Void> jr = new JsonResult<>();
		jr.setMessage(e.getMessage());
		
		if(e instanceof UsernameDuplicateException){
			jr.setState(4000);
		}else if(e instanceof UserNotFoundException){
			jr.setState(4001);
		}else if(e instanceof PasswordNotMatchException){
			jr.setState(4002);
		}else if(e instanceof InsertException){
			jr.setState(5000);
		}
		return jr;
	}
}
