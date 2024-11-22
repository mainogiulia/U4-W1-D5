class Immagine extends ElementoMultimediale implements IShow{
    private int luminosita = 4;

    public Immagine(String titolo) {
        super(titolo);
        this.luminosita = luminosita;
    }

    public void show() {
            System.out.print(titolo + " ");
        for (int i = 0; i < luminosita; i++) {
            System.out.print("*");
        }
        System.out.println(" ");
    }

    public void aumentaLuminosita() {
        if (luminosita > 1) {
            luminosita--;
        }
    }

    public void diminuisciLuminosita() {
        luminosita++;
    }
}