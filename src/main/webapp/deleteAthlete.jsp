<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <title>Delete</title>

    </head>

    <body>
        <h1>Delete athlete</h1>
        <div>
            <% if (request.getAttribute("deletedAthlete") !=null) { out.println("<p>Athlete '" +
                request.getAttribute("deletedAthlete") + "' expelled from sportschool</p>");
                }
                %>
                <div>
                    <form method="post">
                        <label>Please specify id for expelling athlete:
                            <input type="text" name="id"><br />
                        </label>
                        <button type="submit">Submit</button>
                    </form>
                </div>
        </div>
        <div>
            <button onclick="location.href='/jdbc_servlets'">Back to main</button>
        </div>
    </body>

    </html>