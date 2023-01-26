/**
 * Name: Kevin Kuang   
 * Email: kekuang5@gmail.com
 * Sources used: https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa
 * 
 * This file contains the method to encrypt the given 
 * string using SHA256 
 */

import java.security.MessageDigest;

public class StringUtil {
  
  // Using SHA256 as a cryptographic algorithm
  public static String applySha256(String input) {

    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] hash = digest.digest(input.getBytes("UTF-8"));

      StringBuffer hexString = new StringBuffer(); // holds hash as a hexadecimal

      for (int i = 0; i < hash.length; i++) {
        String hex = Integer.toHexString(0xff & hash[i]);
        if (hex.length() == 1) {
          hexString.append('0');
        }
        hexString.append(hex);
      }

      return hexString.toString();
    }
    catch(Exception e) {
      throw new RuntimeException();
    }

  }

}
