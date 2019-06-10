package entity;

import java.util.List;

/**
 * @program: tensquare_parent
 * @description: 分页返回结果
 * @author: cf
 * @create: 2019-06-10 21:55
 */
public class PageResult<T> {

    private Long total;
    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
