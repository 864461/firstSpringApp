<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

        <div class="container">
            <hr>
            <H1>Your To Dos are</H1>
            <table class="table">
                <thead>
<%--                    <th>id</th>--%>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is Done</th>
                    <th></th>
                    <th></th>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
<%--                            <td>${todo.id}</td>--%>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                            <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
                            <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
            </table>
            <a href="add-todo" class="btn btn-success">Add To do </a>
        </div>