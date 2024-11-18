import java.util.HashMap;

public class Race {
    String raceName = "24 часа Леман";
    Vehicle raceWinner;
    HashMap<String, Vehicle> vehicles = new HashMap<>(); // Машины для участия в гонке

    boolean checkDuplicatesVehicleName(Vehicle vehicle) {
        return this.vehicles.containsKey(vehicle.vehicleName);
    }

    boolean checkDuplicatesVehicleSpeed(Vehicle vehicle) {
        for (String key : vehicles.keySet()) {
            if (vehicle.vehicleSpeed == vehicles.get(key).vehicleSpeed) {
                return true;
            }
        }
        return false;
    }

    void addVehicleToRace(Vehicle vehicle) {
        if (checkDuplicatesVehicleName(vehicle)) {
            System.out.println("\nАвтомобиль \"" + vehicle.vehicleName + "\" уже в списке." +
                    "\nЗначение скорости обновлено на: " + vehicle.vehicleSpeed + "\n");
            this.vehicles.put(vehicle.vehicleName, vehicle);
        } else if (checkDuplicatesVehicleSpeed(vehicle)) {
            System.out.println("\nАвтомобиль \"" + vehicle.vehicleName + "\" нельзя добавить в гонку, " +
                    "\nт.к. в нём уже есть автомобиль с такой же скоростью. " +
                    "\nПобедитель должен быть только один. " +
                    "\nИзмените скорость автомобиля и добавьте его повторно.\n");
        } else {
            this.vehicles.put(vehicle.vehicleName, vehicle);
        }
    }

    void printRaceInfo() {
        System.out.println("\n-----===== Информация о гонке ======------");
        System.out.println("Гонка: " + this.raceName);
        System.out.println("Количество заявленных автомобилей: " + this.vehicles.size());
        for (String key : this.vehicles.keySet()) {
            System.out.println(vehicles.get(key).getVehicleInfo());
        }
        System.out.println("-----===== Конец ======------\n");
    }

    void doRace() {
        System.out.println("\n-----===== Гонка началась ======------");
        System.out.println("Самая быстрая машина: " + this.raceWinnerCalculate().vehicleName);
        System.out.println("-----===== Гонка завершена ======------\n");

    }

    Vehicle raceWinnerCalculate() {
        int count = 1;
        for (String key : vehicles.keySet()) {
            if (count == 1) {
                this.raceWinner = vehicles.get(key);
                count++;
            } else if (this.raceWinner.vehicleSpeed < vehicles.get(key).vehicleSpeed) {
                this.raceWinner = vehicles.get(key);
            }
        }
        return this.raceWinner;
    }
}
