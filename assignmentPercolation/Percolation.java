import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
  private int[][] grid;
  private int size;
  private WeightedQuickUnionUF qf;

  private void checkForError(int n, boolean beginning) {
    if (beginning && n <= 0) {
      throw new IllegalArgumentException("Grid size must be greater than 0.");
    } else if (!beginning && n > size || !beginning && n <= 0) {
      throw new IllegalArgumentException("Row and Columns input too low/high!");
    }
  }

  private int xyTo1D(int x, int y) {      // We can swap int to a String!
    return Integer.parseInt(x +  "" + y);
  }

  // creates n-by-n grid, with all sites initially blocked
  public Percolation(int n) {
    checkForError(n, true);

    size = n;
    qf = new WeightedQuickUnionUF(size * size * 2);
    qf.Union();
  }

  // // opens the site (row, col) if it is not open already
  // public void open(int row, int col) {

  // }

  // // is the site (row, col) open?
  // public boolean isOpen(int row, int col) {

  // }

  // // is the site (row, col) full?
  // public boolean isFull(int row, int col) {

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