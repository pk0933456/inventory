package tw.tedu.inventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.tedu.inventory.entity.*;
import tw.tedu.inventory.mapper.ItemMapper;
import tw.tedu.inventory.service.IItemService;
import tw.tedu.inventory.service.ex.InsertException;
import tw.tedu.inventory.service.ex.UpdateException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ItemImpl implements IItemService {

    @Autowired
    private ItemMapper itemMapper;

    /**
     * 新增網頁比對欄位 分別寫入左側選項欄位 以及商店庫存 並放入最末端
     * @param params
     * @param coid
     */
    @Override
    @Transactional
    public void addNewItem(Map<String, Object> params, Integer coid) {
        //查詢StoreItem對應coid最後一筆資料
        List<ItemColumn> value2 = itemMapper.findItemColumnByiccoid(coid);
        Integer lastIdx2 = value2.size() - 1;
        ItemColumn lastElement2 = value2.get(lastIdx2);
        //對應coid查詢到的ItemColumn最後一筆資料的checkidid並+1準備給新增的checkid
        Integer index2 = (lastElement2.getCheckid()) + 1;
        //寫入新資料
        ItemColumn ic = new ItemColumn();
        String surl = (String) params.get("storeurl");
        ic.setStoreurl(surl);
        ic.setCourl((String) params.get("courl"));
        ic.setCheckid(index2);
        ic.setIccoid(coid);
        ic.setIcstate(1);
        ic.setIcid(null);
        Integer rows1 = itemMapper.insertIC(ic);
        if (rows1 != 1) {
            throw new InsertException("新增商品出現未知異常");
        }
        List<StoreItem> value = itemMapper.findStoreItemBysicoid(coid);
        Integer lastIdx = value.size() - 1;
        StoreItem lastElement = value.get(lastIdx);
        //對應coid查詢到的StoreItem最後一筆資料的sicid並+1準備給新增的sicid
        Integer index = (lastElement.getSicid()) + 1;
        //寫入新資料
        StoreItem si = new StoreItem();
        for (int i = 1; i < 11; i++) {
            String content = (String) params.get("ins" + i);
            si.setSicontent(content);
            si.setSicid(index);
            si.setSicoid(coid);
            si.setSiid(null);
            Integer rows = itemMapper.insertSI(si);
            if (rows != 1) {
                throw new InsertException("新增商品出現未知異常");
            }
        }
    }

    @Override
    @Transactional
    public void updateItem(Map<String, Object> params, Integer coid, Integer checkid) {
        //處理比對選項欄位
        List<ItemColumn> ic = itemMapper.findItemColumnByiccoidAndCheckid(coid,checkid);
        String  surl = (String) params.get("storeurl");
        String  courl = (String) params.get("courl");
            if(surl ==""||surl==null){
                surl = ic.get(0).getStoreurl();
            }
            if(courl==""||courl==null){
                courl = ic.get(0).getCourl();
            }
        Integer rows1 = itemMapper.updateItemColumn(checkid,coid,surl,courl);
            if(rows1!=1) {
                throw new InsertException("更新商品出現未知異常");
            }
        //處理商店庫存欄位
        List<StoreItem> si = itemMapper.findStoreItemBysicoidandCI(checkid, coid);
        params.remove("storeurl");
        params.remove("courl");
        Integer lastIdx = si.size() - 1;
        for (int i = 0; i < lastIdx; i++) {
            String index = (String) params.putIfAbsent("ins" + i, si.get(i).getSicontent());
            Integer siid = (si.get(i).getSiid());
            Integer sicid = si.get(i).getSicid();
            Integer sicoid = si.get(i).getSicoid();
            if (index == null || index == "") {
                String sicontent = si.get(i).getSicontent();
                index = sicontent;
                Integer rows = itemMapper.updateStoreItem(siid, sicid, sicoid, sicontent);
                if (rows != 1) {
                    throw new InsertException("更新商品出現未知異常");
                }
            }
            Integer rows = itemMapper.updateStoreItem(siid, sicid, sicoid, index);
            if (rows != 1) {
                throw new InsertException("更新商品出現未知異常");
            }
        }
    }

    /**
     * 將對應的coid的廠商資料更新成最新的比對資料
     * @param coid
     */
    @Override
    @Transactional
    public void update(Integer coid) {
            String coName = itemMapper.findCoByCoid(coid).getConame();
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(coName+".csv"), "UTF-8");
            BufferedReader reader = new BufferedReader(isr);
            if(reader==null) {
                throw new UpdateException("更新錯誤!");
            }

            //清除資料庫中對應的廠商資料
            itemMapper.deleteSItemTable(coid);
            reader.readLine();  //第一行標題資訊
            String line;
            Item item = new Item();
            ArrayList<String> values = new ArrayList();
            while((line=reader.readLine())!=null){
                String[] itemL = line.split(",");   //根據逗號切分
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
                item.setCoid(coid);
                item.setCid(index);
                item.setContent(word);
                itemMapper.insert(item);
            }
            //int value = Integer.parseInt(last);   //轉化為數值(預備用)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Company getCoNameByCoid(Integer coid) {
       Company list = itemMapper.findCoByCoid(coid);
        return list;
    }

    @Override
    public List<Item> getItemByCoid(Integer coid) {
        List<Item> list = new ArrayList<Item>();
        list = itemMapper.findItemByCoid(coid);
        return list;
    }

    @Override
    public List<ItemColumn> getItemColumnByiccoid(Integer iccoid) {
        List<ItemColumn> list = new ArrayList<ItemColumn>();
        list = itemMapper.findItemColumnByiccoid(iccoid);
        return list;
    }

    @Override
    public List<ItemColumn> getItemColumnByiccoidAndCheckid(Integer iccoid, Integer checkid) {
        List<ItemColumn> list = new ArrayList<ItemColumn>();
        list = itemMapper.findItemColumnByiccoidAndCheckid(iccoid,checkid);
        return list;
    }

    @Override
    public List<StoreItem> getStoreItemBysicoid(Integer sicoid) {
        List<StoreItem> list = new ArrayList<StoreItem>();
        list = itemMapper.findStoreItemBysicoid(sicoid);
        return list;
    }

    @Override
    public List<StoreItem> getStoreItemBysicoidandCI(Integer sicid, Integer sicoid) {
        List<StoreItem> list = new ArrayList<StoreItem>();
        list = itemMapper.findStoreItemBysicoidandCI(sicid,sicoid);
        return list;
    }

    @Override
    public Integer deleteSItemTable(Integer coid) {
        Integer rows = itemMapper.deleteSItemTable(coid);
        return rows;
    }

    @Override
    public void deleteWebcolumn(Integer cid, Integer coid, Integer sicid, Integer sicoid, Integer checkid, Integer iccoid) {
        deleteColumn(cid, coid, sicid, sicoid,checkid,iccoid);
    }

    private void deleteColumn(Integer cid, Integer coid, Integer sicid, Integer sicoid, Integer checkid, Integer iccoid){
        itemMapper.delIByCid(cid, coid);
        itemMapper.delSIBySicid(sicid, sicoid);
        itemMapper.delICByCheckId(checkid, iccoid);

    }

}
