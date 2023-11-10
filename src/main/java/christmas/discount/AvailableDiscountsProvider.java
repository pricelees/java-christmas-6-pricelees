package christmas.discount;

import christmas.constants.time.EventTime;
import christmas.domain.SelectedMenu;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DiscountTypesProvider {
    public List<DiscountStrategy> provide(final LocalDateTime visitDate, final SelectedMenu selectedMenu) {
        int dayOfMonth = visitDate.getDayOfMonth();
        DayOfWeek dayOfWeek = visitDate.getDayOfWeek();

        return getAvailableDiscounts(dayOfMonth, dayOfWeek);
    }

    private List<DiscountStrategy> getAvailableDiscounts(int dayOfMonth, DayOfWeek dayOfWeek) {
        List<DiscountStrategy> result = new ArrayList<>();
        if (isBeforeChristmas(dayOfMonth)) {
            result.add(new ChristmasDiscount());
        }
        if (isWeekday(dayOfWeek)) {
            result.add(new WeekdayDiscount());
        }
        if (isWeekend(dayOfWeek)) {
            result.add(new WeekendDiscount());
        }
        if (isSpecialDay(dayOfMonth)) {
            result.add(new SpecialDiscount());
        }
        result.add(new ChampagneDiscount());
        return result;
    }

    private boolean isBeforeChristmas(int dayOfMonth) {
        return dayOfMonth <= EventTime.DAY_OF_MONTH_CHRISTMAS;
    }

    private boolean isWeekday(DayOfWeek dayOfWeek) {
        return EventTime.WEEKDAYS.contains(dayOfWeek);
    }

    private boolean isWeekend(DayOfWeek dayOfWeek) {
        return EventTime.WEEKENDS.contains(dayOfWeek);
    }

    private boolean isSpecialDay(int dayOfMonth) {
        return EventTime.SPECIAL_DISCOUNT_DAYS.contains(dayOfMonth);
    }
}