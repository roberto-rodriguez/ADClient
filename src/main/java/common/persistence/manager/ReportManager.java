package common.persistence.manager;

import com.google.gson.Gson;
import common.persistence.dto.ResultList;
import common.persistence.dto.Transferencia;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author @Roberto Rodriguez :: <RobertoSoftwareEngineer@gmail.com>
 */
@Service
public class ReportManager {

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    public List<Transferencia> search(LinkedHashMap< String, String> request) {
        if (request.containsKey("codEnvio")
                && request.get("codEnvio") != null
                && !(request.get("codEnvio")).isEmpty()) {
            return searchByCode(request);
        } else {
            return searchByParams(request);
        }
    }

    private List<Transferencia> searchByCode(LinkedHashMap< String, String> request) {
        List<Transferencia> list = new ArrayList<>();

        String host = env.getProperty("adserver.url");

        String url = host + "alodiga/mobile/buscarPorCodigo?codEnvio=" + request.get("codEnvio");

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        String str = response.getBody();

        System.out.println("str = " + str);

        Gson gson = new Gson(); // Or use new GsonBuilder().create();

        Transferencia transferencia = gson.fromJson(str, Transferencia.class);

        if (transferencia != null) {
            list.add(transferencia);
        }
        return list;
    }

    private List<Transferencia> searchByParams(LinkedHashMap< String, String> request) {
        List<Transferencia> list = new ArrayList<>();

        String host = env.getProperty("adserver.url");

        String params = request.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.joining("&"));
        System.out.println("params... -> " + params);

        String url = host + "alodiga/mobile/buscar?agenciaOrigen=11502223&";
        url += params;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        String str = response.getBody();

        System.out.println("str = " + str);

        Gson gson = new Gson(); // Or use new GsonBuilder().create();

        ResultList resultList = gson.fromJson(str, ResultList.class);

        System.out.println("resultList = " + (resultList != null));

        if (resultList != null) {
            list = resultList.getList();
        }

        return list;
    }
}
