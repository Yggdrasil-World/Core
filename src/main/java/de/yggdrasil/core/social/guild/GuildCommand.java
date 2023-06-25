package de.yggdrasil.core.social.guild;

import de.yggdrasil.core.command.RegisterCommand;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentCommand;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.command.builder.arguments.minecraft.ArgumentEntity;
import net.minestom.server.utils.entity.EntityFinder;
import org.jetbrains.annotations.NotNull;

@RegisterCommand
public class GuildCommand extends Command {
    public GuildCommand() {
        super("guild");
        //ArgumentCommand invite = ArgumentType.Command("invite");
        addSubcommand(new InviteCommand());
    }

    private class InviteCommand extends Command {

        public InviteCommand() {
            super("invite");
            ArgumentEntity player = ArgumentType.Entity("player");
            player.onlyPlayers(true);


            addSyntax(((sender, context) -> {
                EntityFinder entity = context.get(player);
                sender.sendMessage(entity.findFirstPlayer(sender).asPlayer().getName());
            }), player);
        }
    }
}
