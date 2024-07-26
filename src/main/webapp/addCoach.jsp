<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <title>Add coach</title>

    </head>

    <body>
        <h1>Add coach</h1>
        <div>
            <% if (request.getAttribute("coachName") !=null && request.getAttribute("coachSurname") !=null) {
                out.println("<p>Coach '" + request.getAttribute("coachName") + "' '" +
                request.getAttribute("coachSurname") + "' added!</p>");
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
                        <label>Choose number of speciaity(1 - fitness, 2 - gimnastics, 3 - athletics):
                            <input type="text" name="speciality_id"><br />
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