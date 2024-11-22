class Audio extends ElementoMultimediale implements IPlayable{
    private int durata;
    private int volume = 5;

    public Audio(String titolo, int durata) {
        super(titolo);
        this.durata = 5;
        this.volume = volume;
    }

    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + " " + ("!").repeat(volume));
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

    public void setDurata(int durata) {
        this.durata = durata;
    }
}