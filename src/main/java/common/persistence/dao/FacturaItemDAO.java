package common.persistence.dao;

import common.display.ReportItem;
import common.persistence.domain.Factura;
import common.persistence.domain.FacturaItem;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class FacturaItemDAO extends BaseDAO<FacturaItem, Long> {

    public List<ReportItem> list(Long facturaId) { 
        
        Criteria criteria = getCriteria().createAlias("factura", "factura") .createAlias("factura.store", "store")
                .add(Restrictions.eq("factura.id", facturaId));

        ProjectionList projectionList = Projections.projectionList() 
                .add(Projections.property("quantity").as("quantity"))
                .add(Projections.property("store.loginId").as("loginId"))
                .add(Projections.property("product").as("product"))
                .add(Projections.property("commission").as("commission"))
                .add(Projections.property("sales").as("sales"))
                .add(Projections.property("net2pay").as("net2pay"))
                .add(Projections.property("freeDollar").as("freeDollar"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(ReportItem.class));

        return criteria.list();
    }
    
    public void deleteItems(Factura factura){
        List<FacturaItem> items = getCriteria()
                .createAlias("factura", "factura")
                .add(Restrictions.eq("id", factura.getId()))
                .list();
        
        for (FacturaItem item : items) {
            delete(item);
        }
    }
}
