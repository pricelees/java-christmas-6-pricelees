package christmas.discount;

import christmas.constants.discount.DiscountErrorMessage;
import christmas.constants.time.EventTime;
import christmas.domain.Customer;
import java.time.LocalDateTime;

public class WeekendDiscount implements DiscountStrategy {
    private static final String DISCOUNT_TYPE = "주말 할인";
    private static final int DISCOUNT_AMOUNT_PER_ONE_MAIN_MENU = 2023;

    @Override
    public int getDiscountAmount(Customer customer) {
        validateDate(customer.dateToVisit());
        return -(customer.countMainMenu() * DISCOUNT_AMOUNT_PER_ONE_MAIN_MENU);
    }

    @Override
    public void validateDate(LocalDateTime date) {
        validateYearAndMonth(date);
        if (EventTime.WEEKENDS.contains(date.getDayOfWeek())) {
            return;
        }
        throw new IllegalArgumentException(DiscountErrorMessage.NOT_WEEKEND_ERROR.getErrorMessage());
    }

    @Override
    public String getTypeName() {
        return DISCOUNT_TYPE;
    }
}
