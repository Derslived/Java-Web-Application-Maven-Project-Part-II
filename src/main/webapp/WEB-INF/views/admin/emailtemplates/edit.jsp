<%-- 
    Document   : add
    Created on : Jul 3, 2019, 10:18:57 PM
    Author     : Derslived
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit Email Template!</h1>
        <form action="" method="post">
            <div>
                <label>Title</label>
                <input type="text" name="title" required=""  value="${template.title}" />
            </div>
               <div>
                <label>Slug</label>
                <input type="text" name="slug" required="" value="${template.slug}" />
            </div>
               <div>
                <label>Subject</label>
                <input type="text" name="subject" required=""  value="${template.subject}"/>
            </div>
               <div>
                <label>Body</label>
                <textarea name="body"  required="">${template.body}</textarea> 
            </div>
            <input type="hidden" name="id" value ="${template.id}" />
            <button type="submit">Save</button>
            <a href="${pageContext.request.contextPath}/admin/emailtemplates">Back </a>
        </form>
        
    </body>
</html>
