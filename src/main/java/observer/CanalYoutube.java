package observer;

import java.util.Observable;

public class CanalYoutube extends Observable {

    private String nome;
    private String categoria;

    public CanalYoutube(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public void publicarVideo(String titulo) {
        setChanged();
        notifyObservers(titulo);
    }

    @Override
    public String toString() {
        return "CanalYoutube{" +
                "nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}