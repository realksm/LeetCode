class TrieNode {
    TrieNode[] children;
    boolean isWord;
    TrieNode() {
        this.children = new TrieNode[26];
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = this.root;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(temp.children[index] == null) temp.children[index] = new TrieNode();
            temp = temp.children[index];
        }
        temp.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode temp = this.root;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(temp.children[index] == null) return false;
            temp = temp.children[index];
        }
        return temp != null && temp.isWord;
    }
    
    public boolean startsWith(String word) {
        TrieNode temp = this.root;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(temp.children[index] == null) return false;
            temp = temp.children[index];
        }
        return temp != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */