<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <title>Update</title>

    </head>

    <body>
        <h1>Update athlete. Fill in the fields:</h1>
        <div>
            <% if (request.getAttribute("name") !=null) { out.println("<p>Athlete '" +
                request.getAttribute("name") + "' updated!</p>");
                }
                %>
                <div>
                    <form method="post">
                        <label>Please specify id:
                            <input type="text" name="id"><br />
                        </label>
                        <label>Update name:
                            <input type="text" name="name"><br />
                        </label>
                        <label>Update surname:
                            <input type="text" name="surname"><br />
                        </label>
                        <label>Change the coach(define register number of coach(1-5)):
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