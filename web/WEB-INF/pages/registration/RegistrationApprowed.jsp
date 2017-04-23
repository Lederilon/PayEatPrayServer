<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration Approved</title>
</head>
<body>
Registration Approved for<%=((domain.Profile)session.getAttribute("profile")).getName()%>
usertype  <%=((domain.Profile)session.getAttribute("profile")).getCategory().toString()%>
</body>
</html>