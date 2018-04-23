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
public interface EstrategiaEmpilhamento {

    /**
     * este método verifica se o empilhamento efectuado por uma carta subposta
     * (a que já constava no monte) e uma carta sobreposta (a que será a nova
     * carta) é valido
     * 
     * @param sobreposta nova carta
     * @param subposta carta já existente
     * @return true se é um empilhamento válido, falso em caso contrário
     */
    public abstract boolean empilhamentoValido(Carta sobreposta, Carta subposta);
    
    /**
     * caso a carta a ser inserida seja a primeira carta, então será
     * necessário efectuar uma verificação especial (através deste método)
     * 
     * @param carta primeira carta que irá constar no monte
     * @return true se se trata de um empilhamento válido, falso em caso
     * contrário
     */
    public abstract boolean primeiraCartaValida(Carta carta);
}
