<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Cadastrar Produto</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Cadastrar Produto</h2>

    <!-- FORM -->
    <form name="frmProduto" action="insert" method="post">

        <div class="mb-3">
            <input type="text" class="form-control" name="idprod" placeholder="Código do Produto">
        </div>

        <div class="mb-3">
            <input type="text" class="form-control" name="nome" placeholder="Nome do Produto">
        </div>

        <div class="mb-3">
            <input type="text" class="form-control" name="tipo" placeholder="Tipo">
        </div>

        <div class="mb-3">
            <input type="text" class="form-control" name="sessao" placeholder="Sessão">
        </div>

        <!-- BOTÃO -->
        <button type="submit" class="btn btn-primary">Cadastrar</button>

    </form>
</div>

<!-- JS -->
<script src="scripts/validador.js"></script>

</body>
</html>