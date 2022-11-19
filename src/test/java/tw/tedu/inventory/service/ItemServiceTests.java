package tw.tedu.inventory.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tw.tedu.inventory.entity.Item;
import tw.tedu.inventory.entity.ItemColumn;
import tw.tedu.inventory.entity.Logwriter;
import tw.tedu.inventory.entity.StoreItem;
import tw.tedu.inventory.service.ex.InsertException;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTests {

    @Autowired
    IItemService itemService;

    @Test
    public void update(){
        Integer coid = 3;
        itemService.update(coid);
        System.err.println("ok!");
    }


   @Test
    public void getItemByCoid(){
        Integer coid = 1;
        List<Item>  item = itemService.getItemByCoid(coid);
        for(Item list : item ){
            System.err.println(list);
        }
    }

    @Test
    public void getItemColumnByiccoid(){
        Integer coid = 1;
        List<ItemColumn> item = itemService.getItemColumnByiccoid(coid);
        for(ItemColumn list : item ){
            System.err.println(list);
        }
    }

    @Test
    public void getItemColumnByiccoidAndCheckid(){
        Integer iccoid = 3;
        Integer checkid = 4;
        List<ItemColumn> item = itemService.getItemColumnByiccoidAndCheckid(iccoid,checkid);
        for(ItemColumn list : item ){
            System.err.println(list);
        }
    }

    @Test
    public void getStoreItemBysicoid(){
        Integer coid = 1;
        List<StoreItem> item = itemService.getStoreItemBysicoid(coid);
        for(StoreItem list : item ){
            System.err.println(list);
        }
    }

    @Test
    public void addNewItem(){
        Map<String, Object> params = new HashMap<>();
        Integer coid = 1 ;
        params.put("storeurl","testValue");
        params.put("courl","testValue");
        params.put("ins1","testValue");
        params.put("ins2","testValue");
        params.put("ins3","testValue");
        params.put("ins4","testValue");
        params.put("ins5","testValue");
        params.put("ins6","testValue");
        params.put("ins7","testValue");
        params.put("ins8","testValue");
        params.put("ins9","testValue");
        params.put("ins10","testValue");
        itemService.addNewItem(params,coid);
        System.err.println(params);

    }

    @Test
    public void updateItem(){
        Map<String, Object> params = new HashMap<>();
        Integer coid = 1 ;
        Integer checkid = 1;

        params.put("ins2","");
        params.put("ins6","XXXXXXXL");

        itemService.updateItem(params,coid,checkid);

    }




}
