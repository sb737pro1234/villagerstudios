# VillagerStudioWorldGenerator

Paper 26.2 / Java 25 / Maven custom void generator with Multiverse-Core support.

## Build

Open the project in IntelliJ IDEA as a Maven project, select a Java 25 JDK, then run:

```bash
mvn clean package
```

The JAR will be created at:

```text
target/VillagerStudioWorldGenerator.jar
```

Copy it to the server's `plugins` directory and restart the server.

## Configure

Edit `plugins/VillagerStudioWorldGenerator/config.yml`:

```yaml
worlds:
  - skyblock
```

The configured world name must be listed before you create the world if you want the generator to place its spawn bedrock during chunk generation.

## Multiverse-Core

List loaded generators:

```text
/mv gens
```

Create a fresh Overworld:

```text
/mv create skyblock normal --generator VillagerStudioWorldGenerator
```

Then verify the origin spawn block and empty chunks. Use a new world folder; this plugin does not erase terrain from existing worlds.

## Admin command

```text
/vswg reload
```

Reloads the configured world list and reapplies spawn setup to configured worlds that are already loaded.

## Behaviour

- New chunks generated with this generator are void.
- For configured Overworlds, one bedrock block is generated at `(0, 64, 0)`.
- World spawn is set to `(0.5, 65, 0.5)`, directly above that block.
- Nether and End support are intentionally excluded.
- The generator never clears an existing chunk or deletes saved terrain.
