package tw.tedu.inventory.service;

import org.apache.ibatis.annotations.Param;
import tw.tedu.inventory.entity.*;

import java.util.List;
import java.util.Map;

public interface IItemService {

    /**
     * 更新比對資料庫檔案
     * @param coid
     */
    void update(Integer coid);

    /**
     * 透過coid找尋公司名稱
     *
     * @param coid
     * @return
     */
    Company getCoNameByCoid(Integer coid);

    /**
     * 透過coid找尋比對內容
     *
     * @param coid
     * @return
     */
    List<Item> getItemByCoid(Integer coid);

    /**
     * 根據iccoid查詢選項欄位資料
     * @param iccoid
     * @return
     */
    List<ItemColumn> getItemColumnByiccoid(Integer iccoid);

    /**
     * 根據iccoid查詢商店庫存資料
     * @param sicoid
     * @return
     */
    List<StoreItem> getStoreItemBysicoid(Integer sicoid);

    /**
     * 根據iccoid及checkid查詢選項欄位資料
     * @param iccoid
     * @return
     */
    List<ItemColumn> getItemColumnByiccoidAndCheckid(Integer iccoid,Integer checkid);

    /**
     * 根據sicoid及checkid查詢商店庫存資料
     * @param sicoid
     * @return
     */
    List<StoreItem> getStoreItemBysicoidandCI(@Param("sicid")Integer sicid,
                                               @Param("sicoid")Integer sicoid);


    /**
     * 以coid清空對應的s_item表格
     * @return
     */
    Integer deleteSItemTable(Integer coid);

    /**
     * 刪除指定的比對頁面橫向欄位
     * @param coid  新資料比對廠商id
     * @param cid   新資料比對欄位id
     * @param sicoid    庫存欄位廠商id
     * @param sicid     庫存欄位id
     * @param iccoid    選項欄位廠商id
     * @param checkid   選項欄位id
     */
    void deleteWebcolumn(Integer coid, Integer cid,
                         Integer sicoid, Integer sicid,
                         Integer iccoid, Integer checkid);

    /**
     * 新增商品
     * @param params
     * @param coid
     */
    void addNewItem(Map<String, Object> params, Integer coid);

    /**
     * 修改商品
     * @param params
     * @param coid
     */
    void updateItem(Map<String, Object> params, Integer coid,Integer checkid);




}
