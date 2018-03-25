package common.util;

import java.io.Serializable;
import java.util.LinkedHashMap;  
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
 

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionData extends LinkedHashMap implements Serializable {
 
}
