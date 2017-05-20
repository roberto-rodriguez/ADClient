package common.util.excel;

/**
 * @author @Roberto Rodriguez :: <RobertoSoftwareEngineer@gmail.com>
 */
public class Point {

    private int row, coll;

    public Point(int row, int coll) {
        this.row = row;
        this.coll = coll;
    }

    @Override
    public String toString() {
        return "[ row:" + row + ", coll:" + coll + " ]"; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the coll
     */
    public int getColl() {
        return coll;
    }

    /**
     * @param coll the coll to set
     */
    public void setColl(int coll) {
        this.coll = coll;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

}
