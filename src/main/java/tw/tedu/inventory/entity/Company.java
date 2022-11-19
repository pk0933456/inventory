package tw.tedu.inventory.entity;

import java.io.Serializable;

public class Company implements Serializable {

    private static final long serialVersionUID = -2141827371587908433L;
    private Integer id;
    private String coname;
    private Integer coid;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", coname='" + coname + '\'' +
                ", coid=" + coid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }
}
