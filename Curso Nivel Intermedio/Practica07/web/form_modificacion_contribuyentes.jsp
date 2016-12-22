<%-- 
    Document   : form_modificacion_contribuyentes
    Created on : 09-02-2013, 08:40:58 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificacion de Contribuyentes</title>
    </head>
    <body>
        <h1>Modificacion de Contribuyentes</h1>
        <form name="Form1" action="form_mostrar_contribuyentes.jsp" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>No Nit</td>
                        <td><input type="text" name="no_nit" value="" size="16" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <center>
                            <input type="submit" value="Consultar" name="Consultar" />
                            </center> 
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
