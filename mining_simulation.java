import java.security.MessageDigest;
import java.util.Date;

class Block {
    public int index;
    public long timestamp;
    public String data;
    public String previousHash;
    public int nonce;
    public String hash;

    public Block(int index, long timestamp, String data, String previousHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.previousHash = previousHash;
        this.nonce = 0;
        this.hash = computeHash();
    }

    public String computeHash() {
        try {
            String input = index + Long.toString(timestamp) + data + previousHash + nonce;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));

            // Convert byte array to hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void mineBlock(int difficulty) {
        System.out.println("Mining block with difficulty = " + difficulty);
        long startTime = System.currentTimeMillis();

        String prefix = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(prefix)) {
            nonce++;
            hash = computeHash();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("\nBlock mined successfully!");
        System.out.println("Nonce: " + nonce);
        System.out.println("Hash: " + hash);
        System.out.println("Time taken: " + (endTime - startTime) / 1000.0 + " seconds");
    }
}

public class BlockMining {
    public static void main(String[] args) {
        int difficulty = 4;
        Block block = new Block(1, new Date().getTime(), "Transaction A -> B", "0");
        block.mineBlock(difficulty);
    }
}
