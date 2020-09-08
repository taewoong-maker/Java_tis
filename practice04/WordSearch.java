package practice05;

public class WordSearch {
	
	public static void main(String[] args) {
		
		char[][]words= {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		
		String word = "ABCCED";	
		WordSearch ws = new WordSearch();
		System.out.println(ws.solve(words, word));
	}

	public boolean solve(char[][]words, String word) {
		
		int m=words.length;
		int n=words[0].length;
		
		if(m==0||n==0||words==null)
			return false;
		
		boolean[][] visited = new boolean[m][n];

		for(int i=0;i<words.length;i++) {
			for(int j=0;j<words[i].length;j++){
				if(dfs(words,visited,i,j,0,word))
					return true;
			}
		}
		
		return false;
	}
	
	int[][] tools = {{-1,0},{0,-1},{1,0},{0,1}};
	
	public boolean dfs(char[][] words,boolean[][]visited, int i, int j, int index, String word) {
		int m = words.length;
		int n = words[0].length;
		char[]arr=word.toCharArray();
		
		if(index==arr.length)
			return true;
		
		if(i<0||i>=m||j<0||j>=n||i<0||visited[i][j])
			return false;		
		if(words[i][j]!=word.charAt(index))
			return false;
		
		if(words[i][j]==word.indexOf(index)) {
			visited[i][j]=true;
			
			for(int[]tool:tools) {
				int dx=i+tool[0];
				int dy=j+tool[1];
				if(dfs(words,visited,dx,dy,index+1,word))
					return true;
			}
		}		
		
		return true;
	}
}
