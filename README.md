# NoLocalGlow

Client-only Fabric mod for Minecraft Java 1.21.11. It makes `Entity.isGlowing()` return `false` locally for base entities and living entities, so the vanilla entity-outline renderer should not draw the Glow outline on this client. It does not send packets or change server entity data.

## Compatibility

- Minecraft Java 1.21.11
- Fabric Loader 0.18.x or newer
- Java 21
- Designed to coexist with Sodium; not runtime-tested against every Sodium build or Android launcher.

## Build

You need a Java 21 JDK and Gradle installed.

From this project directory, run:

```sh
gradle build
```

The remapped mod jar should be produced in:

```text
build/libs/NoLocalGlow-1.0.0.jar
```

## Install in M J Launcher

1. Build the project on a computer or another environment that has Java 21 and Gradle.
2. Copy `build/libs/NoLocalGlow-1.0.0.jar` to the `mods` folder used by the Minecraft 1.21.11 Fabric profile in M J Launcher.
3. Keep Fabric Loader enabled. No Fabric API dependency is required by this mod.
4. Launch the game and test with an entity that has the Glow effect.

## Important verification note

This source project is provided for building. The JAR has **not** been compiled or tested in this environment. The Yarn 1.21.11 API documentation confirms that `Entity.isGlowing()` is the client-side flag check and that `LivingEntity` overrides it; the two mixins target those methods. If the build reports a Loom/plugin resolution error, use a current compatible Fabric Loom remap plugin version for Minecraft 1.21.11. If the game reports a Mixin application error, remove the JAR from `mods` and share `latest.log`.

The mod hides the outline by making the local client report that entities are not glowing. This may also affect any other client feature that relies on `isGlowing()`, not just the outline.
