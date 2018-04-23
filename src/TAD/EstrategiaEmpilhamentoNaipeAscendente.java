/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

/**
 *
 * @author lbsilva-pfcosta
 */
public class EstrategiaEmpilhamentoNaipeAscendente implements EstrategiaEmpilhamento {

    /**
     * este método irá verificar se o empilhamento será válido, ou seja,
     * se o naipe da nova carta e da carta já existente são iguais e se
     * o valor da nova carta é uma univade superior ao da carta já
     * presente no monte
     * 
     * @param sobreposta carta a ser adicionada
     * @param subposta carta já presente
     * @return true se a carta a ser adicionada é válida, false caso contrário
     */
    @Override
    public boolean empilhamentoValido(Carta sobreposta, Carta subposta) {
        return (sobreposta.getNaipe() == subposta.getNaipe() && sobreposta.getValor() == subposta.getValor() + 1);
    }
    /**
     * método que verifica se a primeira carta a ser inserida é válida, ou seja
     * se é um ás.
     * 
     * @param carta 
     * @return true se for um ás, false caso contrário
     */
    @Override
    public boolean primeiraCartaValida(Carta carta) {
        return carta.getValor() == 0;
    }

}
