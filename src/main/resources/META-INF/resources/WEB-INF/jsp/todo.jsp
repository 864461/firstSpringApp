<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--<html>--%>
<%--<head>--%>
<%--    <title>Add To Do</title>--%>
<%--    <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
<%--    <h1>Enter To Do Details</h1>--%>
<%--        <form:form method="post" modelAttribute="todo">--%>
<%--        <form:form method="post" modelAttribute="todo">--%>
<%--    Description: <form:input type="text" path="description" required="required"/>--%>
<%--        <form:errors path="description" cssClass="text-warning"/>--%>

<%--        <form:input type="hidden" path="id"/>--%>
<%--        <form:input type="hidden" path="done"/>--%>

<%--    <input type="submit" class="btn btn-success">--%>
<%--    </form:form>--%>
<%--</div>--%>
<%--<script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>--%>
<%--<script src="webjars\jquery\3.6.0\jquery.min.js"></script>--%>

<%--</body>--%>
<%--</html>--%>


<%--<%@ include file="common/header.jspf" %>--%>
<%--<%@ include file="common/navigation.jspf" %>--%>

<div class="container">

    <h1>Enter Todo Details</h1>


    <form:form method="post" modelAttribute="todo">

    <form:label path="description">Description</form:label>
            <form:input type="text" path="description" required="required"/>
             <form:errors path="description" cssClass="text-warning"/>

        <form:input type="hidden" path="id"/>



        <form:input type="hidden" path="done"/>

        <input type="submit" class="btn btn-success"/>

    </form:form>

</div>

<%--<%@ include file="common/footer.jspf" %>--%>

<%--<script type="text/javascript">--%>
<%--    $('#targetDate').datepicker({--%>
<%--        format: 'yyyy-mm-dd'--%>
<%--    });--%>
<%--</script>--%>