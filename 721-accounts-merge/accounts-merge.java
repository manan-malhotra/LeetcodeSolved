/**
 * Using union-find (Union by rank and path compression) to group all emails
 * belonging to same owner. And using TreeSet to sort each group of emails.
 *
 * Time Complexity: O(N + N * log(N) + N) = O(N * log(N))
 *
 * Space Complexity: O(N)
 *
 * N = Total number of email addresses in the input. Here assuming the length of
 * each email and owner string is a fixed constant.
 */

class Solution {
    private class Node {
        String parent;
        String owner;
        int rank;

        public Node(String owner, String parent, int rank) {
            this.owner = owner;
            this.parent = parent;
            this.rank = rank;
        }
    }

    // Union by Rank and Path Compression
    private class AccountMergeUnionFind {
        private Map<String, Node> emailToNode;

        public AccountMergeUnionFind() {
            this.emailToNode = new HashMap<>();
        }

        public void addEmail(String owner, String email) {
            if (!emailToNode.containsKey(email)) {
                emailToNode.put(email, new Node(owner, email, 0));
            }
        }

        public String findParent(String email) {
            Node curNode = emailToNode.get(email);
            if (!email.equals(curNode.parent)) {
                curNode.parent = findParent(curNode.parent);
            }
            return curNode.parent;
        }

        public void union(String email1, String email2) {
            String parent1 = findParent(email1);
            String parent2 = findParent(email2);

            if (parent1.equals(parent2)) {
                return;
            }

            Node node1 = emailToNode.get(parent1);
            Node node2 = emailToNode.get(parent2);

            if (node1.rank >= node2.rank) {
                node2.parent = parent1;
                if (node1.rank == node2.rank) {
                    node1.rank++;
                }
            } else {
                node1.parent = parent2;
            }
        }

        public String getOwner(String email) {
            return emailToNode.get(email).owner;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null) {
            throw new IllegalArgumentException("Input is null");
        }
        if (accounts.size() == 0) {
            return new ArrayList<>();
        }

        AccountMergeUnionFind uf = new AccountMergeUnionFind();

        // Populating UnionFind with all emails.
        for (List<String> account : accounts) {
            if (account.size() <= 1) {
                continue;
            }
            String owner = account.get(0);
            uf.addEmail(owner, account.get(1));

            for (int i = 2; i < account.size(); i++) {
                uf.addEmail(owner, account.get(i));
                uf.union(account.get(1), account.get(i));
            }
        }

        // Creating merged Groups with sorted emails
        Map<String, TreeSet<String>> groups = new HashMap<>();
        for (List<String> account : accounts) {
            if (account.size() <= 1) {
                continue;
            }
            String parent = uf.findParent(account.get(1));
            if (!groups.containsKey(parent)) {
                groups.put(parent, new TreeSet<>());
            }
            TreeSet<String> curGroup = groups.get(parent);
            for (int i = 1; i < account.size(); i++) {
                curGroup.add(account.get(i));
            }
        }

        // Creating final result list
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, TreeSet<String>> group : groups.entrySet()) {
            List<String> account = new ArrayList<>();
            account.add(uf.getOwner(group.getKey()));
            account.addAll(group.getValue());
            result.add(account);
        }

        return result;
    }
}