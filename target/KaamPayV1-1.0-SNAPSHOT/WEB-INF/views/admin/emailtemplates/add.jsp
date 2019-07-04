<%-- 
    Document   : index
    Created on : Jul 2, 2019, 2:50:17 PM
    Author     : Derslived
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Add Email Templates!</h1>
       <form action="" method="post">
            <div>
                <label>Title</label>
                <input type="text" name="title" required="" />
            </div>
               <div>
                <label>Slug</label>
                <input type="text" name="slug" required="" />
            </div>
               <div>
                <label>Subject</label>
                <input type="text" name="subject" required="" />
            </div>
               <div>
                <label>Body</label>
                <textarea name="body"  required=""></textarea> 
            </div>
            <button type="submit">Save</button>
            <a href="${pageContext.request.contextPath}/admin/emailtemplates">Back </a>
        </form>
        
   
</body>
</html>
