package de.yggdrasil.core.permission;

import net.minestom.server.permission.Permission;
import org.jglrxavpok.hephaistos.nbt.NBTCompound;

public interface PermissionAttributeReader {
    boolean hasDescription();
    String getDescription();
    boolean hasDisplayName();
    String getDisplayName();


    static PermissionAttributeReader ReaderOf(Permission permission) {
        NBTCompound nbt = permission.getNBTData();
        final boolean hasDescription;
        final String description;
        final boolean hasDisplayName;
        final String displayName;
        if(nbt == null) {
            hasDescription = false;
            description = null;
            hasDisplayName = false;
            displayName = null;
        }else {
            hasDescription = nbt.contains("description");
            description = nbt.getString("description");
            hasDisplayName = nbt.contains("display-name");
            displayName = nbt.getString("display-name");
        }

        return new PermissionAttributeReader() {
            @Override
            public boolean hasDescription() {
                return hasDescription;
            }

            @Override
            public String getDescription() {
                return description;
            }

            @Override
            public boolean hasDisplayName() {
                return hasDisplayName;
            }

            @Override
            public String getDisplayName() {
                return displayName;
            }
        };

    }
}
