import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws restaurantNotFoundException {
    Restaurant res = new Restaurant("Haldiram", "buldi", LocalTime.of(19, 40, 00), LocalTime.of(21, 00, 00));
    res.addToMenu("pizza", 200);
    res.addToMenu("samosa", 50);
    res.addToMenu("sandwich", 100);

    List<Item> menuServed = res.getMenu();
    System.out.println("+++++++++++++++MENU+++++++++++++");
    for (Item item : menuServed) {
      System.out.print("Item :-" + item.toString());
    }
    System.out.println("+++++++++++++++MENU+++++++++++++");

    System.out.println("RESTAUTANT " + res.getName() + " IS CURRENTLY OPEN " + res.isRestaurantOpen());

    RestaurantService resService = new RestaurantService();
    resService.addRestaurant("Toit", "Indiranagar", LocalTime.of(9, 30, 00), LocalTime.of(21, 00, 00));
    resService.addRestaurant("ShantiSagar", "MG road", LocalTime.of(9, 30, 00), LocalTime.of(21, 00, 00));
    resService.addRestaurant("Tandoor", "Koramangala", LocalTime.of(9, 30, 00), LocalTime.of(21, 00, 00));

    Restaurant foundRes = resService.findRestaurantByName("ShantiSaga");
    foundRes.addToMenu("Lasagne", 200);
    foundRes.addToMenu("Mushroom 65", 50);
    foundRes.addToMenu("Paneer 65", 100);
    List<String> itemsOrdered = new ArrayList<String>();
    itemsOrdered.add("Lasagne");
    itemsOrdered.add("Mushroom 65");
    itemsOrdered.add("Paneer 65");
    int orderValue = foundRes.calculateTotalPrice(itemsOrdered);
    System.out.println("orderValue:-" + orderValue);
    if (!Objects.isNull(foundRes))
      foundRes.displayDetails();

  }
}