package a1;
import java.util.Random;

/**
 * Assignment1 Sudoku is to demonstrate your mastery of recursion 
 * by generating a sudoku puzzle using a recursive algorithm.
 * 
 * @author liumeiling
 *
 */

public class Sudoku {
	protected int[][] board;
	protected int num;
	
	Random random = new Random();

	/**
	 * Constructor: create a board of any size.
     * @param size
	 */
	public Sudoku(int size) {
		num = size;
		board = new int[num][num];
	}

	/**
	 * print Fence
	 */
	public void printBoard() {
		for (int i = 0; i < num; i++) {
			if(i % 3 == 0) {
            		System.out.println(" -----------------------------");
            }
            for (int j = 0; j < num; j++) {
	            	if (j % 3 == 0) {
	    				System.out.print("|");
	    			}
            		System.out.print(" " + board[i][j] + " ");
            }
            System.out.print("|");
            System.out.println(); 
        }		
        System.out.println(" -----------------------------");
	}
	
	public boolean fillBoard() {
		return fillBoard(0,0);
	}
	
	protected boolean fillBoard(int row, int col) {
		// out of loop; tracking actual row and col
		if (col == 9) {
		    col = 0;
		    if (++row == 9)  return true; 
		}
		// base case
		if(col >= this.num) return true;
		for(int i = 0; i < this.num; i++) {	// loop 9 times, not represent actual row!
			int inputNum = random.nextInt(this.num) + 1;
			//System.out.println("intitial board: r & c " + "(" + row + ", " + col + ")");
			
			//Notes: if (safeToFill(i, col, inputNum))
			// 		wrong!, here i represent ith time, although the same num of row
			//				but after backtracking, i will +1 but row not change
			
            if (safeToFill(row, col, inputNum)) {
            	//System.out.println("Starting checking...");
            		board[row][col] = inputNum;
            	//System.out.println("filled board: r & c " + "(" + row + ", " + col + ")");
                
                	if (fillBoard(row, col+1)) return true;
                
            }
            board[row][col] = 0;
            //System.out.println("Start backtracing...");
		}
			
        return false;
	}

	protected boolean safeToFill(int row, int col, int inputNum) {
		//check row
		for (int i = 0; i < this.num; i++) {
			if (board[row][i] == inputNum){
				return false;
			}
		}
		//check col
		for (int j = 0; j < this.num; j++) {
			if (board[j][col] == inputNum) {
				return false;
			}
		}
		//check subgrib
		for(int a = 0; a < this.num/3; a++) {
			for(int b = 0; b < this.num/3; b++) {
				if(inputNum == board[(row/(this.num/3))*this.num/3 +a]
									[(col/(this.num/3))*this.num/3 +b]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Sudoku sudoku = new Sudoku(9);
	
		if(sudoku.fillBoard()) {
			sudoku.printBoard();
		} else {
        		System.out.println("Solution does not exist.");
		}
	}
}
