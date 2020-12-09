
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNo>1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>
    <c:choose>
        <c:when test="${requestScope.page.pageTotal<=5}">
            <c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
                <c:if test="${i==requestScope.page.pageNo}">
                    【${i}】
                </c:if>
                <c:if test="${i != requestScope.page.pageNo}">
                    <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>
        </c:when>
        <c:when test="${requestScope.page.pageTotal>=5&&requestScope.page.pageNo<=5}">
            <c:forEach begin="1" end="5" var="i">
                <c:if test="${i==requestScope.page.pageNo}">
                    【${i}】
                </c:if>
                <c:if test="${i != requestScope.page.pageNo}">
                    <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>
        </c:when>
        <c:when test="${requestScope.page.pageTotal>5&&requestScope.page.pageTotal-requestScope.page.pageNo<=5}">
            <c:forEach begin="${requestScope.page.pageTotal-5}" end="${requestScope.page.pageTotal}" var="i">
                <c:if test="${i==requestScope.page.pageNo}">
                    【${i}】
                </c:if>
                <c:if test="${i != requestScope.page.pageNo}">
                    <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>
        </c:when>
        <c:when test="${requestScope.page.pageNo>5&&requestScope.page.pageTotal-requestScope.page.pageNo>5}">
            <c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">
                <c:if test="${i==requestScope.page.pageNo}">
                    【${i}】
                </c:if>
                <c:if test="${i != requestScope.page.pageNo}">
                    <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>
        </c:when>
    </c:choose>
    <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${page.pageTotal}页，${requestScope.page.totalCount}条记录 到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input type="button" id="s2b" value="确定">
    <script type="text/javascript">
        $(function () {
            $("#s2b").click(function () {
                var pageNo=$("#pn_input").val();
                location.href="${pageScope.basePath}${requestScope.page.url}&pageNo="+pageNo;
            });
        });
    </script>
    </div>
</div>