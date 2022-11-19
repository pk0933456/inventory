package tw.tedu.inventory.entity;

import java.io.Serializable;

/**
 * 比對商品頁右側欄位實體類
 */
public class ItemColumn implements Serializable {

    private static final long serialVersionUID = 4945592359577731833L;
    private Integer icid;
    private String storeurl;
    private String courl;
    private Integer checkid;
    private Integer icstate;
    private Integer iccoid;

    @Override
    public String toString() {
        return "ItemColumn{" +
                "icid=" + icid +
                ", storeurl='" + storeurl + '\'' +
                ", courl='" + courl + '\'' +
                ", checkid=" + checkid +
                ", icstate=" + icstate +
                ", iccoid=" + iccoid +
                '}';
    }

    public Integer getIcid() {
        return icid;
    }

    public void setIcid(Integer icid) {
        this.icid = icid;
    }

    public String getStoreurl() {
        return storeurl;
    }

    public void setStoreurl(String storeurl) {
        this.storeurl = storeurl;
    }

    public String getCourl() {
        return courl;
    }

    public void setCourl(String courl) {
        this.courl = courl;
    }

    public Integer getCheckid() {
        return checkid;
    }

    public void setCheckid(Integer checkid) {
        this.checkid = checkid;
    }

    public Integer getIcstate() {
        return icstate;
    }

    public void setIcstate(Integer icstate) {
        this.icstate = icstate;
    }

    public Integer getIccoid() {
        return iccoid;
    }

    public void setIccoid(Integer iccoid) {
        this.iccoid = iccoid;
    }
}
