package de.yggdrasil.core.command.commands.guild;

import de.yggdrasil.core.command.RegisterCommand;
import de.yggdrasil.core.strings.GuildCommandMessages;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentWord;


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
            ArgumentWord guildName = new ArgumentWord("guild-name");
            guildName.setCallback((sender, exception) -> {
                sender.sendMessage(GuildCommandMessages.NAME_EXCEPTION.formatted(exception.getMessage(),exception.getErrorCode()));
            });
            addSyntax(((sender, context) -> {
                //Overcraft.get().getGuildManager().createGuild(context.get(guildName));
                sender.sendMessage(GuildCommandMessages.GUILD_CREATED.formatted(context.get(guildName)));
            }),guildName);
        }
    }
}
