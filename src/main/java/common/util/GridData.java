/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.util;

/**
 *
 * @author Roberto Rodriguez :: <roberto.rodriguez@smartbt.com>
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class GridData<T> {

    /**
     * Total number of pages
     */
    private int total;
    /**
     * The current page number
     */
    private int page;
    /**
     * Total number of records
     */
    private long records;
    /**
     * The actual data
     */
    private List<T> rows;

    public GridData(int total, int page, long records, List<T> rows) {
        this.total = total;
        this.page = page;
        this.records = records;
        this.rows = rows;
    }

    public GridData() {
    }

    public String getJsonString() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);
        map.put("total", total);
        map.put("records", records);
        map.put("rows", rows);
        return JSONObject.valueToString(map);
    }

    public int getTotal() {
        return total;
    }

    public int getPage() {
        return page;
    }

    public long getRecords() {
        return records;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setRecords(long records) {
        this.records = records;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
