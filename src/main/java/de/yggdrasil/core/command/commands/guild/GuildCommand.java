package de.yggdrasil.core.command.commands.guild;

import de.yggdrasil.core.command.RegisterCommand;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentString;
import net.minestom.server.command.builder.arguments.ArgumentType;


@RegisterCommand
public class GuildCommand extends Command {
    public GuildCommand() {
        super("guild");
        //ArgumentCommand invite = ArgumentType.Command("invite");
        addSubcommand(new Create());
    }

    private static class Create extends Command {

        public Create() {
            super("create");
            ArgumentGuildName guildName = new ArgumentGuildName("guild-name");
            guildName.setCallback((sender, exception) -> {
                sender.sendMessage("Exception: " + exception.getMessage() + " Error code: " + exception.getErrorCode());
            });

            addSyntax(((sender, context) -> {
                sender.sendMessage("test");
            }),guildName);
        }
    }
}
