<html>
<body>
<% request.getSession(false); %>
<h1>Sign in, please</h1>
<h2><form name="input" action="/path" method="POST">
    Login:<input type="text" name="login"><br/>
    Password:<input type="password" name="password"><br/>
    <input type="submit" value="OK">

</form> </h2>
</body>
</html>
