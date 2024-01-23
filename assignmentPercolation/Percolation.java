import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
  private final int size;
  private final int top;
  private final int bottom;
  private int openSites;
  private boolean[][] opened;
  private WeightedQuickUnionUF qf;

  private void checkNumForErrors(int n, boolean beginning) {
    if (beginning && n <= 0) {
      throw new IllegalArgumentException("Grid size must be greater than 0.");
    } else if (!beginning && n > size || !beginning && n <= 0) {
      throw new IllegalArgumentException("Row and Columns input too low/high!");
    }
  }

  private int xyTo1D(int x, int y) {
    return size * x + y + 1;
  }

  // creates n-by-n grid, with all sites initially blocked
  public Percolation(int n) {
    checkNumForErrors(n, true);

    size = n;
    top = 0;
    bottom = size * size + 1;
    openSites = 0;
    opened = new boolean[size][size];
    qf = new WeightedQuickUnionUF(size * size + 2);
  }

  // opens the site (row, col) if it is not open already
  public void open(int row, int col) {
    checkNumForErrors(row--, false);
    checkNumForErrors(col--, false);

    opened[row][col] = true;
    openSites++;
  }

  // is the site (row, col) open?
  public boolean isOpen(int row, int col) {
    checkNumForErrors(row--, false);
    checkNumForErrors(col--, false);

    if (opened[row][col]) {
      return true;
    } else{
      return false;
    }
  }

  // is the site (row, col) full?
  public boolean isFull(int row, int col) {
    checkNumForErrors(row--, false);
    checkNumForErrors(col--, false);

    if (qf.find(xyTo1D(row, col)) == top) {
      return true;
    } else {
      return false;
    }
  }

  // returns the number of open sites
  public int numberOfOpenSites() {
    return openSites;
  }

  // does the system percolate?
  public boolean percolates() {
    if (qf.find(bottom) == top) {
      return true;
    } else {
      return false;
    }
  }

  // test client (optional)
  public static void main(String[] args) {
    Percolation perc = new Percolation(StdIn.readInt());
  }
}