/*
 ** File: Utils.java
 **
 ** Date Created: March 2013
 **
 ** Copyright @ 2004-2013 Smart Business Technology, Inc.
 **
 ** All rights reserved. No part of this software may be 
 ** reproduced, transmitted, transcribed, stored in a retrieval 
 ** system, or translated into any language or computer language, 
 ** in any form or by any means, electronic, mechanical, magnetic, 
 ** optical, chemical, manual or otherwise, without the prior 
 ** written permission of Smart Business Technology, Inc.
 **
 */
package common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
//import javax.ws.rs.core.HttpHeaders;

/**
 *
 * @author Ariamnet Lopez, Ariel Saavedra
 */
public class Utils {

    private static String token_alphabet = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  

    public static String generateToken() {
        return rndstr(48);
    }

    public static String generateCampaignCode() {
        return rndstr(5);
    }

    private static String rndstr(int len) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();

        while (sb.length() < len) {
            sb.append(token_alphabet.charAt(r.nextInt(token_alphabet.length() - 1)));
        }

        return sb.toString();
    }

    /**
     * Basic SHA-1 Password Encryption
     *
     * @param password
     * @return String
     * @throws NoSuchAlgorithmException
     */
    public static String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA-1");
        byte[] result = mDigest.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();

    }
}
