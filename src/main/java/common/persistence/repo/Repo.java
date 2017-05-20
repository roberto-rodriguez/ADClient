 

package common.persistence.repo;

import common.display.Report;
import java.io.Serializable;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


/**
 * @author @Roberto Rodriguez :: <RobertoSoftwareEngineer@gmail.com>
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS) 
public class Repo implements Serializable{
    private List<Report> reports = null;

    /**
     * @return the reports
     */
    public List<Report> getReports() {
        return reports;
    }

    /**
     * @param reports the reports to set
     */
    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
