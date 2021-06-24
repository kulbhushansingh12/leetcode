import java.util.HashMap;
import java.util.Map;

public class SecretStoreImpl implements SecretStore {

    private Map<String, String> inMemoryCache = new HashMap<>();

    @Override
    public String put(String key, String secret) {
        if (key == null || key.isEmpty() || key.length() > 20) {
            throw new IllegalStateException("Key cannot be blank or more than 20 chars");
        }

        inMemoryCache.put(key, secret);
        return key;
    }

    class Node {
        public Node right;
        public Node left;
        public int value;

        public Node(Node right, Node left, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
    private boolean isValueFound = false;
    public boolean findNumber(Node root, int num) {
        findNumberHelper(root, num);
        return isValueFound;
    }

    public void findNumberHelper(Node root, int num) {
        if (root == null)
            return;

        if (root.value == num)
            this.isValueFound = true;

        findNumberHelper(root.left, num);
        findNumberHelper(root.right, num);
    }
}
