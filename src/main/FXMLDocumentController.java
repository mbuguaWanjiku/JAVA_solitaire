/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Collections.Iterator;
import Exceptions.CardNotAllowedException;
import TAD.BaralhoFrances;
import Utils.Tabuleiro;
import Utils.TabuleiroAdulto;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.Effect;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;

/**
 *
 * @author lbsilva
 */
public class FXMLDocumentController implements Initializable {

    private final AudioClip FAIL_SOUND = new AudioClip(getClass().getResource("sounds/error.wav").toString());
    private final AudioClip NEW_GAME_SOUND = new AudioClip(getClass().getResource("sounds/new_game.wav").toString());
    private final AudioClip MOVE_CARDS_SOUND = new AudioClip(getClass().getResource("sounds/move_cards.wav").toString());
    private final AudioClip SELECT_CARDS_SOUND = new AudioClip(getClass().getResource("sounds/select_cards.wav").toString());
    private final AudioClip VICTORY_SOUND = new AudioClip(getClass().getResource("sounds/victory.wav").toString());
    private final AudioClip DECK_SOUND = new AudioClip(getClass().getResource("sounds/baralho.wav").toString());
    private final AudioClip UNDO_REDO_SOUND = new AudioClip(getClass().getResource("sounds/undoRedo.wav").toString());
    
    private static final String TRANSPARENT_IMAGE = "images/transparent.png";
    private static final String EMPTY_CARD_SLOT = "images/card_slot.png";
    private static final Effect SELECTED_CARD_EFFECT = selectedCardEffect();

    private boolean lixoSelected;
    private boolean jogoSelected;
    private String imagemCartas;

    private Tabuleiro jogo;
    private ImageView[][] cartas;

    @FXML
    private MenuItem undo;
    
    @FXML
    private MenuItem redo;

    @FXML
    private ImageView baralho; // baralho
    @FXML
    private ImageView monteLixo1; // primeira carta do monte lixo
    @FXML
    private ImageView monteLixo2; // segunda carta do monte lixo
    @FXML
    private ImageView monteLixo3;
    @FXML
    private ImageView monteTopo1;
    @FXML
    private ImageView monteTopo2;
    @FXML
    private ImageView monteTopo3;
    @FXML
    private ImageView monteTopo4;

    @FXML
    private ImageView cartaEscondida1;
    @FXML
    private ImageView primeiraCarta1;
    @FXML
    private ImageView segundaCarta1;
    @FXML
    private ImageView terceiraCarta1;
    @FXML
    private ImageView quartaCarta1;
    @FXML
    private ImageView quintaCarta1;
    @FXML
    private ImageView sextaCarta1;
    @FXML
    private ImageView setimaCarta1;
    @FXML
    private ImageView oitavaCarta1;
    @FXML
    private ImageView nonaCarta1;
    @FXML
    private ImageView decimaCarta1;
    @FXML
    private ImageView decimaPrimeiraCarta1;
    @FXML
    private ImageView decimaSegundaCarta1;
    @FXML
    private ImageView decimaTerceiraCarta1;

    @FXML
    private ImageView cartaEscondida2;
    @FXML
    private ImageView primeiraCarta2;
    @FXML
    private ImageView segundaCarta2;
    @FXML
    private ImageView terceiraCarta2;
    @FXML
    private ImageView quartaCarta2;
    @FXML
    private ImageView quintaCarta2;
    @FXML
    private ImageView sextaCarta2;
    @FXML
    private ImageView setimaCarta2;
    @FXML
    private ImageView oitavaCarta2;
    @FXML
    private ImageView nonaCarta2;
    @FXML
    private ImageView decimaCarta2;
    @FXML
    private ImageView decimaPrimeiraCarta2;
    @FXML
    private ImageView decimaSegundaCarta2;
    @FXML
    private ImageView decimaTerceiraCarta2;

    @FXML
    private ImageView cartaEscondida3;
    @FXML
    private ImageView primeiraCarta3;
    @FXML
    private ImageView segundaCarta3;
    @FXML
    private ImageView terceiraCarta3;
    @FXML
    private ImageView quartaCarta3;
    @FXML
    private ImageView quintaCarta3;
    @FXML
    private ImageView sextaCarta3;
    @FXML
    private ImageView setimaCarta3;
    @FXML
    private ImageView oitavaCarta3;
    @FXML
    private ImageView nonaCarta3;
    @FXML
    private ImageView decimaCarta3;
    @FXML
    private ImageView decimaPrimeiraCarta3;
    @FXML
    private ImageView decimaSegundaCarta3;
    @FXML
    private ImageView decimaTerceiraCarta3;

