package annotation;

public class App1 {

  public static void main(String[] args) {
    Product p1 = new Product(1, "지우개", 1000);
    Product p2 = new Product(2, "색종이", 2500);

    CreatedAtAnnotionProcessor processor = new CreatedAtAnnotionProcessor();
    processor.process(p1);

    System.out.println(p1);
    System.out.println(p2);
  }
}
