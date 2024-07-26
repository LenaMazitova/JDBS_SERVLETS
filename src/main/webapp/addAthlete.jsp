<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <title>Add</title>

    </head>

    <body>
        <h1>Add athlete</h1>
        <div>
            <% if (request.getAttribute("athleteName") !=null && request.getAttribute("athleteSurname") !=null) {
                out.println("<p>Athlete '" + request.getAttribute("athleteName") + "' '" +
                request.getAttribute("athleteSurname") + "' added!</p>");
                }
                %>
                <div>
                    <form method="post">
                        <label>Name:
                            <input type="text" name="name"><br />
                        </label>
                        <label>Surname:
                            <input type="text" name="surname"><br />
                        </label>
                        <label>Define coach register number(1 - Johnson, 2 - Limpson, 3 - Borch, 4 - Daw, 5 - Binner):
                            <input type="text" name="coach_id"><br />
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