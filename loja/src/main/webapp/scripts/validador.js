function validar() {

    let id = document.forms["frmProduto"]["idprod"].value;
    let nome = document.forms["frmProduto"]["nome"].value;
    let tipo = document.forms["frmProduto"]["tipo"].value;
    let sessao = document.forms["frmProduto"]["sessao"].value;

    if (id === "") {
        alert("Preencha o código do produto");
        document.forms["frmProduto"]["idprod"].focus();
        return false;

    } else if (nome === "") {
        alert("Preencha o nome do produto");
        document.forms["frmProduto"]["nome"].focus();
        return false;

    } else if (tipo === "") {
        alert("Preencha o tipo do produto");
        document.forms["frmProduto"]["tipo"].focus();
        return false;

    } else if (sessao === "") {
        alert("Preencha a sessão do produto");
        document.forms["frmProduto"]["sessao"].focus();
        return false;

    } else {
        document.forms["frmProduto"].submit();
        return true;
    }
}