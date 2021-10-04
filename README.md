# Selenium Tests

___

<p>This repository contains [Selenium](https://www.selenium.dev) tests for the [SauceDemo App](https://www.saucedemo.com/).</p>
<p>In order to utilise this project you need to have the following installed locally:</p>
<ol>
<li>Maven 3.8.2</li>
<li>Chrome</li>
<li>Java 11.0.12</li>
</ol>


## Dependencies

___


<p>To see all available dependencies ready to update run the command:</p>

`mvn versions:display-dependency-updates`

<p>To update the dependencies run the command:</p>

`mvn versions:use-latest-versions`

## Running Tests

___

<p>The project is broken into separate modules for Smoke and Regression testing.<br>
Each of these modules can be utilised independently of the others using maven<br>
profiles.</p>

<p>To run <strong>all</strong> modules run:</p>

`mvn clean test`

<p>To run <strong>Smoke Tests</strong> the following command should be used:</p>

`mvn clean test -DsuiteXmlFile=src/test/resources/SmokeTest.xml`

<p>To run <strong>Regression Tests</strong> the following command should be used:</p>

`mvn clean test -DsuiteXmlFile=src/test/resources/RegressionTest.xml`

<p>To run necessary test classes the following command should be used:</p>

`mvn clean test -Dtest=TestName`

<p>To run necessary test methods the following command should be used:</p>

`mvn -Dtest=TestName#MethodName`