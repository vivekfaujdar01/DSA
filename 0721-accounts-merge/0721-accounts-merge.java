class DisjointSet {
    int[] parent;
    int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUPar(int node) {
        if (node == parent[node])
            return node;

        return parent[node] = findUPar(parent[node]); // Path Compression
    }

    public void unionBySize(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);

        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}

class Solution {

    static List<List<String>> accountsMerge(List<List<String>> details) {

        int n = details.size();
        DisjointSet ds = new DisjointSet(n);

        HashMap<String, Integer> mapMailNode = new HashMap<>();

        // Connect accounts using common emails
        for (int i = 0; i < n; i++) {

            for (int j = 1; j < details.get(i).size(); j++) {

                String mail = details.get(i).get(j);

                if (!mapMailNode.containsKey(mail)) {
                    mapMailNode.put(mail, i);
                } else {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        // Create mergedMail array
        ArrayList<String>[] mergedMail = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<>();
        }

        // Group emails by ultimate parent
        for (Map.Entry<String, Integer> entry : mapMailNode.entrySet()) {

            String mail = entry.getKey();
            int node = ds.findUPar(entry.getValue());

            mergedMail[node].add(mail);
        }

        // Prepare final answer
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (mergedMail[i].size() == 0) continue;

            Collections.sort(mergedMail[i]);

            List<String> temp = new ArrayList<>();

            // Add name
            temp.add(details.get(i).get(0));

            for (String mail : mergedMail[i]) {
                temp.add(mail);
            }

            ans.add(temp);
        }

        return ans;
    }
}