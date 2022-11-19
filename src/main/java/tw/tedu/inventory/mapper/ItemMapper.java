package tw.tedu.inventory.mapper;

import org.apache.ibatis.annotations.Param;
import tw.tedu.inventory.entity.*;

import java.util.List;

public interface ItemMapper {

    /**
     * 寫入Automa爬回的商品數據
     * @param item
     * @return 受影響的行數
     */
    Integer insert(Item item);

    /**
     * 寫入比對頁面右側欄位
     * @param column
     * @return
     */
    Integer insertIC(ItemColumn column);

    /**
     * 寫入比對頁面商店庫存欄位
     * @param storeItem
     * @return
     */
    Integer insertSI(StoreItem storeItem);

    /**
     * 根據Coname查詢廠商資料
     * @param coname
     * @return
     */
    Company findCoByConame(String coname);

    /**
     * 根據coid查詢廠商資料
     * @param coid
     * @return
     */
    Company findCoByCoid(Integer coid);

    /**
     * 根據coid查詢更新資料
     * @param coid
     * @return
     */
    List<Item> findItemByCoid(Integer coid);

    /**
     * 根據iccoid查詢選項欄位資料
     * @param iccoid
     * @return
     */
    List<ItemColumn> findItemColumnByiccoid(Integer iccoid);

    /**
     * 根據iccoid及checkid查詢選項欄位資料
     * @param iccoid
     * @return
     */
    List<ItemColumn> findItemColumnByiccoidAndCheckid(Integer iccoid,Integer checkid);

    /**
     * 根據iccoid查詢商店庫存資料
     * @param sicoid
     * @return
     */
    List<StoreItem> findStoreItemBysicoid(Integer sicoid);

    /**
     * 根據sicoid及checkid查詢商店庫存資料
     * @param sicoid
     * @return
     */
    List<StoreItem> findStoreItemBysicoidandCI(@Param("sicid")Integer sicid,
                                               @Param("sicoid")Integer sicoid);

    /**
     * 查詢網頁日誌顯示
     */
    List<Logwriter> findWebLog();

    /**
     * 清空s_item表格
     * @return
     */
    Integer deleteSItemTable(Integer coid);

    /**
     * 透過CheckId刪除對應的比對頁面的選項欄位
     * @param checkid
     * @return
     */
    Integer delICByCheckId(@Param("checkid")Integer checkid,
                           @Param("iccoid")Integer iccoid);

    /**
     * 透過Sicid,Sicoid刪除對應的比對頁面商店欄位
     * @param sicid
     * @param sicoid
     * @return
     */
    Integer delSIBySicid(@Param("sicid")Integer sicid,
                           @Param("sicoid")Integer sicoid);

    /**
     * 透過cid,coid刪除對應的比對頁面新資料欄位
     * @param cid
     * @param coid
     * @return
     */
    Integer delIByCid(@Param("cid")Integer cid,
                         @Param("coid")Integer coid);

    /**
     * 透過 checkid以及iccoid定位修改商品的storeurl以及courl
     * @param checkid
     * @param iccoid
     * @param storeurl
     * @param courl
     * @return
     */
    Integer updateItemColumn(@Param("checkid")Integer checkid,
                            @Param("iccoid")Integer iccoid,
                            @Param("storeurl")String storeurl,
                            @Param("courl")String courl);

    /**
     * 透過 sicid以及sicoid定位修改商品 再由siid排列修改順序
     * @param siid
     * @param sicid
     * @param sicoid
     * @return
     */
    Integer updateStoreItem(@Param("siid")Integer siid,
                            @Param("sicid")Integer sicid,
                            @Param("sicoid")Integer sicoid,
                            @Param("sicontent")String sicontent);

}
