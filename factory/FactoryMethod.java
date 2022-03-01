package factory;

import java.time.Instant;

/**
 * Padrao de projeto: Factoy Method
 * 
 * @author Rodrigo Andrade
 */
public class FactoryMethod {
   public static void main(String[] args) {
       ProductFactory productFacotry = new ProductFactory();
       Product product = productFacotry.create(ProductType.ELETRONIC);

       System.out.println(product);
   } 
}

// Products
abstract class Product {
    String uuid;
    String name;
    double price;
}

class Eletronic extends Product {
    Instant duration;

    Eletronic() {
        duration = Instant.now();
    }

    @Override
    public String toString() {
        return duration.toString();
    }
}

class Furniture extends Product {
    MaterialType materialType;

    Furniture(MaterialType materialType) {
        this.materialType = materialType;
    }

    @Override
    public String toString() {
        return materialType.toString();
    }
}

// Product Factory
class ProductFactory {
    Product create(ProductType productType) {
        switch(productType) {
            case ELETRONIC:
                return new Eletronic();
            case FURNITURE:
                return new Furniture(MaterialType.WOOD);
            default:
                throw new IllegalArgumentException();
        }
    }
}

enum ProductType {
    ELETRONIC,
    FURNITURE,
}

enum MaterialType {
    WOOD,
    METAL
}