package ad.ud3_a.solid.singlereponsabilty.solution;

public class App {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();

        //Mi clase vehiculo representa un dato, un modelo, no necesita saber como pintarse
        //Es mejor divir responsabilidades. Hare tantas clases como manera de mostrar el vehiculo necesite
        VehiclePrinterCSV csvPrinter = new VehiclePrinterCSV();
        VehiclePrinterHtml htmlPrinter = new VehiclePrinterHtml();
        System.out.println("### CSV ###");
        csvPrinter.print(vehicle);
        System.out.println("### HTML ###");
        htmlPrinter.print(vehicle);


    }
}
