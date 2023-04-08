package Calisma.AnimalInterface;

import java.util.Objects;

public class Cat  implements Animal{
    public String name;
    public  Cat(String name){
        this.name = name;
    }
    @Override
    public String voice() {
        return "Meow!";
    }
    @Override
    public int walk() {
        return 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return name.equals(cat.name);
    }

}
