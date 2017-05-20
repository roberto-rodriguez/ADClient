/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common.util.enums;

import java.io.Serializable;

/**
 *
 * @author Roberto Rodriguez   :: <roberto.rodriguez@smartbt.com>
 */
public enum FilterName implements Serializable{
    VALUE_FILTER,
    ORDER_FILTER,
    PAGINATION_FILTER,
    
    NAME,
    DATE,
    CALL,
    MEETING,
    DECISION,
    SALE,
    CAMPAIGN,
    PAGINATION,
    MEMBERS,
    USER, EMAIL, ROLE,
    ACTIVITY_REPORT_PROJECTION
}
