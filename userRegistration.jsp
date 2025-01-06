<%@ page contentType="text/html" %>
<html>
<body>
    <h1>User Registration</h1>
    <form action="UserServlet" method="post">
        Name: <input type="text" name="name" required><br>
        Email: <input type="email" name="email" required><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
