package tw.tedu.inventory.entity;

import java.io.Serializable;

public class StoreItem implements Serializable {

    private static final long serialVersionUID = 7418713345282778411L;
    private Integer siid;
    private Integer sicid;
    private String sicontent;
    private Integer sicoid;

    @Override
    public String toString() {
        return "StoreItem{" +
                "siid=" + siid +
                ", sicid=" + sicid +
                ", sicontent='" + sicontent + '\'' +
                ", sicoid=" + sicoid +
                '}';
    }

    public Integer getSiid() {
        return siid;
    }

    public void setSiid(Integer siid) {
        this.siid = siid;
    }

    public Integer getSicid() {
        return sicid;
    }

    public void setSicid(Integer sicid) {
        this.sicid = sicid;
    }

    public String getSicontent() {
        return sicontent;
    }

    public void setSicontent(String sicontent) {
        this.sicontent = sicontent;
    }

    public Integer getSicoid() {
        return sicoid;
    }

    public void setSicoid(Integer sicoid) {
        this.sicoid = sicoid;
    }
}
