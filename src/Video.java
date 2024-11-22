class Video extends ElementoMultimediale implements IPlayable{
    private int durata;
    private int volume = 5;
    private int luminosita = 3;

    public Video(String titolo, int durata) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }

    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + " " + ("!").repeat(volume) + " " + ("*").repeat(luminosita));
        }
    }

    public void abbassaVolume() {
        if (volume > 1) {
            volume--;
        }
    }

    public void alzaVolume() {
        volume++;
    }

    public void aumentaLuminosita() {
        luminosita++;
    }

    public void diminuisciLuminosita() {
        if (luminosita > 1) {
            luminosita--;
        }
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }
}