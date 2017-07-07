<%@ taglib uri="/WEB-INF/listTag.tld" prefix="m" %>  
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page isELIgnored="false"%>

<h2>ArrayList Displayed as Table via Custoem Tag</h2>
<m:listDisplay list="${employeeList}"></m:listDisplay>