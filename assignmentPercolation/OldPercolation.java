import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class OldPercolation {
  private Object[][][] grid;
  private Object[][][] topNode;
  private Object[][][] bottomNode;

  private void checkNumForErrors(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("Grid size, or row/col number is too small. Try Again!");
    }
  }

  // creates n-by-n grid, with all sites initially blocked
  public OldPercolation(int n) {
    checkNumForErrors(n);

    // Virtual Top Node
    topNode = new Object[1][1][3];
    topNode[0][0][0] = true; // Flow is set false
    topNode[0][0][1] = -1;   // Value of cell
    topNode[0][0][2] = -1;   // Root value (starts rooted to itself)

    // Virtual Bottom Node
    bottomNode = new Object[1][1][3];
    bottomNode[0][0][0] = false; // Flow is set false
    bottomNode[0][0][1] = n;     // Value of cell
    bottomNode[0][0][2] = n;     // Root value (starts rooted to itself)

    grid = new Object[n][n][3];
    int counter = 0;

    for (int i = 0; i < n; i++) {
      for (int e = 0; e < n; e++) {
        grid[i][e][0] = false;       // Flow is set false
        grid[i][e][1] = counter;     // Value of cell
        grid[i][e][2] = counter;     // Root value (starts rooted to itself)
        counter++;
      }
    }
  }

  // opens the site (row, col) if it is not open already
  public void open(int row, int col) {
    checkNumForErrors(row--);
    checkNumForErrors(col--);

    grid[row][col][0] = true;
    System.out.println(grid[row][col][0] = true);
  }

  // is the site (row, col) open?
  public boolean isOpen(int row, int col) {
    checkNumForErrors(row--);
    checkNumForErrors(col--);

    if ((boolean) grid[row][col][0] == true) {
      return true;
    } else {
      return false;
    }
  }

  // is the site (row, col) full?
  public boolean isFull(int row, int col) {
    checkNumForErrors(row--);
    checkNumForErrors(col--);

    if ((int) grid[row][col][2] == -1) {
      return true;
    } else {
      return false;
    }
  }

  // returns the number of open sites
  public int numberOfOpenSites() {
    int counter = 0;

    for (int i = 0; i < grid[0].length; i++) {
      for (int e = 0; e < grid[0].length; e++) {
        if ((boolean) grid[i][e][0]) {
          counter++;
        }
      }
    }

    return counter;
  }

  // does the system percolate?
  public boolean percolates() {
    if ((int) bottomNode[0][0][2] == -1) {
      return true;
    } else{
      return false;
    }
  }

  // test client (optional)
  public static void main(String[] args) {
    OldPercolation perc = new OldPercolation(StdIn.readInt());
  }
}
