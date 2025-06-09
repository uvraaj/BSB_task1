import java.security.MessageDigest;
import java.util.ArrayList;
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
}

public class SimpleBlockchain {
    public static void main(String[] args) {
        // Create Genesis Block
        Block genesisBlock = new Block(0, new Date().getTime(), "Genesis Block", "0");
        System.out.println("Block 0: " + genesisBlock.hash);

        // Create Block 1
        Block block1 = new Block(1, new Date().getTime(), "Transaction A -> B", genesisBlock.hash);
        System.out.println("Block 1: " + block1.hash);

        // Create Block 2
        Block block2 = new Block(2, new Date().getTime(), "Transaction B -> C", block1.hash);
        System.out.println("Block 2: " + block2.hash);

        // Store in chain
        ArrayList<Block> blockchain = new ArrayList<>();
        blockchain.add(genesisBlock);
        blockchain.add(block1);
        blockchain.add(block2);

        // Display chain
        System.out.println("\n--- Blockchain ---");
        for (Block block : blockchain) {
            System.out.println("Index: " + block.index + ", Hash: " + block.hash + ", PrevHash: " + block.previousHash);
        }

        // Tamper Block 1
        System.out.println("\n--- Tampering Block 1 ---");
        block1.data = "Transaction A -> HACKED";
        block1.hash = block1.computeHash();
        System.out.println("Tampered Block 1 Hash: " + block1.hash);
        System.out.println("Block 2 PrevHash (unchanged): " + block2.previousHash);

        // Check validity
        System.out.println("\n--- Integrity Check ---");
        if (!block2.previousHash.equals(block1.hash)) {
            System.out.println("Blockchain is INVALID due to tampering in Block 1!");
        } else {
            System.out.println("Blockchain is still valid.");
        }
    }
}
