package kg.akoikelov.springmvcapp.command;

public interface Command {

  void run();

  String getName();

  default void showHeader() {
    System.out.println();

    System.out.println("******* " + this.getName() + " *******");
    System.out.println();
  }
}
