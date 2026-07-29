<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Two Number Input Form</title>

    <!-- Link Tag for CSS -->
    <link rel="stylesheet" href="style.css">
</head>

<body>

    <div class="container">
            <h2>Add User Info</h2>

                <form action="usingModelAttribute" method="post">

                    <label for="id">ID Number</label>
                    <input type="text" id="id" name="id" required>

                    <label for="name">Name</label>
                    <input type="text" id="name" name="name" >

                    <button type="submit">Submit</button>

              </form>
    </div>
</body>
</html>

