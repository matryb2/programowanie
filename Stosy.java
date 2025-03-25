import java.util.*;

class Stosy {
    private Set<String> uczestnicy;
    private Queue<String> kolejkaUczestnikow;
    private Map<String, Integer> numeryStartowe;
    private Scanner scanner;

    public Stosy() {
        this.uczestnicy = new TreeSet<>();
        this.kolejkaUczestnikow = new LinkedList<>();
        this.numeryStartowe = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void dodajUczestnika() {
        System.out.print("Podaj imię i nazwisko uczestnika: ");
        String imieNazwisko = scanner.nextLine();
        System.out.print("Podaj numer startowy: ");
        int numerStartowy = scanner.nextInt();
        scanner.nextLine();

        if (uczestnicy.add(imieNazwisko)) {
            kolejkaUczestnikow.offer(imieNazwisko);
            numeryStartowe.put(imieNazwisko, numerStartowy);
            System.out.println(imieNazwisko + " został dodany z numerem startowym " + numerStartowy);
        } else {
            System.out.println("Uczestnik " + imieNazwisko + " już istnieje w systemie.");
        }
    }

    public void wyswietlUczestnikow() {
        System.out.println("Lista uczestników:");
        for (String uczestnik : uczestnicy) {
            System.out.println(uczestnik + " (Numer: " + numeryStartowe.get(uczestnik) + ")");
        }
    }

    public void usunUczestnika() {
        System.out.print("Podaj imię i nazwisko uczestnika do usunięcia: ");
        String osoba = scanner.nextLine();

        if (uczestnicy.remove(osoba)) {
            kolejkaUczestnikow.remove(osoba);
            numeryStartowe.remove(osoba);
            System.out.println("Uczestnik " + osoba + " został usunięty.");
        } else {
            System.out.println("Nie znaleziono uczestnika: " + osoba);
        }
    }

    public void sprawdzObecnosc() {
        System.out.print("Podaj imię i nazwisko uczestnika: ");
        String osoba = scanner.nextLine();

        if (uczestnicy.contains(osoba)) {
            System.out.println(osoba + " jest zapisany na listę.");
        } else {
            System.out.println(osoba + " nie jest zapisany na listę.");
        }
    }

    public void menu() {
        while (true) {
            System.out.println("Wybierz operację:");
            System.out.println("1 - Dodaj uczestnika");
            System.out.println("2 - Wyświetl uczestników");
            System.out.println("3 - Usuń uczestnika");
            System.out.println("4 - Sprawdź obecność");
            System.out.println("5 - Zakończ");
            System.out.print("Wybór: ");

            int wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    dodajUczestnika();
                    break;
                case 2:
                    wyswietlUczestnikow();
                    break;
                case 3:
                    usunUczestnika();
                    break;
                case 4:
                    sprawdzObecnosc();
                    break;
                case 5:
                    System.out.println("Zamykanie programu...");
                    return;
                default:
                    System.out.println("Niepoprawny wybór, spróbuj ponownie.");
            }
        }
    }

    public static void main(String[] args) {
        Stosy konkurs = new Stosy();
        konkurs.menu();
    }
}
