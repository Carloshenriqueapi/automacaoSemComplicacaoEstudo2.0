package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Cliente henrique;
    Cliente carlosHenrique;
    Conta contaHenrique;
    Conta contaCarlosHenrique;

    @BeforeEach
    void setUp() {
        henrique = new Cliente("henrique", "123456789", "111111");
        carlosHenrique = new Cliente("Carlos Henrique", "37855994807", "342684899");

        contaHenrique = new Conta("0024", "2223", 2500.00, henrique);
        contaCarlosHenrique = new Conta("0026", "2378", 3500.00, carlosHenrique);
    }

    @Test
    public void realizarTransacao() {

        contaHenrique.realizarTranferencia(1000.00, contaCarlosHenrique);

        assertEquals(1500.00, contaHenrique.getSaldo());
        assertEquals(4500.00, contaCarlosHenrique.getSaldo());
    }

    @Test
    public void realizarTransfereciaInvalida(){

        boolean resultado = contaHenrique.realizarTranferencia(4000.00, contaCarlosHenrique);
        assertFalse(resultado);
    }
    @Test
    public void validarAgencia(){
        assertEquals("0024", contaHenrique.getAgencia());
        assertEquals("0026", contaCarlosHenrique.getAgencia());
    }
    @Test
    public void validarConta(){
        assertEquals("2223", contaHenrique.getNumeroConta());
        assertEquals("2378", contaCarlosHenrique.getNumeroConta());
    }
    @Test
    public void validarProprietario(){
        assertEquals(henrique,contaHenrique.getProprietario());
        assertEquals(carlosHenrique,contaCarlosHenrique.getProprietario());
        assertEquals(henrique.getNome(),contaHenrique.getProprietario().getNome());
        assertEquals(carlosHenrique.getNome(),contaCarlosHenrique.getProprietario().getNome());
        assertEquals(henrique.getCpf(),contaHenrique.getProprietario().getCpf());
        assertEquals(carlosHenrique.getCpf(),contaCarlosHenrique.getProprietario().getCpf());
        assertEquals(henrique.getRg(),contaHenrique.getProprietario().getRg());
        assertEquals(carlosHenrique.getRg(),contaCarlosHenrique.getProprietario().getRg());

    }




    }


