package strategy;

import java.math.BigDecimal;

/**
 * Estudo do padrao de projeto Strategy.
 * 
 * @author Rodrigo Andrade
 */
public class Strategy {

    public static void main(String[] args) {
        Buy buy = new Buy(new BigDecimal(100));
        buy.processPayment(new CredtiCardPayment());
        buy.processPayment(value -> System.out.println("Payment process with lambda: " + value.paymentValue()));
    }

    /**
     * Strategy use context
     */
    static class Buy implements Payable {
        private BigDecimal value;

        public Buy(BigDecimal value) {
            this.value = value;
        }

        /**
         * Context execution
         * 
         * @param payment PaymentStrategy
         */
        public void processPayment(Payment payment) {
            payment.exec(this);
        }

        @Override
        public BigDecimal paymentValue() {
            return this.value;
        }

    }

    /**
     * Middleware interface to segragate Buy and Strategy algorithms.
     */
    static interface Payable {
        BigDecimal paymentValue();
    }

    /**
     * Payment strategy
     */
    static interface Payment {
        void exec(Payable payable);
    }

    static class WidthdrawCardPayment implements Payment {
        @Override
        public void exec(Payable payable) {
            System.out.println("Payment with witdraw card: " + payable.paymentValue());
        }
    }

    static class CredtiCardPayment implements Payment {
        @Override
        public void exec(Payable payable) {
            System.out.println("Payment with credit card has a fee of 5.00 dolars: " + payable.paymentValue().add(new BigDecimal(5)));
        }
    }

    static class CashPayment implements Payment {
        @Override
        public void exec(Payable payable) {
            System.out.println("Payment with cash $: " + payable.paymentValue());
        }
    }
}