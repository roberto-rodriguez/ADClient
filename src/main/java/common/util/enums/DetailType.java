/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common.util.enums;

/**
 *
 * @author Roberto Rodriguez   :: <roberto.rodriguez@smartbt.com>
 */
public enum DetailType {
    MEETING(1, "Appoinment"),
    DECISION(2, "Decision"),
    OPERTUNITY(3, "Qualified");
    
    private int id;
    private String label;

    private DetailType( int id, String label ) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
    
    
    
}
