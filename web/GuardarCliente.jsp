<%-- 
    Document   : GuardarCliente
    Created on : Mar 16, 2021, 9:58:41 AM
    Author     : Drosselmeyer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="sv.edu.udb.www.Clases.Cliente" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con JavaBean</title>
        
        
        <%-- En caso de que mostrara errores el property capture cada uno de los parametros --%>
        <%--
            
            int Id = Integer.parseInt(request.getParameter("id"));
            String Nombre = request.getParameter("nombre");
            int Cantidad = Integer.parseInt(request.getParameter("cantidad"));
            float Precio = Float.parseFloat(request.getParameter("precio"));
            float Total = Float.parseFloat(request.getParameter("total"));
        --%>
        
        
        <%-- Creamos una instancia de la clase Cliente --%>
        <jsp:useBean id="clienteObj" scope="request" class="sv.edu.udb.www.Clases.Cliente">
        
            <jsp:setProperty name="clienteObj" property="*" />
            <%--Seteamos todos los valores de los atributos 
            <jsp:setProperty name="clienteObj" property="id" value="<%= Id%>" />
            <jsp:setProperty name="clienteObj" property="nombre" value="<%= Nombre%>" />
            <jsp:setProperty name="clienteObj" property="cantidad" value="<%= Cantidad%>" />
            <jsp:setProperty name="clienteObj" property="precio" value="<%= Precio%>" />
            <jsp:setProperty name="clienteObj" property="total" value="<%= Total%>" />
            --%>
        </jsp:useBean>

    </head>
    <body>
               
        
        <%
            int x = clienteObj.setGuardarCliente();
       
            if(x>=1){
        %>
        <jsp:forward page="Correcto.jsp" />
        <%
            }
            else{
        %>
        <jsp:forward page="Error.jsp" />  
        <%
            }
        %>


        
        
    </body>
</html>
