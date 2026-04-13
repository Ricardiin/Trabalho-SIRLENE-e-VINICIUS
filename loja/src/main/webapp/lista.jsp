<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Produto" %>

<%
ArrayList<Produto> lista = (ArrayList<Produto>) request.getAttribute("produtos");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Lista de Produtos</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background-color: #f5f5f5;
}

.table-container {
    background: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
}
</style>

</head>

<body>

<div class="container mt-5">

    <h2 class="text-center mb-4">Lista de Produtos</h2>

    <div class="table-container">

        <table class="table table-bordered table-hover text-center">

            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Tipo</th>
                    <th>Sessão</th>
                    <th>Ações</th>
                </tr>
            </thead>

            <tbody>

            <%
            for(int i = 0; i < lista.size(); i++){
            %>

                <tr>
                    <td><%= lista.get(i).getId() %></td>
                    <td><%= lista.get(i).getNome() %></td>
                    <td><%= lista.get(i).getTipo() %></td>
                    <td><%= lista.get(i).getSessao() %></td>

                    <td>
                        <!-- EDITAR -->
                        <a href="select?idprod=<%= lista.get(i).getId() %>" 
                           class="btn btn-warning btn-sm">
                           Editar
                        </a>

                        <!-- EXCLUIR -->
                        <a href="delete?idprod=<%= lista.get(i).getId() %>" 
                           class="btn btn-danger btn-sm"
                           onclick="return confirm('Deseja excluir este produto?')">
                           Excluir
                        </a>
                    </td>
                </tr>

            <%
            }
            %>

            </tbody>

        </table>

        <!-- BOTÃO NOVO -->
        <div class="text-center mt-3">
            <a href="cadastro.html" class="btn btn-success">
                + Novo Produto
            </a>
        </div>

    </div>

</div>

</body>
</html>