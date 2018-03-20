/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.persistence.dto;

import java.util.List;

/**
 *
 * @author rrodriguez
 */
public class ResultList {
    private String status;
    private String statusMessage;
    private List<Transferencia> list;

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the statusMessage
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * @param statusMessage the statusMessage to set
     */
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    /**
     * @return the list
     */
    public List<Transferencia> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Transferencia> list) {
        this.list = list;
    }
    
}
