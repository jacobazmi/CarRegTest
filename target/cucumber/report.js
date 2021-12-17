$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/CheckCarDetails.feature");
formatter.feature({
  "name": "Check local file description of vehicle matches information online",
  "description": "  As a user\n  I want to check that the description of a vehicle stored on a local text file matches the description online\n  So that I can confirm the validity of the information in the file",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "vehicle registrations extracted from file and information compared against online description",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "i want to search for registrations from \"\u003cinputFile\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "UK vehicle registrations exist in file",
  "keyword": "And "
});
formatter.step({
  "name": "the file is read",
  "keyword": "When "
});
formatter.step({
  "name": "all empty lines are removed",
  "keyword": "And "
});
formatter.step({
  "name": "registrations are extracted",
  "keyword": "And "
});
formatter.step({
  "name": "searched for at \"https://cartaxcheck.co.uk/\"",
  "keyword": "And "
});
formatter.step({
  "name": "the information is compared against the stored records in \"\u003coutputFile\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "the accuracy of the information is confirmed",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "inputFile",
        "outputFile"
      ]
    },
    {
      "cells": [
        "car_input.txt",
        "car_output.txt"
      ]
    },
    {
      "cells": [
        "car_input2.txt",
        "car_output.txt"
      ]
    }
  ]
});
formatter.scenario({
  "name": "vehicle registrations extracted from file and information compared against online description",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "i want to search for registrations from \"car_input.txt\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.azmi.jacob.e2e.test.CheckCarDetailsStepdefs.iWantToSearchForRegistrationsFrom(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "UK vehicle registrations exist in file",
  "keyword": "And "
});
formatter.match({
  "location": "com.azmi.jacob.e2e.test.CheckCarDetailsStepdefs.ukVehicleRegistrationsExistInFile()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the file is read",
  "keyword": "When "
});
formatter.match({
  "location": "com.azmi.jacob.e2e.test.CheckCarDetailsStepdefs.theFileIsRead()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "all empty lines are removed",
  "keyword": "And "
});
formatter.match({
  "location": "com.azmi.jacob.e2e.test.CheckCarDetailsStepdefs.allEmptyLinesAreRemoved()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "registrations are extracted",
  "keyword": "And "
});
formatter.match({
  "location": "com.azmi.jacob.e2e.test.CheckCarDetailsStepdefs.registrationsAreExtracted()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "searched for at \"https://cartaxcheck.co.uk/\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.azmi.jacob.e2e.test.CheckCarDetailsStepdefs.searchedForAt(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the information is compared against the stored records in \"car_output.txt\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.azmi.jacob.e2e.test.CheckCarDetailsStepdefs.theInformationIsComparedAgainstTheStoredRecordsIn(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the accuracy of the information is confirmed",
  "keyword": "And "
});
formatter.match({
  "location": "com.azmi.jacob.e2e.test.CheckCarDetailsStepdefs.theAccuracyOfTheInformationIsConfirmed()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Some stored records do not match online records\r\n\tat org.junit.Assert.fail(Assert.java:89)\r\n\tat org.junit.Assert.assertTrue(Assert.java:42)\r\n\tat org.junit.Assert.assertFalse(Assert.java:65)\r\n\tat com.azmi.jacob.e2e.test.CheckCarDetailsStepdefs.theAccuracyOfTheInformationIsConfirmed(CheckCarDetailsStepdefs.java:187)\r\n\tat ✽.the accuracy of the information is confirmed(file:///C:/Users/Jacob/IdeaProjects/E2ECarRegTest/src/test/resources/features/CheckCarDetails.feature:14)\r\n",
  "status": "failed"
});
formatter.scenario({
  "name": "vehicle registrations extracted from file and information compared against online description",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "i want to search for registrations from \"car_input2.txt\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.azmi.jacob.e2e.test.CheckCarDetailsStepdefs.iWantToSearchForRegistrationsFrom(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "UK vehicle registrations exist in file",
  "keyword": "And "
});
formatter.match({
  "location": "com.azmi.jacob.e2e.test.CheckCarDetailsStepdefs.ukVehicleRegistrationsExistInFile()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the file is read",
  "keyword": "When "
});
formatter.match({
  "location": "com.azmi.jacob.e2e.test.CheckCarDetailsStepdefs.theFileIsRead()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "all empty lines are removed",
  "keyword": "And "
});
formatter.match({
  "location": "com.azmi.jacob.e2e.test.CheckCarDetailsStepdefs.allEmptyLinesAreRemoved()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "registrations are extracted",
  "keyword": "And "
});
formatter.match({
  "location": "com.azmi.jacob.e2e.test.CheckCarDetailsStepdefs.registrationsAreExtracted()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "searched for at \"https://cartaxcheck.co.uk/\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.azmi.jacob.e2e.test.CheckCarDetailsStepdefs.searchedForAt(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the information is compared against the stored records in \"car_output.txt\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.azmi.jacob.e2e.test.CheckCarDetailsStepdefs.theInformationIsComparedAgainstTheStoredRecordsIn(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the accuracy of the information is confirmed",
  "keyword": "And "
});
formatter.match({
  "location": "com.azmi.jacob.e2e.test.CheckCarDetailsStepdefs.theAccuracyOfTheInformationIsConfirmed()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Some stored records do not match online records\r\n\tat org.junit.Assert.fail(Assert.java:89)\r\n\tat org.junit.Assert.assertTrue(Assert.java:42)\r\n\tat org.junit.Assert.assertFalse(Assert.java:65)\r\n\tat com.azmi.jacob.e2e.test.CheckCarDetailsStepdefs.theAccuracyOfTheInformationIsConfirmed(CheckCarDetailsStepdefs.java:187)\r\n\tat ✽.the accuracy of the information is confirmed(file:///C:/Users/Jacob/IdeaProjects/E2ECarRegTest/src/test/resources/features/CheckCarDetails.feature:14)\r\n",
  "status": "failed"
});
});