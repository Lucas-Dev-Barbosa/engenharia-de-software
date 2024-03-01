package br.edu.infnet.lucas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.edu.infnet.lucas.model.domain.Bebida;
import br.edu.infnet.lucas.model.domain.Comida;
import br.edu.infnet.lucas.model.domain.Pedido;
import br.edu.infnet.lucas.model.domain.Sobremesa;
import br.edu.infnet.lucas.model.domain.Solicitante;
import br.edu.infnet.lucas.model.domain.exception.CpfInvalidoException;
import br.edu.infnet.lucas.model.domain.exception.EmailInvalidoException;
import br.edu.infnet.lucas.model.domain.exception.PedidoException;
import br.edu.infnet.lucas.model.domain.vos.Cpf;
import br.edu.infnet.lucas.model.domain.vos.Email;
import br.edu.infnet.lucas.service.IPedidoService;
import br.edu.infnet.lucas.service.PedidoService;

public class PedidoServiceTest {

    private final IPedidoService pedidoService = new PedidoService();
                    

    @Test
    public void listaPedidos() {
       List<Pedido> listaPedidos = pedidoService.listaPedidos();

       assertEquals(new ArrayList<Pedido>(), listaPedidos);
    }

    @Test
    public void getPedidoByIdThrowsPedidoException() {
        assertThrows(PedidoException.class, () -> pedidoService.getPedidoById(0l));
    }

    @Test
    public void getPedidoById() throws EmailInvalidoException, CpfInvalidoException, PedidoException {
        Pedido newPedido = montaPedidoTeste();
        pedidoService.insertPedido(newPedido);
        assertEquals(newPedido, pedidoService.getPedidoById(1l));
    }

    @Test
    public void insertPedidoInvalidoThrowsEmailInvalidoException() {
        assertThrows(EmailInvalidoException.class, this::montaPedidoTesteEmailSolicitanteInvalido);
    }

    @Test
    public void insertPedidoInvalidoThrowsCpfInvalidoException() {
        assertThrows(CpfInvalidoException.class, this::montaPedidoTesteCpfSolicitanteInvalido);
    }

    @Test
    public void insertPedido() throws EmailInvalidoException, CpfInvalidoException {
        Pedido newPedido = montaPedidoTeste();
        assertEquals(newPedido, pedidoService.insertPedido(newPedido));
    }

    @Test
    public void deletePedidoById() throws EmailInvalidoException, CpfInvalidoException {
        pedidoService.insertPedido(montaPedidoTeste());
        pedidoService.deletePedidoById(1l);

        assertThrows(PedidoException.class, () -> pedidoService.getPedidoById(1l));
    }

    @Test
    public void updatePedido() throws EmailInvalidoException, CpfInvalidoException, PedidoException {
        pedidoService.insertPedido(montaPedidoTeste());
        Pedido pedidoAlterado = montaPedidoTesteComAlteracao();
        assertEquals(pedidoAlterado, pedidoService.updatePedido(pedidoAlterado));
    }

    private Pedido montaPedidoTeste() throws CpfInvalidoException, EmailInvalidoException {
        Solicitante solicitante = montaSolicitante();

        Comida comida = montaComida();
        Bebida bebida = montaBebida();
        Sobremesa sobremesa = montaSobremesa();

        Pedido pedido = new Pedido();
        pedido.setDescricao("Pedido de teste Unitario");
        pedido.setData(new Date());
        pedido.setWeb(true);
        pedido.setSolicitante(solicitante);
        pedido.setListaProdutos(List.of(comida, bebida, sobremesa));
        
        return pedido;
    }

    private Pedido montaPedidoTesteComAlteracao() throws CpfInvalidoException, EmailInvalidoException {
        Solicitante solicitante = montaSolicitante();

        Comida comida = montaComida();
        Bebida bebida = montaBebida();
        Sobremesa sobremesa = montaSobremesa();
        
        Pedido pedido = new Pedido();
        pedido.setDescricao("Pedido de teste com alteracao");
        pedido.setData(new Date());
        pedido.setWeb(true);
        pedido.setSolicitante(solicitante);
        pedido.setListaProdutos(List.of(comida, bebida, sobremesa));
        
        return pedido;
    }

