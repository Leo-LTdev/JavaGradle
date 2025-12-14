# JavaGradle - A Console-Based RPG Adventure

This project is a classic text-based RPG (Role-Playing Game) built in Java and managed with Gradle. Players create a character, battle monsters, gain experience, and collect loot in a fantasy setting.

## Project Overview

The game is a console application that immerses the player in a simple yet engaging RPG world. You start by choosing your character's race, which determines your initial stats. From there, you navigate through a menu to engage in turn-based combat with various monsters, manage your inventory, and grow your character's power.

### Gameplay Features

-   **Character Creation**: Choose from classic fantasy races: Human, Elf, or Dwarf.
-   **Turn-Based Combat**: Engage in strategic fights against a variety of monsters.
-   **Random Encounters**: Face different enemies like Orcs, Undead, and Tyranides, each with unique stats.
-   **Experience & Leveling**: Defeat monsters to gain experience points and level up your character.
-   **Loot System**: Monsters drop valuable items upon defeat, including weapons, armor, and potions.
-   **Inventory Management**: Equip the best gear and use potions strategically to survive.
-   **Resting**: Recover health between fights to prepare for the next encounter.

## Technical Architecture & Design Patterns

This project was designed with a strong emphasis on clean code, scalability, and software design principles. The architecture leverages several key design patterns to ensure a decoupled and maintainable codebase.

### Core Class Hierarchy

The entity system is built upon a clear inheritance structure:

-   `Character` (Abstract Class): Provides the base attributes and functionalities for all living entities in the game (e.g., `life`, `attack`, `dealDamage()`).
-   `Aventurer`: Represents the player's character, inheriting from `Character` and adding features like an `inventory`, `gear`, and an experience system.
-   `Monster`: Represents the enemies, also inheriting from `Character` and adding monster-specific attributes like the experience value they provide upon defeat.

### Implemented Design Patterns

As detailed in the `Architecture.md` file, the project makes extensive use of the following patterns:

1.  **Builder Pattern**: Used for the construction of complex objects like `Aventurer` and `Monster`. This pattern provides a clear and readable API for setting an object's attributes (e.g., `.life(100).speed(25).build()`), avoiding constructors with long parameter lists.

2.  **Factory Pattern**: Encapsulates the object creation logic.
    -   `AventurerFactory`: Simplifies the creation of the player's character based on their race selection.
    -   `FactoryMonstre`: Handles the instantiation of random monsters for combat encounters, abstracting away the details of their statistical generation.

3.  **Singleton Pattern**: Applied to the Builder classes (`AventurerBuilder`, `ObjectBuilder`) to ensure a single, globally accessible instance is used for constructing objects, optimizing resource usage.

4.  **Interfaces for Behavior (Strategy-like)**:
    -   `Ideal_damage`: Defines a contract for any character that can deal damage, ensuring polymorphic behavior in the combat system.
    -   `IseReposer`: A specific interface implemented only by `Aventurer`, segregating abilities that are exclusive to the player.

## How to Play

Once the application is running, you will be guided by on-screen prompts:

1.  First, you'll be asked to **choose a race** for your adventurer.
2.  You will then be presented with the **main menu**, where you can:
    -   View your character's stats.
    -   Initiate combat with a random monster.
    -   Manage your inventory by equipping items or drinking potions.
    -   Rest to recover health.
    -   Quit the game.
3.  Combat is turn-based. On your turn, you can choose to attack, use a potion, or attempt to flee.

## Installation

### Prerequisites

-   Java Development Kit (JDK) 8 or higher.

### Manual Installation with Gradle Wrapper

To install and run the project, you can use the provided Gradle Wrapper (`gradlew`).

1.  **Clone the repository:**
    ```bash
    git clone <repository-url>
    cd JavaGradle
    ```

2.  **Run the application using the Gradle Wrapper:**
    The `gradlew` script will automatically download the correct Gradle version.

    For Windows:
    ```bash
    gradlew.bat run
    ```

    For macOS/Linux:
    ```bash
    ./gradlew run
    ```
3. **Here are the manual installation steps :**
    If the other steps didn't work, just create gradlew and put this code in, it should work
