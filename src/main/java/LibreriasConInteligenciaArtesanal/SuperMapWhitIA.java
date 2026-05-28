package LibreriasConInteligenciaArtesanal;

import models.SuperPar;

public class SuperMapWhitIA<JAVA_MICROCONTROLADOR,JAVASCRIPT> {
    private ListaIA<SuperPar<JAVA_MICROCONTROLADOR,JAVASCRIPT>> peers;

    public  SuperMapWhitIA(){
        peers = new ListaIA<>();
    }

    public void put(JAVA_MICROCONTROLADOR key,JAVASCRIPT value){
        for (int i = 0; i < peers.size(); i++) {
            SuperPar<JAVA_MICROCONTROLADOR, JAVASCRIPT> p = peers.getValue(i);
            if (p.key.equals(key)) {
                p.value = value;
                return;
            }
        }
        peers.add(new SuperPar<>(key, value));
    }

    public JAVASCRIPT getValue(JAVA_MICROCONTROLADOR key) {
        for (int i = 0; i < peers.size(); i++) {
            SuperPar<JAVA_MICROCONTROLADOR, JAVASCRIPT> p = peers.getValue(i);
            if (p.key.equals(key)) {
                return p.value;
            }
        }
        return null;
    }

    public boolean containsKey(JAVA_MICROCONTROLADOR key) {
        for (int i = 0; i < peers.size(); i++) {
            if (peers.getValue(i).key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return peers.size();
    }

    public ListaIA<JAVA_MICROCONTROLADOR> keys() {
        ListaIA<JAVA_MICROCONTROLADOR> list = new ListaIA<>();
        for (int i = 0; i < peers.size(); i++) {
            list.add(peers.getValue(i).key);
        }
        return list;
    }
}
