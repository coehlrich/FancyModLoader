package fmlbuild;

import org.gradle.api.Project;
import org.gradle.api.file.RegularFileProperty;

import javax.inject.Inject;

public abstract class NeoForgeClientInstallation extends NeoForgeInstallation {
    @Inject
    public NeoForgeClientInstallation(Project project, String name) {
        super(project, name);
        getVanillaJvmArgFile().convention(getDirectory().file("vanilla_jvm_args.txt"));
        getVanillaMainClassArgFile().convention(getDirectory().file("vanilla_main_class.txt"));
        getVanillaProgramArgFile().convention(getDirectory().file("vanilla_args.txt"));
        getNeoForgeJvmArgFile().convention(getDirectory().file("neoforge_jvm_args.txt"));
        getNeoForgeMainClassArgFile().convention(getDirectory().file("neoforge_main_class.txt"));
        getNeoForgeProgramArgFile().convention(getDirectory().file("neoforge_args.txt"));
    }

    // Write the JVM args to files
    public abstract RegularFileProperty getVanillaJvmArgFile();

    public abstract RegularFileProperty getVanillaMainClassArgFile();

    public abstract RegularFileProperty getVanillaProgramArgFile();

    public abstract RegularFileProperty getNeoForgeJvmArgFile();

    public abstract RegularFileProperty getNeoForgeMainClassArgFile();

    public abstract RegularFileProperty getNeoForgeProgramArgFile();
}
