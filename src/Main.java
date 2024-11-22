import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        for (int i = 0; i < elementi.length; i++) {
            System.out.println("Inserisci il titolo dell'elemento " + (i + 1) + ":");
            String titolo = scanner.nextLine();

            System.out.println("Inserisci il tipo dell'elemento " + (i + 1) + " (1: Immagine, 2: Video, 3: Registrazione Audio):");
            int tipo = scanner.nextInt();
            scanner.nextLine();

            switch (tipo) {
                case 1:
                    elementi[i] = new Immagine(titolo);
                    break;
                case 2:
                    elementi[i] = new Video(titolo, 3);
                    break;
                case 3:
                    elementi[i] = new Audio(titolo, 5);
                    break;
                default:
                    System.out.println("Tipo di elemento non valido. Imposto Immagine di default");
                    elementi[i] = new Immagine(titolo);
            }

            if (elementi[i] instanceof IPlayable) {
                System.out.println("Inserisci la durata dell'elemento " + (i + 1) + ":");
                int durata = scanner.nextInt();
                ((IPlayable) elementi[i]).setDurata(durata);
                scanner.nextLine();
            }
        }

        int scelta;
        do {
            System.out.println("Scegli l'elemento da riprodurre (1-5) o 0 per uscire:");
            scelta = scanner.nextInt();
            scanner.nextLine();

            if (scelta >= 1 && scelta <= 5) {
                if (elementi[scelta - 1] instanceof IPlayable) {
                    ((IPlayable) elementi[scelta - 1]).play();
                    System.out.println("Desideri alzare o abbassare il volume? (1: Alzare,  2:Abbassare, Altro:Nessuna modifica)");
                    int volume = scanner.nextInt();
                    scanner.nextLine();
                    switch (volume) {
                        case 1:
                            ((IPlayable) elementi[scelta - 1]).alzaVolume();
                            System.out.println("Sto alzando il volume...");
                            break;
                        case 2:
                            ((IPlayable) elementi[scelta - 1]).abbassaVolume();
                            System.out.println("Sto abbassando il volume...");
                            break;
                        default:
                            System.out.println("Nessuna modifica al volume");
                    }
                } else {
                    ((IShow) elementi[scelta - 1]).show();
                    System.out.println("Desideri aumentare o diminuire la luminosità? (1: Aumentare,  2:Diminuire, Altro:Nessuna modifica)");
                    int luminosita = scanner.nextInt();
                    scanner.nextLine();
                    switch (luminosita) {
                        case 1:
                            ((IShow) elementi[scelta - 1]).aumentaLuminosita();
                            System.out.println("Sto aumentando la luminosità...");
                            break;
                        case 2:
                            ((IShow) elementi[scelta - 1]).diminuisciLuminosita();
                            System.out.println("Sto diminuendo la luminosità...");
                            break;
                        default:
                            System.out.println("Nessuna modifica alla luminosità");
                    }
                }
            } else if (scelta != 0) {
                System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);

        System.out.println("Arrivederci!");
        scanner.close();
    }
}