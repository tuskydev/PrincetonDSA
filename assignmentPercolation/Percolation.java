import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
  private int[][] grid;
  private int size;
  private WeightedQuickUnionUF qf;

  private void checkForError(int n) {
    if (n <= grid.length) {
      throw new IllegalArgumentException();
    }
  }

  // creates n-by-n grid, with all sites initially blocked
  public Percolation(int n) {
    size = n;
    qf = new WeightedQuickUnionUF(size * size * 2);
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