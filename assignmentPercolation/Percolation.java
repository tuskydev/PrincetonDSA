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
    } else if (!beginning && n >= size || !beginning && n < 0) {
      throw new IllegalArgumentException("Row and Columns input too low/high!");
    }
  }

  private int xyTo1D(int x, int y) {
    System.out.println((x - 1) * size + y + " !!!");
    return (x - 1) * size + y;
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
    checkNumForErrors(row - 1, false);
    checkNumForErrors(col - 1, false);

    if (!isOpen(row, col)) {
      opened[row - 1][col - 1] = true;
      openSites++;
    }

    // Connecting Top and Bottom Virtual Cells if in first/last row
    if (col == 1) {
      System.out.println("eeeee");
      qf.union(xyTo1D(row, col), top);
    } else if (col == size) {
      System.out.println("AHHHHHHHHHHHHHHHHHHHH");
      qf.union(xyTo1D(row, col), bottom);
    }

    // Checking & Connecting Cells if open
    if (col > 1 && isOpen(row, col - 1)) {                  // Top
      System.out.println("TOP!! ");
      qf.union(xyTo1D(row, col), xyTo1D(row, col - 1));
    }

    // if (row < size - 1 && isOpen(row + 1, col)) {           // Bottom
    //   System.out.println("BOTTOM!! ");
    //   qf.union(xyTo1D(row + 1, col), xyTo1D(row, col));
    // }

    // if (col > 1 && isOpen(row, col - 1)) {                  // Left
    //   System.out.println("LEFT!! ");
    //   qf.union(xyTo1D(row, col), xyTo1D(row, col - 1));
    // }

    // if (col < size - 1 && isOpen(row, col + 1)) {           // Right
    //   System.out.println("RIGHT!! ");
    //   qf.union(xyTo1D(row, col), xyTo1D(row, col + 1));
    // }

  }

  // is the site (row, col) open?
  public boolean isOpen(int row, int col) {
    checkNumForErrors(row - 1, false);
    checkNumForErrors(col - 1, false);

    if (opened[row - 1][col - 1]) {
      return true;
    } else{
      return false;
    }
  }

  // is the site (row, col) full?
  public boolean isFull(int row, int col) {
    checkNumForErrors(row - 1, false);
    checkNumForErrors(col - 1, false);

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
    System.out.println(qf.find(bottom));
    System.out.println(qf.find(top));
    if (qf.find(bottom) == qf.find(top)) {
      return true;
    } else {
      return false;
    }
  }

  // test client (optional)
  public static void main(String[] args) {
    Percolation perc = new Percolation(StdIn.readInt());

    while (!perc.percolates()) {
      System.out.println("             ");
      System.out.println("Number of open sites: " + perc.numberOfOpenSites());
      perc.open(StdIn.readInt(), StdIn.readInt());
    }

    System.out.println("Hello world!");
  }
}