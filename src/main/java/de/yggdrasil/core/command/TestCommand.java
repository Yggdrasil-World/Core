package de.yggdrasil.core.command;

import net.minestom.server.command.builder.Command;

/**
 * A TestClass which can be deleted in the future and should not be used by any production ready code
 */
@Deprecated
@RegisterCommand
public class TestCommand extends Command {

    public TestCommand() {
        super("test");
        setDefaultExecutor((sender, context) -> sender.sendMessage("Test!"));
    }
}