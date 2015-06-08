# Material Design theme for Vaadin 7

Material Design theme add-on for Vaadin 7.

## Download release

Official releases of this add-on are available at Vaadin Directory. For Maven instructions, download and reviews, go to 
http://vaadin.com/addon/material-design

## Building and running demo

    git clone https://github.com/marlonrichert/vaadin-material-design
    mvn clean install
    cd material-design-demo
    mvn jetty:run

To see the demo, navigate to http://localhost:8080/

## Contributions

Contributions are welcome, but there are no guarantees that they are accepted as such. Process for contributing is the 
following:

- Fork this project
- Create an issue to this project about the contribution (bug or feature) if there is no such issue about it already. 
  Try to keep the scope minimal.
- Develop and test the fix or functionality carefully. Only include minimum amount of code needed to fix the issue.
- Refer to the fixed issue in commit.
- Send a pull request for the original project.
- Comment on the original issue that you have implemented a fix for it.

## License & Author

Add-on is distributed under Apache License 2.0. For license terms, see LICENSE.txt.

Material Design theme for Vaadin 7 is written by Marlon Richert.

# Developer Guide

## Getting started

To get started quickly, copy-paste the content of md-light/styles.scss or md-dark/styles.scss to your own styles.scss 
and modify the variables.

For more options, you can copy and override additional variables from material-design/_material-design.scss