```
#!/bin/sh

#
# Copyright © 2015 the original authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
# SPDX-License-Identifier: Apache-2.0
#

##############################################################################
#
#   Gradle start up script for POSIX generated by Gradle.
#
#   Important for running:
#
#   (1) You need a POSIX-compliant shell to run this script. If your /bin/sh is
#       noncompliant, but you have some other compliant shell such as ksh or
#       bash, then to run this script, type that shell name before the whole
#       command line, like:
#
#           ksh Gradle
#
#       Busybox and similar reduced shells will NOT work, because this script
#       requires all of these POSIX shell features:
#         * functions;
#         * expansions «$var», «${var}», «${var:-default}», «${var+SET}»,
#           «${var#prefix}», «${var%suffix}», and «$( cmd )»;
#         * compound commands having a testable exit status, especially «case»;
#         * various built-in commands including «command», «set», and «ulimit».
#
#   Important for patching:
#
#   (2) This script targets any POSIX shell, so it avoids extensions provided
#       by Bash, Ksh, etc; in particular arrays are avoided.
#
#       The "traditional" practice of packing multiple parameters into a
#       space-separated string is a well documented source of bugs and security
#       problems, so this is (mostly) avoided, by progressively accumulating
#       options in "$@", and eventually passing that to Java.
#
#       Where the inherited environment variables (DEFAULT_JVM_OPTS, JAVA_OPTS,
#       and GRADLE_OPTS) rely on word-splitting, this is performed explicitly;
#       see the in-line comments for details.
#
#       There are tweaks for specific operating systems such as AIX, CygWin,
#       Darwin, MinGW, and NonStop.
#
#   (3) This script is generated from the Groovy template
#       https://github.com/gradle/gradle/blob/HEAD/platforms/jvm/plugins-application/src/main/resources/org/gradle/api/internal/plugins/unixStartScript.txt
#       within the Gradle project.
#
#       You can find Gradle at https://github.com/gradle/gradle/.
#
##############################################################################

# Attempt to set APP_HOME

# Resolve links: $0 may be a link
app_path=$0

# Need this for daisy-chained symlinks.
while
    APP_HOME=${app_path%"${app_path##*/}"}  # leaves a trailing /; empty if no leading path
    [ -h "$app_path" ]
do
    ls=$( ls -ld "$app_path" )
    link=${ls#*' -> '}
    case $link in             #(
      /*)   app_path=$link ;; #(
      *)    app_path=$APP_HOME$link ;;
    esac
done

# This is normally unused
# shellcheck disable=SC2034
APP_BASE_NAME=${0##*/}
# Discard cd standard output in case $CDPATH is set (https://github.com/gradle/gradle/issues/25036)
APP_HOME=$( cd -P "${APP_HOME:-./}" > /dev/null && printf '%s\n' "$PWD" ) || exit

# Use the maximum available, or set MAX_FD != -1 to use that value.
MAX_FD=maximum

warn () {
    echo "$*"
} >&2

die () {
    echo
    echo "$*"
    echo
    exit 1
} >&2

# OS specific support (must be 'true' or 'false').
cygwin=false
msys=false
darwin=false
nonstop=false
case "$( uname )" in                #(
  CYGWIN* )         cygwin=true  ;; #(
  Darwin* )         darwin=true  ;; #(
  MSYS* | MINGW* )  msys=true    ;; #(
  NONSTOP* )        nonstop=true ;;
esac

CLASSPATH="\\\"\\\""


# Determine the Java command to use to start the JVM.
if [ -n "$JAVA_HOME" ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
        # IBM's JDK on AIX uses strange locations for the executables
        JAVACMD=$JAVA_HOME/jre/sh/java
    else
        JAVACMD=$JAVA_HOME/bin/java
    fi
    if [ ! -x "$JAVACMD" ] ; then
        die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
    fi
else
    JAVACMD=java
    if ! command -v java >/dev/null 2>&1
    then
        die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
    fi
fi

# Increase the maximum file descriptors if we can.
if ! "$cygwin" && ! "$darwin" && ! "$nonstop" ; then
    case $MAX_FD in #(
      max*)
        # In POSIX sh, ulimit -H is undefined. That's why the result is checked to see if it worked.
        # shellcheck disable=SC2039,SC3045
        MAX_FD=$( ulimit -H -n ) ||
            warn "Could not query maximum file descriptor limit"
    esac
    case $MAX_FD in  #(
      '' | soft) :;; #(
      *)
        # In POSIX sh, ulimit -n is undefined. That's why the result is checked to see if it worked.
        # shellcheck disable=SC2039,SC3045
        ulimit -n "$MAX_FD" ||
            warn "Could not set maximum file descriptor limit to $MAX_FD"
    esac
fi

# Collect all arguments for the java command, stacking in reverse order:
#   * args from the command line
#   * the main class name
#   * -classpath
#   * -D...appname settings
#   * --module-path (only if needed)
#   * DEFAULT_JVM_OPTS, JAVA_OPTS, and GRADLE_OPTS environment variables.

# For Cygwin or MSYS, switch paths to Windows format before running java
if "$cygwin" || "$msys" ; then
    APP_HOME=$( cygpath --path --mixed "$APP_HOME" )
    CLASSPATH=$( cygpath --path --mixed "$CLASSPATH" )

    JAVACMD=$( cygpath --unix "$JAVACMD" )

    # Now convert the arguments - kludge to limit ourselves to /bin/sh
    for arg do
        if
            case $arg in                                #(
              -*)   false ;;                            # don't mess with options #(
              /?*)  t=${arg#/} t=/${t%%/*}              # looks like a POSIX filepath
                    [ -e "$t" ] ;;                      #(
              *)    false ;;
            esac
        then
            arg=$( cygpath --path --ignore --mixed "$arg" )
        fi
        # Roll the args list around exactly as many times as the number of
        # args, so each arg winds up back in the position where it started, but
        # possibly modified.
        #
        # NB: a `for` loop captures its iteration list before it begins, so
        # changing the positional parameters here affects neither the number of
        # iterations, nor the values presented in `arg`.
        shift                   # remove old arg
        set -- "$@" "$arg"      # push replacement arg
    done
fi


# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS='"-Xmx64m" "-Xms64m"'

# Collect all arguments for the java command:
#   * DEFAULT_JVM_OPTS, JAVA_OPTS, and optsEnvironmentVar are not allowed to contain shell fragments,
#     and any embedded shellness will be escaped.
#   * For example: A user cannot expect ${Hostname} to be expanded, as it is an environment variable and will be
#     treated as '${Hostname}' itself on the command line.

set -- \
        "-Dorg.gradle.appname=$APP_BASE_NAME" \
        -classpath "$CLASSPATH" \
        -jar "$APP_HOME/gradle/wrapper/gradle-wrapper.jar" \
        "$@"

# Stop when "xargs" is not available.
if ! command -v xargs >/dev/null 2>&1
then
    die "xargs is not available"
fi

# Use "xargs" to parse quoted args.
#
# With -n1 it outputs one arg per line, with the quotes and backslashes removed.
#
# In Bash we could simply go:
#
#   readarray ARGS < <( xargs -n1 <<<"$var" ) &&
#   set -- "${ARGS[@]}" "$@"
#
# but POSIX shell has neither arrays nor command substitution, so instead we
# post-process each arg (as a line of input to sed) to backslash-escape any
# character that might be a shell metacharacter, then use eval to reverse
# that process (while maintaining the separation between arguments), and wrap
# the whole thing up as a single "set" statement.
#
# This will of course break if any of these variables contains a newline or
# an unmatched quote.
#

eval "set -- $(
        printf '%s\n' "$DEFAULT_JVM_OPTS $JAVA_OPTS $GRADLE_OPTS" |
        xargs -n1 |
        sed ' s~[^-[:alnum:]+,./:=@_]~\\&~g; ' |
        tr '\n' ' '
    )" '"$@"'

exec "$JAVACMD" "$@"
```

## Usage

To run the application:

```bash
# On Windows
./gradlew.bat run

# On macOS/Linux
./gradlew run
```

## Building

To build the project and create an executable JAR file:

```bash
# On Windows
./gradlew.bat build

# On macOS/Linux
./gradlew build
```

The distributable files, including the JAR, will be located in the `app/build/distributions` directory.