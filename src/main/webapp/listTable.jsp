<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="app.Athlete" %>
        <%@ page import="java.util.List" %>
            <div>
                <h1>List of athletes</h1>
                <table border="1">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Speciality</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% int i=1; List<Athlete> athletes = (List<Athlete>) request.getAttribute("listAthletes");
                                %>
                                <% for (Athlete a : athletes) { %>
                                    <tr>
                                        <td>
                                            <%= i++ %>
                                        </td>
                                        <td>
                                            <%= a.getName() %>
                                        </td>
                                        <td>
                                            <%= a.getSurname() %>
                                        </td>
                                        <td>
                                            <%= a.getSpeciality() %>
                                        </td>
                                    </tr>
                                    <% } %>
                    </tbody>
                </table>
            </div>