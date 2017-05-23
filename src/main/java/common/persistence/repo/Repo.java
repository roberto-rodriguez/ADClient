 

package common.persistence.repo;
 
import common.persistence.model.Pais;
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
    private List<Pais> config;

    /**
     * @return the config
     */
    public List<Pais> getConfig() {
        return config;
    }

    /**
     * @param config the config to set
     */
    public void setConfig(List<Pais> config) {
        this.config = config;
    }

    
}
