package common.persistence.dao;

import common.display.Report;
import common.display.ReportItem;
import common.persistence.domain.Factura;
import common.util.GridData;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria; 
import org.hibernate.SQLQuery; 
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class FacturaDAO extends BaseDAO<Factura, Long> {
    @Autowired
    private FacturaItemDAO facturaItemDAO;

    public GridData<Report> list(Integer rows, Integer page, String clientId, Date startDate, Date endDate) {
        GridData<Report> data = new GridData<>();
        Criteria criteria = getCriteria().createAlias("store", "store");

        int firstResult = (page - 1) * rows;
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(rows * page);


        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("store.loginId").as("clientId"))
                .add(Projections.property("id").as("facturaId"))
                .add(Projections.property("sales").as("sales"))
                .add(Projections.property("salesPromotion").as("salesPromotion"))
                .add(Projections.property("net2pay").as("net2pay"))
                .add(Projections.property("startDate").as("startDate"))
                .add(Projections.property("endDate").as("endDate"))
                .add(Projections.property("commission").as("commission"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(Report.class));

        addRestrictions(criteria, clientId, startDate, endDate);
        
        criteria.addOrder(Order.desc("startDate"));

        data.setRows(criteria.list());

        Criteria countCriteria = getCriteria().createAlias("store", "store");
        addRestrictions(countCriteria, clientId, startDate, endDate);
        Long total = (Long) countCriteria.setProjection(Projections.rowCount()).uniqueResult();

        data.setRecords(total);
        Long pages = total / rows;
        if (total % rows != 0) {
            pages++;
        }

        data.setTotal(pages.intValue());
        data.setPage(page);
        return data;
    }

    private void addRestrictions(Criteria criteria, String clientId, Date startDate, Date endDate) {
        LogicalExpression startDateDisjunction = Restrictions.or(
                Restrictions.ge("startDate", startDate),
                Restrictions.ge("endDate", startDate)
        );

        LogicalExpression endDateDisjunction = Restrictions.or(
                Restrictions.le("startDate", endDate),
                Restrictions.le("endDate", endDate)
        );

        if (startDate != null) {
            criteria.add(startDateDisjunction);
        }

        if (endDate != null) {
            criteria.add(endDateDisjunction);
        }

        if (clientId != null && !clientId.isEmpty()) {
            criteria.add(Restrictions.eq("store.loginId", clientId.trim()));
        }
    }

    public ReportItem getById(Long id) {
        Criteria criteria = getCriteria()
                .createAlias("store", "store")
                .add(Restrictions.eq("id", id))
                .setMaxResults(1);

        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("salesPromotion").as("totalSalesPromotion"))
                .add(Projections.property("net2pay").as("totalNet2Pay"))
                .add(Projections.property("commission").as("totalCommission"))
                .add(Projections.property("quantity").as("totalQuantity"))
                .add(Projections.property("creationDate").as("reportDate"))
                .add(Projections.property("number").as("reportNumber"))
                .add(Projections.property("sales").as("totalSales"))
                .add(Projections.property("store.name").as("name"))
                .add(Projections.property("store.lastName").as("lastName"))
                .add(Projections.property("startDate").as("startDate"))
                .add(Projections.property("endDate").as("endDate"))
                .add(Projections.property("quantityPurchaseBalance").as("quantityPurchaseBalance"))
                .add(Projections.property("purchaseBalance").as("purchaseBalance"))
                .add(Projections.property("store.address").as("storeAddress"));
 
        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(ReportItem.class));

        return (ReportItem) criteria.uniqueResult();
    }

    public Date getMaxDate() {
        SQLQuery query = getSession().createSQLQuery("select max(end_date) from factura limit 1");

        return (Date) query.uniqueResult();
    }

    public void deleteByRange(Date startDate, Date endDate) {
        //Delete factura items
        Criteria criteria = getCriteria();
        addRestrictions( criteria, null,  startDate,  endDate);
            
        List<Factura> list = criteria.list();
        
        System.out.println("Will override " + list.size() + " facturas.");
        
        for (Factura factura : list) {
            facturaItemDAO.deleteItems(factura);
            delete(factura);
        }
    }
     
      public List<Report> resumen(String clientId, Date startDate, Date endDate) { 
        Criteria criteria = getCriteria().createAlias("store", "store");
  
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("store.loginId").as("clientId")) 
                .add(Projections.property("sales").as("sales"))
                .add(Projections.property("salesPromotion").as("salesPromotion"))
                .add(Projections.property("net2pay").as("net2pay"))
                .add(Projections.property("startDate").as("startDate"))
                .add(Projections.property("endDate").as("endDate"))
                .add(Projections.property("commission").as("commission"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(Report.class));

        addRestrictions(criteria, clientId, startDate, endDate);
        
        criteria.addOrder(Order.desc("startDate"));

        return criteria.list(); 
    }
}
