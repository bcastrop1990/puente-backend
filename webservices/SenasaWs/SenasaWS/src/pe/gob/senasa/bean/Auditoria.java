package pe.gob.senasa.bean;

import java.io.Serializable;

public class Auditoria  implements Serializable{
    public Auditoria() {
        super();
    }
    
    private String txId;
    private String errorCode;
    private String errorMsg;

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getTxId() {
        return txId;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
