# Accuweather

1. The framework is a Webdriver,TestNG,Restassured,extent reports and java based test automation framework. 
2. It provides option to the user to automate ui components and API components under same repo.
3. Easily configurable using config.properties.


## Start Automating
1. Clone the code on local and start automating

```git
git clone https://github.com/ravitester2021/accuweather.git
```

## Usage
1. Chrome driver and Firefox driver supported for windows OS.
2. Safari driver supported for Mac OS.
3. This code works with windows and mac OS.
4. Based on need, you can add your favourite browser using WebDriverManager in base class.


## Run the code

1. Run the testng.xml with required test cases.
2. In case the user want to run only tests.

```cmd
mvn clean test
```


## Configure the Framework
To configure the framework, please refer - config.properties


## Update test data
1. Goto config.properties and change "ui_location" to desired city.
2. Run GetWeatherDetailAndCompare.java OR testng.xml as suite.


## Reporting and Logs
1. Extent report is used for reporting.
2. Logs will added in reports. 
3. Run testng.xml and you can findout logs in "Accuweather\test-output\ExtentReportWithLogs.html"
4. Logs can be added using "reportLog("======	Your LOG INFO	======") after extending UI_Base class;"

