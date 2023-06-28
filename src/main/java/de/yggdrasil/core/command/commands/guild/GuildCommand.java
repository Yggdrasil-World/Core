package de.yggdrasil.core.command.commands.guild;

import de.yggdrasil.core.Overcraft;
import de.yggdrasil.core.command.RegisterCommand;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.Argument;
import net.minestom.server.command.builder.arguments.ArgumentString;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.command.builder.arguments.ArgumentWord;
import net.minestom.server.command.builder.arguments.minecraft.ArgumentComponent;
import net.minestom.server.command.builder.arguments.minecraft.ArgumentNbtTag;
import net.minestom.server.command.builder.arguments.minecraft.ArgumentResource;


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
                sender.sendMessage("Exception: " + exception.getMessage() + " Error code: " + exception.getErrorCode());
            });
            addSyntax(((sender, context) -> {
                //Overcraft.get().getGuildManager().createGuild(context.get(guildName));
                sender.sendMessage("created guild: " + context.get(guildName));
            }),guildName);
        }
    }
}
