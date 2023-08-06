<html>
<head>
	<title>Servlet and JSP</title>
</head>
<body>
	<h2>Demo User Entry with Servlet and JSP</h2>
	<h3>Add New User</h3>
    <form action="User" method="post">
    	<label for="id">Enter ID:</label>
        <input type="text" id="id" name="u_id">
        <br>
        <label for="name">Enter Name:</label>
        <input type="text" id="name" name="u_name">
        <br>
        <p>Select Status:</p>
        <input type="radio" id="active" name="isActive" value="true">
        <label for="active">Active</label>
        <br>
        <input type="radio" id="inactive" name="isActive" value="false">
        <label for="inactive">Inactive</label>
        <br><br>
        <input type="submit">
    </form>
    
    <h3>User Search</h3>
    <form action="User">
    	<label for="search">Enter user ID to search : </label>
        <input type="text" id="search" name="u_id_search">
        <input type="submit">
    </form>
	
</body>
</html>
