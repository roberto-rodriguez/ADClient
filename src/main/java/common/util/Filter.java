/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common.util;

import common.util.enums.FilterName;
import java.io.Serializable;

/**
 *
 * @author Roberto Rodriguez   :: <roberto.rodriguez@smartbt.com>
 */
public class Filter  implements Serializable{
    private FilterName filter;
    private Object value;

    public Filter() {
    }

    public Filter( FilterName filter, Object value ) {
        this.filter = filter;
        this.value = value;
    }
    
    

    /**
     * @return the filter
     */
    public FilterName getFilter() {
        return filter;
    }

    /**
     * @param filter the filter to set
     */
    public void setFilter( FilterName filter ) {
        this.filter = filter;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue( Object value ) {
        this.value = value;
    }
    
    
}
