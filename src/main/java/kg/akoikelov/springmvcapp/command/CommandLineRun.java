package kg.akoikelov.springmvcapp.command;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CommandLineRun implements CommandLineRunner {

  @Autowired
  List<Command> commands;

  @Override
  public void run(String... args) throws Exception {
    Arguments arguments = new Arguments();
    JCommander.newBuilder()
            .addObject(arguments)
            .build()
            .parse(args);

    String commandName = arguments.getCommandName(); // Команда которую мы хотим запустить

    Optional<Command> command = commands.stream().filter(c -> c.getName().equals(commandName)).findFirst();

    if (command.isPresent()) {
      command.get().run();
    } else {
      System.out.println("Command not found");
    }

  }

  private static class Arguments {

    @Parameter(names = {"-command", "-c"}, description = "Command name")
    String commandName;

    public String getCommandName() {
      return commandName;
    }

    public void setCommandName(String commandName) {
      this.commandName = commandName;
    }
  }

}
