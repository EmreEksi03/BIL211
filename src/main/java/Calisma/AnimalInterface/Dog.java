package Calisma.AnimalInterface;

public class Dog implements Animal {
    public String name;
    public Dog(String name){
        this.name = name;
    }
    @Override
    public String voice() {
        return "Bark!!";
    }

    @Override
    public int walk() {
        return 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return name.equals(dog.name);
    }
}
