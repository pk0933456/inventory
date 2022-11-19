package tw.tedu.inventory.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tw.tedu.inventory.entity.UserI;
import tw.tedu.inventory.service.ex.ServiceException;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserIServiceTests {

    @Autowired
    IUserService userService;

    @Test
    public void login(){
        try {
            String username = "root";
            String password = "1234";
            UserI user = userService.login(username,password);
            System.err.println(user);
        }catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void a(){
        List<UserI> list = userService.getByisDelete();
        for (UserI user : list){
            System.err.println("Begin!");
            System.err.println(user);
        }
            System.err.println("end!!");
    }

    @Test
    public void delete(){
        try {
            Integer uid = 29 ;
            userService.delete(uid);
            System.err.println("uid = "+uid+" 刪除完成!");
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }


}
