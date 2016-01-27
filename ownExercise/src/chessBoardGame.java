public class chessBoardGame {
	public static boolean [][] Player1;
	public static boolean [][] Player2;
	private static boolean[][] chessBoard;
	private static int size0=8;
	
	
	public static void init () {
		Player1 = new boolean[size0][size0];
		Player2= new boolean[size0][size0];
		chessBoard = new boolean[size0][size0];
		chessBoard[0][0]=false;
		chessBoard[7][7]=false;
		for (int i=0;i<size0;i++) 
			for (int j=0;j<size0;j++) {
				Player1[i][j]=true;
				Player2[i][j]=true;
			}
	}
	public int getSize () {
		return size0;
	}
	public static boolean checkBoardBorder(int i, int j) {
		return ((i>0) || (i<7) || (j>0) || (j<7));
	}
	public static boolean checkPosition (boolean[][]b,int i,int j) {
		return ((chessBoard[i][j]) && (b[i][j]) && checkBoardBorder(i,j));
	}
	public static void setPosition(boolean[][]a,boolean[][]b, int i, int j) {
		if (checkPosition(b,i,j)) {
			chessBoard[i][j]=false;
			if (checkBoardBorder(i+1,j+2)) a[i+1][j+2]=false;
			if (checkBoardBorder(i+1,j-2)) a[i+1][j-2]=false;
			if (checkBoardBorder(i-1,j+2)) a[i-1][j+2]=false;
			if (checkBoardBorder(i-1,j-2)) a[i-1][j-2]=false;
			if (checkBoardBorder(i+2,j+1)) a[i+2][j+1]=false;
			if (checkBoardBorder(i+2,j-1)) a[i+2][j-1]=false;
			if (checkBoardBorder(i-2,j+1)) a[i-2][j+1]=false;
			if (checkBoardBorder(i-2,j-1)) a[i-2][j-1]=false;
		}
	}
	
	public static boolean dontHaveSpace(boolean[][]a) {
		for (int i=0; i<size0;i++) 
			for (int j=0;j<size0;j++) {
				if (a[i][j] && chessBoard[i][j]) return false;
			}
		return true;
	}
	public static void setTwoKnights(boolean[][] a,boolean[][] b,int i, int j) {
		
		setPosition(a,b,i,j);
		int x=7-i;
		int y=7-j;
		setPosition(b,a,x,y);
	}
	
	public static void main (String[] args) {
		
		//set animation 
		StdDraw.setXscale(-8,8);
		StdDraw.setYscale(-8,8);
		StdDraw.picture(0,0,"resources/chessBoard.gif",16,16);
		StdDraw.picture(1,1,"resources/chessKnight.png",1.6,1.6);
		init();
		while (true) {
			int i = (int)Math.floor(Math.random()*7);
			int j = (int)Math.floor(Math.random()*7);
			setTwoKnights(Player1,Player2,i,j);
			if (!chessBoard[i][j]) StdDraw.picture(i, j, "resources/chessKnight.png",1.6,1.6);
			if (dontHaveSpace(Player2)) {
				StdOut.println("Player 1 wins");
				break;
			}
			if (dontHaveSpace(Player1)) {
				StdOut.println("Player 2 wins");
				break;
			}
		for (int i=0; i<=5;i++) {
			for (int j=0;j<=5;j++) {
				System.out.println(b[i][j]);
				
			}
		}
		if (i=j) {
			
		}
		}
		}
	
}
	
	
	