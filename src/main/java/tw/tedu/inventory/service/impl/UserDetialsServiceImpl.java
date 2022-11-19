package tw.tedu.inventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tw.tedu.inventory.entity.UserI;
import tw.tedu.inventory.mapper.UserMapper;
import tw.tedu.inventory.service.ex.PasswordNotMatchException;
import tw.tedu.inventory.service.ex.UserNotFoundException;

@Service
public class UserDetialsServiceImpl implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException,PasswordNotMatchException {
		UserI result = userMapper.findByUsername(username);
		String password = result.getPassword();
//		if(username == ""){
//			throw new UserNotFoundException("登錄失敗，未填入使用者!");
//		}
//		if(password == ""){
//			throw new PasswordNotMatchException("登錄失敗，未填入密碼!");
//		}
//		// 拋出:UserNotFoundException
//		if(result == null) {
//			throw new UserNotFoundException("登錄失敗，使用者不存在");
//		}
//		// 判斷查詢結果中的isDelete為1 // 拋出:UserNotFoundException
//		if(result.getIsDelete() == 1){
//			throw new UserNotFoundException("登錄失敗，使用者不存在");
//		}
//		PasswordEncoder pe = new BCryptPasswordEncoder();
//		boolean matches = pe.matches(password,result.getPassword());
//		if(matches == false){
//			// 拋出:PasswordNotMatchException
//			throw new PasswordNotMatchException("登錄失敗，密碼錯誤");
//		}
		// 將查詢結果中的password、salt、isDelete設置為null
		result.setPassword(null);
		result.setSalt(null);
		result.setIsDelete(null);
		String authority = String.valueOf(result.getPermissions());
		return new User(username,
				password,
				AuthorityUtils.commaSeparatedStringToAuthorityList(authority));
	}

}
