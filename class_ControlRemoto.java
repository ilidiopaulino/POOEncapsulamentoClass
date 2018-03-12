package poo;

/**
 * @author IJIP productions
 */
public class class_ControlRemoto implements interfaceControlador {

    private int volume;
    private boolean ligado;
    private boolean tocando;

    private  int getVolume() {
        return this.volume;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    private boolean getLigado() {
        return ligado;
    }

    private void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    private boolean getTocando() {
        return tocando;
    }

    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }

    public class_ControlRemoto() {
        this.volume = 50;
        this.ligado = true;
        this.tocando = false;
    }

    @Override
    public void ligar() {
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void abrirMenu() {
        System.out.println("esta ligado: "+this.getLigado());
        System.out.println("volume: "+this.getVolume());
        System.out.println("esta tocando: "+this.getTocando());
        
        for (int i = 0; i <= this.getVolume(); i += 10) {
            System.out.print("|");
        }
        System.out.println("");
    }

    @Override
    public void fecharMenu() {
        System.out.println("fechando Menu...");
    }

    @Override
    public void maisVolume() {
        if(this.getLigado()){
            this.setVolume(this.getVolume()+5);
        }else System.out.println("aparelho desligado, impossivel subir volume");
    }

    @Override
    public void menosVolume() {
         if(this.getLigado()){
            this.setVolume(this.getVolume()-5);
        }else System.out.println("aparelho desligado, impossivel diminuir volume");
    }

    @Override
    public void ligarMudo() {
        if(this.getLigado() && (this.getVolume()>0)){
            this.setVolume(0);
            this.setTocando(false);/*achei melhor acrescentar esse comando
            porque se ligar o mudo entao nao toca*/
        }
    }

    @Override
    public void desligarMudo() {
        if(this.getLigado() &&(this.getVolume()==0)){
            this.setVolume(50);
            this.setTocando(true);//achei melhor acrescentar esse comando
        }
    }

    @Override
    public void play() {
        if(this.getLigado()&& !(this.getTocando())){
            this.setTocando(true);
        }
    }

    @Override
    public void pause() {
        if(this.getLigado() && this.getTocando()){
            this.setTocando(false);
        }
    }

}
