Feature: Check local file description of vehicle matches information online
  As a user
  I want to check that the description of a vehicle stored on a local text file matches the description online
  So that I can confirm the validity of the information in the file

  Scenario Outline: Registrations from file searched for online and results compared against local information
    Given i want to search for registrations from "<inputFile>"
    And UK vehicle registrations exist in file
    When the file is read
    And all empty lines are removed
    And registrations are extracted
    And searched for at "https://cartaxcheck.co.uk/"
    Then the information is compared against the stored records in "<outputFile>"
    And the accuracy of the information is confirmed

    Examples:
      | inputFile | outputFile |
      | car_input.txt | car_output.txt |
#      | car_input2.txt | car_output.txt |