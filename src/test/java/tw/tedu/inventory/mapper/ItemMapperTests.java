package tw.tedu.inventory.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tw.tedu.inventory.entity.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemMapperTests {

    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void insert(){
        Item item = new Item();
        item.setIid(7);
        item.setCid(1);
        item.setContent("3");
        Integer rows = itemMapper.insert(item);
        System.err.println("rows = "+rows);
    }

    @Test
    public void insertIC(){
        ItemColumn ic = new ItemColumn();
        ic.setCheckid(1);
        ic.setStoreurl("http://localhost:8080");
        ic.setCourl("http://localhost:8080");
        ic.setIcstate(1);
        ic.setIccoid(2);
        Integer rows = itemMapper.insertIC(ic);
        System.err.println("rows = "+rows);
    }

    @Test
    public void insertSITest(){
        StoreItem si = new StoreItem();
        si.setSicid(1);
        si.setSicontent("XL");
        si.setSicoid(3);
        Integer rows = itemMapper.insertSI(si);
        System.err.println("rows = "+rows);
    }



    @Test
    public void insertItem(){
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream("testcsv.csv"), "UTF-8");
            BufferedReader reader = new BufferedReader(isr);
            reader.readLine();  //第一行標題資訊
            String line;
            Item item = new Item();
            ArrayList<String> values = new ArrayList();
            while((line=reader.readLine())!=null){
                String[] itemL = line.split(",");   //CSV格式檔案為逗號分隔符檔案，根據逗號切分
                String last = itemL[itemL.length-1];    //取得資料
                values.add(last);
            }
            Integer index = 1;
            for (int i = 0; i <values.size(); i++) {
                String word = values.get(i);
                if(word.equals("next")){
                    index++;
                    continue;
                }
                item.setIid(i+1);
                item.setCoid(2);
                item.setCid(index);
                item.setContent(word);
                itemMapper.insert(item);
                System.out.println("寫入 : "+word);
            }
                //int value = Integer.parseInt(last);   //如果是數值，可以轉化為數值
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test
    public void findByConame(){
        String coname = "StudioWuda";
        Company co = itemMapper.findCoByConame(coname);
        System.err.println(co);
    }

    @Test
    public void findcoByCoid(){
        Integer coid = (2);
        Company co = itemMapper.findCoByCoid(coid);
        System.err.println(co);
    }

    @Test
    public void finditemByCoid(){
        Integer coid = (1);
        List<Item> value = itemMapper.findItemByCoid(coid);
        for(Item item : value){
            System.err.println(item);
        }
    }

    @Test
    public void findItemColumnByCoid(){
        Integer iccoid = (1);
        List<ItemColumn> value = itemMapper.findItemColumnByiccoid(iccoid);
        for(ItemColumn item : value){
            System.err.println(item);
        }
    }

    @Test
    public void findItemColumnByCoidAndCheckid(){
        Integer iccoid = 3;
        Integer checkid = 10;
        List<ItemColumn> value = itemMapper.findItemColumnByiccoidAndCheckid(iccoid,checkid);
        for(ItemColumn item : value){
            System.err.println(item);
        }
    }

    @Test
    public void findStoreItemBysicoid(){
        Integer sicoid = (1);
        List<StoreItem> value = itemMapper.findStoreItemBysicoid(sicoid);
        for(StoreItem item : value){
            System.err.println(item);
        }
        Integer lastIdx = value.size() - 1;
        StoreItem lastElement = value.get(lastIdx);

        System.err.println(lastElement.getSicid());
    }

    @Test
    public void findStoreItemBysicoidANDCI(){
        Integer sicoid = 1;
        Integer sicid = 1;
        List<StoreItem> value = itemMapper.findStoreItemBysicoidandCI(sicid,sicoid);
        for(StoreItem item : value){
            System.err.println(item);
        }
    }

    @Test
    public void findWebLog(){
        List<Logwriter> value = itemMapper.findWebLog();
        for( Logwriter item : value){
            System.err.println(item);
        }
    }



    @Test
    public void deleteSItemTable(){
        Integer coid = 3;
        itemMapper.deleteSItemTable(coid);
        System.err.println("ok!");
    }

    @Test
    public void deleteIC(){
        Integer rows = itemMapper.delICByCheckId(9,3);
        System.err.println("rows = " + rows);
    }

    @Test
    public void deleteSI(){
        Integer rows = itemMapper.delSIBySicid(9,3);
        System.err.println("rows = " + rows);
    }

    @Test
    public void deleteI(){
        Integer rows = itemMapper.delIByCid(10,1);
        System.err.println("rows = " + rows);
    }

    @Test
    public void updateItemColumn(){
        Integer checkid = 10;
        Integer iccoid = 3;
        String storeurl = "www.testvalue2.com";
        String courl = "www.testvalue2.com";
        Integer rows = itemMapper.updateItemColumn(checkid,iccoid,storeurl,courl);
        System.err.println("rows = "+rows);

    }

    @Test
    public void updateSI(){
        Integer siid = 271;
        Integer sicid = 17;
        Integer sicoid = 3;
        String  sicontent = "testValue";
        Integer rows = itemMapper.updateStoreItem(siid,sicid,sicoid,sicontent);
        System.err.println("rows ="+rows);
    }

    @Test
    public void information() {
        Integer coid = (1);
        List<Item> value = itemMapper.findItemByCoid(coid);
        Integer index = 1;
        Integer dcoid = 0;
        String dname = "";
        String color = "";
        String size = "";
        Integer dum = 0;
        for(int i = 0; i < value.size(); i++){
            if(value.get(i).getCid() != index){
                index++;
            }
            String str = value.get(i).getContent();
            if(str.matches("")){

            }
            str.matches("");
        }


//        for(Item item : value){
//            System.err.println(item);
//        }

    }

}