    private Pedido montaPedidoTesteCpfSolicitanteInvalido() throws CpfInvalidoException, EmailInvalidoException {
        Solicitante solicitante = montaSolicitanteCpfInvalido();

        Comida comida = montaComida();
        Bebida bebida = montaBebida();
        Sobremesa sobremesa = montaSobremesa();

        Pedido pedido = new Pedido();
        pedido.setDescricao("Pedido de teste Unitario");
        pedido.setData(new Date());
        pedido.setWeb(true);
        pedido.setSolicitante(solicitante);
        pedido.setListaProdutos(List.of(comida, bebida, sobremesa));
        
        return pedido;
    }

    private Pedido montaPedidoTesteEmailSolicitanteInvalido() throws CpfInvalidoException, EmailInvalidoException {
        Solicitante solicitante = montaSolicitanteEmailInvalido();

        Comida comida = montaComida();
        Bebida bebida = montaBebida();
        Sobremesa sobremesa = montaSobremesa();

        Pedido pedido = new Pedido();
        pedido.setDescricao("Pedido de teste Unitario");
        pedido.setData(new Date());
        pedido.setWeb(true);
        pedido.setSolicitante(solicitante);
        pedido.setListaProdutos(List.of(comida, bebida, sobremesa));
        
        return pedido;
    }

    private Solicitante montaSolicitante() throws CpfInvalidoException, EmailInvalidoException {
        Solicitante solicitante = new Solicitante();
        solicitante.setNome("Solicitante de teste");
        solicitante.setCpf(new Cpf("123.456.789-00"));
        solicitante.setEmail(new Email("email.teste@teste.com"));
        
        return solicitante;
    }

    private Solicitante montaSolicitanteCpfInvalido() throws CpfInvalidoException, EmailInvalidoException {
        Solicitante solicitante = new Solicitante();
        solicitante.setNome("Solicitante de teste");
        solicitante.setCpf(new Cpf("12345678900"));
        solicitante.setEmail(new Email("email.teste@teste.com"));
        
        return solicitante;
    }

    private Solicitante montaSolicitanteEmailInvalido() throws CpfInvalidoException, EmailInvalidoException {
        Solicitante solicitante = new Solicitante();
        solicitante.setNome("Solicitante de teste");
        solicitante.setCpf(new Cpf("12345678900"));
        solicitante.setEmail(new Email("email.testeteste.com"));
        
        return solicitante;
    }

    private Comida montaComida() {
        Comida comida = new Comida();
        comida.setNome("Comida");
        comida.setValor(25);
        comida.setCodigo(123456);
        comida.setTipo('c');
        comida.setPeso(15f);
        comida.setVegano(false);
        comida.setIngredientes(new String[] {"Arroz", "Feijao", "Salada", "Bife", "Batata Frita"});

        return comida;
    }

    private Bebida montaBebida() {
        Bebida bebida = new Bebida();
        bebida.setNome("Bebida");
        bebida.setValor(13);
        bebida.setCodigo(555222);
        bebida.setTipo('b');
        bebida.setGelada(true);
        bebida.setTamanho(Short.parseShort("5"));
        bebida.setMarca("Coca-Cola");

        return bebida;
    }

    private Sobremesa montaSobremesa() {
        Sobremesa sobremesa = new Sobremesa();
        sobremesa.setNome("Sobremesa");
        sobremesa.setValor(10);
        sobremesa.setCodigo(8796545);
        sobremesa.setTipo('s');
        sobremesa.setQuantidade(2L);
        sobremesa.setDoce(true);
        sobremesa.setInformacao("Pave");

        return sobremesa;
    }

}
