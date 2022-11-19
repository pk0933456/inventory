package tw.tedu.inventory.entity;

import java.io.Serializable;

public class Item implements Serializable {

    private static final long serialVersionUID = -6370062179961881336L;
    private Integer iid;
    private Integer cid;
    private String content;
    private Integer coid;

    @Override
    public String toString() {
        return "Item{" +
                "iid=" + iid +
                ", cid=" + cid +
                ", content='" + content + '\'' +
                ", coid=" + coid +
                '}';
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }
}