    @FXML
    private ImageView cartaEscondida4;
    @FXML
    private ImageView primeiraCarta4;
    @FXML
    private ImageView segundaCarta4;
    @FXML
    private ImageView terceiraCarta4;
    @FXML
    private ImageView quartaCarta4;
    @FXML
    private ImageView quintaCarta4;
    @FXML
    private ImageView sextaCarta4;
    @FXML
    private ImageView setimaCarta4;
    @FXML
    private ImageView oitavaCarta4;
    @FXML
    private ImageView nonaCarta4;
    @FXML
    private ImageView decimaCarta4;
    @FXML
    private ImageView decimaPrimeiraCarta4;
    @FXML
    private ImageView decimaSegundaCarta4;
    @FXML
    private ImageView decimaTerceiraCarta4;

    @FXML
    private ImageView cartaEscondida5;
    @FXML
    private ImageView primeiraCarta5;
    @FXML
    private ImageView segundaCarta5;
    @FXML
    private ImageView terceiraCarta5;
    @FXML
    private ImageView quartaCarta5;
    @FXML
    private ImageView quintaCarta5;
    @FXML
    private ImageView sextaCarta5;
    @FXML
    private ImageView setimaCarta5;
    @FXML
    private ImageView oitavaCarta5;
    @FXML
    private ImageView nonaCarta5;
    @FXML
    private ImageView decimaCarta5;
    @FXML
    private ImageView decimaPrimeiraCarta5;
    @FXML
    private ImageView decimaSegundaCarta5;
    @FXML
    private ImageView decimaTerceiraCarta5;

    @FXML
    private ImageView cartaEscondida6;
    @FXML
    private ImageView primeiraCarta6;
    @FXML
    private ImageView segundaCarta6;
    @FXML
    private ImageView terceiraCarta6;
    @FXML
    private ImageView quartaCarta6;
    @FXML
    private ImageView quintaCarta6;
    @FXML
    private ImageView sextaCarta6;
    @FXML
    private ImageView setimaCarta6;
    @FXML
    private ImageView oitavaCarta6;
    @FXML
    private ImageView nonaCarta6;
    @FXML
    private ImageView decimaCarta6;
    @FXML
    private ImageView decimaPrimeiraCarta6;
    @FXML
    private ImageView decimaSegundaCarta6;
    @FXML
    private ImageView decimaTerceiraCarta6;

    @FXML
    private ImageView cartaEscondida7;
    @FXML
    private ImageView primeiraCarta7;
    @FXML
    private ImageView segundaCarta7;
    @FXML
    private ImageView terceiraCarta7;
    @FXML
    private ImageView quartaCarta7;
    @FXML
    private ImageView quintaCarta7;
    @FXML
    private ImageView sextaCarta7;
    @FXML
    private ImageView setimaCarta7;
    @FXML
    private ImageView oitavaCarta7;
    @FXML
    private ImageView nonaCarta7;
    @FXML
    private ImageView decimaCarta7;
    @FXML
    private ImageView decimaPrimeiraCarta7;
    @FXML
    private ImageView decimaSegundaCarta7;
    @FXML
    private ImageView decimaTerceiraCarta7;

