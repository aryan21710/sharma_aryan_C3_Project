import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class RestaurantTest {
    Restaurant restaurant;
    // REFACTOR ALL THE REPEATED LINES OF CODE
    int initialMenuSize;
    Restaurant mockRestaurant;
    List<String> itemsOrdered;
    @BeforeEach
    public void setup() {
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant = new Restaurant("Amelie's cafe", "Chennai", openingTime, closingTime);
        restaurant.addToMenu("Sweet corn soup", 120);
        restaurant.addToMenu("Vegetable lasagne", 260);
        initialMenuSize = restaurant.getMenu().size();
        mockRestaurant = (Restaurant) Mockito.spy(restaurant);
        itemsOrdered = new ArrayList<String>();
        itemsOrdered.add("Sweet corn soup");
        itemsOrdered.add("Vegetable lasagne");

    }

    // >>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    // -------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN
    // INTO ANY TROUBLE
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time() {
        // WRITE UNIT TEST CASE HERE
        Mockito.when(mockRestaurant.getCurrentTime()).thenReturn(LocalTime.of(21, 30, 00));
        assertTrue(mockRestaurant.isRestaurantOpen());

    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time() {
        // WRITE UNIT TEST CASE HERE
        Mockito.when(mockRestaurant.getCurrentTime()).thenReturn(LocalTime.of(23, 30, 00));
        assertFalse(mockRestaurant.isRestaurantOpen());

    }

    // <<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    // >>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1() {
        restaurant.addToMenu("Sizzling brownie", 319);
        assertEquals(initialMenuSize + 1, restaurant.getMenu().size());
    }

    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize - 1, restaurant.getMenu().size());
    }

    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {
        assertThrows(itemNotFoundException.class, () -> restaurant.removeFromMenu("French fries"));
    }
    // <<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    
}