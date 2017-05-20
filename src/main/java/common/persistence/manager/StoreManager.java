package common.persistence.manager;

import common.display.StoreDTO;
import common.persistence.dao.StoreDAO;
import common.persistence.domain.Store;
import common.util.GridData;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author @Roberto Rodriguez :: <RobertoSoftwareEngineer@gmail.com>
 */
@Service
public class StoreManager {

    @Autowired
    private StoreDAO storeDAO;

    public void saveBatch(List<Store> list) {
        for (Store store : list) {
            Store persistentStore = storeDAO.getStoreByLoginId(store.getLoginId());

            if (persistentStore != null) {
                persistentStore.setAddress(store.getAddress());
                persistentStore.setEmail(store.getEmail());
                persistentStore.setLastName(store.getLastName());
                persistentStore.setName(store.getName());
                persistentStore.setPhone(store.getPhone());
                persistentStore.setCreationDate(store.getCreationDate());
                storeDAO.saveOrUpdate(persistentStore);
            } else {
                storeDAO.saveOrUpdate(store);
            }
        }
    }

    public GridData<StoreDTO> list(Integer rows, Integer page) {
        return storeDAO.list(rows, page);
    }

    public Store getStoreByLoginId(String loginId) {
        return storeDAO.getStoreByLoginId(loginId);
    }
}
