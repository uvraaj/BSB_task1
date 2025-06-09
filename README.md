# Blockchain Simulation Project

This project demonstrates the fundamental principles of blockchain technology, including block structure, hashing, mining, and consensus mechanisms. It serves as an educational tool to simulate how blockchain ensures data integrity, immutability, and decentralized consensus.

## 1. Blockchain Basics

A blockchain is a decentralized, tamper-resistant digital ledger that stores data in units called blocks, which are cryptographically linked in sequential order. Each block contains a unique hash, a reference to the previous block's hash, a timestamp, and transactional data.

The decentralized architecture ensures transparency and makes it extremely difficult to alter any data once it's been recorded. Modifying any block requires consensus across the network and recalculating all subsequent blocks, providing strong protection against data manipulation.

### Real-World Use Cases

- **Supply Chain Management**  
  Enables real-time tracking and verification of goods throughout the supply chain, improving transparency and reducing fraud.

- **Digital Identity**  
  Allows users to own and manage secure, verifiable digital identities without relying on centralized authorities.

## 2. Block Anatomy

Each block typically contains the following fields:

```
+----------------------------+
|       Block Header         |
+----------------------------+
| Timestamp: 2025-06-07      |
| Nonce: 58293               |
| Previous Hash: 7d32ab...   |
| Merkle Root: f9a8c...      |
+----------------------------+
|           Data             |
| "Alice pays Bob 10 BTC"    |
+----------------------------+
|           Hash             |
| a1b2c3d4e5f6...            |
+----------------------------+
```


### Merkle Root Explanation

The Merkle Root is a single hash that summarizes all transactions in a block. It is computed by hashing pairs of transaction hashes repeatedly until a single root hash remains.

**Example:**

Transactions = [A, B, C, D]

1. Hash A + B = H1  
2. Hash C + D = H2  
3. Merkle Root = Hash(H1 + H2)

If any transaction is altered, the Merkle Root changes, allowing for efficient and secure verification of data integrity without checking each transaction individually.

## 3. Consensus Mechanisms

### Proof of Work (PoW)

Proof of Work requires miners to solve computational puzzles to validate blocks. The first to solve the puzzle adds the new block to the chain and receives a reward. This mechanism ensures security and tamper resistance but is energy-intensive due to high computational requirements.

### Proof of Stake (PoS)

Proof of Stake selects validators based on the number of coins they lock (stake) in the network. The higher the stake, the greater the probability of being chosen to validate the next block. It consumes significantly less energy than PoW and discourages malicious behavior through economic incentives.

### Delegated Proof of Stake (DPoS)

In Delegated Proof of Stake, token holders vote to elect a small group of trusted delegates who are responsible for validating transactions and producing blocks. DPoS is faster and more energy-efficient than PoW and PoS, though it introduces some centralization through delegate voting.

## Project Files

- `blockchain_simulation.java`  
  Simulates creation and linking of basic blocks in a blockchain.

- `mining_simulation.java`  
  Demonstrates a simplified Proof of Work mechanism using nonce mining.

- `consensus_demo.java`  
  Simulates and compares validator selection in PoW, PoS, and DPoS systems.




