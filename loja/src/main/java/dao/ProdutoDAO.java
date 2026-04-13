package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Produto;

public class ProdutoDAO {

    // CONEXÃO
    public Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/loja";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // LISTAR
    public ArrayList<Produto> listar() {
        ArrayList<Produto> lista = new ArrayList<>();

        String read = "select * from produtos";

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setTipo(rs.getString("tipo"));
                p.setSessao(rs.getString("sessao"));
                lista.add(p);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return lista;
    }

    // INSERIR
    public void inserir(Produto p) {
        String create = "insert into produtos (nome, tipo, sessao) values (?, ?, ?)";

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(create);
            pst.setString(1, p.getNome());
            pst.setString(2, p.getTipo());
            pst.setString(3, p.getSessao());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // BUSCAR
    public void buscar(Produto p) {
        String read = "select * from produtos where id=?";

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            pst.setInt(1, p.getId());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                p.setNome(rs.getString("nome"));
                p.setTipo(rs.getString("tipo"));
                p.setSessao(rs.getString("sessao"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // ATUALIZAR
    public void atualizar(Produto p) {
        String update = "update produtos set nome=?, tipo=?, sessao=? where id=?";

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(update);
            pst.setString(1, p.getNome());
            pst.setString(2, p.getTipo());
            pst.setString(3, p.getSessao());
            pst.setInt(4, p.getId());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Deletar
    public void deletar(Produto p) {
        String delete = "delete from produtos where id=?";

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(delete);
            pst.setInt(1, p.getId());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}