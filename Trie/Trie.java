import java.util.HashMap;
import java.util.Map;

public class Trie {

	
	static class TrieNode {
		
		boolean isEnd;
		Map<Character,TrieNode> children;
		
		public TrieNode() {
			this.children = new HashMap<>();
			this.isEnd = false;
		}
		
	}
	
	TrieNode root = null;
	
	public void insert(String str)
	{
		TrieNode curr = this.root;
		for(int i=0;i<str.length();i++)
		{
		TrieNode child = curr.children.get(str.charAt(i)); 	
		
		if(child == null )
		{
		 child = new TrieNode();	
		 curr.children.put(str.charAt(i), child);	
		}
		curr = child;
		}
		
		curr.isEnd = true;
	}
	
	public boolean search(String str) {
		
		TrieNode curr = this.root;
		
		for(int i=0;i<str.length();i++)
		{
			TrieNode child = curr.children.get(str.charAt(i)); 	
				
			if(child == null)
			return false;	
			
			curr = child;
		}
		
		return curr.isEnd;
	}
	
	public void delete(String str) {
		
	delete(this.root,str,0);	
	}
	

	public void delete(TrieNode current, String str, int i) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	
	
}
