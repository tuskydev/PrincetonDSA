import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
  private Object[][][] grid;

  // creates n-by-n grid, with all sites initially blocked
  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("Grid size must be greater than 0");
    }

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
    if (row > grid[0].length) {
      throw new IllegalArgumentException("ROW outside prescribed range");
    }
    if (col > grid[0].length) {
      throw new IllegalArgumentException("COL outside prescribed range");
    }


  }

  // // is the site (row, col) open?
  // public boolean isOpen(int row, int col) {
  //   if (row > grid[0].length) {
  //     throw new IllegalArgumentException("ROW outside prescribed range");
  //   }
  //   if (col > grid[0].length) {
  //     throw new IllegalArgumentException("COL outside prescribed range");
  //   }
  // }

  // // is the site (row, col) full?
  // public boolean isFull(int row, int col) {
  //   if (row > grid[0].length) {
  //     throw new IllegalArgumentException("ROW outside prescribed range");
  //   }
  //   if (col > grid[0].length) {
  //     throw new IllegalArgumentException("COL outside prescribed range");
  //   }
  // }

  // // returns the number of open sites
  // public int numberOfOpenSites() {

  // }

  // // does the system percolate?
  // public boolean percolates() {

  // }

  // test client (optional)
  public static void main(String[] args) {
    Percolation perc = new Percolation(StdIn.readInt());
  }
}
