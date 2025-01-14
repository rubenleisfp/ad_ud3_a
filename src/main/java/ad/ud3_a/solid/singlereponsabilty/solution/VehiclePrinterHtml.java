package ad.ud3_a.solid.singlereponsabilty.solution;

public class VehiclePrinterHtml {
	
	public void print(Vehicle vehicle) {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<h6>");
		sb.append("Numero de ruedas: ");
		sb.append(vehicle.getWheelCount());
		sb.append("</h6>");
		sb.append("<h6>");
		sb.append("Velocidad Maxima: ");
		sb.append(vehicle.getMaxSpeed());
		sb.append("</h6>");
		sb.append("<html>");

		System.out.println(sb.toString());
	}

}
