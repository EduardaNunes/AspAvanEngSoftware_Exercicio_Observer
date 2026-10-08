package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InscritoTest {

    @Test
    void deveNotificarUmInscrito() {
        CanalYoutube canal = new CanalYoutube("DevCast", "Tecnologia");
        Inscrito inscrito = new Inscrito("Marina");
        inscrito.inscrever(canal);
        canal.publicarVideo("Padrões de Projeto na prática");
        assertEquals("Marina foi notificado: novo vídeo 'Padrões de Projeto na prática' no CanalYoutube{nome='DevCast', categoria='Tecnologia'}", inscrito.getUltimaNotificacao());
    }

    @Test
    void deveNotificarInscritos() {
        CanalYoutube canal = new CanalYoutube("DevCast", "Tecnologia");
        Inscrito inscrito1 = new Inscrito("Marina");
        Inscrito inscrito2 = new Inscrito("Lucas");
        inscrito1.inscrever(canal);
        inscrito2.inscrever(canal);
        canal.publicarVideo("Clean Code em 10 minutos");
        assertEquals("Marina foi notificado: novo vídeo 'Clean Code em 10 minutos' no CanalYoutube{nome='DevCast', categoria='Tecnologia'}", inscrito1.getUltimaNotificacao());
        assertEquals("Lucas foi notificado: novo vídeo 'Clean Code em 10 minutos' no CanalYoutube{nome='DevCast', categoria='Tecnologia'}", inscrito2.getUltimaNotificacao());
    }

    @Test
    void deveNotificarInscritoCanalCerto() {
        CanalYoutube canalA = new CanalYoutube("DevCast", "Tecnologia");
        CanalYoutube canalB = new CanalYoutube("CulinariaFacil", "Gastronomia");
        Inscrito inscrito1 = new Inscrito("Ana");
        Inscrito inscrito2 = new Inscrito("Bruno");
        inscrito1.inscrever(canalA);
        inscrito2.inscrever(canalB);
        canalA.publicarVideo("Observer explicado");
        assertEquals("Ana foi notificado: novo vídeo 'Observer explicado' no CanalYoutube{nome='DevCast', categoria='Tecnologia'}", inscrito1.getUltimaNotificacao());
        assertEquals(null, inscrito2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarInscrito() {
        CanalYoutube canal = new CanalYoutube("DevCast", "Tecnologia");
        Inscrito inscrito = new Inscrito("Pedro");
        canal.publicarVideo("Vídeo sem inscrito");
        assertEquals(null, inscrito.getUltimaNotificacao());
    }

}
