<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Editar Produto</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background-color: #f5f5f5;
}

.card {
    max-width: 500px;
    margin: auto;
    border-radius: 15px;
    box-shadow: 0 0 15px rgba(0,0,0,0.1);
}

.card-header {
    background: #1f2b5c;
    color: white;
    text-align: center;
    font-size: 20px;
    border-radius: 15px 15px 0 0;
}
</style>

</head>

<body>

<div class="container mt-5">

    <div class="card">

        <div class="card-header">
            Editar Produto
        </div>

        <div class="card-body">

            <!-- FORM -->
            <form action="update" method="post">

                <!-- ID (OCULTO) -->
                <input type="hidden" name="idprod" value="<%= request.getAttribute("idprod") %>">

                <div class="mb-3">
                    <label class="form-label">Nome</label>
                    <input type="text" name="nome" class="form-control"
                        value="<%= request.getAttribute("nome") %>">
                </div>

                <div class="mb-3">
                    <label class="form-label">Tipo</label>
                    <input type="text" name="tipo" class="form-control"
                        value="<%= request.getAttribute("tipo") %>">
                </div>

                <div class="mb-3">
                    <label class="form-label">Sessão</label>
                    <input type="text" name="sessao" class="form-control"
                        value="<%= request.getAttribute("sessao") %>">
                </div>

                <!-- BOTÕES -->
                <div class="d-flex justify-content-between">

                    <a href="main" class="btn btn-secondary">
                        Voltar
                    </a>

                    <button type="submit" class="btn btn-success">
                        Salvar Alterações
                    </button>

                </div>

            </form>

        </div>

    </div>

</div>

</body>
</html>