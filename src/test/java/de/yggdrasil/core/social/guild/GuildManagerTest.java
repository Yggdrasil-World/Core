package de.yggdrasil.core.social.guild;

import de.yggdrasil.core.exceptions.StringRegexException;
import de.yggdrasil.core.exceptions.guild.NameNotAvailableException;
import de.yggdrasil.core.player.character.Character;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GuildManagerTest {
    private GuildManagerImpl testManager;
    private Character testCharacter;
    @BeforeEach
    void setUp() {
        testManager = new GuildManagerImpl();
        testCharacter = new Character() {
        };
    }

    @Test
    void guildNameExists() {
        try {
            testManager.createGuild("TestGuild", testCharacter);
        } catch (StringRegexException | NameNotAvailableException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(testManager.guildNameExists("TestGuild"), "Guild name does not existing");
    }

    @Test
    void createGuildWithViableName() {
        Assertions.assertThrows(StringRegexException.class, () -> testManager.createGuild("}[]{", testCharacter), "Viable name not excepted");

    }


    @Test
    void createGuildWithNotViableName() {
        Assertions.assertDoesNotThrow(() -> testManager.createGuild("TestGuild", testCharacter), "Not viable name excepted");
    }
}