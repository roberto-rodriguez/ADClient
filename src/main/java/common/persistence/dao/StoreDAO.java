package common.persistence.dao;
 
import common.display.StoreDTO;
import common.persistence.domain.Store;
import common.util.GridData; 
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StoreDAO extends BaseDAO<Store, Long> {

    public Store getStoreByLoginId(String loginId) {
        return (Store) getCriteria().add(Restrictions.eq("loginId", loginId))
                .setMaxResults(1).uniqueResult();
    }

    public GridData<StoreDTO> list(Integer rows, Integer page) {
        GridData<StoreDTO> data = new GridData<>();
        Criteria criteria = getCriteria();

        int firstResult = (page - 1) * rows;
        System.out.println("FirstResult = " + firstResult);
        System.out.println("MaxResults = " + (rows * page));
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(rows * page);

        criteria.addOrder(Order.asc("creationDate"));

        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("loginId").as("loginId"))
                .add(Projections.property("name").as("name"))
                .add(Projections.property("lastName").as("lastName"))
                .add(Projections.property("address").as("address"))
                .add(Projections.property("phone").as("phone"))
                .add(Projections.property("creationDate").as("creationDate"))
                .add(Projections.property("sendReport").as("sendReport"))
                .add(Projections.property("email").as("email"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(StoreDTO.class)); 

        data.setRows(criteria.list());

        Long total = (Long) getCriteria().setProjection(Projections.rowCount()).uniqueResult();

        data.setRecords(total); 
        Long pages = total / rows; 
        if (total % rows != 0) { 
            pages++; 
        }
 
        data.setTotal(pages.intValue());
        data.setPage(page);
        return data;
    }

    public void deleteAll() {
        getSession().createQuery("delete from Store").executeUpdate();
    }
}
