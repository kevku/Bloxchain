/**
 * Name: Kevin Kuang   
 * Email: kekuang5@gmail.com
 * Sources used: https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa
 * 
 * This file contains the construction of the Block
 * and the method to mine the block.
 */
import java.util.Date;

public class Block {
  
  public String hash;
  public String previousHash;
  private String data; // our simple message
  private long timeStamp; // as number of milliseconds since 1/1/1970
  private int nonce;

  public Block(String data, String previousHash) {
    this.data = data;
    this.previousHash = previousHash;
    this.timeStamp = new Date().getTime();
    this.hash = calculateHash();
  }

  public String calculateHash() {
    String calculatedHash = StringUtil.applySha256(
      previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data);
      return calculatedHash;
  }

  public void mineBlock(int difficulty) {
    // Creates a string with difficulty "0"
    String target = new String(new char[difficulty]).replace('\0', '0');

    while (!hash.substring(0, difficulty).equals(target)) {
      nonce++;
      hash = calculateHash();
    }
    System.out.println("Block Mined!! : " + hash);
  }

}
