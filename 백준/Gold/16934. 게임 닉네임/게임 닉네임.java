import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static class TrieNode {
        TrieNode[] child = new TrieNode[26];  
        int count = 0;     
        int endCount = 0;  
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public String insert(String name) {
            TrieNode node = root;
            StringBuilder sb = new StringBuilder();
            boolean isNew = false;

            for (int i = 0; i < name.length(); i++) {
                char c = name.charAt(i);
                int idx = c - 'a';

                if (node.child[idx] == null) {
                    node.child[idx] = new TrieNode();
                }

                node = node.child[idx];
                node.count++;
                
                if (node.count == 1 && !isNew) {
                    sb.append(name.substring(0, i + 1));
                    isNew = true;
                }
            }

            String prefix = sb.toString();
            if (node.endCount == 0) {
				node.endCount++;
				return prefix.equals("") ? name : prefix;
			}

            node.endCount++;
            return name + (node.endCount);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Trie trie = new Trie();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            result.append(trie.insert(name)).append("\n");
        }

        System.out.print(result);
    }
}