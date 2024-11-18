import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frases frases = new Frases(); // Инициализируем текстовки
        Race race = new Race(); // Инициализиуем гонку
        String input; // Переменная для сохранения ввода из консоли
        boolean whileExitFlag = true; // Флаг для выхода из бесконечных циклов

        System.out.println(frases.welcome);

        while (whileExitFlag) {
            input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "да":
                    whileExitFlag = false;
                    break;
                case "нет":
                    System.out.println(frases.exit);
                    System.exit(0);
                    break;
                default:
                    System.out.println("\"Да\" - продолжить, \"Нет\" - конец программы");
                    break;
            }
        }

        while (race.vehicles.size() != 3) {
            Vehicle vehicle = new Vehicle(scanner);
            race.addVehicleToRace(vehicle);
        }

        race.doRace();
        //race.printRaceInfo(); // Вывести информацию о гонке
    }
}