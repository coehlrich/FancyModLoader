package fmlbuild;

import org.gradle.api.Named;
import org.gradle.api.Project;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.ListProperty;
import org.gradle.api.provider.Property;

public abstract class NeoForgeInstallation implements Named {
    private final String name;

    public NeoForgeInstallation(Project project, String name) {
        this.name = name;
        getDirectory().convention(project.getLayout().getBuildDirectory().dir("installs/" + name));
    }

    @Override
    public String getName() {
        return name;
    }

    public abstract Property<String> getVersion();

    public abstract Property<String> getMinecraftVersion();

    public abstract DirectoryProperty getDirectory();
}
