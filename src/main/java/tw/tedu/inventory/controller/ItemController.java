package tw.tedu.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.tedu.inventory.entity.*;
import tw.tedu.inventory.service.IItemService;
import tw.tedu.inventory.util.JsonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("item")
public class ItemController extends BaseController{

    @Autowired
    private IItemService itemService;

    /**
     * 執行新增商店庫存作業
     * @param params
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("addNewItem")
    public JsonResult<Void> addNewItem(@RequestBody Map<String, Object> params,HttpSession session) {
        Integer coid = (Integer) session.getAttribute("coid");
        itemService.addNewItem(params,coid);
        return new JsonResult<Void>(SUCCESS);
    }

    /**
     * 執行更新商店庫存作業
     * @param params
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("upitem")
    public JsonResult<Void> upItem(@RequestBody Map<String, Object> params,HttpSession session) {
        Integer coid = (Integer) session.getAttribute("coid");
        Integer checkid = (Integer) session.getAttribute("checkid");
        itemService.updateItem(params,coid,checkid);
        return new JsonResult<>(SUCCESS);
    }

    /**
     * 準備執行更新商店庫存，對session寫入修改商品對應的檢查id
     * @param checkid
     * @param session
     * @return
     */
    @RequestMapping("{checkid}/updateSI")
    public JsonResult<Void> updateSI(@PathVariable("checkid") Integer checkid, HttpSession session) {
        session.setAttribute("checkid",checkid);
        return new JsonResult<>(SUCCESS);
    }

    /**
     * 執行對session寫入對應廠商id
     * @param coid
     * @param session
     * @return
     */
    @RequestMapping("{coid}/set_coid")
    public JsonResult<Void> setCoid(@PathVariable("coid") Integer coid, HttpSession session) {
        session.setAttribute("coid", coid);
        return new JsonResult<>(SUCCESS);
    }

    /**
     * 顯示比對頁面最新商品欄位
     * @param session
     * @return
     */
    @GetMapping("showCoName")
    public JsonResult<Company> showCoName(HttpSession session) {
        Integer coid = (Integer) session.getAttribute("coid");
        Company coName = (Company) itemService.getCoNameByCoid(coid);
        return new JsonResult<>(SUCCESS,coName);

    }

    /**
     * 顯示比對頁面最新商品欄位
     * @param session
     * @return
     */
    @GetMapping("showItem")
    public JsonResult<List<Item>> showItem(HttpSession session) {
        Integer coid = (Integer) session.getAttribute("coid");
        List<Item> items = itemService.getItemByCoid(coid);
        return new JsonResult<>(SUCCESS, items);
    }

    /**
     * 顯示比對頁面的選項欄位
     * @param session
     * @return
     */
    @GetMapping("showItemColumn")
    public JsonResult<List<ItemColumn>> showItemColumn(HttpSession session) {
        Integer coid = (Integer) session.getAttribute("coid");
        List<ItemColumn> ItemColumn = itemService.getItemColumnByiccoid(coid);
        return new JsonResult<>(SUCCESS, ItemColumn);

    }

    /**
     * 顯示商店庫存欄位
     * @param session
     * @return
     */
    @GetMapping("showStoreItem")
    public JsonResult<List<StoreItem>> showStoreItem(HttpSession session) {
        Integer coid = (Integer) session.getAttribute("coid");
        List<StoreItem> StoreItem = itemService.getStoreItemBysicoid(coid);
        return new JsonResult<>(SUCCESS, StoreItem);
    }

    /**
     * 顯示選擇更新網址欄位的資訊
     * @param session
     * @return
     */
    @GetMapping("showUpdateItemColumn")
    public JsonResult<List<ItemColumn>> showUpdateItemColumn(HttpSession session) {
        Integer coid = (Integer) session.getAttribute("coid");
        Integer checkid = (Integer) session.getAttribute("checkid");
        List<ItemColumn> ItemColumn = itemService.getItemColumnByiccoidAndCheckid(coid,checkid);
        return new JsonResult<>(SUCCESS, ItemColumn);

    }

    /**
     * 顯示選擇更新庫存商品資訊
     * @param session
     * @return
     */
    @GetMapping("showUpdateStoreItem")
    public JsonResult<List<StoreItem>> showUpdateStoreItem(HttpSession session) {
        Integer coid = (Integer) session.getAttribute("coid");
        Integer checkid = (Integer) session.getAttribute("checkid");
        List<StoreItem> StoreItem = itemService.getStoreItemBysicoidandCI(checkid,coid);
        return new JsonResult<>(SUCCESS, StoreItem);

    }

    /**
     * 重新刷新商品頁面
     * @param session
     * @return
     */
    @RequestMapping("replaceItem")
    public JsonResult<Void> replaceItem(HttpSession session) {
        Integer coid = (Integer) session.getAttribute("coid");
        itemService.update(coid);
        return new JsonResult<>(SUCCESS);

    }

    /**
     * 刪除所選比對欄位
     * @param checkid
     * @param session
     * @return
     */
    @RequestMapping("{checkid}/deleteWC")
    public JsonResult<Void> deleteWC(@PathVariable("checkid") Integer checkid,HttpSession session){
        Integer coid = getCoidFromSession(session);
        Integer cid = checkid ;
        Integer iccoid = coid ;
        Integer sicid = cid ;
        Integer sicoid = coid ;
        itemService.deleteWebcolumn(cid, coid,  sicid,  sicoid,  checkid,  iccoid);
        return new JsonResult<>(SUCCESS);
    }

}
