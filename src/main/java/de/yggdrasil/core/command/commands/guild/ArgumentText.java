package de.yggdrasil.core.command.commands.guild;


import net.minestom.server.command.builder.arguments.Argument;
import net.minestom.server.command.builder.arguments.ArgumentLiteral;
import net.minestom.server.command.builder.arguments.minecraft.ArgumentResource;
import net.minestom.server.command.builder.exception.ArgumentSyntaxException;
import net.minestom.server.utils.StringUtils;
import org.jetbrains.annotations.NotNull;


public class ArgumentText extends Argument<String> {

    public static final int SPACE_ERROR = 1;

    public ArgumentText(@NotNull String id) {
        super(id, false);
    }

    /**
     * @param input the argument to parse
     * @return
     * @throws ArgumentSyntaxException
     */
    @Override
    public @NotNull String parse(@NotNull String input) throws ArgumentSyntaxException {
        if (input.contains(StringUtils.SPACE))
            throw new ArgumentSyntaxException("Text argument doesn't allow spaces", input, SPACE_ERROR);
        return input;
    }

    /**
     * @return
     */
    @Override
    public String parser() {
        return "null";
    }
    @Override
    public String toString() {
        return String.format("Guild<%s>", getId());
    }
}
