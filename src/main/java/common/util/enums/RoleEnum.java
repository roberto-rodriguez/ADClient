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
public enum RoleEnum {

    SELLER(1),
    SUPERVISOR(2),
    ADMIN(3),
    MVC(4);
    
    private long id;

    private RoleEnum( long id ) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
    
    public static RoleEnum getRole(long id){
        switch((int)id){
            case 1: return SELLER;
            case 2: return SUPERVISOR;
            case 3: return ADMIN;
            case 4: return MVC;
        }
        return null;
    }
}
