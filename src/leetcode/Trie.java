package leetcode;

//https://leetcode.com/problems/implement-trie-prefix-tree/
public class Trie {

   TrieNode root;

   /** Initialize your data structure here. */
   public Trie() {
      root = new TrieNode();
   }

   /** Inserts a word into the trie. */
   public void insert(String word) {
      TrieNode current = root;
      for (char ch : word.toCharArray()) {
         if (current.childrens[ch - 'a'] == null) {
            current.childrens[ch - 'a'] = new TrieNode();
         }
         current = current.childrens[ch - 'a'];
      }
      current.isLastNode = true;
   }

   /** Returns if the word is in the trie. */
   public boolean search(String word) {
      TrieNode current = root;
      for (char ch : word.toCharArray()) {
         if (current.childrens[ch - 'a'] == null)
            return false;
         current = current.childrens[ch - 'a'];
      }

      return current != null && current.isLastNode;
   }

   /** Returns if there is any word in the trie that starts with the given prefix. */
   public boolean startsWith(String prefix) {
      TrieNode current = root;
      for (char ch : prefix.toCharArray()) {
         if (current.childrens[ch - 'a'] == null)
            return false;
         current = current.childrens[ch - 'a'];
      }

      return current.childrens != null;
   }

   class TrieNode {
      public TrieNode[] childrens = new TrieNode[26];
      public boolean isLastNode;
   }

   public static void main(String[] args) {
      Trie trie = new Trie();
      trie.insert("apple");
      System.out.println(trie.search("apple"));
      System.out.println(trie.search("app"));
      System.out.println(trie.startsWith("app"));
      trie.insert("app");
      System.out.println(trie.search("app"));
   }
}
