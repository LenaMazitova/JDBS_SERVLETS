<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="app.Athlete" import="app.Coach" import="java.util.List" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <title>All of athletes and coaches</title>
        </head>

        <body>
            <h1>List of athletes</h1>

            <% List<Athlete> athletes = (List<Athlete>) request.getAttribute("listAthletes");

                    if (athletes != null && !athletes.isEmpty()) {
                    out.println("<ui>");
                        for (Athlete a : athletes) {
                        out.println("<li>Athlete: '" + a.getName() + "' '" + a.getSurname() + "' '" +
                            a.getCoach().toString() + "</li>");
                        }
                        out.println("</ui>");
                    } else out.println("<p>There are no athletes yet!</p>");
                    %>
                    <br />
                    <h1>List of coaches</h1>
                    <% List<Coach> coaches = (List<Coach>) request.getAttribute("listCoaches");

                            if (coaches != null && !coaches.isEmpty()) {
                            out.println("<ui>");
                                for (Coach c : coaches) {
                                out.println("<li>Coach: '" + c.getName() + "' '" + c.getSurname() + ". Speciality: '" +
                                    c.getSpeciality_descr() + "</li>");
                                }
                                out.println("</ui>");
                            } else out.println("<p>There are no coaches yet!</p>");
                            %>
        </body>

        </html>