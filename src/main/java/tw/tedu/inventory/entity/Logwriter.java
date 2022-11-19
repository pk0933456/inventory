package tw.tedu.inventory.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * web日誌實體類
 */
public class Logwriter implements Serializable {

    private static final long serialVersionUID = 231702079149152206L;
    private Integer logId ;
    private String logUsername ;
    private String doAction ;
    private String logObj ;
    private Date exeTime ;

    @Override
    public String toString() {
        return "Logwriter{" +
                "logId=" + logId +
                ", logUsername='" + logUsername + '\'' +
                ", doAction='" + doAction + '\'' +
                ", logObj='" + logObj + '\'' +
                ", exeTime=" + exeTime +
                '}';
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogUsername() {
        return logUsername;
    }

    public void setLogUsername(String logUsername) {
        this.logUsername = logUsername;
    }

    public String getDoAction() {
        return doAction;
    }

    public void setDoAction(String doAction) {
        this.doAction = doAction;
    }

    public String getLogObj() {
        return logObj;
    }

    public void setLogObj(String logObj) {
        this.logObj = logObj;
    }

    public Date getExeTime() {
        return exeTime;
    }

    public void setExeTime(Date exeTime) {
        this.exeTime = exeTime;
    }
}
