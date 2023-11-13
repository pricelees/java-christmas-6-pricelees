package christmas.service;

import christmas.domain.Customer;
import christmas.util.PriceFormatter;

public abstract class CustomerService {
    final Customer customer;

    public CustomerService(Customer customer) {
        this.customer = customer;
    }

    public String showOrderedMenu() {
        return customer.orderedMenu();
    }

    public String showAmountBeforeDiscount() {
        return PriceFormatter.format(customer.orderAmount());
    }

    public int getDayOfMonth() {
        return customer.dayOfMonthToVisit();
    }

    public abstract String showFreeMenu();

    public abstract String showDiscountDescription();

    public abstract String showTotalBenefitsAmount();

    public abstract String showExpectedAmountToPay();

    public abstract String showEventBadge();
}