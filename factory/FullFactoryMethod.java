package factory;

/**
 * Forma completa do Factory Method
 * descrita no Livro do GOF.
 * 
 * 1) Abstract creator
 * 2) Abstract product
 * 3) Concrete creator
 * 4) Concrete product
 * 
 * @author Rodrigo Andrade
 */
public class FullFactoryMethod {

    public static void main(String[] args) {
        ProductFactory productFactory = new ProductConcreteFactory();
        productFactory.create().sayHi();

        productFactory = new ProductConcreteFactoryPlus();
        productFactory.create().sayHi();
    }

    // Creator
    static interface ProductFactory {
        Product create();
    }

    static class ProductConcreteFactory implements ProductFactory {
        @Override
        public Product create() {
            return new ProductConcrete();
        }
    }

    static class ProductConcreteFactoryPlus implements ProductFactory {
        @Override
        public Product create() {
            return new ProductConcretePlus();
        }
    }

    // Product
    static interface Product {
        void sayHi();
    }

    static class ProductConcrete implements Product {
        @Override
        public void sayHi() {
            System.out.println("Hi from product concrete");
        }
    }

    static class ProductConcretePlus implements Product {
        @Override
        public void sayHi() {
            System.out.println("Hi from product concrete plus");
        }
    }
}
