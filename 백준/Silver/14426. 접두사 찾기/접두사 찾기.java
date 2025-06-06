import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static class TrieNode{
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    static class Trie{
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word){
            TrieNode cur = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';

                if(cur.children[index] == null){
                    cur.children[index] = new TrieNode();
                }

                cur = cur.children[index];
            }
        }
        
        public boolean isStartWith(String word){
            TrieNode cur = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';

                if(cur.children[index] == null){
                    return false;
                }

                cur = cur.children[index];
            }

            return true;
        }
    }    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		Trie trie = new Trie();
		for (int i = 0; i < N; i++) {
			trie.insert(br.readLine());
		}
		int count = 0;
		for (int i = 0; i < M; i++) {
			if (trie.isStartWith(br.readLine())) {
				count++;
			}
		}
		System.out.println(count);
	}
}
