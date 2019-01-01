<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body>
        <%
            Cookie[] cks = request.getCookies();
            if (cks == null) {
                response.sendRedirect("sessionExpired.html");
                return; // to stop further execution
            }

        %>
        <h3>Ba?ar?l? giri? yapt?n?z. 	${cookie['username'].value} ${cookie['role'].value} ${cookie['unreadMessageCount'].value}</h3><br>
        your session is set to expire in 10min<br>
        try reloading after 10 min <br>
        <form action="Logout" method="post">
            <input type="submit" value="Logout">
        </form>
        <%!
            String getKookieValue(Cookie[] cookies, String cookieName) {
                {
                    String cookieValue = "";
                    Cookie cookie;
                    if (cookies != null) {
                        for (int i = 0; i < cookies.length; i++) {
                            cookie = cookies[i];
                            if (cookieName.equals(cookie.getName())) {
                                cookieValue = cookie.getValue();
                            }
                        }
                    }
                    return cookieValue;
                }
            }


        %>

        <%            String role = getKookieValue(request.getCookies(), "role");//içeri admin girince appointment gir.
            if (role.equals("Admin")) {
        %>
        <a href="/Appointment">Appointment</a>
        <%
            }%>

    </body>
</html>