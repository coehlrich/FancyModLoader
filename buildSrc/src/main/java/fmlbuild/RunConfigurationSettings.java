package fmlbuild;

import org.gradle.api.Action;
import org.gradle.api.Named;
import org.gradle.api.Project;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.provider.ListProperty;
import org.gradle.api.provider.MapProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Nested;

import javax.inject.Inject;

public abstract class RunConfigurationSettings implements Named {
    private final String name;

    @Inject
    public RunConfigurationSettings(Project project, String name) {
        this.name = name;
        getIdeName().convention(name);
        getWorkingDirectory().convention(project.getLayout().getProjectDirectory());
    }

    @Override
    public String getName() {
        return name;
    }

    public abstract Property<String> getTaskGroup();

    public abstract Property<String> getIdeName();

    public abstract Property<String> getMainClass();

    public abstract DirectoryProperty getWorkingDirectory();

    public abstract ListProperty<String> getProgramArgs();

    public abstract ListProperty<String> getJvmArgs();

    public abstract MapProperty<String, String> getSystemProperties();

    @Nested
    public abstract RunConfigurationDependencies getDependencies();

    public void dependencies(Action<? super RunConfigurationDependencies> action) {
        action.execute(getDependencies());
    }
}
