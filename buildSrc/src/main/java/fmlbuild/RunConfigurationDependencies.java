package fmlbuild;

import org.gradle.api.artifacts.dsl.Dependencies;
import org.gradle.api.artifacts.dsl.DependencyCollector;

public interface RunConfigurationDependencies extends Dependencies {
    DependencyCollector getClasspath();

    DependencyCollector getModulepath();
}
