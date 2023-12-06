package br.edu.infnet.lucas;

import br.edu.infnet.lucas.file.AppFileReaderJson;
import br.edu.infnet.lucas.file.AppFileWriterCsv;
import br.edu.infnet.lucas.model.domain.*;
import br.edu.infnet.lucas.model.domain.exception.CpfInvalidoException;
import br.edu.infnet.lucas.model.domain.exception.EmailInvalidoException;
import br.edu.infnet.lucas.model.domain.exception.PedidoException;
import br.edu.infnet.lucas.model.domain.repository.PedidoRepository;
import br.edu.infnet.lucas.model.domain.vos.Cpf;
import br.edu.infnet.lucas.model.domain.vos.Email;
import br.edu.infnet.lucas.service.IPedidoService;
import br.edu.infnet.lucas.service.PedidoService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoServiceTest {

    private final IPedidoService pedidoService =
            new PedidoService(
                    new PedidoRepository(
                            new AppFileReaderJson<Pedido>(), new AppFileWriterCsv()));

    @Test
    public void listaPedidos() {
       List<Pedido> listaPedidos = pedidoService.listaPedidos();

       assertEquals(new ArrayList<Pedido>(), listaPedidos);
    }

    @Test
    public void getPedidoByCpfSolicitanteThrowsPedidoException() {
        assertThrows(PedidoException.class, () -> pedidoService.getPedidoByCpfSolicitante(""));
    }

    @Test
    public void getPedidoByCpfSolicitante() throws EmailInvalidoException, CpfInvalidoException, PedidoException {
        Pedido newPedido = montaPedidoTeste();
        pedidoService.insertPedido(newPedido);
        assertEquals(newPedido, pedidoService.getPedidoByCpfSolicitante("123.456.789-00"));
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
    public void deletePedidoByCpfSolicitante() throws EmailInvalidoException, CpfInvalidoException {
        pedidoService.insertPedido(montaPedidoTeste());
        pedidoService.deletePedidoByCpfSolicitante("123.456.789-00");

        assertThrows(PedidoException.class, () -> pedidoService.getPedidoByCpfSolicitante("123.456.789-00"));
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

        return new Pedido(
                "Pedido de teste Unitario",
                new Date(),
                true,
                solicitante,
                List.of(comida, bebida, sobremesa)
                );
    }

    private Pedido montaPedidoTesteComAlteracao() throws CpfInvalidoException, EmailInvalidoException {
        Solicitante solicitante = montaSolicitante();

        Comida comida = montaComida();
        Bebida bebida = montaBebida();
        Sobremesa sobremesa = montaSobremesa();

        return new Pedido(
                "Pedido de teste com alteracao",
                new Date(),
                true,
                solicitante,
                List.of(comida, bebida, sobremesa)
        );
    }

    private Pedido montaPedidoTesteCpfSolicitanteInvalido() throws CpfInvalidoException, EmailInvalidoException {
        Solicitante solicitante = montaSolicitanteCpfInvalido();

        Comida comida = montaComida();
        Bebida bebida = montaBebida();
        Sobremesa sobremesa = montaSobremesa();

        return new Pedido(
                "Pedido de teste Unitario",
                new Date(),
                true,
                solicitante,
                List.of(comida, bebida, sobremesa)
        );
    }

    private Pedido montaPedidoTesteEmailSolicitanteInvalido() throws CpfInvalidoException, EmailInvalidoException {
        Solicitante solicitante = montaSolicitanteEmailInvalido();

        Comida comida = montaComida();
        Bebida bebida = montaBebida();
        Sobremesa sobremesa = montaSobremesa();

        return new Pedido(
                "Pedido de teste Unitario",
                new Date(),
                true,
                solicitante,
                List.of(comida, bebida, sobremesa)
        );
    }

    private Solicitante montaSolicitante() throws CpfInvalidoException, EmailInvalidoException {
        return new Solicitante(
                "Solicitante de teste",
                new Cpf("123.456.789-00"),
                new Email("email.teste@teste.com"));
    }

    private Solicitante montaSolicitanteCpfInvalido() throws CpfInvalidoException, EmailInvalidoException {
        return new Solicitante(
                "Solicitante de teste",
                new Cpf("12345678900"),
                new Email("email.teste@teste.com"));
    }

    private Solicitante montaSolicitanteEmailInvalido() throws CpfInvalidoException, EmailInvalidoException {
        return new Solicitante(
                "Solicitante de teste",
                new Cpf("123.456.789-00"),
                new Email("email.testeteste.com"));
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
