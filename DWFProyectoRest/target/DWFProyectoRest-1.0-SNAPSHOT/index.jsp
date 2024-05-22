<%-- 
    Document   : index
    Created on : 05-21-2024, 09:16:29 PM
    Author     : Joan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>API RESTful Cursos - Alumno</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 20px;
        }
        h1, h2 {
            margin-bottom: 10px;
        }
        ul {
            list-style-type: none;
            padding-left: 0;
        }
        li {
            margin-bottom: 8px;
        }
        li a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
            margin-right: 10px;
        }
        li a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>API RESTful Cursos - Alumno</h1>
    <h2>Servicios Web Disponibles</h2>
    <ul>
        <li><a href="rest/curso">GET /curso</a> - Obtener todos los cursos</li>
        <li><a href="rest/curso/1">GET /curso/{id}</a> - Obtener datos de un curso específico (ejemplo)</li>
        <li><a href="rest/curso" data-method="POST">POST /curso</a> - Crear un nuevo curso</li>
        <li><a href="rest/curso/1" data-method="PUT">PUT /curso/{id}</a> - Actualizar un curso existente (ejemplo)</li>
        <li><a href="rest/curso/1" data-method="DELETE">DELETE /curso/{id}</a> - Eliminar un curso (ejemplo)</li>
        <li><a href="rest/curso/1/alumno">GET /curso/{id}/alumno</a> - Obtener todos los alumnos de un curso</li>
        <li><a href="rest/curso/1/alumno/1">GET /curso/{id}/alumno/{id}</a> - Obtener datos de un alumno específico (ejemplo)</li>
        <li><a href="rest/curso/1/alumno" data-method="POST">POST /curso/{id}/alumno</a> - Crear un nuevo alumno en un curso (ejemplo)</li>
        <li><a href="rest/curso/1/alumno/1" data-method="PUT">PUT /curso/{id}/alumno/{id}</a> - Actualizar un alumno en un curso (ejemplo)</li>
        <li><a href="rest/curso/1/alumno/1" data-method="DELETE">DELETE /curso/{id}/alumno/{id}</a> - Eliminar un alumno de un curso (ejemplo)</li>
    </ul>
</body>
</html>



