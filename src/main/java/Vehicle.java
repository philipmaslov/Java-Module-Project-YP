import java.util.Scanner;

class Vehicle {
    String vehicleName;
    double vehicleSpeed;
    double vehicleMinSpeed = 0d;
    double vehicleMaxSpeed = 250d;

    Vehicle(Scanner scanner) {
        System.out.println("\n-----===== Созадём автомобиль =====-----");
        vehicleName = askVehicleName(scanner);
        vehicleSpeed = askVehicleSpeed(scanner);
        System.out.println("-----===== Автомобиль создан =====-----\n");
    }

    String getVehicleInfo() {
        return "Название автомобиля: " + this.vehicleName +
                "\nСкорость автомобиля: " + this.vehicleSpeed + " км/ч";
    }

    String askVehicleName(Scanner scanner) {
        System.out.println("Введите название автомобиля." +
                "\nПример: \"Машина 1\"" +
                "\n(макс 32 символа. Мы сократим авматоматически, если потребуется.)");

        String name = scanner.nextLine();

        if (name.length() > 32) {
            name = name.trim().substring(0, 32);
            System.out.println("\nЭто длинное название мы сократили до: " + name);
        }
        return name;
    }

    double askVehicleSpeed(Scanner scanner) {
        double speed = 0d; // Переменная для сохранения скорости автомобиля
        boolean inpIsInt = false;
        boolean inpIsDouble = false;
        do {
            System.out.printf("\nВведите скорость автомобиля.\nЧисло больше %s и до %s включительно:" +
                    "\nпример: 23 или 249.58\n", vehicleMinSpeed, vehicleMaxSpeed);

            String input = scanner.nextLine();

            try {
                speed = Integer.parseInt(input) * 1.0;
                inpIsInt = true;
            } catch (Exception ignored) {
            }

            try {
                speed = Double.parseDouble(input);
                inpIsDouble = true;
            } catch (Exception ignored) {
            }

            if ((inpIsInt || inpIsDouble) && (speed > vehicleMinSpeed && speed <= vehicleMaxSpeed)) {
                break;
            } else {
                System.out.println("Ожидалось другое значение.");
            }
        } while (true);

        return speed;
    }
}