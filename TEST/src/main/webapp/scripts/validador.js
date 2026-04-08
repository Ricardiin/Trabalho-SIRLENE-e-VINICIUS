function validar() {
    let nome = document.frmContato.nome.value;
    let fone = document.frmContato.fone.value;

    if (nome === "") {
        alert("Preencha o campo nome");
        document.frmContato.nome.focus();
        return false;

    } else if (fone === "") {
        alert("Preencha o campo Telefone");
        document.frmContato.fone.focus();
        return false;

    } else {
        document.frmContato.submit();
        return true;
    }
}