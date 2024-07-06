package fmlbuild;

import org.gradle.api.Project;
import org.gradle.api.file.RegularFileProperty;

import javax.inject.Inject;

public abstract class NeoForgeServerInstallation extends NeoForgeInstallation {
    @Inject
    public NeoForgeServerInstallation(Project project, String name) {
        super(project, name);

        // Write the JVM args to files
        getNeoForgeJvmArgFile().set(getDirectory().file("neoforge_jvm_args.txt"));
        getNeoForgeMainClassArgFile().set(getDirectory().file("neoforge_mainclass.txt"));
        getNeoForgeProgramArgFile().set(getDirectory().file("neoforge_args.txt"));
    }

    public abstract RegularFileProperty getNeoForgeJvmArgFile();

    public abstract RegularFileProperty getNeoForgeMainClassArgFile();

    public abstract RegularFileProperty getNeoForgeProgramArgFile();
}
