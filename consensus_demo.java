import java.util.*;

public class ConsensusSimulation {

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("========== Consensus Mechanism Simulation ==========\n");

        // -------------------
        // 1. Proof of Work (PoW)
        // -------------------
        System.out.println(">>> Proof of Work (PoW) Simulation");

        Map<String, Integer> miners = new HashMap<>();
        miners.put("MinerA", random.nextInt(100) + 1);
        miners.put("MinerB", random.nextInt(100) + 1);
        miners.put("MinerC", random.nextInt(100) + 1);

        String powWinner = Collections.max(miners.entrySet(), Map.Entry.comparingByValue()).getKey();

        System.out.println("Miners and their power:");
        for (Map.Entry<String, Integer> entry : miners.entrySet()) {
            System.out.println("  " + entry.getKey() + ": Power = " + entry.getValue());
        }
        System.out.println("Selected Validator: " + powWinner + " (Highest computational power)");
        System.out.println("Explanation: In PoW, validators (miners) compete by solving cryptographic puzzles. The one with the most power wins.\n");

        // -------------------
        // 2. Proof of Stake (PoS)
        // -------------------
        System.out.println(">>> Proof of Stake (PoS) Simulation");

        Map<String, Integer> stakers = new HashMap<>();
        stakers.put("StakerA", random.nextInt(100) + 1);
        stakers.put("StakerB", random.nextInt(100) + 1);
        stakers.put("StakerC", random.nextInt(100) + 1);

        String posWinner = Collections.max(stakers.entrySet(), Map.Entry.comparingByValue()).getKey();

        System.out.println("Stakers and their stake:");
        for (Map.Entry<String, Integer> entry : stakers.entrySet()) {
            System.out.println("  " + entry.getKey() + ": Stake = " + entry.getValue());
        }
        System.out.println("Selected Validator: " + posWinner + " (Highest stake)");
        System.out.println("Explanation: In PoS, validators are chosen based on the amount of tokens they lock (stake) in the network.\n");

        // -------------------
        // 3. Delegated Proof of Stake (DPoS)
        // -------------------
        System.out.println(">>> Delegated Proof of Stake (DPoS) Simulation");

        Map<String, Integer> delegates = new HashMap<>();
        delegates.put("Delegate1", 0);
        delegates.put("Delegate2", 0);
        delegates.put("Delegate3", 0);

        String[] voters = {"Voter1", "Voter2", "Voter3"};
        List<String> delegateList = new ArrayList<>(delegates.keySet());

        System.out.println("Voting process:");
        for (String voter : voters) {
            String selected = delegateList.get(random.nextInt(delegateList.size()));
            delegates.put(selected, delegates.get(selected) + 1);
            System.out.println("  " + voter + " voted for " + selected);
        }

        String dposWinner = Collections.max(delegates.entrySet(), Map.Entry.comparingByValue()).getKey();

        System.out.println("\nDelegates and their votes:");
        for (Map.Entry<String, Integer> entry : delegates.entrySet()) {
            System.out.println("  " + entry.getKey() + ": Votes = " + entry.getValue());
        }

        System.out.println("Selected Validator: " + dposWinner + " (Most votes)");
        System.out.println("Explanation: In DPoS, token holders vote for delegates who validate blocks on their behalf. It is faster and more democratic.\n");

        System.out.println("========== End of Simulation ==========");
    }
}
