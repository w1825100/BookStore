package domain;

import java.util.List;
public class  Page<T> {
    private  Integer pageNo;
    private  Integer pageTotal;
    private  Integer pageSize;
    private  List<T> items;
    private  Integer totalCount;
    private  String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", items=" + items +
                ", totalCount=" + totalCount +
                ", url='" + url + '\'' +
                '}';
    }

    public Page() {
    }

    public Page(Integer pageNo, Integer pageTotal, Integer pageSize, List<T> items, Integer totalCount) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageSize = pageSize;
        this.items = items;
        this.totalCount = totalCount;
    }
}
