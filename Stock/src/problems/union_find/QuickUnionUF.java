package problems.union_find;

/**
 * Quick-Union implementation
 * Created by chelsea on 12/8/15.
 */
public class QuickUnionUF {
    private int[] id;
    private int[] size; // Improvement 1: Weighted tree

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = 1;
            size[i] = 1; // Improvement 1: Weighted tree
        }
    }

    private int root(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    /**
     * Improvement 2: Path compression
     * After computing p's root, make all notes along the path to the root point
     * directly to the root
     * @param i
     * @return
     */
    private int root2(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; // additional line
            i = id[i];
        }
        return i;
    }
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    /**
     * Improvement 1: Weighted tree
     * @param p
     * @param q
     */
    public void union2(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
    }
}
