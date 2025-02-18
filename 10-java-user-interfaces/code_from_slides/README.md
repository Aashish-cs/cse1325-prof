# User Interface Options

This code presents several options for providing a user interface to a program
such as your semester project.

## oop

The OOP option provides a ``menu`` package for creating menu-driven interfaces
(mdi) within the terminal.

Each menu item is represented by a ``MenuItem`` object that encapsulates both the menu item's text and the method to be called when it is selected. 

The ``Menu`` class aggregates and manages many ``MenuItem`` objects, for example,
formatting the menu and facilitating selection of a menu item.

This is the approach required for this course.

HINT: Use ``ant javadoc`` to build complete reference documentation for the ``menu``
package. You'll find it under docs/api/index.html.

## c-like

This is the mdi approach likely taught in your C class, with a hard-coded menu
and a switch to convert the user's input into the requested behavior.

## Alternates

These 5 approaches constrast user interface options for building a simple
file checksum application.

### with_menu

This is a classic mdi version, with a hard-coded menu and an if/else structure
to select the behavior based on the user's selection.

### attomenu

This uses the open-source attomenu package for the application.
Attomenu adds additional options, such as arbitrary letter selectors rather than 
only sequential numbers, automated help, and a built-in main loop just as you
would find in a windowing toolkit.

### with_cli

This is a hard-coded command-line interface (cli) example similar to how
it might be written in C.

### with_picocli

This is a cli example using the open-source picocli package, which provides
a powerful toolkit for creating cli applications.

### with_Swing

This demonstrates how to create the checksum application with a graphical user
interface based on the Swing library, which is included by default with the
Java Developer Kit (OpenJDK).

