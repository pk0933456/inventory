package tw.tedu.inventory.entity;

import java.io.Serializable;

public class ItemIns implements Serializable {
    private String storeUrl ;
    private String coUrl ;
    private String sicontent1 ;
    private String sicontent2 ;
    private String sicontent3 ;
    private String sicontent4 ;
    private String sicontent5 ;
    private String sicontent6 ;
    private String sicontent7 ;
    private String sicontent8 ;
    private String sicontent9 ;
    private String sicontent10 ;

    @Override
    public String toString() {
        return "ItemIns{" +
                "storeUrl='" + storeUrl + '\'' +
                ", coUrl='" + coUrl + '\'' +
                ", sicontent1='" + sicontent1 + '\'' +
                ", sicontent2='" + sicontent2 + '\'' +
                ", sicontent3='" + sicontent3 + '\'' +
                ", sicontent4='" + sicontent4 + '\'' +
                ", sicontent5='" + sicontent5 + '\'' +
                ", sicontent6='" + sicontent6 + '\'' +
                ", sicontent7='" + sicontent7 + '\'' +
                ", sicontent8='" + sicontent8 + '\'' +
                ", sicontent9='" + sicontent9 + '\'' +
                ", sicontent10='" + sicontent10 + '\'' +
                '}';
    }

    public String getStoreUrl() {
        return storeUrl;
    }

    public void setStoreUrl(String storeUrl) {
        this.storeUrl = storeUrl;
    }

    public String getCoUrl() {
        return coUrl;
    }

    public void setCoUrl(String coUrl) {
        this.coUrl = coUrl;
    }

    public String getSicontent1() {
        return sicontent1;
    }

    public void setSicontent1(String sicontent1) {
        this.sicontent1 = sicontent1;
    }

    public String getSicontent2() {
        return sicontent2;
    }

    public void setSicontent2(String sicontent2) {
        this.sicontent2 = sicontent2;
    }

    public String getSicontent3() {
        return sicontent3;
    }

    public void setSicontent3(String sicontent3) {
        this.sicontent3 = sicontent3;
    }

    public String getSicontent4() {
        return sicontent4;
    }

    public void setSicontent4(String sicontent4) {
        this.sicontent4 = sicontent4;
    }

    public String getSicontent5() {
        return sicontent5;
    }

    public void setSicontent5(String sicontent5) {
        this.sicontent5 = sicontent5;
    }

    public String getSicontent6() {
        return sicontent6;
    }

    public void setSicontent6(String sicontent6) {
        this.sicontent6 = sicontent6;
    }

    public String getSicontent7() {
        return sicontent7;
    }

    public void setSicontent7(String sicontent7) {
        this.sicontent7 = sicontent7;
    }

    public String getSicontent8() {
        return sicontent8;
    }

    public void setSicontent8(String sicontent8) {
        this.sicontent8 = sicontent8;
    }

    public String getSicontent9() {
        return sicontent9;
    }

    public void setSicontent9(String sicontent9) {
        this.sicontent9 = sicontent9;
    }

    public String getSicontent10() {
        return sicontent10;
    }

    public void setSicontent10(String sicontent10) {
        this.sicontent10 = sicontent10;
    }
}
