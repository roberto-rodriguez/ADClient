/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.persistence.dto;

/**
 *
 * @author rrodriguez
 */
public class LoginCommand {
   private String username;
   private String password;
   private Boolean invalidCredentials;

    public LoginCommand() {
    }

    public LoginCommand(String username, String password ) {
        this.username = username;
        this.password = password; 
    }
   
   

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the invalidCredentials
     */
    public Boolean getInvalidCredentials() {
        return invalidCredentials;
    }

    /**
     * @param invalidCredentials the invalidCredentials to set
     */
    public void setInvalidCredentials(Boolean invalidCredentials) {
        this.invalidCredentials = invalidCredentials;
    }
                    
   
}
