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
public final class EstrategiaEmpilhamentoCorNaipeDescendente implements EstrategiaEmpilhamento {

    /**
     * neste caso, o empilhamento é valido se as cartas tiverem naipes de cores
     * diferentes, e o valor da nova carta for uma unidade inferior ao da
     * carta que já constava no monte
     * 
     * @param sobreposta nova carta a ser inserida
     * @param subposta carta que já constava no monte
     * @return true se se trata de um empilhamento válido, false caso contrário
     */
    @Override
    public boolean empilhamentoValido(Carta sobreposta, Carta subposta) {
        return (naipesValidos(sobreposta, subposta) && (valoresValidos(sobreposta, subposta)));
    }
    
    /**
     * este método serve para verificar se uma carta é de naipe preto
     * 
     * @param carta carta a ser verificada
     * @return true se tem naipe preto, false caso contrário
     */
    private boolean cartaPreta(Carta carta) {
        return (carta.getNaipe() == NaipeFrances.ESPADAS || carta.getNaipe() == NaipeFrances.PAUS);
    }

    /**
     * método que verifica se as cartas têm naipes de cores diferentes
     * (ou seja: Vermelho e Preto, ou Preto e Vermelho)
     * 
     * @param sobreposta carta a ser verificada
     * @param subposta carta que ja consta no monte
     * @return true caso tenha naipe valido, false caso contrário
     */
    private boolean naipesValidos(Carta sobreposta, Carta subposta) {
        return (cartaPreta(sobreposta) != cartaPreta(subposta));
    }

    /**
     * este método verifica se os valores das cartas são válidos:
     *  - O valor da nova carta terá que ser uma unidade inferior à da
     * que já constava no monte
     * 
     * @param sobreposta carta a ser verificada
     * @param subposta carta já presente no monte
     * @return true caso tenha valores validos, false caso contrário
     */
    private boolean valoresValidos(Carta sobreposta, Carta subposta) {
        return (sobreposta.getValor() == (subposta.getValor()-1));
    }

    /**
     * num monte sequencial, a primeira carta pode ser qualquer uma, por isso
     * este método retornará sempre o valor true
     * 
     * @param carta
     * @return true
     */
    @Override
    public boolean primeiraCartaValida(Carta carta) {
        return true;
    }
}
