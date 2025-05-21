enum Sizes {
    XXS(32) {
        @Override
        String getDescription() {
            return "Детский размер";
        }
    },
    XS(34), S(36), M(38), L(40);
    int euroSize;
    Sizes(int euroSize) {
        this.euroSize = euroSize;
    }

    String getDescription() {
        return "Взрослый размер";
    }

}
interface manCloth{
    void dressManCloth();
}

interface womanCloth{
    void dressWomanCloth();
}
abstract class Cloth{
    Sizes size;
    int price;
    String colour;
    Cloth(Sizes size, int price, String colour){
        this.size = size;
        this.price = price;
        this.colour = colour;
    }
}

class Shirt extends Cloth implements manCloth, womanCloth{
    Shirt(Sizes size, int price, String colour){
        super(size,price,colour);
    }
    @Override
    public void dressManCloth() {
        System.out.println("Мужская футболка");
    }

    @Override
    public void dressWomanCloth() {
        System.out.println("Женская футболка");
    }
}

class Pants extends Cloth implements manCloth, womanCloth{
    Pants(Sizes size, int price, String colour) {
        super(size, price, colour);
    }

    @Override
    public void dressManCloth() {
        System.out.println("Мужские штаны");
    }

    @Override
    public void dressWomanCloth() {
        System.out.println("Женская штаны");
    }
}
class Skirt extends Cloth implements womanCloth{
    Skirt(Sizes size, int price, String colour) {
        super(size, price, colour);
    }

    @Override
    public void dressWomanCloth() {
        System.out.println("Женская юбка");
    }
}
class Tie extends Cloth implements manCloth{
    Tie(Sizes size, int price, String colour) {
        super(size, price, colour);
    }

    @Override
    public void dressManCloth() {
        System.out.println("Мужской галстук");
    }
}

class Atelier {
    public void dressManCloth(Cloth[] clothes) {
        System.out.println("Мужская одежда");
        for (Cloth item : clothes) {
            if (item instanceof manCloth) {
                ((manCloth) item).dressManCloth();
            }
        }
    }

    public void dressWomanCloth(Cloth[] clothes) {
        System.out.println("Мужская одежда");
        for (Cloth item : clothes) {
            if (item instanceof womanCloth) {
                ((womanCloth) item).dressWomanCloth();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Cloth[] clothes = {
                new Shirt(Sizes.S, 990, "Белая"),
                new Pants(Sizes.M, 1490, "Черные"),
                new Skirt(Sizes.XS, 790, "Черная"),
                new Tie(Sizes.L, 490, "Серый")
        };
        Atelier atelier = new Atelier();
        atelier.dressWomanCloth(clothes);
        atelier.dressManCloth(clothes);
    }
}