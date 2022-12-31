<%--
  Created by IntelliJ IDEA.
  User: PC Net Computers
  Date: 1/1/2023
  Time: 12:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Income tax Calculator</h1>
<form method="post" action="sector">

    <select name ="catagory" id="catagory">
        <option value = "General">General</option>
        <option value="Women/OLD">Women/Old</option>
        <option value="Freedom Fighter">Freedom Fighter</option>
    </select><br>
    <table border="1">
        <tr>
            <th>Area</th>
            <th>Amount</th>
        </tr>

        <tr>
            <td>
                Basic Sallary
            </td>
            <td>
                <input type="number" name="b_sal" id="b_sal" value="0"/>
            </td>
        </tr>
        <tr>
            <td>
                House Rent
            </td>
            <td>
                <input type="number" name="rent" id="rent" value="0"/>
            </td>
        </tr>
        <tr>
            <td>
                Medical Allowance
            </td>
            <td>
                <input type="number" name="med" id="med" value="0"/>
            </td>
        </tr>
        <tr>
            <td>
                Conveyance
            </td>
            <td>
                <input type="number" name="conv" id="conv" value="0"/>
            </td>
        </tr>
        <tr>
            <td>
                Festival Bonus
            </td>
            <td>
                <input type="number" name="bonus" id="bonus" value="0"/>
            </td>
        </tr>
        <br>
        <table >
            <input type="submit" value="Calculate">
            <input type="reset" value="Reset">
            <tr>
                <th>Monthly Income</th>
                <th>Taxable Income</th>
                <th>Yearly Tax</th>
            </tr>
            <tr>
                <td align="center">
                    ${result}
                </td>
                <td align="center">
                    ${taxable_amount}
                </td>
                </td>
                <td align="center">
                    ${tax}
                </td>
            </tr>
        </table>


        <%--        <tbody>--%>
        <%--        <c:forEach items="${tax}" var="tax">--%>
        <%--        <tr>--%>
        <%--            <td>--%>
        <%--                ${tax.tax_amount}--%>
        <%--            </td>--%>
        <%--        </tr>--%>
        <%--        </c:forEach>--%>
        <%--        </tbody>--%>
    </table>


</form>


</body>
</html>
