package de.yggdrasil.core.permission;

import net.minestom.server.permission.Permission;
import org.jglrxavpok.hephaistos.nbt.NBTCompound;

public class PermissionSaver {
    public PermissionSaver() {
        Permission permission = new Permission("test.permission", new NBTCompound());
        
    }
}