    @FXML
    private void moreCards(MouseEvent event) {
        if (!lixoSelected) {
            DECK_SOUND.play();
            jogo.maisCartas();
            update();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarJogo();
        NEW_GAME_SOUND.play();
    }

    private void update() {
        undo.setDisable(!jogo.hasUndos());
        redo.setDisable(!jogo.hasRedos());
        verificarVitoria();
        updateTop();
        updateCenter();
    }

    private void updateTop() {
        if (!jogo.isBaralhoEmpty()) {
            baralho.setImage(new Image(getClass().getResourceAsStream(imagemCartas)));
        } else {
            baralho.setImage(new Image(getClass().getResourceAsStream(EMPTY_CARD_SLOT)));
        }
        String carta = jogo.getMonteCartasTopo(0);
        if (null != carta) {
            monteTopo1.setImage(new Image(getClass().getResourceAsStream("images/" + carta + ".png")));
        } else {
            monteTopo1.setImage(new Image(getClass().getResourceAsStream(EMPTY_CARD_SLOT)));
        }
        monteTopo1.setOnMouseClicked(new AceCardEvent(0));
        carta = jogo.getMonteCartasTopo(1);
        if (null != carta) {
            monteTopo2.setImage(new Image(getClass().getResourceAsStream("images/" + carta + ".png")));
        } else {
            monteTopo2.setImage(new Image(getClass().getResourceAsStream(EMPTY_CARD_SLOT)));
        }
        monteTopo2.setOnMouseClicked(new AceCardEvent(1));
        carta = jogo.getMonteCartasTopo(2);
        if (null != carta) {
            monteTopo3.setImage(new Image(getClass().getResourceAsStream("images/" + carta + ".png")));
        } else {
            monteTopo3.setImage(new Image(getClass().getResourceAsStream(EMPTY_CARD_SLOT)));
        }
        monteTopo3.setOnMouseClicked(new AceCardEvent(2));
        carta = jogo.getMonteCartasTopo(3);
        if (null != carta) {
            monteTopo4.setImage(new Image(getClass().getResourceAsStream("images/" + carta + ".png")));
        } else {
            monteTopo4.setImage(new Image(getClass().getResourceAsStream(EMPTY_CARD_SLOT)));
        }
        monteTopo4.setOnMouseClicked(new AceCardEvent(3));
        apresentarLixo();
    }

    private void updateCenter() {
        Iterator it;
        for (int i = 0; i < 7; i++) {
            it = jogo.getMonteCartasJogo(i).getIterator();
            if (!jogo.isMonteCartasEscondidasEmpty(i)) {
                cartas[i][0].setImage(new Image(getClass().getResourceAsStream(imagemCartas)));
            } else {
                cartas[i][0].setImage(new Image(getClass().getResourceAsStream(TRANSPARENT_IMAGE)));
            }
            for (int j = 1; j < cartas[i].length; j++) {
                if (it.hasNext()) {
                    cartas[i][j].setImage(new Image(getClass().getResourceAsStream("images/" + it.next().toString() + ".png")));
                    if (!it.hasNext()) {
                        cartas[i][j].setOnMouseClicked(new LastCardEvent(i, j));
                    } else {
                        cartas[i][j].setOnMouseClicked(new CardEvent(i, j));
                    }
                } else {
                    if (j == 1) {
                        cartas[i][j].setImage(new Image(getClass().getResourceAsStream(EMPTY_CARD_SLOT)));
                        cartas[i][j].setOnMouseClicked(new KingCardEvent(i));
                    } else {
                        cartas[i][j].setImage(new Image(getClass().getResourceAsStream(TRANSPARENT_IMAGE)));
                        cartas[i][j].setOnMouseClicked(null);
                    }
                }
            }
        }
    }

    private static Effect selectedCardEffect() {
        InnerShadow is = new InnerShadow();
        is.setOffsetX(5.0f);
        is.setOffsetY(5.0f);
        return is;
    }

    private void apresentarLixo() {
        Iterator it;
        it = jogo.getMonteCartasLixo().getIterator();
        if (it.hasNext()) {
            monteLixo1.setImage(new Image(getClass().getResourceAsStream("images/" + it.next() + ".png")));
            if (!it.hasNext()) {
                monteLixo1.setOnMouseClicked(new LixoEvent((monteLixo1)));
            } else {
                monteLixo1.setOnMouseClicked(null);
            }
        } else {
            monteLixo1.setImage(new Image(getClass().getResourceAsStream(TRANSPARENT_IMAGE)));
        }
        if (it.hasNext()) {
            monteLixo2.setImage(new Image(getClass().getResourceAsStream("images/" + it.next() + ".png")));
            if (!it.hasNext()) {
                monteLixo2.setOnMouseClicked(new LixoEvent((monteLixo2)));
            } else {
                monteLixo2.setOnMouseClicked(null);
            }
        } else {
            monteLixo2.setImage(new Image(getClass().getResourceAsStream(TRANSPARENT_IMAGE)));
        }
        if (it.hasNext()) {

            monteLixo3.setImage(new Image(getClass().getResourceAsStream("images/" + it.next() + ".png")));
            if (!it.hasNext()) {
                monteLixo3.setOnMouseClicked(new LixoEvent((monteLixo3)));
            } else {
                monteLixo3.setOnMouseClicked(null);
            }
        } else {
            monteLixo3.setImage(new Image(getClass().getResourceAsStream(TRANSPARENT_IMAGE)));
        }
    }

    private void verificarVitoria() {
        int colunasAcabadas = 0;
        for (int i = 0; i < 4; i++) {
            String carta = jogo.getMonteCartasTopo(i);
            if (isRei(carta)) {
                colunasAcabadas++;
            }
        }
        if (colunasAcabadas == 4) {
            VICTORY_SOUND.play();
            new AlertWindow("Vitoria", "Parabens, venceu.");
            iniciarJogo();
        }
    }

    private boolean isRei(String carta) {
        if (carta == null) {
            return false;
        }
        if (carta.equals("rei_paus")) {
            return true;
        }
        if (carta.equals("rei_ouros")) {
            return true;
        }
        if (carta.equals("rei_espadas")) {
            return true;
        }
        return carta.equals("rei_copas");
    }

    private class KingCardEvent implements EventHandler<MouseEvent> {

        private int numeroColuna;

        public KingCardEvent(int numeroColuna) {
            this.numeroColuna = numeroColuna;
        }

        @Override
        public void handle(MouseEvent event) {
            if (lixoSelected) {
                try {
                    jogo.moverCartaParaColuna(numeroColuna);
                } catch (CardNotAllowedException e) {
                    FAIL_SOUND.play();
                    new AlertWindow("Jogada ilegal", e.getMessage());
                } finally {
                    removeAllSelects();
                    update();
                }
                MOVE_CARDS_SOUND.play();

            } else if (jogoSelected) {
                try {
                    jogo.moverCartaDeColunaParaColuna(numeroColuna);
                } catch (CardNotAllowedException e) {
                    FAIL_SOUND.play();
                    new AlertWindow("Jogada ilegal", e.getMessage());
                } finally {
                    removeAllSelects();
                    update();
                }
                MOVE_CARDS_SOUND.play();
            }
        }
    }

    private class AceCardEvent implements EventHandler<MouseEvent> {

        private int numeroBloco;

        public AceCardEvent(int numeroBloco) {
            this.numeroBloco = numeroBloco;
        }

        @Override
        public void handle(MouseEvent event) {
            if (lixoSelected) {
                try {
                    jogo.moverCartaParaTopo(numeroBloco);
                } catch (CardNotAllowedException e) {
                    FAIL_SOUND.play();
                    new AlertWindow("Jogada ilegal", e.getMessage());
                } finally {
                    removeAllSelects();
                    update();
                }
                MOVE_CARDS_SOUND.play();
            } else if (jogoSelected) {
                try {
                    jogo.moverCartaDeColunaParaTopo(numeroBloco);
                } catch (CardNotAllowedException e) {
                    FAIL_SOUND.play();
                    new AlertWindow("Jogada ilegal", e.getMessage());
                } finally {
                    removeAllSelects();
                    update();
                }
                MOVE_CARDS_SOUND.play();
            }
        }
    }

    private class LastCardEvent implements EventHandler<MouseEvent> {

        private int i;
        private int j;

        public LastCardEvent(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public void handle(MouseEvent event) {
            if (lixoSelected) {
                try {
                    jogo.moverCartaParaColuna(i);
                } catch (CardNotAllowedException e) {
                    FAIL_SOUND.play();
                    new AlertWindow("Jogada ilegal", e.getMessage());
                } finally {
                    removeAllSelects();
                    update();
                }
                MOVE_CARDS_SOUND.play();
            } else if (jogoSelected) {
                try {
                    jogo.moverCartaDeColunaParaColuna(i);
                } catch (CardNotAllowedException e) {
                    FAIL_SOUND.play();
                    new AlertWindow("Jogada ilegal", e.getMessage());
                } finally {
                    removeAllSelects();
                    update();
                }
                MOVE_CARDS_SOUND.play();
            } else {
                if (cartas[i][j].getEffect() == null) {
                    cartas[i][j].setEffect(SELECTED_CARD_EFFECT);
                    try {
                        jogo.selectUltimaCartaDeColuna(i);
                        jogoSelected = true;
                    } catch (CardNotAllowedException e) {
                        removeAllSelects();
                    } finally {
                        update();
                    }
                    SELECT_CARDS_SOUND.play();
                } else {
                    cartas[i][j].setEffect(null);
                    jogo.desselect();
                    SELECT_CARDS_SOUND.play();
                    removeAllSelects();
                    update();
                }
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            LastCardEvent other = (LastCardEvent) obj;
            if (this.i != other.i) {
                return false;
            }
            return this.j == other.j;
        }

    }

    private class CardEvent implements EventHandler<MouseEvent> {

        private int i;
        private int j;

        public CardEvent(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public void handle(MouseEvent event) {
            if (jogoSelected) {
                try {
                    jogo.moverCartaDeColunaParaColuna(i);
                } catch (CardNotAllowedException e) {
                    FAIL_SOUND.play();
                    new AlertWindow("Jogada ilegal", e.getMessage());
                } finally {
                    removeAllSelects();
                    update();
                }
                MOVE_CARDS_SOUND.play();
            } else {
                SELECT_CARDS_SOUND.play();
                if (cartas[i][j].getEffect() == null) {
                    cartas[i][j].setEffect(SELECTED_CARD_EFFECT);
                    jogo.selectColuna(i, j - 1);
                    jogoSelected = true;
                    update();
                } else {
                    cartas[i][j].setEffect(null);
                    jogo.desselect();
                    removeAllSelects();
                    update();
                }
            }
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            LastCardEvent other = (LastCardEvent) obj;
            if (this.i != other.i) {
                return false;
            }
            return this.j == other.j;
        }
    }

    private class LixoEvent implements EventHandler<MouseEvent> {

        private ImageView card;

        public LixoEvent(ImageView card) {
            this.card = card;
        }

        @Override
        public void handle(MouseEvent event) {
            if (!jogoSelected) {
                SELECT_CARDS_SOUND.play();
                if (!lixoSelected) {
                    card.setEffect(SELECTED_CARD_EFFECT);
                    lixoSelected = true;
                } else {
                    card.setEffect(null);
                    lixoSelected = false;
                }
            } else {
                FAIL_SOUND.play();
                new AlertWindow("Jogada ilegal", "Impossivel repor carta no monte");
                removeAllSelects();
            }
        }
    }

    private void removeAllSelects() {
        for (int i = 0; i < cartas.length; i++) {
            for (int j = 0; j < cartas[i].length; j++) {
                cartas[i][j].setEffect(null);
            }
        }
        monteLixo1.setEffect(null);
        monteLixo2.setEffect(null);
        monteLixo3.setEffect(null);
        jogoSelected = false;
        lixoSelected = false;
    }

    @FXML
    private void newGame(ActionEvent event) {
        new AlertWindow("Novo jogo", "Vai ser iniciado um novo jogo.");
        NEW_GAME_SOUND.play();
        iniciarJogo();
    }

    @FXML
    private void undo(ActionEvent event) {
        UNDO_REDO_SOUND.play();
        jogo.undo();
        update();
    }
    
    @FXML
    private void redo(ActionEvent event) {
        UNDO_REDO_SOUND.play();
        jogo.redo();
        update();
    }

    private void iniciarJogo() {
        lixoSelected = false;
        jogoSelected = false;
        jogo = new TabuleiroAdulto(new BaralhoFrances());
        imagemCartas = "images/blueBack.png";
        cartas = new ImageView[][]{
            {cartaEscondida1, primeiraCarta1, segundaCarta1, terceiraCarta1, quartaCarta1, quintaCarta1, sextaCarta1, setimaCarta1, oitavaCarta1, nonaCarta1, decimaCarta1, decimaPrimeiraCarta1, decimaSegundaCarta1, decimaTerceiraCarta1},
            {cartaEscondida2, primeiraCarta2, segundaCarta2, terceiraCarta2, quartaCarta2, quintaCarta2, sextaCarta2, setimaCarta2, oitavaCarta2, nonaCarta2, decimaCarta2, decimaPrimeiraCarta2, decimaSegundaCarta2, decimaTerceiraCarta2},
            {cartaEscondida3, primeiraCarta3, segundaCarta3, terceiraCarta3, quartaCarta3, quintaCarta3, sextaCarta3, setimaCarta3, oitavaCarta3, nonaCarta3, decimaCarta3, decimaPrimeiraCarta3, decimaSegundaCarta3, decimaTerceiraCarta3},
            {cartaEscondida4, primeiraCarta4, segundaCarta4, terceiraCarta4, quartaCarta4, quintaCarta4, sextaCarta4, setimaCarta4, oitavaCarta4, nonaCarta4, decimaCarta4, decimaPrimeiraCarta4, decimaSegundaCarta4, decimaTerceiraCarta4},
            {cartaEscondida5, primeiraCarta5, segundaCarta5, terceiraCarta5, quartaCarta5, quintaCarta5, sextaCarta5, setimaCarta5, oitavaCarta5, nonaCarta5, decimaCarta5, decimaPrimeiraCarta5, decimaSegundaCarta5, decimaTerceiraCarta5},
            {cartaEscondida6, primeiraCarta6, segundaCarta6, terceiraCarta6, quartaCarta6, quintaCarta6, sextaCarta6, setimaCarta6, oitavaCarta6, nonaCarta6, decimaCarta6, decimaPrimeiraCarta6, decimaSegundaCarta6, decimaTerceiraCarta6},
            {cartaEscondida7, primeiraCarta7, segundaCarta7, terceiraCarta7, quartaCarta7, quintaCarta7, sextaCarta7, setimaCarta7, oitavaCarta7, nonaCarta7, decimaCarta7, decimaPrimeiraCarta7, decimaSegundaCarta7, decimaTerceiraCarta7}
        };
        update();
    }

    @FXML
    private void sair(ActionEvent event) {
        try {
            super.finalize();
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
        System.exit(0);
    }
}
