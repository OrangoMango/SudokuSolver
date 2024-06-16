import java.util.Random;
import java.io.*;

public class SudokuSolver{
	private static int GRID_SIZE, SUBGRID_SIZE;

	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		while (flag){
			System.out.print("GRID_SIZE: ");
			GRID_SIZE = Integer.parseInt(reader.readLine());
			System.out.print("SUBGRID_SIZE: ");
			SUBGRID_SIZE = Integer.parseInt(reader.readLine());

			int[][] grid = new int[GRID_SIZE*SUBGRID_SIZE][GRID_SIZE*SUBGRID_SIZE];

			System.out.print("Fill the grid? (Y/N): ");
			String fill = reader.readLine();
			if (fill.toLowerCase().equals("y")){
				for (int i = 0; i < GRID_SIZE*SUBGRID_SIZE; i++){
					String line = reader.readLine();
					String[] pieces = line.split(" ");
					for (int j = 0; j < pieces.length; j++){
						int x = Integer.parseInt(pieces[j]);
						grid[i][j] = x;
					}
				}
				System.out.println();
			}

			boolean result = solve(grid, 0, 0);

			if (result){
				printGrid(grid);
			} else {
				System.out.println("Could not find a solution");
			}

			System.out.print("Continue? (Y/N): ");
			String ans = reader.readLine();
			if (!ans.toLowerCase().equals("y")){
				flag = false;
			}
		}
	}

	private static void printGrid(int[][] grid){
		for (int y = 0; y < SUBGRID_SIZE*GRID_SIZE; y++){
			for (int x = 0; x < SUBGRID_SIZE*GRID_SIZE; x++){
				System.out.format("%02d ", grid[y][x]);
				if ((x+1) % SUBGRID_SIZE == 0) System.out.print(" ");
			}
			System.out.println();
			if ((y+1) % SUBGRID_SIZE == 0) System.out.println();
		}
	}

	private static boolean solve(int[][] grid, int r, int c){
		if (r == SUBGRID_SIZE*GRID_SIZE){
			return true;
		} else if (c == SUBGRID_SIZE*GRID_SIZE){
			return solve(grid, r+1, 0);
		} else if (grid[r][c] != 0){
			return solve(grid, r, c+1);
		} else {
			Random random = new Random();
			int[] n = new int[SUBGRID_SIZE*SUBGRID_SIZE];
			for (int i = 1; i < n.length+1; i++){
				n[i-1] = i;
			}

			for (int i = 0; i < n.length; i++){
				int idx = random.nextInt(n.length);
				int temp = n[idx];
				n[idx] = n[i];
				n[i] = temp;
			}

			for (int k = 0; k < n.length; k++){
				if (isValid(grid, r, c, n[k])){
					grid[r][c] = n[k];
					if (solve(grid, r, c+1)){
						return true;
					}
					grid[r][c] = 0;
				}
			}

			return false;
		}
	}

	private static boolean isValid(int[][] grid, int r, int c, int k){
		// Not in the same row
		for (int i = 0; i < SUBGRID_SIZE*GRID_SIZE; i++){
			if (grid[r][i] == k){
				return false;
			}
		}

		// Not in the same column
		for (int i = 0; i < SUBGRID_SIZE*GRID_SIZE; i++){
			if (grid[i][c] == k){
				return false;
			}
		}

		// Not in the same subgrid
		int sx = r / GRID_SIZE;
		int sy = c / GRID_SIZE;
		for (int i = sx*SUBGRID_SIZE; i < sx*SUBGRID_SIZE+SUBGRID_SIZE; i++){
			for (int j = sy*SUBGRID_SIZE; j < sy*SUBGRID_SIZE+SUBGRID_SIZE; j++){
				if (grid[i][j] == k){
					return false;
				}
			}
		}

		return true;
	}
}
