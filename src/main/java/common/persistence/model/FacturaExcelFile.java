 

package common.persistence.model;


/**
 * @author @Roberto Rodriguez :: <RobertoSoftwareEngineer@gmail.com>
 */

public class FacturaExcelFile extends ExcelFile{
    private String dateStart;
    private String dateEnd;
    private String lastFacturaDate = "";


    /**
     * @return the dateStart
     */
    public String getDateStart() {
        return dateStart;
    }

    /**
     * @param dateStart the dateStart to set
     */
    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * @return the dateEnd
     */
    public String getDateEnd() {
        return dateEnd;
    }

    /**
     * @param dateEnd the dateEnd to set
     */
    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * @return the lastFacturaDate
     */
    public String getLastFacturaDate() {
        return lastFacturaDate;
    }

    /**
     * @param lastFacturaDate the lastFacturaDate to set
     */
    public void setLastFacturaDate(String lastFacturaDate) {
        this.lastFacturaDate = lastFacturaDate;
    }
}
