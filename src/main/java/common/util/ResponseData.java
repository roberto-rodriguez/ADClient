/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common.util;

import java.util.List;

/**
 *
 * @author Roberto Rodriguez   :: <roberto.rodriguez@smartbt.com>
 */
public class ResponseData<T> {
    private List<T> list;
    private int totalRows;

    public ResponseData( List<T> list, int totalRows ) {
        this.list = list;
        this.totalRows = totalRows;
    }

    /**
     * @return the list
     */
    public List<T> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList( List<T> list ) {
        this.list = list;
    }

    /**
     * @return the totalRows
     */
    public int getTotalRows() {
        return totalRows;
    }

    /**
     * @param totalRows the totalRows to set
     */
    public void setTotalRows( int totalRows ) {
        this.totalRows = totalRows;
    }
    
    
    
    
}
